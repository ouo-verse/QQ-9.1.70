package com.tenpay.sdk.activity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.media.SoundPool;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelStoreOwner;
import com.huawei.hms.adapter.internal.CommonCode;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.RouterConstants;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.api.IQWalletUnitedConfigApi;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.soter.core.model.SoterSignatureResult;
import com.tencent.soter.wrapper.SoterWrapperApi;
import com.tencent.soter.wrapper.wrap_biometric.SoterBiometricCanceller;
import com.tencent.soter.wrapper.wrap_callback.SoterProcessAuthenticationResult;
import com.tencent.soter.wrapper.wrap_callback.SoterProcessCallback;
import com.tencent.soter.wrapper.wrap_task.AuthenticationParam;
import com.tencent.thread.monitor.plugin.proxy.BaseTimer;
import com.tencent.youtu.sdkkitframework.common.StateEvent;
import com.tenpay.ErrorCode;
import com.tenpay.QwLog;
import com.tenpay.api.QFuncProxy;
import com.tenpay.api.TenpayInterface;
import com.tenpay.bank.BindBankModule;
import com.tenpay.compat.SoterBiometricStateCallbackCompat;
import com.tenpay.fingerpay.FingerPaySettingSwitchFragment;
import com.tenpay.impl.ApiFingerImpl;
import com.tenpay.ndk.CertUtil;
import com.tenpay.proxy.QQProxyDialog;
import com.tenpay.proxy.QUIProxy;
import com.tenpay.sdk.Cgi;
import com.tenpay.sdk.QWalletFakeUrl;
import com.tenpay.sdk.helper.SharedHelper;
import com.tenpay.sdk.net.NetUtil;
import com.tenpay.sdk.util.QWSoterConstans;
import com.tenpay.sdk.util.TenUtils;
import com.tenpay.sdk.view.SixPasswdDialogEditText;
import com.tenpay.util.MD5;
import com.tenpay.util.Utils;
import cooperation.qwallet.plugin.FakeUrl;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes27.dex */
public abstract class BasePayActivity extends NetBaseActivity {
    public static int CHOOSE_PRICECUT_RESULT_CODE = 2017;
    public static int ChangePhoneNum_RESULT_CODE = 2003;
    public static int ChangeValidDate_RESULT_CODE = 2002;
    protected static final int ONE_MINUTE = 59;
    public static int OpenCTPay_RESULT_CODE = 2005;
    public static final String PAY_SCENE_SOCIAL = "social";
    public static int REQUEST_CODE_BIND_BANK = 2019;
    public static int REQUEST_CODE_CHOOSE_PAY_CHANNEL = 2018;
    public static int ResetPassBridge_RESULT_CODE = 2006;
    public static int ResetPass_RESULT_CODE = 1003;
    public static int ShiMing_RESULT_CODE = 1002;
    public static final long TIME_LAZY_FINISH = 500;
    public static final int WINDOW_STYLE_FINGERPAY = 1;
    public static final int WINDOW_STYLE_NOPASSPAY = 2;
    public static final int WINDOW_STYLE_PASSPAY = 0;
    protected static int mLeftTime = 59;
    protected JSONObject busi_switch;
    protected String buyer_uin;
    protected String headPath;
    protected int iPayFrom;
    protected boolean isFriendPay;
    protected boolean isInner;
    protected boolean isNeedRestartFingerPay;
    protected boolean isPaySkinCanUse;
    protected boolean isShowingVerifyCodeView;
    protected boolean isSoterOpened;
    protected long mBalance;
    protected Boolean mChangePhoneNum;
    protected Boolean mChangeValidDate;
    protected long mCurrentTime;
    private QQProxyDialog mDetectDialog;
    protected SoterSignatureResult mFingerAuthenResult;
    protected boolean mIsAccountUpgrade;
    protected boolean mIsFromConFirmTrans;
    protected boolean mIsSixPasswdUser;
    protected HashMap<String, Integer> mMusicIds;
    protected String mNewPhoneNum;
    protected EditText mNormalPasswdEdit;
    protected String mOldPhoneNum;
    protected JSONObject mPayGateObj;
    protected String mPhoneNumCVV;
    private final BroadcastReceiver mPwdChangeReceiver;
    protected String mSelectBankSerial;
    protected String mShowCvv;
    protected SixPasswdDialogEditText mSixPasswdEdit;
    protected SoterBiometricCanceller mSoterBiometricCanceller;
    protected List<String> mSoterOpenFid;
    protected Timer mTimer;
    protected String mTrans_Id;
    protected String mValidDate;
    protected String mValidDateCVV;
    protected int mWindowStyle;
    protected String offerid;
    protected int order_type;
    protected List<Bitmap> passIconBp;
    protected String pay_scene;
    protected String soter_open_text;
    protected SoundPool soundPool;
    protected int SOTER_OPEN_FLAG = -1;
    protected int mSelectedPayType = -1;
    protected int mSelectedPayBankIndex = -1;
    protected int mTouchidRetryCount = 0;
    protected int mPassAnimDuration = 300;
    protected int mIsCallback = 0;
    protected JSONObject mPaySuccessObj = null;
    protected String mTrustPayOpen = "";
    protected boolean mWaitingConfirm = true;
    protected int soter_open_flag = -1;

