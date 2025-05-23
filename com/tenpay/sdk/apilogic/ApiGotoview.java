package com.tenpay.sdk.apilogic;

import android.app.Activity;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.ResultReceiver;
import android.text.TextUtils;
import com.qwallet.activity.patternlock.QWalletPatternLockGuardianFragment;
import com.qwallet.utils.QWalletUtils;
import com.tencent.ark.ark;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.hippy.qq.view.scroll.HippyHeaderListViewController;
import com.tencent.mobileqq.msf.core.c0.j;
import com.tencent.mobileqq.qwallet.hb.detail.HbDetailModule;
import com.tencent.mobileqq.qwallet.transaction.impl.NotifyMsgApiImpl;
import com.tencent.mobileqq.qwallet.utils.k;
import com.tencent.mobileqq.winkpublish.api.constant.FSPublishConstants;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.dtreport.api.DefaultTVKDataProvider;
import com.tenpay.QwLog;
import com.tenpay.api.TenpayInterface;
import com.tenpay.bank.BindBankModule;
import com.tenpay.fingerpay.FingerPaySettingSwitchFragment;
import com.tenpay.ndk.CertUtil;
import com.tenpay.payment.paymentin.PaymentInFragment;
import com.tenpay.payment.paymentout.PaymentOutFragment;
import com.tenpay.payment.qrcodehb.QrCodeHbFragment;
import com.tenpay.realname.RealNameSource;
import com.tenpay.sdk.Cgi;
import com.tenpay.sdk.QWalletFakeUrl;
import com.tenpay.sdk.SDKCallbackManager;
import com.tenpay.sdk.activity.CertActivity;
import com.tenpay.sdk.activity.ChangePassActivity;
import com.tenpay.sdk.activity.DepositStartActivity;
import com.tenpay.sdk.activity.FriendPayActivity;
import com.tenpay.sdk.activity.GrapHbActivity;
import com.tenpay.sdk.activity.GrapMchHbActivity;
import com.tenpay.sdk.activity.GrapSpecifyHBActivity;
import com.tenpay.sdk.activity.HbConfirmActivity;
import com.tenpay.sdk.activity.HbListActivity;
import com.tenpay.sdk.activity.PassVerifyActivity;
import com.tenpay.sdk.activity.PsdMgrActivity;
import com.tenpay.sdk.activity.ResetPassBridgeActivity;
import com.tenpay.sdk.activity.TransferOrderActivity;
import com.tenpay.sdk.activity.UnBindRemindActivity;
import com.tenpay.sdk.activity.WearVerifyActivity;
import com.tenpay.sdk.activity.WithdrawActivity;
import com.tenpay.sdk.basebl.TenpayBL;
import com.tenpay.sdk.basebl.UserInfo;
import com.tenpay.sdk.fakeurl.FakeInfo;
import com.tenpay.sdk.fakeurl.QWalletFakeUrlHandler;
import com.tenpay.sdk.fakeurl.utils.FakeUrlUtils;
import com.tenpay.sdk.helper.HttpHelper;
import com.tenpay.sdk.helper.PayHelper;
import com.tenpay.sdk.util.TenpayUtil;
import com.tenpay.util.Utils;
import cooperation.qwallet.plugin.IActivity;
import cooperation.qwallet.plugin.IQWalletHelper;
import cooperation.qwallet.plugin.ipc.QWalletResultReceiver;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes27.dex */
public class ApiGotoview extends ApiBaseGotoview {
    public static final String CALLBACK_WHEN_CANCEL_PAY = "callback_when_cancel_pay";
    private static final Map<String, Method> METHOD_MAP = new ConcurrentHashMap();
    public static final String SILENCE_PREFIX = "silence_";
    private static final String TAG = "Q.qwallet.ApiGotoview";

    public ApiGotoview(Context context, String str, String str2, Bundle bundle, ResultReceiver resultReceiver, JSONObject jSONObject, Service service) {
        super(context, str, str2, bundle, resultReceiver, jSONObject, service);
    }

    private void balance() {
        Context context = getContext();
        if (context == null) {
            return;
        }
        if (context instanceof Activity) {
            QWalletUtils.k((Activity) context, "mqqapi://wallet/open?viewtype=0&version=1&src_type=web&view=1");
        }
        this.callback.send(0, new Bundle());
    }

    private void bindCardVerify() {
        Context context = getContext();
        if (context == null) {
            return;
        }
        Intent newComIntent = newComIntent();
        newComIntent.putExtra("IsShiMing", true);
        if ("1".equals(this.ejson.optString("showIDCardVerify"))) {
            newComIntent.putExtra("IsIdVerifyValid", true);
        }
        String optString = this.ejson.optString("sourceId");
        String optString2 = this.ejson.optString(RealNameSource.EXTRA_KEY_SOURCE_NAME);
        if (TextUtils.isEmpty(optString)) {
            optString = this.params.getString("sourceId");
        }
        if (TextUtils.isEmpty(optString2)) {
            optString2 = this.params.getString(RealNameSource.EXTRA_KEY_SOURCE_NAME);
        }
        if (TextUtils.isEmpty(optString)) {
            optString = "0";
            optString2 = RealNameSource.getSourceName("0");
        }
        newComIntent.putExtra(RealNameSource.EXTRA_KEY_SOURCE, new RealNameSource(optString, optString2));
        BindBankModule.INSTANCE.startVerify(context, newComIntent);
    }

