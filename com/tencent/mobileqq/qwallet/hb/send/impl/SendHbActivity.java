package com.tencent.mobileqq.qwallet.hb.send.impl;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.os.ResultReceiver;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import androidx.activity.result.ActivityResultCaller;
import androidx.annotation.NonNull;
import androidx.core.internal.view.SupportMenu;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;
import com.google.gson.GsonBuilder;
import com.huawei.hms.adapter.internal.CommonCode;
import com.qwallet.temp.IQWalletTemp;
import com.tencent.ark.ark;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.hippy.qq.view.scroll.HippyHeaderListViewController;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.PayBridgeActivity;
import com.tencent.mobileqq.activity.fling.FlingConstant;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.annotation.RoutePage;
import com.tencent.mobileqq.qwallet.api.INewQWalletApi;
import com.tencent.mobileqq.qwallet.api.IQWalletNickNameApi;
import com.tencent.mobileqq.qwallet.api.IQWalletUnitedConfigApi;
import com.tencent.mobileqq.qwallet.data.SendQrCodeHbResult;
import com.tencent.mobileqq.qwallet.hb.HbInfo;
import com.tencent.mobileqq.qwallet.hb.panel.recommend.HbListRecommendSkinViewModel;
import com.tencent.mobileqq.qwallet.hb.send.model.HbSkinViewModel;
import com.tencent.mobileqq.qwallet.report.impl.ReportUtils;
import com.tencent.mobileqq.relation.api.IContactUtilsApi;
import com.tencent.mobileqq.selectmember.ISelectMemberActivityConstants;
import com.tencent.mobileqq.selectmember.ResultRecord;
import com.tencent.mobileqq.selectmember.api.ISelectMemberApi;
import com.tencent.mobileqq.troop.api.ITroopHWApi;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.vas.vipav.api.VipFunCallConstants;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmini.sdk.launcher.core.proxy.PayProxy;
import com.tencent.util.QQToastUtil;
import com.tenpay.realname.RealNameSource;
import cooperation.qwallet.plugin.IQWalletHelper;
import cooperation.qwallet.plugin.QWalletPayBridge;
import cooperation.qwallet.plugin.QWalletPayProgressDialog;
import cooperation.qwallet.plugin.impl.QWalletHelperImpl;
import cooperation.qzone.QzoneIPCModule;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import mqq.app.MobileQQ;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
@RoutePage(desc = "QQ\u94b1\u5305-\u53d1\u7ea2\u5305\u754c\u9762", path = "/qwallet/redpacket/sendhb")
/* loaded from: classes16.dex */
public class SendHbActivity extends QBaseActivity implements View.OnClickListener {
    private static final int BROADCAST_VIDEO_TYPE = 999;
    private static final int ERR_IDIOM_RECOMMEND = 66249000;
    private static final int ERR_NOT_REGISTER = 66238025;
    private static final String RECEIVER_ACTION = "com.qwallet.report";
    public static final int REQUEST_CODE_PAY_HB = 1002;
    public static final int REQUEST_CODE_QCIRCLE_MAKE = 1001;
    private static final String TAG = "SendHbActivity";
    private static final String TAG_Hb_CALLBACK = "sendHbCallback";
    private static final String TAG_QRCODE_Hb_CALLBACK = "qrcodeHbCallback";
    private String callbackSn;
    private QWalletPayProgressDialog dialog;
    private String hbFromType;
    private HbListRecommendSkinViewModel hbListRecommendskinViewModel;
    private boolean isConfirm;
    private String mAppInfo;
    private int mComeFrom;
    private long mEnterTime;
    private String mGuildId;
    private Intent mIntent;
    private boolean mIsH5;
    private boolean mIsTheme;
    private String mListId;
    private JSONObject mPaySuccessObj;
    private String mRecvNick;
    private String mRecvType;
    private String mRecvTypeUpload;
    private String mRecvUin;
    private View mSendLayout;
    private String mSubGuildId;
    public String mThemeType;
    private String mUin;
    private Map<String, String> mapParams;
    public int nChannel;
    private View rootView;
    private ImageButton sendClose;
    private View stateBar;
    private HbSkinViewModel viewModel;
    private boolean isActivityPause = false;
    private BaseHbFragment fragment = null;
    private boolean mIsBackKeyPressed = false;
    private String mTotalAmount = "";
    private String mCount = "";
    private int nConfirm = -1;
    private BroadcastReceiver mHbReceiver = new a();
    List<Integer> hbCallbacks = new ArrayList(Arrays.asList(32768, 128, 256, 512, 2048));
    private boolean isJumpToWx = false;
    private boolean hasMsgBySelf = false;
    private BroadcastReceiver mReceiver = new d();
    Intent intent = new Intent();

