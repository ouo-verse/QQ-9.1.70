package com.tenpay.sdk.activity;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelStoreOwner;
import com.google.gson.GsonBuilder;
import com.heytap.databaseengine.type.DeviceType;
import com.huawei.hms.adapter.internal.CommonCode;
import com.tencent.gamematrix.gmcg.sdk.nonage.report.CGNonAgeReport;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.NotificationActivity;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.api.IQWalletUnitedConfigApi;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.opentelemetry.semconv.resource.attributes.ResourceAttributes;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.qqlive.tvkplayer.vinfo.live.TVKLiveRequestBuilder;
import com.tencent.thread.monitor.plugin.proxy.BaseTimer;
import com.tencent.thumbplayer.core.downloadproxy.api.TPDownloadProxyEnum;
import com.tencent.util.LoadingUtil;
import com.tenpay.ErrorCode;
import com.tenpay.QwLog;
import com.tenpay.api.MyKeyboardWindow;
import com.tenpay.api.QWalletUtils;
import com.tenpay.face.FaceVerifyBean;
import com.tenpay.face.FaceVerifyErr;
import com.tenpay.face.QWalletFaceProxyFragment;
import com.tenpay.idverify.hint.IdVerifyFinishProcessor;
import com.tenpay.idverify.hint.IdVerifyHintModule;
import com.tenpay.idverify.model.IdVerifyStateBean;
import com.tenpay.marketservice.MarketServiceUtils;
import com.tenpay.proxy.QUIProxy;
import com.tenpay.realname.RealNameSource;
import com.tenpay.realname.RealNameSourceReporter;
import com.tenpay.sdk.Cgi;
import com.tenpay.sdk.model.BindBankFaceBean;
import com.tenpay.sdk.net.NetSender;
import com.tenpay.sdk.paynet.Net;
import com.tenpay.sdk.util.TenUtils;
import com.tenpay.sdk.util.WalletGateData;
import com.tenpay.sdk.view.OnPasswdInputListener;
import com.tenpay.sdk.view.SixPasswdDialogEditText;
import com.tenpay.util.Utils;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import kotlin.Unit;
import org.json.JSONException;
import org.json.JSONObject;
import qk2.PrivacyTipConfig;