    private void bindNewCard() {
        Context context = getContext();
        if (context == null) {
            return;
        }
        Intent newComIntent = newComIntent();
        newComIntent.putExtra("bargainor_id", this.params.getString("bargainor_id"));
        newComIntent.putExtra("prefillUserInfo", this.ejson.optString("prefillUserInfo"));
        String optString = this.ejson.optString("sourceId");
        String optString2 = this.ejson.optString(RealNameSource.EXTRA_KEY_SOURCE_NAME);
        if (TextUtils.isEmpty(optString)) {
            optString = this.params.getString("sourceId");
        }
        if (TextUtils.isEmpty(optString2)) {
            optString2 = this.params.getString(RealNameSource.EXTRA_KEY_SOURCE_NAME);
        }
        if (TextUtils.isEmpty(optString)) {
            optString = "0";
            optString2 = RealNameSource.getSourceName("0");
        }
        newComIntent.putExtra(RealNameSource.EXTRA_KEY_SOURCE, new RealNameSource(optString, optString2));
        BindBankModule.INSTANCE.startWithSwitch(context, newComIntent, 3);
    }

    private void checkPsw() {
        Context context = getContext();
        if (context == null) {
            return;
        }
        com.tencent.mobileqq.base.c.d(context, newComIntent(), PassVerifyActivity.class);
    }

    private void checkPswInner() {
        Context context = getContext();
        if (context == null) {
            return;
        }
        com.tencent.mobileqq.base.c.d(context, newComIntent(), PassVerifyActivity.class);
    }

    private void deleteCardConform() {
        Context context = getContext();
        if (context == null) {
            return;
        }
        String optString = this.ejson.optString("bank_name");
        String optString2 = this.ejson.optString("card_tail");
        String optString3 = this.ejson.optString("bank_type");
        String optString4 = this.ejson.optString("bind_serial");
        String optString5 = this.ejson.optString("image_id");
        boolean optBoolean = this.ejson.optBoolean("skipConfirm");
        Intent newComIntent = newComIntent();
        newComIntent.putExtra("bank", optString);
        newComIntent.putExtra("cardTail", optString2);
        newComIntent.putExtra("bankType", optString3);
        newComIntent.putExtra("bankSerial", optString4);
        newComIntent.putExtra("bankIconId", optString5);
        newComIntent.putExtra("skipConfirm", optBoolean);
        newComIntent.putExtra("uin", this.uin);
        newComIntent.putExtra("callback", this.callback);
        newComIntent.putExtra(SDKCallbackManager.SESSION_RECEIVER, this.callback);
        com.tencent.mobileqq.base.c.d(context, newComIntent, UnBindRemindActivity.class);
    }

    @Deprecated
    private void deposit() {
        recharge();
    }

    private void findPsw() {
        Context context = getContext();
        if (context == null) {
            return;
        }
        Intent newComIntent = newComIntent();
        newComIntent.putExtra("forget_pass", true);
        newComIntent.putExtra("h5_find_pwd", true);
        com.tencent.mobileqq.base.c.d(context, newComIntent, ResetPassBridgeActivity.class);
    }

