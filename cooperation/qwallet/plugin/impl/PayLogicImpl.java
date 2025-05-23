package cooperation.qwallet.plugin.impl;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcel;
import android.os.ResultReceiver;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.View;
import android.widget.TextView;
import com.qwallet.temp.IQWalletTemp;
import com.tencent.ads.data.AdParam;
import com.tencent.ark.ark;
import com.tencent.biz.qqcircle.tedgers2.bean.QFSEdgeItem;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.commonsdk.util.notification.QQNotificationManager;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.hippy.qq.view.scroll.HippyHeaderListViewController;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.RouterConstants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.emosm.a;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.msf.core.c0.j;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.IQWalletApi;
import com.tencent.mobileqq.qwallet.IQWalletPayApi;
import com.tencent.mobileqq.qwallet.api.INewQWalletApi;
import com.tencent.mobileqq.qwallet.api.IQWalletNickNameApi;
import com.tencent.mobileqq.qwallet.api.IQWalletUnitedConfigApi;
import com.tencent.mobileqq.qwallet.transaction.impl.TransactionActivity;
import com.tencent.mobileqq.qwallet.utils.f;
import com.tencent.mobileqq.shortvideo.ShortVideoConstants;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.vas.ar;
import com.tencent.mobileqq.winkpublish.api.constant.FSPublishConstants;
import com.tencent.qmethod.pandoraex.monitor.OaidMonitor;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.qqmini.sdk.launcher.core.proxy.PayProxy;
import com.tencent.qqmini.sdk.plugins.PayJsPlugin;
import com.tencent.qzonehub.api.webview.IQzoneWebViewPluginHelper;
import com.tenpay.api.TenpayInterface;
import com.tenpay.realname.RealNameSource;
import com.tenpay.sdk.QWalletFakeUrl;
import com.tenpay.view.WalletProgressDialog;
import cooperation.qwallet.midas.MidasPayResultReceiver;
import cooperation.qwallet.open.data.PayInfo;
import cooperation.qwallet.plugin.IPayLogic;
import cooperation.qwallet.plugin.IQWalletHelper;
import cooperation.qwallet.plugin.QWalletPayBridge;
import cooperation.qzone.QzoneIPCModule;
import cooperation.qzone.webviewplugin.QzoneVipPaymentJsPlugin;
import java.io.UnsupportedEncodingException;
import java.lang.ref.WeakReference;
import java.net.URLDecoder;
import java.util.HashSet;
import mqq.app.AppRuntime;
import mqq.app.Constants;
import mqq.app.MobileQQ;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes28.dex */
public class PayLogicImpl implements IPayLogic {
    static HashSet<String> allowView = null;
    private static boolean isPaying = false;
    private static SparseArray<PayLogicImpl> sPayLogics;
    private BaseQQAppInterface app;
    private Intent intent;
    private WalletProgressDialog loadingDialog;
    private QBaseActivity mActivity;
    private a.C7495a mEmojiPayReqData;
    private String mMidasAid;
    private String mMidasOfferid;
    private String mMidasOrderId;
    private String mOpenViewTag;
    private String mPayAppId;
    private String mPayBargainorId;
    private String mPayChannel;
    protected long mPayH5StartTime;
    private String mPayTokenId;
    protected ResultReceiver mResultReceiver;
    private Bundle intentData = null;
    private int mRequestCode = -1;
    protected int mPayType = -1;
    protected boolean isLockWithdraw = false;
    private boolean isFromPCPush = false;
    protected boolean isPCPushDesc = false;
    OnActivityResult mOnActivityResult = null;
    private int saveResultCode = -1;
    private Intent saveResultData = null;

    /* loaded from: classes28.dex */
    public static class CompactReceiver extends ResultReceiver {
        private WeakReference<PayLogicImpl> mLogicRef;

        public CompactReceiver(Handler handler, PayLogicImpl payLogicImpl) {
            super(handler);
            this.mLogicRef = new WeakReference<>(payLogicImpl);
        }

        @Override // android.os.ResultReceiver
        protected void onReceiveResult(int i3, Bundle bundle) {
            super.onReceiveResult(i3, bundle);
            PayLogicImpl payLogicImpl = this.mLogicRef.get();
            if (payLogicImpl != null) {
                Intent intent = new Intent();
                intent.putExtras(bundle);
                payLogicImpl.onActivityResult(3001, -1, intent);
            }
        }
    }

    /* loaded from: classes28.dex */
    public static class OnActivityResult {
        public Intent data;
        public int requestCode;
        public int resultCode;

        public OnActivityResult(int i3, int i16, Intent intent) {
            this.requestCode = i3;
            this.resultCode = i16;
            this.data = intent;
        }
    }

    static {
        HashSet<String> hashSet = new HashSet<>();
        allowView = hashSet;
        hashSet.add("resetPsw");
        allowView.add(QWalletFakeUrl.FAKEURL_BINDNEWCARD);
        allowView.add("balance");
        allowView.add("pswManage");
        allowView.add("modifyPsw");
        allowView.add("checkPsw");
        allowView.add("withdraw");
        allowView.add("transferInfor");
        allowView.add(TransactionActivity.PREF_NAME_TRANSFER);
        allowView.add("graphb");
        allowView.add("qpay_hb_share");
        allowView.add("sendHb");
        allowView.add("sendHbCallback");
        allowView.add("makeHongbao");
        allowView.add("parseqrcode");
        allowView.add("verifyqrcode");
        allowView.add("findPsw");
        allowView.add("pushMsg");
        allowView.add("transferPush");
        allowView.add("transferqrcode");
        allowView.add(QWalletFakeUrl.FAKEURL_TRANSFERINPUT);
        allowView.add("redgiftDetail");
        allowView.add("redgiftRecord");
        allowView.add("idCardVerify");
        allowView.add("payCode");
        allowView.add("showWearPayAuthor");
        allowView.add(TenpayInterface.VIEWTAG_REQARDTRANSFER);
        allowView.add("hbPackConfirm");
        allowView.add("qpayCert");
        allowView.add("qrcodeHb");
        allowView.add("qrcodeHbCallback");
        allowView.add("payByFriendConfirm");
        allowView.add("goldmsg_open");
        allowView.add("goldmsg_close");
        allowView.add("openEmbelUrl");
        allowView.add("showHbDetail");
        allowView.add("recharge");
        allowView.add("deleteCardConform");
        allowView.add("openSchema");
        sPayLogics = new SparseArray<>();
    }

    private void OnEmojimallPayResult(a.C7495a c7495a, int i3, int i16, int i17, int i18, int i19, String str) {
        if (c7495a == null) {
            end();
            return;
        }
        Intent intent = new Intent();
        a.b bVar = new a.b(i3, i16, i17, i18, i19, str);
        intent.putExtras(c7495a.a());
        intent.putExtras(bVar.a());
        this.mActivity.setResult(-1, intent);
        saveNonePCPayResultData(-1, intent);
        end();
    }

