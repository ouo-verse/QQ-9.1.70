package com.tencent.mobileqq.qwallet.transaction.impl;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.huawei.hms.adapter.internal.CommonCode;
import com.qwallet.temp.IQWalletTemp;
import com.qwallet.temp.IQwTemp;
import com.tencent.ark.ark;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK;
import com.tencent.hippy.qq.view.scroll.HippyHeaderListViewController;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.RouterConstants;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.msf.core.c0.j;
import com.tencent.mobileqq.profilecard.api.IProfileProtocolConst;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.annotation.RoutePage;
import com.tencent.mobileqq.qwallet.IQWalletApi;
import com.tencent.mobileqq.qwallet.widget.impl.YellowTipsLayout;
import com.tencent.mobileqq.util.x;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.dtreport.api.DefaultTVKDataProvider;
import com.tencent.qqmini.sdk.launcher.core.proxy.PayProxy;
import com.tencent.qqnt.ntrelation.friendsinfo.api.IFriendsInfoService;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tenpay.realname.RealNameSource;
import com.tenpay.realname.api.IRealNameSourceReportApi;
import com.tenpay.sdk.QWalletFakeUrl;
import cooperation.qwallet.plugin.QWalletPayBridge;
import cooperation.qwallet.plugin.impl.QWalletHelperImpl;
import cooperation.qzone.QzoneIPCModule;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.json.JSONObject;

/* compiled from: P */
@RoutePage(desc = "QQ\u94b1\u5305-\u8f6c\u8d26\u754c\u9762", path = "/qwallet/transaction")
/* loaded from: classes16.dex */
public class TransactionActivity extends QBaseActivity implements View.OnClickListener {
    public static final String PREF_NAME_TRANSFER = "transfer";
    public static final String PREF_NAME_TRANSFER_KEY = "is_need_dialog_";
    private static final String TAG = "TransactionActivity";
    private static final String TRANSFER_URL = "https://myun.tenpay.com/mqq/myun/trade/record.shtml?_wv=1027&_wvx=10&jump_type=payment";
    private String callbackSn;
    private ImageView del;
    private EditText mAmoutTxt;
    private String mAppInfo;
    private String mAuthCode;
    private TextView mBackBtn;
    private int mComeFrom;
    private Button mConfirmBtn;
    private Context mContext;
    private String mDesc;
    private boolean mFromJump;
    private String mGroupType;
    private String mGroupUin;
    private String mHistransSign;
    private View mInputScroll;
    private boolean mIsBackKeyPressed;
    private ImageView mLogo;
    private EditText mMemo;
    private int mMinTransferStrangerFee;
    private String mMinTransferStrangerMsg;
    private EditText mPayAmountEdit;
    private View mPayLayout;
    private TextView mPayMemoEdit;
    private String mPayeeNick;
    private String mPayeeUin;
    private TextView mRightView;
    private View mRootScroll;
    private String mSource;
    private String mTag;
    private String mTransFee;
    private int mTransMaxFee;
    private String mTransQuotaMsg;
    private View mTransferLayout;
    private TextView mTransferTips;
    private String mUin;
    private Button mUinBtn;
    private EditText mUinTxt;
    private String mUserNick;
    private TextView mUserNickTxt;
    private View middleLine;
    private String naFromH5Data;
    private LinearLayout root;
    private TextView titleTV;
    private ImageView transferUnit;
    private TextView transferUnitText;
    protected TextWatcher mTextWatcher = new c();
    protected TextWatcher mUinTextWatcher = new d();
    private boolean mIsJumpToH5 = false;
    private boolean isActivityPause = false;
    private long mlastInvalidatetime = 0;
    private boolean mIsStranger = false;
    private int maxWidthNick = 140;
    private boolean mAvoidInput = false;
    d4.b fob = new b();

