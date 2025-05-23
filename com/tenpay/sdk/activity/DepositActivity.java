package com.tenpay.sdk.activity;

import android.animation.ObjectAnimator;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelStoreOwner;
import com.heytap.databaseengine.type.DeviceType;
import com.huawei.hms.adapter.internal.CommonCode;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.transfile.api.impl.TransFileControllerImpl;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.qqlive.tvkplayer.vinfo.live.TVKLiveRequestBuilder;
import com.tencent.soter.core.model.SoterSignatureResult;
import com.tencent.soter.wrapper.SoterWrapperApi;
import com.tencent.soter.wrapper.wrap_biometric.SoterBiometricCanceller;
import com.tencent.soter.wrapper.wrap_callback.SoterProcessAuthenticationResult;
import com.tencent.soter.wrapper.wrap_callback.SoterProcessCallback;
import com.tencent.soter.wrapper.wrap_task.AuthenticationParam;
import com.tencent.thread.monitor.plugin.proxy.BaseTimer;
import com.tencent.thumbplayer.core.downloadproxy.api.TPDownloadProxyEnum;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tenpay.ErrorCode;
import com.tenpay.QwLog;
import com.tenpay.api.BankImageUtil;
import com.tenpay.api.MyKeyboardWindow;
import com.tenpay.api.QFuncProxy;
import com.tenpay.api.QWalletUtils;
import com.tenpay.compat.SoterBiometricStateCallbackCompat;
import com.tenpay.impl.ApiFingerImpl;
import com.tenpay.proxy.QQProxyDialog;
import com.tenpay.proxy.QUIProxy;
import com.tenpay.sdk.Cgi;
import com.tenpay.sdk.QWalletFakeUrl;
import com.tenpay.sdk.activity.DepositActivity;
import com.tenpay.sdk.fakeurl.QWalletFakeUrlHandler;
import com.tenpay.sdk.helper.SharedHelper;
import com.tenpay.sdk.net.NetUtil;
import com.tenpay.sdk.util.QWSoterConstans;
import com.tenpay.sdk.view.OnPasswdInputListener;
import com.tenpay.sdk.view.SixPasswdDialogEditText;
import com.tenpay.util.MD5;
import com.tenpay.util.Utils;
import cooperation.qwallet.plugin.FakeUrl;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes27.dex */
public class DepositActivity extends NetBaseActivity implements View.OnClickListener {
    public static int CHANGEPHONENUM_RESULT_CODE = 2003;
    public static int DEPOSIT_BANK_RESULT_CODE = 3002;
    public static int DEPOSIT_BIND_RESULT_CODE = 3003;
    protected static final int ONE_MINUTE = 59;
    protected static final int PAY_BANK_DEFAULT_INDEX = 0;
    private static String RET_CODE_CHARGE_AUTHEN_ERROR_152702158 = "152702158";
    public static final int WINDOW_STYLE_FINGERPAY = 1;
    public static final int WINDOW_STYLE_PASSPAY = 0;
    protected static int mLeftTime = 59;
    private ImageView back_btn;
    protected Button confirmPayBtn;
    private boolean isNeedRestartFingerPay;
    private boolean isShowingVerifyCodeView;
    private RelativeLayout mAnimLayout;
    private String mBankArrayStr;
    private float mBankCount;
    protected JSONObject mBindedFastObj;
    protected ImageView mChangePayBankIcon_finger;
    protected ImageView mChangePayBankIcon_pass;
    private TextView mChangePayBankTail_finger;
    private TextView mChangePayBankTail_pass;
    protected TextView mChangePayBankTxt_finger;
    protected TextView mChangePayBankTxt_pass;
    protected LinearLayout mChangePayTypeBtn_finger;
    protected LinearLayout mChangePayTypeBtn_pass;
    private Boolean mChangePhoneNum;
    protected Button mChangePhoneNumBtn;
    protected ImageButton mCloseBtn;
    protected String mDepositCount;
    private QQProxyDialog mDetectDialog;
    private SoterSignatureResult mFingerAuthenResult;
    protected TextView mFingerErrorTips;
    private boolean mFingerStatus;
    protected Boolean mIsCreditCard;
    protected Boolean mIsReentry;
    protected boolean mIsSixPasswdUser;
    protected MyKeyboardWindow mKeyboard;
    private String mNewPhoneNum;
    protected EditText mNormalPasswdEdit;
    private LinearLayout mOtherPayView;
    private int mPassAnimDuration;
    private LinearLayout mPassView;
    protected LinearLayout mPayAuthLayout;
    protected Button mPayConfirmBtn;
    private TextView mPayErrorTxt;
    private LinearLayout mPayHeadLayout;
    protected TextView mPriceTxt;
    protected TextView mProductTxt;
    protected RelativeLayout mRootView;
    protected JSONObject mSelectBankObj;
    protected int mSelectedPayBankIndex;
    private Boolean mShowPhoneChangeBtn;
    protected SixPasswdDialogEditText mSixPasswdEdit;
    private SoterBiometricCanceller mSoterBiometricCanceller;
    private List<String> mSoterOpenFid;
    protected TextWatcher mTextWatcher;
    protected Timer mTimer;
    protected TextView mTitleRightTxt;
    protected TextView mTitleTxt;
    private int mTouchidRetryCount;
    protected EditText mVerifyCodeEdit;
    protected MyKeyboardWindow mVerifyKeyboard;
    protected TextView mVerifyMobileTxt;
    protected Button mVerifyResendBtn;
    protected LinearLayout mVerifyView;
    protected int mWindowStyle;
    protected LinearLayout mWx2QQLayoutFinger;
    protected LinearLayout mWx2QQLayoutPassword;
    protected String mWx2QQUrl;
    private LinearLayout normal_passwd_layout;
    private RelativeLayout price_layout;
    private boolean mHasVerify = false;
    private boolean mForgetPwd = false;
    private boolean mForgetPwdBind = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tenpay.sdk.activity.DepositActivity$3, reason: invalid class name */
    /* loaded from: classes27.dex */
    public class AnonymousClass3 extends TimerTask {
        AnonymousClass3() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$run$0() {
            DepositActivity.mLeftTime--;
            String string = DepositActivity.this.getString(R.string.ede);
            if (DepositActivity.mLeftTime > 0) {
                string = string + "(" + DepositActivity.mLeftTime + ")";
                DepositActivity.this.mVerifyResendBtn.setClickable(false);
                DepositActivity.this.mVerifyResendBtn.setEnabled(false);
            } else {
                DepositActivity.this.mVerifyResendBtn.setClickable(true);
                DepositActivity.this.mVerifyResendBtn.setEnabled(true);
                DepositActivity.this.mTimer.cancel();
                DepositActivity.mLeftTime = 59;
            }
            DepositActivity.this.mVerifyResendBtn.setText(string);
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            Handler handler = DepositActivity.this.mHandler;
            if (handler != null) {
                handler.post(new Runnable() { // from class: com.tenpay.sdk.activity.as
                    @Override // java.lang.Runnable
                    public final void run() {
                        DepositActivity.AnonymousClass3.this.lambda$run$0();
                    }
                });
            }
        }
    }

