package com.tenpay.sdk.activity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.os.ResultReceiver;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelStoreOwner;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.qwallet.utils.QWalletUtils;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK;
import com.tencent.hippy.qq.view.scroll.HippyHeaderListViewController;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.base.QWalletBaseFragment;
import com.tencent.mobileqq.winkpublish.api.constant.FSPublishConstants;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.dtreport.api.DefaultTVKDataProvider;
import com.tencent.qzonehub.api.webview.IQzoneWebViewPluginHelper;
import com.tenpay.ErrorCode;
import com.tenpay.QwLog;
import com.tenpay.api.MyKeyboardWindow;
import com.tenpay.api.QFuncProxy;
import com.tenpay.api.TTSUtil;
import com.tenpay.proxy.DataProxy;
import com.tenpay.sdk.Cgi;
import com.tenpay.sdk.IResult;
import com.tenpay.sdk.SDKCallbackManager;
import com.tenpay.sdk.apilogic.ApiGotoview;
import com.tenpay.sdk.net.core.actions.DomainSettingAction;
import com.tenpay.sdk.util.TenUtils;
import com.tenpay.sdk.util.TenpayUtil;
import com.tenpay.sdk.util.UIUtils;
import com.tenpay.sdk.view.OkTipWithSubTitleDialog;
import com.tenpay.sdk.view.OkTipsDialog;
import com.tenpay.sdk.view.SMSAlertButton;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import mqq.app.NewIntent;

