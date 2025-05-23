package com.tenpay.impl;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.ResultReceiver;
import android.text.TextUtils;
import com.qwallet.temp.IQWalletTemp;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.msf.core.c0.j;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qzonehub.api.webview.IQzoneWebViewPluginHelper;
import com.tenpay.QwLog;
import com.tenpay.api.IApiInterface;
import com.tenpay.sdk.Cgi;
import com.tenpay.sdk.SDKCallbackManager;
import com.tenpay.sdk.activity.ConfirmTransactionActivity;
import com.tenpay.sdk.activity.PayActivity;
import com.tenpay.sdk.apilogic.ApiGotoview;
import com.tenpay.sdk.apilogic.ApiMidasNetListener;
import com.tenpay.sdk.apilogic.ApiNetListener;
import com.tenpay.sdk.apilogic.ApiRequestDataProcess;
import com.tenpay.sdk.apilogic.ApiUtil;
import com.tenpay.sdk.apilogic.PreGetQrcode;
import com.tenpay.sdk.basebl.TenpayBL;
import com.tenpay.sdk.basebl.UserInfo;
import com.tenpay.sdk.helper.PayHelper;
import com.tenpay.sdk.net.NetUtil;
import com.tenpay.sdk.net.core.actions.DomainSettingAction;
import com.tenpay.sdk.net.core.comm.BannedUserInfo;
import com.tenpay.sdk.net.core.comm.SpecialKeyInfo;
import com.tenpay.sdk.util.TenUtils;
import com.tenpay.util.Utils;
import cooperation.qwallet.plugin.IQWalletHelper;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.java_websocket.WebSocketImpl;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes27.dex */
public class ApiInterfaceImpl implements IApiInterface {
    private static final String TAG = "ApiInterfaceImpl";

    private JSONObject getEjson(Bundle bundle) {
        JSONObject jSONObject = new JSONObject();
        if (bundle != null && bundle.getString("extra_data") != null) {
            try {
                String string = bundle.getString("extra_data");
                if (!Utils.isEmpty(string)) {
                    return new JSONObject(string);
                }
                return jSONObject;
            } catch (Exception e16) {
                QLog.e(TAG, 1, "", e16);
                return jSONObject;
            }
        }
        return jSONObject;
    }