/* compiled from: P */
/* loaded from: classes27.dex */
public class ActivateTenpayAccount extends NetBaseActivity implements View.OnClickListener {
    protected static final int ONE_MINUTE = 59;
    public static final String PARAM_ACTIVATE_ACCOUNT_BUNDLE = "activate_account";
    public static final String PARAM_ACTIVATE_ACCOUNT_JSON = "activate_account_json";
    public static final String PARAM_ACTIVATE_FACE_VERIFY_BEAN = "face_verify_bean";
    public static final String PARAM_ACTIVATE_MAP = "activate";
    public static final String PARAM_FROM = "from";
    protected static int mLeftTime = 59;
    protected Button mActivate2Btn;
    protected LinearLayout mActivateLayout;
    protected HashMap<String, String> mActivateObj;
    protected TextView mBackBtn;
    private BindBankFaceBean mBindBankFaceBean;
    protected HashMap<String, String> mExcuteYzObj;
    protected FaceVerifyBean mFaceVerifyBean;
    protected Map<String, String> mGetYzmObj;
    private boolean mIsFromWithdraw;
    private boolean mIsShiMing;
    protected MyKeyboardWindow mKeyboardWindow;
    protected JSONObject mNewUserDepositObj;
    protected Button mNextBtn;
    protected SixPasswdDialogEditText mPassAgainEdit;
    protected SixPasswdDialogEditText mPassEdit;
    private RealNameSource mRealNameSource;
    protected RelativeLayout mRepeatLayout;
    protected EditText mThirdEdit;
    protected LinearLayout mThirdLayout;
    protected TextView mThirdPhoneTextView;
    protected Button mThirdResendBtn;
    protected Timer mTimer;
    private HashMap<String, String> parentParams = new HashMap<>();
    protected boolean mIsFromDeposit = false;
    protected String mNeedYzCode = "0";
    private String mTrustPayOpen = "";
    private String mPassword = null;
    protected EnumFrom mFrom = EnumFrom.BIND_BANK_IN_PAY;
    private View.OnClickListener mSixOnClickListener = new View.OnClickListener() { // from class: com.tenpay.sdk.activity.ActivateTenpayAccount.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            ActivateTenpayAccount.this.mKeyboardWindow.setVisibility(0);
            EventCollector.getInstance().onViewClicked(view);
        }
    };
    protected TextWatcher mTextWatcher = new TextWatcher() { // from class: com.tenpay.sdk.activity.ActivateTenpayAccount.2
        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            if (ActivateTenpayAccount.this.mThirdLayout.getVisibility() == 0) {
                if (ActivateTenpayAccount.this.mThirdEdit.getText().toString().trim().length() > 5) {
                    if (!ActivateTenpayAccount.this.mNextBtn.isEnabled()) {
                        ActivateTenpayAccount.this.addTraceData("enable");
                    }
                    ActivateTenpayAccount.this.mNextBtn.setClickable(true);
                    ActivateTenpayAccount.this.mNextBtn.setEnabled(true);
                    return;
                }
                if (ActivateTenpayAccount.this.mNextBtn.isEnabled()) {
                    ActivateTenpayAccount.this.addTraceData("disable");
                }
                ActivateTenpayAccount.this.mNextBtn.setClickable(false);
                ActivateTenpayAccount.this.mNextBtn.setEnabled(false);
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
        }
    };
    protected OnPasswdInputListener mOnPasswdInputListener = new OnPasswdInputListener() { // from class: com.tenpay.sdk.activity.ActivateTenpayAccount.3
        @Override // com.tenpay.sdk.view.OnPasswdInputListener
        public void onTextChange() {
            ActivateTenpayAccount.this.mHandler.postDelayed(new Runnable() { // from class: com.tenpay.sdk.activity.ActivateTenpayAccount.3.1
                @Override // java.lang.Runnable
                public void run() {
                    if (ActivateTenpayAccount.this.mActivateLayout.getVisibility() == 0) {
                        if (ActivateTenpayAccount.this.mPassEdit.getInputText().trim().length() > 5) {
                            ActivateTenpayAccount.this.addTraceData("pagesecond");
                            ActivateTenpayAccount.this.mActivateLayout.setVisibility(8);
                            ActivateTenpayAccount.this.mRepeatLayout.setVisibility(0);
                            ActivateTenpayAccount.this.addTraceData("show");
                            ActivateTenpayAccount.this.mPassAgainEdit.requestFocus();
                            ActivateTenpayAccount.this.mKeyboardWindow.setXMode(3);
                            ActivateTenpayAccount activateTenpayAccount = ActivateTenpayAccount.this;
                            activateTenpayAccount.mKeyboardWindow.setInputEditText(activateTenpayAccount.mPassAgainEdit);
                            return;
                        }
                        return;
                    }
                    if (ActivateTenpayAccount.this.mRepeatLayout.getVisibility() == 0) {
                        if (ActivateTenpayAccount.this.mPassAgainEdit.getInputText().trim().length() > 5) {
                            if (!ActivateTenpayAccount.this.mActivate2Btn.isEnabled()) {
                                ActivateTenpayAccount.this.addTraceData("enable");
                            }
                            ActivateTenpayAccount.this.mActivate2Btn.setClickable(true);
                            ActivateTenpayAccount.this.mActivate2Btn.setEnabled(true);
                            return;
                        }
                        if (ActivateTenpayAccount.this.mActivate2Btn.isEnabled()) {
                            ActivateTenpayAccount.this.addTraceData("disable");
                        }
                        ActivateTenpayAccount.this.mActivate2Btn.setClickable(false);
                        ActivateTenpayAccount.this.mActivate2Btn.setEnabled(false);
                    }
                }
            }, 500L);
        }
    };
    protected final Handler mTimeHandler = new Handler() { // from class: com.tenpay.sdk.activity.ActivateTenpayAccount.6
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            ActivateTenpayAccount.mLeftTime--;
            String string = ActivateTenpayAccount.this.getString(R.string.ede);
            if (ActivateTenpayAccount.mLeftTime > 0) {
                string = string + "(" + ActivateTenpayAccount.mLeftTime + ")";
                ActivateTenpayAccount.this.mThirdResendBtn.setClickable(false);
                ActivateTenpayAccount.this.mThirdResendBtn.setEnabled(false);
            } else {
                ActivateTenpayAccount.this.mThirdResendBtn.setClickable(true);
                ActivateTenpayAccount.this.mThirdResendBtn.setEnabled(true);
                ActivateTenpayAccount.this.mTimer.cancel();
                ActivateTenpayAccount.mLeftTime = 59;
            }
            ActivateTenpayAccount.this.mThirdResendBtn.setText(string);
        }
    };
    private final HashSet<Runnable> runnableHashSet = new HashSet<>();

    /* compiled from: P */
    /* renamed from: com.tenpay.sdk.activity.ActivateTenpayAccount$11, reason: invalid class name */
    /* loaded from: classes27.dex */
    static /* synthetic */ class AnonymousClass11 {
        static final /* synthetic */ int[] $SwitchMap$com$tenpay$sdk$activity$ActivateTenpayAccount$EnumFrom;

        static {
            int[] iArr = new int[EnumFrom.values().length];
            $SwitchMap$com$tenpay$sdk$activity$ActivateTenpayAccount$EnumFrom = iArr;
            try {
                iArr[EnumFrom.BIND_BANK_IN_PAY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$tenpay$sdk$activity$ActivateTenpayAccount$EnumFrom[EnumFrom.BIND_BANK.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$tenpay$sdk$activity$ActivateTenpayAccount$EnumFrom[EnumFrom.ID_AUTH.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$tenpay$sdk$activity$ActivateTenpayAccount$EnumFrom[EnumFrom.CHILDREN_AUTH.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public enum EnumFrom {
        BIND_BANK_IN_PAY,
        BIND_BANK,
        ID_AUTH,
        CHILDREN_AUTH;

        public static EnumFrom create(int i3) {
            for (EnumFrom enumFrom : values()) {
                if (enumFrom.ordinal() == i3) {
                    return enumFrom;
                }
            }
            return BIND_BANK_IN_PAY;
        }
    }

    private void afterIdVerifySuccess(final JSONObject jSONObject) {
        RealNameSourceReporter.INSTANCE.reportIdVerifyGet(false);
        QwLog.i("onSuccess,auth_comment");
        final Dialog showLoadingDialog = showLoadingDialog();
        final PrivacyTipConfig privacyTipConfig = (PrivacyTipConfig) ((IQWalletUnitedConfigApi) QRoute.api(IQWalletUnitedConfigApi.class)).getConfig(IQWalletUnitedConfigApi.QWALLET_PRIVACY_TIP_CONFIG, new PrivacyTipConfig());
        final zu1.c cVar = new zu1.c() { // from class: com.tenpay.sdk.activity.a
            @Override // zu1.c
            public final Object invoke(Object obj) {
                Unit lambda$afterIdVerifySuccess$0;
                lambda$afterIdVerifySuccess$0 = ActivateTenpayAccount.this.lambda$afterIdVerifySuccess$0(showLoadingDialog, privacyTipConfig, jSONObject, (Boolean) obj);
                return lambda$afterIdVerifySuccess$0;
            }
        };
        List<Integer> b16 = privacyTipConfig.b();
        if (b16.isEmpty()) {
            cVar.invoke(Boolean.FALSE);
            return;
        }
        for (int i3 = 0; i3 < b16.size(); i3++) {
            final boolean z16 = true;
            if (i3 != b16.size() - 1) {
                z16 = false;
            }
            Runnable runnable = new Runnable() { // from class: com.tenpay.sdk.activity.b
                @Override // java.lang.Runnable
                public final void run() {
                    ActivateTenpayAccount.this.lambda$afterIdVerifySuccess$1(z16, cVar);
                }
            };
            ThreadManagerV2.getUIHandlerV2().postDelayed(runnable, b16.get(i3).intValue() * 1000);
            this.runnableHashSet.add(runnable);
        }
        Runnable runnable2 = new Runnable() { // from class: com.tenpay.sdk.activity.c
            @Override // java.lang.Runnable
            public final void run() {
                ActivateTenpayAccount.lambda$afterIdVerifySuccess$2(zu1.c.this);
            }
        };
        ThreadManagerV2.getUIHandlerV2().postDelayed(runnable2, 10000L);
        this.runnableHashSet.add(runnable2);
    }

    private void gotoFaceVerify() {
        if (isFinishing()) {
            QwLog.e("gotoFaceVerify fail, activity isFinishing");
            return;
        }
        Context context = getContext();
        if (context == null) {
            QwLog.e("gotoFaceVerify fail, context is null");
            return;
        }
        BindBankFaceBean bindBankFaceBean = this.mBindBankFaceBean;
        if (bindBankFaceBean == null) {
            QwLog.e("gotoFaceVerify fail, mBindBankFaceBean is null");
        } else {
            QWalletFaceProxyFragment.start(context, bindBankFaceBean.toVerifyBean(), 101);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$afterIdVerifySuccess$0(Dialog dialog, PrivacyTipConfig privacyTipConfig, JSONObject jSONObject, Boolean bool) {
        String optString;
        String optString2;
        PrivacyTipConfig.SourceContent sourceContent;
        Iterator<Runnable> it = this.runnableHashSet.iterator();
        while (it.hasNext()) {
            ThreadManagerV2.removeJob(it.next(), 128);
        }
        if (isFinishing()) {
            return Unit.INSTANCE;
        }
        dialog.dismiss();
        String str = "\u5b8c\u6210";
        if (bool.booleanValue()) {
            Map<String, PrivacyTipConfig.SourceContent> d16 = privacyTipConfig.d();
            RealNameSource realNameSource = this.mRealNameSource;
            if (realNameSource != null && (sourceContent = d16.get(realNameSource.getSourceId())) != null) {
                optString = sourceContent.getFinishTitle();
                optString2 = sourceContent.getFinishTip();
                str = sourceContent.getFinishBtnText();
            } else {
                optString = "\u5df2\u5b8c\u6210\u5b9e\u540d\u8ba4\u8bc1";
                optString2 = "";
            }
        } else {
            optString = jSONObject.optString(IdVerifyFinishProcessor.KEY_AUTH_COMMENT);
            optString2 = jSONObject.optString(IdVerifyFinishProcessor.KEY_AUTH_TIP);
        }
        setResult(-1, new Intent().putExtra(IdVerifyFinishProcessor.KEY_AUTH_COMMENT, optString).putExtra(IdVerifyFinishProcessor.KEY_AUTH_TIP, optString2).putExtra(IdVerifyFinishProcessor.KEY_AUTH_BUTTON, str));
        finish();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$afterIdVerifySuccess$2(zu1.c cVar) {
        cVar.invoke(Boolean.FALSE);
    }

    private void newUserBind_Deposit() {
        HashMap hashMap = new HashMap();
        hashMap.put(TPDownloadProxyEnum.USER_SSID, this.mNewUserDepositObj.optString(TPDownloadProxyEnum.USER_SSID));
        hashMap.put("uin", this.mUin);
        hashMap.put("bank_type", this.mNewUserDepositObj.optString("bank_type"));
        hashMap.put("verify_code", this.mNewUserDepositObj.optString("verify_code"));
        hashMap.put("pay_passwd", this.mPassEdit.getInputText().trim());
        hashMap.put("timestamp", this.mTimestamp + "");
        httpRequest(Cgi.URI_QWallet_NEWUSER_DEPOSIT, hashMap);
    }

    private void onFaceVerifyFinish(int i3, Intent intent) {
        if (i3 != -1) {
            QwLog.e("onFaceVerifyFinish fail, resultCode=" + i3);
            return;
        }
        if (intent == null) {
            QwLog.e("onFaceVerifyFinish fail, data is null");
            return;
        }
        int intExtra = intent.getIntExtra(QWalletFaceProxyFragment.KEY_OUT_PARAM_RET_CODE, FaceVerifyErr.ERROR_CANCEL.getRetCode());
        String stringExtra = intent.getStringExtra(QWalletFaceProxyFragment.KEY_OUT_PARAM_RET_MSG);
        if (intExtra == FaceVerifyErr.OK.getRetCode()) {
            QwLog.i("onFaceVerifyFinish success");
            showContinuePwd();
            return;
        }
        QwLog.e("onFaceVerifyFinish fail: retCode=" + intExtra + ", retMsg=" + stringExtra);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: requestQwalletCgi, reason: merged with bridge method [inline-methods] */
    public void lambda$afterIdVerifySuccess$1(final boolean z16, final zu1.c<Boolean, Unit> cVar) {
        HashMap hashMap = new HashMap();
        String str = this.mUin;
        if (TextUtils.isEmpty(str)) {
            str = com.tencent.mobileqq.base.a.c();
        }
        hashMap.put("uin", str);
        hashMap.put("query_real_data", "1");
        NetSender.with(getActivity(), Cgi.URL_WALLET_GATE, hashMap, com.tencent.mobileqq.base.a.c()).request(new Net.NetAdapter() { // from class: com.tenpay.sdk.activity.ActivateTenpayAccount.10
            @Override // com.tenpay.sdk.paynet.Net.NetAdapter, com.tenpay.sdk.paynet.Net.NetListener
            public void onBlError(String str2, JSONObject jSONObject) {
                cVar.invoke(Boolean.FALSE);
            }

            @Override // com.tenpay.sdk.paynet.Net.NetAdapter, com.tenpay.sdk.paynet.Net.NetListener
            public void onError(String str2, JSONObject jSONObject) {
                cVar.invoke(Boolean.FALSE);
            }

            @Override // com.tenpay.sdk.paynet.Net.NetAdapter, com.tenpay.sdk.paynet.Net.NetListener
            public void onSuccess(String str2, JSONObject jSONObject) {
                if (ActivateTenpayAccount.this.isFinishing()) {
                    return;
                }
                if (jSONObject == null) {
                    if (z16) {
                        cVar.invoke(Boolean.FALSE);
                        return;
                    }
                    return;
                }
                WalletGateData.getInstance().setData(com.tencent.mobileqq.base.a.c(), jSONObject, System.currentTimeMillis());
                if (jSONObject.optInt("user_attr") == 2) {
                    cVar.invoke(Boolean.TRUE);
                } else if (z16) {
                    cVar.invoke(Boolean.FALSE);
                }
            }
        });
    }

    private void showContinuePwd() {
        this.mRepeatLayout.setVisibility(0);
        addTraceData("show");
        this.mThirdLayout.setVisibility(8);
        this.mKeyboardWindow.setXMode(3);
        this.mKeyboardWindow.setInputEditText(this.mPassAgainEdit);
        closeTime();
    }

    private Dialog showLoadingDialog() {
        Dialog showLoadingDialog = LoadingUtil.showLoadingDialog(getActivity(), "\u5b9e\u540d\u8ba4\u8bc1\u4e2d", false);
        if (showLoadingDialog != null) {
            showLoadingDialog.show();
        }
        return showLoadingDialog;
    }

    protected void addTraceData(String str) {
        String str2;
        StringBuffer stringBuffer = new StringBuffer();
        if (this.mIsMidas) {
            if (this.mRepeatLayout.getVisibility() == 0) {
                str2 = "tenpay.conpwd.";
            } else if (this.mThirdLayout.getVisibility() == 0) {
                str2 = "tenpay.choosemsg.";
            } else {
                str2 = "tenpay.pwd.";
            }
        } else if (this.mRepeatLayout.getVisibility() == 0) {
            str2 = "setpwd.second.";
        } else if (this.mThirdLayout.getVisibility() == 0) {
            str2 = "bigpay.sms.";
        } else {
            str2 = "setpwd.first.";
        }
        stringBuffer.append(str2);
        stringBuffer.append(str);
        com.tencent.mobileqq.qwallet.c.c(stringBuffer.toString(), Integer.valueOf(getProcessType()));
    }

    public void back() {
        if (this.mRepeatLayout.getVisibility() == 0) {
            this.mActivateLayout.setVisibility(0);
            this.mRepeatLayout.setVisibility(8);
            addTraceData("show");
            this.mPassEdit.setInputText("");
            this.mPassEdit.requestFocus();
            this.mPassAgainEdit.setInputText("");
            this.mKeyboardWindow.setInputEditText(this.mPassEdit);
            this.mKeyboardWindow.setXMode(0);
            return;
        }
        finish();
    }

    protected void closeTime() {
        Timer timer = this.mTimer;
        if (timer != null) {
            timer.cancel();
        }
        mLeftTime = 59;
        this.mThirdResendBtn.setText(getString(R.string.ede));
        this.mThirdResendBtn.setEnabled(true);
        this.mThirdResendBtn.setClickable(true);
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment
    public boolean doOnKeyDown(int i3, KeyEvent keyEvent) {
        if (i3 == 4) {
            MyKeyboardWindow myKeyboardWindow = this.mKeyboardWindow;
            if (myKeyboardWindow != null && myKeyboardWindow.getVisibility() == 0) {
                this.mKeyboardWindow.setVisibility(8);
                return true;
            }
            addTraceData("keyback");
            back();
            return true;
        }
        return super.doOnKeyDown(i3, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tenpay.sdk.activity.TenpayUtilActivity
    public int getProcessType() {
        EnumFrom enumFrom = this.mFrom;
        if (enumFrom == EnumFrom.ID_AUTH) {
            return 154;
        }
        if (this.mIsFromWithdraw) {
            return 127;
        }
        if (this.mUserAttr == 3) {
            if (this.mIsShiMing) {
                return 19;
            }
            return 20;
        }
        if (enumFrom == EnumFrom.BIND_BANK) {
            return 102;
        }
        return 4;
    }

    @Override // com.tenpay.sdk.activity.NetBaseActivity, com.tenpay.sdk.activity.TenpayUtilActivity, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public /* bridge */ /* synthetic */ ViewModel getViewModel(ViewModelStoreOwner viewModelStoreOwner, String str, @NonNull Class cls) {
        return ne0.a.a(this, viewModelStoreOwner, str, cls);
    }

    protected void gotoDepositSuccess(JSONObject jSONObject) {
        Intent intent = new Intent();
        intent.putExtra(CommonCode.MapKey.TRANSACTION_ID, jSONObject.optString(CommonCode.MapKey.TRANSACTION_ID));
        intent.putExtra("pay_time", jSONObject.optString("pay_time"));
        intent.putExtra("bank_info", this.mNewUserDepositObj.optString("bank_info"));
        intent.putExtra("show_true_name", this.mNewUserDepositObj.optString("true_name"));
        intent.putExtra("deposit_count", this.mNewUserDepositObj.optString("deposit_count"));
        intent.putExtra("process_flag", this.mNewUserDepositObj.optString("process_flag"));
        launchFragment(intent, DepositSuccessActivity.class);
        finish();
    }

    protected void initTimer() {
        String str = getString(R.string.ede) + "(" + mLeftTime + ")";
        this.mThirdResendBtn.setClickable(false);
        this.mThirdResendBtn.setEnabled(false);
        this.mThirdResendBtn.setText(str);
        TimerTask timerTask = new TimerTask() { // from class: com.tenpay.sdk.activity.ActivateTenpayAccount.7
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                ActivateTenpayAccount.this.mTimeHandler.sendMessage(new Message());
            }
        };
        Timer timer = this.mTimer;
        if (timer != null) {
            timer.cancel();
            this.mTimer = null;
        }
        BaseTimer baseTimer = new BaseTimer();
        this.mTimer = baseTimer;
        baseTimer.schedule(timerTask, 1000L, 1000L);
    }

    @Override // com.tenpay.sdk.activity.TenpayUtilActivity, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onActivityResult(int i3, int i16, Intent intent) {
        super.onActivityResult(i3, i16, intent);
        QwLog.i("activate tenpay result requestCode = " + i3 + " resultCode = " + i16);
        if (i3 == 101) {
            onFaceVerifyFinish(i16, intent);
        }
    }

    @Override // com.tenpay.sdk.activity.NetBaseActivity, com.tenpay.sdk.paynet.Net.NetListener
    public void onBlError(String str, JSONObject jSONObject) {
        super.onBlError(str, jSONObject);
        if (ErrorCode.ERR_PAY_IVR.equals(jSONObject.optString("retcode"))) {
            com.tencent.mobileqq.qwallet.c.c("pay.hold-up.show", Integer.valueOf(getProcessType()));
            QUIProxy.createCustomDialog(getContext(), 230, null, jSONObject.optString("retmsg"), getString(R.string.e2i), getString(R.string.e2l), new DialogInterface.OnClickListener() { // from class: com.tenpay.sdk.activity.ActivateTenpayAccount.8
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i3) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("uin", ActivateTenpayAccount.this.mUin);
                    hashMap.put("token_id", ActivateTenpayAccount.this.mPayTokenId);
                    ActivateTenpayAccount.this.httpRequest(Cgi.URI_CODE_IVR_CONFIRM, hashMap);
                    com.tencent.mobileqq.qwallet.c.c("pay.hold-up.go", Integer.valueOf(ActivateTenpayAccount.this.getProcessType()));
                }
            }, new DialogInterface.OnClickListener() { // from class: com.tenpay.sdk.activity.ActivateTenpayAccount.9
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i3) {
                    dialogInterface.dismiss();
                    com.tencent.mobileqq.qwallet.c.c("pay.hold-up.cancel", Integer.valueOf(ActivateTenpayAccount.this.getProcessType()));
                }
            });
            return;
        }
        if (Cgi.URI_NONE_CFT_USER_REGISTER_BIND.equals(str)) {
            String optString = jSONObject.optString("retcode");
            if (ErrorCode.ERR_REGISTER_TIME_OUT.equals(optString)) {
                this.mActivateLayout.setVisibility(8);
                this.mRepeatLayout.setVisibility(8);
                this.mThirdLayout.setVisibility(0);
                addTraceData("show");
                this.mKeyboardWindow.setXMode(3);
                this.mKeyboardWindow.setInputEditText(this.mThirdEdit);
                return;
            }
            if (ErrorCode.ERR_PAYPASS_TIMEOUT.equals(optString)) {
                httpRequestNoEncript(Cgi.URI_GET_PASS_TIME, new HashMap());
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        int id5 = view.getId();
        if (id5 == R.id.ivTitleBtnLeft) {
            addTraceData("back");
            back();
        } else if (id5 == R.id.jdq) {
            if (this.mIsMidas) {
                addTraceData("sure");
            } else {
                addTraceData(ResourceAttributes.TelemetrySdkLanguageValues.GO);
            }
            String inputText = this.mPassEdit.getInputText();
            String inputText2 = this.mPassAgainEdit.getInputText();
            if (!Utils.isEmpty(inputText) && !Utils.isEmpty(inputText2)) {
                if (!inputText.equals(inputText2)) {
                    addTraceData("errorback");
                    QQToast.makeText(getContext(), R.string.efx, 0).show();
                    this.mActivateLayout.setVisibility(0);
                    this.mRepeatLayout.setVisibility(8);
                    addTraceData("show");
                    this.mPassEdit.setInputText("");
                    this.mPassAgainEdit.setInputText("");
                    this.mPassEdit.requestFocus();
                    this.mKeyboardWindow.setInputEditText(this.mPassEdit);
                    this.mKeyboardWindow.setXMode(0);
                } else if (this.mIsFromDeposit) {
                    newUserBind_Deposit();
                } else {
                    this.mPassword = this.mPassEdit.getInputText();
                    this.mActivateObj.put("p", this.mPassEdit.getInputText().trim());
                    this.mActivateObj.put("timestamp", this.mTimestamp + "");
                    this.mActivateObj.put("come_from", this.mComeFrom + "");
                    this.mActivateObj.put(com.tencent.mobileqq.msf.core.c0.j.T0, this.mAppInfo + "");
                    int i3 = AnonymousClass11.$SwitchMap$com$tenpay$sdk$activity$ActivateTenpayAccount$EnumFrom[this.mFrom.ordinal()];
                    if (i3 != 1 && i3 != 2) {
                        if (i3 != 3) {
                            if (i3 == 4) {
                                PrivacyTipConfig.e(this.mActivateObj);
                                httpRequest(Cgi.URI_MINORREG_DONE, this.mActivateObj);
                            }
                        } else {
                            RealNameSource realNameSource = this.mRealNameSource;
                            if (realNameSource != null && !TextUtils.isEmpty(realNameSource.getSourceId())) {
                                this.mActivateObj.put("source_id", this.mRealNameSource.getSourceId());
                            }
                            PrivacyTipConfig.e(this.mActivateObj);
                            HashMap hashMap = new HashMap(this.mActivateObj);
                            FaceVerifyBean faceVerifyBean = this.mFaceVerifyBean;
                            if (faceVerifyBean != null) {
                                hashMap.put("token_id", faceVerifyBean.getTokenId());
                                hashMap.put(CGNonAgeReport.EVENT_CHANNEL, this.mFaceVerifyBean.getChannelInfo());
                            }
                            httpRequest(Cgi.URI_QWallet_AUTH, hashMap);
                        }
                    } else {
                        PrivacyTipConfig.e(this.mActivateObj);
                        httpRequest(Cgi.URI_NONE_CFT_USER_REGISTER_BIND, this.mActivateObj);
                    }
                }
            } else {
                QQToast.makeText(getContext(), R.string.efw, 0).show();
            }
        } else if (id5 == R.id.f166961jf2) {
            if (this.mIsMidas) {
                addTraceData("refresh");
            } else {
                addTraceData("reacquire");
            }
            if (this.mFrom == EnumFrom.BIND_BANK) {
                this.mGetYzmObj.put("is_reentry", "1");
            }
            if (this.parentParams.size() > 0) {
                if (this.mGetYzmObj.containsKey("user_info_extend")) {
                    try {
                        JSONObject jSONObject = new JSONObject(this.mGetYzmObj.get("user_info_extend"));
                        for (String str : this.parentParams.keySet()) {
                            jSONObject.put(str, this.parentParams.get(str));
                        }
                        this.mGetYzmObj.put("user_info_extend", jSONObject.toString());
                    } catch (JSONException e16) {
                        QLog.e(((NetBaseActivity) this).TAG, 1, "", e16);
                        this.mGetYzmObj.put("user_info_extend", new JSONObject(this.parentParams).toString());
                    }
                } else {
                    this.mGetYzmObj.put("user_info_extend", new JSONObject(this.parentParams).toString());
                }
            }
            httpRequest(Cgi.URI_NONE_CFT_USER_AUTHEN, this.mGetYzmObj);
        } else if (id5 == R.id.jez) {
            if (this.mIsMidas) {
                addTraceData("sure");
            } else {
                addTraceData(ResourceAttributes.TelemetrySdkLanguageValues.GO);
            }
            String trim = this.mThirdEdit.getText().toString().trim();
            if (Utils.isEmpty(trim)) {
                QQToast.makeText(getContext(), R.string.efz, 0).show();
            } else {
                HashMap<String, String> hashMap2 = this.mActivateObj;
                if (hashMap2 != null) {
                    hashMap2.put("verify_code", trim);
                }
                if ("1".equals(this.mNeedYzCode)) {
                    HashMap<String, String> hashMap3 = this.mExcuteYzObj;
                    if (hashMap3 != null) {
                        hashMap3.put("verify_code", trim);
                    }
                    EnumFrom enumFrom = this.mFrom;
                    if (enumFrom == EnumFrom.BIND_BANK || enumFrom == EnumFrom.BIND_BANK_IN_PAY) {
                        httpRequest(Cgi.URI_NONE_CFT_USER_SMSCODE_VALIDATE, this.mExcuteYzObj);
                    }
                } else {
                    this.mActivateLayout.setVisibility(0);
                    addTraceData("show");
                    this.mKeyboardWindow.setXMode(0);
                    this.mKeyboardWindow.setInputEditText(this.mPassEdit);
                    this.mThirdLayout.setVisibility(8);
                    closeTime();
                }
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tenpay.sdk.activity.TenpayUtilActivity, com.tencent.mobileqq.base.QWalletBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getWindow().addFlags(8192);
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.f168574ad1, viewGroup, false);
        if (getIntent().getSerializableExtra("params") instanceof Map) {
            this.parentParams.putAll((Map) getIntent().getSerializableExtra("params"));
        }
        this.mRealNameSource = (RealNameSource) getIntent().getParcelableExtra(RealNameSource.EXTRA_KEY_SOURCE);
        QwLog.i("ActivateTenpayAccount...");
        this.mIsShiMing = getIntent().getBooleanExtra("IsShiMing", false);
        this.mIsFromWithdraw = getIntent().getBooleanExtra(WithdrawActivity.FROM_WITHDRAW, false);
        boolean booleanExtra = getIntent().getBooleanExtra(DepositStartActivity.FROM_DESPOSIT, false);
        this.mIsFromDeposit = booleanExtra;
        String str = "";
        if (booleanExtra) {
            try {
                this.mNewUserDepositObj = new JSONObject(getIntent().getStringExtra(PARAM_ACTIVATE_ACCOUNT_JSON));
            } catch (JSONException e16) {
                QLog.e(((NetBaseActivity) this).TAG, 1, "", e16);
            }
        } else {
            Bundle bundleExtra = getIntent().getBundleExtra(PARAM_ACTIVATE_ACCOUNT_BUNDLE);
            this.mFrom = EnumFrom.create(getIntent().getIntExtra("from", 0));
            if (this.mAppInfo == null) {
                this.mAppInfo = "";
            }
            if (bundleExtra != null) {
                this.mActivateObj = (HashMap) bundleExtra.getSerializable(PARAM_ACTIVATE_MAP);
                this.mGetYzmObj = (HashMap) bundleExtra.getSerializable("getyzm");
                this.mExcuteYzObj = (HashMap) bundleExtra.getSerializable("excute_yzm");
                this.mNeedYzCode = bundleExtra.getString("need_yz");
            }
        }
        this.mTrustPayOpen = getIntent().getStringExtra("trustpay_open_flag");
        this.mFaceVerifyBean = (FaceVerifyBean) getIntent().getParcelableExtra(PARAM_ACTIVATE_FACE_VERIFY_BEAN);
        MyKeyboardWindow myKeyboardWindow = (MyKeyboardWindow) inflate.findViewById(R.id.je9);
        this.mKeyboardWindow = myKeyboardWindow;
        myKeyboardWindow.setVisibility(0);
        this.mKeyboardWindow.setXMode(0);
        this.mActivateLayout = (LinearLayout) inflate.findViewById(R.id.jdj);
        SixPasswdDialogEditText sixPasswdDialogEditText = (SixPasswdDialogEditText) inflate.findViewById(R.id.jeb);
        this.mPassEdit = sixPasswdDialogEditText;
        sixPasswdDialogEditText.setOnClickListener(this.mSixOnClickListener);
        TextView textView = (TextView) inflate.findViewById(R.id.ivTitleBtnLeft);
        this.mBackBtn = textView;
        textView.setOnClickListener(this);
        this.mKeyboardWindow.setInputEditText(this.mPassEdit);
        this.mPassEdit.setOnPasswdInputListener(this.mOnPasswdInputListener);
        this.mRepeatLayout = (RelativeLayout) inflate.findViewById(R.id.jdi);
        SixPasswdDialogEditText sixPasswdDialogEditText2 = (SixPasswdDialogEditText) inflate.findViewById(R.id.jec);
        this.mPassAgainEdit = sixPasswdDialogEditText2;
        sixPasswdDialogEditText2.setOnClickListener(this.mSixOnClickListener);
        this.mPassAgainEdit.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.tenpay.sdk.activity.ActivateTenpayAccount.4
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView2, int i3, KeyEvent keyEvent) {
                if (keyEvent != null && keyEvent.getKeyCode() == 66) {
                    ActivateTenpayAccount.this.mActivate2Btn.performClick();
                }
                EventCollector.getInstance().onEditorAction(textView2, i3, keyEvent);
                return false;
            }
        });
        this.mPassAgainEdit.setOnPasswdInputListener(this.mOnPasswdInputListener);
        Button button = (Button) inflate.findViewById(R.id.jdq);
        this.mActivate2Btn = button;
        button.setOnClickListener(this);
        this.mActivate2Btn.setEnabled(false);
        this.mActivate2Btn.setClickable(false);
        this.mThirdLayout = (LinearLayout) inflate.findViewById(R.id.f166962jf3);
        EditText editText = (EditText) inflate.findViewById(R.id.f166959jf0);
        this.mThirdEdit = editText;
        QWalletUtils.hideSysKeyBorad(editText);
        this.mThirdEdit.addTextChangedListener(this.mTextWatcher);
        this.mThirdEdit.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.tenpay.sdk.activity.ActivateTenpayAccount.5
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView2, int i3, KeyEvent keyEvent) {
                if (keyEvent != null && keyEvent.getKeyCode() == 66) {
                    ActivateTenpayAccount.this.mNextBtn.performClick();
                }
                EventCollector.getInstance().onEditorAction(textView2, i3, keyEvent);
                return false;
            }
        });
        Button button2 = (Button) inflate.findViewById(R.id.f166961jf2);
        this.mThirdResendBtn = button2;
        button2.setOnClickListener(this);
        Button button3 = (Button) inflate.findViewById(R.id.jez);
        this.mNextBtn = button3;
        button3.setOnClickListener(this);
        this.mNextBtn.setEnabled(false);
        this.mNextBtn.setClickable(false);
        this.mThirdPhoneTextView = (TextView) inflate.findViewById(R.id.f166960jf1);
        Map<String, String> map = this.mGetYzmObj;
        if (map != null) {
            String str2 = map.get(DeviceType.DeviceCategory.MOBILE);
            if (str2 != null && str2.length() == 11) {
                str = (str2.substring(0, 3) + "******") + str2.substring(9, 11);
            }
            this.mThirdPhoneTextView.setText(str);
        }
        addTraceData("show");
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, inflate);
        return inflate;
    }

    @Override // com.tenpay.sdk.activity.NetBaseActivity, com.tenpay.sdk.activity.TenpayUtilActivity, com.tencent.mobileqq.base.QWalletBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        this.mTimeHandler.removeCallbacksAndMessages(null);
        closeTime();
        super.onDestroy();
    }

    @Override // com.tenpay.sdk.activity.NetBaseActivity
    public void onNetDlgokClick(String str, JSONObject jSONObject) {
        super.onNetDlgokClick(str, jSONObject);
        String optString = jSONObject.optString("retcode");
        if (Cgi.URI_NONE_CFT_USER_REGISTER_BIND.equals(str)) {
            if (ErrorCode.ERR_BIND_CARD_PHONE_NOT_SAME.equals(optString)) {
                Intent intent = new Intent();
                intent.putExtra("phone_not_same", 1);
                setResult(-1, intent);
                finish();
                return;
            }
            return;
        }
        if (Cgi.URI_QWallet_AUTH.equals(str)) {
            String optString2 = jSONObject.optString("returl");
            if (!TextUtils.equals(Uri.parse(optString2).getQueryParameter("exitProcess"), "0")) {
                com.tencent.mobileqq.qwallet.c.c("stepwd.second.identify-fail", Integer.valueOf(getProcessType()));
                String optString3 = jSONObject.optString("retmsg");
                Intent intent2 = new Intent();
                intent2.putExtra("retcode", optString);
                intent2.putExtra("retmsg", optString3);
                intent2.putExtra("returl", optString2);
                intent2.putExtra("guardian_check", jSONObject.optString("guardian_check"));
                setResult(1, intent2);
                finish();
            }
        }
    }

    @Override // com.tenpay.sdk.activity.NetBaseActivity, com.tenpay.sdk.activity.TenpayUtilActivity, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    @Deprecated
    public /* bridge */ /* synthetic */ void onPartTimeCostReport(String str, String str2, long j3) {
        ne0.a.e(this, str, str2, j3);
    }

    @Override // com.tenpay.sdk.activity.NetBaseActivity, com.tenpay.sdk.paynet.Net.NetListener
    public void onSuccess(String str, JSONObject jSONObject) {
        IdVerifyStateBean idVerifyStateBean;
        super.onSuccess(str, jSONObject);
        if (str.equals(Cgi.URI_NONE_CFT_USER_SMSCODE_VALIDATE)) {
            BindBankFaceBean bindBankFaceBean = this.mBindBankFaceBean;
            if (bindBankFaceBean != null && bindBankFaceBean.getNeedFace() == 1) {
                QwLog.i("need verify face");
                gotoFaceVerify();
                return;
            } else {
                QwLog.i("not need verify face");
                showContinuePwd();
                return;
            }
        }
        if (str.equals(Cgi.URI_CODE_IVR_CONFIRM)) {
            try {
                jSONObject.put("is_ivr_succ", true);
            } catch (JSONException e16) {
                QLog.e(((NetBaseActivity) this).TAG, 1, "", e16);
            }
            Intent intent = new Intent();
            if (!Utils.isEmpty(jSONObject.optString("real_fee"))) {
                this.mTotalFee = jSONObject.optString("real_fee");
            }
            if (this.mIsRandomCut) {
                this.mPromotionFee = jSONObject.optString("promotion_fee");
            }
            this.mPromotionResult = jSONObject.optString("promotion_result");
            intent.putExtra("success", jSONObject.toString());
            intent.putExtra("process_flag", getProcessType());
            setIntentData(intent);
            com.tencent.mobileqq.qwallet.pay.k.a(getContext(), intent);
            finish();
            return;
        }
        if (str.equals(Cgi.URI_NONE_CFT_USER_AUTHEN)) {
            initTimer();
            this.mBindBankFaceBean = BindBankFaceBean.parseFromUserAuthenRsp(jSONObject);
            return;
        }
        if (str.equals(Cgi.URI_NONE_CFT_USER_REGISTER_BIND)) {
            com.tencent.mobileqq.qwallet.utils.g.l("qwallet_is_pws_enter_" + this.mUin, true);
            MarketServiceUtils.sendMarketServiceSwitch();
            Intent intent2 = new Intent();
            intent2.putExtra("result", jSONObject.toString());
            intent2.putExtra(NotificationActivity.PASSWORD, TenUtils.getEncWithMacPasswd(getContext(), this.mPassEdit.getInputText(), this.mTimestamp));
            RealNameSourceReporter.INSTANCE.reportBindBankGet();
            setResult(-1, intent2);
            finish();
            return;
        }
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
        if (str.equals(Cgi.URI_QWallet_NEWUSER_DEPOSIT)) {
            gotoDepositSuccess(jSONObject);
            return;
        }
        if (str.equals(Cgi.URI_QWallet_AUTH)) {
            afterIdVerifySuccess(jSONObject);
            return;
        }
        if (Cgi.URI_MINORREG_DONE.equals(str)) {
            MarketServiceUtils.sendMarketServiceSwitch();
            try {
                idVerifyStateBean = (IdVerifyStateBean) new GsonBuilder().create().fromJson(jSONObject.toString(), IdVerifyStateBean.class);
            } catch (Exception e17) {
                QLog.w(((NetBaseActivity) this).TAG, 1, "parse IdVerifyStateBean fail: ", e17);
                idVerifyStateBean = null;
            }
            RealNameSourceReporter.INSTANCE.reportIdVerifyGet(true);
            IdVerifyHintModule.startStateBeanHint(this, idVerifyStateBean);
            setResult(-1);
            finish();
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