/* compiled from: P */
/* loaded from: classes27.dex */
public abstract class TenpayUtilActivity extends QWalletBaseFragment {
    private static final int BROADCAST_VIDEO_TYPE = 999;
    public static final int MIN_INTERVAL = 500;
    public static final String NEARY_PROFILE_CARD_URL = "mqqapi://nearby_entry/nearby_profile?src_type=web&version=1&from=10003&from_type=0&uin=%s&mode=3";
    private static final String RECEIVER_ACTION = "com.qwallet.report";
    public static final String SCHEME_ACCOUNT_DETAIL = "mqqapi://card/show_pslcard?src_type=internal&uin=%s&version=1";
    public static final String SCHEME_TROOP_MEMEMBER = "mqqapi://card/show_pslcard?src_type=internal&version=1&card_type=troopmemberfromhb&uin=%s&troopuin=%s";
    private static short resultCounter;
    protected int authen_channel_state;
    protected String back_button_text;
    protected int mAdDisplay;
    protected String mAppInfo;
    protected String mAppid;
    protected String mBargainorId;
    protected String mBargainorName;
    protected String mCacheVer;
    protected String mCardID;
    protected String mCardType;
    protected int mComeFrom;
    protected String mDiscountType;
    protected String mGoodsName;
    protected String mGroupid;
    protected byte[] mGuid;
    protected boolean mIsH5Success;
    protected boolean mIsH5Withdraw;
    protected boolean mIsMidas;
    protected int mLocType;
    private MyKeyboardWindow mMyKeyboardWindow;
    private OkTipsDialog mOkTips;
    protected String mOriginalTotal;
    protected String mPassFlag;
    protected String mPayTokenId;
    protected String mPayType;
    protected String mProcessViewTag;
    protected String mPromotionFee;
    protected String mPromotionFlag;
    protected String mPromotionId;
    protected String mPromotionName;
    protected String mPromotionResult;
    protected String mPromotionShowTxt;
    protected String mPromotionType;
    protected long mProssesID;
    protected String mServiceId;
    protected String mSubscribeInfo;
    private OkTipWithSubTitleDialog mSubtitleTips;
    protected long mTimestamp;
    protected String mTotalFee;
    protected int mTouchidRetryMaxCount;
    protected String mTouchidStateInfo;
    protected String mTrueName;
    protected int mUserAttr;
    protected int mUserCertType;
    protected BroadcastReceiver myBroadcastReceiver;
    protected String newprice;
    protected View stateBar;
    protected int subscribe_default_option;
    protected final String TAG = getClass().getSimpleName();
    private Map<Integer, IResult> mResultMap = new HashMap();
    protected boolean mIsRandomCut = false;
    public String mUin = "";
    protected String mUserNick = "";
    protected int mEnterType = 0;
    protected int mTouchidState = 0;
    protected boolean callback_when_cancel_pay = false;
    protected boolean mExitEnable = true;
    protected boolean isOpenWebank = false;
    protected boolean mShowNativePaySuccess = true;
    private BroadcastReceiver mHbReceiver = new BroadcastReceiver() { // from class: com.tenpay.sdk.activity.TenpayUtilActivity.1
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            Bundle bundleExtra;
            ResultReceiver resultReceiver;
            String action = intent.getAction();
            if (action != null && action.equals(TenpayUtilActivity.RECEIVER_ACTION)) {
                int intExtra = intent.getIntExtra("type", 0);
                QwLog.i("onReceive type = " + intExtra);
                if (999 != intExtra || (bundleExtra = intent.getBundleExtra("params")) == null) {
                    return;
                }
                QwLog.i("onReceive bundle = " + bundleExtra.toString());
                String string = bundleExtra.getString("from");
                if (!TenpayUtilActivity.this.isFinishing() && "video".equals(string)) {
                    if (TenpayUtilActivity.this.getIntent() != null) {
                        resultReceiver = (ResultReceiver) TenpayUtilActivity.this.getIntent().getParcelableExtra(SDKCallbackManager.SESSION_RECEIVER);
                    } else {
                        resultReceiver = null;
                    }
                    if (resultReceiver != null) {
                        Bundle bundle = new Bundle();
                        bundle.putString("retmsg", "\u6536\u5230\u7ed3\u675f\u5e7f\u64ad");
                        resultReceiver.send(-1, bundle);
                    }
                    TenUtils.notifyToExit(TenpayUtilActivity.this.getContext(), 1L);
                }
            }
        }
    };
    private int ret_code = -1;
    private Bundle ret_bundle = new Bundle();
    private long mLastClickTime = 0;
    private int mLastId = 0;
    protected boolean hasTopCallback = false;

    private String bindUpdataData() {
        StringBuffer stringBuffer = new StringBuffer();
        List<String> list = TenpayUtil.mUploadData;
        if (list != null && list.size() > 0) {
            int size = TenpayUtil.mUploadData.size();
            for (int i3 = 0; i3 < size; i3++) {
                if (i3 != 0) {
                    if (this.mIsMidas) {
                        stringBuffer.append("|");
                    } else {
                        stringBuffer.append(";");
                    }
                }
                stringBuffer.append(TenpayUtil.mUploadData.get(i3));
            }
            TenpayUtil.mUploadData.clear();
        }
        return stringBuffer.toString();
    }

    private boolean canCallback() {
        String obj;
        Intent intent = getIntent();
        if (intent == null) {
            return false;
        }
        int b16 = pk2.a.b();
        Parcelable parcelableExtra = intent.getParcelableExtra(SDKCallbackManager.SESSION_RECEIVER);
        StringBuilder sb5 = new StringBuilder();
        sb5.append("canCallback activityCount=");
        sb5.append(b16);
        sb5.append(", receiver=");
        if (parcelableExtra == null) {
            obj = "null";
        } else {
            obj = parcelableExtra.toString();
        }
        sb5.append(obj);
        QwLog.i(sb5.toString());
        if (parcelableExtra == null) {
            return false;
        }
        if (b16 == 1) {
            return true;
        }
        return this.hasTopCallback;
    }

    private void registerHbBroadCast() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(RECEIVER_ACTION);
        registerReceiver(this.mHbReceiver, intentFilter);
    }

    private void resetIntentData(Intent intent, String str, Object obj) {
        if (!intent.hasExtra(str)) {
            if (obj instanceof Integer) {
                intent.putExtra(str, (Integer) obj);
                return;
            }
            if (obj instanceof Boolean) {
                intent.putExtra(str, (Boolean) obj);
                return;
            }
            if (obj instanceof byte[]) {
                intent.putExtra(str, (byte[]) obj);
            } else if (obj instanceof Long) {
                intent.putExtra(str, (Long) obj);
            } else {
                intent.putExtra(str, (String) obj);
            }
        }
    }

    public void addUploadData(String str) {
        com.tencent.mobileqq.qwallet.c.c(str, Integer.valueOf(getProcessType()));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void callBackFromNet(HashMap<String, String> hashMap) {
        int j3 = x05.c.j(hashMap.get("retcode"), -1);
        for (String str : hashMap.keySet()) {
            this.ret_bundle.putString(str, hashMap.get(str));
        }
        setRetCodeAndGetBundle(j3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void callBackReceiver() {
        ResultReceiver resultReceiver;
        QwLog.i("send call back...");
        String bindUpdataData = bindUpdataData();
        if (!TextUtils.isEmpty(bindUpdataData)) {
            this.ret_bundle.putString("upload_data", bindUpdataData);
        }
        if (this.mIsMidas) {
            this.ret_bundle.putInt(DefaultTVKDataProvider.KEY_PAY_TYPE, getProcessType());
            this.ret_bundle.putInt("backfrom", this.mLocType);
        }
        Intent intent = getIntent();
        if (intent != null && intent.hasExtra(SDKCallbackManager.SESSION_RECEIVER) && (resultReceiver = (ResultReceiver) intent.getParcelableExtra(SDKCallbackManager.SESSION_RECEIVER)) != null) {
            int defRetCode = defRetCode();
            Bundle bundle = new Bundle(this.ret_bundle);
            int i3 = this.ret_code;
            if (i3 == -1) {
                bundle.putString("err_msg", getString(R.string.e1t));
            } else if (i3 == -4) {
                bundle.putString("err_msg", getString(R.string.e5t));
            } else if (i3 == -6) {
                bundle.putString("err_msg", getString(R.string.eak));
            }
            QwLog.i("send...");
            resultReceiver.send(defRetCode, bundle);
        }
    }

    public boolean chooseFriends(String str, ResultReceiver resultReceiver) {
        if (resultReceiver == null) {
            return false;
        }
        Bundle bundle = new Bundle();
        bundle.putInt("forward_type", 15);
        if (!TextUtils.isEmpty(str)) {
            bundle.putString(AppConstants.Key.FORWARD_TEXT, str);
        }
        DataProxy.reqRecentFowrad(resultReceiver, bundle);
        return true;
    }

    protected int defRetCode() {
        return this.ret_code;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        try {
            if (motionEvent.getAction() == 0) {
                MyKeyboardWindow myKeyboardWindow = this.mMyKeyboardWindow;
                if (myKeyboardWindow != null && myKeyboardWindow.getVisibility() == 0 && !UIUtils.isInView(motionEvent, this.mMyKeyboardWindow)) {
                    this.mMyKeyboardWindow.setVisibility(8);
                } else if (getActivity().getCurrentFocus() != null && !UIUtils.isInView(motionEvent, getActivity().getCurrentFocus())) {
                    InputMethodManager inputMethodManager = (InputMethodManager) getActivity().getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD);
                    if (inputMethodManager.isActive()) {
                        inputMethodManager.hideSoftInputFromWindow(getActivity().getCurrentFocus().getWindowToken(), 0);
                    }
                }
            }
        } catch (Throwable th5) {
            QLog.e(this.TAG, 1, "dispatchTouchEvent: ", th5);
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public void exitCurrentProcess() {
        TenUtils.notifyToExit(getContext(), this.mProssesID);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int getProcessType() {
        return -1;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public /* bridge */ /* synthetic */ ViewModel getViewModel(ViewModelStoreOwner viewModelStoreOwner, String str, @NonNull Class cls) {
        return ne0.a.a(this, viewModelStoreOwner, str, cls);
    }

    public void gotoH5(String str) {
        QFuncProxy.gotoH5(getOutActivity(), str, true, true);
    }

    public void gotoQWalletActivity(int i3) {
        QWalletUtils.k(getActivity(), "mqqapi://wallet/open?viewtype=0&version=1&src_type=web&view=0&channel=" + i3);
    }

    protected boolean isRegisterMyBroadcastReceiver() {
        return true;
    }

    protected boolean isSDKActivity() {
        return true;
    }

    @Override // com.tencent.mobileqq.base.QWalletBaseFragment
    protected boolean isStatusBarImmersive() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean isValidClick(int i3) {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.mLastClickTime > 500) {
            this.mLastId = i3;
            this.mLastClickTime = currentTimeMillis;
            return true;
        }
        this.mLastClickTime = currentTimeMillis;
        if (i3 == this.mLastId) {
            return false;
        }
        this.mLastId = i3;
        return true;
    }

    @Override // com.tencent.mobileqq.base.QWalletBaseFragment
    public void launchFragment(@NonNull Intent intent, @NonNull Class<? extends QWalletBaseFragment> cls) {
        setIntentData(intent);
        super.launchFragment(intent, cls);
    }

    @Override // com.tencent.mobileqq.base.QWalletBaseFragment
    public void launchFragmentForResult(@NonNull Intent intent, @NonNull Class<? extends QWalletBaseFragment> cls, int i3) {
        setIntentData(intent);
        super.launchFragmentForResult(intent, cls, i3);
    }

    public void mSetContentView(View view) {
        TextView textView = (TextView) view.findViewById(R.id.jdp);
        if (textView != null) {
            textView.setClickable(true);
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.tenpay.sdk.activity.TenpayUtilActivity.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    EventCollector.getInstance().onViewClickedBefore(view2);
                    TenpayUtilActivity.this.gotoH5(new StringBuffer(Cgi.URI_QQPAY_SUPPORT).toString());
                    EventCollector.getInstance().onViewClicked(view2);
                }
            });
        }
        SMSAlertButton sMSAlertButton = (SMSAlertButton) view.findViewById(R.id.jes);
        if (sMSAlertButton != null) {
            sMSAlertButton.setOnConfirm(new SMSAlertButton.OnConfirmListener() { // from class: com.tenpay.sdk.activity.TenpayUtilActivity.4
                @Override // com.tenpay.sdk.view.SMSAlertButton.OnConfirmListener
                public void OnConfirm() {
                    TenpayUtilActivity tenpayUtilActivity = TenpayUtilActivity.this;
                    if (!tenpayUtilActivity.mIsMidas) {
                        com.tencent.mobileqq.qwallet.c.c("bigpay.sms.question", Integer.valueOf(tenpayUtilActivity.getProcessType()));
                    }
                }
            });
        }
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment
    public boolean needDispatchTouchEvent() {
        return true;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onActivityResult(int i3, int i16, Intent intent) {
        super.onActivityResult(i3, i16, intent);
        IResult remove = this.mResultMap.remove(Integer.valueOf(i3));
        if (remove != null) {
            remove.back(i16, intent);
        }
    }

    @Override // com.tencent.mobileqq.base.QWalletBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        SharedPreferences sharedPreferences;
        SharedPreferences sharedPreferences2;
        super.onCreate(bundle);
        if (isSDKActivity()) {
            pk2.a.c();
            if (QLog.isColorLevel()) {
                QLog.i(this.TAG, 2, "onCreate: activityCount " + pk2.a.b());
            }
        }
        getWindow().setFeatureInt(5, -2);
        getWindow().setSoftInputMode(19);
        Intent intent = getIntent();
        if (intent != null) {
            this.mTimestamp = intent.getLongExtra("time_stamp", 0L);
            this.mBargainorName = intent.getStringExtra("bargainor_true_name");
            this.mGoodsName = intent.getStringExtra("goods_name");
            this.mPayType = intent.getStringExtra(DefaultTVKDataProvider.KEY_PAY_TYPE);
            this.mTotalFee = intent.getStringExtra("total_fee");
            this.mCardType = intent.getStringExtra("card_type");
            this.mCardID = intent.getStringExtra("card_id");
            this.mTrueName = intent.getStringExtra("true_name");
            this.isOpenWebank = intent.getBooleanExtra("isOpenWebank", false);
            this.mPromotionFee = intent.getStringExtra("promotionfee");
            this.mPromotionFlag = intent.getStringExtra("promotionflag");
            this.mPromotionName = intent.getStringExtra("promotionname");
            this.mPromotionType = intent.getStringExtra("promotiontype");
            this.mPromotionId = intent.getStringExtra("promotionid");
            this.mPromotionShowTxt = intent.getStringExtra("promotionshow");
            this.mPromotionResult = intent.getStringExtra("promotion_result");
            this.mDiscountType = intent.getStringExtra("discounttype");
            this.mOriginalTotal = intent.getStringExtra("original_total");
            this.mIsRandomCut = intent.getBooleanExtra("is_random_cut", false);
            this.mUserAttr = intent.getIntExtra("user_attr", 0);
            this.mCacheVer = intent.getStringExtra("interf_cache_ver");
            this.mUserCertType = intent.getIntExtra("cert_user", 0);
            String stringExtra = intent.getStringExtra("uin");
            this.mUin = stringExtra;
            if (TextUtils.isEmpty(stringExtra)) {
                this.mUin = com.tencent.mobileqq.base.a.c();
            }
            String stringExtra2 = intent.getStringExtra(IQzoneWebViewPluginHelper.EXTRA_FAMOUS_SHARE_NICKNAME);
            this.mUserNick = stringExtra2;
            if (TextUtils.isEmpty(stringExtra2)) {
                this.mUserNick = com.tencent.mobileqq.base.a.b();
            }
            this.mEnterType = intent.getIntExtra("wallet_bind", 0);
            this.mPayTokenId = intent.getStringExtra("token_id");
            this.mComeFrom = intent.getIntExtra("come_from", 0);
            this.mAppInfo = intent.getStringExtra(com.tencent.mobileqq.msf.core.c0.j.T0);
            this.mSubscribeInfo = intent.getStringExtra("subscribe_info");
            this.mServiceId = intent.getStringExtra("service_id");
            this.mGuid = intent.getByteArrayExtra("guid");
            this.mAppid = intent.getStringExtra("appid");
            this.mIsMidas = intent.getBooleanExtra("is_midas", false);
            this.mLocType = intent.getIntExtra("midas_paytype", 0);
            this.mPassFlag = intent.getStringExtra("pass_flag");
            this.subscribe_default_option = intent.getIntExtra("subscribe_default_option", 1);
            this.mProssesID = intent.getLongExtra("prossesId", 0L);
            this.mAdDisplay = intent.getIntExtra("ad_display", 0);
            this.mBargainorId = intent.getStringExtra("bargainor_id");
            this.mProcessViewTag = intent.getStringExtra(HippyHeaderListViewController.VIEW_TAG);
            this.authen_channel_state = intent.getIntExtra("authen_channel_state", 0);
            this.back_button_text = intent.getStringExtra("back_button_text");
            this.mGroupid = intent.getStringExtra(FSPublishConstants.FSPublishJsBridge.JSON_OBJECT_KEY_GROUP_ID);
            if (Cgi.domain_name == null && (sharedPreferences2 = getSharedPreferences("qb_tenpay_addr", 0)) != null) {
                Cgi.domain_name = sharedPreferences2.getString("server_addr", null);
            }
            if (TextUtils.isEmpty(Cgi.wallet_domain) && (sharedPreferences = getSharedPreferences("qb_tenpay_addr", 0)) != null) {
                Cgi.wallet_domain = sharedPreferences.getString(DomainSettingAction.SP_KEY_WALLET_DOMAIN, null);
            }
            this.mIsH5Withdraw = intent.getBooleanExtra("isH5Withdraw", false);
            this.mIsH5Success = intent.getBooleanExtra("h5_success", false);
            this.mShowNativePaySuccess = intent.getBooleanExtra("show_native_paysucc", true);
            this.mTouchidState = intent.getIntExtra("touchid_state", 0);
            this.mTouchidStateInfo = intent.getStringExtra("touchid_state_info");
            this.mTouchidRetryMaxCount = intent.getIntExtra("touchid_retry_count", 0);
            this.newprice = intent.getStringExtra("newprice");
            this.callback_when_cancel_pay = getIntent().getBooleanExtra(ApiGotoview.CALLBACK_WHEN_CANCEL_PAY, false);
            QwLog.i("callback_when_cancel_pay: " + this.callback_when_cancel_pay);
        }
        this.myBroadcastReceiver = new BroadcastReceiver() { // from class: com.tenpay.sdk.activity.TenpayUtilActivity.2
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent2) {
                long longExtra = intent2.getLongExtra("ID", 0L);
                QwLog.i("receiver, id=" + longExtra + ", mProssesID=" + TenpayUtilActivity.this.mProssesID + ", clazzName=" + TenpayUtilActivity.this.getClass().getSimpleName());
                if ((longExtra == 1 || TenpayUtilActivity.this.mProssesID == longExtra) && !TenpayUtilActivity.this.isFinishing()) {
                    TenpayUtilActivity tenpayUtilActivity = TenpayUtilActivity.this;
                    if (tenpayUtilActivity.mExitEnable) {
                        tenpayUtilActivity.finish();
                    }
                }
            }
        };
    }

    @Override // com.tencent.mobileqq.base.QWalletBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        QwLog.i("onDestroy: " + getClass().getSimpleName());
        TTSUtil.destroy();
        if (isSDKActivity()) {
            if (canCallback()) {
                callBackReceiver();
            }
            pk2.a.a();
            if (QLog.isColorLevel()) {
                QLog.i(this.TAG, 2, "onDestroy: activityCount " + pk2.a.b());
            }
        }
        super.onDestroy();
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        OkTipsDialog okTipsDialog = this.mOkTips;
        if (okTipsDialog != null && okTipsDialog.isShowing()) {
            this.mOkTips.dismiss();
        }
        OkTipWithSubTitleDialog okTipWithSubTitleDialog = this.mSubtitleTips;
        if (okTipWithSubTitleDialog != null && okTipWithSubTitleDialog.isShowing()) {
            this.mSubtitleTips.dismiss();
        }
        BroadcastReceiver broadcastReceiver = this.myBroadcastReceiver;
        if (broadcastReceiver != null) {
            unregisterReceiver(broadcastReceiver);
            this.myBroadcastReceiver = null;
        }
        unregisterReceiver(this.mHbReceiver);
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    @Deprecated
    public /* bridge */ /* synthetic */ void onPartTimeCostReport(String str, String str2, long j3) {
        ne0.a.e(this, str, str2, j3);
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public /* bridge */ /* synthetic */ void onUserLeaveHint() {
        com.tencent.biz.richframework.compat.f.m(this);
    }

    @Override // com.tencent.mobileqq.base.QWalletBaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(@NonNull View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        registerHbBroadCast();
        if (isRegisterMyBroadcastReceiver()) {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(NewIntent.ACTION_ACCOUNT_KICKED);
            intentFilter.addAction(Cgi.BROADCAST_INTENT_ACTION_EXIT);
            registerReceiver(this.myBroadcastReceiver, intentFilter);
        }
        mSetContentView(view);
    }

    public void openFriendCard(String str, boolean z16, boolean z17) {
        String format;
        if (z16) {
            format = String.format(NEARY_PROFILE_CARD_URL, str);
        } else if (z17 && !TextUtils.isEmpty(this.mGroupid)) {
            format = String.format(SCHEME_TROOP_MEMEMBER, str, this.mGroupid);
        } else {
            format = String.format(SCHEME_ACCOUNT_DETAIL, str);
        }
        Intent intent = new Intent(CommonConstant.ACTION.HWID_SCHEME_URL);
        intent.setData(Uri.parse(format));
        getActivity().startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setIntentData(Intent intent) {
        try {
            resetIntentData(intent, "time_stamp", Long.valueOf(this.mTimestamp));
            resetIntentData(intent, "bargainor_true_name", this.mBargainorName);
            resetIntentData(intent, "goods_name", this.mGoodsName);
            resetIntentData(intent, DefaultTVKDataProvider.KEY_PAY_TYPE, this.mPayType);
            resetIntentData(intent, "total_fee", this.mTotalFee);
            resetIntentData(intent, "card_type", this.mCardType);
            resetIntentData(intent, "card_id", this.mCardID);
            resetIntentData(intent, "true_name", this.mTrueName);
            resetIntentData(intent, "promotionfee", this.mPromotionFee);
            resetIntentData(intent, "promotionflag", this.mPromotionFlag);
            resetIntentData(intent, "promotionname", this.mPromotionName);
            resetIntentData(intent, "promotiontype", this.mPromotionType);
            resetIntentData(intent, "promotionid", this.mPromotionId);
            resetIntentData(intent, "promotionshow", this.mPromotionShowTxt);
            resetIntentData(intent, "promotion_result", this.mPromotionResult);
            resetIntentData(intent, "discounttype", this.mDiscountType);
            resetIntentData(intent, "original_total", this.mOriginalTotal);
            resetIntentData(intent, "is_random_cut", Boolean.valueOf(this.mIsRandomCut));
            resetIntentData(intent, "user_attr", Integer.valueOf(this.mUserAttr));
            resetIntentData(intent, "interf_cache_ver", this.mCacheVer);
            resetIntentData(intent, "cert_user", Integer.valueOf(this.mUserCertType));
            resetIntentData(intent, "uin", this.mUin);
            resetIntentData(intent, IQzoneWebViewPluginHelper.EXTRA_FAMOUS_SHARE_NICKNAME, this.mUserNick);
            resetIntentData(intent, "wallet_bind", Integer.valueOf(this.mEnterType));
            resetIntentData(intent, "token_id", this.mPayTokenId);
            resetIntentData(intent, "come_from", Integer.valueOf(this.mComeFrom));
            resetIntentData(intent, com.tencent.mobileqq.msf.core.c0.j.T0, this.mAppInfo);
            resetIntentData(intent, "subscribe_info", this.mSubscribeInfo);
            resetIntentData(intent, "service_id", this.mServiceId);
            resetIntentData(intent, "exec_code", getIntent().getStringExtra("exec_code"));
            QwLog.i("is_inner: " + intent.hasExtra("is_inner"));
            if (!intent.hasExtra("is_inner")) {
                intent.putExtra(SDKCallbackManager.SESSION_RECEIVER, getIntent().getParcelableExtra(SDKCallbackManager.SESSION_RECEIVER));
            }
            resetIntentData(intent, "guid", this.mGuid);
            resetIntentData(intent, "appid", this.mAppid);
            resetIntentData(intent, "is_midas", Boolean.valueOf(this.mIsMidas));
            resetIntentData(intent, "midas_paytype", Integer.valueOf(this.mLocType));
            resetIntentData(intent, "pass_flag", this.mPassFlag);
            resetIntentData(intent, "isH5Withdraw", Boolean.valueOf(this.mIsH5Withdraw));
            resetIntentData(intent, "h5_success", Boolean.valueOf(this.mIsH5Success));
            resetIntentData(intent, "show_native_paysucc", Boolean.valueOf(this.mShowNativePaySuccess));
            resetIntentData(intent, "touchid_state", Integer.valueOf(this.mTouchidState));
            resetIntentData(intent, "touchid_state_info", this.mTouchidStateInfo);
            resetIntentData(intent, "touchid_retry_count", Integer.valueOf(this.mTouchidRetryMaxCount));
            resetIntentData(intent, "authen_channel_state", Integer.valueOf(this.authen_channel_state));
            resetIntentData(intent, "prossesId", Long.valueOf(this.mProssesID));
            resetIntentData(intent, "ad_display", Integer.valueOf(this.mAdDisplay));
            resetIntentData(intent, "bargainor_id", this.mBargainorId);
            resetIntentData(intent, HippyHeaderListViewController.VIEW_TAG, this.mProcessViewTag);
            resetIntentData(intent, "back_button_text", this.back_button_text);
            resetIntentData(intent, "newprice", this.newprice);
            resetIntentData(intent, "subscribe_default_option", Integer.valueOf(this.subscribe_default_option));
            resetIntentData(intent, ApiGotoview.CALLBACK_WHEN_CANCEL_PAY, Boolean.valueOf(this.callback_when_cancel_pay));
        } catch (Exception e16) {
            QLog.e(this.TAG, 1, "", e16);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setKeyboardTouchOutsizeCancel(MyKeyboardWindow myKeyboardWindow) {
        this.mMyKeyboardWindow = myKeyboardWindow;
    }

    public void setRetCodeAndErrorMsg(int i3, String str) {
        setRetCodeMsgAndGetBundle(i3, String.format(ErrorCode.ERR_STR_FORMAT, str));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Bundle setRetCodeAndGetBundle(int i3) {
        this.ret_code = i3;
        return this.ret_bundle;
    }

    public Bundle setRetCodeMsgAndGetBundle(int i3, String str) {
        this.ret_bundle.putString("retmsg", str);
        return setRetCodeAndGetBundle(i3);
    }

    public void setServerAddr(String str) {
        Cgi.domain_name = str;
        SharedPreferences sharedPreferences = getSharedPreferences("qb_tenpay_addr", 0);
        if (sharedPreferences != null) {
            SharedPreferences.Editor edit = sharedPreferences.edit();
            edit.putString("server_addr", Cgi.domain_name);
            edit.commit();
        }
    }

    public void showOkTips(String str, DialogInterface.OnDismissListener onDismissListener) {
        if (isFinishing()) {
            return;
        }
        OkTipsDialog okTipsDialog = this.mOkTips;
        if (okTipsDialog == null || !okTipsDialog.isShowing()) {
            this.mOkTips = new OkTipsDialog(getContext(), R.style.f174210t1);
        }
        this.mOkTips.setMessage(str);
        this.mOkTips.setCancelable(false);
        this.mOkTips.setOnDismissListener(onDismissListener);
        this.mOkTips.show();
    }

    public void showOkTipsWithSubTitle(Context context, String str, String str2, DialogInterface.OnDismissListener onDismissListener) {
        if (isFinishing()) {
            return;
        }
        OkTipWithSubTitleDialog okTipWithSubTitleDialog = this.mSubtitleTips;
        if (okTipWithSubTitleDialog == null || !okTipWithSubTitleDialog.isShowing()) {
            this.mSubtitleTips = new OkTipWithSubTitleDialog(context, R.style.f174210t1);
        }
        this.mSubtitleTips.setMessage(str, str2);
        this.mSubtitleTips.setCancelable(false);
        this.mSubtitleTips.setOnDismissListener(onDismissListener);
        this.mSubtitleTips.show();
    }

    public void startActivityForResult(Intent intent, Class<? extends QWalletBaseFragment> cls, IResult iResult) {
        if (resultCounter >= Short.MAX_VALUE) {
            resultCounter = (short) 0;
        }
        Map<Integer, IResult> map = this.mResultMap;
        short s16 = (short) (resultCounter + 1);
        resultCounter = s16;
        map.put(Integer.valueOf(s16), iResult);
        launchFragmentForResult(intent, cls, resultCounter);
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public /* bridge */ /* synthetic */ boolean useArgusLifecycle() {
        return ne0.a.f(this);
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public /* bridge */ /* synthetic */ ViewModel getViewModel(String str, @NonNull Class cls) {
        return ne0.a.c(this, str, cls);
    }
}