    public BasePayActivity() {
        Boolean bool = Boolean.FALSE;
        this.mChangeValidDate = bool;
        this.mChangePhoneNum = bool;
        this.mIsAccountUpgrade = false;
        this.mPwdChangeReceiver = new BroadcastReceiver() { // from class: com.tenpay.sdk.activity.BasePayActivity.1
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                if (ChangePassActivity.BROADCAST_INTENT_ACTION_CHANGE_PWD_SUCCESS.equals(intent.getAction())) {
                    BasePayActivity.this.onPwdChange();
                }
            }
        };
        this.mCurrentTime = 0L;
        this.mShowCvv = "";
        this.mDetectDialog = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dismissDetectDialog() {
        View findViewById;
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
        FragmentActivity activity = getActivity();
        if (activity != null && !activity.isFinishing() && (findViewById = activity.findViewById(R.id.root_layout)) != null) {
            findViewById.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showSoterUpdateDialog$0(DialogInterface dialogInterface, int i3) {
        if (SoterWrapperApi.isInitialized()) {
            SoterWrapperApi.release();
        }
        launchFragment(new Intent(), FingerPaySettingSwitchFragment.class);
        finish();
        QLog.i(((NetBaseActivity) this).TAG, 1, "soter error dialog left");
    }

    private void observerPwdChange() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(ChangePassActivity.BROADCAST_INTENT_ACTION_CHANGE_PWD_SUCCESS);
        registerReceiver(this.mPwdChangeReceiver, intentFilter);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onOpenFingerPayFinish(boolean z16) {
        QwLog.i("onOpenFingerPayFinish success=" + z16);
        dismissDetectDialog();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDetectDialogImg(int i3) {
        QQProxyDialog qQProxyDialog = this.mDetectDialog;
        if (qQProxyDialog != null && qQProxyDialog.isShowing() && i3 != 0) {
            ((ImageView) this.mDetectDialog.findViewById(R.id.image)).setImageResource(i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showSoterUpdateDialog(String str) {
        DialogInterface.OnClickListener onClickListener;
        String str2;
        String str3;
        if (((IQWalletUnitedConfigApi) QRoute.api(IQWalletUnitedConfigApi.class)).isSwitchOn(IQWalletUnitedConfigApi.QWALLET_SOTER_UPDATE_DO_NOT_LAUNCH_SET)) {
            str3 = null;
            onClickListener = null;
            str2 = "\u77e5\u9053\u4e86";
        } else {
            onClickListener = new DialogInterface.OnClickListener() { // from class: com.tenpay.sdk.activity.d
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i3) {
                    BasePayActivity.this.lambda$showSoterUpdateDialog$0(dialogInterface, i3);
                }
            };
            str2 = "\u53d6\u6d88";
            str3 = "\u53bb\u8bbe\u7f6e";
        }
        DialogUtil.createCustomDialog(getActivity(), 0, (String) null, str, str2, str3, onClickListener, new DialogInterface.OnClickListener() { // from class: com.tenpay.sdk.activity.e
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                BasePayActivity.lambda$showSoterUpdateDialog$1(dialogInterface, i3);
            }
        }).show();
    }

    protected abstract void changePayTypeInFakeUrl();

    protected void checkBargainorId(String str) {
        String str2 = this.mAppInfo;
        if (str2 != null) {
            String[] split = str2.split("\\|");
            if (split.length > 0) {
                String str3 = "";
                String str4 = "";
                String str5 = str4;
                for (String str6 : split) {
                    int indexOf = str6.indexOf("appid#");
                    int indexOf2 = str6.indexOf("bargainor_id#");
                    int indexOf3 = str6.indexOf("channel#");
                    if (indexOf >= 0) {
                        str5 = str6.substring(6);
                    } else if (indexOf2 >= 0) {
                        str3 = str6.substring(13);
                    } else if (indexOf3 >= 0) {
                        str4 = str6.substring(8);
                    }
                }
                if (TextUtils.isEmpty(str3) || "null".equals(str3)) {
                    this.mAppInfo = "appid#" + str5 + "|bargainor_id#" + str + "|channel#" + str4;
                    return;
                }
                return;
            }
            this.mAppInfo = "|bargainor_id#" + str + "|";
            return;
        }
        this.mAppInfo = "|bargainor_id#" + str + "|";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void checkFP() {
        boolean soterOpen = SharedHelper.soterOpen(this.mUin);
        this.isSoterOpened = soterOpen;
        if (soterOpen) {
            this.mSoterOpenFid = Arrays.asList(SharedHelper.fingersLocal(this.mUin));
            QwLog.i("mSoterOpenFid : " + this.mSoterOpenFid);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void closeTime(Button button) {
        Timer timer = this.mTimer;
        if (timer != null) {
            timer.cancel();
        }
        mLeftTime = 59;
        if (button != null) {
            button.setText(getString(R.string.ede));
            button.setEnabled(true);
            button.setClickable(true);
        }
    }

    protected void doPayConfirm(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put(CommonCode.MapKey.TRANSACTION_ID, jSONObject.optString(CommonCode.MapKey.TRANSACTION_ID));
        hashMap.put("sp_data", Uri.decode(jSONObject.optString("sp_data")));
        hashMap.put("uin", this.mUin);
        httpRequest(Cgi.URI_TRANSFER_PAY_CONFIRM, hashMap);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void fingerParamFill(Map<String, String> map) {
        if (this.mWindowStyle == 1) {
            map.put("pay_method", "2");
        }
        SoterSignatureResult soterSignatureResult = this.mFingerAuthenResult;
        if (soterSignatureResult != null) {
            map.put("soter_auth_json", soterSignatureResult.getJsonValue());
            map.put("soter_auth_signature", this.mFingerAuthenResult.getSignature());
            map.put(QWSoterConstans.CGI_KEY_BUSI_TYPE, SharedHelper.getCurSoterBusiType(this.mUin) + "");
        }
    }

    protected String getDataToSign() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("device_id=");
        stringBuffer.append(QFuncProxy.getDeviceId(getContext()));
        stringBuffer.append("&isroot=");
        stringBuffer.append(NetUtil.isPhoneRooted(getContext()) ? 1 : 0);
        stringBuffer.append("&timestamp=");
        stringBuffer.append((System.currentTimeMillis() / 1000) + this.mTimestamp);
        stringBuffer.append("&token_id=");
        stringBuffer.append(this.mPayTokenId);
        stringBuffer.append("&uin=");
        stringBuffer.append(this.mUin);
        return stringBuffer.toString();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean getFingerPayExceedAmountNoticed() {
        return getSharedPreferences(SharedHelper.QB_TENPAY_FP_ + this.mUin, 0).getBoolean("fp_exceed_amount_noticed", false);
    }

    protected abstract boolean getFingerPayStatus();

    protected abstract String getPasswd();

    @Override // com.tenpay.sdk.activity.NetBaseActivity
    protected List<String> getSpecialErrorCode() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(ErrorCode.ERR_PAY_IVR);
        arrayList.add(ErrorCode.ERR_SHIMING);
        arrayList.add(ErrorCode.ERR_YDT_CREDITCARD_EXPIRE);
        arrayList.add(ErrorCode.ERR_GUIDE_TO_CTPAY_FOR_NOT_CTUSER);
        arrayList.add(ErrorCode.ERR_GUIDE_TO_CTPAY_FOR_CTUSER);
        return arrayList;
    }

    @Override // com.tenpay.sdk.activity.NetBaseActivity, com.tenpay.sdk.activity.TenpayUtilActivity, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public /* bridge */ /* synthetic */ ViewModel getViewModel(ViewModelStoreOwner viewModelStoreOwner, String str, @NonNull Class cls) {
        return ne0.a.a(this, viewModelStoreOwner, str, cls);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void go2ChangePhoneNumActivity() {
        Intent intent = new Intent();
        String str = this.mValidDateCVV;
        if (str != null && !TextUtils.isEmpty(str)) {
            this.mShowCvv = "";
        } else {
            this.mPhoneNumCVV = "";
        }
        intent.putExtra("showCvv", this.mShowCvv);
        intent.putExtra("phone", this.mNewPhoneNum);
        if (this.mWindowStyle == 1) {
            intent.putExtra("processtype", getProcessType());
        } else {
            intent.putExtra("processtype", 16);
        }
        launchFragmentForResult(intent, ChangePhoneNumActivity.class, ChangePhoneNum_RESULT_CODE);
    }

    protected abstract void go2PWDAuth();

    protected abstract void goneViewForPaySuccess();

    /* JADX INFO: Access modifiers changed from: protected */
    public void gotoPaySuccess(JSONObject jSONObject, String str) {
        int i3;
        QwLog.i("SOTER_OPEN_FLAG : " + this.SOTER_OPEN_FLAG);
        if (3 == this.SOTER_OPEN_FLAG) {
            SharedHelper.updateFingersLocal(this.mUin, this.mSoterOpenFid, this.mFingerAuthenResult.getFid());
        }
        saveDefaultPayType();
        if (TenpayInterface.VIEWTAG_REQARDTRANSFER.equals(this.mProcessViewTag)) {
            i3 = handleIsCallBack(jSONObject, str);
            if (1 == i3) {
                return;
            }
        } else {
            i3 = 0;
        }
        if ((TenpayInterface.VIEWTAG_QQ_TRANSFER_PAGE.equals(this.mProcessViewTag) || "AioTransfer".equals(this.mProcessViewTag)) && this.mIsCallback == 1) {
            if (this.mWaitingConfirm) {
                this.mWaitingConfirm = false;
                this.mPaySuccessObj = jSONObject;
                doPayConfirm(jSONObject);
                return;
            } else {
                JSONObject jSONObject2 = this.mPaySuccessObj;
                if (jSONObject2 != null) {
                    jSONObject = jSONObject2;
                }
            }
        }
        if (!this.mIsMidas && 2 != i3 && 3 != i3) {
            Intent intent = new Intent();
            if (4 == i3) {
                intent.putExtra("transfercallback_data", jSONObject.toString());
                JSONObject jSONObject3 = this.mPaySuccessObj;
                if (jSONObject3 != null) {
                    jSONObject = jSONObject3;
                }
            }
            intent.putExtra("success", jSONObject.toString());
            intent.putExtra("process_flag", getProcessType());
            intent.putExtra("pass_flag", this.mPassFlag);
            intent.putExtra(StateEvent.ActionValue.STAGE_PASS, getPasswd());
            intent.putExtra("push_spwd_flag", this.mPayGateObj.optString("push_spwd_flag"));
            intent.putExtra("push_spwd_date", this.mPayGateObj.optString("push_spwd_date"));
            intent.putExtra("timestamp_old", (this.mCurrentTime / 1000) + this.mTimestamp);
            intent.putExtra("iPayFrom", this.iPayFrom);
            intent.putExtra(com.tencent.mobileqq.msf.core.c0.j.T0, getIntent().getStringExtra(com.tencent.mobileqq.msf.core.c0.j.T0));
            intent.putExtra("offerid", this.offerid);
            intent.putExtra("soter_open_flag", this.soter_open_flag);
            if (!TextUtils.isEmpty(this.mPayGateObj.optString("sdk_auth_data"))) {
                intent.putExtra("sdk_auth_data", this.mPayGateObj.optString("sdk_auth_data"));
            }
            intent.putExtra("exec_code", getIntent().getStringExtra("exec_code"));
            String optString = this.mPayGateObj.optString("scheme_url");
            if (!TextUtils.isEmpty(optString)) {
                try {
                    intent.putExtra("KEY_FINISH_SCHEME_URL", URLDecoder.decode(optString, "utf-8"));
                } catch (UnsupportedEncodingException e16) {
                    QLog.w(((NetBaseActivity) this).TAG, 1, "decode schemeUrl error: " + optString, e16);
                }
            }
            JSONObject jSONObject4 = this.busi_switch;
            if (jSONObject4 != null && "1".equals(jSONObject4.optString("succ_hide"))) {
                intent.putExtra("succ_hide", true);
            }
            setIntentData(intent);
            com.tencent.mobileqq.qwallet.pay.k.a(getContext(), intent);
            finish();
        } else {
            Bundle retCodeAndGetBundle = setRetCodeAndGetBundle(0);
            if (2 == i3) {
                retCodeAndGetBundle.putString("transfer_retmsg", getString(R.string.ee_));
            }
            if (3 == i3) {
                NetUtil.setTransferCallBackData(jSONObject, retCodeAndGetBundle);
                JSONObject jSONObject5 = this.mPaySuccessObj;
                if (jSONObject5 != null) {
                    jSONObject = jSONObject5;
                }
            }
            retCodeAndGetBundle.putString("sp_data", jSONObject.optString("sp_data"));
            retCodeAndGetBundle.putString("total_fee", jSONObject.optString("real_fee"));
            try {
                JSONArray jSONArray = jSONObject.getJSONArray("refund");
                if (jSONArray != null && jSONArray.length() > 0) {
                    retCodeAndGetBundle.putString("refund", jSONArray.getJSONObject(0).toString());
                }
            } catch (JSONException e17) {
                QLog.e(((NetBaseActivity) this).TAG, 1, "", e17);
            }
            TenUtils.notifyToExit(getContext(), this.mProssesID);
        }
        Boolean bool = Boolean.FALSE;
        this.mChangePhoneNum = bool;
        this.mChangeValidDate = bool;
    }

    protected int handleIsCallBack(JSONObject jSONObject, String str) {
        int i3 = this.mIsCallback;
        if (Cgi.URI_QWALLET_QPAY_REWARD_CALLBACK.equals(str)) {
            if (i3 == 0) {
                return 3;
            }
            if (i3 == 2) {
                return 4;
            }
            return 0;
        }
        if (i3 == 1) {
            String optString = jSONObject.optString("callback_url");
            if (!TextUtils.isEmpty(optString)) {
                Intent intent = new Intent();
                try {
                    optString = URLDecoder.decode(optString, "UTF-8");
                } catch (UnsupportedEncodingException e16) {
                    QLog.e(((NetBaseActivity) this).TAG, 1, "", e16);
                }
                intent.putExtra("url", optString + "?sp_data=" + jSONObject.optString("sp_data") + "&_scene=reward&transaction_id=" + jSONObject.optString(CommonCode.MapKey.TRANSACTION_ID));
                intent.putExtra("startOpenPageTime", System.currentTimeMillis());
                intent.putExtra("hide_operation_bar", true);
                intent.putExtra("hide_more_button", true);
                RouteUtils.startActivity(getActivity(), intent, RouterConstants.UI_ROUTE_BROWSER);
            }
            return 2;
        }
        this.mPaySuccessObj = jSONObject;
        HashMap hashMap = new HashMap();
        hashMap.put("uin", this.mUin);
        hashMap.put("sp_data", jSONObject.optString("sp_data"));
        httpRequest(Cgi.URI_QWALLET_QPAY_REWARD_CALLBACK, hashMap);
        return 1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void initPayGateData() {
        JSONObject jSONObject = this.mPayGateObj;
        if (jSONObject == null) {
            return;
        }
        this.mTimestamp = Long.parseLong(jSONObject.optString("time_stamp")) - (System.currentTimeMillis() / 1000);
        this.mBargainorName = this.mPayGateObj.optString("bargainor_true_name");
        checkBargainorId(this.mPayGateObj.optString("bargainor_id"));
        this.mTrans_Id = this.mPayGateObj.optString(CommonCode.MapKey.TRANSACTION_ID);
        this.mGoodsName = this.mPayGateObj.optString("desc");
        this.mCardType = this.mPayGateObj.optString("creditcard_type");
        this.mCardID = this.mPayGateObj.optString("creditcard_id");
        this.mTrueName = this.mPayGateObj.optString("purchaser_true_name");
        this.mUserAttr = this.mPayGateObj.optInt("user_attr");
        this.mCacheVer = this.mPayGateObj.optString("interf_cache_ver");
        this.mUserCertType = this.mPayGateObj.optInt("cert_user");
        this.mAdDisplay = this.mPayGateObj.optInt("ad_display");
        this.mBargainorId = this.mPayGateObj.optString("bargainor_id");
        this.mPassFlag = this.mPayGateObj.optString("pass_flag");
        this.mTotalFee = this.mPayGateObj.optString("total_fee");
        this.mBalance = this.mPayGateObj.optLong("balance");
        this.offerid = this.mPayGateObj.optString("offerid");
        this.mTouchidState = this.mPayGateObj.optInt("touchid_state");
        this.mTouchidStateInfo = this.mPayGateObj.optString("touchid_state_info");
        this.mTouchidRetryMaxCount = this.mPayGateObj.optInt("touchid_retry_count");
        String optString = this.mPayGateObj.optString("domain_name");
        if (!TextUtils.isEmpty(optString)) {
            setServerAddr(optString);
        }
        this.busi_switch = this.mPayGateObj.optJSONObject("busi_switch");
        this.pay_scene = this.mPayGateObj.optString("pay_scene");
        QwLog.i("start pay addisp mAdDisplay = " + this.mAdDisplay + ",pay_scene = " + this.pay_scene);
        if (!"social".equals(this.pay_scene)) {
            String str = this.mBargainorId;
            if (str == null) {
                str = "";
            }
            com.tencent.mobileqq.qwallet.pay.h.d(str, this.offerid);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void initTimer(final Button button) {
        String str = getString(R.string.ede) + "(" + mLeftTime + ")";
        button.setClickable(false);
        button.setEnabled(false);
        button.setText(str);
        TimerTask timerTask = new TimerTask() { // from class: com.tenpay.sdk.activity.BasePayActivity.2
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                Handler handler = BasePayActivity.this.mHandler;
                if (handler != null) {
                    handler.post(new Runnable() { // from class: com.tenpay.sdk.activity.BasePayActivity.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            BasePayActivity.mLeftTime--;
                            String string = BasePayActivity.this.getApplicationContext().getString(R.string.ede);
                            if (BasePayActivity.mLeftTime > 0) {
                                string = string + "(" + BasePayActivity.mLeftTime + ")";
                                button.setClickable(false);
                                button.setEnabled(false);
                            } else {
                                button.setClickable(true);
                                button.setEnabled(true);
                                BasePayActivity.this.mTimer.cancel();
                                BasePayActivity.mLeftTime = 59;
                            }
                            button.setText(string);
                        }
                    });
                }
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

    /* JADX INFO: Access modifiers changed from: protected */
    public void initValue(Intent intent) {
        if (TextUtils.isEmpty(this.mProcessViewTag)) {
            this.mProcessViewTag = intent.getStringExtra("fromPage");
        }
        if (TenpayInterface.VIEWTAG_REQARDTRANSFER.equals(this.mProcessViewTag) || TenpayInterface.VIEWTAG_QQ_TRANSFER_PAGE.equals(this.mProcessViewTag) || "AioTransfer".equals(this.mProcessViewTag)) {
            this.mIsCallback = intent.getIntExtra("is_callback", 0);
        }
        this.mSelectedPayType = intent.getIntExtra("pay_by", -1);
        this.mSelectedPayBankIndex = intent.getIntExtra("bank_index", -1);
        this.mSelectBankSerial = intent.getStringExtra("bind_serial");
        this.isInner = intent.getBooleanExtra("isInner", false);
        this.mTrustPayOpen = intent.getStringExtra("trustpay_open_flag");
        this.mIsFromConFirmTrans = intent.getBooleanExtra("is_from_confirm_trans", false);
        this.iPayFrom = intent.getIntExtra("iPayFrom", -1);
    }

    @Override // com.tenpay.sdk.activity.NetBaseActivity, cooperation.qwallet.plugin.FakeUrl.FakeListener
    public boolean onBlHandleFakeurl(FakeUrl.FakeInfo fakeInfo, int i3) {
        super.onBlHandleFakeurl(fakeInfo, i3);
        if (i3 == 0) {
            resetPassUI();
            if (fakeInfo.data.optString("close_cur_page").equals("1")) {
                finish();
            }
            return false;
        }
        if (i3 == 1) {
            String optString = fakeInfo.data.optString("rbutton_click");
            if (Utils.isEmpty(optString)) {
                com.tencent.mobileqq.qwallet.c.e(optString, "", "", "", "");
            }
        }
        if (!fakeInfo.host.equals(QWalletFakeUrl.FAKEURL_REGENERATEASKEY) && !fakeInfo.host.equals(QWalletFakeUrl.FAKEURL_REGENERATEAUTHKEY)) {
            if (fakeInfo.host.equals("changeSelectCard")) {
                changePayTypeInFakeUrl();
                return true;
            }
            if (fakeInfo.host.equals("reservedMobileChange")) {
                go2ChangePhoneNumActivity();
                return true;
            }
            if (fakeInfo.host.equals("accountUpgrade")) {
                this.mIsAccountUpgrade = true;
                pay();
                return true;
            }
            if (!fakeInfo.host.equals(QWalletFakeUrl.FAKEURL_BINDCARDVERIFY)) {
                return false;
            }
            String optString2 = fakeInfo.data.optString("time_stamp");
            if (!TextUtils.isEmpty(optString2)) {
                this.mTimestamp = Long.parseLong(optString2) - (System.currentTimeMillis() / 1000);
            }
            this.mBargainorId = fakeInfo.data.optString("bargainor_id");
            this.mBargainorName = fakeInfo.data.optString("bargainor_true_name");
            this.mGoodsName = fakeInfo.data.optString("desc");
            this.mTotalFee = fakeInfo.data.optString("total_fee");
            this.mCardType = fakeInfo.data.optString("creditcard_type");
            this.mCardID = fakeInfo.data.optString("creditcard_id");
            this.mTrueName = fakeInfo.data.optString("purchaser_true_name");
            this.mUserAttr = fakeInfo.data.optInt("user_attr");
            Intent intent = new Intent();
            intent.putExtra("IsShiMing", true);
            intent.putExtra("IsIdVerifyValid", true);
            visitFakeUrlJumpBefore(intent, fakeInfo.host);
            BindBankModule.INSTANCE.startVerifyForResult(this, intent, ShiMing_RESULT_CODE);
            return true;
        }
        go2PWDAuth();
        return false;
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        resetLayout();
    }

    @Override // com.tenpay.sdk.activity.TenpayUtilActivity, com.tencent.mobileqq.base.QWalletBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getWindow().addFlags(8192);
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        View onCreateView = super.onCreateView(layoutInflater, viewGroup, bundle);
        getWindow().setSoftInputMode(19);
        this.mEnterType = Cgi.ENTER_FROM_PAY;
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, onCreateView);
        return onCreateView;
    }

    @Override // com.tenpay.sdk.activity.NetBaseActivity, com.tenpay.sdk.activity.TenpayUtilActivity, com.tencent.mobileqq.base.QWalletBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        try {
            QwLog.i(MosaicConstants$JsFunction.FUNC_ON_DESTROY);
            if (1 == this.mWindowStyle) {
                releaseFp();
            }
            if (SoterWrapperApi.isInitialized()) {
                SoterWrapperApi.release();
            }
            SoundPool soundPool = this.soundPool;
            if (soundPool != null) {
                soundPool.release();
                this.soundPool = null;
            }
            this.mMusicIds = null;
        } catch (Exception e16) {
            QLog.e(((NetBaseActivity) this).TAG, 1, "", e16);
        }
    }

    @Override // com.tenpay.sdk.activity.TenpayUtilActivity, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        unregisterReceiver(this.mPwdChangeReceiver);
    }

    protected abstract void onFingerAuthenticationSucceed();

    protected abstract void onFingerLocked();

    @Override // com.tenpay.sdk.activity.NetBaseActivity
    public void onNetDlgokClick(String str, JSONObject jSONObject) {
        super.onNetDlgokClick(str, jSONObject);
        String optString = jSONObject.optString("retcode");
        String optString2 = jSONObject.optString("retmsg");
        if (ErrorCode.ERR_PAY_PASSWORD.equals(optString)) {
            setRetCodeAndGetBundle(-6);
            return;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(ErrorCode.ERR_FAST_REGISTER_PHONE);
        arrayList.add(ErrorCode.ERR_SUBMIT_BILL_AGAIN);
        arrayList.add(ErrorCode.ERR_RET_DATA);
        arrayList.add(ErrorCode.ERR_TIME_OUT);
        if (arrayList.contains(optString)) {
            setRetCodeAndErrorMsg(Integer.parseInt(optString), optString2);
            return;
        }
        if (this.mWindowStyle == 1 && !this.isShowingVerifyCodeView) {
            go2PWDAuth();
        }
        if (ErrorCode.ERR_PAY_NOT_ENOUGH.equals(optString)) {
            resetPassUI();
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

    protected abstract void onStartFingerAuthentication();

    @Override // com.tenpay.sdk.activity.NetBaseActivity, com.tenpay.sdk.activity.TenpayUtilActivity, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public /* bridge */ /* synthetic */ void onUserLeaveHint() {
        com.tencent.biz.richframework.compat.f.m(this);
    }

    @Override // com.tenpay.sdk.activity.TenpayUtilActivity, com.tencent.mobileqq.base.QWalletBaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(@NonNull View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        observerPwdChange();
    }

    protected abstract void pay();

    protected abstract void playFingerErrorAnim(String str);

    /* JADX INFO: Access modifiers changed from: protected */
    public void playMusic(String str) {
        SoundPool soundPool = this.soundPool;
        if (soundPool != null) {
            soundPool.play(this.mMusicIds.get(str).intValue(), 1.0f, 1.0f, 0, 0, 1.0f);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void prosSotorBackParams(JSONObject jSONObject) {
        if (jSONObject == null) {
            QwLog.i("jo null, back...");
            return;
        }
        JSONObject optJSONObject = jSONObject.optJSONObject("soter");
        if (optJSONObject != null) {
            QwLog.i("soter = " + optJSONObject);
            this.SOTER_OPEN_FLAG = optJSONObject.optInt("open_flag", -1);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void releaseFp() {
        SoterBiometricCanceller soterBiometricCanceller;
        if (SoterWrapperApi.isSupportSoter() && (soterBiometricCanceller = this.mSoterBiometricCanceller) != null) {
            soterBiometricCanceller.asyncCancelBiometricAuthentication();
            this.mSoterBiometricCanceller = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean resetPassUI() {
        QwLog.i("current window style: " + this.mWindowStyle);
        int i3 = this.mWindowStyle;
        if (i3 == 1) {
            return false;
        }
        if (i3 != 0) {
            QwLog.i("not pass pay... " + this.mWindowStyle);
            return false;
        }
        if (this.mIsSixPasswdUser) {
            QwLog.i("six pwd user...");
            this.mSixPasswdEdit.setInputText("");
            this.mSixPasswdEdit.requestFocus();
        } else {
            QwLog.i("no six pwd user...");
            this.mNormalPasswdEdit.setText("");
            this.mNormalPasswdEdit.setFocusable(true);
            this.mNormalPasswdEdit.requestFocus();
            Utils.touchEditText(this.mHandler, this.mNormalPasswdEdit);
        }
        return false;
    }

    protected abstract void saveDefaultPayType();

    /* JADX INFO: Access modifiers changed from: protected */
    public void sendBalancePay(Map<String, String> map, int i3) {
        HashMap hashMap = new HashMap(map);
        hashMap.put("token_id", this.mPayTokenId);
        hashMap.put("p", getPasswd());
        hashMap.put("timestamp", this.mTimestamp + "");
        hashMap.put("qpay_cert_cn", CertUtil.getCid(getContext(), this.mUin));
        hashMap.put("trustpay_open_flag", this.mTrustPayOpen);
        fingerParamFill(hashMap);
        if (!TextUtils.isEmpty(this.mPromotionFlag) && this.mPromotionFlag.equals("1")) {
            hashMap.put("promotion_id", this.mPromotionId);
            hashMap.put("promotion_fee", this.mPromotionFee);
            hashMap.put("promotion_type", this.mPromotionType);
        }
        this.mCurrentTime = System.currentTimeMillis();
        httpRequestWithQQPayLoading(Cgi.URI_BALANCE_GET_CODE, hashMap, i3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setFingerPayExceedAmountNoticed(boolean z16) {
        SharedPreferences.Editor edit = getSharedPreferences(SharedHelper.QB_TENPAY_FP_ + this.mUin, 0).edit();
        edit.putBoolean("fp_exceed_amount_noticed", z16);
        edit.commit();
    }

    protected void showDetectDialog() {
        try {
            if (getContext() != null && !isFinishing()) {
                if (this.mDetectDialog == null) {
                    int curSoterBusiType = SharedHelper.getCurSoterBusiType(this.mUin);
                    this.mDetectDialog = QUIProxy.createCustomDialogWithImage(getContext(), R.layout.ado, R.style.qZoneInputDialog, R.id.image, QWSoterConstans.getAuthResIdByBusiType(curSoterBusiType), null, String.format(getString(R.string.f171337e63), QWSoterConstans.getNameByBusiType(curSoterBusiType)), R.string.e5h, 0, null, new DialogInterface.OnClickListener() { // from class: com.tenpay.sdk.activity.BasePayActivity.3
                        @Override // android.content.DialogInterface.OnClickListener
                        public void onClick(DialogInterface dialogInterface, int i3) {
                            BasePayActivity.this.onOpenFingerPayFinish(false);
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

    /* JADX INFO: Access modifiers changed from: protected */
    public void startFingerprintAuthentication() {
        String hexdigest = MD5.hexdigest(getDataToSign());
        this.mSoterBiometricCanceller = new SoterBiometricCanceller();
        final int curSoterBusiType = SharedHelper.getCurSoterBusiType(this.mUin);
        SoterWrapperApi.requestAuthorizeAndSign(new SoterProcessCallback<SoterProcessAuthenticationResult>() { // from class: com.tenpay.sdk.activity.BasePayActivity.5
            @Override // com.tencent.soter.wrapper.wrap_callback.SoterProcessCallback
            public void onResult(SoterProcessAuthenticationResult soterProcessAuthenticationResult) {
                QwLog.i("requestAuthorizeAndSign: " + soterProcessAuthenticationResult.toString());
                if (BasePayActivity.this.isFinishing()) {
                    return;
                }
                if (soterProcessAuthenticationResult.isSuccess()) {
                    BasePayActivity.this.dismissQQPayLoading();
                    BasePayActivity.this.mFingerAuthenResult = soterProcessAuthenticationResult.getExtData();
                    BasePayActivity basePayActivity = BasePayActivity.this;
                    SoterSignatureResult soterSignatureResult = basePayActivity.mFingerAuthenResult;
                    if (soterSignatureResult == null) {
                        basePayActivity.go2PWDAuth();
                        return;
                    }
                    String fid = soterSignatureResult.getFid();
                    QwLog.i("fid : " + fid + "|" + BasePayActivity.this.mSoterOpenFid);
                    List<String> list = BasePayActivity.this.mSoterOpenFid;
                    if (list != null) {
                        if (list.contains(fid)) {
                            BasePayActivity.this.releaseFp();
                            BasePayActivity.this.pay();
                            return;
                        } else {
                            QQToast.makeText(BasePayActivity.this.getContext(), BasePayActivity.this.getString(R.string.e9o), 1).show();
                            BasePayActivity.this.go2PWDAuth();
                            return;
                        }
                    }
                    return;
                }
                int i3 = soterProcessAuthenticationResult.errCode;
                if (i3 == 1006 || i3 == 1005 || i3 == 3 || i3 == 1007) {
                    new ApiFingerImpl().closeFingerPay(BasePayActivity.this.getContext(), BasePayActivity.this.mUin);
                    BasePayActivity.this.showSoterUpdateDialog(BasePayActivity.this.getString(R.string.e6b, QWSoterConstans.getNameByBusiType(curSoterBusiType), QWSoterConstans.getNameByBusiType(curSoterBusiType)));
                    BasePayActivity.this.go2PWDAuth();
                    return;
                }
                if (i3 == 1020) {
                    return;
                }
                if (i3 == 1021) {
                    BasePayActivity.this.onFingerLocked();
                    return;
                }
                if (i3 == 1017) {
                    BasePayActivity.this.setDetectDialogImg(QWSoterConstans.getAuthFailResId(curSoterBusiType));
                    if (BasePayActivity.this.mDetectDialog != null) {
                        BasePayActivity basePayActivity2 = BasePayActivity.this;
                        if (basePayActivity2.mTouchidRetryCount >= basePayActivity2.mTouchidRetryMaxCount) {
                            basePayActivity2.mDetectDialog.setMessage(BasePayActivity.this.getString(R.string.iwr));
                            BasePayActivity.this.mDetectDialog.setNegativeButton(R.string.e5h, new DialogInterface.OnClickListener() { // from class: com.tenpay.sdk.activity.BasePayActivity.5.1
                                @Override // android.content.DialogInterface.OnClickListener
                                public void onClick(DialogInterface dialogInterface, int i16) {
                                    BasePayActivity.this.go2PWDAuth();
                                    BasePayActivity.this.dismissDetectDialog();
                                }
                            });
                            BasePayActivity.this.mDetectDialog.setPositiveButton((String) null, (DialogInterface.OnClickListener) null);
                            return;
                        } else {
                            basePayActivity2.mDetectDialog.setMessage(BasePayActivity.this.getString(R.string.iws));
                            BasePayActivity.this.mDetectDialog.setPositiveButton(R.string.iws, new DialogInterface.OnClickListener() { // from class: com.tenpay.sdk.activity.BasePayActivity.5.2
                                @Override // android.content.DialogInterface.OnClickListener
                                public void onClick(DialogInterface dialogInterface, int i16) {
                                    BasePayActivity.this.mDetectDialog.setMessage(String.format(BasePayActivity.this.getString(R.string.f171337e63), QWSoterConstans.getNameByBusiType(curSoterBusiType)));
                                    AnonymousClass5 anonymousClass5 = AnonymousClass5.this;
                                    BasePayActivity.this.setDetectDialogImg(QWSoterConstans.getAuthResIdByBusiType(curSoterBusiType));
                                    BasePayActivity.this.mDetectDialog.setPositiveButton((String) null, (DialogInterface.OnClickListener) null);
                                    BasePayActivity.this.startFingerprintAuthentication();
                                }
                            }, false);
                            return;
                        }
                    }
                    return;
                }
                if (BasePayActivity.this.isFinishing()) {
                    return;
                }
                BasePayActivity.this.go2PWDAuth();
            }
        }, new AuthenticationParam.AuthenticationParamBuilder().setScene(Cgi.scene_FingerPay).setBiometricType(QWSoterConstans.getBiometricType(curSoterBusiType)).setContext(getContext()).setSoterBiometricCanceller(this.mSoterBiometricCanceller).setPrefilledChallenge(hexdigest).setIWrapUploadSignature(null).setSoterBiometricStateCallback(new SoterBiometricStateCallbackCompat() { // from class: com.tenpay.sdk.activity.BasePayActivity.4
            @Override // com.tencent.soter.wrapper.wrap_biometric.SoterBiometricStateCallback
            public void onAuthenticationCancelled() {
                BasePayActivity basePayActivity = BasePayActivity.this;
                basePayActivity.mTouchidRetryCount = 0;
                basePayActivity.mSoterBiometricCanceller = null;
                basePayActivity.dismissDetectDialog();
            }

            @Override // com.tenpay.compat.SoterBiometricStateCallbackCompat
            public void onAuthenticationErrorCompat(int i3, CharSequence charSequence) {
                QwLog.i("onAuthenticationError:" + i3 + ",CharSequence:" + ((Object) charSequence));
                QQToast.makeText(BasePayActivity.this.getContext(), String.format(BasePayActivity.this.getString(R.string.iwq), QWSoterConstans.getNameByBusiType(curSoterBusiType)), 0).show();
                BasePayActivity.this.go2PWDAuth();
                BasePayActivity.this.dismissDetectDialog();
            }

            @Override // com.tencent.soter.wrapper.wrap_biometric.SoterBiometricStateCallback
            public void onAuthenticationFailed() {
                BasePayActivity basePayActivity = BasePayActivity.this;
                basePayActivity.mTouchidRetryCount++;
                basePayActivity.playFingerErrorAnim(basePayActivity.getString(R.string.e6a));
                if (BasePayActivity.this.mDetectDialog != null) {
                    BasePayActivity.this.mDetectDialog.playShakeAnim(R.anim.f154873en);
                }
            }

            @Override // com.tencent.soter.wrapper.wrap_biometric.SoterBiometricStateCallback
            public void onAuthenticationHelp(int i3, CharSequence charSequence) {
                QwLog.i(String.format("onAuthenticationHelp: %d, %s", Integer.valueOf(i3), charSequence));
            }

            @Override // com.tencent.soter.wrapper.wrap_biometric.SoterBiometricStateCallback
            public void onAuthenticationSucceed() {
                QwLog.i("onAuthenticationSucceed()");
                BasePayActivity.this.onFingerAuthenticationSucceed();
                BasePayActivity.this.dismissDetectDialog();
            }

            @Override // com.tencent.soter.wrapper.wrap_biometric.SoterBiometricStateCallback
            public void onStartAuthentication() {
                BasePayActivity.this.showDetectDialog();
                BasePayActivity.this.onStartFingerAuthentication();
            }
        }).build());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void uploadData(String str) {
        uploadData(str, getProcessType());
    }

    @Override // com.tenpay.sdk.activity.NetBaseActivity, com.tenpay.sdk.activity.TenpayUtilActivity, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public /* bridge */ /* synthetic */ boolean useArgusLifecycle() {
        return ne0.a.f(this);
    }

    @Override // com.tenpay.sdk.activity.NetBaseActivity, com.tenpay.sdk.activity.TenpayUtilActivity, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public /* bridge */ /* synthetic */ ViewModel getViewModel(String str, @NonNull Class cls) {
        return ne0.a.c(this, str, cls);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void uploadData(String str, int i3) {
        com.tencent.mobileqq.qwallet.c.c(str, Integer.valueOf(i3));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onPwdChange() {
    }

    public void resetLayout() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$showSoterUpdateDialog$1(DialogInterface dialogInterface, int i3) {
    }
}