    private void initCacheData(String str) {
        QwLog.i("setCache extra_data = " + str);
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            BannedUserInfo.saveInfoIfNeed(new JSONObject(str));
        } catch (Exception e16) {
            QLog.e(TAG, 1, "", e16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$preNetLink$0(JSONObject jSONObject) {
        try {
            InetAddress.getByName(Cgi.DOMAIN_YUN_SERVER);
            new InetSocketAddress(Cgi.DOMAIN_YUN_SERVER, WebSocketImpl.DEFAULT_WSS_PORT).getAddress();
        } catch (Exception e16) {
            QLog.e(TAG, 1, "", e16);
        }
        try {
            InetAddress.getByName("mqq.tenpay.com");
            new InetSocketAddress("mqq.tenpay.com", WebSocketImpl.DEFAULT_WSS_PORT).getAddress();
        } catch (Exception e17) {
            QLog.e(TAG, 1, "", e17);
        }
        QwLog.i("preNetLink() callPullConfigCgi json = " + jSONObject);
    }

    @Override // com.tenpay.api.IApiInterface
    public void closeTenpay(Context context) {
        TenUtils.notifyToExit(context, 1L);
    }

    @Override // com.tenpay.api.IApiInterface
    public void freshQrcode(Context context, Map<String, String> map, boolean z16, ResultReceiver resultReceiver) {
        QwLog.i("pre get qrcode");
        PreGetQrcode preGetQrcode = new PreGetQrcode(context);
        if (preGetQrcode.initInfo(map.get("uin"), z16)) {
            preGetQrcode.preCodeStart(map, resultReceiver);
        }
    }

    @Override // com.tenpay.api.IApiInterface
    public void getTenpayInfo(Context context, String str, ResultReceiver resultReceiver) {
        ApiUtil.enterSDK(str);
        if (context == null) {
            if (resultReceiver != null) {
                resultReceiver.send(-101, PayHelper.createResultForError("getTenpayInfo fail! context is null"));
                return;
            }
            return;
        }
        HashMap hashMap = new HashMap();
        try {
            hashMap.put("uin", str);
        } catch (Exception e16) {
            QwLog.e("getTenpayInfo catch:" + e16.toString());
        }
        TenpayBL tenpayBL = new TenpayBL();
        tenpayBL.setNetListener(new ApiMidasNetListener(context, resultReceiver, new UserInfo(str, null)));
        tenpayBL.doTask(context, Cgi.URI_WALLET_MIDAS, hashMap, "", "0", str, true);
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0222 A[Catch: all -> 0x00f8, TryCatch #0 {all -> 0x00f8, blocks: (B:49:0x00f1, B:9:0x00fb, B:12:0x016f, B:14:0x018f, B:15:0x01ec, B:21:0x021c, B:23:0x0222, B:24:0x0227, B:37:0x0196, B:40:0x01aa, B:43:0x01b2, B:46:0x01c6, B:47:0x01cb), top: B:48:0x00f1 }] */
    @Override // com.tenpay.api.IApiInterface
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void gotoPay(Context context, Bundle bundle, ResultReceiver resultReceiver) {
        ResultReceiver resultReceiver2;
        int i3;
        Class cls;
        String string = bundle.getString("uin");
        ApiUtil.enterSDK(string);
        SpecialKeyInfo.saveInfoIfNeed(bundle);
        QwLog.i("gotoPay..." + bundle);
        String string2 = bundle.getString("token_id");
        String string3 = bundle.getString(IQzoneWebViewPluginHelper.EXTRA_FAMOUS_SHARE_NICKNAME);
        int i16 = bundle.getInt("come_from");
        String correctAppInfo = ((IQWalletHelper) QRoute.api(IQWalletHelper.class)).getCorrectAppInfo(bundle.getString(j.T0), ((IQWalletTemp) QRoute.api(IQWalletTemp.class)).getAppInfoFromHistory());
        String string4 = bundle.getString("subscribe_info");
        if (!TextUtils.isEmpty(string2) && !TextUtils.isEmpty(string)) {
            try {
                String string5 = bundle.getString("extra_data");
                QwLog.i("gotoPay extra_data=" + string5);
                boolean z16 = bundle.getBoolean(ApiGotoview.CALLBACK_WHEN_CANCEL_PAY, false);
                initCacheData(string5);
                Intent intent = new Intent();
                intent.putExtra("token_id", string2);
                intent.putExtra("uin", string);
                intent.putExtra(IQzoneWebViewPluginHelper.EXTRA_FAMOUS_SHARE_NICKNAME, string3);
                intent.putExtra("come_from", i16);
                intent.putExtra(j.T0, correctAppInfo);
                intent.putExtra("subscribe_info", string4);
                intent.putExtra("extra_data", string5);
                resultReceiver2 = resultReceiver;
                i3 = -101;
                if (resultReceiver2 != null) {
                    try {
                        intent.putExtra(SDKCallbackManager.SESSION_RECEIVER, resultReceiver2);
                    } catch (Throwable th5) {
                        th = th5;
                        QwLog.e(th.getMessage());
                        if (resultReceiver2 != null) {
                            resultReceiver2.send(i3, PayHelper.createResultForError(th.getMessage()));
                            return;
                        }
                        return;
                    }
                }
                intent.putExtra("back_button_text", bundle.getString("back_button_text"));
                intent.putExtra("sdk_channel", bundle.getInt("sdk_channel") + "");
                intent.putExtra("sdk_data", bundle.getString("sdk_data"));
                intent.putExtra("iPayFrom", bundle.getInt("iPayFrom", -1));
                intent.putExtra("subscribe_default_option", bundle.getInt("subscribe_default_option", 1));
                intent.putExtra("h5_success", bundle.getBoolean("h5_success", false));
                intent.putExtra("isOpenWebank", bundle.getBoolean("isOpenWebank", false));
                intent.putExtra(ApiGotoview.CALLBACK_WHEN_CANCEL_PAY, z16);
                boolean z17 = bundle.getBoolean("is_midas");
                QwLog.i("is_midas" + z17);
                if (z17) {
                    intent.putExtra("is_midas", true);
                    int i17 = bundle.getInt("midas_paytype");
                    QwLog.i("is_midas" + i17);
                    intent.putExtra("midas_paytype", i17);
                    if (i17 == 0) {
                        intent.putExtra("pay_by", 0);
                    } else if (i17 == 1) {
                        intent.putExtra("pay_by", 1);
                        intent.putExtra("bind_serial", bundle.getString("bank_id"));
                    } else if (i17 == 2) {
                        intent.putExtra("pay_by", 0);
                    } else if (i17 == 3) {
                        intent.putExtra("pay_by", 1);
                        intent.putExtra("bind_serial", bundle.getString("bank_id"));
                    } else if (i17 == 4) {
                        intent.putExtra("pay_by", 2);
                    }
                } else {
                    intent.putExtra("pay_by", bundle.getInt("pay_by", -1));
                    intent.putExtra("bank_index", bundle.getInt("bank_index", -1));
                    intent.putExtra("bank_type", bundle.getString("bank_type"));
                }
                intent.putExtra("appid", bundle.getString("appid"));
                intent.putExtra("guid", bundle.getByteArray("guid"));
                intent.putExtra("prossesId", System.currentTimeMillis());
                if (i16 != 4 && i16 != 3) {
                    cls = PayActivity.class;
                    if (context instanceof Service) {
                        intent.addFlags(268435456);
                    }
                    com.tencent.mobileqq.base.c.d(context, intent, cls);
                }
                cls = ConfirmTransactionActivity.class;
                if (context instanceof Service) {
                }
                com.tencent.mobileqq.base.c.d(context, intent, cls);
            } catch (Throwable th6) {
                th = th6;
                resultReceiver2 = resultReceiver;
                i3 = -101;
            }
        } else if (resultReceiver != null) {
            resultReceiver.send(-101, PayHelper.createResultForError("params error, token_id is " + string2 + " | uin is " + string));
        }
    }

    @Override // com.tenpay.api.IApiInterface
    public void gotoView(Context context, String str, String str2, String str3, Bundle bundle, ResultReceiver resultReceiver) {
        gotoView(context, str, str2, str3, bundle, resultReceiver, null);
    }

    @Override // com.tenpay.api.IApiInterface
    public void preConnect(Context context, String str) {
        ApiUtil.enterSDK(str);
        QwLog.i("preConnect is in");
        NetUtil.preConnect(context, Cgi.URL_MQQ_PRECONNECT);
        NetUtil.preConnect(context, Cgi.URL_MYUN_PRECONNECT);
    }

    @Override // com.tenpay.api.IApiInterface
    public void preNetLink(Context context, final JSONObject jSONObject, ResultReceiver resultReceiver) {
        QwLog.i("in preNetLink json = " + jSONObject);
        ThreadManagerV2.excute(new Runnable() { // from class: com.tenpay.impl.c
            @Override // java.lang.Runnable
            public final void run() {
                ApiInterfaceImpl.lambda$preNetLink$0(JSONObject.this);
            }
        }, 128, null, false);
    }

    @Override // com.tenpay.api.IApiInterface
    public void pregetQrcode(Context context, Map<String, String> map, ResultReceiver resultReceiver) {
        QwLog.i("pre get qrcode");
        freshQrcode(context, map, false, resultReceiver);
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0052, code lost:
    
        r9.send(-101, com.tenpay.sdk.helper.PayHelper.createResultForError("requestData fail! context is " + r5 + " | tag is " + r6 + " | uin is " + r7));
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:?, code lost:
    
        return;
     */
    @Override // com.tenpay.api.IApiInterface
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void requestData(Context context, String str, String str2, Map<String, String> map, ResultReceiver resultReceiver) {
        SharedPreferences sharedPreferences;
        ApiUtil.enterSDK(str2);
        QwLog.i("requestData...");
        if (map != null) {
            try {
                initCacheData(map.get("extra_data"));
            } catch (Throwable th5) {
                QwLog.e(th5.getMessage());
                if (resultReceiver != null) {
                    resultReceiver.send(-101, PayHelper.createResultForError(th5.getMessage()));
                    return;
                }
                return;
            }
        }
        if (context != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            if (TextUtils.isEmpty(Cgi.wallet_domain) && (sharedPreferences = context.getSharedPreferences("qb_tenpay_addr", 0)) != null) {
                Cgi.wallet_domain = sharedPreferences.getString(DomainSettingAction.SP_KEY_WALLET_DOMAIN, null);
            }
            new ApiRequestDataProcess(context, str2, map, resultReceiver).requestData(str);
        }
    }

    public void sendFriendPayRequest(Context context, String str, String str2, List<String> list, String str3, ResultReceiver resultReceiver) {
        String str4;
        String str5;
        if (resultReceiver != null && list != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("token_id", str);
            hashMap.put("message", str3);
            try {
                Iterator<String> it = list.iterator();
                str4 = "";
                while (it.hasNext()) {
                    try {
                        str4 = str4 + it.next() + "|";
                    } catch (Exception e16) {
                        e = e16;
                        QLog.e(TAG, 1, "", e);
                        QwLog.i(list.toString());
                        str5 = str4;
                        hashMap.put("payer_uin_list", str5);
                        hashMap.put("uin", str2);
                        TenpayBL tenpayBL = new TenpayBL();
                        tenpayBL.setNetListener(new ApiNetListener(context, resultReceiver, new UserInfo(str2, null), false, false));
                        tenpayBL.doTask(context, Cgi.URL_FRIENDPAY_VERIFY, hashMap, str, "0", str2, true);
                    }
                }
                str5 = str4.substring(0, str4.length() - 1);
            } catch (Exception e17) {
                e = e17;
                str4 = "";
            }
            hashMap.put("payer_uin_list", str5);
            hashMap.put("uin", str2);
            TenpayBL tenpayBL2 = new TenpayBL();
            tenpayBL2.setNetListener(new ApiNetListener(context, resultReceiver, new UserInfo(str2, null), false, false));
            tenpayBL2.doTask(context, Cgi.URL_FRIENDPAY_VERIFY, hashMap, str, "0", str2, true);
        }
    }

    @Override // com.tenpay.api.IApiInterface
    public void gotoView(Context context, String str, String str2, String str3, Bundle bundle, ResultReceiver resultReceiver, Service service) {
        if (context != null && !TextUtils.isEmpty(str) && bundle != null) {
            ApiUtil.enterSDK(str2);
            try {
                JSONObject ejson = getEjson(bundle);
                try {
                    BannedUserInfo.saveInfoIfNeed(ejson);
                } catch (Exception e16) {
                    QLog.e(TAG, 1, "gotoView: ", e16);
                }
                ApiGotoview apiGotoview = new ApiGotoview(context, str2, str3, bundle, resultReceiver, ejson, service);
                if (service != null) {
                    apiGotoview.gotoSilenceView(str);
                } else {
                    apiGotoview.gotoView(str);
                }
                QwLog.i("gotoView tag = " + str + " ejson = " + ejson);
                return;
            } catch (Throwable th5) {
                QwLog.e(th5.getMessage());
                if (resultReceiver != null) {
                    resultReceiver.send(-101, PayHelper.createResultForError(th5.getMessage()));
                    return;
                }
                return;
            }
        }
        if (resultReceiver != null) {
            resultReceiver.send(-101, PayHelper.createResultForError("gotoView fail! context is " + context + " | params is " + bundle + " | uin is " + str2));
        }
        QwLog.i("parameter error...");
    }

    @Override // com.tenpay.api.IApiBase
    public void init(Context context) {
    }
}