    /* compiled from: P */
    /* loaded from: classes16.dex */
    class a implements DialogInterface.OnClickListener {
        a() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            dialogInterface.dismiss();
        }
    }

    /* compiled from: P */
    /* loaded from: classes16.dex */
    class b implements d4.b {
        b() {
        }

        @Override // d4.b
        public void a(String str, boolean z16) {
            if (z16 && str != null) {
                TransactionActivity.this.mPayeeNick = ((IQwTemp) QRoute.api(IQwTemp.class)).ContactUtils$getBuddyName(TransactionActivity.this.getAppRuntime(), TransactionActivity.this.mPayeeUin, true);
                String c16 = com.tencent.mobileqq.qwallet.impl.d.c(TransactionActivity.this.mContext, TransactionActivity.this.mPayeeNick, x.c(TransactionActivity.this.mContext, TransactionActivity.this.maxWidthNick), TransactionActivity.this.mUserNickTxt.getPaint());
                TransactionActivity.this.mUserNickTxt.setText(c16 + "(" + TransactionActivity.this.mPayeeUin + ")");
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes16.dex */
    class c extends x05.b {
        c() {
        }

        @Override // x05.b, android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            try {
                if (!TextUtils.isEmpty(editable.toString()) && x05.c.i(editable.toString()) > 0.0f) {
                    TransactionActivity.this.mConfirmBtn.setEnabled(true);
                } else {
                    TransactionActivity.this.mConfirmBtn.setEnabled(false);
                }
                float parseFloat = Float.parseFloat(editable.toString());
                int length = TransactionActivity.this.mAmoutTxt.getText().length();
                String transFeeUint = TransactionActivity.this.getTransFeeUint(parseFloat);
                if (StringUtil.isEmpty(transFeeUint)) {
                    TransactionActivity.this.middleLine.setVisibility(0);
                    TransactionActivity.this.transferUnit.setVisibility(8);
                    TransactionActivity.this.transferUnitText.setVisibility(8);
                } else {
                    TransactionActivity.this.middleLine.setVisibility(8);
                    TransactionActivity.this.transferUnit.setVisibility(0);
                    TransactionActivity.this.transferUnitText.setVisibility(0);
                    TransactionActivity.this.transferUnitText.setText(transFeeUint);
                }
                if (length > 0 && !TransactionActivity.this.mAmoutTxt.getText().toString().startsWith(".") && !TransactionActivity.this.mAmoutTxt.getText().toString().endsWith(".")) {
                    TransactionActivity transactionActivity = TransactionActivity.this;
                    if (transactionActivity.checkWithdrawCount(transactionActivity.mAmoutTxt.getText().toString())) {
                        if (TransactionActivity.this.mTransMaxFee > 0 && !TextUtils.isEmpty(TransactionActivity.this.mTransQuotaMsg) && parseFloat * 100.0f >= TransactionActivity.this.mTransMaxFee && !TextUtils.isEmpty(TransactionActivity.this.mTransQuotaMsg)) {
                            TransactionActivity transactionActivity2 = TransactionActivity.this;
                            transactionActivity2.showToast(transactionActivity2.mTransQuotaMsg);
                        }
                        if (!TransactionActivity.this.mConfirmBtn.isEnabled()) {
                            TransactionActivity.this.mConfirmBtn.setEnabled(true);
                            TransactionActivity transactionActivity3 = TransactionActivity.this;
                            transactionActivity3.addUploadData(transactionActivity3.mUin, 128, "transfer.amount.enable", "", "", TransactionActivity.this.mComeFrom, "");
                            return;
                        }
                        return;
                    }
                }
                if (TransactionActivity.this.mConfirmBtn.isEnabled()) {
                    TransactionActivity.this.mConfirmBtn.setEnabled(false);
                    TransactionActivity transactionActivity4 = TransactionActivity.this;
                    transactionActivity4.addUploadData(transactionActivity4.mUin, 128, "transfer.amount.disable", "", "", TransactionActivity.this.mComeFrom, "");
                }
            } catch (Exception e16) {
                QLog.e(TransactionActivity.TAG, 1, "error msg in qqpay-impl module: ", e16);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes16.dex */
    public class e implements TextView.OnEditorActionListener {
        e() {
        }

        @Override // android.widget.TextView.OnEditorActionListener
        public boolean onEditorAction(TextView textView, int i3, KeyEvent keyEvent) {
            if (i3 == 6 || (keyEvent != null && keyEvent.getKeyCode() == 66)) {
                if (TransactionActivity.this.mConfirmBtn.isEnabled()) {
                    TransactionActivity.this.mConfirmBtn.performClick();
                }
                if (TransactionActivity.this.mContext != null) {
                    ((InputMethodManager) TransactionActivity.this.mContext.getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD)).hideSoftInputFromWindow(TransactionActivity.this.mMemo.getWindowToken(), 0);
                }
            }
            EventCollector.getInstance().onEditorAction(textView, i3, keyEvent);
            return false;
        }
    }

    /* compiled from: P */
    /* loaded from: classes16.dex */
    class f implements DialogInterface.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ SharedPreferences f279233d;

        f(SharedPreferences sharedPreferences) {
            this.f279233d = sharedPreferences;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            this.f279233d.edit().putBoolean(TransactionActivity.PREF_NAME_TRANSFER_KEY + TransactionActivity.this.getApp().getCurrentAccountUin() + TransactionActivity.this.mPayeeUin, false).commit();
            TransactionActivity transactionActivity = TransactionActivity.this;
            transactionActivity.addUploadData(transactionActivity.mUin, 128, "transfer.amount.go", "", "", TransactionActivity.this.mComeFrom, "");
            TransactionActivity.this.sendTransferRequest();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean checkWithdrawCount(String str) {
        if (TextUtils.isEmpty(str) || str.indexOf(46) == 0) {
            return false;
        }
        if (str.indexOf(46) > 0 && str.indexOf(46) < str.length() - 3) {
            return false;
        }
        try {
            double doubleValue = Double.valueOf(str).doubleValue();
            if (doubleValue <= 0.0d) {
                return false;
            }
            if (this.mIsStranger) {
                if (this.mMinTransferStrangerFee > doubleValue * 100.0d) {
                    return false;
                }
                return true;
            }
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public static String div(String str, String str2, int i3) {
        if (i3 < 0) {
            return "0";
        }
        try {
            return new DecimalFormat("#0.00").format(new BigDecimal(str).divide(new BigDecimal(str2), i3, 4).doubleValue());
        } catch (Exception e16) {
            QLog.e(TAG, 1, "error msg in qqpay-impl module: ", e16);
            return "0";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public BaseQQAppInterface getApp() {
        BaseQQAppInterface baseQQAppInterface;
        AppRuntime appRuntime = getAppRuntime();
        if (appRuntime instanceof BaseQQAppInterface) {
            baseQQAppInterface = (BaseQQAppInterface) appRuntime;
        } else {
            baseQQAppInterface = null;
        }
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 4, "getApp, " + baseQQAppInterface);
        }
        return baseQQAppInterface;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getTransFeeUint(float f16) {
        if (f16 >= 1000.0f && f16 <= 9999.0f) {
            return HardCodeUtil.qqStr(R.string.f172790u80);
        }
        if (f16 >= 10000.0f && f16 <= 99999.0f) {
            return HardCodeUtil.qqStr(R.string.f172794u84);
        }
        if (f16 >= 100000.0f && f16 <= 999999.0f) {
            return HardCodeUtil.qqStr(R.string.f172793u83);
        }
        if (f16 >= 1000000.0f && f16 <= 9999999.0f) {
            return HardCodeUtil.qqStr(R.string.f172791u81);
        }
        if (f16 >= 1.0E7f && f16 < 1.0E8f) {
            return HardCodeUtil.qqStr(R.string.u7z);
        }
        return "";
    }

    private void initUI(boolean z16) {
        if (z16) {
            if (!ImmersiveUtils.setStatusTextColor(!QQTheme.isNowThemeIsNight(), getWindow())) {
                getWindow().setStatusBarColor(637534208);
            }
            this.titleTV.setTextColor(getResources().getColor(R.color.qwallet_black_fit_night_mode_color));
            this.root.setBackgroundColor(getResources().getColor(R.color.skin_bg_gray));
            this.mRightView.setVisibility(0);
            this.mRootScroll.setVisibility(0);
            this.mInputScroll.setVisibility(8);
            this.mBackBtn.setCompoundDrawablesWithIntrinsicBounds(R.drawable.qb_tenpay_back_black_normal_support_nightmode, 0, 0, 0);
            return;
        }
        if (!ImmersiveUtils.setStatusTextColor(false, getWindow())) {
            getWindow().setStatusBarColor(0);
        }
        this.root.setBackground(new GradientDrawable(GradientDrawable.Orientation.TL_BR, new int[]{getResources().getColor(R.color.f157661w0), getResources().getColor(R.color.f157660vz)}));
        this.titleTV.setTextColor(-1);
        this.mRightView.setVisibility(8);
        this.mRootScroll.setVisibility(8);
        this.mInputScroll.setVisibility(0);
        this.mBackBtn.setCompoundDrawablesWithIntrinsicBounds(R.drawable.fsc, 0, 0, 0);
    }

    private void initYellowTips() {
        YellowTipsLayout yellowTipsLayout = (YellowTipsLayout) findViewById(R.id.f7b);
        if (yellowTipsLayout != null && yellowTipsLayout.b()) {
            this.mRootScroll.setPadding(0, 0, 0, 0);
        }
    }

    private void preMConnect() {
        Bundle bundle = new Bundle();
        bundle.putString("uin", this.mUin);
        bundle.putInt(QWalletPayBridge.Key.PAY_INVOKER_ID, 21);
        QWalletPayBridge.launchBackground(MobileQQ.sMobileQQ, bundle);
    }

    private void sendPush(String str) {
        if (!this.mFromJump) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("TargetUin", this.mPayeeUin);
            jSONObject.put("PayeeNick", this.mUserNick);
            jSONObject.put(DefaultTVKDataProvider.KEY_PAY_STATUS, str);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("userId", this.mUin);
            jSONObject2.put(HippyHeaderListViewController.VIEW_TAG, "transferPush");
            jSONObject2.put(PayProxy.Source.PAY_REQUEST_PAY_COME_FROM, this.mComeFrom);
            jSONObject2.put("appInfo", this.mAppInfo);
            jSONObject2.put("extra_data", jSONObject.toString());
            tenpay(this, jSONObject2.toString(), 5, "0");
        } catch (Exception e16) {
            QLog.e(TAG, 1, "error msg in qqpay-impl module: ", e16);
        }
    }

    private void tenpay(Activity activity, String str, int i3, String str2) {
        if (activity != null && str != null) {
            Bundle bundle = new Bundle();
            bundle.putString(ark.ARKMETADATA_JSON, str);
            bundle.putString("callbackSn", str2);
            Intent payBridgeIntent = ((IQWalletApi) QRoute.api(IQWalletApi.class)).getPayBridgeIntent(activity);
            payBridgeIntent.putExtras(bundle);
            payBridgeIntent.putExtra("pay_requestcode", i3);
            if (QLog.isColorLevel()) {
                QLog.i(TAG, 2, "tenpay startActivity and request=" + bundle.toString() + ",requestCode=" + i3);
            }
            activity.startActivityForResult(payBridgeIntent, i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateTransferTips() {
        final String str;
        if (this.mIsStranger) {
            if (TextUtils.isEmpty(this.mMinTransferStrangerMsg)) {
                str = "\u5411\u964c\u751f\u4eba\u8f6c\u8d26\u6700\u4f4e1.00\u5143\uff01";
            } else {
                str = this.mMinTransferStrangerMsg;
            }
            ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.qwallet.transaction.impl.TransactionActivity.4
                @Override // java.lang.Runnable
                public void run() {
                    TransactionActivity.this.mTransferTips.setText(TransactionActivity.this.getString(R.string.e9l) + "\uff08" + str + "\uff09");
                }
            });
            return;
        }
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.qwallet.transaction.impl.TransactionActivity.5
            @Override // java.lang.Runnable
            public void run() {
                TransactionActivity.this.mTransferTips.setText(TransactionActivity.this.getString(R.string.e9l));
            }
        });
    }

    private String yuan2Fen(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return new DecimalFormat("#").format(new BigDecimal(str).multiply(new BigDecimal("100")).doubleValue());
        } catch (Exception unused) {
            return "";
        }
    }

    public void addUploadData(String str, int i3, String str2, String str3, String str4, int i16, String str5) {
        com.tencent.mobileqq.qwallet.c.c(str2, Integer.valueOf(i3));
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, false, true);
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, dispatchTouchEvent, false);
        return dispatchTouchEvent;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0066 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // mqq.app.AppActivity
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void doOnActivityResult(int i3, int i16, Intent intent) {
        JSONObject jSONObject;
        super.doOnActivityResult(i3, i16, intent);
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "onActivityResult doOnActivityResult: " + i3 + ", resultCode: " + i16 + ", intent: " + intent);
        }
        this.isActivityPause = false;
        if (intent != null && i16 == -1) {
            String stringExtra = intent.getStringExtra("result");
            JSONObject jSONObject2 = null;
            if (stringExtra != null && stringExtra.length() > 0) {
                try {
                    jSONObject = new JSONObject(stringExtra);
                } catch (Exception e16) {
                    QLog.e(TAG, 1, "error msg in qqpay-impl module: ", e16);
                }
                if (jSONObject != null) {
                    try {
                        i16 = jSONObject.optInt(QzoneIPCModule.RESULT_CODE, -1);
                        jSONObject2 = new JSONObject(jSONObject.optString("retmsg"));
                    } catch (Exception e17) {
                        QLog.e(TAG, 1, "error msg in qqpay-impl module: ", e17);
                    }
                }
                if (i16 != 0 && jSONObject2 != null) {
                    if (i3 == 5) {
                        String optString = jSONObject2.optString("callback_url");
                        if (TextUtils.isEmpty(optString)) {
                            return;
                        }
                        StringBuffer stringBuffer = new StringBuffer(Uri.decode(optString));
                        String optString2 = jSONObject2.optString("sp_data");
                        if (!TextUtils.isEmpty(optString2)) {
                            stringBuffer.append("&sp_data=");
                            stringBuffer.append(optString2);
                        }
                        String optString3 = jSONObject2.optString(CommonCode.MapKey.TRANSACTION_ID);
                        if (!TextUtils.isEmpty(optString3)) {
                            stringBuffer.append("&transaction_id=");
                            stringBuffer.append(optString3);
                        }
                        String optString4 = jSONObject2.optString("total_fee");
                        if (!TextUtils.isEmpty(optString4)) {
                            stringBuffer.append("&total_fee=");
                            stringBuffer.append(optString4);
                        }
                        String optString5 = jSONObject2.optString("pay_time");
                        if (!TextUtils.isEmpty(optString5)) {
                            stringBuffer.append("&pay_time=");
                            stringBuffer.append(optString5);
                        }
                        JSONObject jSONObject3 = new JSONObject();
                        try {
                            JSONObject jSONObject4 = new JSONObject();
                            jSONObject4.put("callback_url", stringBuffer.toString());
                            jSONObject4.put("exec_code", jSONObject2.optString("exec_code"));
                            jSONObject4.put("uin", this.mPayeeUin);
                            jSONObject4.put("url", stringBuffer.toString());
                            jSONObject3.put(QzoneIPCModule.RESULT_CODE, 0);
                            jSONObject3.put("retmsg", "SUCCESS");
                            if (this.mComeFrom == 5) {
                                jSONObject3.put("retdata", jSONObject4);
                            } else {
                                jSONObject3.put("data", jSONObject4);
                            }
                        } catch (Exception unused) {
                        }
                        if (this.mIsJumpToH5) {
                            x05.c.h(this, stringBuffer.toString());
                        }
                        Intent intent2 = new Intent();
                        intent2.putExtra("callbackSn", this.callbackSn);
                        intent2.putExtra(QWalletPayBridge.Key.PAY_INVOKER_ID, 5);
                        intent2.putExtra("result", jSONObject3.toString());
                        setResult(-1, intent2);
                        finish();
                        return;
                    }
                    return;
                }
                if (i16 <= 0 && jSONObject != null) {
                    String optString6 = jSONObject.optString("retmsg");
                    if (!TextUtils.isEmpty(optString6)) {
                        QQToast.makeText(this.mContext, optString6, 0).show();
                        return;
                    }
                    return;
                }
            }
            jSONObject = null;
            if (jSONObject != null) {
            }
            if (i16 != 0) {
            }
            if (i16 <= 0) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public boolean doOnCreate(Bundle bundle) {
        this.mActNeedImmersive = false;
        super.doOnCreate(bundle);
        ((IRealNameSourceReportApi) QRoute.api(IRealNameSourceReportApi.class)).setCurrentNameSource(new RealNameSource("17"));
        setProgressBarIndeterminateVisibility(false);
        setRequestedOrientation(1);
        this.mContext = this;
        ((IQWalletTemp) QRoute.api(IQWalletTemp.class)).addQBaseActivityObserver(this, this.fob);
        try {
            BaseQQAppInterface app = getApp();
            if (app != null) {
                this.mUin = app.getCurrentAccountUin();
                this.mUserNick = app.getCurrentNickname();
            }
            this.mComeFrom = getIntent().getIntExtra("come_from", 1);
            this.mIsJumpToH5 = getIntent().getBooleanExtra("isJumpToH5", false);
            this.callbackSn = getIntent().getStringExtra("callbackSn");
            this.mAppInfo = getIntent().getStringExtra(j.T0);
            this.mFromJump = getIntent().getBooleanExtra("fromJump", false);
            this.mTag = getIntent().getStringExtra("tag");
            this.mAvoidInput = getIntent().getBooleanExtra("avoidInput", false);
            this.mAuthCode = getIntent().getStringExtra("authCode");
            JSONObject jSONObject = new JSONObject(getIntent().getStringExtra("extra_data"));
            this.mPayeeUin = jSONObject.optString(IProfileProtocolConst.PARAM_TARGET_UIN);
            this.mPayeeNick = jSONObject.optString("targetNickname");
            this.mTransFee = jSONObject.optString("trans_fee");
            this.mDesc = jSONObject.optString("desc");
            this.mHistransSign = jSONObject.optString("sign");
            this.mSource = jSONObject.optString("source");
            this.mGroupType = jSONObject.optString("group_type");
            this.mGroupUin = jSONObject.optString("group_uin");
            this.naFromH5Data = jSONObject.optString("na_from_h5_data");
        } catch (Exception e16) {
            QLog.e(TAG, 1, "error msg in qqpay-impl module: ", e16);
        }
        initView();
        sendPush("1");
        ThreadManager.getFileThreadHandler().post(new Runnable() { // from class: com.tencent.mobileqq.qwallet.transaction.impl.TransactionActivity.3
            @Override // java.lang.Runnable
            public void run() {
                JSONObject optJSONObject;
                try {
                    JSONObject loadUnifiedConfig = QWalletHelperImpl.loadUnifiedConfig(TransactionActivity.this.mContext);
                    if (loadUnifiedConfig != null && (optJSONObject = loadUnifiedConfig.optJSONObject("qpayment")) != null) {
                        TransactionActivity.this.mTransMaxFee = optJSONObject.optInt("large_transfer_remind_fee");
                        TransactionActivity.this.mTransQuotaMsg = optJSONObject.optString("large_transfer_remind_msg");
                        TransactionActivity.this.mMinTransferStrangerFee = optJSONObject.optInt("min_transfer_stranger_fee");
                        TransactionActivity.this.mMinTransferStrangerMsg = optJSONObject.optString("min_transfer_stranger_msg");
                        TransactionActivity.this.updateTransferTips();
                    }
                } catch (Exception e17) {
                    QLog.e(TransactionActivity.TAG, 1, "error msg in qqpay-impl module: ", e17);
                }
            }
        });
        if (QWalletHelperImpl.isNeedPreConnect(this.mContext, this.mUin, "type_mqq_and_myun")) {
            preMConnect();
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnDestroy() {
        ((IQWalletTemp) QRoute.api(IQWalletTemp.class)).removeQBaseActivityObserver(this, this.fob);
        super.doOnDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnPause() {
        super.doOnPause();
        this.isActivityPause = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnResume() {
        super.doOnResume();
        try {
            getWindow().setSoftInputMode(16);
            this.isActivityPause = false;
            if (this.mInputScroll.getVisibility() == 0) {
                addUploadData(this.mUin, 128, "transfer.qqid.show", "", "", this.mComeFrom, "");
            } else {
                addUploadData(this.mUin, 128, "transfer.amount.show", "", "", this.mComeFrom, "");
            }
        } catch (Exception e16) {
            QLog.e(TAG, 1, "error msg in qqpay-impl module: ", e16);
        }
    }

    public int getTitleBarHeight(Context context) {
        try {
            return context.getResources().getDimensionPixelSize(R.dimen.title_bar_height) - ((int) (context.getResources().getDisplayMetrics().density * 5.0f));
        } catch (Exception unused) {
            return 0;
        }
    }

    protected void initView() {
        String string;
        try {
            setContentView(R.layout.ccs);
        } catch (Exception e16) {
            QLog.e(TAG, 1, "error msg in qqpay-impl module: ", e16);
            finish();
        }
        this.root = (LinearLayout) findViewById(R.id.root);
        this.mPayLayout = findViewById(R.id.ggr);
        this.mTransferLayout = findViewById(R.id.ghp);
        this.mRootScroll = findViewById(R.id.root_layout);
        this.mInputScroll = findViewById(R.id.a9v);
        initYellowTips();
        TextView textView = (TextView) findViewById(R.id.ivTitleBtnLeft);
        this.mBackBtn = textView;
        textView.setVisibility(0);
        this.mBackBtn.setOnClickListener(this);
        this.titleTV = (TextView) findViewById(R.id.ivTitleName);
        this.transferUnit = (ImageView) findViewById(R.id.mbc);
        this.middleLine = findViewById(R.id.f166254ew0);
        this.transferUnitText = (TextView) findViewById(R.id.mbd);
        this.mAmoutTxt = (EditText) findViewById(R.id.f164306ro);
        this.mPayAmountEdit = (EditText) findViewById(R.id.fj7);
        EditText editText = (EditText) findViewById(R.id.jef);
        this.mUinTxt = editText;
        editText.addTextChangedListener(this.mUinTextWatcher);
        this.mAmoutTxt.addTextChangedListener(this.mTextWatcher);
        EditText editText2 = this.mAmoutTxt;
        editText2.addTextChangedListener(new bl2.e(editText2));
        this.mPayAmountEdit.addTextChangedListener(this.mTextWatcher);
        this.mMemo = (EditText) findViewById(R.id.f166224ep1);
        this.mPayMemoEdit = (TextView) findViewById(R.id.fji);
        this.mMemo.setOnEditorActionListener(new e());
        Button button = (Button) findViewById(R.id.jvd);
        this.mConfirmBtn = button;
        button.setOnClickListener(this);
        this.mConfirmBtn.setEnabled(false);
        if (QQTheme.isNowSimpleUI()) {
            this.mConfirmBtn.setTypeface(Typeface.defaultFromStyle(0));
        } else {
            this.mConfirmBtn.setTypeface(Typeface.defaultFromStyle(1));
        }
        Button button2 = (Button) findViewById(R.id.je_);
        this.mUinBtn = button2;
        button2.setOnClickListener(this);
        this.mUinBtn.setEnabled(false);
        this.mUinBtn.setClickable(false);
        this.mLogo = (ImageView) findViewById(R.id.jey);
        this.mUserNickTxt = (TextView) findViewById(R.id.jex);
        String c16 = com.tencent.mobileqq.qwallet.impl.d.c(this.mContext, this.mPayeeNick, x.c(r1, this.maxWidthNick), this.mUserNickTxt.getPaint());
        this.mUserNickTxt.setText(c16 + "(" + this.mPayeeUin + ")");
        ImageView imageView = (ImageView) findViewById(R.id.jve);
        this.del = imageView;
        imageView.setOnClickListener(this);
        TextView textView2 = (TextView) findViewById(R.id.ivTitleBtnRightText);
        this.mRightView = textView2;
        textView2.setVisibility(0);
        this.mRightView.setText(HardCodeUtil.qqStr(R.string.f172792u82));
        this.mRightView.setOnClickListener(this);
        if (QWalletFakeUrl.FAKEURL_TRANSFERINPUT.equals(this.mTag)) {
            initUI(false);
            this.titleTV.setText(R.string.ecr);
            getWindow().setWindowAnimations(R.style.actAnimation);
            this.mUinTxt.requestFocus();
            if (!TextUtils.isEmpty(this.mPayeeUin)) {
                this.mUinTxt.setText(this.mPayeeUin);
                this.mUinTxt.setSelection(this.mPayeeUin.length());
            }
            this.mSource = "3";
            this.mComeFrom = 2;
            if (this.mAvoidInput && !TextUtils.isEmpty(this.mPayeeUin)) {
                this.mUinBtn.performClick();
            } else {
                new Handler().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.qwallet.transaction.impl.TransactionActivity.7
                    @Override // java.lang.Runnable
                    public void run() {
                        MotionEvent obtain = MotionEvent.obtain(SystemClock.uptimeMillis(), SystemClock.uptimeMillis(), 0, 0.0f, 0.0f, 0);
                        TransactionActivity.this.mUinTxt.dispatchTouchEvent(obtain);
                        MotionEvent obtain2 = MotionEvent.obtain(SystemClock.uptimeMillis(), SystemClock.uptimeMillis(), 1, 0.0f, 0.0f, 0);
                        TransactionActivity.this.mUinTxt.dispatchTouchEvent(obtain2);
                        obtain.recycle();
                        obtain2.recycle();
                    }
                }, 100L);
            }
        } else {
            initUI(true);
            if (((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).isFriend(((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(this.mPayeeUin), TAG)) {
                string = getString(R.string.eei);
            } else {
                string = getString(R.string.eek);
                this.mIsStranger = true;
            }
            int i3 = this.mComeFrom;
            if (i3 == 2) {
                string = string + getString(R.string.eem);
                this.mConfirmBtn.setText(getString(R.string.eep));
            } else if (i3 == 5) {
                string = string + getString(R.string.eel);
                this.mConfirmBtn.setText(getString(R.string.eeu));
            }
            if (!TextUtils.isEmpty(this.mTransFee)) {
                if (!TextUtils.isEmpty(this.mDesc)) {
                    this.mPayMemoEdit.setText(this.mDesc);
                }
                if (!TextUtils.isEmpty(this.mTransFee)) {
                    String div = div(this.mTransFee, "100", 2);
                    this.mTransFee = div;
                    this.mPayAmountEdit.setText(div);
                }
                this.root.setBackgroundResource(R.drawable.qui_common_bg_bottom_light_bg);
                this.mPayLayout.setVisibility(0);
                this.mTransferLayout.setVisibility(8);
                this.mConfirmBtn.setEnabled(true);
            } else {
                this.root.setBackgroundColor(getResources().getColor(R.color.skin_bg_gray));
                this.mAmoutTxt.requestFocus();
                this.mTransferLayout.setVisibility(0);
                this.mPayLayout.setVisibility(8);
                new Handler().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.qwallet.transaction.impl.TransactionActivity.8
                    @Override // java.lang.Runnable
                    public void run() {
                        MotionEvent obtain = MotionEvent.obtain(SystemClock.uptimeMillis(), SystemClock.uptimeMillis(), 0, 0.0f, 0.0f, 0);
                        TransactionActivity.this.mAmoutTxt.dispatchTouchEvent(obtain);
                        MotionEvent obtain2 = MotionEvent.obtain(SystemClock.uptimeMillis(), SystemClock.uptimeMillis(), 1, 0.0f, 0.0f, 0);
                        TransactionActivity.this.mAmoutTxt.dispatchTouchEvent(obtain2);
                        obtain.recycle();
                        obtain2.recycle();
                    }
                }, 100L);
            }
            this.titleTV.setText(string);
            this.mLogo.setImageDrawable(FaceDrawable.getFaceDrawable(getApp(), 1, this.mPayeeUin));
        }
        this.mTransferTips = (TextView) findViewById(R.id.jvf);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        int id5 = view.getId();
        if (id5 == R.id.ivTitleBtnLeft) {
            if (QWalletFakeUrl.FAKEURL_TRANSFERINPUT.equals(this.mTag) && this.mRootScroll.getVisibility() == 0 && !this.mAvoidInput) {
                if (this.mIsBackKeyPressed) {
                    addUploadData(this.mUin, 128, "transfer.qqid.keyback", "", "", this.mComeFrom, "");
                } else {
                    addUploadData(this.mUin, 128, "transfer.qqid.back", "", "", this.mComeFrom, "");
                }
                this.mUinTxt.requestFocus();
                initUI(false);
                this.mPayeeNick = null;
                this.mLogo.setImageDrawable(null);
                this.mUserNickTxt.setText("");
                this.titleTV.setText(R.string.eej);
            } else {
                if (this.mIsBackKeyPressed) {
                    addUploadData(this.mUin, 128, "transfer.amout.keyback", "", "", this.mComeFrom, "");
                } else {
                    addUploadData(this.mUin, 128, "transfer.amount.back", "", "", this.mComeFrom, "");
                }
                sendPush("2");
                sendCallback(-1, null);
                Context context = this.mContext;
                if (context != null) {
                    ((InputMethodManager) context.getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD)).hideSoftInputFromWindow(this.mMemo.getWindowToken(), 0);
                }
                finish();
            }
        } else if (id5 == R.id.ivTitleBtnRightText) {
            if (!TextUtils.isEmpty("https")) {
                String lowerCase = "https".toLowerCase();
                if (lowerCase.compareTo("http") == 0 || lowerCase.compareTo("https") == 0) {
                    Intent intent = new Intent();
                    intent.putExtra("url", TRANSFER_URL);
                    intent.putExtra("startOpenPageTime", System.currentTimeMillis());
                    RouteUtils.startActivityForResult(this, intent, RouterConstants.UI_ROUTE_BROWSER, -1);
                }
            }
        } else if (id5 == R.id.jvd) {
            long currentTimeMillis = System.currentTimeMillis();
            if (this.mlastInvalidatetime + 1000 < currentTimeMillis) {
                SharedPreferences sharedPreferences = getSharedPreferences(PREF_NAME_TRANSFER, 0);
                if (sharedPreferences.getBoolean(PREF_NAME_TRANSFER_KEY + this.mUin + this.mPayeeUin, true)) {
                    DialogUtil.createCustomDialog(this.mContext, 233, (String) null, getString(R.string.eeq), R.string.cancel, R.string.hkj, new f(sharedPreferences), new a()).show();
                } else {
                    addUploadData(this.mUin, 128, "transfer.amount.go", "", "", this.mComeFrom, "");
                    sendTransferRequest();
                }
                this.mlastInvalidatetime = currentTimeMillis;
            }
        } else if (id5 == R.id.je_) {
            BaseQQAppInterface app = getApp();
            this.mPayeeUin = this.mUinTxt.getText().toString();
            initUI(true);
            this.mAmoutTxt.requestFocus();
            String ContactUtils$getBuddyName = ((IQwTemp) QRoute.api(IQwTemp.class)).ContactUtils$getBuddyName(app, this.mPayeeUin, true);
            this.mPayeeNick = ContactUtils$getBuddyName;
            String c16 = com.tencent.mobileqq.qwallet.impl.d.c(this.mContext, ContactUtils$getBuddyName, x.c(r1, this.maxWidthNick), this.mUserNickTxt.getPaint());
            this.mUserNickTxt.setText(c16 + "(" + this.mPayeeUin + ")");
            this.mLogo.setImageDrawable(FaceDrawable.getFaceDrawable(app, 1, this.mPayeeUin));
            addUploadData(this.mUin, 128, "transfer.qqid.next", "", "", this.mComeFrom, "");
            String str = getString(R.string.eek) + getString(R.string.eem);
            if (QWalletFakeUrl.FAKEURL_TRANSFERINPUT.equals(this.mTag) && app != null) {
                if (((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).isFriend(((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(this.mPayeeUin), TAG)) {
                    str = getString(R.string.eei) + getString(R.string.eem);
                    this.mIsStranger = false;
                } else {
                    this.mIsStranger = true;
                }
            }
            this.titleTV.setText(str);
            updateTransferTips();
            this.mAmoutTxt.setText("");
        } else if (id5 == R.id.jve) {
            this.mAmoutTxt.setText("");
            this.middleLine.setVisibility(0);
            this.transferUnit.setVisibility(8);
            this.transferUnitText.setVisibility(8);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }

    @Override // mqq.app.AppActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i3, KeyEvent keyEvent) {
        if (i3 == 4) {
            this.mIsBackKeyPressed = true;
            this.mBackBtn.performClick();
            return true;
        }
        return super.onKeyDown(i3, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.AppActivity
    public void requestWindowFeature(Intent intent) {
        requestWindowFeature(1);
    }

    public void sendCallback(int i3, Bundle bundle) {
        if (bundle == null) {
            new Bundle();
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(QzoneIPCModule.RESULT_CODE, i3);
        } catch (Exception unused) {
        }
        Intent intent = new Intent();
        intent.putExtra("callbackSn", this.callbackSn);
        intent.putExtra(QWalletPayBridge.Key.PAY_INVOKER_ID, 5);
        intent.putExtra("result", jSONObject.toString());
        setResult(-1, intent);
    }

    protected void sendTransferRequest() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("PayeeUin", this.mPayeeUin);
            jSONObject.put("PayeeNick", this.mPayeeNick);
            if (!TextUtils.isEmpty(this.mTransFee)) {
                jSONObject.put("Amout", yuan2Fen(this.mTransFee));
                jSONObject.put("Memo", this.mDesc);
            } else {
                jSONObject.put("Amout", yuan2Fen(this.mAmoutTxt.getText().toString()));
                jSONObject.put("Memo", this.mMemo.getText().toString());
            }
            jSONObject.put("ComeFrom", this.mComeFrom);
            jSONObject.put("HistransSign", this.mHistransSign);
            jSONObject.put("source", this.mSource);
            jSONObject.put("group_type", this.mGroupType);
            jSONObject.put("group_uin", this.mGroupUin);
            jSONObject.put("na_from_h5_data", this.naFromH5Data);
            jSONObject.put("h5_success", true);
            jSONObject.put("authCode", this.mAuthCode);
            JSONObject jSONObject2 = new JSONObject();
            if (QWalletFakeUrl.FAKEURL_TRANSFERINPUT.equals(this.mTag)) {
                jSONObject2.put("getpayee_type", 1);
                jSONObject2.put("payee_uin", this.mPayeeUin);
                jSONObject2.put("payee_nick", this.mPayeeNick);
            }
            jSONObject2.put("fromPage", "AioTransfer");
            jSONObject.put("transPay_data", jSONObject2.toString());
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("userId", this.mUin);
            jSONObject3.put(HippyHeaderListViewController.VIEW_TAG, "transferInfor");
            jSONObject3.put(PayProxy.Source.PAY_REQUEST_PAY_COME_FROM, this.mComeFrom);
            jSONObject3.put("appInfo", this.mAppInfo);
            jSONObject3.put("extra_data", jSONObject.toString());
            tenpay(this, jSONObject3.toString(), 5, "0");
        } catch (Exception e16) {
            QLog.e(TAG, 1, "error msg in qqpay-impl module: ", e16);
        }
    }

    public void showToast(CharSequence charSequence) {
        if (!this.isActivityPause && !isFinishing()) {
            QQToast.makeText(this, charSequence, 0).show(getTitleBarHeight(this.mContext));
        }
    }

    /* compiled from: P */
    /* loaded from: classes16.dex */
    class d implements TextWatcher {
        d() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            if (TransactionActivity.this.mUinTxt.getText().length() > 4) {
                if (!TransactionActivity.this.mUinBtn.isEnabled()) {
                    TransactionActivity.this.mUinBtn.setEnabled(true);
                    TransactionActivity.this.mUinBtn.setClickable(true);
                    TransactionActivity transactionActivity = TransactionActivity.this;
                    transactionActivity.addUploadData(transactionActivity.mUin, 128, "transfer.qqid.enable", "", "", TransactionActivity.this.mComeFrom, "");
                    return;
                }
                return;
            }
            if (TransactionActivity.this.mUinBtn.isEnabled()) {
                TransactionActivity.this.mUinBtn.setClickable(false);
                TransactionActivity.this.mUinBtn.setEnabled(false);
                TransactionActivity transactionActivity2 = TransactionActivity.this;
                transactionActivity2.addUploadData(transactionActivity2.mUin, 128, "transfer.qqid.disable", "", "", TransactionActivity.this.mComeFrom, "");
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
        }
    }
}