    private static void add(PayLogicImpl payLogicImpl) {
        if (payLogicImpl != null) {
            sPayLogics.append(payLogicImpl.getTag(), payLogicImpl);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:73:0x02d7  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x02f7  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x02fc  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected static Bundle buyGoods(AppRuntime appRuntime, Activity activity, ResultReceiver resultReceiver, String str, String str2, int i3, long j3, String str3) {
        String str4;
        Bundle bundle;
        String str5;
        String str6;
        String str7;
        String str8;
        int i16;
        String string;
        boolean z16;
        String str9;
        String str10;
        String str11;
        String str12;
        String str13;
        String str14;
        String str15;
        int i17;
        String str16;
        Bundle bundle2 = new Bundle();
        try {
            try {
                try {
                    JSONObject jSONObject = new JSONObject(str2);
                    String string2 = jSONObject.getString("offerId");
                    String string3 = jSONObject.getString("userId");
                    String optString = jSONObject.optString("userKey");
                    String optString2 = jSONObject.optString(ShortVideoConstants.PARAM_KEY_SESSION_TYPE);
                    String string4 = jSONObject.getString("tokenUrl");
                    if (jSONObject.has("zoneId")) {
                        try {
                            string = jSONObject.getString("zoneId");
                        } catch (JSONException e16) {
                            e = e16;
                            str5 = "retJson";
                            str6 = "error msg in qqpay-impl module: ";
                            str7 = IPayLogic.TAG;
                            bundle = bundle2;
                            str4 = "retCode";
                            if (QLog.isColorLevel()) {
                                QLog.e(str7, 2, "buyGoods JSONException:" + e.getMessage());
                            }
                            if (!QLog.isDevelopLevel()) {
                                i16 = 1;
                                QLog.e(str7, 1, str6, e);
                            } else {
                                i16 = 1;
                            }
                            bundle.putInt(str4, -1);
                            bundle.putString(str5, "{'resultCode':-1,'retmsg':'buyGoods JSONException'}");
                            QLog.e(str7, i16, str6, e);
                            return bundle;
                        }
                    } else {
                        string = "1";
                    }
                    String str17 = string;
                    if (jSONObject.has("numberVisible")) {
                        z16 = jSONObject.getBoolean("numberVisible");
                    } else {
                        z16 = true;
                    }
                    Boolean valueOf = Boolean.valueOf(z16);
                    if (jSONObject.has("unit")) {
                        str9 = jSONObject.getString("unit");
                    } else {
                        str9 = null;
                    }
                    String str18 = str9;
                    String str19 = "";
                    if (jSONObject.has("aid")) {
                        str10 = "aid";
                        str11 = jSONObject.getString("aid");
                    } else {
                        str10 = "aid";
                        str11 = "";
                    }
                    if (!jSONObject.has(QzoneVipPaymentJsPlugin.KEY_DISCOUNTID)) {
                        str12 = "";
                    } else {
                        str12 = jSONObject.getString(QzoneVipPaymentJsPlugin.KEY_DISCOUNTID);
                    }
                    if (!jSONObject.has("other")) {
                        str13 = "";
                    } else {
                        str13 = jSONObject.getString("other");
                    }
                    if (!jSONObject.has("payload")) {
                        str14 = "";
                    } else {
                        str14 = jSONObject.getString("payload");
                    }
                    if (jSONObject.has("drmInfo")) {
                        str19 = jSONObject.getString("drmInfo");
                    }
                    String str20 = str19;
                    if (jSONObject.has(PayProxy.Source.PAY_REQUEST_PAY_COME_FROM)) {
                        i17 = jSONObject.getInt(PayProxy.Source.PAY_REQUEST_PAY_COME_FROM);
                        str15 = PayProxy.Source.PAY_REQUEST_PAY_COME_FROM;
                    } else {
                        str15 = PayProxy.Source.PAY_REQUEST_PAY_COME_FROM;
                        i17 = 1;
                    }
                    String optString3 = jSONObject.optString(WadlProxyConsts.CHANNEL);
                    Bundle bundle3 = new Bundle();
                    bundle3.putString("offerId", string2);
                    bundle3.putString("setEnv", "release");
                    bundle3.putBoolean("setLogEnable", false);
                    bundle3.putBoolean("isShowNum", valueOf.booleanValue());
                    if (str18 != null && str18.length() > 0) {
                        bundle3.putString("unit", str18);
                    }
                    bundle3.putString("callbackSn", str);
                    if (jSONObject.has(AdParam.PF)) {
                        str16 = jSONObject.getString(AdParam.PF);
                    } else {
                        str16 = "qq_m_qq-2013-android-" + AppSetting.f() + "-" + str11;
                    }
                    bundle3.putString("userId", string3);
                    if (ar.b("kenaiyu", "2024-11-19", "vas_bug_buy_goods_opt").isEnable(true)) {
                        String optString4 = jSONObject.optString("sessionId");
                        if (TextUtils.isEmpty(optString4)) {
                            bundle3.putString("sessionId", "uin");
                        } else {
                            bundle3.putString("sessionId", optString4);
                        }
                        if (!TextUtils.isEmpty(optString)) {
                            bundle3.putString("userKey", optString);
                        }
                        if (!TextUtils.isEmpty(optString2)) {
                            bundle3.putString(ShortVideoConstants.PARAM_KEY_SESSION_TYPE, optString2);
                        }
                    } else {
                        bundle3.putString("sessionId", "uin");
                        if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(optString2)) {
                            bundle3.putString(ShortVideoConstants.PARAM_KEY_SESSION_TYPE, optString2);
                            bundle3.putString("userKey", optString);
                        }
                    }
                    bundle3.putString("zoneId", str17);
                    bundle3.putString(AdParam.PF, str16);
                    bundle3.putString("pfKey", "pfKey");
                    bundle3.putString("tokenUrl", string4);
                    bundle3.putInt("resId", 0);
                    bundle3.putString(QzoneVipPaymentJsPlugin.KEY_DISCOUNTID, str12);
                    bundle3.putString("other", str13);
                    bundle3.putString("payload", str14);
                    bundle3.putString("drmInfo", str20);
                    bundle3.putString("payChannel", optString3);
                    bundle3.putInt(str15, i17);
                    bundle3.putInt(QWalletPayBridge.Key.PAY_INVOKER_ID, 7);
                    bundle3.putInt(PayProxy.Source.PAY_TYPE_EXTRA_KEY, i3);
                    bundle3.putLong(PayProxy.Source.PAY_H5_START_EXTRA_KEY, j3);
                    bundle3.putString("payparmas_h5_url", str3);
                    setIPCReceiver(resultReceiver, bundle3);
                    QWalletPayBridge.launchForeground(activity, bundle3);
                    y05.a.a(activity, resultReceiver, bundle3);
                    bundle = bundle2;
                    str4 = "retCode";
                    try {
                        bundle.putInt(str4, 0);
                        bundle.putString("offerId", string2);
                        bundle.putString(str10, str11);
                        bundle.putString(QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_ORDER_ID, string4);
                    } catch (JSONException e17) {
                        e = e17;
                        str5 = "retJson";
                        str6 = "error msg in qqpay-impl module: ";
                        str7 = IPayLogic.TAG;
                        if (QLog.isColorLevel()) {
                        }
                        if (!QLog.isDevelopLevel()) {
                        }
                        bundle.putInt(str4, -1);
                        bundle.putString(str5, "{'resultCode':-1,'retmsg':'buyGoods JSONException'}");
                        QLog.e(str7, i16, str6, e);
                        return bundle;
                    } catch (Exception e18) {
                        e = e18;
                        if (QLog.isColorLevel()) {
                            String str21 = "buyGoods Exception:" + e.getMessage();
                            str8 = IPayLogic.TAG;
                            QLog.e(str8, 2, str21);
                        } else {
                            str8 = IPayLogic.TAG;
                        }
                        if (QLog.isDevelopLevel()) {
                            QLog.e(str8, 1, "error msg in qqpay-impl module: ", e);
                        }
                        bundle.putInt(str4, -1);
                        bundle.putString("retJson", "{'resultCode':-1,'retmsg':'buyGoods Exception'}");
                        return bundle;
                    }
                } catch (Exception e19) {
                    e = e19;
                    bundle = bundle2;
                    str4 = "retCode";
                }
            } catch (JSONException e26) {
                e = e26;
                bundle = bundle2;
                str4 = "retCode";
            }
        } catch (JSONException e27) {
            e = e27;
            str5 = "retJson";
            str4 = "retCode";
            str6 = "error msg in qqpay-impl module: ";
            str7 = IPayLogic.TAG;
            bundle = bundle2;
        } catch (Exception e28) {
            e = e28;
            str4 = "retCode";
            bundle = bundle2;
        }
        return bundle;
    }

    private boolean checkEmojiPayParam(a.C7495a c7495a) {
        if (c7495a != null && !TextUtils.isEmpty(c7495a.f204124b) && !TextUtils.isEmpty(c7495a.f204123a) && !TextUtils.isEmpty(c7495a.f204125c) && !TextUtils.isEmpty(c7495a.f204126d) && !TextUtils.isEmpty(c7495a.f204132j)) {
            return true;
        }
        return false;
    }

    public static void clearCache() {
        SparseArray<PayLogicImpl> sparseArray = sPayLogics;
        if (sparseArray != null) {
            sparseArray.clear();
        }
    }

    private Dialog createCustomDialog(String str, String str2, DialogInterface.OnDismissListener onDismissListener) {
        ReportDialog reportDialog = new ReportDialog(this.mActivity, R.style.qZoneInputDialog);
        reportDialog.setContentView(R.layout.custom_dialog);
        TextView textView = (TextView) reportDialog.findViewById(R.id.dialogTitle);
        if (textView != null) {
            textView.setText(str);
        }
        TextView textView2 = (TextView) reportDialog.findViewById(R.id.dialogText);
        if (textView2 != null) {
            textView2.setText(str2);
        }
        TextView textView3 = (TextView) reportDialog.findViewById(R.id.dialogLeftBtn);
        if (textView3 != null) {
            textView3.setText(17039360);
        }
        TextView textView4 = (TextView) reportDialog.findViewById(R.id.dialogRightBtn);
        if (textView4 != null) {
            textView4.setText(R.string.g6q);
        }
        reportDialog.setOnDismissListener(onDismissListener);
        return reportDialog;
    }

    private void doEmojimallPay(a.C7495a c7495a) {
        this.mEmojiPayReqData = c7495a;
        this.mMidasOfferid = c7495a.f204124b;
        this.mMidasAid = getAidFromPf(c7495a.f204130h);
        Bundle bundle = new Bundle();
        bundle.putString("setEnv", "release");
        bundle.putBoolean("setLogEnable", false);
        bundle.putString("offerId", c7495a.f204124b);
        bundle.putBoolean("isShowNum", false);
        bundle.putString("userId", c7495a.f204125c);
        bundle.putString("userKey", c7495a.f204126d);
        bundle.putString("sessionId", c7495a.f204127e);
        bundle.putString(ShortVideoConstants.PARAM_KEY_SESSION_TYPE, c7495a.f204128f);
        bundle.putString("zoneId", c7495a.f204129g);
        bundle.putString(AdParam.PF, c7495a.f204130h);
        bundle.putString("pfKey", c7495a.f204131i);
        bundle.putString("tokenUrl", c7495a.f204132j);
        bundle.putInt("resId", R.drawable.bfr);
        bundle.putString(QzoneVipPaymentJsPlugin.KEY_DISCOUNTID, c7495a.f204133k);
        bundle.putString("other", c7495a.f204134l);
        bundle.putString("payload", c7495a.f204135m);
        bundle.putString("drmInfo", c7495a.f204136n);
        bundle.putInt(QWalletPayBridge.Key.PAY_INVOKER_ID, 1);
        bundle.putInt(PayProxy.Source.PAY_TYPE_EXTRA_KEY, this.mPayType);
        QWalletPayBridge.launchForeground(this.mActivity, bundle);
        putProxyReceiverToBundle(bundle);
        y05.a.a(this.mActivity, this.mResultReceiver, bundle);
    }

    private void doGoldCharge(Bundle bundle) {
        String string = bundle.getString("offerid");
        String string2 = bundle.getString("uin");
        String string3 = bundle.getString("userKey");
        String string4 = bundle.getString(ShortVideoConstants.PARAM_KEY_SESSION_TYPE);
        String string5 = bundle.getString(AdParam.PF);
        String string6 = bundle.getString(QzoneVipPaymentJsPlugin.KEY_DISCOUNTID);
        String string7 = bundle.getString("other");
        String string8 = bundle.getString("payload");
        String string9 = bundle.getString("drmInfo");
        String string10 = bundle.getString("saveValue");
        boolean z16 = bundle.getBoolean("isCanChange", true);
        this.mMidasOfferid = string;
        this.mMidasAid = getAidFromPf(string5);
        Bundle bundle2 = new Bundle();
        bundle2.putString("setEnv", "release");
        bundle2.putBoolean("setLogEnable", false);
        bundle2.putString("offerId", string);
        bundle2.putString("userId", string2);
        bundle2.putString("sessionId", "uin");
        bundle2.putString("userKey", string3);
        bundle2.putString(ShortVideoConstants.PARAM_KEY_SESSION_TYPE, string4);
        bundle2.putString("zoneId", "1");
        bundle2.putString(AdParam.PF, string5);
        bundle2.putString("pfKey", "pfKey");
        bundle2.putString("acctType", "common");
        bundle2.putInt("resId", R.drawable.fky);
        bundle2.putString(QzoneVipPaymentJsPlugin.KEY_DISCOUNTID, string6);
        bundle2.putString("other", string7);
        bundle2.putString("payload", string8);
        bundle2.putString("drmInfo", string9);
        bundle2.putInt(QWalletPayBridge.Key.PAY_INVOKER_ID, 2);
        bundle2.putInt(PayProxy.Source.PAY_TYPE_EXTRA_KEY, this.mPayType);
        if (string10 != null && string10.trim().length() > 0) {
            bundle2.putString("saveValue", string10);
            bundle2.putBoolean("isCanChange", z16);
        }
        putProxyReceiverToBundle(bundle2);
        QWalletPayBridge.launchForeground(this.mActivity, bundle2);
    }

    private void doOpenQQReaderVip(Bundle bundle) {
        String string = bundle.getString("offerid");
        String string2 = bundle.getString("uin");
        String string3 = bundle.getString("userKey");
        String string4 = bundle.getString(ShortVideoConstants.PARAM_KEY_SESSION_TYPE);
        String string5 = bundle.getString(AdParam.PF);
        String string6 = bundle.getString(QzoneVipPaymentJsPlugin.KEY_PROVIDEUIN);
        String string7 = bundle.getString(QzoneVipPaymentJsPlugin.KEY_PROVIDETYPE);
        String string8 = bundle.getString(QzoneVipPaymentJsPlugin.KEY_DISCOUNTID);
        String string9 = bundle.getString("other");
        String string10 = bundle.getString("payload");
        String string11 = bundle.getString("drmInfo");
        this.mMidasOfferid = string;
        this.mMidasAid = getAidFromPf(string5);
        Bundle bundle2 = new Bundle();
        bundle2.putString("setEnv", "release");
        bundle2.putBoolean("setLogEnable", false);
        bundle2.putString("offerId", string);
        bundle2.putString("userId", string2);
        bundle2.putString("sessionId", "uin");
        bundle2.putString("userKey", string3);
        bundle2.putString(ShortVideoConstants.PARAM_KEY_SESSION_TYPE, string4);
        bundle2.putString(AdParam.PF, string5);
        bundle2.putString("pfKey", "pfKey");
        bundle2.putString("serviceCode", "QQYFSC");
        bundle2.putString("serviceName", "\u817e\u8baf\u6587\u5b66\u5305\u6708VIP");
        bundle2.putInt("resId", R.drawable.fky);
        bundle2.putString("saveValue", "3");
        bundle2.putBoolean("isCanChange", true);
        bundle2.putString("remark", "");
        bundle2.putString(QzoneVipPaymentJsPlugin.KEY_PROVIDEUIN, string6);
        bundle2.putString(QzoneVipPaymentJsPlugin.KEY_PROVIDETYPE, string7);
        bundle2.putString(QzoneVipPaymentJsPlugin.KEY_DISCOUNTID, string8);
        bundle2.putString("other", string9);
        bundle2.putString("payload", string10);
        bundle2.putString("drmInfo", string11);
        bundle2.putInt(QWalletPayBridge.Key.PAY_INVOKER_ID, 3);
        bundle2.putInt(PayProxy.Source.PAY_TYPE_EXTRA_KEY, this.mPayType);
        putProxyReceiverToBundle(bundle2);
        QWalletPayBridge.launchForeground(this.mActivity, bundle2);
        y05.a.a(this.mActivity, this.mResultReceiver, bundle2);
    }

    private String generateMidasErrorResult() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(QzoneIPCModule.RESULT_CODE, -1);
            jSONObject.put("payState", -1);
            jSONObject.put("provideState", -1);
            jSONObject.put("resultMsg", "");
            return jSONObject.toString();
        } catch (Exception unused) {
            return "";
        }
    }

    private String generateTenPayErrorResult() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(QzoneIPCModule.RESULT_CODE, -1);
            jSONObject.put("retmsg", "error");
            jSONObject.put("data", new JSONObject());
            return jSONObject.toString();
        } catch (Exception unused) {
            return "";
        }
    }

    public static String getAidFromPf(String str) {
        int lastIndexOf;
        if (TextUtils.isEmpty(str) || (lastIndexOf = str.lastIndexOf(45)) == -1) {
            return "";
        }
        return str.substring(lastIndexOf + 1);
    }

    private static String getPfPref(int i3) {
        if (i3 == 9) {
            return IPayLogic.MINIAPP_PF_PREF;
        }
        return IPayLogic.DEFAULT_PF_PREF;
    }

    private static boolean isEnterMidasTestEnv(JSONObject jSONObject) {
        if (jSONObject == null || jSONObject.optInt(PayJsPlugin.PAYJSON_KEY_SET_MIDAS_ENV, 0) != 1 || !((IMiniAppService) QRoute.api(IMiniAppService.class)).isDebugMiniApp(jSONObject.optString(PayJsPlugin.PAYJSON_KEY_MINI_APP_VERTYPE_STR))) {
            return false;
        }
        return true;
    }

    public static boolean isLockWithdraw(int i3, Bundle bundle) {
        if (1 != i3) {
            return false;
        }
        try {
            return isLockWithdraw(i3, new JSONObject(bundle.getString(ark.ARKMETADATA_JSON)).optJSONObject("extra_data"));
        } catch (Exception e16) {
            QLog.e(IPayLogic.TAG, 1, "error msg in qqpay-impl module: ", e16);
            return false;
        }
    }

    private boolean isLoginParamsValid() {
        boolean z16;
        BaseQQAppInterface baseQQAppInterface;
        if (!this.isLockWithdraw && this.intentData.getBoolean("payparmas_from_is_login_state", true)) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16 && ((baseQQAppInterface = this.app) == null || baseQQAppInterface.getCurrentAccountUin() == null)) {
            return false;
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:49:0x01d7  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x01f7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected static Bundle launchWeChat(Activity activity, ResultReceiver resultReceiver, String str, String str2, int i3, long j3, String str3) {
        Bundle bundle;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        String string;
        String str9;
        String str10;
        String str11;
        String str12;
        String str13;
        String str14;
        Bundle bundle2 = new Bundle();
        try {
            try {
                JSONObject jSONObject = new JSONObject(str2);
                String string2 = jSONObject.getString("payType");
                try {
                    try {
                        String string3 = jSONObject.getString("appId");
                        String string4 = jSONObject.getString("autoJump");
                        String str15 = null;
                        if (jSONObject.has("wxSignUrl")) {
                            try {
                                string = jSONObject.getString("wxSignUrl");
                            } catch (JSONException e16) {
                                e = e16;
                                str6 = "retJson";
                                str7 = "error msg in qqpay-impl module: ";
                                str8 = IPayLogic.TAG;
                                bundle = bundle2;
                                str4 = "retCode";
                                if (QLog.isColorLevel()) {
                                    QLog.e(str8, 2, "launchWeChat JSONException:" + e.getMessage());
                                }
                                if (QLog.isDevelopLevel()) {
                                    QLog.e(str8, 1, str7, e);
                                }
                                bundle.putInt(str4, -1);
                                bundle.putString(str6, "{'resultCode':-1,'resultMsg':'launchWeChat JSONException'}");
                                return bundle;
                            }
                        } else {
                            string = null;
                        }
                        if (jSONObject.has(QFSEdgeItem.KEY_EXTEND)) {
                            str9 = jSONObject.getString(QFSEdgeItem.KEY_EXTEND);
                        } else {
                            str9 = null;
                        }
                        if (jSONObject.has("bargainorId")) {
                            str10 = jSONObject.getString("bargainorId");
                        } else {
                            str10 = null;
                        }
                        if (jSONObject.has("tokenId")) {
                            str11 = jSONObject.getString("tokenId");
                        } else {
                            str11 = null;
                        }
                        if (jSONObject.has(PayProxy.Source.PAY_REQUEST_NONCE_STR_KEY)) {
                            str12 = jSONObject.getString(PayProxy.Source.PAY_REQUEST_NONCE_STR_KEY);
                        } else {
                            str12 = null;
                        }
                        if (jSONObject.has(PayProxy.Source.PAY_REQUEST_TIME_STAMP_KEY)) {
                            str13 = jSONObject.getString(PayProxy.Source.PAY_REQUEST_TIME_STAMP_KEY);
                        } else {
                            str13 = null;
                        }
                        if (jSONObject.has("packageValue")) {
                            str14 = jSONObject.getString("packageValue");
                        } else {
                            str14 = null;
                        }
                        if (jSONObject.has("sign")) {
                            str15 = jSONObject.getString("sign");
                        }
                        String str16 = str15;
                        Bundle bundle3 = new Bundle();
                        bundle3.putString("payType", string2);
                        bundle3.putString("appId", string3);
                        bundle3.putString("autoJump", string4);
                        bundle3.putString("wxSignUrl", string);
                        bundle3.putString(QFSEdgeItem.KEY_EXTEND, str9);
                        bundle3.putString("bargainorId", str10);
                        bundle3.putString("tokenId", str11);
                        bundle3.putString(PayProxy.Source.PAY_REQUEST_NONCE_STR_KEY, str12);
                        bundle3.putString(PayProxy.Source.PAY_REQUEST_TIME_STAMP_KEY, str13);
                        bundle3.putString("packageValue", str14);
                        bundle3.putString("sign", str16);
                        bundle3.putString("callbackSn", str);
                        bundle3.putInt(QWalletPayBridge.Key.PAY_INVOKER_ID, 17);
                        bundle3.putInt(PayProxy.Source.PAY_TYPE_EXTRA_KEY, i3);
                        bundle3.putLong(PayProxy.Source.PAY_H5_START_EXTRA_KEY, j3);
                        bundle3.putString("payparmas_h5_url", str3);
                        setIPCReceiver(resultReceiver, bundle3);
                        if (QLog.isDevelopLevel()) {
                            QLog.d("loadQWalletPlugin", 4, "PayBridgeActivity-loadPluginStart=" + System.currentTimeMillis());
                        }
                        QWalletPayBridge.launchForeground(activity, bundle3);
                        y05.a.a(activity, resultReceiver, bundle3);
                        bundle = bundle2;
                        str4 = "retCode";
                        try {
                            bundle.putInt(str4, 0);
                        } catch (JSONException e17) {
                            e = e17;
                            str6 = "retJson";
                            str7 = "error msg in qqpay-impl module: ";
                            str8 = IPayLogic.TAG;
                            if (QLog.isColorLevel()) {
                            }
                            if (QLog.isDevelopLevel()) {
                            }
                            bundle.putInt(str4, -1);
                            bundle.putString(str6, "{'resultCode':-1,'resultMsg':'launchWeChat JSONException'}");
                            return bundle;
                        } catch (Exception e18) {
                            e = e18;
                            if (QLog.isColorLevel()) {
                                String str17 = "launchWeChat Exception:" + e.getMessage();
                                str5 = IPayLogic.TAG;
                                QLog.e(str5, 2, str17);
                            } else {
                                str5 = IPayLogic.TAG;
                            }
                            if (QLog.isDevelopLevel()) {
                                QLog.e(str5, 1, "error msg in qqpay-impl module: ", e);
                            }
                            bundle.putInt(str4, -1);
                            bundle.putString("retJson", "{'resultCode':-1,'resultMsg':'launchWeChat Exception'}");
                            return bundle;
                        }
                    } catch (Exception e19) {
                        e = e19;
                        bundle = bundle2;
                        str4 = "retCode";
                    }
                } catch (JSONException e26) {
                    e = e26;
                    bundle = bundle2;
                    str4 = "retCode";
                }
            } catch (JSONException e27) {
                e = e27;
                str4 = "retCode";
                bundle = bundle2;
            } catch (Exception e28) {
                e = e28;
                str4 = "retCode";
                bundle = bundle2;
            }
        } catch (JSONException e29) {
            e = e29;
            bundle = bundle2;
            str4 = "retCode";
        } catch (Exception e36) {
            e = e36;
            bundle = bundle2;
            str4 = "retCode";
        }
        return bundle;
    }

    private void newPay(int i3, Bundle bundle) {
        Bundle nativePay;
        String string = bundle.getString("callbackSn");
        String string2 = bundle.getString(ark.ARKMETADATA_JSON);
        String string3 = bundle.getString(PayProxy.Source.PAY_URL_APPINFO_EXTRA_KEY);
        ResultReceiver resultReceiver = (ResultReceiver) bundle.getParcelable(IPayLogic.RECEIVER_COM_KEY);
        if (resultReceiver == null) {
            resultReceiver = new CompactReceiver(ThreadManagerV2.getUIHandlerV2(), this);
        }
        ResultReceiver resultReceiver2 = resultReceiver;
        QBaseActivity qBaseActivity = this.mActivity;
        if (i3 == 4) {
            nativePay = openService(this.app, qBaseActivity, resultReceiver2, string, string2, this.mPayType, this.mPayH5StartTime, null);
        } else if (i3 == 6) {
            nativePay = rechargeGameCurrency(this.app, qBaseActivity, resultReceiver2, string, string2, this.mPayType, this.mPayH5StartTime, null);
        } else if (i3 == 7) {
            nativePay = buyGoods(this.app, qBaseActivity, resultReceiver2, string, string2, this.mPayType, this.mPayH5StartTime, null);
        } else if (i3 == 8) {
            nativePay = rechargeQb(this.app, qBaseActivity, resultReceiver2, string, string2, this.mPayType, this.mPayH5StartTime, null);
        } else if (i3 == 9) {
            nativePay = pay(this.app, qBaseActivity, resultReceiver2, string, string2, string3, this.mPayType, this.mPayH5StartTime, null);
        } else if (i3 == 14) {
            nativePay = subscribeMonthCardPay(this.app, qBaseActivity, resultReceiver2, string, string2, this.mPayType, this.mPayH5StartTime, null);
        } else {
            nativePay = i3 == 15 ? nativePay(qBaseActivity, resultReceiver2, bundle) : null;
        }
        if (nativePay != null) {
            if (nativePay.getInt("retCode", -1) != 0) {
                String string4 = nativePay.getString("retJson");
                if (string4 != null) {
                    tenpayResult(string, string4);
                    return;
                }
                return;
            }
            if (i3 == 9) {
                this.mPayTokenId = nativePay.getString("token");
                this.mPayAppId = nativePay.getString("appid");
                this.mPayChannel = nativePay.getString(WadlProxyConsts.CHANNEL);
                this.mPayBargainorId = nativePay.getString("bargainor");
                return;
            }
            this.mMidasOfferid = nativePay.getString("offerId");
            this.mMidasAid = nativePay.getString("aid");
            this.mMidasOrderId = nativePay.getString(QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_ORDER_ID);
        }
    }

    private void onCheckWebankResult(Intent intent) {
        this.mActivity.setResult(-1, intent);
        end();
    }

    private void onEmojimallPayResult(Intent intent) {
        a.C7495a c7495a;
        int intExtra = intent.getIntExtra(QWalletPayBridge.PayResult.PAY_RESULT_EXTRA_KEY, 1);
        int intExtra2 = intent.getIntExtra("result", -1);
        int intExtra3 = intent.getIntExtra("realSaveNum", -1);
        int intExtra4 = intent.getIntExtra("payChannel", -1);
        int intExtra5 = intent.getIntExtra("payState", -1);
        int intExtra6 = intent.getIntExtra("provideState", -1);
        String stringExtra = intent.getStringExtra("message");
        intent.getIntExtra("payRetCode", -1);
        if (intExtra == 1 && (c7495a = this.mEmojiPayReqData) != null) {
            OnEmojimallPayResult(c7495a, intExtra2, intExtra3, intExtra4, intExtra5, intExtra6, stringExtra);
        } else {
            OnEmojimallPayResult(this.mEmojiPayReqData, -1, -1, -1, -1, -1, "");
        }
    }

    private void onF2FRedpackCheckError() {
        QBaseActivity qBaseActivity = this.mActivity;
        QQCustomDialog createCustomDialog = DialogUtil.createCustomDialog(qBaseActivity, 231, (String) null, qBaseActivity.getResources().getString(R.string.b27), qBaseActivity.getResources().getString(R.string.b26), (String) null, (DialogInterface.OnClickListener) null, new DialogInterface.OnClickListener() { // from class: cooperation.qwallet.plugin.impl.PayLogicImpl.1
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i3) {
                if (i3 == 0) {
                    dialogInterface.dismiss();
                    PayLogicImpl.this.end();
                }
            }
        });
        createCustomDialog.setCancelable(false);
        createCustomDialog.show();
    }

    private void onGoldChargeResult(Intent intent) {
        int intExtra = intent.getIntExtra(QWalletPayBridge.PayResult.PAY_RESULT_EXTRA_KEY, 1);
        int intExtra2 = intent.getIntExtra("result", -1);
        String stringExtra = intent.getStringExtra("retInnerCode");
        int intExtra3 = intent.getIntExtra("realSaveNum", -1);
        int intExtra4 = intent.getIntExtra("payChannel", -1);
        int intExtra5 = intent.getIntExtra("payState", -1);
        int intExtra6 = intent.getIntExtra("provideState", -1);
        String stringExtra2 = intent.getStringExtra("message");
        intent.getIntExtra("payRetCode", -1);
        if (intExtra == 1) {
            onGoldChargeResult(intExtra2, stringExtra, intExtra3, intExtra4, intExtra5, intExtra6, stringExtra2);
        } else {
            onGoldChargeResult(-1, "", -1, -1, -1, -1, "");
        }
    }

    private void onMidasPayResult(Intent intent) {
        if (intent.getIntExtra(QWalletPayBridge.PayResult.PAY_RESULT_EXTRA_KEY, 1) != 1) {
            intent.putExtra("result", generateMidasErrorResult());
        }
        tenpayResult(intent.getExtras());
    }

    private void onNativePayResult(Intent intent) {
        WalletProgressDialog walletProgressDialog = this.loadingDialog;
        if (walletProgressDialog != null) {
            walletProgressDialog.dismiss();
        }
    }

    private void onOpenQQReaderVipResult(Intent intent) {
        int intExtra = intent.getIntExtra(QWalletPayBridge.PayResult.PAY_RESULT_EXTRA_KEY, 1);
        int intExtra2 = intent.getIntExtra("result", -1);
        String stringExtra = intent.getStringExtra("retInnerCode");
        int intExtra3 = intent.getIntExtra("realSaveNum", -1);
        int intExtra4 = intent.getIntExtra("payChannel", -1);
        int intExtra5 = intent.getIntExtra("payState", -1);
        int intExtra6 = intent.getIntExtra("provideState", -1);
        String stringExtra2 = intent.getStringExtra("message");
        intent.getIntExtra("payRetCode", -1);
        if (intExtra == 1) {
            onGoldChargeResult(intExtra2, stringExtra, intExtra3, intExtra4, intExtra5, intExtra6, stringExtra2);
        } else {
            onGoldChargeResult(-1, "", -1, -1, -1, -1, "");
        }
    }

    private void onOpenQzoneVipCallBack(int i3, String str, String str2, int i16, int i17) {
        Bundle bundle = new Bundle();
        bundle.putString("retInnerCode", str);
        bundle.putString("msg", str2);
        bundle.putInt("payState", i16);
        bundle.putInt("provideState", i17);
        Intent intent = new Intent();
        intent.putExtras(bundle);
        this.mActivity.setResult(i3, intent);
        saveNonePCPayResultData(i3, intent);
        end();
    }

    private void onOpenQzoneVipResult(Intent intent) {
        int intExtra = intent.getIntExtra(QWalletPayBridge.PayResult.PAY_RESULT_EXTRA_KEY, 1);
        int intExtra2 = intent.getIntExtra("result", -1);
        String stringExtra = intent.getStringExtra("retInnerCode");
        int intExtra3 = intent.getIntExtra("payState", -1);
        int intExtra4 = intent.getIntExtra("provideState", -1);
        String stringExtra2 = intent.getStringExtra("message");
        intent.getIntExtra("payRetCode", -1);
        if (intExtra == 1) {
            onOpenQzoneVipCallBack(intExtra2, stringExtra, stringExtra2, intExtra3, intExtra4);
        } else {
            onOpenQzoneVipCallBack(-1, "", "", -1, -1);
        }
    }

    private void onOpenQzoneVipServiceCallBack(int i3, String str, int i16, int i17) {
        Bundle bundle = new Bundle();
        bundle.putString("msg", str);
        bundle.putInt("payState", i16);
        bundle.putInt("provideState", i17);
        Intent intent = new Intent();
        intent.putExtras(bundle);
        this.mActivity.setResult(i3, intent);
        saveNonePCPayResultData(i3, intent);
        end();
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0104 A[Catch: Exception -> 0x0126, TRY_LEAVE, TryCatch #1 {Exception -> 0x0126, blocks: (B:9:0x00b5, B:11:0x00d8, B:13:0x00de, B:23:0x0104), top: B:8:0x00b5 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void onOpenTenpayViewResult(Intent intent) {
        int i3;
        int i16;
        int intExtra = intent.getIntExtra(QWalletPayBridge.PayResult.PAY_RESULT_EXTRA_KEY, 1);
        String stringExtra = intent.getStringExtra("result");
        int intExtra2 = intent.getIntExtra("viewRetCode", -9);
        f.b(IPayLogic.TAG, "onOpenTenpayViewResult mOpenViewTag=" + this.mOpenViewTag + ",nPayResult=" + intExtra + ",result=" + stringExtra + ",viewRetCode=" + intExtra2);
        if (!TextUtils.isEmpty(stringExtra)) {
            try {
                JSONObject optJSONObject = new JSONObject(stringExtra).optJSONObject("retdata");
                if (optJSONObject != null) {
                    Intent intent2 = new Intent();
                    intent2.putExtra("retdata", optJSONObject.toString());
                    int intValue = Integer.valueOf(optJSONObject.optString("exec_code", "-1")).intValue();
                    if (intValue == 1 || intValue == 2 || intValue == 3) {
                        this.mActivity.setResult(-1, intent2);
                        end();
                        return;
                    }
                }
            } catch (Exception e16) {
                QLog.e(IPayLogic.TAG, 1, "error msg in qqpay-impl module: ", e16);
            }
        }
        if (intExtra2 == 0 && !TextUtils.isEmpty(stringExtra) && "hbPackConfirm".equalsIgnoreCase(this.mOpenViewTag)) {
            try {
                JSONObject jSONObject = new JSONObject(new JSONObject(new JSONObject(stringExtra).optString("retmsg")).optString("user_msg"));
                if (jSONObject.has("uin") && jSONObject.has("type")) {
                    String string = jSONObject.getString("uin");
                    int i17 = jSONObject.getInt("type");
                    if (i17 != 0) {
                        if (i17 != 1) {
                            if (i17 != 2) {
                                if (i17 != 3) {
                                    if (i17 != 4) {
                                        i16 = -1;
                                        i3 = -1;
                                        if (i3 != i16) {
                                            QBaseActivity qBaseActivity = this.mActivity;
                                            Intent m3 = BaseAIOUtils.m(new Intent(), null);
                                            m3.putExtra("uin", string);
                                            m3.putExtra("uintype", i3);
                                            m3.putExtra("isBack2Root", true);
                                            RouteUtils.startActivity(qBaseActivity, m3, RouterConstants.UI_ROUTER_SPLASH);
                                        }
                                    } else {
                                        i3 = 1004;
                                    }
                                } else {
                                    i3 = 1000;
                                }
                            } else {
                                i3 = 1;
                            }
                        } else {
                            i3 = 3000;
                        }
                    } else {
                        i3 = 0;
                    }
                    i16 = -1;
                    if (i3 != i16) {
                    }
                }
            } catch (Exception e17) {
                QLog.e(IPayLogic.TAG, 1, "error msg in qqpay-impl module: ", e17);
            }
        }
        if (intExtra == 1) {
            intent.putExtra("payRetCode", intExtra2);
            tenpayResult(intent.getExtras());
        } else {
            intent.putExtra("payRetCode", intExtra2);
            intent.putExtra("result", generateTenPayErrorResult());
            tenpayResult(intent.getExtras());
        }
    }

    private void onPayResult(Intent intent) {
        if (intent.getIntExtra(QWalletPayBridge.PayResult.PAY_RESULT_EXTRA_KEY, 1) == 1) {
            tenpayResult(intent.getExtras());
        } else {
            intent.putExtra("result", generateTenPayErrorResult());
            tenpayResult(intent.getExtras());
        }
    }

    private void onQWalletCrash() {
        Intent intent = this.intent;
        if (intent == null) {
            return;
        }
        final QBaseActivity qBaseActivity = this.mActivity;
        String stringExtra = intent.getStringExtra("title");
        String stringExtra2 = this.intent.getStringExtra("content");
        String stringExtra3 = this.intent.getStringExtra("btn");
        final String stringExtra4 = this.intent.getStringExtra("url");
        QQCustomDialog createCustomDialog = DialogUtil.createCustomDialog(qBaseActivity, 0);
        createCustomDialog.setTitle(stringExtra);
        createCustomDialog.setMessage(stringExtra2);
        createCustomDialog.setCancelable(false);
        DialogInterface.OnClickListener onClickListener = new DialogInterface.OnClickListener() { // from class: cooperation.qwallet.plugin.impl.PayLogicImpl.2
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i3) {
                if (i3 == 1) {
                    if (!TextUtils.isEmpty(stringExtra4)) {
                        Intent intent2 = new Intent();
                        intent2.putExtra("url", stringExtra4);
                        intent2.putExtra("startOpenPageTime", System.currentTimeMillis());
                        RouteUtils.startActivity(qBaseActivity, intent2, RouterConstants.UI_ROUTE_BROWSER);
                    }
                    dialogInterface.dismiss();
                    PayLogicImpl.this.end();
                }
            }
        };
        if (TextUtils.isEmpty(stringExtra3)) {
            stringExtra3 = qBaseActivity.getResources().getString(R.string.f171151ok);
        }
        createCustomDialog.setPositiveButton(stringExtra3, onClickListener);
        createCustomDialog.show();
    }

    private void openQzoneVipService(Bundle bundle) {
        PayLogicImpl payLogicImpl;
        try {
            String string = bundle.getString("offerId");
            String string2 = bundle.getString("userId");
            String string3 = bundle.getString("userKey");
            String string4 = bundle.getString(ShortVideoConstants.PARAM_KEY_SESSION_TYPE);
            String string5 = bundle.getString("serviceCode");
            String string6 = bundle.getString("serviceName");
            String string7 = bundle.getString(WadlProxyConsts.CHANNEL);
            String string8 = bundle.getString("uint");
            String string9 = bundle.getString("openMonth");
            Boolean valueOf = Boolean.valueOf(bundle.getBoolean("isCanChange"));
            String string10 = bundle.getString(QzoneVipPaymentJsPlugin.KEY_PROVIDEUIN);
            String string11 = bundle.getString(QzoneVipPaymentJsPlugin.KEY_PROVIDETYPE);
            String string12 = bundle.getString(QzoneVipPaymentJsPlugin.KEY_DISCOUNTID);
            String string13 = bundle.getString("other");
            String string14 = bundle.getString("payload");
            boolean z16 = bundle.getBoolean("autoPay", true);
            String string15 = bundle.getString("drmInfo");
            String string16 = bundle.getString("aid");
            String str = "qq_m_qq-2013-android-" + AppSetting.f() + "-" + string16;
            try {
                this.mMidasOfferid = string;
                this.mMidasAid = string16;
                Bundle bundle2 = new Bundle();
                bundle2.putString("setEnv", "release");
                bundle2.putBoolean("setLogEnable", true);
                bundle2.putString("offerId", string);
                if (string8 != null && string8.length() > 0) {
                    bundle2.putString("unit", string8);
                }
                if (string7 != null && string7.length() > 0) {
                    bundle2.putString("payChannel", string7);
                }
                bundle2.putString("userId", string2);
                bundle2.putString("userKey", string3);
                bundle2.putString("sessionId", "uin");
                bundle2.putString(ShortVideoConstants.PARAM_KEY_SESSION_TYPE, string4);
                bundle2.putString(AdParam.PF, str);
                bundle2.putString("pfKey", "pfKey");
                bundle2.putString("serviceCode", string5);
                bundle2.putString("serviceName", string6);
                bundle2.putBoolean("autoPay", z16);
                bundle2.putInt("resId", 0);
                if (string9 != null && string9.length() > 0) {
                    bundle2.putString("saveValue", string9);
                    bundle2.putBoolean("isCanChange", valueOf.booleanValue());
                }
                bundle2.putString("remark", "");
                bundle2.putString(QzoneVipPaymentJsPlugin.KEY_PROVIDEUIN, string10);
                bundle2.putString(QzoneVipPaymentJsPlugin.KEY_PROVIDETYPE, string11);
                bundle2.putString(QzoneVipPaymentJsPlugin.KEY_DISCOUNTID, string12);
                bundle2.putString("other", string13);
                bundle2.putString("payload", string14);
                bundle2.putString("drmInfo", string15);
                bundle2.putInt(QWalletPayBridge.Key.PAY_INVOKER_ID, 4);
                payLogicImpl = this;
                try {
                    bundle2.putInt(PayProxy.Source.PAY_TYPE_EXTRA_KEY, payLogicImpl.mPayType);
                    payLogicImpl.putProxyReceiverToBundle(bundle2);
                    QWalletPayBridge.launchForeground(payLogicImpl.mActivity, bundle2);
                    y05.a.a(payLogicImpl.mActivity, payLogicImpl.mResultReceiver, bundle2);
                } catch (Exception e16) {
                    e = e16;
                    if (QLog.isColorLevel()) {
                        QLog.e(IPayLogic.TAG, 2, "openService Exception:" + e.getMessage());
                    }
                    payLogicImpl.onOpenQzoneVipServiceCallBack(-5, "openService Exception", -1, -1);
                    QLog.e(IPayLogic.TAG, 1, "error msg in qqpay-impl module: ", e);
                }
            } catch (Exception e17) {
                e = e17;
                payLogicImpl = this;
            }
        } catch (Exception e18) {
            e = e18;
            payLogicImpl = this;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:112:0x0444  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x0400  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void openSVip(Bundle bundle) {
        String str;
        String str2;
        PayLogicImpl payLogicImpl;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        String str9;
        String str10;
        boolean z16;
        boolean z17;
        String str11;
        String str12;
        String str13;
        String str14;
        int i3;
        String str15;
        String str16;
        String str17;
        String str18;
        String str19;
        int i16;
        String str20;
        String str21;
        String str22;
        String str23;
        String str24;
        String str25;
        Bundle bundle2;
        String string = bundle.getString("callbackSn");
        if (QLog.isColorLevel()) {
            str = "upgradeServicePrice";
            StringBuilder sb5 = new StringBuilder();
            str2 = "openServicePrice";
            sb5.append("PayBridgeActivity openSVip request=");
            sb5.append(bundle.toString());
            sb5.append(",callbackSn=");
            sb5.append(String.valueOf(string));
            QLog.i(IPayLogic.TAG, 2, sb5.toString());
        } else {
            str = "upgradeServicePrice";
            str2 = "openServicePrice";
        }
        try {
            try {
                try {
                    JSONObject jSONObject = new JSONObject(bundle.getString(ark.ARKMETADATA_JSON));
                    String string2 = jSONObject.getString("offerId");
                    String string3 = jSONObject.getString("userId");
                    str3 = IPayLogic.TAG;
                    try {
                        String string4 = jSONObject.getString("userKey");
                        String string5 = jSONObject.getString(ShortVideoConstants.PARAM_KEY_SESSION_TYPE);
                        String string6 = jSONObject.getString("serviceCode");
                        String string7 = jSONObject.getString("serviceName");
                        String str26 = null;
                        if (jSONObject.has(WadlProxyConsts.CHANNEL)) {
                            str6 = jSONObject.getString(WadlProxyConsts.CHANNEL);
                        } else {
                            str6 = null;
                        }
                        if (jSONObject.has("unit")) {
                            str7 = string3;
                            str8 = jSONObject.getString("unit");
                        } else {
                            str7 = string3;
                            str8 = null;
                        }
                        if (jSONObject.has("openMonth")) {
                            str9 = "openMonth";
                            str10 = jSONObject.getString("openMonth");
                        } else {
                            str9 = "openMonth";
                            str10 = null;
                        }
                        if (jSONObject.has("isCanChange")) {
                            z16 = jSONObject.getBoolean("isCanChange");
                        } else {
                            z16 = true;
                        }
                        Boolean valueOf = Boolean.valueOf(z16);
                        if (jSONObject.has("isAutoPay")) {
                            z17 = jSONObject.getBoolean("isAutoPay");
                        } else {
                            z17 = true;
                        }
                        Boolean valueOf2 = Boolean.valueOf(z17);
                        String str27 = "";
                        if (!jSONObject.has("remark")) {
                            str11 = "remark";
                            str12 = "";
                        } else {
                            str12 = jSONObject.getString("remark");
                            str11 = "remark";
                        }
                        if (!jSONObject.has("aid")) {
                            str13 = "";
                        } else {
                            str13 = jSONObject.getString("aid");
                        }
                        if (!jSONObject.has("actTitle")) {
                            str14 = "";
                        } else {
                            str14 = jSONObject.getString("actTitle");
                        }
                        if (jSONObject.has("openType")) {
                            i3 = jSONObject.getInt("openType");
                        } else {
                            i3 = 0;
                        }
                        if (jSONObject.has("actHint")) {
                            str15 = jSONObject.getString("actHint");
                        } else {
                            str15 = null;
                        }
                        if (jSONObject.has("actPayTotal")) {
                            str16 = jSONObject.getString("actPayTotal");
                        } else {
                            str16 = null;
                        }
                        if (jSONObject.has("actPayDiscount")) {
                            str17 = jSONObject.getString("actPayDiscount");
                        } else {
                            str17 = null;
                        }
                        if (jSONObject.has("actBtnTitle")) {
                            str18 = jSONObject.getString("actBtnTitle");
                        } else {
                            str18 = null;
                        }
                        String str28 = str2;
                        if (jSONObject.has(str28)) {
                            str19 = jSONObject.getString(str28);
                        } else {
                            str19 = null;
                        }
                        String str29 = str;
                        if (jSONObject.has(str29)) {
                            str26 = jSONObject.getString(str29);
                        }
                        String str30 = str26;
                        if (jSONObject.has("maxUpgradeMonth")) {
                            i16 = jSONObject.getInt("maxUpgradeMonth");
                        } else {
                            i16 = 0;
                        }
                        if (!jSONObject.has("openTitle")) {
                            str20 = "";
                        } else {
                            str20 = jSONObject.getString("openTitle");
                        }
                        if (!jSONObject.has("upgradeTitle")) {
                            str21 = "upgradeTitle";
                            str22 = "";
                        } else {
                            str22 = jSONObject.getString("upgradeTitle");
                            str21 = "upgradeTitle";
                        }
                        if (!jSONObject.has(QzoneVipPaymentJsPlugin.KEY_DISCOUNTID)) {
                            str23 = "";
                        } else {
                            str23 = jSONObject.getString(QzoneVipPaymentJsPlugin.KEY_DISCOUNTID);
                        }
                        if (!jSONObject.has("other")) {
                            str24 = "";
                        } else {
                            str24 = jSONObject.getString("other");
                        }
                        if (!jSONObject.has("payload")) {
                            str25 = "";
                        } else {
                            str25 = jSONObject.getString("payload");
                        }
                        if (jSONObject.has("couponId")) {
                            str27 = jSONObject.getString("couponId");
                        }
                        String str31 = str9;
                        String str32 = str27;
                        try {
                            this.mMidasOfferid = string2;
                            this.mMidasAid = str13;
                            bundle2 = new Bundle();
                            bundle2.putString("offerId", string2);
                            bundle2.putString("setEnv", "release");
                            bundle2.putBoolean("setLogEnable", false);
                            if (str8 != null && str8.length() > 0) {
                                bundle2.putString("unit", str8);
                            }
                            if (str6 != null && str6.length() > 0) {
                                bundle2.putString("payChannel", str6);
                            }
                            str5 = "callbackSn";
                            try {
                                bundle2.putString(str5, string);
                                String str33 = "qq_m_qq-2013-android-" + AppSetting.f() + "-" + str13;
                                bundle2.putString("userId", str7);
                                bundle2.putString("sessionId", "uin");
                                bundle2.putString("userKey", string4);
                                bundle2.putString(ShortVideoConstants.PARAM_KEY_SESSION_TYPE, string5);
                                bundle2.putString(AdParam.PF, str33);
                                bundle2.putString("pfKey", "pfKey");
                                bundle2.putString("serviceCode", string6);
                                bundle2.putString("serviceName", string7);
                                bundle2.putInt("resId", 0);
                                if (str10 != null && str10.length() > 0) {
                                    bundle2.putString(str31, str10);
                                    bundle2.putBoolean("isCanChange", valueOf.booleanValue());
                                }
                                bundle2.putBoolean("isAutoPay", valueOf2.booleanValue());
                                bundle2.putString(str11, str12);
                                bundle2.putString("actTitle", str14);
                                bundle2.putInt("openType", i3);
                                bundle2.putString("actHint", str15);
                                bundle2.putString("actPayTotal", str16);
                                bundle2.putString("actPayDiscount", str17);
                                bundle2.putString("actBtnTitle", str18);
                                bundle2.putString(str28, str19);
                                bundle2.putString(str29, str30);
                                bundle2.putInt("maxUpgradeMonth", i16);
                                bundle2.putString("openTitle", str20);
                                bundle2.putString(str21, str22);
                                bundle2.putString(QzoneVipPaymentJsPlugin.KEY_DISCOUNTID, str23);
                                bundle2.putString("other", str24);
                                bundle2.putString("payload", str25);
                                bundle2.putString("couponId", str32);
                                bundle2.putInt(QWalletPayBridge.Key.PAY_INVOKER_ID, 11);
                                payLogicImpl = this;
                            } catch (JSONException e16) {
                                e = e16;
                                payLogicImpl = this;
                            } catch (Exception e17) {
                                e = e17;
                                payLogicImpl = this;
                            }
                        } catch (JSONException e18) {
                            e = e18;
                            payLogicImpl = this;
                            str5 = "callbackSn";
                            str4 = str3;
                            if (QLog.isColorLevel()) {
                            }
                            Bundle bundle3 = new Bundle();
                            bundle3.putString(str5, string);
                            bundle3.putString("result", "{'resultCode':-1,'resultMsg':'openSVip JSONException'}");
                            bundle3.putInt("payRetCode", -1);
                            payLogicImpl.tenpayResult(bundle3);
                        } catch (Exception e19) {
                            e = e19;
                            payLogicImpl = this;
                            str5 = "callbackSn";
                            if (QLog.isColorLevel()) {
                            }
                            Bundle bundle4 = new Bundle();
                            bundle4.putString(str5, string);
                            bundle4.putString("result", "{'resultCode':-1,'resultMsg':'openSVip Exception'}");
                            bundle4.putInt("payRetCode", -1);
                            payLogicImpl.tenpayResult(bundle4);
                        }
                        try {
                            bundle2.putInt(PayProxy.Source.PAY_TYPE_EXTRA_KEY, payLogicImpl.mPayType);
                            bundle2.putLong(PayProxy.Source.PAY_H5_START_EXTRA_KEY, payLogicImpl.mPayH5StartTime);
                            if (QLog.isDevelopLevel()) {
                                QLog.d("loadQWalletPlugin", 4, "PayBridgeActivity-loadPluginStart=" + System.currentTimeMillis());
                            }
                            payLogicImpl.putProxyReceiverToBundle(bundle2);
                            QWalletPayBridge.launchForeground(payLogicImpl.mActivity, bundle2);
                            y05.a.a(payLogicImpl.mActivity, payLogicImpl.mResultReceiver, bundle2);
                        } catch (JSONException e26) {
                            e = e26;
                            str4 = str3;
                            if (QLog.isColorLevel()) {
                                QLog.e(str4, 2, "openSVip JSONException:" + e.getMessage());
                            }
                            Bundle bundle32 = new Bundle();
                            bundle32.putString(str5, string);
                            bundle32.putString("result", "{'resultCode':-1,'resultMsg':'openSVip JSONException'}");
                            bundle32.putInt("payRetCode", -1);
                            payLogicImpl.tenpayResult(bundle32);
                        } catch (Exception e27) {
                            e = e27;
                            if (QLog.isColorLevel()) {
                                QLog.e(str3, 2, "openSVip Exception:" + e.getMessage());
                            }
                            Bundle bundle42 = new Bundle();
                            bundle42.putString(str5, string);
                            bundle42.putString("result", "{'resultCode':-1,'resultMsg':'openSVip Exception'}");
                            bundle42.putInt("payRetCode", -1);
                            payLogicImpl.tenpayResult(bundle42);
                        }
                    } catch (JSONException e28) {
                        e = e28;
                        payLogicImpl = this;
                    } catch (Exception e29) {
                        e = e29;
                        payLogicImpl = this;
                    }
                } catch (JSONException e36) {
                    e = e36;
                    payLogicImpl = this;
                    str5 = "callbackSn";
                    str4 = IPayLogic.TAG;
                }
            } catch (Exception e37) {
                e = e37;
                payLogicImpl = this;
                str3 = IPayLogic.TAG;
            }
        } catch (JSONException e38) {
            e = e38;
            payLogicImpl = this;
            str4 = IPayLogic.TAG;
            str5 = "callbackSn";
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(24:1|(30:2|3|(1:5)(1:128)|6|(1:8)(1:127)|9|(1:11)(1:126)|12|(1:14)(1:125)|15|16|(1:18)(1:124)|19|(1:21)(1:123)|22|(1:24)(1:122)|25|(1:27)(1:121)|28|(1:30)(1:120)|31|(1:33)(1:119)|34|(1:36)(1:118)|37|(1:39)(1:117)|40|(1:42)(1:116)|43|44)|(2:110|(20:115|50|(1:52)(1:109)|53|(1:55)|56|(1:60)|(1:64)|65|(1:69)|70|(1:74)|75|76|77|78|79|80|81|82)(1:114))(1:48)|49|50|(0)(0)|53|(0)|56|(2:58|60)|(2:62|64)|65|(2:67|69)|70|(2:72|74)|75|76|77|78|79|80|81|82|(1:(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:100:0x0336, code lost:
    
        r2.putInt(r3, -1);
        r2.putString("retJson", "{'resultCode':-1,'resultMsg':'openService Exception'}");
     */
    /* JADX WARN: Code restructure failed: missing block: B:102:0x02fe, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:103:0x02ff, code lost:
    
        r3 = "retCode";
     */
    /* JADX WARN: Code restructure failed: missing block: B:104:0x0349, code lost:
    
        r2 = r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:105:0x02fa, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:106:0x02fb, code lost:
    
        r3 = "retCode";
     */
    /* JADX WARN: Code restructure failed: missing block: B:107:0x0307, code lost:
    
        r2 = r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x02f8, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x034f, code lost:
    
        if (com.tencent.qphone.base.util.QLog.isColorLevel() != false) goto L124;
     */
    /* JADX WARN: Code restructure failed: missing block: B:88:0x0351, code lost:
    
        com.tencent.qphone.base.util.QLog.e(r1, 2, "openService JSONException:" + r0.getMessage());
     */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x036f, code lost:
    
        if (com.tencent.qphone.base.util.QLog.isDevelopLevel() != false) goto L127;
     */
    /* JADX WARN: Code restructure failed: missing block: B:91:0x0371, code lost:
    
        com.tencent.qphone.base.util.QLog.e(r1, 1, "error msg in qqpay-impl module: ", r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:92:0x0378, code lost:
    
        r2.putInt(r3, -1);
        r2.putString("retJson", "{'resultCode':-1,'resultMsg':'openService JSONException'}");
     */
    /* JADX WARN: Code restructure failed: missing block: B:93:0x02f6, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:95:0x030d, code lost:
    
        if (com.tencent.qphone.base.util.QLog.isColorLevel() != false) goto L114;
     */
    /* JADX WARN: Code restructure failed: missing block: B:96:0x030f, code lost:
    
        com.tencent.qphone.base.util.QLog.e(r1, 2, "openService Exception:" + r0.getMessage());
     */
    /* JADX WARN: Code restructure failed: missing block: B:98:0x032d, code lost:
    
        if (com.tencent.qphone.base.util.QLog.isDevelopLevel() != false) goto L117;
     */
    /* JADX WARN: Code restructure failed: missing block: B:99:0x032f, code lost:
    
        com.tencent.qphone.base.util.QLog.e(r1, 1, "error msg in qqpay-impl module: ", r0);
     */
    /* JADX WARN: Removed duplicated region for block: B:109:0x01aa A[Catch: Exception -> 0x0302, JSONException -> 0x0344, TryCatch #6 {JSONException -> 0x0344, Exception -> 0x0302, blocks: (B:3:0x003f, B:5:0x0072, B:6:0x007c, B:8:0x0082, B:9:0x0095, B:11:0x009e, B:12:0x00a8, B:14:0x00ae, B:15:0x00b5, B:18:0x00c2, B:19:0x00cb, B:21:0x00d1, B:22:0x00da, B:24:0x00e0, B:25:0x00e9, B:27:0x00ef, B:28:0x00f8, B:30:0x00fe, B:31:0x0107, B:33:0x010d, B:34:0x0116, B:36:0x011c, B:37:0x0123, B:39:0x012d, B:40:0x013c, B:42:0x0142, B:43:0x014f, B:46:0x0162, B:48:0x016b, B:50:0x0197, B:52:0x019d, B:53:0x01cd, B:55:0x01d3, B:56:0x01d7, B:58:0x01fb, B:60:0x0201, B:62:0x0208, B:64:0x020e, B:65:0x0216, B:67:0x022c, B:69:0x0232, B:70:0x023a, B:72:0x0267, B:74:0x026d, B:75:0x027a, B:109:0x01aa, B:110:0x0180, B:112:0x0186, B:114:0x018c), top: B:2:0x003f }] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x019d A[Catch: Exception -> 0x0302, JSONException -> 0x0344, TryCatch #6 {JSONException -> 0x0344, Exception -> 0x0302, blocks: (B:3:0x003f, B:5:0x0072, B:6:0x007c, B:8:0x0082, B:9:0x0095, B:11:0x009e, B:12:0x00a8, B:14:0x00ae, B:15:0x00b5, B:18:0x00c2, B:19:0x00cb, B:21:0x00d1, B:22:0x00da, B:24:0x00e0, B:25:0x00e9, B:27:0x00ef, B:28:0x00f8, B:30:0x00fe, B:31:0x0107, B:33:0x010d, B:34:0x0116, B:36:0x011c, B:37:0x0123, B:39:0x012d, B:40:0x013c, B:42:0x0142, B:43:0x014f, B:46:0x0162, B:48:0x016b, B:50:0x0197, B:52:0x019d, B:53:0x01cd, B:55:0x01d3, B:56:0x01d7, B:58:0x01fb, B:60:0x0201, B:62:0x0208, B:64:0x020e, B:65:0x0216, B:67:0x022c, B:69:0x0232, B:70:0x023a, B:72:0x0267, B:74:0x026d, B:75:0x027a, B:109:0x01aa, B:110:0x0180, B:112:0x0186, B:114:0x018c), top: B:2:0x003f }] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x01d3 A[Catch: Exception -> 0x0302, JSONException -> 0x0344, TryCatch #6 {JSONException -> 0x0344, Exception -> 0x0302, blocks: (B:3:0x003f, B:5:0x0072, B:6:0x007c, B:8:0x0082, B:9:0x0095, B:11:0x009e, B:12:0x00a8, B:14:0x00ae, B:15:0x00b5, B:18:0x00c2, B:19:0x00cb, B:21:0x00d1, B:22:0x00da, B:24:0x00e0, B:25:0x00e9, B:27:0x00ef, B:28:0x00f8, B:30:0x00fe, B:31:0x0107, B:33:0x010d, B:34:0x0116, B:36:0x011c, B:37:0x0123, B:39:0x012d, B:40:0x013c, B:42:0x0142, B:43:0x014f, B:46:0x0162, B:48:0x016b, B:50:0x0197, B:52:0x019d, B:53:0x01cd, B:55:0x01d3, B:56:0x01d7, B:58:0x01fb, B:60:0x0201, B:62:0x0208, B:64:0x020e, B:65:0x0216, B:67:0x022c, B:69:0x0232, B:70:0x023a, B:72:0x0267, B:74:0x026d, B:75:0x027a, B:109:0x01aa, B:110:0x0180, B:112:0x0186, B:114:0x018c), top: B:2:0x003f }] */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0351  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0371  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x030f  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x032f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected static Bundle openService(AppRuntime appRuntime, Activity activity, ResultReceiver resultReceiver, String str, String str2, int i3, long j3, String str3) {
        String str4;
        String str5;
        JSONObject jSONObject;
        String string;
        String string2;
        String string3;
        String string4;
        String str6;
        String str7;
        String str8;
        String str9;
        String str10;
        String str11;
        boolean z16;
        Boolean valueOf;
        String str12;
        String str13;
        String str14;
        String str15;
        String str16;
        String str17;
        String str18;
        boolean z17;
        Boolean valueOf2;
        String str19;
        String str20;
        String str21;
        String str22;
        String str23;
        String string5;
        String string6;
        String str24;
        String str25;
        String sb5;
        Bundle bundle;
        Bundle bundle2 = new Bundle();
        try {
            jSONObject = new JSONObject(str2);
            string = jSONObject.getString("offerId");
            string2 = jSONObject.getString("userId");
            string3 = jSONObject.getString("serviceCode");
            string4 = jSONObject.getString("serviceName");
            str6 = null;
            if (jSONObject.has(WadlProxyConsts.CHANNEL)) {
                str7 = jSONObject.getString(WadlProxyConsts.CHANNEL);
            } else {
                str7 = null;
            }
            if (jSONObject.has("unit")) {
                str9 = "unit";
                str8 = str7;
                str10 = jSONObject.getString("unit");
            } else {
                str8 = str7;
                str9 = "unit";
                str10 = null;
            }
            if (jSONObject.has("openMonth")) {
                str11 = jSONObject.getString("openMonth");
            } else {
                str11 = null;
            }
            if (jSONObject.has("isCanChange")) {
                z16 = jSONObject.getBoolean("isCanChange");
            } else {
                z16 = true;
            }
            valueOf = Boolean.valueOf(z16);
            str12 = "";
            if (!jSONObject.has("remark")) {
                str13 = "";
            } else {
                str13 = jSONObject.getString("remark");
            }
            if (jSONObject.has(QzoneVipPaymentJsPlugin.KEY_PROVIDEUIN)) {
                str14 = jSONObject.getString(QzoneVipPaymentJsPlugin.KEY_PROVIDEUIN);
            } else {
                str14 = null;
            }
            if (jSONObject.has(QzoneVipPaymentJsPlugin.KEY_PROVIDETYPE)) {
                str15 = jSONObject.getString(QzoneVipPaymentJsPlugin.KEY_PROVIDETYPE);
            } else {
                str15 = null;
            }
            if (!jSONObject.has(QzoneVipPaymentJsPlugin.KEY_DISCOUNTID)) {
                str16 = "";
            } else {
                str16 = jSONObject.getString(QzoneVipPaymentJsPlugin.KEY_DISCOUNTID);
            }
            if (!jSONObject.has("other")) {
                str17 = "";
            } else {
                str17 = jSONObject.getString("other");
            }
            if (!jSONObject.has("payload")) {
                str18 = "";
            } else {
                str18 = jSONObject.getString("payload");
            }
            if (jSONObject.has("autoPay")) {
                z17 = jSONObject.getBoolean("autoPay");
            } else {
                z17 = true;
            }
            valueOf2 = Boolean.valueOf(z17);
            if (jSONObject.has("aid")) {
                str19 = "aid";
                str20 = jSONObject.getString("aid");
            } else {
                str19 = "aid";
                str20 = "";
            }
            if (!jSONObject.has("couponId")) {
                str21 = "couponId";
                str22 = "";
            } else {
                str22 = jSONObject.getString("couponId");
                str21 = "couponId";
            }
        } catch (JSONException e16) {
            e = e16;
            str4 = "retCode";
            str5 = IPayLogic.TAG;
        } catch (Exception e17) {
            e = e17;
            str4 = "retCode";
            str5 = IPayLogic.TAG;
        }
        if (jSONObject.has("ticketName") && jSONObject.has("ticketValue")) {
            string5 = jSONObject.getString("ticketValue");
            string6 = jSONObject.getString("ticketName");
        } else if (jSONObject.has("userKey") && jSONObject.has(ShortVideoConstants.PARAM_KEY_SESSION_TYPE)) {
            string5 = jSONObject.getString("userKey");
            string6 = jSONObject.getString(ShortVideoConstants.PARAM_KEY_SESSION_TYPE);
        } else {
            str23 = null;
            if (jSONObject.has(AdParam.PF)) {
                str24 = "other";
                StringBuilder sb6 = new StringBuilder();
                str25 = QzoneVipPaymentJsPlugin.KEY_DISCOUNTID;
                sb6.append("qq_m_qq-2013-android-");
                sb6.append(AppSetting.f());
                sb6.append("-");
                sb6.append(str20);
                sb5 = sb6.toString();
            } else {
                String string7 = jSONObject.getString(AdParam.PF);
                str25 = QzoneVipPaymentJsPlugin.KEY_DISCOUNTID;
                str24 = "other";
                sb5 = string7;
            }
            if (jSONObject.has("drmInfo")) {
                str12 = jSONObject.getString("drmInfo");
            }
            String str26 = str12;
            bundle = new Bundle();
            String str27 = str20;
            bundle.putString("offerId", string);
            bundle.putString("setEnv", "release");
            bundle.putBoolean("setLogEnable", false);
            if (str10 != null && str10.length() > 0) {
                bundle.putString(str9, str10);
            }
            if (str8 != null && str8.length() > 0) {
                bundle.putString("payChannel", str8);
            }
            bundle.putString("callbackSn", str);
            bundle.putString("userId", string2);
            if (!TextUtils.isEmpty(str23) && !TextUtils.isEmpty(str6)) {
                bundle.putString(ShortVideoConstants.PARAM_KEY_SESSION_TYPE, str6);
                bundle.putString("userKey", str23);
            }
            bundle.putString("sessionId", "uin");
            bundle.putString(AdParam.PF, sb5);
            bundle.putString("pfKey", "pfKey");
            bundle.putString("serviceCode", string3);
            bundle.putString("serviceName", string4);
            bundle.putInt("resId", 0);
            if (str11 != null && str11.length() > 0) {
                bundle.putString("saveValue", str11);
                bundle.putBoolean("isCanChange", valueOf.booleanValue());
            }
            bundle.putString("remark", str13);
            bundle.putString(QzoneVipPaymentJsPlugin.KEY_PROVIDEUIN, str14);
            bundle.putString(QzoneVipPaymentJsPlugin.KEY_PROVIDETYPE, str15);
            bundle.putString(str25, str16);
            bundle.putString(str24, str17);
            bundle.putString("payload", str18);
            bundle.putBoolean("autoPay", valueOf2.booleanValue());
            bundle.putString(str21, str22);
            bundle.putString("drmInfo", str26);
            bundle.putInt(QWalletPayBridge.Key.PAY_INVOKER_ID, 4);
            bundle.putInt(PayProxy.Source.PAY_TYPE_EXTRA_KEY, i3);
            bundle.putLong(PayProxy.Source.PAY_H5_START_EXTRA_KEY, j3);
            bundle.putString("payparmas_h5_url", str3);
            str5 = IPayLogic.TAG;
            setIPCReceiver(resultReceiver, bundle);
            QWalletPayBridge.launchForeground(activity, bundle);
            y05.a.a(activity, resultReceiver, bundle);
            str4 = "retCode";
            Bundle bundle3 = bundle2;
            bundle3.putInt(str4, 0);
            bundle3.putString("offerId", string);
            bundle3.putString(str19, str27);
            return bundle3;
        }
        String str28 = string5;
        str6 = string6;
        str23 = str28;
        if (jSONObject.has(AdParam.PF)) {
        }
        if (jSONObject.has("drmInfo")) {
        }
        String str262 = str12;
        bundle = new Bundle();
        String str272 = str20;
        bundle.putString("offerId", string);
        bundle.putString("setEnv", "release");
        bundle.putBoolean("setLogEnable", false);
        if (str10 != null) {
            bundle.putString(str9, str10);
        }
        if (str8 != null) {
            bundle.putString("payChannel", str8);
        }
        bundle.putString("callbackSn", str);
        bundle.putString("userId", string2);
        if (!TextUtils.isEmpty(str23)) {
            bundle.putString(ShortVideoConstants.PARAM_KEY_SESSION_TYPE, str6);
            bundle.putString("userKey", str23);
        }
        bundle.putString("sessionId", "uin");
        bundle.putString(AdParam.PF, sb5);
        bundle.putString("pfKey", "pfKey");
        bundle.putString("serviceCode", string3);
        bundle.putString("serviceName", string4);
        bundle.putInt("resId", 0);
        if (str11 != null) {
            bundle.putString("saveValue", str11);
            bundle.putBoolean("isCanChange", valueOf.booleanValue());
        }
        bundle.putString("remark", str13);
        bundle.putString(QzoneVipPaymentJsPlugin.KEY_PROVIDEUIN, str14);
        bundle.putString(QzoneVipPaymentJsPlugin.KEY_PROVIDETYPE, str15);
        bundle.putString(str25, str16);
        bundle.putString(str24, str17);
        bundle.putString("payload", str18);
        bundle.putBoolean("autoPay", valueOf2.booleanValue());
        bundle.putString(str21, str22);
        bundle.putString("drmInfo", str262);
        bundle.putInt(QWalletPayBridge.Key.PAY_INVOKER_ID, 4);
        bundle.putInt(PayProxy.Source.PAY_TYPE_EXTRA_KEY, i3);
        bundle.putLong(PayProxy.Source.PAY_H5_START_EXTRA_KEY, j3);
        bundle.putString("payparmas_h5_url", str3);
        str5 = IPayLogic.TAG;
        setIPCReceiver(resultReceiver, bundle);
        QWalletPayBridge.launchForeground(activity, bundle);
        y05.a.a(activity, resultReceiver, bundle);
        str4 = "retCode";
        Bundle bundle32 = bundle2;
        bundle32.putInt(str4, 0);
        bundle32.putString("offerId", string);
        bundle32.putString(str19, str272);
        return bundle32;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:113:0x02d4 A[Catch: Exception -> 0x045d, TRY_LEAVE, TryCatch #1 {Exception -> 0x045d, blocks: (B:191:0x02aa, B:111:0x02cb, B:113:0x02d4, B:118:0x02f1, B:128:0x02f8, B:130:0x0306, B:132:0x030c, B:133:0x0313, B:135:0x0319, B:136:0x031f, B:138:0x0328, B:139:0x032f, B:141:0x0338, B:142:0x033f, B:144:0x0348, B:145:0x034f, B:147:0x035a, B:148:0x0361, B:150:0x036c, B:151:0x0373, B:153:0x037e, B:154:0x0385, B:156:0x0390, B:157:0x0397, B:159:0x03a2, B:160:0x03a9, B:162:0x03b4, B:163:0x03bb, B:165:0x03c6, B:166:0x03ca, B:127:0x02e1, B:115:0x02e6), top: B:190:0x02aa, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:135:0x0319 A[Catch: Exception -> 0x045d, TryCatch #1 {Exception -> 0x045d, blocks: (B:191:0x02aa, B:111:0x02cb, B:113:0x02d4, B:118:0x02f1, B:128:0x02f8, B:130:0x0306, B:132:0x030c, B:133:0x0313, B:135:0x0319, B:136:0x031f, B:138:0x0328, B:139:0x032f, B:141:0x0338, B:142:0x033f, B:144:0x0348, B:145:0x034f, B:147:0x035a, B:148:0x0361, B:150:0x036c, B:151:0x0373, B:153:0x037e, B:154:0x0385, B:156:0x0390, B:157:0x0397, B:159:0x03a2, B:160:0x03a9, B:162:0x03b4, B:163:0x03bb, B:165:0x03c6, B:166:0x03ca, B:127:0x02e1, B:115:0x02e6), top: B:190:0x02aa, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:138:0x0328 A[Catch: Exception -> 0x045d, TryCatch #1 {Exception -> 0x045d, blocks: (B:191:0x02aa, B:111:0x02cb, B:113:0x02d4, B:118:0x02f1, B:128:0x02f8, B:130:0x0306, B:132:0x030c, B:133:0x0313, B:135:0x0319, B:136:0x031f, B:138:0x0328, B:139:0x032f, B:141:0x0338, B:142:0x033f, B:144:0x0348, B:145:0x034f, B:147:0x035a, B:148:0x0361, B:150:0x036c, B:151:0x0373, B:153:0x037e, B:154:0x0385, B:156:0x0390, B:157:0x0397, B:159:0x03a2, B:160:0x03a9, B:162:0x03b4, B:163:0x03bb, B:165:0x03c6, B:166:0x03ca, B:127:0x02e1, B:115:0x02e6), top: B:190:0x02aa, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:141:0x0338 A[Catch: Exception -> 0x045d, TryCatch #1 {Exception -> 0x045d, blocks: (B:191:0x02aa, B:111:0x02cb, B:113:0x02d4, B:118:0x02f1, B:128:0x02f8, B:130:0x0306, B:132:0x030c, B:133:0x0313, B:135:0x0319, B:136:0x031f, B:138:0x0328, B:139:0x032f, B:141:0x0338, B:142:0x033f, B:144:0x0348, B:145:0x034f, B:147:0x035a, B:148:0x0361, B:150:0x036c, B:151:0x0373, B:153:0x037e, B:154:0x0385, B:156:0x0390, B:157:0x0397, B:159:0x03a2, B:160:0x03a9, B:162:0x03b4, B:163:0x03bb, B:165:0x03c6, B:166:0x03ca, B:127:0x02e1, B:115:0x02e6), top: B:190:0x02aa, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:144:0x0348 A[Catch: Exception -> 0x045d, TryCatch #1 {Exception -> 0x045d, blocks: (B:191:0x02aa, B:111:0x02cb, B:113:0x02d4, B:118:0x02f1, B:128:0x02f8, B:130:0x0306, B:132:0x030c, B:133:0x0313, B:135:0x0319, B:136:0x031f, B:138:0x0328, B:139:0x032f, B:141:0x0338, B:142:0x033f, B:144:0x0348, B:145:0x034f, B:147:0x035a, B:148:0x0361, B:150:0x036c, B:151:0x0373, B:153:0x037e, B:154:0x0385, B:156:0x0390, B:157:0x0397, B:159:0x03a2, B:160:0x03a9, B:162:0x03b4, B:163:0x03bb, B:165:0x03c6, B:166:0x03ca, B:127:0x02e1, B:115:0x02e6), top: B:190:0x02aa, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:147:0x035a A[Catch: Exception -> 0x045d, TryCatch #1 {Exception -> 0x045d, blocks: (B:191:0x02aa, B:111:0x02cb, B:113:0x02d4, B:118:0x02f1, B:128:0x02f8, B:130:0x0306, B:132:0x030c, B:133:0x0313, B:135:0x0319, B:136:0x031f, B:138:0x0328, B:139:0x032f, B:141:0x0338, B:142:0x033f, B:144:0x0348, B:145:0x034f, B:147:0x035a, B:148:0x0361, B:150:0x036c, B:151:0x0373, B:153:0x037e, B:154:0x0385, B:156:0x0390, B:157:0x0397, B:159:0x03a2, B:160:0x03a9, B:162:0x03b4, B:163:0x03bb, B:165:0x03c6, B:166:0x03ca, B:127:0x02e1, B:115:0x02e6), top: B:190:0x02aa, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:150:0x036c A[Catch: Exception -> 0x045d, TryCatch #1 {Exception -> 0x045d, blocks: (B:191:0x02aa, B:111:0x02cb, B:113:0x02d4, B:118:0x02f1, B:128:0x02f8, B:130:0x0306, B:132:0x030c, B:133:0x0313, B:135:0x0319, B:136:0x031f, B:138:0x0328, B:139:0x032f, B:141:0x0338, B:142:0x033f, B:144:0x0348, B:145:0x034f, B:147:0x035a, B:148:0x0361, B:150:0x036c, B:151:0x0373, B:153:0x037e, B:154:0x0385, B:156:0x0390, B:157:0x0397, B:159:0x03a2, B:160:0x03a9, B:162:0x03b4, B:163:0x03bb, B:165:0x03c6, B:166:0x03ca, B:127:0x02e1, B:115:0x02e6), top: B:190:0x02aa, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:153:0x037e A[Catch: Exception -> 0x045d, TryCatch #1 {Exception -> 0x045d, blocks: (B:191:0x02aa, B:111:0x02cb, B:113:0x02d4, B:118:0x02f1, B:128:0x02f8, B:130:0x0306, B:132:0x030c, B:133:0x0313, B:135:0x0319, B:136:0x031f, B:138:0x0328, B:139:0x032f, B:141:0x0338, B:142:0x033f, B:144:0x0348, B:145:0x034f, B:147:0x035a, B:148:0x0361, B:150:0x036c, B:151:0x0373, B:153:0x037e, B:154:0x0385, B:156:0x0390, B:157:0x0397, B:159:0x03a2, B:160:0x03a9, B:162:0x03b4, B:163:0x03bb, B:165:0x03c6, B:166:0x03ca, B:127:0x02e1, B:115:0x02e6), top: B:190:0x02aa, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:156:0x0390 A[Catch: Exception -> 0x045d, TryCatch #1 {Exception -> 0x045d, blocks: (B:191:0x02aa, B:111:0x02cb, B:113:0x02d4, B:118:0x02f1, B:128:0x02f8, B:130:0x0306, B:132:0x030c, B:133:0x0313, B:135:0x0319, B:136:0x031f, B:138:0x0328, B:139:0x032f, B:141:0x0338, B:142:0x033f, B:144:0x0348, B:145:0x034f, B:147:0x035a, B:148:0x0361, B:150:0x036c, B:151:0x0373, B:153:0x037e, B:154:0x0385, B:156:0x0390, B:157:0x0397, B:159:0x03a2, B:160:0x03a9, B:162:0x03b4, B:163:0x03bb, B:165:0x03c6, B:166:0x03ca, B:127:0x02e1, B:115:0x02e6), top: B:190:0x02aa, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:159:0x03a2 A[Catch: Exception -> 0x045d, TryCatch #1 {Exception -> 0x045d, blocks: (B:191:0x02aa, B:111:0x02cb, B:113:0x02d4, B:118:0x02f1, B:128:0x02f8, B:130:0x0306, B:132:0x030c, B:133:0x0313, B:135:0x0319, B:136:0x031f, B:138:0x0328, B:139:0x032f, B:141:0x0338, B:142:0x033f, B:144:0x0348, B:145:0x034f, B:147:0x035a, B:148:0x0361, B:150:0x036c, B:151:0x0373, B:153:0x037e, B:154:0x0385, B:156:0x0390, B:157:0x0397, B:159:0x03a2, B:160:0x03a9, B:162:0x03b4, B:163:0x03bb, B:165:0x03c6, B:166:0x03ca, B:127:0x02e1, B:115:0x02e6), top: B:190:0x02aa, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:162:0x03b4 A[Catch: Exception -> 0x045d, TryCatch #1 {Exception -> 0x045d, blocks: (B:191:0x02aa, B:111:0x02cb, B:113:0x02d4, B:118:0x02f1, B:128:0x02f8, B:130:0x0306, B:132:0x030c, B:133:0x0313, B:135:0x0319, B:136:0x031f, B:138:0x0328, B:139:0x032f, B:141:0x0338, B:142:0x033f, B:144:0x0348, B:145:0x034f, B:147:0x035a, B:148:0x0361, B:150:0x036c, B:151:0x0373, B:153:0x037e, B:154:0x0385, B:156:0x0390, B:157:0x0397, B:159:0x03a2, B:160:0x03a9, B:162:0x03b4, B:163:0x03bb, B:165:0x03c6, B:166:0x03ca, B:127:0x02e1, B:115:0x02e6), top: B:190:0x02aa, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:165:0x03c6 A[Catch: Exception -> 0x045d, TryCatch #1 {Exception -> 0x045d, blocks: (B:191:0x02aa, B:111:0x02cb, B:113:0x02d4, B:118:0x02f1, B:128:0x02f8, B:130:0x0306, B:132:0x030c, B:133:0x0313, B:135:0x0319, B:136:0x031f, B:138:0x0328, B:139:0x032f, B:141:0x0338, B:142:0x033f, B:144:0x0348, B:145:0x034f, B:147:0x035a, B:148:0x0361, B:150:0x036c, B:151:0x0373, B:153:0x037e, B:154:0x0385, B:156:0x0390, B:157:0x0397, B:159:0x03a2, B:160:0x03a9, B:162:0x03b4, B:163:0x03bb, B:165:0x03c6, B:166:0x03ca, B:127:0x02e1, B:115:0x02e6), top: B:190:0x02aa, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:170:0x03f2 A[Catch: Exception -> 0x0476, TryCatch #5 {Exception -> 0x0476, blocks: (B:168:0x03e6, B:170:0x03f2, B:171:0x0405, B:173:0x0428, B:174:0x0445, B:176:0x044e, B:177:0x0454, B:202:0x0461, B:204:0x0468, B:205:0x046f), top: B:9:0x009f }] */
    /* JADX WARN: Removed duplicated region for block: B:173:0x0428 A[Catch: Exception -> 0x0476, TryCatch #5 {Exception -> 0x0476, blocks: (B:168:0x03e6, B:170:0x03f2, B:171:0x0405, B:173:0x0428, B:174:0x0445, B:176:0x044e, B:177:0x0454, B:202:0x0461, B:204:0x0468, B:205:0x046f), top: B:9:0x009f }] */
    /* JADX WARN: Removed duplicated region for block: B:176:0x044e A[Catch: Exception -> 0x0476, TryCatch #5 {Exception -> 0x0476, blocks: (B:168:0x03e6, B:170:0x03f2, B:171:0x0405, B:173:0x0428, B:174:0x0445, B:176:0x044e, B:177:0x0454, B:202:0x0461, B:204:0x0468, B:205:0x046f), top: B:9:0x009f }] */
    /* JADX WARN: Removed duplicated region for block: B:180:0x03b9  */
    /* JADX WARN: Removed duplicated region for block: B:181:0x03a7  */
    /* JADX WARN: Removed duplicated region for block: B:182:0x0395  */
    /* JADX WARN: Removed duplicated region for block: B:183:0x0383  */
    /* JADX WARN: Removed duplicated region for block: B:184:0x0371  */
    /* JADX WARN: Removed duplicated region for block: B:185:0x035f  */
    /* JADX WARN: Removed duplicated region for block: B:186:0x034d  */
    /* JADX WARN: Removed duplicated region for block: B:187:0x033d  */
    /* JADX WARN: Removed duplicated region for block: B:188:0x032d  */
    /* JADX WARN: Removed duplicated region for block: B:189:0x031e  */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v3, types: [org.json.JSONObject, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v5 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void openTenpayView(Bundle bundle) {
        PayLogicImpl payLogicImpl;
        QBaseActivity qBaseActivity;
        Bundle bundle2;
        int i3;
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        String str9;
        Bundle bundle3;
        int i16;
        String str10;
        String str11;
        String str12;
        String str13;
        QBaseActivity qBaseActivity2 = this.mActivity;
        String string = bundle.getString("callbackSn");
        f.b(IPayLogic.TAG, "PayBridgeActivity openTenpayView request=" + bundle.toString() + ",callbackSn=" + String.valueOf(string));
        try {
            payLogicImpl = new JSONObject(bundle.getString(ark.ARKMETADATA_JSON));
            String optString = payLogicImpl.optString("userId");
            if (TextUtils.isEmpty(optString) || optString.startsWith("0")) {
                optString = this.app.getCurrentUin();
            }
            String str14 = optString;
            String string2 = payLogicImpl.getString(HippyHeaderListViewController.VIEW_TAG);
            f.b(string2, "openTenpayView json = " + ((Object) payLogicImpl));
            this.mOpenViewTag = string2;
            try {
                if (string2 != null && allowView.contains(string2)) {
                    if (QWalletFakeUrl.FAKEURL_TRANSFERINPUT.compareTo(string2) == 0) {
                        ((INewQWalletApi) QRoute.api(INewQWalletApi.class)).launchPayTransferPage(qBaseActivity2);
                        return;
                    }
                    String str15 = "";
                    if (TransactionActivity.PREF_NAME_TRANSFER.compareTo(string2) == 0) {
                        Intent intent = new Intent();
                        intent.putExtra("callbackSn", string);
                        intent.putExtra("come_from", 1);
                        intent.putExtra("isJumpToH5", false);
                        intent.putExtra("tag", string2);
                        if (!payLogicImpl.has("appInfo")) {
                            str13 = "";
                        } else {
                            str13 = payLogicImpl.getString("appInfo");
                        }
                        intent.putExtra(j.T0, str13);
                        if (payLogicImpl.has("extra_data")) {
                            str15 = payLogicImpl.getString("extra_data");
                        }
                        intent.putExtra("extra_data", str15);
                        RouteUtils.startActivityForResult(qBaseActivity2, intent, "/qwallet/transaction", 5);
                        return;
                    }
                    if ("makeHongbao".compareTo(string2) == 0) {
                        JSONObject optJSONObject = payLogicImpl.optJSONObject("extra_data");
                        if (optJSONObject != null) {
                            String optString2 = optJSONObject.optString("hb_from_type", "0");
                            if (!optString2.equals("0") && !optString2.equals("1") && !optString2.equals("2") && !optString2.equals("100")) {
                                tenpayResult(string, "{'resultCode':-1001,'retmsg':'hb_from_type\u53c2\u6570\u9519\u8bef'}");
                                return;
                            }
                            if (optString2.equals("0")) {
                                if (optJSONObject.has("hb_from")) {
                                    optJSONObject.remove("hb_from");
                                }
                                if (optJSONObject.has("makeHb_type")) {
                                    optJSONObject.remove("makeHb_type");
                                }
                                if (optJSONObject.has("skin_id")) {
                                    optJSONObject.remove("skin_id");
                                }
                                if (optJSONObject.has("feedsid")) {
                                    optJSONObject.remove("feedsid");
                                }
                                if (optJSONObject.has("total_amount")) {
                                    optJSONObject.remove("total_amount");
                                }
                                if (optJSONObject.has("total_num")) {
                                    optJSONObject.remove("total_num");
                                }
                                if (optJSONObject.has("wishing")) {
                                    optJSONObject.remove("wishing");
                                }
                                if (optJSONObject.has("biz_params")) {
                                    optJSONObject.remove("biz_params");
                                }
                                Intent intent2 = new Intent();
                                intent2.putExtra("callbackSn", string);
                                intent2.putExtra("come_from", 2);
                                intent2.putExtra("is_H5", true);
                                if (!payLogicImpl.has("appInfo")) {
                                    str12 = "";
                                } else {
                                    str12 = payLogicImpl.getString("appInfo");
                                }
                                intent2.putExtra(j.T0, str12);
                                if (payLogicImpl.has("extra_data")) {
                                    str15 = payLogicImpl.getString("extra_data");
                                }
                                intent2.putExtra("extra_data", str15);
                                RouteUtils.startActivityForResult(qBaseActivity2, intent2, "/qwallet/redpacket/sendhb", 5);
                                return;
                            }
                            if (zk2.a.d(optJSONObject, string, qBaseActivity2)) {
                                return;
                            }
                        }
                        Intent intent3 = new Intent();
                        intent3.putExtra("callbackSn", string);
                        intent3.putExtra("come_from", 2);
                        intent3.putExtra("is_H5", true);
                        if (!payLogicImpl.has("appInfo")) {
                            str11 = "";
                        } else {
                            str11 = payLogicImpl.getString("appInfo");
                        }
                        intent3.putExtra(j.T0, str11);
                        if (payLogicImpl.has("extra_data")) {
                            str15 = payLogicImpl.getString("extra_data");
                        }
                        intent3.putExtra("extra_data", str15);
                        RouteUtils.startActivityForResult(qBaseActivity2, intent3, "/qwallet/redpacket/sendhb", 5);
                        return;
                    }
                    if ("parseqrcode".compareTo(string2) == 0) {
                        Intent intent4 = new Intent();
                        intent4.putExtra("callbackSn", string);
                        if (payLogicImpl.has(PayProxy.Source.PAY_REQUEST_PAY_COME_FROM)) {
                            i16 = payLogicImpl.getInt(PayProxy.Source.PAY_REQUEST_PAY_COME_FROM);
                        } else {
                            i16 = 5;
                        }
                        intent4.putExtra("come_from", i16);
                        if (!payLogicImpl.has("appInfo")) {
                            str10 = "";
                        } else {
                            str10 = payLogicImpl.getString("appInfo");
                        }
                        intent4.putExtra(j.T0, str10);
                        if (payLogicImpl.has("extra_data")) {
                            str15 = payLogicImpl.getString("extra_data");
                        }
                        intent4.putExtra("extra_data", str15);
                        RouteUtils.startActivityForResult(qBaseActivity2, intent4, "/qwallet/tenpay/jump", 5);
                        return;
                    }
                    if ("transferqrcode".compareTo(string2) == 0) {
                        try {
                            String currentNickname = this.app.getCurrentNickname();
                            JSONObject optJSONObject2 = payLogicImpl.optJSONObject("extra_data");
                            if (optJSONObject2 == null) {
                                try {
                                    optJSONObject2 = new JSONObject();
                                } catch (Exception unused) {
                                }
                            }
                            qBaseActivity = qBaseActivity2;
                            JSONObject jSONObject = optJSONObject2;
                            try {
                                jSONObject.put("name", currentNickname);
                                payLogicImpl.put("extra_data", jSONObject);
                            } catch (Exception unused2) {
                            }
                            if (TextUtils.equals("openSchema", string2)) {
                                String optString3 = payLogicImpl.optString("url");
                                JSONObject optJSONObject3 = payLogicImpl.optJSONObject("extra_data");
                                if (optJSONObject3 == null) {
                                    try {
                                        optJSONObject3 = new JSONObject();
                                    } catch (Exception e16) {
                                        QLog.w(IPayLogic.TAG, 1, "parse openSchema fail", e16);
                                    }
                                }
                                optJSONObject3.put("url", optString3);
                                payLogicImpl.put("extra_data", optJSONObject3);
                            }
                            bundle2 = new Bundle();
                            if (string2.equals(QWalletFakeUrl.FAKEURL_BINDNEWCARD) && payLogicImpl.has("bargainor_id")) {
                                bundle2.putString("bargainor_id", payLogicImpl.getString("bargainor_id"));
                            }
                            if (!payLogicImpl.has(PayProxy.Source.PAY_REQUEST_PAY_COME_FROM)) {
                                i3 = payLogicImpl.getInt(PayProxy.Source.PAY_REQUEST_PAY_COME_FROM);
                            } else {
                                i3 = 1;
                            }
                            bundle2.putInt("come_from", i3);
                            if (payLogicImpl.has("appInfo")) {
                                str = "";
                            } else {
                                str = payLogicImpl.getString("appInfo");
                            }
                            bundle2.putString(j.T0, str);
                            if (payLogicImpl.has("extra_data")) {
                                str2 = "";
                            } else {
                                str2 = payLogicImpl.getString("extra_data");
                            }
                            bundle2.putString("extra_data", str2);
                            if (payLogicImpl.has("grouptype")) {
                                str3 = "";
                            } else {
                                str3 = payLogicImpl.getString("grouptype");
                            }
                            bundle2.putString("grouptype", str3);
                            if (payLogicImpl.has(FSPublishConstants.FSPublishJsBridge.JSON_OBJECT_KEY_GROUP_ID)) {
                                str4 = "";
                            } else {
                                str4 = payLogicImpl.getString(FSPublishConstants.FSPublishJsBridge.JSON_OBJECT_KEY_GROUP_ID);
                            }
                            bundle2.putString(FSPublishConstants.FSPublishJsBridge.JSON_OBJECT_KEY_GROUP_ID, str4);
                            if (payLogicImpl.has("guildId")) {
                                str5 = "";
                            } else {
                                str5 = payLogicImpl.getString("guildId");
                            }
                            bundle2.putString("guildId", str5);
                            if (payLogicImpl.has("tinyId")) {
                                str6 = "";
                            } else {
                                str6 = payLogicImpl.getString("tinyId");
                            }
                            bundle2.putString("tinyId", str6);
                            if (payLogicImpl.has("subGuildId")) {
                                str7 = "";
                            } else {
                                str7 = payLogicImpl.getString("subGuildId");
                            }
                            bundle2.putString("subGuildId", str7);
                            if (payLogicImpl.has("senderuin")) {
                                str8 = "";
                            } else {
                                str8 = payLogicImpl.getString("senderuin");
                            }
                            bundle2.putString("senderuin", str8);
                            if (payLogicImpl.has("sourceId")) {
                                str9 = "";
                            } else {
                                str9 = payLogicImpl.getString("sourceId");
                            }
                            bundle2.putString("sourceId", str9);
                            if (payLogicImpl.has(RealNameSource.EXTRA_KEY_SOURCE_NAME)) {
                                str15 = payLogicImpl.getString(RealNameSource.EXTRA_KEY_SOURCE_NAME);
                            }
                            bundle2.putString(RealNameSource.EXTRA_KEY_SOURCE_NAME, str15);
                            Bundle bundle4 = new Bundle(bundle);
                            bundle4.putString("callbackSn", string);
                            bundle4.putString("tag", string2);
                            bundle4.putString("uin", str14);
                            if (!TextUtils.isEmpty(this.app.getCurrentAccountUin())) {
                                bundle4.putString(IQzoneWebViewPluginHelper.EXTRA_FAMOUS_SHARE_NICKNAME, ((IQWalletNickNameApi) QRoute.api(IQWalletNickNameApi.class)).getCurrentNickName(null));
                            }
                            bundle4.putBundle("params", bundle2);
                            bundle4.putInt(QWalletPayBridge.Key.PAY_INVOKER_ID, 5);
                            bundle4.putInt(PayProxy.Source.PAY_TYPE_EXTRA_KEY, this.mPayType);
                            bundle4.putBoolean(PayProxy.Source.PAY_IS_LOCK_WITHDRAW, this.isLockWithdraw);
                            if (QLog.isDevelopLevel()) {
                                QLog.d("loadQWalletPlugin", 4, "PayBridgeActivity-loadPluginStart=" + System.currentTimeMillis());
                            }
                            bundle3 = bundle.getBundle("extra_ext_data");
                            if (bundle3 != null) {
                                bundle4.putBundle("extra_ext_data", bundle3);
                            }
                            putProxyReceiverToBundle(bundle4);
                            QWalletPayBridge.launchForeground(qBaseActivity, bundle4);
                            return;
                        } catch (Exception e17) {
                            e = e17;
                            payLogicImpl = this;
                            if (QLog.isColorLevel()) {
                                QLog.e(IPayLogic.TAG, 2, "openTenpayView Exception", e);
                            }
                            payLogicImpl.tenpayResult(string, "{'resultCode':-1,'retmsg':'openTenpayView Exception'}");
                            QLog.e(IPayLogic.TAG, 1, "error msg in qqpay-impl module: ", e);
                            return;
                        }
                    }
                    qBaseActivity = qBaseActivity2;
                    if (TextUtils.equals("openSchema", string2)) {
                    }
                    bundle2 = new Bundle();
                    if (string2.equals(QWalletFakeUrl.FAKEURL_BINDNEWCARD)) {
                        bundle2.putString("bargainor_id", payLogicImpl.getString("bargainor_id"));
                    }
                    if (!payLogicImpl.has(PayProxy.Source.PAY_REQUEST_PAY_COME_FROM)) {
                    }
                    bundle2.putInt("come_from", i3);
                    if (payLogicImpl.has("appInfo")) {
                    }
                    bundle2.putString(j.T0, str);
                    if (payLogicImpl.has("extra_data")) {
                    }
                    bundle2.putString("extra_data", str2);
                    if (payLogicImpl.has("grouptype")) {
                    }
                    bundle2.putString("grouptype", str3);
                    if (payLogicImpl.has(FSPublishConstants.FSPublishJsBridge.JSON_OBJECT_KEY_GROUP_ID)) {
                    }
                    bundle2.putString(FSPublishConstants.FSPublishJsBridge.JSON_OBJECT_KEY_GROUP_ID, str4);
                    if (payLogicImpl.has("guildId")) {
                    }
                    bundle2.putString("guildId", str5);
                    if (payLogicImpl.has("tinyId")) {
                    }
                    bundle2.putString("tinyId", str6);
                    if (payLogicImpl.has("subGuildId")) {
                    }
                    bundle2.putString("subGuildId", str7);
                    if (payLogicImpl.has("senderuin")) {
                    }
                    bundle2.putString("senderuin", str8);
                    if (payLogicImpl.has("sourceId")) {
                    }
                    bundle2.putString("sourceId", str9);
                    if (payLogicImpl.has(RealNameSource.EXTRA_KEY_SOURCE_NAME)) {
                    }
                    bundle2.putString(RealNameSource.EXTRA_KEY_SOURCE_NAME, str15);
                    Bundle bundle42 = new Bundle(bundle);
                    bundle42.putString("callbackSn", string);
                    bundle42.putString("tag", string2);
                    bundle42.putString("uin", str14);
                    if (!TextUtils.isEmpty(this.app.getCurrentAccountUin())) {
                    }
                    bundle42.putBundle("params", bundle2);
                    bundle42.putInt(QWalletPayBridge.Key.PAY_INVOKER_ID, 5);
                    bundle42.putInt(PayProxy.Source.PAY_TYPE_EXTRA_KEY, this.mPayType);
                    bundle42.putBoolean(PayProxy.Source.PAY_IS_LOCK_WITHDRAW, this.isLockWithdraw);
                    if (QLog.isDevelopLevel()) {
                    }
                    bundle3 = bundle.getBundle("extra_ext_data");
                    if (bundle3 != null) {
                    }
                    putProxyReceiverToBundle(bundle42);
                    QWalletPayBridge.launchForeground(qBaseActivity, bundle42);
                    return;
                }
                if (QLog.isColorLevel()) {
                    QLog.e(string2, 2, "openTenpayView viewTag is not allow");
                }
                tenpayResult(string, "{'resultCode':-1,'retmsg':'openTenpayView param viewTag error'}");
            } catch (Exception e18) {
                e = e18;
            }
        } catch (Exception e19) {
            e = e19;
            payLogicImpl = this;
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(13:1|(14:3|4|5|6|7|8|(1:10)|11|12|13|14|15|(3:17|18|19)(3:41|42|43)|20)(1:60)|59|8|(0)|11|12|13|14|15|(0)(0)|20|(1:(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x00b1, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x00b2, code lost:
    
        r16 = "retJson";
        r17 = "retCode";
        r13 = 2;
        r14 = cooperation.qwallet.plugin.IPayLogic.TAG;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x0102, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x0103, code lost:
    
        r2 = 1;
        r1 = "error msg in qqpay-impl module: ";
        r4 = "retJson";
        r3 = "retCode";
        r13 = 2;
        r14 = cooperation.qwallet.plugin.IPayLogic.TAG;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x00bf, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x00c0, code lost:
    
        r18 = "error msg in qqpay-impl module: ";
        r16 = "retJson";
        r17 = "retCode";
        r13 = 2;
        r14 = cooperation.qwallet.plugin.IPayLogic.TAG;
     */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0038  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x010f  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x012e  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00ce  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00ed  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0087  */
    /* JADX WARN: Unreachable blocks removed: 2, instructions: 2 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected static Bundle pay(AppRuntime appRuntime, Activity activity, ResultReceiver resultReceiver, String str, String str2, String str3, int i3, long j3, String str4) {
        String str5;
        String str6;
        String str7;
        String str8;
        String str9;
        int i16;
        String str10;
        int i17;
        String str11;
        String str12;
        String str13;
        Bundle bundle = new Bundle();
        if (!TextUtils.isEmpty(str3)) {
            str5 = str3;
            try {
                str6 = URLDecoder.decode(str5, "UTF-8");
            } catch (UnsupportedEncodingException e16) {
                QLog.e(IPayLogic.TAG, 1, "error msg in qqpay-impl module: ", e16);
            }
            if (QLog.isColorLevel()) {
                QLog.i(IPayLogic.TAG, 2, "pay request=" + str2 + ",callbackSn=" + String.valueOf(str));
            }
            JSONObject jSONObject = new JSONObject(str2);
            if (!a15.a.f(str2)) {
                str8 = "retJson";
                i16 = 2;
                str9 = "retCode";
                str10 = IPayLogic.TAG;
                try {
                    payV2(bundle, jSONObject, activity, resultReceiver, str, str2, i3, j3, str4);
                } catch (JSONException e17) {
                    e = e17;
                    i17 = 1;
                    str11 = "error msg in qqpay-impl module: ";
                    str12 = str8;
                    str13 = str9;
                    if (QLog.isColorLevel()) {
                        QLog.e(str10, i16, "pay JSONException:" + e.getMessage());
                    }
                    if (QLog.isDevelopLevel()) {
                        QLog.e(str10, i17, str11, e);
                    }
                    bundle.putInt(str13, -1);
                    bundle.putString(str12, "{'resultCode':-900,'retmsg':'pay params error','data':{}}");
                    return bundle;
                } catch (Exception e18) {
                    e = e18;
                    str7 = "error msg in qqpay-impl module: ";
                    if (QLog.isColorLevel()) {
                        QLog.e(str10, i16, "pay Exception:" + e.getMessage());
                    }
                    if (QLog.isDevelopLevel()) {
                        QLog.e(str10, 1, str7, e);
                    }
                    bundle.putInt(str9, -1);
                    bundle.putString(str8, "{'resultCode':-900,'retmsg':'pay Exception','data':{}}");
                    return bundle;
                }
            } else {
                str8 = "retJson";
                str9 = "retCode";
                i16 = 2;
                str10 = IPayLogic.TAG;
                str7 = "error msg in qqpay-impl module: ";
                try {
                    payV1(bundle, jSONObject, appRuntime, activity, resultReceiver, str, str2, str6, i3, j3, str4);
                } catch (JSONException e19) {
                    e = e19;
                    str12 = str8;
                    str13 = str9;
                    str11 = str7;
                    i17 = 1;
                    if (QLog.isColorLevel()) {
                    }
                    if (QLog.isDevelopLevel()) {
                    }
                    bundle.putInt(str13, -1);
                    bundle.putString(str12, "{'resultCode':-900,'retmsg':'pay params error','data':{}}");
                    return bundle;
                } catch (Exception e26) {
                    e = e26;
                    if (QLog.isColorLevel()) {
                    }
                    if (QLog.isDevelopLevel()) {
                    }
                    bundle.putInt(str9, -1);
                    bundle.putString(str8, "{'resultCode':-900,'retmsg':'pay Exception','data':{}}");
                    return bundle;
                }
            }
            return bundle;
        }
        str5 = str3;
        str6 = str5;
        if (QLog.isColorLevel()) {
        }
        JSONObject jSONObject2 = new JSONObject(str2);
        if (!a15.a.f(str2)) {
        }
        return bundle;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(25:1|(1:3)(1:89)|4|(1:6)(1:88)|7|(1:9)|10|(3:77|78|(2:82|(16:84|13|14|15|(1:17)|18|19|20|21|(5:23|24|(7:28|(5:30|31|32|33|(2:35|(1:37)(2:38|(1:40)(2:41|(2:43|44)))))(1:62)|45|46|44|25|26)|63|64)(1:69)|53|(1:55)|56|(1:58)|59|60)))|12|13|14|15|(0)|18|19|20|21|(0)(0)|53|(0)|56|(0)|59|60|(1:(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x016c, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x016d, code lost:
    
        r29 = r14;
        r6 = r0;
        r0 = r16;
        r28 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x00f8, code lost:
    
        r0 = new org.json.JSONObject();
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x0101, code lost:
    
        if (android.text.TextUtils.isEmpty(r41) == false) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x0103, code lost:
    
        r0.putOpt("h5_url", r41);
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x0106, code lost:
    
        r0 = r0.toString();
     */
    /* JADX WARN: Removed duplicated region for block: B:17:0x00f0 A[Catch: Exception -> 0x00f8, TryCatch #4 {Exception -> 0x00f8, blocks: (B:15:0x00e2, B:17:0x00f0, B:18:0x00f3), top: B:14:0x00e2 }] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0111 A[Catch: Exception -> 0x016c, TRY_LEAVE, TryCatch #2 {Exception -> 0x016c, blocks: (B:21:0x010b, B:23:0x0111), top: B:20:0x010b }] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x01f8  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x020b  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0165  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static void payV1(Bundle bundle, JSONObject jSONObject, AppRuntime appRuntime, Activity activity, ResultReceiver resultReceiver, String str, String str2, String str3, int i3, long j3, String str4) throws JSONException {
        boolean z16;
        boolean z17;
        boolean z18;
        String str5;
        String str6;
        boolean z19;
        String str7;
        String currentAccountUin = appRuntime.getCurrentAccountUin();
        String property = appRuntime.getApplication().getProperty(Constants.PropertiesKey.nickName.toString() + currentAccountUin);
        String string = jSONObject.getString("tokenId");
        int i16 = jSONObject.has(PayProxy.Source.PAY_REQUEST_PAY_COME_FROM) ? jSONObject.getInt(PayProxy.Source.PAY_REQUEST_PAY_COME_FROM) : 1;
        String str8 = "0";
        String correctAppInfo = ((IQWalletHelper) QRoute.api(IQWalletHelper.class)).getCorrectAppInfo(jSONObject.has("appInfo") ? jSONObject.getString("appInfo") : "", str3);
        String string2 = jSONObject.has("extra_data") ? jSONObject.getString("extra_data") : "";
        String optString = jSONObject.optString("sourceId");
        String optString2 = jSONObject.optString(RealNameSource.EXTRA_KEY_SOURCE_NAME);
        int optInt = jSONObject.optInt("pay_by", -1);
        int optInt2 = jSONObject.optInt("bank_index", -1);
        String optString3 = jSONObject.optString("bank_type");
        if (1 == i3) {
            try {
            } catch (Exception e16) {
                QLog.e(IPayLogic.TAG, 1, "error msg in qqpay-impl module: ", e16);
                z16 = false;
            }
            if (jSONObject.has("pskey") || jSONObject.has("p_skey_forbid")) {
                if (jSONObject.has("banned_user_buff")) {
                    z17 = true;
                    z16 = z17;
                    JSONObject jSONObject2 = new JSONObject(string2);
                    jSONObject2.remove("h5_url");
                    if (!TextUtils.isEmpty(str4)) {
                        jSONObject2.putOpt("h5_url", str4);
                    }
                    String jSONObject3 = jSONObject2.toString();
                    String str9 = jSONObject3;
                    if (TextUtils.isEmpty(correctAppInfo)) {
                        String[] split = correctAppInfo.split("\\|");
                        String str10 = str8;
                        str6 = str10;
                        int i17 = 0;
                        while (i17 < split.length) {
                            try {
                                if (TextUtils.isEmpty(split[i17])) {
                                    z18 = z16;
                                } else {
                                    z18 = z16;
                                    try {
                                        int indexOf = split[i17].indexOf(35);
                                        if (indexOf != -1) {
                                            str7 = split[i17].substring(indexOf + 1);
                                            if (i17 == 0) {
                                                str8 = str7;
                                            } else if (i17 == 1) {
                                                str6 = str7;
                                            } else if (i17 == 2) {
                                                i17++;
                                                str10 = str7;
                                                z16 = z18;
                                            }
                                        }
                                    } catch (Exception e17) {
                                        e = e17;
                                        Exception exc = e;
                                        str5 = str10;
                                        if (QLog.isColorLevel()) {
                                            QLog.e(IPayLogic.TAG, 1, "error msg in qqpay-impl module: ", exc);
                                        }
                                        String str11 = str8;
                                        String str12 = str6;
                                        Bundle bundle2 = new Bundle();
                                        bundle2.putString("callbackSn", str);
                                        bundle2.putString("tokenId", string);
                                        bundle2.putString("userId", currentAccountUin);
                                        bundle2.putString("userName", property);
                                        bundle2.putInt(PayProxy.Source.PAY_REQUEST_PAY_COME_FROM, i16);
                                        bundle2.putString("appInfo", correctAppInfo);
                                        bundle2.putString("extra_data", str9);
                                        bundle2.putString("sourceId", optString);
                                        bundle2.putString(RealNameSource.EXTRA_KEY_SOURCE_NAME, optString2);
                                        bundle2.putInt("pay_by", optInt);
                                        bundle2.putInt("bank_index", optInt2);
                                        bundle2.putString("bank_type", optString3);
                                        bundle2.putBoolean("h5_success", jSONObject.optBoolean("h5_success"));
                                        bundle2.putInt(QWalletPayBridge.Key.PAY_INVOKER_ID, 9);
                                        bundle2.putInt(PayProxy.Source.PAY_TYPE_EXTRA_KEY, i3);
                                        bundle2.putLong(PayProxy.Source.PAY_H5_START_EXTRA_KEY, j3);
                                        z19 = z18;
                                        bundle2.putBoolean(PayProxy.Source.PAY_IS_LOCK_WITHDRAW, z19);
                                        if (z19) {
                                        }
                                        setIPCReceiver(resultReceiver, bundle2);
                                        if (QLog.isDevelopLevel()) {
                                        }
                                        QWalletPayBridge.launchForeground(activity, bundle2);
                                        bundle.putInt("retCode", 0);
                                        bundle.putString("token", string);
                                        bundle.putString("appid", str11);
                                        bundle.putString(WadlProxyConsts.CHANNEL, str5);
                                        bundle.putString("bargainor", str12);
                                    }
                                }
                                str7 = str10;
                                i17++;
                                str10 = str7;
                                z16 = z18;
                            } catch (Exception e18) {
                                e = e18;
                                z18 = z16;
                            }
                        }
                        z18 = z16;
                        str5 = str10;
                    } else {
                        z18 = z16;
                        str5 = str8;
                        str6 = str5;
                    }
                    String str112 = str8;
                    String str122 = str6;
                    Bundle bundle22 = new Bundle();
                    bundle22.putString("callbackSn", str);
                    bundle22.putString("tokenId", string);
                    bundle22.putString("userId", currentAccountUin);
                    bundle22.putString("userName", property);
                    bundle22.putInt(PayProxy.Source.PAY_REQUEST_PAY_COME_FROM, i16);
                    bundle22.putString("appInfo", correctAppInfo);
                    bundle22.putString("extra_data", str9);
                    bundle22.putString("sourceId", optString);
                    bundle22.putString(RealNameSource.EXTRA_KEY_SOURCE_NAME, optString2);
                    bundle22.putInt("pay_by", optInt);
                    bundle22.putInt("bank_index", optInt2);
                    bundle22.putString("bank_type", optString3);
                    bundle22.putBoolean("h5_success", jSONObject.optBoolean("h5_success"));
                    bundle22.putInt(QWalletPayBridge.Key.PAY_INVOKER_ID, 9);
                    bundle22.putInt(PayProxy.Source.PAY_TYPE_EXTRA_KEY, i3);
                    bundle22.putLong(PayProxy.Source.PAY_H5_START_EXTRA_KEY, j3);
                    z19 = z18;
                    bundle22.putBoolean(PayProxy.Source.PAY_IS_LOCK_WITHDRAW, z19);
                    if (z19) {
                        bundle22.putString("noskey_json", str2);
                    }
                    setIPCReceiver(resultReceiver, bundle22);
                    if (QLog.isDevelopLevel()) {
                        QLog.d("loadQWalletPlugin", 4, "PayBridgeActivity-loadPluginStart=" + System.currentTimeMillis());
                    }
                    QWalletPayBridge.launchForeground(activity, bundle22);
                    bundle.putInt("retCode", 0);
                    bundle.putString("token", string);
                    bundle.putString("appid", str112);
                    bundle.putString(WadlProxyConsts.CHANNEL, str5);
                    bundle.putString("bargainor", str122);
                }
            }
        }
        z17 = false;
        z16 = z17;
        JSONObject jSONObject22 = new JSONObject(string2);
        jSONObject22.remove("h5_url");
        if (!TextUtils.isEmpty(str4)) {
        }
        String jSONObject32 = jSONObject22.toString();
        String str92 = jSONObject32;
        if (TextUtils.isEmpty(correctAppInfo)) {
        }
        String str1122 = str8;
        String str1222 = str6;
        Bundle bundle222 = new Bundle();
        bundle222.putString("callbackSn", str);
        bundle222.putString("tokenId", string);
        bundle222.putString("userId", currentAccountUin);
        bundle222.putString("userName", property);
        bundle222.putInt(PayProxy.Source.PAY_REQUEST_PAY_COME_FROM, i16);
        bundle222.putString("appInfo", correctAppInfo);
        bundle222.putString("extra_data", str92);
        bundle222.putString("sourceId", optString);
        bundle222.putString(RealNameSource.EXTRA_KEY_SOURCE_NAME, optString2);
        bundle222.putInt("pay_by", optInt);
        bundle222.putInt("bank_index", optInt2);
        bundle222.putString("bank_type", optString3);
        bundle222.putBoolean("h5_success", jSONObject.optBoolean("h5_success"));
        bundle222.putInt(QWalletPayBridge.Key.PAY_INVOKER_ID, 9);
        bundle222.putInt(PayProxy.Source.PAY_TYPE_EXTRA_KEY, i3);
        bundle222.putLong(PayProxy.Source.PAY_H5_START_EXTRA_KEY, j3);
        z19 = z18;
        bundle222.putBoolean(PayProxy.Source.PAY_IS_LOCK_WITHDRAW, z19);
        if (z19) {
        }
        setIPCReceiver(resultReceiver, bundle222);
        if (QLog.isDevelopLevel()) {
        }
        QWalletPayBridge.launchForeground(activity, bundle222);
        bundle.putInt("retCode", 0);
        bundle.putString("token", string);
        bundle.putString("appid", str1122);
        bundle.putString(WadlProxyConsts.CHANNEL, str5);
        bundle.putString("bargainor", str1222);
    }

    private static void payV2(Bundle bundle, JSONObject jSONObject, Activity activity, ResultReceiver resultReceiver, String str, String str2, int i3, long j3, String str3) throws JSONException {
        int payFrom;
        PayInfo e16 = a15.a.e(activity, str2, str);
        e16.getBase().j(com.tencent.mobileqq.base.a.c());
        Bundle bundle2 = new Bundle();
        boolean z16 = true;
        if (1 != i3 || ((!jSONObject.has("pskey") && !jSONObject.has("p_skey_forbid")) || !jSONObject.has("banned_user_buff"))) {
            z16 = false;
        }
        bundle2.putBoolean(PayProxy.Source.PAY_IS_LOCK_WITHDRAW, z16);
        if (z16) {
            bundle2.putString("noskey_json", str2);
        }
        JSONObject optJSONObject = jSONObject.optJSONObject("extra_data");
        if (optJSONObject == null) {
            optJSONObject = new JSONObject();
        }
        if (!TextUtils.isEmpty(str3)) {
            optJSONObject.put("h5_url", str3);
        }
        bundle2.putString("extra_data", optJSONObject.toString());
        bundle2.putBoolean("h5_success", jSONObject.optBoolean("h5_success"));
        if (jSONObject.has(PayProxy.Source.PAY_REQUEST_PAY_COME_FROM)) {
            payFrom = jSONObject.getInt(PayProxy.Source.PAY_REQUEST_PAY_COME_FROM);
        } else {
            payFrom = e16.getBase().getPayFrom();
        }
        bundle2.putInt(PayProxy.Source.PAY_REQUEST_PAY_COME_FROM, payFrom);
        bundle2.putParcelable(PayInfo.class.getName(), e16);
        bundle2.putInt(PayProxy.Source.PAY_TYPE_EXTRA_KEY, i3);
        bundle2.putLong(PayProxy.Source.PAY_H5_START_EXTRA_KEY, j3);
        bundle2.putInt(QWalletPayBridge.Key.PAY_INVOKER_ID, 24);
        setIPCReceiver(resultReceiver, bundle2);
        QWalletPayBridge.launchForeground(activity, bundle2);
        bundle.putInt("retCode", 0);
    }

    private void putProxyReceiverToBundle(Bundle bundle) {
        setIPCReceiver(new CompactReceiver(ThreadManagerV2.getUIHandlerV2(), this), bundle);
    }

    protected static Bundle rechargeGameCurrency(AppRuntime appRuntime, Activity activity, ResultReceiver resultReceiver, String str, String str2, int i3, long j3, String str3) {
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        Bundle bundle;
        String str9;
        String str10;
        String str11;
        boolean z16;
        String str12;
        boolean z17;
        String str13;
        String str14;
        String str15;
        String str16;
        String str17;
        String str18;
        String str19;
        String str20;
        int i16;
        String str21;
        Bundle bundle2 = new Bundle();
        try {
            try {
                try {
                    JSONObject jSONObject = new JSONObject(str2);
                    String string = jSONObject.getString("offerId");
                    String string2 = jSONObject.getString("userId");
                    String optString = jSONObject.optString("userKey");
                    String optString2 = jSONObject.optString(ShortVideoConstants.PARAM_KEY_SESSION_TYPE);
                    if (jSONObject.has("zoneId")) {
                        str10 = jSONObject.getString("zoneId");
                    } else {
                        str10 = "1";
                    }
                    String str22 = str10;
                    if (jSONObject.has("acctType")) {
                        str11 = jSONObject.getString("acctType");
                    } else {
                        str11 = "common";
                    }
                    String str23 = str11;
                    if (jSONObject.has("numberVisible")) {
                        z16 = jSONObject.getBoolean("numberVisible");
                    } else {
                        z16 = true;
                    }
                    Boolean valueOf = Boolean.valueOf(z16);
                    if (jSONObject.has("saveValue")) {
                        str12 = jSONObject.getString("saveValue");
                    } else {
                        str12 = null;
                    }
                    String str24 = str12;
                    if (jSONObject.has("isCanChange")) {
                        z17 = jSONObject.getBoolean("isCanChange");
                    } else {
                        z17 = true;
                    }
                    Boolean valueOf2 = Boolean.valueOf(z17);
                    String str25 = "";
                    if (jSONObject.has("aid")) {
                        str13 = "aid";
                        str14 = jSONObject.getString("aid");
                    } else {
                        str13 = "aid";
                        str14 = "";
                    }
                    if (jSONObject.has(QzoneVipPaymentJsPlugin.KEY_DISCOUNTID)) {
                        str15 = "isCanChange";
                        str16 = jSONObject.getString(QzoneVipPaymentJsPlugin.KEY_DISCOUNTID);
                    } else {
                        str15 = "isCanChange";
                        str16 = "";
                    }
                    if (jSONObject.has("other")) {
                        str17 = str24;
                        str18 = jSONObject.getString("other");
                    } else {
                        str17 = str24;
                        str18 = "";
                    }
                    if (!jSONObject.has("payload")) {
                        str19 = "";
                    } else {
                        str19 = jSONObject.getString("payload");
                    }
                    if (jSONObject.has("drmInfo")) {
                        str25 = jSONObject.getString("drmInfo");
                    }
                    String str26 = str25;
                    if (jSONObject.has(PayProxy.Source.PAY_REQUEST_PAY_COME_FROM)) {
                        i16 = jSONObject.getInt(PayProxy.Source.PAY_REQUEST_PAY_COME_FROM);
                        str20 = PayProxy.Source.PAY_REQUEST_PAY_COME_FROM;
                    } else {
                        str20 = PayProxy.Source.PAY_REQUEST_PAY_COME_FROM;
                        i16 = 1;
                    }
                    String optString3 = jSONObject.optString(WadlProxyConsts.CHANNEL);
                    Bundle bundle3 = new Bundle();
                    bundle3.putString("offerId", string);
                    if (isEnterMidasTestEnv(jSONObject)) {
                        str21 = "test";
                    } else {
                        str21 = "release";
                    }
                    bundle3.putString("setEnv", str21);
                    bundle3.putBoolean("setLogEnable", true);
                    bundle3.putBoolean("isShowNum", valueOf.booleanValue());
                    bundle3.putString("callbackSn", str);
                    String str27 = getPfPref(i16) + "2013-android-" + AppSetting.f() + "-" + str14;
                    bundle3.putString("userId", string2);
                    bundle3.putString("sessionId", "uin");
                    if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(optString2)) {
                        bundle3.putString(ShortVideoConstants.PARAM_KEY_SESSION_TYPE, optString2);
                        bundle3.putString("userKey", optString);
                    }
                    bundle3.putString("zoneId", str22);
                    bundle3.putString(AdParam.PF, str27);
                    bundle3.putString("pfKey", "pfKey");
                    bundle3.putString("acctType", str23);
                    bundle3.putString(QzoneVipPaymentJsPlugin.KEY_DISCOUNTID, str16);
                    bundle3.putString("other", str18);
                    bundle3.putString("payload", str19);
                    bundle3.putString("drmInfo", str26);
                    bundle3.putString("payChannel", optString3);
                    if (str17 != null && str17.length() > 0) {
                        bundle3.putString("saveValue", str17);
                        bundle3.putBoolean(str15, valueOf2.booleanValue());
                    }
                    bundle3.putInt("resId", 0);
                    bundle3.putInt(QWalletPayBridge.Key.PAY_INVOKER_ID, 6);
                    bundle3.putInt(PayProxy.Source.PAY_TYPE_EXTRA_KEY, i3);
                    bundle3.putLong(PayProxy.Source.PAY_H5_START_EXTRA_KEY, j3);
                    bundle3.putString("payparmas_h5_url", str3);
                    bundle3.putInt(str20, i16);
                    setIPCReceiver(resultReceiver, bundle3);
                    QWalletPayBridge.launchForeground(activity, bundle3);
                    y05.a.a(activity, resultReceiver, bundle3);
                    str7 = "retCode";
                    bundle = bundle2;
                    try {
                        bundle.putInt(str7, 0);
                        bundle.putString("offerId", string);
                        bundle.putString(str13, str14);
                    } catch (JSONException e16) {
                        e = e16;
                        str4 = "{'resultCode':-1,'resultMsg':'rechargeCurrency JSONException'}";
                        str5 = "retJson";
                        str6 = "error msg in qqpay-impl module: ";
                        str8 = IPayLogic.TAG;
                        if (QLog.isColorLevel()) {
                            QLog.e(str8, 2, "rechargeCurrency JSONException:" + e.getMessage());
                        }
                        if (QLog.isDevelopLevel()) {
                            QLog.e(str8, 1, str6, e);
                        }
                        bundle.putInt(str7, -1);
                        bundle.putString(str5, str4);
                        return bundle;
                    } catch (Exception e17) {
                        e = e17;
                        if (QLog.isColorLevel()) {
                            String str28 = "rechargeCurrency Exception:" + e.getMessage();
                            str9 = IPayLogic.TAG;
                            QLog.e(str9, 2, str28);
                        } else {
                            str9 = IPayLogic.TAG;
                        }
                        if (QLog.isDevelopLevel()) {
                            QLog.e(str9, 1, "error msg in qqpay-impl module: ", e);
                        }
                        bundle.putInt(str7, -1);
                        bundle.putString("retJson", "{'resultCode':-1,'resultMsg':'rechargeCurrency JSONException'}");
                        return bundle;
                    }
                } catch (JSONException e18) {
                    e = e18;
                    str7 = "retCode";
                    bundle = bundle2;
                }
            } catch (JSONException e19) {
                e = e19;
                str4 = "{'resultCode':-1,'resultMsg':'rechargeCurrency JSONException'}";
                str5 = "retJson";
                str6 = "error msg in qqpay-impl module: ";
                str7 = "retCode";
                str8 = IPayLogic.TAG;
                bundle = bundle2;
            }
        } catch (Exception e26) {
            e = e26;
            str7 = "retCode";
            bundle = bundle2;
        }
        return bundle;
    }

    /* JADX WARN: Removed duplicated region for block: B:62:0x0261  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0281  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected static Bundle rechargeQb(AppRuntime appRuntime, Activity activity, ResultReceiver resultReceiver, String str, String str2, int i3, long j3, String str3) {
        String str4;
        Bundle bundle;
        String str5;
        String str6;
        String str7;
        String str8;
        String str9;
        String string;
        String str10;
        String str11;
        String str12;
        String str13;
        String str14;
        String str15;
        String str16;
        String str17;
        Bundle bundle2 = new Bundle();
        try {
            try {
                try {
                    JSONObject jSONObject = new JSONObject(str2);
                    String string2 = jSONObject.getString("offerId");
                    String string3 = jSONObject.getString("userId");
                    String optString = jSONObject.optString("userKey");
                    String optString2 = jSONObject.optString(ShortVideoConstants.PARAM_KEY_SESSION_TYPE);
                    String str18 = null;
                    if (jSONObject.has(WadlProxyConsts.CHANNEL)) {
                        try {
                            string = jSONObject.getString(WadlProxyConsts.CHANNEL);
                        } catch (JSONException e16) {
                            e = e16;
                            str8 = "{'resultCode':-1,'resultMsg':'rechargeQb JSONException'}";
                            str5 = "retJson";
                            str6 = "error msg in qqpay-impl module: ";
                            str7 = IPayLogic.TAG;
                            bundle = bundle2;
                            str4 = "retCode";
                            if (QLog.isColorLevel()) {
                                QLog.e(str7, 2, "rechargeQb JSONException:" + e.getMessage());
                            }
                            if (QLog.isDevelopLevel()) {
                                QLog.e(str7, 1, str6, e);
                            }
                            bundle.putInt(str4, -1);
                            bundle.putString(str5, str8);
                            return bundle;
                        }
                    } else {
                        string = null;
                    }
                    if (jSONObject.has("unit")) {
                        str10 = optString2;
                        str11 = jSONObject.getString("unit");
                    } else {
                        str10 = optString2;
                        str11 = null;
                    }
                    if (jSONObject.has("saveValue")) {
                        str12 = jSONObject.getString("saveValue");
                    } else {
                        str12 = null;
                    }
                    String str19 = "";
                    if (jSONObject.has("aid")) {
                        str13 = "aid";
                        str14 = jSONObject.getString("aid");
                    } else {
                        str13 = "aid";
                        str14 = "";
                    }
                    if (jSONObject.has(QzoneVipPaymentJsPlugin.KEY_PROVIDEUIN)) {
                        str15 = jSONObject.getString(QzoneVipPaymentJsPlugin.KEY_PROVIDEUIN);
                    } else {
                        str15 = null;
                    }
                    if (jSONObject.has(QzoneVipPaymentJsPlugin.KEY_PROVIDETYPE)) {
                        str18 = jSONObject.getString(QzoneVipPaymentJsPlugin.KEY_PROVIDETYPE);
                    }
                    String str20 = str18;
                    if (!jSONObject.has(QzoneVipPaymentJsPlugin.KEY_DISCOUNTID)) {
                        str16 = "";
                    } else {
                        str16 = jSONObject.getString(QzoneVipPaymentJsPlugin.KEY_DISCOUNTID);
                    }
                    if (!jSONObject.has("other")) {
                        str17 = "";
                    } else {
                        str17 = jSONObject.getString("other");
                    }
                    if (jSONObject.has("payload")) {
                        str19 = jSONObject.getString("payload");
                    }
                    String str21 = str19;
                    Bundle bundle3 = new Bundle();
                    bundle3.putString("offerId", string2);
                    bundle3.putString("setEnv", "release");
                    bundle3.putBoolean("setLogEnable", true);
                    if (str11 != null && str11.length() > 0) {
                        bundle3.putString("unit", str11);
                    }
                    if (string != null && string.length() > 0) {
                        bundle3.putString("payChannel", string);
                    }
                    bundle3.putString("callbackSn", str);
                    String str22 = "qq_m_qq-2013-android-" + AppSetting.f() + "-" + str14;
                    bundle3.putString("userId", string3);
                    bundle3.putString("sessionId", "uin");
                    if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(str10)) {
                        bundle3.putString(ShortVideoConstants.PARAM_KEY_SESSION_TYPE, str10);
                        bundle3.putString("userKey", optString);
                    }
                    bundle3.putString(AdParam.PF, str22);
                    bundle3.putString("pfKey", "pfKey");
                    bundle3.putString("saveValue", str12);
                    bundle3.putString(QzoneVipPaymentJsPlugin.KEY_PROVIDEUIN, str15);
                    bundle3.putString(QzoneVipPaymentJsPlugin.KEY_PROVIDETYPE, str20);
                    bundle3.putString(QzoneVipPaymentJsPlugin.KEY_DISCOUNTID, str16);
                    bundle3.putString("other", str17);
                    bundle3.putString("payload", str21);
                    bundle3.putInt(QWalletPayBridge.Key.PAY_INVOKER_ID, 8);
                    bundle3.putInt(PayProxy.Source.PAY_TYPE_EXTRA_KEY, i3);
                    bundle3.putLong(PayProxy.Source.PAY_H5_START_EXTRA_KEY, j3);
                    bundle3.putString("payparmas_h5_url", str3);
                    setIPCReceiver(resultReceiver, bundle3);
                    QWalletPayBridge.launchForeground(activity, bundle3);
                    y05.a.a(activity, resultReceiver, bundle3);
                    bundle = bundle2;
                    str4 = "retCode";
                    try {
                        bundle.putInt(str4, 0);
                        bundle.putString("offerId", string2);
                        bundle.putString(str13, str14);
                    } catch (JSONException e17) {
                        e = e17;
                        str8 = "{'resultCode':-1,'resultMsg':'rechargeQb JSONException'}";
                        str5 = "retJson";
                        str6 = "error msg in qqpay-impl module: ";
                        str7 = IPayLogic.TAG;
                        if (QLog.isColorLevel()) {
                        }
                        if (QLog.isDevelopLevel()) {
                        }
                        bundle.putInt(str4, -1);
                        bundle.putString(str5, str8);
                        return bundle;
                    } catch (Exception e18) {
                        e = e18;
                        if (QLog.isColorLevel()) {
                            String str23 = "rechargeQb Exception:" + e.getMessage();
                            str9 = IPayLogic.TAG;
                            QLog.e(str9, 2, str23);
                        } else {
                            str9 = IPayLogic.TAG;
                        }
                        if (QLog.isDevelopLevel()) {
                            QLog.e(str9, 1, "error msg in qqpay-impl module: ", e);
                        }
                        bundle.putInt(str4, -1);
                        bundle.putString("retJson", "{'resultCode':-1,'resultMsg':'rechargeQb JSONException'}");
                        return bundle;
                    }
                } catch (JSONException e19) {
                    e = e19;
                    bundle = bundle2;
                    str4 = "retCode";
                }
            } catch (Exception e26) {
                e = e26;
                bundle = bundle2;
                str4 = "retCode";
            }
        } catch (JSONException e27) {
            e = e27;
            str4 = "retCode";
            str5 = "retJson";
            str6 = "error msg in qqpay-impl module: ";
            str7 = IPayLogic.TAG;
            bundle = bundle2;
            str8 = "{'resultCode':-1,'resultMsg':'rechargeQb JSONException'}";
        } catch (Exception e28) {
            e = e28;
            str4 = "retCode";
            bundle = bundle2;
        }
        return bundle;
    }

    private static void remove(PayLogicImpl payLogicImpl) {
        if (payLogicImpl != null) {
            sPayLogics.remove(payLogicImpl.getTag());
        }
    }

    private void saveNonePCPayResultData(int i3, Intent intent) {
        if (!this.isFromPCPush && this.saveResultData == null) {
            this.saveResultData = intent;
            this.saveResultCode = i3;
        }
    }

    private void setActivityRef(QBaseActivity qBaseActivity) {
        if (qBaseActivity != null) {
            this.mActivity = qBaseActivity;
        }
    }

    public static void setIPCReceiver(ResultReceiver resultReceiver, Bundle bundle) {
        boolean z16;
        if (resultReceiver != null && bundle != null) {
            Parcel obtain = Parcel.obtain();
            if (QWalletPayBridge.isMidasInvokerId(bundle.getInt(QWalletPayBridge.Key.PAY_INVOKER_ID)) && !((IQWalletUnitedConfigApi) QRoute.api(IQWalletUnitedConfigApi.class)).isSwitchOn(IQWalletUnitedConfigApi.QWALLET_DISABLE_MIDAS_RESULT_MONITOR, false)) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                resultReceiver = new MidasPayResultReceiver(resultReceiver, bundle, new Handler(MobileQQ.sMobileQQ.getMainLooper()));
            }
            resultReceiver.writeToParcel(obtain, 0);
            obtain.setDataPosition(0);
            ResultReceiver resultReceiver2 = (ResultReceiver) ResultReceiver.CREATOR.createFromParcel(obtain);
            OaidMonitor.parcelRecycle(obtain);
            bundle.putParcelable(IPayLogic.RECEIVER_COM_KEY, resultReceiver2);
        }
    }

    public static void setIsPaying(boolean z16) {
        isPaying = z16;
    }

    /* JADX WARN: Removed duplicated region for block: B:109:0x034c  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x036c  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0305  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x032a  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x0322  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected static Bundle subscribeMonthCardPay(AppRuntime appRuntime, Activity activity, ResultReceiver resultReceiver, String str, String str2, int i3, long j3, String str3) {
        String str4;
        String str5;
        Bundle bundle;
        String str6;
        boolean z16;
        String str7;
        String str8;
        String str9;
        boolean z17;
        String str10;
        boolean z18;
        String str11;
        String str12;
        String str13;
        String str14;
        String str15;
        String str16;
        String str17;
        String str18;
        String str19;
        String str20;
        Bundle bundle2 = new Bundle();
        try {
            try {
                try {
                    JSONObject jSONObject = new JSONObject(str2);
                    String string = jSONObject.getString("offerId");
                    if (jSONObject.has("isShowNum")) {
                        z16 = jSONObject.getBoolean("isShowNum");
                    } else {
                        z16 = true;
                    }
                    String str21 = null;
                    if (!jSONObject.has("unit")) {
                        str7 = "unit";
                        str8 = null;
                    } else {
                        str8 = jSONObject.getString("unit");
                        str7 = "unit";
                    }
                    String string2 = jSONObject.getString("userId");
                    String optString = jSONObject.optString("userKey");
                    String optString2 = jSONObject.optString(ShortVideoConstants.PARAM_KEY_SESSION_TYPE);
                    String string3 = jSONObject.getString("serviceCode");
                    String string4 = jSONObject.getString("serviceName");
                    if (jSONObject.has(WadlProxyConsts.CHANNEL)) {
                        str9 = jSONObject.getString(WadlProxyConsts.CHANNEL);
                    } else {
                        str9 = null;
                    }
                    if (jSONObject.has("saveValue")) {
                        str21 = jSONObject.getString("saveValue");
                    }
                    String str22 = str21;
                    if (jSONObject.has("isCanChange")) {
                        z17 = jSONObject.getBoolean("isCanChange");
                    } else {
                        z17 = false;
                    }
                    Boolean valueOf = Boolean.valueOf(z17);
                    String str23 = "";
                    if (!jSONObject.has("remark")) {
                        str10 = "";
                    } else {
                        str10 = jSONObject.getString("remark");
                    }
                    if (jSONObject.has("autoPay")) {
                        z18 = jSONObject.getBoolean("autoPay");
                    } else {
                        z18 = true;
                    }
                    Boolean valueOf2 = Boolean.valueOf(z18);
                    if (!jSONObject.has("aid")) {
                        str11 = "";
                    } else {
                        str11 = jSONObject.getString("aid");
                    }
                    if (jSONObject.has("productId")) {
                        str12 = "aid";
                        str13 = jSONObject.getString("productId");
                    } else {
                        str12 = "aid";
                        str13 = "";
                    }
                    if (!jSONObject.has("couponId")) {
                        str14 = "";
                    } else {
                        str14 = jSONObject.getString("couponId");
                    }
                    if (!jSONObject.has("other")) {
                        str15 = "";
                    } else {
                        str15 = jSONObject.getString("other");
                    }
                    if (!jSONObject.has("payload")) {
                        str16 = "";
                    } else {
                        str16 = jSONObject.getString("payload");
                    }
                    if (!jSONObject.has("drmInfo")) {
                        str17 = "";
                    } else {
                        str17 = jSONObject.getString("drmInfo");
                    }
                    if (!jSONObject.has(QzoneVipPaymentJsPlugin.KEY_PROVIDEUIN)) {
                        str18 = "";
                    } else {
                        str18 = jSONObject.getString(QzoneVipPaymentJsPlugin.KEY_PROVIDEUIN);
                    }
                    if (!jSONObject.has(QzoneVipPaymentJsPlugin.KEY_PROVIDETYPE)) {
                        str19 = "";
                    } else {
                        str19 = jSONObject.getString(QzoneVipPaymentJsPlugin.KEY_PROVIDETYPE);
                    }
                    if (jSONObject.has(QzoneVipPaymentJsPlugin.KEY_DISCOUNTID)) {
                        str23 = jSONObject.getString(QzoneVipPaymentJsPlugin.KEY_DISCOUNTID);
                    }
                    String str24 = str23;
                    if (jSONObject.has(AdParam.PF)) {
                        str20 = jSONObject.getString(AdParam.PF);
                    } else {
                        str20 = "qq_m_qq-2013-android-" + AppSetting.f() + "-" + str11;
                    }
                    Bundle bundle3 = new Bundle();
                    String str25 = str11;
                    bundle3.putString("setEnv", "release");
                    bundle3.putBoolean("setLogEnable", false);
                    bundle3.putString("offerId", string);
                    bundle3.putBoolean("isShowNum", z16);
                    if (str8 != null && str8.length() > 0) {
                        bundle3.putString(str7, str8);
                    }
                    if (str9 != null && str9.length() > 0) {
                        bundle3.putString("payChannel", str9);
                    }
                    bundle3.putString("callbackSn", str);
                    bundle3.putString("userId", string2);
                    bundle3.putString("sessionId", "uin");
                    if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(optString2)) {
                        bundle3.putString(ShortVideoConstants.PARAM_KEY_SESSION_TYPE, optString2);
                        bundle3.putString("userKey", optString);
                    }
                    bundle3.putString(AdParam.PF, str20);
                    bundle3.putString("pfKey", "pfKey");
                    if (str22 != null && str22.length() > 0) {
                        bundle3.putString("saveValue", str22);
                        bundle3.putBoolean("isCanChange", valueOf.booleanValue());
                    }
                    bundle3.putInt("resId", 0);
                    bundle3.putString("serviceCode", string3);
                    bundle3.putString("serviceName", string4);
                    bundle3.putString("remark", str10);
                    bundle3.putBoolean("autoPay", valueOf2.booleanValue());
                    bundle3.putString("productId", str13);
                    bundle3.putString("couponId", str14);
                    bundle3.putString("other", str15);
                    bundle3.putString("payload", str16);
                    bundle3.putString("drmInfo", str17);
                    bundle3.putString(QzoneVipPaymentJsPlugin.KEY_PROVIDEUIN, str18);
                    bundle3.putString(QzoneVipPaymentJsPlugin.KEY_PROVIDETYPE, str19);
                    bundle3.putString(QzoneVipPaymentJsPlugin.KEY_DISCOUNTID, str24);
                    bundle3.putInt(QWalletPayBridge.Key.PAY_INVOKER_ID, 14);
                    bundle3.putInt(PayProxy.Source.PAY_TYPE_EXTRA_KEY, i3);
                    bundle3.putLong(PayProxy.Source.PAY_H5_START_EXTRA_KEY, j3);
                    bundle3.putString("payparmas_h5_url", str3);
                    str4 = "retCode";
                    try {
                        setIPCReceiver(resultReceiver, bundle3);
                        QWalletPayBridge.launchForeground(activity, bundle3);
                        y05.a.a(activity, resultReceiver, bundle3);
                        bundle = bundle2;
                        try {
                            bundle.putInt(str4, 0);
                            bundle.putString("offerId", string);
                            bundle.putString(str12, str25);
                        } catch (JSONException e16) {
                            e = e16;
                            str5 = IPayLogic.TAG;
                            if (QLog.isColorLevel()) {
                            }
                            if (QLog.isDevelopLevel()) {
                            }
                            bundle.putInt(str4, -1);
                            bundle.putString("retJson", "{'resultCode':-1,'resultMsg':'subscribeMonthCardPay JSONException'}");
                            return bundle;
                        } catch (Exception e17) {
                            e = e17;
                            if (!QLog.isColorLevel()) {
                            }
                            if (QLog.isDevelopLevel()) {
                            }
                            bundle.putInt(str4, -1);
                            bundle.putString("retJson", "{'resultCode':-1,'resultMsg':'subscribeMonthCardPay Exception'}");
                            return bundle;
                        }
                    } catch (JSONException e18) {
                        e = e18;
                        bundle = bundle2;
                        str5 = IPayLogic.TAG;
                        if (QLog.isColorLevel()) {
                            QLog.e(str5, 2, "subscribeMonthCardPay JSONException:" + e.getMessage());
                        }
                        if (QLog.isDevelopLevel()) {
                            QLog.e(str5, 1, "error msg in qqpay-impl module: ", e);
                        }
                        bundle.putInt(str4, -1);
                        bundle.putString("retJson", "{'resultCode':-1,'resultMsg':'subscribeMonthCardPay JSONException'}");
                        return bundle;
                    } catch (Exception e19) {
                        e = e19;
                        bundle = bundle2;
                        if (!QLog.isColorLevel()) {
                            String str26 = "subscribeMonthCardPay Exception:" + e.getMessage();
                            str6 = IPayLogic.TAG;
                            QLog.e(str6, 2, str26);
                        } else {
                            str6 = IPayLogic.TAG;
                        }
                        if (QLog.isDevelopLevel()) {
                            QLog.e(str6, 1, "error msg in qqpay-impl module: ", e);
                        }
                        bundle.putInt(str4, -1);
                        bundle.putString("retJson", "{'resultCode':-1,'resultMsg':'subscribeMonthCardPay Exception'}");
                        return bundle;
                    }
                } catch (JSONException e26) {
                    e = e26;
                    str4 = "retCode";
                }
            } catch (JSONException e27) {
                e = e27;
                str4 = "retCode";
                str5 = IPayLogic.TAG;
                bundle = bundle2;
            }
        } catch (Exception e28) {
            e = e28;
            str4 = "retCode";
        }
        return bundle;
    }

    private void tenpayResult(String str, String str2) {
        Bundle bundle = new Bundle();
        bundle.putString("callbackSn", str);
        bundle.putString("result", str2);
        tenpayResult(bundle);
    }

    protected String convertToReportAction(int i3) {
        if (this.isFromPCPush) {
            if (i3 == 4) {
                return "openService-push";
            }
            if (i3 == 6) {
                return "rechargeGameCurrency-push";
            }
            if (i3 == 7) {
                return "buyGoods-push";
            }
            if (i3 == 8) {
                return "rechargeQb-push";
            }
            if (i3 == 9) {
                return "pay-push";
            }
            if (i3 == 14) {
                return "monthCardPay-push";
            }
            if (i3 == 11) {
                return "openSVip-push";
            }
            return null;
        }
        if (i3 == 4) {
            return "openService-nt";
        }
        if (i3 == 6) {
            return "rechargeGameCurrency-nt";
        }
        if (i3 == 7) {
            return "buyGoods-nt";
        }
        if (i3 == 8) {
            return "rechargeQb-nt";
        }
        if (i3 == 9) {
            return "pay-native";
        }
        if (i3 == 14) {
            return "monthCardPay-nt";
        }
        if (i3 == 11) {
            return "openSVip-nt";
        }
        return null;
    }

    @Override // cooperation.qwallet.plugin.IPayLogic
    public void doOnRestoreInstanceState(Bundle bundle) {
        if (QLog.isColorLevel()) {
            QLog.i(IPayLogic.TAG, 2, "doOnRestoreInstanceState savedInstanceState=" + bundle);
        }
        if (bundle == null) {
            return;
        }
        this.mPayType = bundle.getInt("mPayType", -1);
        this.mPayTokenId = bundle.getString("mPayTokenId");
        this.mPayAppId = bundle.getString("mPayAppId");
        this.mPayChannel = bundle.getString("mPayChannel");
        this.mPayBargainorId = bundle.getString("mPayBargainorId");
        this.mMidasOfferid = bundle.getString("mMidasOfferid");
        this.mMidasAid = bundle.getString("mMidasAid");
        this.mMidasOrderId = bundle.getString("mMidasOrderId");
        this.mOpenViewTag = bundle.getString("mOpenViewTag");
    }

    @Override // cooperation.qwallet.plugin.IPayLogic
    public void doOnSaveInstanceState(Bundle bundle) {
        if (QLog.isColorLevel()) {
            QLog.i(IPayLogic.TAG, 2, "doOnSaveInstanceState outState=" + bundle);
        }
        if (bundle == null) {
            return;
        }
        bundle.putInt("mPayType", this.mPayType);
        bundle.putString("mPayTokenId", this.mPayTokenId);
        bundle.putString("mPayAppId", this.mPayAppId);
        bundle.putString("mPayChannel", this.mPayChannel);
        bundle.putString("mPayBargainorId", this.mPayBargainorId);
        bundle.putString("mMidasOfferid", this.mMidasOfferid);
        bundle.putString("mMidasAid", this.mMidasAid);
        bundle.putString("mMidasOrderId", this.mMidasOrderId);
        bundle.putString("mOpenViewTag", this.mOpenViewTag);
    }

    @Override // cooperation.qwallet.plugin.IPayLogic
    public void end() {
        if (QLog.isColorLevel()) {
            QLog.i(IPayLogic.TAG, 2, "end()");
        }
        ((IQWalletPayApi) QRoute.api(IQWalletPayApi.class)).removePayingData();
        int idlePayDataCount = ((IQWalletPayApi) QRoute.api(IQWalletPayApi.class)).getIdlePayDataCount();
        if (QLog.isColorLevel()) {
            QLog.i(IPayLogic.TAG, 2, "finish idlePayCount=" + idlePayDataCount);
        }
        QBaseActivity qBaseActivity = this.mActivity;
        if (idlePayDataCount > 0 && qBaseActivity != null) {
            Intent payBridgeIntent = ((IQWalletApi) QRoute.api(IQWalletApi.class)).getPayBridgeIntent(qBaseActivity);
            payBridgeIntent.addFlags(536870912);
            qBaseActivity.startActivity(payBridgeIntent);
            final Dialog createCustomDialog = createCustomDialog("\u6211\u7684\u94b1\u5305", String.format(qBaseActivity.getString(R.string.g6r), Integer.valueOf(idlePayDataCount)), null);
            createCustomDialog.setCancelable(false);
            View.OnClickListener onClickListener = new View.OnClickListener() { // from class: cooperation.qwallet.plugin.impl.PayLogicImpl.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    EventCollector.getInstance().onViewClickedBefore(view);
                    if (view.getId() == R.id.dialogRightBtn) {
                        PayLogicImpl.this.startPCPushPay(((IQWalletPayApi) QRoute.api(IQWalletPayApi.class)).getIdlePayData(PayLogicImpl.this.isPCPushDesc));
                    } else if (view.getId() == R.id.dialogLeftBtn) {
                        createCustomDialog.dismiss();
                        ((IQWalletPayApi) QRoute.api(IQWalletPayApi.class)).clearAllPayData();
                        PayLogicImpl.this.end();
                    }
                    EventCollector.getInstance().onViewClicked(view);
                }
            };
            createCustomDialog.findViewById(R.id.dialogRightBtn).setOnClickListener(onClickListener);
            createCustomDialog.findViewById(R.id.dialogLeftBtn).setOnClickListener(onClickListener);
            createCustomDialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: cooperation.qwallet.plugin.impl.PayLogicImpl.4
                @Override // android.content.DialogInterface.OnDismissListener
                public void onDismiss(DialogInterface dialogInterface) {
                    if (QLog.isDevelopLevel()) {
                        QLog.d(IPayLogic.TAG, 4, "finish dialog dismiss...");
                    }
                }
            });
            try {
                createCustomDialog.show();
                return;
            } catch (Throwable th5) {
                QLog.e(IPayLogic.TAG, 2, th5.getMessage());
                return;
            }
        }
        tryNonPCPay();
        setIsPaying(false);
        onEndFinished();
    }

    @Override // cooperation.qwallet.plugin.IPayLogic
    public void exec() {
        if (QLog.isColorLevel()) {
            QLog.i(IPayLogic.TAG, 2, "exec()");
        }
        QBaseActivity qBaseActivity = this.mActivity;
        int i3 = this.mRequestCode;
        if (i3 == 12) {
            if (((IQWalletTemp) QRoute.api(IQWalletTemp.class)).getJumpLock(qBaseActivity, this.app.getCurrentAccountUin())) {
                if (QLog.isColorLevel()) {
                    QLog.i(IQWalletHelper.TAG_WALLET_PUSH, 2, "moveTaskToBack and startUnlockActivity...");
                }
                qBaseActivity.startUnlockActivity();
                onEndFinished();
                return;
            }
            if (isPaying) {
                onEndFinished();
                return;
            }
            isPaying = true;
            this.isFromPCPush = true;
            this.isPCPushDesc = true;
            startPCPushPay(((IQWalletPayApi) QRoute.api(IQWalletPayApi.class)).getIdlePayData(this.isPCPushDesc));
            return;
        }
        isPaying = true;
        if (i3 != 200) {
            if (i3 != 201) {
                switch (i3) {
                    case 1:
                        a.C7495a b16 = a.C7495a.b(this.intentData);
                        if (b16 != null && checkEmojiPayParam(b16)) {
                            doEmojimallPay(b16);
                            return;
                        }
                        OnEmojimallPayResult(b16, -1, 0, -1, -1, -1, "param error");
                        if (b16 == null) {
                            if (QLog.isColorLevel()) {
                                QLog.i(IPayLogic.TAG, 2, "emojimall pay paramerror: reqData:null");
                            }
                        } else if (QLog.isColorLevel()) {
                            QLog.i(IPayLogic.TAG, 2, "emojimall pay paramerror:userid:" + b16.f204125c + "userkey:" + b16.f204126d + "sessionid:" + b16.f204127e + "sessionType:" + b16.f204128f + "zoneId:" + b16.f204129g + "pf:" + b16.f204130h + "pfKey:" + b16.f204131i + "tokenUrl:" + b16.f204132j + "discountId:" + b16.f204133k + "other:" + b16.f204134l + "payload:" + b16.f204135m);
                        }
                        isPaying = false;
                        end();
                        return;
                    case 2:
                        doGoldCharge(this.intentData);
                        return;
                    case 3:
                        doOpenQQReaderVip(this.intentData);
                        return;
                    case 4:
                    case 6:
                    case 7:
                    case 8:
                    case 9:
                        break;
                    case 5:
                        openTenpayView(this.intentData);
                        return;
                    case 10:
                        openQzoneVipService(this.intentData);
                        return;
                    case 11:
                        openSVip(this.intentData);
                        return;
                    default:
                        switch (i3) {
                            case 13:
                                Bundle bundle = new Bundle();
                                bundle.putInt(QWalletPayBridge.Key.PAY_INVOKER_ID, 12);
                                putProxyReceiverToBundle(bundle);
                                QWalletPayBridge.launchForeground(qBaseActivity, bundle);
                                return;
                            case 14:
                            case 15:
                                break;
                            default:
                                end();
                                return;
                        }
                }
                newPay(i3, this.intentData);
                return;
            }
            onQWalletCrash();
            return;
        }
        onF2FRedpackCheckError();
    }

    @Override // cooperation.qwallet.plugin.IPayLogic
    public IPayLogic getLogic(int i3) {
        return sPayLogics.get(i3);
    }

    @Override // cooperation.qwallet.plugin.IPayLogic
    public int getTag() {
        return hashCode();
    }

    @Override // cooperation.qwallet.plugin.IPayLogic
    public boolean init(Intent intent, AppRuntime appRuntime, Activity activity) {
        this.intent = intent;
        this.app = (BaseQQAppInterface) appRuntime;
        this.mActivity = (QBaseActivity) activity;
        add(this);
        if (QLog.isColorLevel()) {
            QLog.i(IPayLogic.TAG, 2, "init()");
        }
        if (intent != null && intent.getExtras() != null) {
            Bundle extras = intent.getExtras();
            this.intentData = extras;
            this.mResultReceiver = (ResultReceiver) extras.getParcelable("receiver");
            if (QLog.isColorLevel()) {
                QLog.e(IPayLogic.TAG, 2, "specified receiver = " + this.mResultReceiver);
            }
            this.mRequestCode = this.intentData.getInt("pay_requestcode", -1);
            int i3 = this.intentData.getInt(PayProxy.Source.PAY_TYPE_EXTRA_KEY, -1);
            this.mPayType = i3;
            this.isLockWithdraw = isLockWithdraw(i3, this.intentData);
            if (QLog.isColorLevel()) {
                QLog.e(IPayLogic.TAG, 2, "isLockWithdraw = " + this.isLockWithdraw);
            }
            if (!isLoginParamsValid()) {
                if (QLog.isColorLevel()) {
                    QLog.e(IPayLogic.TAG, 2, "PayBridgeActivity.doOnCreate login params error");
                }
                return false;
            }
            QQNotificationManager.getInstance().cancel(IPayLogic.TAG, 238);
            this.isFromPCPush = this.intentData.getBoolean("payparmas_from_pcpush", false);
            this.mPayH5StartTime = this.intentData.getLong(PayProxy.Source.PAY_H5_START_EXTRA_KEY, 0L);
            return true;
        }
        if (QLog.isColorLevel()) {
            QLog.e(IPayLogic.TAG, 2, "init extras is null");
        }
        return false;
    }

    @Override // cooperation.qwallet.plugin.IPayLogic
    public boolean isPaying() {
        return isPaying;
    }

    protected Bundle nativePay(Activity activity, ResultReceiver resultReceiver, Bundle bundle) {
        Bundle bundle2 = new Bundle();
        try {
            setIPCReceiver(resultReceiver, bundle);
            QWalletPayBridge.launchForeground(activity, bundle);
            if (this.loadingDialog == null) {
                this.loadingDialog = new WalletProgressDialog(activity);
            }
            this.loadingDialog.show();
            bundle2.putInt("retCode", 0);
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.e(IPayLogic.TAG, 2, "nativePay Exception:" + e16.getMessage());
            }
            if (QLog.isDevelopLevel()) {
                QLog.e(IPayLogic.TAG, 1, "error msg in qqpay-impl module: ", e16);
            }
            bundle2.putInt("retCode", -1);
            bundle2.putString("retJson", "{'resultCode':-900,'retmsg':'pay Exception','data':{}}");
        }
        return bundle2;
    }

    @Override // cooperation.qwallet.plugin.IPayLogic
    public void onActivityResult(int i3, int i16, Intent intent) {
        Integer num;
        Integer num2 = null;
        if (QLog.isColorLevel()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("PayBridgeActivity@");
            QBaseActivity qBaseActivity = this.mActivity;
            if (qBaseActivity != null) {
                num = Integer.valueOf(qBaseActivity.hashCode());
            } else {
                num = null;
            }
            sb5.append(num);
            sb5.append(" onActivityResult requestCode=");
            sb5.append(i3);
            sb5.append(",resultCode=");
            sb5.append(i16);
            QLog.d(IPayLogic.TAG, 1, sb5.toString());
        }
        if (this.mActivity == null) {
            this.mOnActivityResult = new OnActivityResult(i3, i16, intent);
            return;
        }
        int i17 = -1;
        if ((intent != null && i3 == 3001) || i16 == -1) {
            if (intent != null) {
                i17 = intent.getIntExtra(QWalletPayBridge.Key.PAY_INVOKER_ID, -1);
            }
            if (QLog.isColorLevel()) {
                StringBuilder sb6 = new StringBuilder();
                sb6.append("PayBridgeActivity@");
                QBaseActivity qBaseActivity2 = this.mActivity;
                if (qBaseActivity2 != null) {
                    num2 = Integer.valueOf(qBaseActivity2.hashCode());
                }
                sb6.append(num2);
                sb6.append(" nInvokerId = ");
                sb6.append(i17);
                QLog.i(IPayLogic.TAG, 2, sb6.toString());
            }
            if (i17 != 14 && i17 != 17) {
                if (i17 != 25) {
                    switch (i17) {
                        case 1:
                            onEmojimallPayResult(intent);
                            return;
                        case 2:
                            onGoldChargeResult(intent);
                            return;
                        case 3:
                            onOpenQQReaderVipResult(intent);
                            return;
                        case 4:
                        case 6:
                        case 7:
                        case 8:
                        case 11:
                            break;
                        case 5:
                            onOpenTenpayViewResult(intent);
                            return;
                        case 9:
                            onPayResult(intent);
                            return;
                        case 10:
                            onOpenQzoneVipResult(intent);
                            return;
                        case 12:
                            onCheckWebankResult(intent);
                            return;
                        default:
                            if (QLog.isColorLevel()) {
                                QLog.e(IPayLogic.TAG, 2, "QvipPayBridge Unknown InvokerId : " + i17);
                            }
                            end();
                            return;
                    }
                } else {
                    onNativePayResult(intent);
                    return;
                }
            }
            onMidasPayResult(intent);
            return;
        }
        if (i3 == 5 && intent == null) {
            Intent intent2 = new Intent();
            intent2.putExtra(QWalletPayBridge.PayResult.PAY_RESULT_EXTRA_KEY, 2);
            onOpenTenpayViewResult(intent2);
        } else {
            if (QLog.isColorLevel()) {
                QLog.e(IPayLogic.TAG, 2, "QvipPayBridge Unknown data");
            }
            end();
        }
    }

    @Override // cooperation.qwallet.plugin.IPayLogic
    @Deprecated
    public void onDestroy() {
        setIsPaying(false);
        this.mActivity = null;
    }

    @Override // cooperation.qwallet.plugin.IPayLogic
    public void onEndFinished() {
        this.mActivity.finish();
        remove(this);
    }

    public void startPCPushPay(IQWalletPayApi.a aVar) {
        if (aVar == null) {
            end();
            return;
        }
        aVar.f277010h = 1;
        Bundle bundle = new Bundle();
        bundle.putString(ark.ARKMETADATA_JSON, aVar.f277006d);
        bundle.putString("callbackSn", "0");
        int payBridgeCode = ((IQWalletPayApi) QRoute.api(IQWalletPayApi.class)).getPayBridgeCode(aVar.f277005c);
        if (payBridgeCode != 11) {
            if (payBridgeCode != 14) {
                switch (payBridgeCode) {
                    case 4:
                    case 6:
                    case 7:
                    case 8:
                    case 9:
                        break;
                    case 5:
                        Bundle extras = this.intent.getExtras();
                        extras.putString(ark.ARKMETADATA_JSON, aVar.f277006d);
                        extras.putString("callbackSn", "0");
                        openTenpayView(extras);
                        return;
                    default:
                        end();
                        return;
                }
            }
            newPay(payBridgeCode, bundle);
            return;
        }
        openSVip(bundle);
    }

    @Override // cooperation.qwallet.plugin.IPayLogic
    public boolean tryDoOnActivityResult(Activity activity) {
        if (activity != null && this.mOnActivityResult != null) {
            setActivityRef((QBaseActivity) activity);
            OnActivityResult onActivityResult = this.mOnActivityResult;
            onActivityResult(onActivityResult.requestCode, onActivityResult.resultCode, onActivityResult.data);
            return true;
        }
        return false;
    }

    public void tryNonPCPay() {
        Intent intent;
        if (!this.isFromPCPush && (intent = this.saveResultData) != null) {
            this.mActivity.setResult(this.saveResultCode, intent);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x001f, code lost:
    
        if (r4.has("banned_user_buff") != false) goto L15;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean isLockWithdraw(int i3, JSONObject jSONObject) {
        boolean z16 = true;
        if (1 == i3 && jSONObject != null) {
            try {
                if (jSONObject.has("pskey") || jSONObject.has("p_skey_forbid")) {
                }
            } catch (Exception e16) {
                QLog.e(IPayLogic.TAG, 1, "error msg in qqpay-impl module: ", e16);
                return false;
            }
        }
        z16 = false;
        return z16;
    }

    private void tenpayResult(Bundle bundle) {
        String str;
        String str2;
        if (bundle != null) {
            str = bundle.getString("callbackSn");
            str2 = bundle.getString("result");
        } else {
            bundle = new Bundle();
            str = null;
            str2 = null;
        }
        if (QLog.isColorLevel()) {
            QLog.i(IPayLogic.TAG, 2, "get callbackSn = " + str);
        }
        if (this.intentData != null) {
            if (TextUtils.isEmpty(str)) {
                str = this.intentData.getString("callbackSn");
            }
            bundle.putString("callbackSn", str);
        }
        if (this.mResultReceiver != null) {
            f.b(IPayLogic.TAG, "receiver back : " + bundle);
            this.mResultReceiver.send(0, bundle);
        }
        Intent intent = new Intent();
        intent.putExtra("result", str2);
        intent.putExtra("callbackSn", str);
        if (QLog.isColorLevel()) {
            QLog.i(IPayLogic.TAG, 2, "PayBridgeActivity tenpayResult:callbackSn=" + str + ",result=" + str2);
        }
        this.mActivity.setResult(-1, intent);
        saveNonePCPayResultData(-1, intent);
        end();
    }

    private void onGoldChargeResult(int i3, String str, int i16, int i17, int i18, int i19, String str2) {
        Intent intent = new Intent();
        Bundle bundle = new Bundle();
        bundle.putInt("result", i3);
        bundle.putString("retInnerCode", str);
        bundle.putInt("realSaveNum", i16);
        bundle.putInt("payChannel", i17);
        bundle.putInt("payState", i18);
        bundle.putInt("provideState", i19);
        bundle.putString("message", str2);
        intent.putExtras(bundle);
        this.mActivity.setResult(i3, intent);
        saveNonePCPayResultData(i3, intent);
        end();
    }

    @Override // cooperation.qwallet.plugin.IPayLogic
    public Bundle newPay(AppRuntime appRuntime, Activity activity, ResultReceiver resultReceiver, int i3, Bundle bundle) {
        String str;
        long j3;
        String str2;
        String str3;
        String str4;
        int i16;
        boolean z16;
        Bundle launchWeChat;
        Bundle bundle2 = new Bundle();
        boolean z17 = (appRuntime == null || activity == null) ? false : true;
        if (bundle != null) {
            str = bundle.getString(PayProxy.Source.PAY_CALLBACK_SN_EXTRA_KEY);
            String string = bundle.getString(PayProxy.Source.PAY_JSON_EXTRA_KEY);
            i16 = bundle.getInt(PayProxy.Source.PAY_TYPE_EXTRA_KEY, -1);
            long j16 = bundle.getLong(PayProxy.Source.PAY_H5_START_EXTRA_KEY, 0L);
            String string2 = bundle.getString(PayProxy.Source.PAY_URL_APPINFO_EXTRA_KEY);
            String string3 = bundle.getString("payparmas_h5_url");
            if (i16 == -1 || TextUtils.isEmpty(string)) {
                z17 = false;
            }
            if (i3 == 6 || i3 == 7 || i3 == 8 || i3 == 4 || i3 == 9 || i3 == 24 || i3 == 25 || i3 == 14 || i3 == 17) {
                str4 = string3;
                z16 = z17;
            } else {
                str4 = string3;
                z16 = false;
            }
            str3 = string;
            str2 = string2;
            j3 = j16;
        } else {
            str = "";
            j3 = 0;
            str2 = "";
            str3 = null;
            str4 = null;
            i16 = -1;
            z16 = false;
        }
        if (QLog.isColorLevel()) {
            QLog.i(IPayLogic.TAG, 2, "from static method invokerId:" + i3 + " request=" + str3 + ",callbackSn=" + str);
        }
        if (!z16) {
            bundle2.putInt("retCode", -1);
            bundle2.putString("retJson", "{'resultCode':-1,'resultMsg':'System error.'}");
            return bundle2;
        }
        if (i3 == 6) {
            launchWeChat = rechargeGameCurrency(appRuntime, activity, resultReceiver, str, str3, i16, j3, str4);
        } else if (i3 == 7) {
            launchWeChat = buyGoods(appRuntime, activity, resultReceiver, str, str3, i16, j3, str4);
        } else if (i3 == 8) {
            launchWeChat = rechargeQb(appRuntime, activity, resultReceiver, str, str3, i16, j3, str4);
        } else if (i3 == 4) {
            launchWeChat = openService(appRuntime, activity, resultReceiver, str, str3, i16, j3, str4);
        } else {
            if (i3 == 9 || i3 == 24) {
                return pay(appRuntime, activity, resultReceiver, str, str3, str2, i16, j3, str4);
            }
            if (i3 == 14) {
                launchWeChat = subscribeMonthCardPay(appRuntime, activity, resultReceiver, str, str3, i16, j3, str4);
            } else {
                if (i3 != 17) {
                    return i3 == 25 ? nativePay(activity, resultReceiver, bundle) : bundle2;
                }
                launchWeChat = launchWeChat(activity, resultReceiver, str, str3, i16, j3, str4);
            }
        }
        return launchWeChat;
    }
}