    public DepositActivity() {
        Boolean bool = Boolean.FALSE;
        this.mChangePhoneNum = bool;
        this.mShowPhoneChangeBtn = bool;
        this.mSelectedPayBankIndex = 0;
        this.mIsReentry = bool;
        this.mIsCreditCard = Boolean.TRUE;
        this.mTouchidRetryCount = 0;
        this.mPassAnimDuration = 300;
        this.mBankCount = 0.0f;
        this.mTextWatcher = new TextWatcher() { // from class: com.tenpay.sdk.activity.DepositActivity.1
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                DepositActivity depositActivity = DepositActivity.this;
                if (depositActivity.mWindowStyle == 0 && !depositActivity.isShowingVerifyCodeView) {
                    if (DepositActivity.this.getPasswd().length() > 5) {
                        if (!DepositActivity.this.mPayConfirmBtn.isEnabled()) {
                            DepositActivity.this.mPayConfirmBtn.setEnabled(true);
                            DepositActivity.this.mPayConfirmBtn.setClickable(true);
                            return;
                        }
                        return;
                    }
                    if (DepositActivity.this.mPayConfirmBtn.isEnabled()) {
                        DepositActivity.this.mPayConfirmBtn.setClickable(false);
                        DepositActivity.this.mPayConfirmBtn.setEnabled(false);
                        return;
                    }
                    return;
                }
                if (DepositActivity.this.isShowingVerifyCodeView && DepositActivity.this.mVerifyCodeEdit.getText().toString().length() > 5) {
                    DepositActivity.this.getWindow().setSoftInputMode(3);
                    DepositActivity.this.deposit_verify();
                }
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
            }
        };
        this.mDetectDialog = null;
    }

    private void back() {
        if (this.isShowingVerifyCodeView) {
            goneVerfyView();
            if (this.mWindowStyle == 1) {
                showFingerPayView();
            } else {
                showPassPayView();
            }
            this.isShowingVerifyCodeView = false;
            return;
        }
        if (this.mWindowStyle == 1) {
            com.tencent.mobileqq.qwallet.c.c("fingerprint.confirm.cancel", Integer.valueOf(getProcessType()));
            releaseFp();
        }
        if (!this.mPassFlag.equals("2")) {
            QWalletUtils.hideSysKeyBorad(this.mNormalPasswdEdit);
        }
        finish();
    }

    private void checkFP() {
        if (SharedHelper.soterOpen(this.mUin)) {
            this.mSoterOpenFid = Arrays.asList(SharedHelper.fingersLocal(this.mUin));
            QwLog.i("mSoterOpenFid : " + this.mSoterOpenFid);
        }
    }

    private void clearPass() {
        if (this.mIsSixPasswdUser) {
            this.mSixPasswdEdit.setInputText("");
            this.mSixPasswdEdit.requestFocus();
            this.mPayConfirmBtn.setClickable(false);
            this.mPayConfirmBtn.setEnabled(false);
            return;
        }
        this.mNormalPasswdEdit.setText("");
        this.mNormalPasswdEdit.requestFocus();
        Utils.touchEditText(this.mHandler, this.mNormalPasswdEdit);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dismissDetectDialog() {
        try {
            releaseFp();
            QQProxyDialog qQProxyDialog = this.mDetectDialog;
            if (qQProxyDialog != null) {
                qQProxyDialog.dismiss();
                this.mDetectDialog = null;
            }
        } catch (Exception e16) {
            QLog.e(((NetBaseActivity) this).TAG, 1, "", e16);
        }
        View findViewById = getActivity().findViewById(R.id.root_layout);
        if (findViewById != null) {
            findViewById.setVisibility(0);
        }
    }

    private int getLoadingHeight() {
        if (this.isShowingVerifyCodeView) {
            return this.mVerifyView.getHeight();
        }
        if (this.mWindowStyle == 0) {
            return this.mPassView.getHeight();
        }
        return this.mOtherPayView.getHeight();
    }

    private void go2ChangePhoneNumActivity() {
        Intent intent = new Intent();
        intent.putExtra("processtype", 17);
        launchFragmentForResult(intent, ChangePhoneNumActivity.class, CHANGEPHONENUM_RESULT_CODE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void go2PWDAuth() {
        releaseFp();
        showPassPayView();
        com.tencent.mobileqq.qwallet.c.c("fingerprint.number-exceed-error.go", Integer.valueOf(getProcessType()));
    }

    private void goneVerfyView() {
        if (this.isShowingVerifyCodeView) {
            closeTime();
            this.mProductTxt.setVisibility(0);
            this.price_layout.setVisibility(0);
            this.back_btn.setVisibility(8);
            this.mVerifyView.setVisibility(4);
            this.isShowingVerifyCodeView = false;
        }
    }

    private void gotoChangePayType() {
        Intent intent = new Intent();
        intent.putExtra("FromDepositActivity", true);
        intent.putExtra("setBackgroundGray", false);
        if (this.mWindowStyle == 1) {
            intent.putExtra("isFingerPayDeposit", true);
        }
        intent.putExtra("pass_flag", Integer.valueOf(this.mPassFlag));
        intent.putExtra("banks_info", this.mBankArrayStr);
        intent.putExtra("bank_index", this.mSelectedPayBankIndex);
        intent.putExtra(DepositStartActivity.DESPOSIT_COUNT, this.mDepositCount);
        launchFragmentForResult(intent, ChooseWithdrawBankActivity.class, DEPOSIT_BANK_RESULT_CODE);
        getActivity().overridePendingTransition(R.anim.f154877er, 0);
        if (this.mBankCount > 4.0f) {
            this.mBankCount = 4.5f;
        }
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.mAnimLayout, "translationY", r0.getHeight());
        ofFloat.setDuration(300L);
        ofFloat.start();
        int i3 = this.mWindowStyle;
        if (i3 == 0) {
            this.mPassView.setVisibility(4);
        } else if (i3 == 1) {
            this.mOtherPayView.setVisibility(4);
        }
        this.mPayHeadLayout.setVisibility(4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initView$0() {
        if (this.mSixPasswdEdit.getInputText().length() > 5) {
            depositAuthen();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initView$1() {
        this.mKeyboard.setVisibility(0);
        this.mKeyboard.setInputEditText(this.mSixPasswdEdit);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initView$2(View view, boolean z16) {
        Handler handler;
        if (this.mSixPasswdEdit.isFocused() && (handler = this.mHandler) != null) {
            handler.post(new Runnable() { // from class: com.tenpay.sdk.activity.an
                @Override // java.lang.Runnable
                public final void run() {
                    DepositActivity.this.lambda$initView$1();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$initView$3(TextView textView, int i3, KeyEvent keyEvent) {
        if (keyEvent != null && keyEvent.getKeyCode() == 66) {
            if (getPasswd().length() > 5) {
                depositAuthen();
            }
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$initView$4(TextView textView, int i3, KeyEvent keyEvent) {
        if (keyEvent == null || keyEvent.getKeyCode() != 66) {
            return false;
        }
        if (this.mVerifyCodeEdit.getText().toString().length() > 5) {
            getWindow().setSoftInputMode(3);
            deposit_verify();
            if (this.mWindowStyle == 0) {
                com.tencent.mobileqq.qwallet.c.c("smallpay.sms.go", Integer.valueOf(getProcessType()));
            }
        } else {
            QQToast.makeText(getContext(), R.string.efz, 0).show();
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$playFingerErrorAnim$11() {
        this.mFingerErrorTips.setText(R.string.e6i);
        this.mFingerErrorTips.setTextColor(Color.parseColor("#E8A741"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$playPassWordErrorAnim$10() {
        int i3;
        if (this.mPayErrorTxt.getLineCount() > 1) {
            i3 = 20000;
        } else {
            i3 = 1000;
        }
        this.mPayErrorTxt.startAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.f154873en));
        this.mHandler.postDelayed(new Runnable() { // from class: com.tenpay.sdk.activity.aq
            @Override // java.lang.Runnable
            public final void run() {
                DepositActivity.this.lambda$playPassWordErrorAnim$9();
            }
        }, i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$playPassWordErrorAnim$9() {
        this.mSixPasswdEdit.clearErrorColor();
        clearPass();
        this.mPayErrorTxt.setText(getString(R.string.eal));
        this.mPayErrorTxt.setTextColor(AppCompatResources.getColorStateList(getContext(), R.color.c_t));
        this.mPayErrorTxt.setClickable(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showFingerPayView$5() {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.mAnimLayout, "translationY", -(this.mOtherPayView.getHeight() + this.mPayHeadLayout.getHeight()));
        ofFloat.setDuration(300L);
        ofFloat.setInterpolator(new AccelerateDecelerateInterpolator());
        ofFloat.start();
        this.mHandler.postDelayed(new Runnable() { // from class: com.tenpay.sdk.activity.DepositActivity.2
            @Override // java.lang.Runnable
            public void run() {
                DepositActivity.this.mOtherPayView.setVisibility(0);
            }
        }, 300L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showPassPayView$6() {
        this.mPassView.setVisibility(0);
        this.mOtherPayView.setVisibility(4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showPassPayView$7() {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.mAnimLayout, "translationY", -(this.mPassView.getHeight() + this.mPayHeadLayout.getHeight()));
        ofFloat.setDuration(this.mPassAnimDuration);
        ofFloat.setInterpolator(new AccelerateDecelerateInterpolator());
        ofFloat.start();
        this.mHandler.postDelayed(new Runnable() { // from class: com.tenpay.sdk.activity.ag
            @Override // java.lang.Runnable
            public final void run() {
                DepositActivity.this.lambda$showPassPayView$6();
            }
        }, this.mPassAnimDuration);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showVeryfyCodeView$8() {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.mAnimLayout, "translationY", -(this.mVerifyView.getHeight() + this.mPayHeadLayout.getHeight()));
        ofFloat.setDuration(250L);
        ofFloat.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onOpenFingerPayFinish(boolean z16) {
        QwLog.i("onOpenFingerPayFinish success=" + z16);
        dismissDetectDialog();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void playFingerErrorAnim(String str) {
        this.mFingerErrorTips.setText(str);
        this.mFingerErrorTips.setTextColor(getResources().getColor(R.color.f157595u6));
        this.mFingerErrorTips.startAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.f154873en));
        Handler handler = this.mHandler;
        if (handler != null) {
            handler.postDelayed(new Runnable() { // from class: com.tenpay.sdk.activity.ao
                @Override // java.lang.Runnable
                public final void run() {
                    DepositActivity.this.lambda$playFingerErrorAnim$11();
                }
            }, 700L);
        }
    }

    private void playPassWordErrorAnim(String str) {
        this.mSixPasswdEdit.setErrorColor(getResources().getColor(R.color.f157595u6));
        this.mPayErrorTxt.setText(str);
        this.mPayErrorTxt.setTextColor(getResources().getColor(R.color.f157595u6));
        this.mPayErrorTxt.setClickable(false);
        this.mPayErrorTxt.setVisibility(0);
        this.mPayErrorTxt.post(new Runnable() { // from class: com.tenpay.sdk.activity.ah
            @Override // java.lang.Runnable
            public final void run() {
                DepositActivity.this.lambda$playPassWordErrorAnim$10();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void releaseFp() {
        if (SoterWrapperApi.isSupportSoter() && this.mSoterBiometricCanceller != null) {
            QwLog.i("releaseFp...");
            this.mSoterBiometricCanceller.asyncCancelBiometricAuthentication();
            this.mSoterBiometricCanceller = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDetectDialogImg(int i3) {
        QQProxyDialog qQProxyDialog = this.mDetectDialog;
        if (qQProxyDialog != null && qQProxyDialog.isShowing() && i3 != 0) {
            ((ImageView) this.mDetectDialog.findViewById(R.id.image)).setImageResource(i3);
        }
    }

    private void setPayType(String str, String str2, String str3) {
        StringBuilder sb5 = new StringBuilder();
        if (!TextUtils.isEmpty(str3)) {
            sb5.append("(");
            sb5.append(str3);
            sb5.append(")");
        }
        if (!Utils.isEmpty(str)) {
            BankImageUtil.getInstance(getContext()).setBankImage(str, this.mChangePayBankIcon_pass);
            BankImageUtil.getInstance(getContext()).setBankImage(str, this.mChangePayBankIcon_finger);
        }
        this.mChangePayBankTxt_pass.setText(str2);
        this.mChangePayBankTxt_finger.setText(str2);
        this.mChangePayBankTail_pass.setText(sb5.toString());
        this.mChangePayBankTail_finger.setText(sb5.toString());
    }

    private void showFingerPayView() {
        this.mPassView.setVisibility(4);
        this.mCloseBtn.setVisibility(0);
        this.mPayHeadLayout.setVisibility(0);
        this.mAnimLayout.setVisibility(0);
        this.mTitleTxt.setText("\u652f\u4ed8");
        this.mTitleRightTxt.setText("\u5bc6\u7801\u652f\u4ed8");
        this.mTitleRightTxt.setVisibility(0);
        if (this.mSoterBiometricCanceller != null) {
            QwLog.i("last canceller is not null. should not happen because we will set it to null every time we finished the process");
        }
        SoterWrapperApi.isSupportSoter();
        this.confirmPayBtn.setVisibility(0);
        this.mOtherPayView.post(new Runnable() { // from class: com.tenpay.sdk.activity.ar
            @Override // java.lang.Runnable
            public final void run() {
                DepositActivity.this.lambda$showFingerPayView$5();
            }
        });
    }

    private void showPassPayView() {
        getWindow().addFlags(8192);
        this.mCloseBtn.setVisibility(0);
        this.mIsSixPasswdUser = "2".equals(this.mPassFlag);
        this.mWindowStyle = 0;
        this.mAnimLayout.setVisibility(0);
        this.mPayHeadLayout.setVisibility(0);
        this.mTitleTxt.setText("\u8f93\u5165\u652f\u4ed8\u5bc6\u7801");
        if (this.mFingerStatus) {
            this.mTitleRightTxt.setText(QWSoterConstans.getNameByBusiType(SharedHelper.getCurSoterBusiType(this.mUin)) + "\u652f\u4ed8");
            this.mTitleRightTxt.setVisibility(0);
        } else {
            this.mTitleRightTxt.setVisibility(8);
        }
        if (this.mIsSixPasswdUser) {
            this.mKeyboard.setVisibility(0);
            this.normal_passwd_layout.setVisibility(8);
            this.mSixPasswdEdit.setVisibility(0);
            this.mSixPasswdEdit.requestFocus();
        } else {
            this.mSixPasswdEdit.setVisibility(8);
            this.normal_passwd_layout.setVisibility(0);
            this.mKeyboard.setVisibility(8);
            if (this.mWindowStyle == 0) {
                this.mPayConfirmBtn.setVisibility(0);
            }
            this.normal_passwd_layout.setVisibility(0);
            if (this.mNormalPasswdEdit.getText().toString().length() > 5) {
                this.mPayConfirmBtn.setEnabled(true);
                this.mPayConfirmBtn.setClickable(true);
            } else {
                this.mPayConfirmBtn.setEnabled(false);
                this.mPayConfirmBtn.setClickable(false);
            }
            this.mNormalPasswdEdit.requestFocus();
            Utils.touchEditText(this.mHandler, this.mNormalPasswdEdit);
        }
        this.mPassView.post(new Runnable() { // from class: com.tenpay.sdk.activity.ai
            @Override // java.lang.Runnable
            public final void run() {
                DepositActivity.this.lambda$showPassPayView$7();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startFingerprintAuthentication() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("amount=");
        stringBuffer.append(this.mDepositCount);
        stringBuffer.append("&device_id=");
        stringBuffer.append(QFuncProxy.getDeviceId(getContext()));
        stringBuffer.append("&isroot=");
        stringBuffer.append(NetUtil.isPhoneRooted(getContext()) ? 1 : 0);
        stringBuffer.append("&timestamp=");
        stringBuffer.append((System.currentTimeMillis() / 1000) + this.mTimestamp);
        stringBuffer.append("&uin=");
        stringBuffer.append(this.mUin);
        String hexdigest = MD5.hexdigest(stringBuffer.toString());
        this.mSoterBiometricCanceller = new SoterBiometricCanceller();
        final int curSoterBusiType = SharedHelper.getCurSoterBusiType(this.mUin);
        SoterWrapperApi.requestAuthorizeAndSign(new SoterProcessCallback<SoterProcessAuthenticationResult>() { // from class: com.tenpay.sdk.activity.DepositActivity.5
            @Override // com.tencent.soter.wrapper.wrap_callback.SoterProcessCallback
            public void onResult(SoterProcessAuthenticationResult soterProcessAuthenticationResult) {
                QwLog.i("requestAuthorizeAndSign: " + soterProcessAuthenticationResult.toString());
                if (soterProcessAuthenticationResult.isSuccess()) {
                    DepositActivity.this.mFingerAuthenResult = soterProcessAuthenticationResult.getExtData();
                    String fid = DepositActivity.this.mFingerAuthenResult.getFid();
                    if (DepositActivity.this.mSoterOpenFid == null || !DepositActivity.this.mSoterOpenFid.contains(fid)) {
                        if (DepositActivity.this.mSoterOpenFid != null) {
                            QQToast.makeText(DepositActivity.this.getContext(), DepositActivity.this.getString(R.string.e9o), 1).show();
                            DepositActivity.this.go2PWDAuth();
                        }
                        DepositActivity.this.dismissQQPayLoading();
                        return;
                    }
                    DepositActivity.this.releaseFp();
                    DepositActivity.this.depositAuthen();
                    return;
                }
                int i3 = soterProcessAuthenticationResult.errCode;
                if (i3 == 1006 || i3 == 1005 || i3 == 3) {
                    DepositActivity.this.go2PWDAuth();
                    QQToast.makeText(DepositActivity.this.getContext(), String.format(DepositActivity.this.getString(R.string.e6b), QWSoterConstans.getNameByBusiType(curSoterBusiType), QWSoterConstans.getNameByBusiType(curSoterBusiType)), 1).show();
                    new ApiFingerImpl().closeFingerPay(DepositActivity.this.getContext(), DepositActivity.this.mUin);
                    return;
                }
                if (i3 == 1020) {
                    return;
                }
                if (i3 == 1017) {
                    DepositActivity.this.setDetectDialogImg(QWSoterConstans.getAuthFailResId(curSoterBusiType));
                    if (DepositActivity.this.mDetectDialog != null) {
                        int i16 = DepositActivity.this.mTouchidRetryCount;
                        DepositActivity depositActivity = DepositActivity.this;
                        if (i16 >= depositActivity.mTouchidRetryMaxCount) {
                            depositActivity.mDetectDialog.setMessage(DepositActivity.this.getString(R.string.iwr));
                            DepositActivity.this.mDetectDialog.setNegativeButton(R.string.e5h, new DialogInterface.OnClickListener() { // from class: com.tenpay.sdk.activity.DepositActivity.5.1
                                @Override // android.content.DialogInterface.OnClickListener
                                public void onClick(DialogInterface dialogInterface, int i17) {
                                    DepositActivity.this.go2PWDAuth();
                                    DepositActivity.this.dismissDetectDialog();
                                }
                            });
                            DepositActivity.this.mDetectDialog.setPositiveButton((String) null, (DialogInterface.OnClickListener) null);
                            return;
                        }
                        depositActivity.mDetectDialog.setPositiveButton(R.string.iws, new DialogInterface.OnClickListener() { // from class: com.tenpay.sdk.activity.DepositActivity.5.2
                            @Override // android.content.DialogInterface.OnClickListener
                            public void onClick(DialogInterface dialogInterface, int i17) {
                                DepositActivity.this.mDetectDialog.setMessage(String.format(DepositActivity.this.getString(R.string.f171337e63), QWSoterConstans.getNameByBusiType(curSoterBusiType)));
                                AnonymousClass5 anonymousClass5 = AnonymousClass5.this;
                                DepositActivity.this.setDetectDialogImg(QWSoterConstans.getAuthResIdByBusiType(curSoterBusiType));
                                DepositActivity.this.mDetectDialog.setPositiveButton((String) null, (DialogInterface.OnClickListener) null);
                                DepositActivity.this.startFingerprintAuthentication();
                            }
                        }, false);
                        return;
                    }
                    return;
                }
                if (DepositActivity.this.isFinishing()) {
                    return;
                }
                DepositActivity.this.go2PWDAuth();
            }
        }, new AuthenticationParam.AuthenticationParamBuilder().setScene(Cgi.scene_FingerPay).setBiometricType(QWSoterConstans.getBiometricType(curSoterBusiType)).setContext(getContext()).setSoterBiometricCanceller(this.mSoterBiometricCanceller).setPrefilledChallenge(hexdigest).setIWrapUploadSignature(null).setSoterBiometricStateCallback(new SoterBiometricStateCallbackCompat() { // from class: com.tenpay.sdk.activity.DepositActivity.4
            @Override // com.tencent.soter.wrapper.wrap_biometric.SoterBiometricStateCallback
            public void onAuthenticationCancelled() {
                DepositActivity.this.mTouchidRetryCount = 0;
                DepositActivity.this.mSoterBiometricCanceller = null;
                DepositActivity.this.dismissDetectDialog();
            }

            @Override // com.tenpay.compat.SoterBiometricStateCallbackCompat
            public void onAuthenticationErrorCompat(int i3, CharSequence charSequence) {
                QwLog.i("onAuthenticationError:" + i3 + ",CharSequence:" + ((Object) charSequence));
                DepositActivity.this.mSoterBiometricCanceller = null;
                QQToast.makeText(DepositActivity.this.getContext(), String.format(DepositActivity.this.getString(R.string.iwq), QWSoterConstans.getNameByBusiType(curSoterBusiType)), 0).show();
                DepositActivity.this.go2PWDAuth();
                DepositActivity.this.dismissDetectDialog();
            }

            @Override // com.tencent.soter.wrapper.wrap_biometric.SoterBiometricStateCallback
            public void onAuthenticationFailed() {
                DepositActivity.this.mTouchidRetryCount++;
                DepositActivity depositActivity = DepositActivity.this;
                depositActivity.playFingerErrorAnim(depositActivity.getString(R.string.e6a));
                if (DepositActivity.this.mDetectDialog != null) {
                    DepositActivity.this.mDetectDialog.playShakeAnim(R.anim.f154873en);
                }
                int i3 = DepositActivity.this.mTouchidRetryCount;
                DepositActivity depositActivity2 = DepositActivity.this;
                if (i3 >= depositActivity2.mTouchidRetryMaxCount) {
                    depositActivity2.go2PWDAuth();
                }
            }

            @Override // com.tencent.soter.wrapper.wrap_biometric.SoterBiometricStateCallback
            public void onAuthenticationHelp(int i3, CharSequence charSequence) {
                QwLog.i(String.format("onAuthenticationHelp: %d, %s", Integer.valueOf(i3), charSequence));
            }

            @Override // com.tencent.soter.wrapper.wrap_biometric.SoterBiometricStateCallback
            public void onAuthenticationSucceed() {
                DepositActivity depositActivity = DepositActivity.this;
                depositActivity.showQQPayLoading(depositActivity.mOtherPayView.getHeight());
                DepositActivity.this.dismissDetectDialog();
            }

            @Override // com.tencent.soter.wrapper.wrap_biometric.SoterBiometricStateCallback
            public void onStartAuthentication() {
                DepositActivity.this.showDetectDialog();
                TextView textView = DepositActivity.this.mFingerErrorTips;
                if (textView != null) {
                    textView.setText(R.string.e6i);
                    DepositActivity.this.mFingerErrorTips.setTextColor(Color.parseColor("#E8A741"));
                }
            }
        }).build());
    }

    protected void closeTime() {
        Timer timer = this.mTimer;
        if (timer != null) {
            timer.cancel();
        }
        mLeftTime = 59;
        Button button = this.mVerifyResendBtn;
        if (button != null) {
            button.setText(getString(R.string.ede));
            this.mVerifyResendBtn.setEnabled(true);
            this.mVerifyResendBtn.setClickable(true);
        }
    }

    protected void depositAuthen() {
        QwLog.i("---\u53d1\u8d77\u5145\u503c\u9274\u6743---" + this.mSelectBankObj);
        JSONObject jSONObject = this.mSelectBankObj;
        if (jSONObject != null) {
            String optString = jSONObject.optString("name");
            String optString2 = this.mSelectBankObj.optString("card_tail");
            if (!TextUtils.isEmpty(optString2)) {
                optString = optString + "(\u5c3e\u53f7" + optString2 + ")";
            }
            this.mPayType = optString;
            String optString3 = this.mSelectBankObj.optString("type");
            HashMap hashMap = new HashMap();
            hashMap.put("flag", "3");
            hashMap.put("uin", this.mUin);
            hashMap.put("amount", this.mDepositCount);
            hashMap.put("bank_type", this.mSelectBankObj.optString("code"));
            hashMap.put("bind_serial", this.mSelectBankObj.optString("bind_serialno"));
            hashMap.put("pay_passwd", getPasswd());
            if (this.mChangePhoneNum.booleanValue()) {
                hashMap.put("new_mobile", this.mNewPhoneNum);
            }
            hashMap.put("timestamp", this.mTimestamp + "");
            if (this.mIsReentry.booleanValue()) {
                this.mIsReentry = Boolean.FALSE;
                hashMap.put("is_reentry", "1");
            } else {
                hashMap.put("is_reentry", "0");
            }
            if (this.mWindowStyle == 1 && this.mFingerAuthenResult != null) {
                hashMap.put("pay_method", "2");
                hashMap.put("soter_auth_json", this.mFingerAuthenResult.getJsonValue());
                hashMap.put("soter_auth_signature", this.mFingerAuthenResult.getSignature());
                hashMap.put(QWSoterConstans.CGI_KEY_BUSI_TYPE, SharedHelper.getCurSoterBusiType(this.mUin) + "");
            }
            QwLog.i("pay_type = " + optString3);
            httpRequestWithQQPayLoading(Cgi.URI_QWallet_REQUEST_DEPOSIT, hashMap, getLoadingHeight());
        }
    }

    protected void deposit_verify() {
        JSONObject jSONObject = this.mSelectBankObj;
        if (jSONObject != null) {
            String optString = jSONObject.optString("name");
            String optString2 = this.mSelectBankObj.optString("card_tail");
            if (!Utils.isEmpty(optString2)) {
                optString = optString + "(\u5c3e\u53f7" + optString2 + ")";
            }
            this.mPayType = optString;
            HashMap hashMap = new HashMap();
            hashMap.put("flag", "3");
            hashMap.put(TPDownloadProxyEnum.USER_SSID, this.mBindedFastObj.optString(TPDownloadProxyEnum.USER_SSID));
            hashMap.put("uin", this.mUin);
            hashMap.put("bank_type", this.mSelectBankObj.optString("code"));
            hashMap.put("verify_code", this.mVerifyCodeEdit.getText().toString().trim());
            hashMap.put("pay_passwd", getPasswd());
            hashMap.put("timestamp", this.mTimestamp + "");
            if (this.mWindowStyle == 1) {
                hashMap.put("pay_method", "2");
            }
            httpRequestWithQQPayLoading(Cgi.URI_QWallet_VERIFY_DEPOSIT, hashMap, getLoadingHeight());
        }
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment
    public boolean doOnKeyDown(int i3, KeyEvent keyEvent) {
        if (i3 == 4) {
            back();
            return true;
        }
        return super.doOnKeyDown(i3, keyEvent);
    }

    protected void fillViewWithData(int i3) {
        this.mSelectedPayBankIndex = i3;
        String str = this.mBankArrayStr;
        if (str != null) {
            try {
                JSONArray jSONArray = new JSONArray(str);
                this.mBankCount = jSONArray.length();
                if (jSONArray.length() > 0 && this.mSelectedPayBankIndex < jSONArray.length()) {
                    if (this.mSelectedPayBankIndex <= 0) {
                        int i16 = 0;
                        while (true) {
                            if (i16 >= jSONArray.length()) {
                                break;
                            }
                            if (((JSONObject) jSONArray.opt(i16)).optString(TransFileControllerImpl.VALUE_USE_PRE_CONN).contains("CHARGE")) {
                                this.mSelectedPayBankIndex = i16;
                                break;
                            }
                            i16++;
                        }
                    }
                    JSONObject jSONObject = (JSONObject) jSONArray.opt(this.mSelectedPayBankIndex);
                    if (jSONObject.optInt("disable") == 0) {
                        this.mSelectBankObj = jSONObject;
                        setPayType(this.mSelectBankObj.optString("image_id"), jSONObject.optString("name"), this.mSelectBankObj.optString("card_tail"));
                        this.mIsCreditCard = Boolean.valueOf(this.mSelectBankObj.optString("cardtype").equals("CREDIT"));
                    }
                    if (this.mWindowStyle == 0) {
                        showPassPayView();
                    } else {
                        showFingerPayView();
                    }
                }
            } catch (JSONException e16) {
                QLog.e(((NetBaseActivity) this).TAG, 1, "", e16);
            }
        }
    }

    protected String getPasswd() {
        if (this.mIsSixPasswdUser) {
            return this.mSixPasswdEdit.getInputText();
        }
        return this.mNormalPasswdEdit.getText().toString();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tenpay.sdk.activity.TenpayUtilActivity
    public int getProcessType() {
        int i3;
        if (this.mWindowStyle == 1) {
            return 139;
        }
        if (this.mHasVerify) {
            if (this.mChangePhoneNum.booleanValue()) {
                i3 = 17;
            } else {
                i3 = 119;
            }
        } else {
            i3 = 118;
        }
        if (this.mForgetPwd) {
            if (this.mForgetPwdBind) {
                return 123;
            }
            return 124;
        }
        return i3;
    }

    @Override // com.tenpay.sdk.activity.NetBaseActivity, com.tenpay.sdk.activity.TenpayUtilActivity, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public /* bridge */ /* synthetic */ ViewModel getViewModel(ViewModelStoreOwner viewModelStoreOwner, String str, @NonNull Class cls) {
        return ne0.a.a(this, viewModelStoreOwner, str, cls);
    }

    protected void gotoDepositSuccess(JSONObject jSONObject) {
        Intent intent = new Intent();
        intent.putExtra(CommonCode.MapKey.TRANSACTION_ID, jSONObject.optString(CommonCode.MapKey.TRANSACTION_ID));
        intent.putExtra("pay_time", jSONObject.optString("pay_time"));
        String optString = this.mSelectBankObj.optString("name");
        String optString2 = this.mSelectBankObj.optString("card_tail");
        StringBuilder sb5 = new StringBuilder();
        sb5.append(optString);
        if (!TextUtils.isEmpty(optString2)) {
            sb5.append("(");
            sb5.append(optString2);
            sb5.append(")");
        }
        intent.putExtra("bank_info", sb5.toString());
        intent.putExtra("deposit_count", this.mDepositCount);
        intent.putExtra("process_flag", getProcessType());
        launchFragment(intent, DepositSuccessActivity.class);
        this.mChangePhoneNum = Boolean.FALSE;
        finish();
    }

    protected void initTimer() {
        String str = getString(R.string.ede) + "(" + mLeftTime + ")";
        this.mVerifyResendBtn.setClickable(false);
        this.mVerifyResendBtn.setEnabled(false);
        this.mVerifyResendBtn.setText(str);
        AnonymousClass3 anonymousClass3 = new AnonymousClass3();
        Timer timer = this.mTimer;
        if (timer != null) {
            timer.cancel();
            this.mTimer = null;
        }
        BaseTimer baseTimer = new BaseTimer();
        this.mTimer = baseTimer;
        baseTimer.schedule(anonymousClass3, 1000L, 1000L);
    }

    protected void initView(View view) {
        this.mTitleTxt = (TextView) view.findViewById(R.id.fjh);
        TextView textView = (TextView) view.findViewById(R.id.f30560oo);
        this.mTitleRightTxt = textView;
        textView.setOnClickListener(this);
        Button button = (Button) view.findViewById(R.id.b7s);
        this.confirmPayBtn = button;
        button.setOnClickListener(this);
        this.mCloseBtn = (ImageButton) view.findViewById(R.id.az7);
        this.back_btn = (ImageView) view.findViewById(R.id.a47);
        this.mCloseBtn.setOnClickListener(this);
        this.back_btn.setOnClickListener(this);
        LinearLayout linearLayout = (LinearLayout) this.mPassView.findViewById(R.id.ggt);
        this.mChangePayTypeBtn_pass = linearLayout;
        linearLayout.setOnClickListener(this);
        this.mChangePayBankTxt_pass = (TextView) this.mPassView.findViewById(R.id.at5);
        this.mChangePayBankTail_pass = (TextView) this.mPassView.findViewById(R.id.f164766at4);
        this.mChangePayBankIcon_pass = (ImageView) this.mPassView.findViewById(R.id.ggs);
        LinearLayout linearLayout2 = (LinearLayout) this.mOtherPayView.findViewById(R.id.ggt);
        this.mChangePayTypeBtn_finger = linearLayout2;
        linearLayout2.setOnClickListener(this);
        this.mChangePayBankTxt_finger = (TextView) this.mOtherPayView.findViewById(R.id.at5);
        this.mChangePayBankTail_finger = (TextView) this.mOtherPayView.findViewById(R.id.f164766at4);
        this.mChangePayBankIcon_finger = (ImageView) this.mOtherPayView.findViewById(R.id.ggs);
        this.mProductTxt = (TextView) view.findViewById(R.id.title_txt);
        this.mPriceTxt = (TextView) view.findViewById(R.id.f166540fz1);
        this.price_layout = (RelativeLayout) view.findViewById(R.id.f166539fz0);
        view.findViewById(R.id.fyy).setVisibility(8);
        this.mPayAuthLayout = (LinearLayout) view.findViewById(R.id.a16);
        this.mProductTxt = (TextView) view.findViewById(R.id.title_txt);
        this.mPriceTxt = (TextView) view.findViewById(R.id.f166540fz1);
        this.price_layout = (RelativeLayout) view.findViewById(R.id.f166539fz0);
        this.mPriceTxt.setText(Utils.fen2Yuan(this.mDepositCount));
        this.mProductTxt.setText(getString(R.string.e59));
        this.mNormalPasswdEdit = (EditText) view.findViewById(R.id.fai);
        this.normal_passwd_layout = (LinearLayout) view.findViewById(R.id.faj);
        this.mNormalPasswdEdit.setLongClickable(false);
        this.mNormalPasswdEdit.addTextChangedListener(this.mTextWatcher);
        SixPasswdDialogEditText sixPasswdDialogEditText = (SixPasswdDialogEditText) view.findViewById(R.id.iwz);
        this.mSixPasswdEdit = sixPasswdDialogEditText;
        sixPasswdDialogEditText.setLongClickable(false);
        this.mSixPasswdEdit.setOnPasswdInputListener(new OnPasswdInputListener() { // from class: com.tenpay.sdk.activity.aj
            @Override // com.tenpay.sdk.view.OnPasswdInputListener
            public final void onTextChange() {
                DepositActivity.this.lambda$initView$0();
            }
        });
        this.mSixPasswdEdit.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.tenpay.sdk.activity.ak
            @Override // android.view.View.OnFocusChangeListener
            public final void onFocusChange(View view2, boolean z16) {
                DepositActivity.this.lambda$initView$2(view2, z16);
            }
        });
        this.mSixPasswdEdit.setOnClickListener(this);
        this.mSixPasswdEdit.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.tenpay.sdk.activity.al
            @Override // android.widget.TextView.OnEditorActionListener
            public final boolean onEditorAction(TextView textView2, int i3, KeyEvent keyEvent) {
                boolean lambda$initView$3;
                lambda$initView$3 = DepositActivity.this.lambda$initView$3(textView2, i3, keyEvent);
                return lambda$initView$3;
            }
        });
        this.mFingerErrorTips = (TextView) view.findViewById(R.id.caq);
        TextView textView2 = (TextView) view.findViewById(R.id.fjf);
        this.mPayErrorTxt = textView2;
        textView2.setOnClickListener(this);
        this.mKeyboard = (MyKeyboardWindow) view.findViewById(R.id.je9);
        this.mVerifyKeyboard = (MyKeyboardWindow) view.findViewById(R.id.kn7);
        this.mVerifyMobileTxt = (TextView) view.findViewById(R.id.fmv);
        EditText editText = (EditText) view.findViewById(R.id.knc);
        this.mVerifyCodeEdit = editText;
        editText.addTextChangedListener(this.mTextWatcher);
        this.mVerifyCodeEdit.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.tenpay.sdk.activity.am
            @Override // android.widget.TextView.OnEditorActionListener
            public final boolean onEditorAction(TextView textView3, int i3, KeyEvent keyEvent) {
                boolean lambda$initView$4;
                lambda$initView$4 = DepositActivity.this.lambda$initView$4(textView3, i3, keyEvent);
                return lambda$initView$4;
            }
        });
        this.mVerifyCodeEdit.setOnClickListener(this);
        QWalletUtils.hideSysKeyBorad(this.mVerifyCodeEdit);
        Button button2 = (Button) view.findViewById(R.id.i8e);
        this.mVerifyResendBtn = button2;
        button2.setOnClickListener(this);
        Button button3 = (Button) view.findViewById(R.id.change_phone_num_btn);
        this.mChangePhoneNumBtn = button3;
        button3.setOnClickListener(this);
        this.mChangePhoneNumBtn.setEnabled(true);
        this.mChangePhoneNumBtn.setClickable(true);
        this.mChangePhoneNumBtn.setVisibility(8);
        Button button4 = (Button) view.findViewById(R.id.fah);
        this.mPayConfirmBtn = button4;
        button4.setOnClickListener(this);
        LinearLayout linearLayout3 = (LinearLayout) this.mPassView.findViewById(R.id.f30580oq);
        this.mWx2QQLayoutPassword = linearLayout3;
        linearLayout3.setOnClickListener(this);
        LinearLayout linearLayout4 = (LinearLayout) this.mOtherPayView.findViewById(R.id.f30580oq);
        this.mWx2QQLayoutFinger = linearLayout4;
        linearLayout4.setOnClickListener(this);
        Intent intent = getIntent();
        if (intent.hasExtra("title") && intent.hasExtra("url")) {
            String stringExtra = intent.getStringExtra("title");
            this.mWx2QQUrl = intent.getStringExtra("url");
            ((TextView) this.mPassView.findViewById(R.id.f122157d7)).setText(stringExtra);
            this.mWx2QQLayoutPassword.setVisibility(0);
            ((TextView) this.mOtherPayView.findViewById(R.id.f122157d7)).setText(stringExtra);
            this.mWx2QQLayoutFinger.setVisibility(0);
        } else {
            this.mWx2QQLayoutFinger.setVisibility(8);
            this.mWx2QQLayoutFinger.setVisibility(8);
        }
        com.tencent.mobileqq.qwallet.c.c("smallpay.pwd.show", Integer.valueOf(getProcessType()));
    }

    @Override // com.tenpay.sdk.activity.TenpayUtilActivity, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onActivityResult(int i3, int i16, Intent intent) {
        String str;
        if (i16 == -1) {
            if (i3 == CHANGEPHONENUM_RESULT_CODE) {
                if (intent == null) {
                    return;
                }
                Boolean bool = Boolean.TRUE;
                this.mChangePhoneNum = bool;
                this.mIsReentry = bool;
                String stringExtra = intent.getStringExtra("PhoneNum");
                this.mNewPhoneNum = stringExtra;
                if (stringExtra == null || stringExtra.length() != 11) {
                    str = "";
                } else {
                    str = (this.mNewPhoneNum.substring(0, 3) + "*****") + this.mNewPhoneNum.substring(9, 11);
                }
                this.mVerifyMobileTxt.setText(getString(R.string.edo) + str);
                if (!TextUtils.isEmpty(this.mNewPhoneNum)) {
                    closeTime();
                    this.mVerifyCodeEdit.setText("");
                    depositAuthen();
                    return;
                }
                return;
            }
            if (i3 == DEPOSIT_BANK_RESULT_CODE) {
                if (intent == null) {
                    return;
                }
                if (intent.getBooleanExtra("afterBindNewCard", false)) {
                    finish();
                }
                goneVerfyView();
                int intExtra = intent.getIntExtra("bank_index", 0);
                this.mSelectedPayBankIndex = intExtra;
                this.mPassAnimDuration = 150;
                fillViewWithData(intExtra);
                this.isNeedRestartFingerPay = false;
                return;
            }
            if (i3 == DEPOSIT_BIND_RESULT_CODE) {
                this.mForgetPwd = true;
                if (intent == null) {
                    return;
                }
                this.mForgetPwdBind = intent.getBooleanExtra("forget_bind", false);
                this.mPassFlag = "2";
                showPassPayView();
                return;
            }
            return;
        }
        if (i16 == 0) {
            if (i3 == DEPOSIT_BANK_RESULT_CODE) {
                goneVerfyView();
                this.mPassAnimDuration = 150;
                fillViewWithData(this.mSelectedPayBankIndex);
                this.isNeedRestartFingerPay = false;
                return;
            }
            if (i3 == CHANGEPHONENUM_RESULT_CODE) {
                this.mChangePhoneNum = Boolean.FALSE;
            } else if (i3 == DEPOSIT_BIND_RESULT_CODE) {
                clearPass();
            }
        }
    }

    @Override // com.tenpay.sdk.activity.NetBaseActivity, com.tenpay.sdk.paynet.Net.NetListener
    public void onBlError(String str, JSONObject jSONObject) {
        super.onBlError(str, jSONObject);
        String optString = jSONObject.optString("retcode");
        if (ErrorCode.ERR_PASSWORD_BALANCE_PAY.equals(optString)) {
            playPassWordErrorAnim(jSONObject.optString("retmsg"));
            return;
        }
        if (ErrorCode.ERR_PAYPASS_TIMEOUT.equals(optString)) {
            httpRequestNoEncript(Cgi.URI_GET_PASS_TIME, new HashMap());
            return;
        }
        if (!this.isShowingVerifyCodeView) {
            if (this.mIsSixPasswdUser) {
                this.mSixPasswdEdit.setInputText("");
                this.mSixPasswdEdit.requestFocus();
                this.mPayConfirmBtn.setClickable(false);
                this.mPayConfirmBtn.setEnabled(false);
                return;
            }
            this.mNormalPasswdEdit.setText("");
            this.mNormalPasswdEdit.requestFocus();
            return;
        }
        this.mVerifyCodeEdit.setText("");
        this.mVerifyCodeEdit.requestFocus();
    }

    @Override // com.tenpay.sdk.activity.NetBaseActivity, cooperation.qwallet.plugin.FakeUrl.FakeListener
    public boolean onBlHandleFakeurl(FakeUrl.FakeInfo fakeInfo, int i3) {
        if (i3 == 0) {
            if (fakeInfo.data.optString("close_cur_page").equals("1")) {
                finish();
            }
            return false;
        }
        if (i3 == 1 && fakeInfo.reqUrl.equals(Cgi.URI_QWallet_REQUEST_DEPOSIT) && RET_CODE_CHARGE_AUTHEN_ERROR_152702158.equals(fakeInfo.data.optString("retcode"))) {
            new QWalletFakeUrlHandler(getActivity(), com.tencent.mobileqq.base.a.c()).dispatch(fakeInfo.retUrl);
            finish();
            return true;
        }
        super.onBlHandleFakeurl(fakeInfo, i3);
        if (!fakeInfo.host.equals(QWalletFakeUrl.FAKEURL_REGENERATEASKEY) && !fakeInfo.host.equals(QWalletFakeUrl.FAKEURL_REGENERATEAUTHKEY)) {
            return false;
        }
        go2PWDAuth();
        return false;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        int id5 = view.getId();
        if (id5 == R.id.fah) {
            depositAuthen();
        } else if (id5 == R.id.fjf) {
            Intent intent = new Intent();
            intent.putExtra("pass_flag", this.mPassFlag);
            intent.putExtra("forget_pass", true);
            intent.putExtra(DepositStartActivity.FROM_DESPOSIT, true);
            launchFragmentForResult(intent, ResetPassBridgeActivity.class, DEPOSIT_BIND_RESULT_CODE);
        } else if (id5 == R.id.kkq) {
            if (this.mWindowStyle == 1) {
                com.tencent.mobileqq.qwallet.c.c("fingerprint.confirm.pwd", Integer.valueOf(getProcessType()));
                go2PWDAuth();
            }
        } else if (id5 != R.id.a47 && id5 != R.id.az7) {
            if (id5 != this.mChangePayTypeBtn_finger.getId() && id5 != this.mChangePayTypeBtn_pass.getId()) {
                if (id5 == R.id.i8e) {
                    if (this.mWindowStyle == 0) {
                        com.tencent.mobileqq.qwallet.c.c("smallpay.sms.reacquire", Integer.valueOf(getProcessType()));
                    }
                    this.mIsReentry = Boolean.TRUE;
                    depositAuthen();
                } else if (id5 != R.id.iwz && id5 != R.id.knc) {
                    if (id5 == R.id.change_phone_num_btn) {
                        if (this.mWindowStyle == 0) {
                            com.tencent.mobileqq.qwallet.c.c("smallpay.sms.change", Integer.valueOf(getProcessType()));
                        }
                        go2ChangePhoneNumActivity();
                    } else if (id5 == R.id.f30560oo) {
                        int i3 = this.mWindowStyle;
                        if (i3 == 0) {
                            this.mWindowStyle = 1;
                            showFingerPayView();
                        } else if (i3 == 1) {
                            showPassPayView();
                        }
                    } else if (id5 == R.id.f30580oq) {
                        com.tencent.mobileqq.qwallet.utils.k.h(getContext(), this.mWx2QQUrl);
                    } else if (id5 == R.id.b7s && SoterWrapperApi.isSupportSoter() && this.mSoterBiometricCanceller == null) {
                        QwLog.i("\u8c03\u7528\u5fae\u4fe1SDK\u5f00\u542f\u6307\u7eb9\u670d\u52a1");
                        startFingerprintAuthentication();
                    }
                } else if (!this.mKeyboard.isShown()) {
                    this.mKeyboard.setVisibility(0);
                }
            } else {
                if (this.mWindowStyle == 1) {
                    com.tencent.mobileqq.qwallet.c.c("fingerprint.confirm.change-payment", Integer.valueOf(getProcessType()));
                }
                gotoChangePayType();
            }
        } else {
            back();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        getWindow().setSoftInputMode(19);
        Intent intent = getIntent();
        this.mDepositCount = intent.getStringExtra("deposit_count");
        View inflate = layoutInflater.inflate(R.layout.aff, viewGroup, false);
        this.mRootView = (RelativeLayout) inflate.findViewById(R.id.root_layout);
        this.mOtherPayView = (LinearLayout) inflate.findViewById(R.id.f166474fg0);
        this.mPassView = (LinearLayout) inflate.findViewById(R.id.fio);
        this.mAnimLayout = (RelativeLayout) inflate.findViewById(R.id.f164327rz);
        this.mPayHeadLayout = (LinearLayout) inflate.findViewById(R.id.fjg);
        this.mVerifyView = (LinearLayout) inflate.findViewById(R.id.knd);
        int height = getActivity().getWindowManager().getDefaultDisplay().getHeight();
        if (QFuncProxy.isSupporImmersive() != 1) {
            height -= ImmersiveUtils.getStatusBarHeight(getContext());
        }
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.mRootView.getLayoutParams();
        layoutParams.height = height * 2;
        this.mRootView.setLayoutParams(layoutParams);
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.mAnimLayout.getLayoutParams();
        layoutParams2.height = height;
        this.mAnimLayout.setLayoutParams(layoutParams2);
        this.mAnimLayout.setVisibility(0);
        if (intent.getBooleanExtra("isFingerDeposit", false) && this.mTouchidState == 3) {
            this.mWindowStyle = 1;
            checkFP();
            this.mFingerStatus = true;
        }
        initView(inflate);
        this.mSelectedPayBankIndex = intent.getIntExtra("bank_index", 0);
        this.mBankArrayStr = intent.getStringExtra("banks_info");
        fillViewWithData(this.mSelectedPayBankIndex);
        com.tencent.mobileqq.qwallet.c.c("smallpay.pwd.show", Integer.valueOf(getProcessType()));
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, inflate);
        return inflate;
    }

    @Override // com.tenpay.sdk.activity.NetBaseActivity, com.tenpay.sdk.activity.TenpayUtilActivity, com.tencent.mobileqq.base.QWalletBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        closeTime();
        releaseFp();
        super.onDestroy();
    }

    @Override // com.tenpay.sdk.activity.NetBaseActivity
    public void onNetDlgokClick(String str, JSONObject jSONObject) {
        super.onNetDlgokClick(str, jSONObject);
        if (this.mWindowStyle == 1 && !this.isShowingVerifyCodeView) {
            go2PWDAuth();
        }
    }

    @Override // com.tenpay.sdk.activity.NetBaseActivity, com.tenpay.sdk.activity.TenpayUtilActivity, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    @Deprecated
    public /* bridge */ /* synthetic */ void onPartTimeCostReport(String str, String str2, long j3) {
        ne0.a.e(this, str, str2, j3);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        if (this.mWindowStyle == 1) {
            this.isNeedRestartFingerPay = true;
            releaseFp();
        }
    }

    @Override // com.tencent.mobileqq.base.QWalletBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.mWindowStyle == 1 && this.isNeedRestartFingerPay && !this.isShowingVerifyCodeView) {
            this.isNeedRestartFingerPay = false;
        }
    }

    @Override // com.tenpay.sdk.activity.NetBaseActivity, com.tenpay.sdk.paynet.Net.NetListener
    public void onSuccess(String str, JSONObject jSONObject) {
        String str2;
        super.onSuccess(str, jSONObject);
        if (str.equals(Cgi.URI_GET_PASS_TIME)) {
            String optString = jSONObject.optString(TVKLiveRequestBuilder.RequestParamKey.CKEY_TIMESTAMP);
            if (optString.length() == 20) {
                StringBuffer stringBuffer = new StringBuffer();
                for (int i3 = 0; i3 < optString.length(); i3++) {
                    if (i3 % 2 == 1) {
                        stringBuffer.append(optString.charAt(i3));
                    }
                }
                this.mTimestamp = Long.parseLong(stringBuffer.toString()) - (System.currentTimeMillis() / 1000);
                return;
            }
            this.mTimestamp = Long.parseLong(optString) - (System.currentTimeMillis() / 1000);
            return;
        }
        if (str.equals(Cgi.URI_QWallet_REQUEST_DEPOSIT)) {
            QwLog.i("---ID_QWallet_REQUEST_DEPOSIT call back---");
            if ("0".equals(jSONObject.optString("send_flag"))) {
                this.mHasVerify = false;
                gotoDepositSuccess(jSONObject);
                return;
            }
            this.mHasVerify = true;
            this.mBindedFastObj = jSONObject;
            String optString2 = jSONObject.optString(DeviceType.DeviceCategory.MOBILE);
            if (optString2.length() == 11) {
                str2 = (optString2.substring(0, 3) + "*****") + optString2.substring(9, 11);
            } else {
                str2 = "";
            }
            this.mVerifyMobileTxt.setText(getString(R.string.edo) + str2);
            this.mShowPhoneChangeBtn = Boolean.TRUE;
            showVeryfyCodeView();
            return;
        }
        if (Cgi.URI_QWallet_VERIFY_DEPOSIT.equals(str)) {
            QwLog.i("---URI_QWallet_VERIFY_DEPOSIT call back---");
            gotoDepositSuccess(jSONObject);
        }
    }

    @Override // com.tenpay.sdk.activity.NetBaseActivity, com.tenpay.sdk.activity.TenpayUtilActivity, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public /* bridge */ /* synthetic */ void onUserLeaveHint() {
        com.tencent.biz.richframework.compat.f.m(this);
    }

    protected void showDetectDialog() {
        try {
            if (getContext() != null && !isFinishing()) {
                if (this.mDetectDialog == null) {
                    int curSoterBusiType = SharedHelper.getCurSoterBusiType(this.mUin);
                    this.mDetectDialog = QUIProxy.createCustomDialogWithImage(getContext(), R.layout.ado, R.style.qZoneInputDialog, R.id.image, QWSoterConstans.getAuthResIdByBusiType(curSoterBusiType), null, String.format(getString(R.string.f171337e63), QWSoterConstans.getNameByBusiType(curSoterBusiType)), R.string.e5h, 0, null, new DialogInterface.OnClickListener() { // from class: com.tenpay.sdk.activity.DepositActivity.6
                        @Override // android.content.DialogInterface.OnClickListener
                        public void onClick(DialogInterface dialogInterface, int i3) {
                            DepositActivity.this.onOpenFingerPayFinish(false);
                        }
                    });
                }
                if (!this.mDetectDialog.isShowing()) {
                    this.mDetectDialog.show();
                }
                View findViewById = getActivity().findViewById(R.id.root_layout);
                if (findViewById != null) {
                    findViewById.setVisibility(4);
                }
            }
        } catch (Exception e16) {
            QLog.e(((NetBaseActivity) this).TAG, 1, "", e16);
        }
    }

    protected void showVeryfyCodeView() {
        this.mCloseBtn.setVisibility(0);
        this.isShowingVerifyCodeView = true;
        com.tencent.mobileqq.qwallet.c.c("smallpay.sms.show", Integer.valueOf(getProcessType()));
        this.mVerifyCodeEdit.setText("");
        QWalletUtils.hideSysKeyBorad(this.mVerifyCodeEdit);
        initTimer();
        this.mVerifyCodeEdit.requestFocus();
        this.mVerifyKeyboard.setInputEditText(this.mVerifyCodeEdit);
        if (this.mShowPhoneChangeBtn.booleanValue()) {
            this.mChangePhoneNumBtn.setVisibility(0);
        }
        this.mTitleTxt.setText(R.string.fz6);
        this.mPassView.setVisibility(4);
        this.mOtherPayView.setVisibility(4);
        this.mVerifyView.setVisibility(0);
        this.mProductTxt.setVisibility(8);
        this.price_layout.setVisibility(8);
        this.mCloseBtn.setVisibility(8);
        this.back_btn.setVisibility(0);
        this.mVerifyView.post(new Runnable() { // from class: com.tenpay.sdk.activity.ap
            @Override // java.lang.Runnable
            public final void run() {
                DepositActivity.this.lambda$showVeryfyCodeView$8();
            }
        });
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