    /* compiled from: P */
    /* loaded from: classes16.dex */
    class a extends BroadcastReceiver {
        a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            Bundle bundleExtra;
            String action = intent.getAction();
            if (SendHbActivity.RECEIVER_ACTION.equals(action)) {
                int intExtra = intent.getIntExtra("type", 0);
                QLog.i(SendHbActivity.TAG, 2, "onReceive type = " + intExtra);
                if (999 != intExtra || (bundleExtra = intent.getBundleExtra("params")) == null) {
                    return;
                }
                QLog.i(SendHbActivity.TAG, 2, "onReceive bundle = " + bundleExtra.toString());
                String string = bundleExtra.getString("from");
                if (!SendHbActivity.this.isFinishing() && "video".equals(string)) {
                    SendHbActivity.this.finish();
                    return;
                }
                return;
            }
            if ("com.tencent.mobileqq.qwallet.hb.skin.refresh".equals(action)) {
                int intExtra2 = intent.getIntExtra("hb_skin_refresh_from", 0);
                if (intExtra2 == 1 || intExtra2 == 2) {
                    int intExtra3 = intent.getIntExtra("hb_skin_refresh_skin_id", 0);
                    if (SendHbActivity.this.viewModel != null) {
                        SendHbActivity.this.viewModel.U1();
                    }
                    if (!com.tencent.mobileqq.qwallet.hb.aio.impl.d.g(SendHbActivity.this.mRecvType) && SendHbActivity.this.hbListRecommendskinViewModel != null) {
                        SendHbActivity.this.hbListRecommendskinViewModel.z2(1);
                    }
                    if (intExtra3 != 0 && SendHbActivity.this.viewModel != null) {
                        SendHbActivity.this.viewModel.W1(intExtra3, "", 0);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes16.dex */
    public class b implements DialogInterface.OnClickListener {
        b() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            Intent intent = new Intent();
            intent.putExtra("hb_id", SendHbActivity.this.mListId);
            intent.putExtra("send_uin", SendHbActivity.this.mUin);
            intent.putExtra("hb_type", "1");
            intent.putExtra(AppConstants.Key.FORWARD_TEXT, SendHbActivity.this.getString(R.string.edm));
            if (SendHbActivity.this.mIsTheme) {
                intent.putExtra(PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, 1);
            }
            intent.putExtra("forward_type", 17);
            intent.putExtra("invoke_from", "qwallet");
            ((IQWalletTemp) QRoute.api(IQWalletTemp.class)).startForwardActivity(SendHbActivity.this, intent);
            SendHbActivity.this.addHbUploadData("hongbao.wrapped.send");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes16.dex */
    public class c implements DialogInterface.OnClickListener {
        c() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            SendHbActivity.this.finish();
        }
    }

    /* compiled from: P */
    /* loaded from: classes16.dex */
    class d extends BroadcastReceiver {
        d() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            QLog.i(SendHbActivity.TAG, 1, "onReceive: action = " + action);
            if (ITroopHWApi.ACTION_START_VIDEO_CHAT.equals(action) && SendHbActivity.this.mIsTheme) {
                SendHbActivity sendHbActivity = SendHbActivity.this;
                if ((sendHbActivity.nChannel & 64) > 0) {
                    sendHbActivity.finish();
                    return;
                }
            }
            if ("com.tencent.mobileqq.qwallet.send.message".equals(action)) {
                QLog.i(SendHbActivity.TAG, 1, "isJumpToWx = " + SendHbActivity.this.isJumpToWx);
                if (!SendHbActivity.this.isJumpToWx) {
                    SendHbActivity.this.hasMsgBySelf = true;
                    return;
                } else {
                    SendHbActivity.this.finish();
                    return;
                }
            }
            if ("HB_PACK_WX_CHANNEL_SUCCESS".equals(action)) {
                SendHbActivity.this.finish();
            }
        }
    }

    private void addFragment(Fragment fragment) {
        FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
        if (fragment != null) {
            ((FrameLayout) findViewById(R.id.bcw)).setVisibility(0);
            Fragment findFragmentByTag = getSupportFragmentManager().findFragmentByTag(fragment.getClass().getName());
            if (findFragmentByTag != null) {
                beginTransaction.remove(findFragmentByTag);
            }
            beginTransaction.add(R.id.bcw, fragment, fragment.getClass().getName());
            beginTransaction.commitAllowingStateLoss();
        }
    }

    private Bundle buildParamsBundle() {
        Bundle bundle = new Bundle();
        for (String str : this.mapParams.keySet()) {
            bundle.putString(str, this.mapParams.get(str));
        }
        bundle.putString(WadlProxyConsts.CHANNEL, String.valueOf(this.nChannel));
        return bundle;
    }

    private boolean checkAndShowNewPayChannelDialog(JSONObject jSONObject, String str) {
        JSONArray optJSONArray;
        String str2;
        if (jSONObject == null || (optJSONArray = jSONObject.optJSONArray("pay_channel")) == null || optJSONArray.length() != 2 || !WXShareHelper.b0().e0()) {
            return false;
        }
        if (2048 == this.nChannel) {
            str2 = "11";
        } else if (com.tencent.mobileqq.qwallet.hb.aio.impl.d.g(this.mRecvType)) {
            str2 = "10";
        } else if (com.tencent.mobileqq.qwallet.hb.aio.impl.d.e(this.mRecvType)) {
            str2 = "8";
        } else {
            str2 = "9";
        }
        ((INewQWalletApi) QRoute.api(INewQWalletApi.class)).startHbPay(this, optJSONArray, str, Integer.toString(this.mComeFrom), str2, 1002);
        return true;
    }

    private boolean checkAndShowOldPayChannelDialog(JSONObject jSONObject, final String str) {
        JSONArray optJSONArray;
        if (jSONObject == null || (optJSONArray = jSONObject.optJSONArray("pay_channel")) == null || optJSONArray.length() != 2 || !WXShareHelper.b0().e0()) {
            return false;
        }
        ((INewQWalletApi) QRoute.api(INewQWalletApi.class)).createPayChannelDialog(optJSONArray, str, Integer.toString(this.mComeFrom), new ResultReceiver(null) { // from class: com.tencent.mobileqq.qwallet.hb.send.impl.SendHbActivity.2
            @Override // android.os.ResultReceiver
            protected void onReceiveResult(int i3, Bundle bundle) {
                super.onReceiveResult(i3, bundle);
                if (i3 == 0) {
                    SendHbActivity.this.pay(str);
                } else if (1 == i3) {
                    if (!SendHbActivity.this.hasMsgBySelf) {
                        SendHbActivity.this.isJumpToWx = true;
                    } else {
                        SendHbActivity.this.finish();
                    }
                }
            }
        }).show(getSupportFragmentManager(), "choose_pay_channel_dialog");
        return true;
    }

    private Map<String, String> conbineExtraParams(String str) {
        QLog.i(TAG, 2, "extra_data = " + str);
        HashMap<String, String> s16 = com.tencent.mobileqq.qwallet.impl.d.s(str);
        String remove = s16.remove("extra_info");
        if (!TextUtils.isEmpty(remove)) {
            s16.putAll(com.tencent.mobileqq.qwallet.impl.d.s(remove));
        }
        s16.put("send_name", this.mRecvNick);
        s16.put("send_uin", this.mUin);
        return s16;
    }

    private void finishIfHiddenMakeView() {
        if (com.tencent.mobileqq.qwallet.impl.d.m(this.mapParams, "makeHb_type", "0").equals("1")) {
            finish();
        }
    }

    private void initCustomHb() {
        int i3;
        if ("1".equals(com.tencent.mobileqq.qwallet.impl.d.m(this.mapParams, "makeHb_type", "0"))) {
            this.rootView.setVisibility(8);
            this.mTotalAmount = this.mapParams.get("total_amount");
            this.mCount = this.mapParams.get("total_num");
            if (this.hbFromType.equals("100")) {
                Map<String, String> mapPacketExtra = getMapPacketExtra();
                mapPacketExtra.put("type", "1");
                new bl2.g(this).b(mapPacketExtra);
                return;
            }
            new bl2.g(this).c();
            return;
        }
        if (this.mIsH5 && "h5".equals(this.mapParams.get("invoke_from")) && this.nChannel == 2048) {
            new bl2.g(this).a("", this.mUin);
            finish();
            return;
        }
        if (!this.mIsTheme && (i3 = this.nChannel) != 64) {
            if (i3 != 128 && i3 != 256 && i3 != 32768) {
                if (i3 != 1000005) {
                    int i16 = 1;
                    if (i3 == 4096) {
                        if ("1".equals(this.mRecvType) || "7".equals(this.mRecvType) || "6".equals(this.mRecvType)) {
                            i16 = 2;
                        }
                    } else if (!HbInfo.f277194b.contains(this.mRecvType)) {
                        int i17 = this.nChannel;
                        i16 = 3;
                        if (i17 != 2048 && i17 != 512) {
                            i16 = 0;
                        }
                    }
                    String string = getString(R.string.e7g);
                    if (this.nChannel == 512) {
                        string = getString(R.string.edn);
                    }
                    boolean booleanExtra = getIntent().getBooleanExtra("isFromPanel", false);
                    ArrayList<? extends Parcelable> parcelableArrayListExtra = getIntent().getParcelableArrayListExtra("panelEntryData");
                    Bundle buildParamsBundle = buildParamsBundle();
                    buildParamsBundle.putBoolean("isFromPanel", booleanExtra);
                    buildParamsBundle.putParcelableArrayList("panelEntryData", parcelableArrayListExtra);
                    buildParamsBundle.putInt("tabMask", i16);
                    buildParamsBundle.putString("hbTitle", string);
                    buildParamsBundle.putInt("skin_id", getIntent().getIntExtra("skin_id", 0));
                    SendHbMainFragment sendHbMainFragment = new SendHbMainFragment();
                    this.fragment = sendHbMainFragment;
                    sendHbMainFragment.setArguments(buildParamsBundle);
                } else {
                    initFestivalFragment();
                }
            } else {
                initQzoneFragment();
            }
        }
        if (!(this.fragment instanceof SendHbMainFragment) && 1000005 != this.nChannel) {
            new ul2.a(this, -1308622848, this.stateBar);
        }
        addFragment(this.fragment);
    }

    private void initData() {
        String currentNickname;
        this.mUin = getAppRuntime().getCurrentAccountUin();
        this.mIsTheme = this.mIntent.getBooleanExtra("theme", false);
        this.mIsH5 = this.mIntent.getBooleanExtra("is_H5", false);
        this.mComeFrom = this.mIntent.getIntExtra("come_from", 1);
        this.callbackSn = this.mIntent.getStringExtra("callbackSn");
        this.mAppInfo = this.mIntent.getStringExtra(com.tencent.mobileqq.msf.core.c0.j.T0);
        Map<String, String> conbineExtraParams = conbineExtraParams(this.mIntent.getStringExtra("extra_data"));
        this.mapParams = conbineExtraParams;
        this.hbFromType = com.tencent.mobileqq.qwallet.impl.d.m(conbineExtraParams, "hb_from_type", "0");
        this.mRecvUin = this.mapParams.get("recv_uin");
        this.mGuildId = this.mapParams.get("guild_id");
        this.mSubGuildId = this.mapParams.get("sub_guild_id");
        String str = this.mapParams.get("recv_type");
        this.mRecvType = str;
        this.mRecvTypeUpload = str;
        this.viewModel = (HbSkinViewModel) new ViewModelProvider(this).get(HbSkinViewModel.class);
        getLifecycle().addObserver(this.viewModel);
        this.hbListRecommendskinViewModel = (HbListRecommendSkinViewModel) new ViewModelProvider(this).get(HbListRecommendSkinViewModel.class);
        zk2.b.f452710a.n();
        if (!com.tencent.mobileqq.qwallet.hb.aio.impl.d.g(this.mRecvType)) {
            getLifecycle().addObserver(this.hbListRecommendskinViewModel);
            this.hbListRecommendskinViewModel.z2(1);
        }
        String currentNickName = ((IQWalletNickNameApi) QRoute.api(IQWalletNickNameApi.class)).getCurrentNickName(this.mRecvUin);
        this.mRecvNick = currentNickName;
        if (TextUtils.isEmpty(currentNickName)) {
            BaseQQAppInterface appInterface = ((IQWalletHelper) QRoute.api(IQWalletHelper.class)).getAppInterface();
            if (appInterface == null) {
                currentNickname = this.mUin;
            } else {
                currentNickname = appInterface.getCurrentNickname();
            }
            this.mRecvNick = currentNickname;
        }
        this.nChannel = x05.c.j(this.mapParams.get(WadlProxyConsts.CHANNEL), 1);
        QLog.i(TAG, 2, "mChannel = " + this.nChannel);
        if (!this.mIsTheme) {
            String str2 = this.mapParams.get("theme_type");
            this.mThemeType = str2;
            try {
                if (!TextUtils.isEmpty(str2) && Integer.valueOf(this.mThemeType).intValue() > 1) {
                    this.mIsTheme = true;
                }
            } catch (Exception e16) {
                QLog.e(TAG, 1, "error msg in qqpay-impl module: ", e16);
            }
        }
        if (TextUtils.isEmpty(this.mThemeType)) {
            this.mThemeType = this.mIntent.getStringExtra("theme_type");
        }
        if (com.tencent.mobileqq.qwallet.hb.aio.impl.d.g(this.mRecvType)) {
            this.mRecvNick = com.tencent.mobileqq.qwallet.hb.aio.impl.d.a(getAppRuntime(), this.mapParams.get("guild_id"), this.mapParams.get("tinyid"));
            return;
        }
        if (5 == this.nChannel) {
            this.nChannel = 16;
        }
        if (6 == this.nChannel) {
            this.nChannel = 32;
        }
        int i3 = this.nChannel;
        if (5 == i3 || 16 == i3 || 128 == i3 || 256 == i3) {
            String dateNickName = ((IContactUtilsApi) QRoute.api(IContactUtilsApi.class)).getDateNickName(this.mUin);
            this.mRecvNick = dateNickName;
            if (TextUtils.isEmpty(dateNickName) || TextUtils.equals(this.mRecvNick, this.mUin)) {
                this.mRecvNick = ((IQWalletNickNameApi) QRoute.api(IQWalletNickNameApi.class)).getNickNameSync(null, this.mUin);
            }
        }
    }

    private void initFestivalFragment() {
        SendFestivalHbFragment sendFestivalHbFragment = new SendFestivalHbFragment();
        this.fragment = sendFestivalHbFragment;
        sendFestivalHbFragment.setArguments(buildParamsBundle());
    }

    private void initView() {
        this.stateBar = findViewById(R.id.j1w);
        this.rootView = findViewById(R.id.root);
        this.mSendLayout = findViewById(R.id.ina);
        ImageButton imageButton = (ImageButton) findViewById(R.id.in8);
        this.sendClose = imageButton;
        imageButton.setOnClickListener(this);
        ((Button) findViewById(R.id.in9)).setOnClickListener(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showErrorDialog$0(DialogInterface dialogInterface, int i3) {
        dialogInterface.dismiss();
        finishIfHiddenMakeView();
    }

    private String mul(String str, String str2) {
        try {
            return new DecimalFormat("#0.00").format(new BigDecimal(str).multiply(new BigDecimal(str2)).doubleValue());
        } catch (Exception unused) {
            return "0";
        }
    }

    private void onCashPay(JSONObject jSONObject) {
        if (jSONObject.optBoolean("jump_to_wx", false)) {
            QLog.i(TAG, 1, "onCashPay: jump to wx");
            if (this.hasMsgBySelf) {
                finish();
                return;
            } else {
                this.isJumpToWx = true;
                return;
            }
        }
        String optString = jSONObject.optString("callback_url");
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("number#");
        stringBuffer.append(this.mCount);
        stringBuffer.append(",type#");
        if (!"1".equals(this.mRecvType) && !"7".equals(this.mRecvType) && !"4".equals(this.mRecvType) && !"5".equals(this.mRecvType)) {
            if ("2".equals(this.mRecvType)) {
                stringBuffer.append("crowd");
            } else {
                stringBuffer.append(VipFunCallConstants.KEY_GROUP);
            }
        } else {
            stringBuffer.append("person");
        }
        stringBuffer.append(",channel#");
        stringBuffer.append(this.nChannel);
        stringBuffer.append(",money#");
        stringBuffer.append(this.mTotalAmount);
        addHbUploadData("hongbao.wrap.success");
        if (optString == null) {
            QLog.w(TAG, 1, "onCashPay return url is null");
            return;
        }
        if (!TextUtils.isEmpty(this.mRecvUin) && this.nConfirm != 1 && !this.hbCallbacks.contains(Integer.valueOf(this.nChannel))) {
            onCommonHbResult(jSONObject, null);
            return;
        }
        String optString2 = jSONObject.optString("sp_data");
        if (2048 == this.nChannel) {
            sendConfirmRequest(TAG_QRCODE_Hb_CALLBACK, optString2);
        } else {
            sendConfirmRequest(TAG_Hb_CALLBACK, optString2);
        }
        this.mPaySuccessObj = jSONObject;
    }

    private void onLogicError(String str, int i3, String str2) {
        JSONObject jSONObject;
        if (this.isConfirm) {
            int i16 = this.nChannel;
            if (256 != i16 && 128 != i16) {
                if (!TextUtils.isEmpty(this.mRecvUin) && (jSONObject = this.mPaySuccessObj) != null) {
                    onCommonHbResult(jSONObject, null);
                }
            } else {
                Intent intent = new Intent();
                intent.putExtra("retmsg", str);
                setResult(-1, intent);
                finish();
            }
        }
        if (isFinishing()) {
            return;
        }
        if (!TextUtils.isEmpty(str2)) {
            if (i3 != ERR_NOT_REGISTER && i3 != ERR_IDIOM_RECOMMEND) {
                showErrorToast(str2);
            } else {
                showErrorDialog(str2);
            }
        }
        finishIfHiddenMakeView();
    }

    private void onOpenTenpayView(JSONObject jSONObject, JSONObject jSONObject2, int i3) {
        QLog.i(TAG, 1, "onOpenTenpayView, isConfirm=" + this.isConfirm + ", nChannel=" + this.nChannel);
        if (this.isConfirm) {
            this.isConfirm = false;
            this.nConfirm = -1;
            int optInt = jSONObject.optInt("state");
            if (1 != optInt && 2 != optInt) {
                int i16 = this.nChannel;
                if (256 != i16 && 128 != i16 && i16 != 32768) {
                    if (512 == i16) {
                        onVisitHbResult(jSONObject);
                        return;
                    } else {
                        showToast(getString(R.string.f171345e82), 0);
                        return;
                    }
                }
                onRewardHbResult(jSONObject);
                return;
            }
            if (TextUtils.isEmpty(this.mRecvUin)) {
                showShareUI();
                this.mListId = jSONObject.optString("send_listid");
                return;
            }
            int i17 = this.nChannel;
            if (256 != i17 && 128 != i17 && 512 != i17 && 2048 != i17) {
                JSONObject jSONObject3 = this.mPaySuccessObj;
                if (jSONObject3 != null) {
                    jSONObject = jSONObject3;
                }
                onCommonHbResult(jSONObject, jSONObject2);
                return;
            }
            if (2048 == i17) {
                onQrcodeHbResult(jSONObject);
                return;
            }
            return;
        }
        int i18 = this.nChannel;
        if (64 != i18 && i18 != 64) {
            this.nConfirm = jSONObject.optInt("is_confirm");
            String optString = jSONObject.optString("token_id");
            if (((IQWalletUnitedConfigApi) QRoute.api(IQWalletUnitedConfigApi.class)).isSwitchOn(IQWalletUnitedConfigApi.QWALLET_REVERT_TO_OLD_PAY_CHANNEL, false)) {
                if (checkAndShowOldPayChannelDialog(jSONObject, optString)) {
                    return;
                }
            } else if (checkAndShowNewPayChannelDialog(jSONObject, optString)) {
                return;
            }
            pay(optString);
            return;
        }
        JSONObject jSONObject4 = new JSONObject();
        try {
            jSONObject4.putOpt("token_id", jSONObject.optString("token_id"));
            jSONObject4.putOpt("total_amount", this.mTotalAmount);
        } catch (JSONException e16) {
            QLog.e(TAG, 1, "error msg in qqpay-impl module: ", e16);
        }
        setResult(-1, onGroupHbBack(i3, "", jSONObject4.toString()));
        finish();
    }

    private void onSendHbCallback(@NonNull JSONObject jSONObject) {
        JSONObject optJSONObject = jSONObject.optJSONObject("data");
        if (optJSONObject != null && optJSONObject.optInt("retcode", -1) == 0) {
            QQToastUtil.showQQToastInUiThread(2, "\u5df2\u53d1\u9001");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pay(String str) {
        String str2;
        ActivityResultCaller activityResultCaller = this.fragment;
        if (activityResultCaller != null && (activityResultCaller instanceof k)) {
            ((k) activityResultCaller).Zc();
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("tokenId", str);
            jSONObject.put(PayProxy.Source.PAY_REQUEST_PAY_COME_FROM, this.mComeFrom);
            jSONObject.put("h5_success", true);
            jSONObject.put("appInfo", this.mAppInfo);
            Bundle bundle = new Bundle();
            if (2048 == this.nChannel) {
                str2 = "11";
            } else if (com.tencent.mobileqq.qwallet.hb.aio.impl.d.g(this.mRecvType)) {
                str2 = "10";
            } else if (com.tencent.mobileqq.qwallet.hb.aio.impl.d.e(this.mRecvType)) {
                str2 = "8";
            } else {
                str2 = "9";
            }
            jSONObject.put("sourceId", str2);
            jSONObject.put(RealNameSource.EXTRA_KEY_SOURCE_NAME, RealNameSource.getSourceName(str2));
            bundle.putString(ark.ARKMETADATA_JSON, jSONObject.toString());
            bundle.putString("callbackSn", "0");
            PayBridgeActivity.tenpay(this, 9, bundle);
        } catch (Exception e16) {
            QLog.e(TAG, 1, "error msg in qqpay-impl module: ", e16);
        }
    }

    private void preMConnect() {
        Bundle bundle = new Bundle();
        bundle.putString("uin", this.mUin);
        bundle.putInt(QWalletPayBridge.Key.PAY_INVOKER_ID, 21);
        QWalletPayBridge.launchBackground(MobileQQ.sMobileQQ, bundle);
    }

    private void registBroadcast() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(ITroopHWApi.ACTION_START_VIDEO_CHAT);
        intentFilter.addAction("com.tencent.mobileqq.qwallet.send.message");
        intentFilter.addAction("HB_PACK_WX_CHANNEL_SUCCESS");
        try {
            registerReceiver(this.mReceiver, intentFilter);
        } catch (Exception e16) {
            QLog.e(TAG, 1, "error msg in qqpay-impl module: ", e16);
        }
    }

    private void registerHbBroadCast() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(RECEIVER_ACTION);
        intentFilter.addAction("com.tencent.mobileqq.qwallet.hb.skin.refresh");
        registerReceiver(this.mHbReceiver, intentFilter);
    }

    private void showErrorDialog(String str) {
        DialogUtil.createCustomDialog(this, 230, (String) null, str, (String) null, getString(R.string.e5j), new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.qwallet.hb.send.impl.ad
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                SendHbActivity.this.lambda$showErrorDialog$0(dialogInterface, i3);
            }
        }, (DialogInterface.OnClickListener) null).show();
    }

    private void showErrorToast(String str) {
        if (!this.isActivityPause && !isFinishing()) {
            SpannableString spannableString = new SpannableString(str);
            spannableString.setSpan(new ForegroundColorSpan(SupportMenu.CATEGORY_MASK), 0, spannableString.length(), 33);
            spannableString.setSpan(new AbsoluteSizeSpan(16, true), 0, spannableString.length(), 33);
            QQToast.makeText(this, 1, spannableString, 0).show(getTitleBarHeight(this));
        }
    }

    private void showShareUI() {
        this.rootView.setVisibility(0);
        this.mSendLayout.setVisibility(0);
        View view = this.stateBar;
        if (view != null) {
            view.setBackgroundColor(-1308622848);
        }
        addHbUploadData("hongbao.wrapped.show");
    }

    private String yuan2Fen(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return Long.toString((long) Double.valueOf(mul(str, "100")).doubleValue());
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    public void addHbUploadData(String str) {
        com.tencent.mobileqq.qwallet.c.c(str, Integer.valueOf(getProcessType()));
    }

    public void addQZoneHbUploadData(int i3, String str, int i16) {
        com.tencent.mobileqq.qwallet.c.c(str, Integer.valueOf(i3));
    }

    public void callForwardPage(String str, ArrayList<String> arrayList, int i3) {
        Intent intent = new Intent();
        if ("2".equals(str)) {
            intent.putExtra(ISelectMemberActivityConstants.PARAM_ONLY_DISCUSSION_MEMBER, true);
        } else if ("3".equals(str)) {
            intent.putExtra(ISelectMemberActivityConstants.PARAM_ONLY_TROOP_MEMBER, true);
        }
        intent.putExtra(ISelectMemberActivityConstants.PARAM_TITLE, getString(R.string.e4_));
        intent.putExtra(ISelectMemberActivityConstants.PARAM_MIN, 0);
        intent.putExtra(ISelectMemberActivityConstants.PARAM_DONE_BUTTON_WORDING, getString(R.string.f173097hd1));
        intent.putExtra(ISelectMemberActivityConstants.PARAM_DONE_BUTTON_HIGHLIGHT_WORDING, getString(R.string.f173098hd2));
        intent.putExtra(ISelectMemberActivityConstants.PARAM_MAX, i3);
        intent.putExtra(ISelectMemberActivityConstants.PARAM_ENTRANCE, 25);
        if (arrayList != null && arrayList.size() > 0) {
            ArrayList arrayList2 = new ArrayList();
            Iterator<String> it = arrayList.iterator();
            while (it.hasNext()) {
                String next = it.next();
                new ResultRecord().uin = next;
                arrayList2.add(com.tencent.mobileqq.selectmember.e.a(next, "", 0, this.mUin));
            }
            intent.putExtra(ISelectMemberActivityConstants.PARAM_SELECTED_RECORDS_FOR_CREATE_DISCURRION, arrayList2);
        }
        intent.putExtra("group_uin", this.mRecvUin);
        String currentAccountUin = getAppRuntime().getCurrentAccountUin();
        if (!TextUtils.isEmpty(currentAccountUin)) {
            ArrayList arrayList3 = new ArrayList();
            arrayList3.add(currentAccountUin);
            intent.putExtra(ISelectMemberActivityConstants.PARAM_HIDE_UIN_LIST, arrayList3);
        }
        ((ISelectMemberApi) QRoute.api(ISelectMemberApi.class)).startSelectMemberActivityForResult(this, intent, 1024);
    }

    public void cancelCallBack() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(QzoneIPCModule.RESULT_CODE, -1);
        } catch (Exception unused) {
        }
        Intent intent = new Intent();
        intent.putExtra("callbackSn", this.callbackSn);
        intent.putExtra(QWalletPayBridge.Key.PAY_INVOKER_ID, 5);
        intent.putExtra("result", jSONObject.toString());
        setResult(0, intent);
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, false, true);
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, dispatchTouchEvent, false);
        return dispatchTouchEvent;
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnBackPressed() {
        QLog.i(TAG, 2, "SendHbActivity doOnBackPressed...");
        setResult(0, new Intent());
        super.doOnBackPressed();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public boolean doOnCreate(Bundle bundle) {
        Intent intent = getIntent();
        this.mIntent = intent;
        intent.putExtra(FlingConstant.FLING_ACTION_KEY, 0);
        this.mActNeedImmersive = false;
        initRequestedOrientation();
        super.doOnCreate(bundle);
        try {
            registerHbBroadCast();
            setProgressBarIndeterminateVisibility(false);
            setContentView(R.layout.aga);
            initData();
            initView();
            initCustomHb();
            registBroadcast();
            ((IQWalletHelper) QRoute.api(IQWalletHelper.class)).preloadQWallet(MobileQQ.sMobileQQ.peekAppRuntime());
            if (QWalletHelperImpl.isNeedPreConnect(this, this.mUin, "type_mqq_and_myun")) {
                preMConnect();
            }
            com.tencent.mobileqq.qwallet.hb.panel.preview.f fVar = com.tencent.mobileqq.qwallet.hb.panel.preview.f.f277592a;
            if (fVar.d() != null) {
                fVar.f();
                return true;
            }
            if (com.tencent.mobileqq.qwallet.hb.aio.impl.d.g(this.mRecvType)) {
                fVar.g(this.mGuildId, this.mSubGuildId);
                return true;
            }
            return true;
        } catch (OutOfMemoryError unused) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnDestroy() {
        String str;
        if (com.tencent.mobileqq.qwallet.hb.aio.impl.d.g(this.mRecvType)) {
            str = this.mGuildId;
        } else {
            str = this.mRecvUin;
        }
        ReportUtils.g("redpack.send.showtime", this.mRecvType, "", String.valueOf(NetConnInfoCenter.getServerTimeMillis() - this.mEnterTime), str);
        try {
            BroadcastReceiver broadcastReceiver = this.mReceiver;
            if (broadcastReceiver != null) {
                unregisterReceiver(broadcastReceiver);
            }
        } catch (Exception e16) {
            QLog.e(TAG, 1, "error msg in qqpay-impl module: ", e16);
        }
        com.tencent.mobileqq.qwallet.hb.panel.preview.f.f277592a.b();
        try {
            unregisterReceiver(this.mHbReceiver);
        } catch (Exception e17) {
            QLog.e(TAG, 1, "error msg in qqpay-impl module: ", e17);
        }
        super.doOnDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnNewIntent(Intent intent) {
        super.doOnNewIntent(intent);
        switchToUsualHbFragment(null);
        int intExtra = intent.getIntExtra("skin_id", 0);
        HbSkinViewModel hbSkinViewModel = this.viewModel;
        if (hbSkinViewModel != null) {
            hbSkinViewModel.W1(intExtra, "", 0);
        }
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
        this.isActivityPause = false;
        addHbUploadData("hongbao.wrap.show");
        this.mEnterTime = NetConnInfoCenter.getServerTimeMillis();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnStop() {
        super.doOnStop();
    }

    public int getForwardItem() {
        String m3 = com.tencent.mobileqq.qwallet.impl.d.m(com.tencent.mobileqq.qwallet.impl.d.s(this.mapParams.get("selector")), "friend_type", "1");
        if (m3.equals("1")) {
            return 1;
        }
        if (m3.equals("2")) {
            return 16;
        }
        if (m3.equals("3")) {
            return 256;
        }
        if (m3.equals("1|2")) {
            return 17;
        }
        if (m3.equals("1|3")) {
            return 257;
        }
        if (m3.equals("2|3")) {
            return 272;
        }
        if (m3.equals("1|2|3")) {
            return 273;
        }
        return 0;
    }

    public HbListRecommendSkinViewModel getHbListRecommendskinViewModel() {
        return this.hbListRecommendskinViewModel;
    }

    public Map<String, String> getMapPacketExtra() {
        HashMap hashMap = new HashMap(this.mapParams);
        hashMap.put("name", this.mRecvNick);
        if (2048 != this.nChannel) {
            hashMap.put("recv_type", this.mRecvTypeUpload);
        }
        hashMap.put("hb_from_type", this.hbFromType + "");
        return hashMap;
    }

    public Map<String, String> getMapPacketJson() {
        HashMap hashMap = new HashMap();
        hashMap.put("userId", this.mUin);
        hashMap.put(HippyHeaderListViewController.VIEW_TAG, "sendHb");
        hashMap.put(PayProxy.Source.PAY_REQUEST_PAY_COME_FROM, "2");
        hashMap.put("appInfo", this.mAppInfo);
        return hashMap;
    }

    protected int getProcessType() {
        int i3;
        if (this.mIsH5) {
            i3 = 131;
        } else if (TextUtils.isEmpty(this.mRecvType)) {
            if (HbInfo.f277195c.contains(this.mRecvType)) {
                i3 = 133;
            } else {
                i3 = 132;
            }
        } else {
            i3 = com.tencent.luggage.wxa.ig.s.CTRL_INDEX;
        }
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "getProcessType: processFlag:" + i3);
        }
        return i3;
    }

    public int getTitleBarHeight(Context context) {
        try {
            return context.getResources().getDimensionPixelSize(R.dimen.title_bar_height) - ((int) (context.getResources().getDisplayMetrics().density * 5.0f));
        } catch (Exception unused) {
            return 0;
        }
    }

    public HbSkinViewModel getViewModel() {
        return this.viewModel;
    }

    public void initQzoneFragment() {
        this.fragment = new QzoneHbFragment();
        this.fragment.setArguments(buildParamsBundle());
    }

    protected void initRequestedOrientation() {
        if (AppSetting.o(this)) {
            setRequestedOrientation(-1);
        } else {
            setRequestedOrientation(1);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Can't wrap try/catch for region: R(10:12|(8:16|17|18|(3:20|(3:24|25|26)|(1:31))(1:61)|32|33|34|(1:(2:50|51)(2:52|(2:54|55)(2:56|57)))(1:(2:38|(2:40|(1:44)(2:42|43))(2:45|46))(2:47|48)))|65|18|(0)(0)|32|33|34|(0)|(0)(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x00cb, code lost:
    
        r3 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x00cc, code lost:
    
        com.tencent.qphone.base.util.QLog.w(com.tencent.mobileqq.qwallet.hb.send.impl.SendHbActivity.TAG, 2, "dialog.dismiss: ", r3);
     */
    /* JADX WARN: Removed duplicated region for block: B:20:0x007a  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00f0  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00f4  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00c3  */
    @Override // mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onActivityResult(int i3, int i16, Intent intent) {
        JSONObject jSONObject;
        int i17;
        String str;
        super.onActivityResult(i3, i16, intent);
        com.tencent.mobileqq.qwallet.utils.f.b(TAG, "onActivityResult requestCode = " + i3 + " resultCode = " + i16 + ", data = " + intent);
        BaseHbFragment baseHbFragment = this.fragment;
        if (baseHbFragment != null) {
            baseHbFragment.onActivityResult(i3, i16, intent);
        }
        this.isActivityPause = false;
        if (intent != null && i16 == -1) {
            if (i3 == 1001) {
                return;
            }
            String stringExtra = intent.getStringExtra("result");
            JSONObject jSONObject2 = null;
            if (stringExtra != null && stringExtra.length() > 0) {
                try {
                    jSONObject = new JSONObject(stringExtra);
                } catch (Exception e16) {
                    QLog.e(TAG, 1, "error msg in qqpay-impl module: ", e16);
                }
                QLog.i(TAG, 2, "onActivityResult resultData = " + jSONObject);
                if (jSONObject == null) {
                    str = jSONObject.optString("retmsg");
                    i17 = jSONObject.optInt(QzoneIPCModule.RESULT_CODE, -1);
                    String optString = jSONObject.optString("data");
                    if (optString != null && optString.length() > 0) {
                        try {
                            jSONObject2 = new JSONObject(optString);
                        } catch (Exception e17) {
                            QLog.e(TAG, 1, "error msg in qqpay-impl module: ", e17);
                        }
                    }
                    if (i17 != 0) {
                        QLog.w(TAG, 1, "onActivityResult fail: " + str + ";" + i17);
                    }
                } else {
                    i17 = -1;
                    str = null;
                }
                this.dialog.dismiss();
                if (i17 != 0 && jSONObject2 != null) {
                    if (i3 != 5) {
                        if (i3 != 9) {
                            if (i3 == 1002) {
                                onCashPay(jSONObject2);
                                return;
                            }
                            return;
                        }
                        onCashPay(jSONObject2);
                        return;
                    }
                    onOpenTenpayView(jSONObject2, jSONObject, i17);
                    return;
                }
                if (i17 <= 0) {
                    onLogicError(stringExtra, i17, str);
                    return;
                }
                if (i17 < -10) {
                    showToast(HardCodeUtil.qqStr(R.string.tax) + i17, 0);
                    finishIfHiddenMakeView();
                    return;
                }
                Intent intent2 = new Intent();
                intent2.putExtra(QWalletPayBridge.Key.PAY_INVOKER_ID, 5);
                intent2.putExtra("result", stringExtra);
                setResult(-1, intent2);
                finishIfHiddenMakeView();
                return;
            }
            jSONObject = null;
            QLog.i(TAG, 2, "onActivityResult resultData = " + jSONObject);
            if (jSONObject == null) {
            }
            this.dialog.dismiss();
            if (i17 != 0) {
            }
            if (i17 <= 0) {
            }
        } else {
            finishIfHiddenMakeView();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        int id5 = view.getId();
        if (id5 == R.id.in9) {
            addHbUploadData("hongbao.wrapped.send");
            sendPackedHb();
        } else if (id5 == R.id.in8) {
            String str = getString(R.string.f171347ea0) + getString(R.string.e2e);
            String string = getString(R.string.e9r);
            if (this.mIsTheme) {
                str = getString(R.string.f171347ea0);
                string = getString(R.string.e4k);
            }
            showDialog(str, string, getString(R.string.f171350ea3));
            if (this.mIsBackKeyPressed) {
                addHbUploadData("hongbao.wrapped.keyback");
            } else {
                addHbUploadData("hongbao.wrapped.close");
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    protected void onCommonHbResult(JSONObject jSONObject, JSONObject jSONObject2) {
        com.tencent.mobileqq.qwallet.utils.f.b(TAG, "onCommonHbResult data = " + jSONObject);
        if (jSONObject == null) {
            return;
        }
        if (jSONObject2 != null) {
            onSendHbCallback(jSONObject2);
        }
        try {
            StringBuffer stringBuffer = new StringBuffer(Uri.decode(jSONObject.optString("callback_url")));
            String optString = jSONObject.optString("sp_data");
            if (!TextUtils.isEmpty(optString)) {
                stringBuffer.append("&sp_data=");
                stringBuffer.append(optString);
            }
            String optString2 = jSONObject.optString(CommonCode.MapKey.TRANSACTION_ID);
            if (!TextUtils.isEmpty(optString2)) {
                stringBuffer.append("&transaction_id=");
                stringBuffer.append(optString2);
            }
            String optString3 = jSONObject.optString("total_fee");
            if (!TextUtils.isEmpty(optString3)) {
                stringBuffer.append("&total_fee=");
                stringBuffer.append(optString3);
            }
            String optString4 = jSONObject.optString("pay_time");
            if (!TextUtils.isEmpty(optString4)) {
                stringBuffer.append("&pay_time=");
                stringBuffer.append(optString4);
            }
            JSONObject jSONObject3 = new JSONObject();
            try {
                JSONObject jSONObject4 = new JSONObject();
                jSONObject4.put("callback_url", stringBuffer.toString());
                jSONObject3.put(QzoneIPCModule.RESULT_CODE, 0);
                jSONObject3.put("retmsg", "SUCCESS");
                jSONObject3.put("data", jSONObject4);
            } catch (Exception unused) {
            }
            QLog.i(TAG, 2, "onCommonHbResult jdata = " + jSONObject3);
            Intent intent = new Intent();
            intent.putExtra("callbackSn", this.callbackSn);
            intent.putExtra(QWalletPayBridge.Key.PAY_INVOKER_ID, 5);
            intent.putExtra("result", jSONObject3.toString());
            setResult(-1, intent);
            finish();
        } catch (Exception e16) {
            QLog.e(TAG, 1, "error msg in qqpay-impl module: ", e16);
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }

    public Intent onGroupHbBack(int i3, String str, String str2) {
        Intent intent = new Intent();
        if (i3 == 0) {
            intent.putExtra("data", str2);
        } else {
            intent.putExtra("retmsg", str);
        }
        intent.putExtra("result", i3);
        return intent;
    }

    @Override // mqq.app.AppActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i3, KeyEvent keyEvent) {
        QLog.i(TAG, 2, "SendHbActivity onKeyDown keyCode = " + i3 + " event = " + keyEvent);
        if (i3 == 4) {
            this.mIsBackKeyPressed = true;
            BaseHbFragment baseHbFragment = this.fragment;
            if (baseHbFragment != null) {
                if (baseHbFragment instanceof HbSkinListFragment) {
                    ((HbSkinListFragment) baseHbFragment).Rh(i3);
                } else {
                    if (baseHbFragment instanceof SendHbMainFragment) {
                        ((SendHbMainFragment) baseHbFragment).Nh();
                    }
                    addHbUploadData("theme.pack.keyback");
                    cancelCallBack();
                    finish();
                }
            }
            return true;
        }
        return super.onKeyDown(i3, keyEvent);
    }

    protected void onQrcodeHbResult(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            SendQrCodeHbResult sendQrCodeHbResult = (SendQrCodeHbResult) new GsonBuilder().create().fromJson(jSONObject.toString(), SendQrCodeHbResult.class);
            ((INewQWalletApi) QRoute.api(INewQWalletApi.class)).saveQrCodeHbToken(sendQrCodeHbResult.getQrToken());
            Intent intent = new Intent();
            intent.putExtra("KEY_SEND_QRCODE_HB_RESULT", sendQrCodeHbResult);
            setResult(-1, intent);
            finish();
        } catch (Exception e16) {
            QLog.e(TAG, 1, "error msg in qqpay-impl module: ", e16);
        }
    }

    protected void onRewardHbResult(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        Intent intent = new Intent();
        intent.putExtra("retmsg", jSONObject.toString());
        setResult(-1, intent);
        finish();
    }

    protected void onVisitHbResult(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        Intent intent = new Intent();
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.putOpt("send_name", this.mRecvNick);
            jSONObject2.putOpt("send_uin", this.mUin);
            jSONObject2.putOpt("send_listid", jSONObject.optString("send_listid"));
            jSONObject2.putOpt("amount", jSONObject.optString("amount"));
            jSONObject2.putOpt("feedsid", this.mapParams.get("feedsid"));
            jSONObject2.putOpt(WadlProxyConsts.CHANNEL, this.nChannel + "");
        } catch (JSONException e16) {
            QLog.e(TAG, 1, "error msg in qqpay-impl module: ", e16);
        }
        JSONObject jSONObject3 = new JSONObject();
        try {
            jSONObject3.putOpt(QzoneIPCModule.RESULT_CODE, 0);
            jSONObject3.putOpt("retmsg", "");
            jSONObject3.putOpt("data", jSONObject2.toString());
        } catch (JSONException e17) {
            QLog.e(TAG, 1, "error msg in qqpay-impl module: ", e17);
        }
        intent.putExtra("result", jSONObject3.toString());
        intent.putExtra("callbackSn", this.callbackSn);
        intent.putExtra(QWalletPayBridge.Key.PAY_INVOKER_ID, 5);
        setResult(-1, intent);
        finish();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.AppActivity
    public void requestWindowFeature(Intent intent) {
        requestWindowFeature(1);
    }

    protected void sendConfirmRequest(String str, String str2) {
        int i3;
        QLog.i(TAG, 2, "sendConfirmRequest viewtag = " + str + " sp_data = " + str2);
        this.isConfirm = true;
        QWalletPayProgressDialog qWalletPayProgressDialog = new QWalletPayProgressDialog(this);
        this.dialog = qWalletPayProgressDialog;
        qWalletPayProgressDialog.show();
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("sp_data", str2);
            int i16 = this.nChannel;
            if (32768 == i16) {
                if (this.mRecvType.equals("1")) {
                    i3 = 1;
                } else {
                    i3 = 1024;
                }
                jSONObject.put(WadlProxyConsts.CHANNEL, i3);
            } else {
                jSONObject.put(WadlProxyConsts.CHANNEL, String.valueOf(i16));
            }
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("userId", this.mUin);
            jSONObject2.put(HippyHeaderListViewController.VIEW_TAG, str);
            jSONObject2.put(PayProxy.Source.PAY_REQUEST_PAY_COME_FROM, 2);
            jSONObject2.put("appInfo", this.mAppInfo);
            jSONObject2.put("extra_data", jSONObject.toString());
            PayBridgeActivity.tenpay(this, jSONObject2.toString(), 5, "0");
        } catch (Exception e16) {
            QLog.e(TAG, 1, "error msg in qqpay-impl module: ", e16);
        }
    }

    public void sendPackedHb() {
        this.intent.putExtra("hb_id", this.mListId);
        this.intent.putExtra("send_uin", this.mUin);
        this.intent.putExtra("hb_type", "1");
        this.intent.putExtra(AppConstants.Key.FORWARD_TEXT, getString(R.string.edm));
        HashMap<String, String> s16 = com.tencent.mobileqq.qwallet.impl.d.s(this.mapParams.get("selector"));
        int l3 = com.tencent.mobileqq.qwallet.impl.d.l(s16, "type", 0);
        if (this.mIsTheme) {
            this.intent.putExtra(PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, 1);
        } else if (this.hbFromType.equals("100") && l3 == 1) {
            this.intent.putExtra(PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, getForwardItem());
            this.intent.putExtra("title", com.tencent.mobileqq.qwallet.impl.d.m(s16, "title", HardCodeUtil.qqStr(R.string.tay)));
        }
        this.intent.putExtra("forward_type", 17);
        this.intent.putExtra("invoke_from", "qwallet");
        ((IQWalletTemp) QRoute.api(IQWalletTemp.class)).startForwardActivity(this, this.intent);
    }

    public void showCommonHbToast(CharSequence charSequence) {
        showToast(charSequence, 0);
    }

    public void showDialog(String str, String str2, String str3) {
        DialogUtil.createCustomDialog(this, 230, (String) null, str, str2, str3, new b(), new c()).show();
    }

    public void showQzoneHbToast(CharSequence charSequence) {
        showToast(charSequence, 0);
    }

    public void showToast(CharSequence charSequence, int i3) {
        if (!this.isActivityPause && !isFinishing()) {
            QQToast.makeText(this, i3, charSequence, 0).show(getTitleBarHeight(this));
        }
    }

    protected void switchFragment(BaseHbFragment baseHbFragment, boolean z16) {
        FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
        BaseHbFragment baseHbFragment2 = this.fragment;
        if (baseHbFragment2 != null && !baseHbFragment2.equals(baseHbFragment)) {
            beginTransaction.hide(this.fragment);
        }
        boolean isAdded = baseHbFragment.isAdded();
        if (isAdded && z16) {
            beginTransaction.show(baseHbFragment);
        } else if (!isAdded) {
            if (z16) {
                beginTransaction.remove(baseHbFragment);
            }
            beginTransaction.add(R.id.bcw, baseHbFragment, baseHbFragment.getClass().getName());
        }
        beginTransaction.commitAllowingStateLoss();
        this.fragment = baseHbFragment;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void switchToHbSkinListFragment(Bundle bundle) {
        boolean z16;
        HbSkinListFragment hbSkinListFragment = (HbSkinListFragment) getSupportFragmentManager().findFragmentByTag(HbSkinListFragment.class.getName());
        Bundle bundle2 = new Bundle();
        if (bundle != null) {
            bundle2.putAll(bundle);
        }
        if (hbSkinListFragment == null) {
            hbSkinListFragment = new HbSkinListFragment();
            bundle2.putAll(buildParamsBundle());
            z16 = false;
        } else {
            z16 = true;
        }
        hbSkinListFragment.setArguments(bundle2);
        switchFragment(hbSkinListFragment, z16);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void switchToUsualHbFragment(Bundle bundle) {
        boolean z16;
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        Bundle bundle2 = new Bundle();
        if (bundle != null) {
            bundle2.putAll(bundle);
        }
        SendHbMainFragment sendHbMainFragment = (SendHbMainFragment) supportFragmentManager.findFragmentByTag(SendHbMainFragment.class.getName());
        if (sendHbMainFragment == null) {
            sendHbMainFragment = new SendHbMainFragment();
            bundle2.putAll(buildParamsBundle());
            z16 = false;
        } else {
            z16 = true;
        }
        sendHbMainFragment.setArguments(bundle2);
        switchFragment(sendHbMainFragment, z16);
    }
}