    private static Method getMethod(String str) throws NoSuchMethodException {
        Map<String, Method> map = METHOD_MAP;
        Method method = map.get(str);
        if (method == null) {
            Method declaredMethod = ApiGotoview.class.getDeclaredMethod(str, new Class[0]);
            map.put(str, declaredMethod);
            return declaredMethod;
        }
        return method;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void graphb() {
        Class cls;
        Context context = getContext();
        if (context == null) {
            return;
        }
        int optInt = this.ejson.optInt(WadlProxyConsts.CHANNEL);
        if (1 == this.ejson.optInt("silence_grap")) {
            new HttpHelper(this.callback, this.uin, optInt).silenceGrapHb(context, this.uin, this.params);
            return;
        }
        Intent newComIntent = newComIntent();
        newComIntent.putExtra("hb_sender_uin", this.params.getString("senderuin"));
        Iterator keys = this.ejson.keys();
        while (keys.hasNext()) {
            String obj = keys.next().toString();
            try {
                newComIntent.putExtra(obj, this.ejson.get(obj).toString());
            } catch (JSONException e16) {
                QLog.e(TAG, 1, "", e16);
            }
        }
        if (TextUtils.isEmpty(newComIntent.getStringExtra("senderuin"))) {
            newComIntent.putExtra("senderuin", this.params.getString("senderuin"));
        }
        QwLog.e("**channel from AIO is " + optInt);
        if (optInt == 1024) {
            cls = GrapSpecifyHBActivity.class;
        } else {
            cls = GrapHbActivity.class;
        }
        JSONObject optJSONObject = this.ejson.optJSONObject("detailinfo");
        QwLog.e("detail info received is " + optJSONObject);
        Class cls2 = GrapMchHbActivity.class;
        if (optJSONObject != null) {
            newComIntent.putExtra("detailinfo", optJSONObject.toString());
            int optInt2 = optJSONObject.optInt(WadlProxyConsts.CHANNEL, 0);
            cls = cls;
            if (optInt2 == 4) {
                newComIntent.putExtra(WadlProxyConsts.CHANNEL, optInt2 + "");
                cls = cls2;
            }
            if (optInt2 == 2) {
                newComIntent.putExtra(WadlProxyConsts.CHANNEL, optInt2 + "");
                cls = cls2;
            }
        }
        if (optInt != 2) {
            cls2 = cls;
        }
        com.tencent.mobileqq.base.c.d(context, newComIntent, cls2);
    }

    private void hbPackConfirm() {
        Context context = getContext();
        if (context == null) {
            return;
        }
        Intent newComIntent = newComIntent();
        newComIntent.putExtra("push_data", this.ejson.optString("push_data"));
        com.tencent.mobileqq.base.c.d(context, newComIntent, HbConfirmActivity.class);
    }

    private void idCardVerify() {
        Context context = getContext();
        if (context == null) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("uin", this.uin);
        hashMap.put("query_real_data", "1");
        TenpayBL tenpayBL = new TenpayBL();
        UserInfo userInfo = new UserInfo(this.uin, this.nick_name);
        String optString = this.ejson.optString("sourceId");
        String optString2 = this.ejson.optString(RealNameSource.EXTRA_KEY_SOURCE_NAME);
        if (TextUtils.isEmpty(optString)) {
            optString = this.params.getString("sourceId");
        }
        if (TextUtils.isEmpty(optString2)) {
            optString2 = this.params.getString(RealNameSource.EXTRA_KEY_SOURCE_NAME);
        }
        if (TextUtils.isEmpty(optString)) {
            optString = "0";
            optString2 = RealNameSource.getSourceName("0");
        }
        tenpayBL.setNetListener(new ApiQwalletIdCardVerifyNetListener(context, this.callback, userInfo, new RealNameSource(optString, optString2)));
        tenpayBL.doTask(context, Cgi.URL_WALLET_GATE, hashMap, "", "0", this.uin, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$openEmbelUrl$0(Context context, FakeInfo fakeInfo, Uri uri) {
        Activity activity;
        if (uri != null && TextUtils.equals(QWalletFakeUrlHandler.EnumFakeHost.transferInput.name(), uri.getHost())) {
            ResultReceiver resultReceiver = this.callback;
            if (resultReceiver == null && (context instanceof Activity)) {
                activity = (Activity) context;
                Intent intent = activity.getIntent();
                if (intent != null) {
                    resultReceiver = (ResultReceiver) intent.getParcelableExtra(SDKCallbackManager.SESSION_RECEIVER);
                }
            } else {
                activity = null;
            }
            if (resultReceiver != null) {
                resultReceiver.send(fakeInfo.getRetCode(), PayHelper.createResultForError(fakeInfo.getRetMsg()));
            }
            if (activity != null) {
                activity.finish();
            }
        }
        return null;
    }

    private void modifyPsw() {
        Context context = getContext();
        if (context == null) {
            return;
        }
        if (QwLog.getIsDevelop()) {
            try {
                this.ejson = new JSONObject("{\"tokenid\":\"852555654656565656\",\"verify_code\":\"2154545466666\"}");
            } catch (JSONException e16) {
                QLog.e(TAG, 1, "", e16);
            }
            resetPsw();
            return;
        }
        QLog.i(TAG, 1, "modifyPsw...");
        Intent newComIntent = newComIntent();
        newComIntent.putExtra("fromH5", true);
        com.tencent.mobileqq.base.c.d(context, newComIntent, ChangePassActivity.class);
    }

    private void openEmbelUrl() {
        final Context context = getContext();
        if (context == null) {
            return;
        }
        if (FakeUrlUtils.isUseNewFakeUrl()) {
            QWalletFakeUrlHandler qWalletFakeUrlHandler = new QWalletFakeUrlHandler(context, this.uin);
            qWalletFakeUrlHandler.setDispatcherCallback(new Function2() { // from class: com.tenpay.sdk.apilogic.a
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit lambda$openEmbelUrl$0;
                    lambda$openEmbelUrl$0 = ApiGotoview.this.lambda$openEmbelUrl$0(context, (FakeInfo) obj, (Uri) obj2);
                    return lambda$openEmbelUrl$0;
                }
            });
            qWalletFakeUrlHandler.dispatch(this.ejson.optString("url"));
        } else {
            QWalletFakeUrl qWalletFakeUrl = new QWalletFakeUrl(context, this.uin);
            qWalletFakeUrl.setCallback(this.callback);
            qWalletFakeUrl.onApiFakePros(this.ejson, null);
        }
    }

    private void openSchema() {
        Context context = getContext();
        if (context == null) {
            return;
        }
        String optString = this.ejson.optString("url");
        if (TextUtils.isEmpty(optString)) {
            QLog.w(TAG, 1, "openSchema fail: schema is null");
            return;
        }
        QLog.w(TAG, 1, "openSchema result: " + k.h(context, optString));
    }

    private void payByFriendConfirm() {
        Context context = getContext();
        if (context == null) {
            return;
        }
        Intent newComIntent = newComIntent();
        newComIntent.putExtra(IQWalletHelper.QWALLET_EXTRA_KEY_MQQ_RECEIVER, QWalletResultReceiver.getInstance());
        newComIntent.putExtra("from_out", true);
        com.tencent.mobileqq.base.c.d(context, newComIntent, FriendPayActivity.class);
    }

    private void payCode() {
        Context context = getContext();
        if (context == null) {
            return;
        }
        Intent newComIntent = newComIntent();
        newComIntent.putExtra("entry", this.ejson.optString("entry"));
        newComIntent.putExtra(IQWalletHelper.QWALLET_HOMEPAGE_IS_NEED_OPEN_PATTERN_LOCK, this.ejson.optBoolean(IActivity.PARAM_IS_USE_QWALLET_PATTERN_LOCK));
        newComIntent.putExtra(QWalletPatternLockGuardianFragment.EXTRA_IS_SHOW_PATTRENLOCK, this.ejson.optBoolean(IActivity.PARAM_IS_USE_QWALLET_PATTERN_LOCK, true));
        com.tencent.mobileqq.base.c.d(context, newComIntent, PaymentOutFragment.class);
    }

    private void pswManage() {
        Context context = getContext();
        if (context == null) {
            return;
        }
        com.tencent.mobileqq.base.c.d(context, newComIntent(), PsdMgrActivity.class);
    }

    private void pushMsg() {
        try {
            this.callback.send(0, new Bundle());
            Context context = getContext();
            if (context == null) {
                return;
            }
            Intent intent = new Intent(Cgi.BROADCAST_INTENT_ACTION_PUSH);
            intent.putExtra("extra_data", this.ejson.toString());
            context.sendBroadcast(intent);
        } catch (Exception e16) {
            QLog.e(TAG, 1, "", e16);
        }
    }

    private void qpayCert() {
        int i3;
        Context context = getContext();
        if (context == null) {
            return;
        }
        int optInt = this.ejson.optInt("if_type");
        String optString = this.ejson.optString("cert_id");
        if (optInt != 1) {
            if (optInt != 2) {
                if (optInt == 3) {
                    boolean isCertExist = CertUtil.getInstance(context).isCertExist(optString);
                    if (!isCertExist) {
                        CertUtil.removeCert(context, this.uin);
                    }
                    Bundle bundle = new Bundle();
                    try {
                        JSONObject jSONObject = new JSONObject();
                        if (isCertExist) {
                            i3 = 1;
                        } else {
                            i3 = 0;
                        }
                        jSONObject.put("isCertExist", i3);
                        bundle.putString("retdata", jSONObject.toString());
                    } catch (JSONException e16) {
                        QLog.e(TAG, 1, "", e16);
                    }
                    this.callback.send(0, bundle);
                    return;
                }
                return;
            }
            CertUtil.getInstance(context).clearCert(optString);
            CertUtil.removeCert(context, this.uin);
            this.callback.send(0, new Bundle());
            return;
        }
        com.tencent.mobileqq.base.c.d(context, newComIntent(), CertActivity.class);
    }

    private void qpay_hb_share() {
        Context context = getContext();
        if (context == null) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("uin", this.uin);
        hashMap.put("listid", this.ejson.optString("listid"));
        hashMap.put("send_uin", this.ejson.optString("send_uin"));
        hashMap.put("hb_type", this.ejson.optString("hb_type"));
        hashMap.put("recv_type", this.ejson.optString("recv_type"));
        hashMap.put("recv_uin", this.ejson.optString("recv_uin"));
        hashMap.put("group_id", this.ejson.optString("group_id"));
        hashMap.put("from_memo", this.ejson.optString("from_memo"));
        hashMap.put("appid", this.ejson.optString("appid"));
        String optString = this.ejson.optString("sp_data");
        if (!Utils.isEmpty(optString)) {
            hashMap.put("sp_data", Uri.decode(optString));
        }
        TenpayBL tenpayBL = new TenpayBL();
        tenpayBL.setNetListener(new ApiNetListener(context, this.callback, new UserInfo(this.uin, null), false, false));
        tenpayBL.doTask(context, Cgi.URI_HB_SHARE, hashMap, "", "0", this.uin, true);
    }

    private void qrcodeHb() {
        Context context = getContext();
        if (context == null) {
            return;
        }
        Intent newComIntent = newComIntent();
        newComIntent.addFlags(4194304);
        newComIntent.putExtra(QrCodeHbFragment.KEY_IN_QR_TOKEN, this.ejson.optString(QrCodeHbFragment.KEY_IN_QR_TOKEN));
        newComIntent.putExtra(QrCodeHbFragment.KEY_IN_QR_DATA, this.ejson.optString(QrCodeHbFragment.KEY_IN_QR_DATA));
        newComIntent.putExtra(QrCodeHbFragment.KEY_IN_NEED_CALLBACK_ON_DESTROY, true);
        newComIntent.putExtra("comeFrom", this.ejson.optInt("comeFrom"));
        com.tencent.mobileqq.base.c.d(context, newComIntent, QrCodeHbFragment.class);
    }

    private void qrcodeHbCallback() {
        Context context = getContext();
        if (context == null) {
            return;
        }
        String optString = this.ejson.optString("sp_data");
        String optString2 = this.ejson.optString(WadlProxyConsts.CHANNEL);
        QLog.i(TAG, 1, "qrcodeHbCallback:" + this.uin);
        if (TextUtils.isEmpty(this.uin)) {
            ResultReceiver resultReceiver = this.callback;
            if (resultReceiver != null) {
                resultReceiver.send(-101, PayHelper.createResultForError("sendQrcodeHbCallback fail! context is " + context + " | uin is " + this.uin));
                return;
            }
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("uin", this.uin);
        hashMap.put(WadlProxyConsts.CHANNEL, optString2);
        hashMap.put("sp_data", Uri.decode(optString));
        TenpayBL tenpayBL = new TenpayBL();
        tenpayBL.setNetListener(new ApiNetListener(context, this.callback, new UserInfo(this.uin, null), true, false));
        tenpayBL.doTask(context, Cgi.URI_MAKE_QRCODE_HB_CALLBACK, hashMap, "", "0", this.uin, true);
    }

    private void recharge() {
        Context context = getContext();
        if (context == null) {
            return;
        }
        Intent newComIntent = newComIntent();
        boolean z16 = true;
        if (1 != this.params.getInt("come_from")) {
            z16 = false;
        }
        newComIntent.putExtra("isH5Withdraw", z16);
        com.tencent.mobileqq.base.c.d(context, newComIntent, DepositStartActivity.class);
    }

    private void redgiftDetail() {
        Context context = getContext();
        if (context == null) {
            return;
        }
        Intent newComIntent = newComIntent();
        newComIntent.putExtra("listid", this.ejson.optString("listid"));
        newComIntent.putExtra(FSPublishConstants.FSPublishJsBridge.JSON_OBJECT_KEY_GROUP_ID, this.ejson.optString(FSPublishConstants.FSPublishJsBridge.JSON_OBJECT_KEY_GROUP_ID));
        newComIntent.putExtra("grouptype", this.ejson.optInt("grouptype", -1));
        String string = this.params.getString("grouptype");
        if (!TextUtils.isEmpty(string)) {
            newComIntent.putExtra("grouptype", string);
        }
        String string2 = this.params.getString(FSPublishConstants.FSPublishJsBridge.JSON_OBJECT_KEY_GROUP_ID);
        if (!TextUtils.isEmpty(string2)) {
            newComIntent.putExtra(FSPublishConstants.FSPublishJsBridge.JSON_OBJECT_KEY_GROUP_ID, string2);
        }
        newComIntent.putExtra("tinyId", this.params.getString("tinyId"));
        newComIntent.putExtra("guildId", this.params.getString("guildId"));
        newComIntent.putExtra("subGuildId", this.params.getString("subGuildId"));
        newComIntent.putExtra("name", this.ejson.optString("name"));
        newComIntent.putExtra("answer", this.ejson.optString("answer"));
        newComIntent.putExtra("authkey", this.ejson.optString("authkey"));
        newComIntent.putExtra("from_out", true);
        HbDetailModule.k(context, newComIntent, false);
    }

    private void redgiftRecord() {
        Context context = getContext();
        if (context == null) {
            return;
        }
        Intent newComIntent = newComIntent();
        String optString = this.ejson.optString("tab_index");
        if (!TextUtils.isEmpty(optString)) {
            newComIntent.putExtra("tab_index", optString);
        }
        String string = this.params.getString(FSPublishConstants.FSPublishJsBridge.JSON_OBJECT_KEY_GROUP_ID);
        String string2 = this.params.getString("grouptype");
        if (!TextUtils.isEmpty(string2)) {
            newComIntent.putExtra("grouptype", string2);
        }
        if (!TextUtils.isEmpty(string)) {
            newComIntent.putExtra(FSPublishConstants.FSPublishJsBridge.JSON_OBJECT_KEY_GROUP_ID, string);
        }
        newComIntent.putExtra(NotifyMsgApiImpl.KEY_GROUP_TYPE, string2);
        newComIntent.putExtra("from_out", true);
        com.tencent.mobileqq.base.c.d(context, newComIntent, HbListActivity.class);
    }

    private void resetPsw() {
        Context context = getContext();
        if (context == null) {
            return;
        }
        HashMap<String, String> jsonToMap = Utils.jsonToMap(this.ejson);
        Intent newComIntent = newComIntent();
        newComIntent.putExtra("entry_mark_resetpwd", true);
        newComIntent.putExtra("fromH5", true);
        newComIntent.putExtra("tokenid", jsonToMap.get("tokenid"));
        newComIntent.putExtra("verify_code", jsonToMap.get("verify_code"));
        newComIntent.putExtra("idkey", jsonToMap.get("idkey"));
        newComIntent.putExtra("busi_info", jsonToMap.get("busi_info"));
        com.tencent.mobileqq.base.c.d(context, newComIntent, ChangePassActivity.class);
    }

    private void rewardTransferInput() {
        Context context = getContext();
        if (context == null) {
            return;
        }
        Intent newComIntent = newComIntent();
        newComIntent.putExtra(HippyHeaderListViewController.VIEW_TAG, TenpayInterface.VIEWTAG_REQARDTRANSFER);
        com.tencent.mobileqq.base.c.d(context, newComIntent, TransferOrderActivity.class);
    }

    private void sendHb() {
        ApiGotoview apiGotoview;
        Context context = getContext();
        String optString = this.ejson.optString("total_amount");
        String optString2 = this.ejson.optString("total_num");
        String optString3 = this.ejson.optString("bus_type");
        String optString4 = this.ejson.optString("wishing");
        int optInt = this.ejson.optInt("type");
        String optString5 = this.ejson.optString("recv_uin");
        String optString6 = this.ejson.optString("recv_type");
        String optString7 = this.ejson.optString("name");
        String optString8 = this.ejson.optString("session_token");
        String optString9 = this.ejson.optString(WadlProxyConsts.CHANNEL);
        String optString10 = this.ejson.optString("na_from_h5_data");
        String optString11 = this.ejson.optString("grouspid");
        String optString12 = this.ejson.optString("theme_type");
        String optString13 = this.ejson.optString("feeds_name");
        String optString14 = this.ejson.optString("feeds_sid");
        HashMap hashMap = new HashMap();
        addIfHasTheParamHongBao(hashMap, this.ejson);
        if (!"128".equals(optString9) && !"256".equals(optString9) && !"512".equals(optString9)) {
            if ("32768".equals(optString9)) {
                apiGotoview = this;
            } else {
                sendHbReuest(context, this.uin, optString7, optString, optString2, optString3, optString4, optString5, optString6, optString8, optString9, optString10, optInt, optString11, optString12, hashMap, this.callback);
                return;
            }
        } else {
            apiGotoview = this;
        }
        sendQZoneHb(context, apiGotoview.uin, optString7, optString9, optString4, optString2, optString3, optString, optString5, optString13, optString14, apiGotoview.callback);
    }

    private void sendHbCallback() {
        Context context = getContext();
        String optString = this.ejson.optString("sp_data");
        sendConfirm(context, this.uin, this.ejson.optString(WadlProxyConsts.CHANNEL), optString, this.callback);
    }

    private void showHbDetail() {
        Context context = getContext();
        if (context == null) {
            return;
        }
        Intent newComIntent = newComIntent();
        newComIntent.putExtra("is_h5_common_native_show", true);
        newComIntent.putExtra("hb_data", this.ejson.toString());
        if (!(context instanceof Activity)) {
            newComIntent.addFlags(268435456);
        }
        QLog.i(TAG, 1, "ApiGrapH5CommonHbNetListener showHbDetail : " + context + " ejson: " + this.ejson);
        com.tencent.mobileqq.base.c.d(context, newComIntent, GrapHbActivity.class);
    }

    private void showWearPayAuthor() {
        Context context = getContext();
        if (context == null) {
            return;
        }
        Intent newComIntent = newComIntent();
        newComIntent.putExtra(ark.ARKMETADATA_JSON, RequestWatch.getInstance().reqData);
        com.tencent.mobileqq.base.c.d(context, newComIntent, WearVerifyActivity.class);
    }

    private void silence_grapH5CommonHb() {
        String str;
        Context context = getContext();
        if (context == null) {
            return;
        }
        if (this.ejson.has("detail_data")) {
            this.ejson.remove("detail_data");
        }
        HashMap<String, String> jsonToMap = Utils.jsonToMap(this.ejson);
        if (TenpayUtil.getShareBoolean(context, "qb_tenpay_hb_" + this.uin, "agree_wallet_contrace")) {
            str = "1";
        } else {
            str = "0";
        }
        jsonToMap.put("agreement", str);
        jsonToMap.put("grap_step", "1");
        jsonToMap.put("hb_from_type", "100");
        jsonToMap.put("senderuin", this.ejson.optString("senderuin"));
        TenpayBL tenpayBL = new TenpayBL();
        tenpayBL.setNetListener(new ApiGrapH5CommonHbNetListener(context, this.callback, new UserInfo(this.uin, this.nick_name), false, false, this));
        tenpayBL.doTask(context, Cgi.URI_HB_NA_GRAP, jsonToMap, "", "0", this.uin, true);
    }

    private void silence_graphb() {
        String str;
        Context context = getContext();
        if (context == null) {
            return;
        }
        HashMap<String, String> jsonToMap = Utils.jsonToMap(this.ejson);
        jsonToMap.put("uin", this.uin);
        if (TenpayUtil.getShareBoolean(context, "qb_tenpay_hb_" + this.uin, "agree_wallet_contrace")) {
            str = "1";
        } else {
            str = "0";
        }
        jsonToMap.put("agreement", str);
        jsonToMap.put("senderuin", this.ejson.optString("senderuin"));
        TenpayBL tenpayBL = new TenpayBL();
        tenpayBL.setNetListener(new ApiGraphbNetListener(context, this.callback, new UserInfo(this.uin, this.nick_name)));
        tenpayBL.doTask(context, Cgi.URI_HB_NA_GRAP, jsonToMap, "", "0", this.uin, true);
    }

    private void silence_redgiftDetail() {
        String str;
        Context context = getContext();
        if (context == null) {
            return;
        }
        HashMap<String, String> jsonToMap = Utils.jsonToMap(this.ejson);
        if (TenpayUtil.getShareBoolean(context, "qb_tenpay_hb_" + this.uin, "agree_wallet_contrace")) {
            str = "1";
        } else {
            str = "0";
        }
        jsonToMap.put("agreement", str);
        TenpayBL tenpayBL = new TenpayBL();
        tenpayBL.setNetListener(new ApiHbDetailNetListener(context, this.callback, new UserInfo(this.uin, this.nick_name)));
        tenpayBL.doTask(context, Cgi.URI_HB_Detail_Server, jsonToMap, "", "0", this.uin, true);
    }

    private void touchPayManage() {
        Context context = getContext();
        if (context == null) {
            return;
        }
        com.tencent.mobileqq.base.c.d(context, newComIntent(), FingerPaySettingSwitchFragment.class);
    }

    private void transferInfor() {
        Context context = getContext();
        HashMap hashMap = new HashMap();
        hashMap.put("uin", this.uin);
        hashMap.put("payee_uin", this.ejson.optString("PayeeUin"));
        hashMap.put("payee_nick", this.ejson.optString("PayeeNick"));
        hashMap.put("total_fee", this.ejson.optString("Amout"));
        hashMap.put("memo", this.ejson.optString("Memo"));
        hashMap.put("source", this.ejson.optString("source"));
        hashMap.put("group_type", this.ejson.optString("group_type"));
        hashMap.put("group_uin", this.ejson.optString("group_uin"));
        hashMap.put("na_from_h5_data", this.ejson.optString("na_from_h5_data"));
        hashMap.put(j.T0, this.params.getString("appid"));
        hashMap.put("come_from", this.ejson.optInt("ComeFrom") + "");
        hashMap.put("histrans_sign", this.ejson.optString("HistransSign"));
        hashMap.put("auth_code", this.ejson.optString("authCode"));
        if (context == null) {
            ResultReceiver resultReceiver = this.callback;
            if (resultReceiver != null) {
                resultReceiver.send(-101, PayHelper.createResultForError("getTransInfo fail! context is null"));
                return;
            }
            return;
        }
        String str = (String) hashMap.get("uin");
        TenpayBL tenpayBL = new TenpayBL();
        Intent newComIntent = newComIntent();
        newComIntent.putExtra(CALLBACK_WHEN_CANCEL_PAY, true);
        tenpayBL.setNetListener(new ApiTransNetListener(context, newComIntent, this.callback, hashMap, this.ejson, new UserInfo(str, null)));
        tenpayBL.doTask(context, Cgi.URI_QWallet_REQUEST_TRANSFER, hashMap, "", "0", str, true);
    }

    private void transferPush() {
        Context context = getContext();
        if (context == null) {
            return;
        }
        String optString = this.ejson.optString("TargetUin");
        String optString2 = this.ejson.optString("PayeeNick");
        String optString3 = this.ejson.optString(DefaultTVKDataProvider.KEY_PAY_STATUS);
        int optInt = this.ejson.optInt("ComeFrom");
        QLog.i(TAG, 1, "" + this.uin);
        if (TextUtils.isEmpty(this.uin)) {
            ResultReceiver resultReceiver = this.callback;
            if (resultReceiver != null) {
                resultReceiver.send(-101, PayHelper.createResultForError("sendTransPush fail! context is " + getContext() + " | uin is " + this.uin));
                return;
            }
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("uin", this.uin);
        hashMap.put("name", optString2);
        hashMap.put("to_uin", optString);
        hashMap.put(DefaultTVKDataProvider.KEY_PAY_STATUS, optString3);
        hashMap.put("come_from", optInt + "");
        TenpayBL tenpayBL = new TenpayBL();
        tenpayBL.setNetListener(new ApiNetListener(context, this.callback, new UserInfo(this.uin, null), false, false));
        tenpayBL.doTask(context, Cgi.URI_QWallet_REQUEST_TRANSFER_PUSH, hashMap, "", "0", this.uin, true);
    }

    private void transferqrcode() {
        Context context = getContext();
        if (context == null) {
            return;
        }
        Intent newComIntent = newComIntent();
        newComIntent.putExtra("entry", this.ejson.optString("entry"));
        com.tencent.mobileqq.base.c.d(context, newComIntent, PaymentInFragment.class);
    }

    private void verifyqrcode() {
        Context context = getContext();
        if (context == null) {
            return;
        }
        String optString = this.ejson.optString("auth_code");
        if (TextUtils.isEmpty(this.uin)) {
            ResultReceiver resultReceiver = this.callback;
            if (resultReceiver != null) {
                resultReceiver.send(-101, PayHelper.createResultForError("sendVerifyQrcode fail! context is " + context + " | uin is " + this.uin));
                return;
            }
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("uin", this.uin);
        hashMap.put("auth_code", optString);
        TenpayBL tenpayBL = new TenpayBL();
        tenpayBL.setNetListener(new ApiNetListener(context, this.callback, new UserInfo(this.uin, null), true, true));
        tenpayBL.doTask(context, Cgi.URI_VERIFY_QRCODE, hashMap, "", "0", this.uin, true);
    }

    private void withdraw() {
        Context context = getContext();
        if (context == null) {
            return;
        }
        int i3 = this.params.getInt("come_from");
        Intent newComIntent = newComIntent();
        boolean z16 = true;
        if (1 != i3) {
            z16 = false;
        }
        newComIntent.putExtra("isH5Withdraw", z16);
        com.tencent.mobileqq.base.c.d(context, newComIntent, WithdrawActivity.class);
    }

    public void gotoSilenceView(String str) {
        QLog.i(TAG, 1, "tag = " + str + ", print:", new Throwable());
        try {
            getMethod(SILENCE_PREFIX + str).invoke(this, new Object[0]);
        } catch (Exception e16) {
            QLog.e(TAG, 1, "", e16);
            ResultReceiver resultReceiver = this.callback;
            if (resultReceiver != null) {
                resultReceiver.send(-101, PayHelper.createResultForError("error, can't get the specified tag:" + str));
            }
        }
    }

    public void gotoView(String str) {
        QLog.i(TAG, 1, "tag = " + str + ", print:", new Throwable());
        try {
            getMethod(str).invoke(this, new Object[0]);
        } catch (Exception e16) {
            QLog.e(TAG, 1, "", e16);
            ResultReceiver resultReceiver = this.callback;
            if (resultReceiver != null) {
                resultReceiver.send(-101, PayHelper.createResultForError("error, can't get the specified tag:" + str));
            }
        }
    }

    public void silence_redgiftH5CommonDetail() {
        String str;
        Context context = getContext();
        if (context == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            if (this.ejson.has("listid")) {
                jSONObject.put("listid", this.ejson.optString("listid"));
            }
            if (this.ejson.has("uin")) {
                jSONObject.put("uin", this.ejson.optString("uin"));
            }
            if (this.ejson.has("offset")) {
                jSONObject.put("offset", this.ejson.optInt("offset"));
            } else {
                jSONObject.put("offset", 0);
            }
            if (this.ejson.has("limit")) {
                jSONObject.put("limit", this.ejson.optInt("limit"));
            } else {
                jSONObject.put("limit", 10);
            }
            if (this.ejson.has("authkey")) {
                jSONObject.put("authkey", this.ejson.optString("authkey"));
            }
            if (this.ejson.has("grouptype")) {
                jSONObject.put("grouptype", this.ejson.optString("grouptype"));
            }
            if (this.ejson.has(FSPublishConstants.FSPublishJsBridge.JSON_OBJECT_KEY_GROUP_ID)) {
                jSONObject.put(FSPublishConstants.FSPublishJsBridge.JSON_OBJECT_KEY_GROUP_ID, this.ejson.optString(FSPublishConstants.FSPublishJsBridge.JSON_OBJECT_KEY_GROUP_ID));
            }
            if (this.ejson.has(HippyHeaderListViewController.VIEW_TAG)) {
                jSONObject.put(HippyHeaderListViewController.VIEW_TAG, this.ejson.optString(HippyHeaderListViewController.VIEW_TAG));
            }
        } catch (JSONException e16) {
            QLog.e(TAG, 1, "", e16);
        }
        HashMap<String, String> jsonToMap = Utils.jsonToMap(jSONObject);
        if (TenpayUtil.getShareBoolean(context, "qb_tenpay_hb_" + this.uin, "agree_wallet_contrace")) {
            str = "1";
        } else {
            str = "0";
        }
        jsonToMap.put("agreement", str);
        jsonToMap.put("hb_from_type", "100");
        TenpayBL tenpayBL = new TenpayBL();
        tenpayBL.setNetListener(new ApiHbDetailNetListener(context, this.callback, new UserInfo(this.uin, this.nick_name)));
        tenpayBL.doTask(context, Cgi.URI_HB_Detail_Server, jsonToMap, "", "0", this.uin, true);
    }
}
