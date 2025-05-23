package com.tencent.mobileqq.vaswebviewplugin;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import android.view.KeyEvent;
import com.tencent.ads.data.AdParam;
import com.tencent.common.app.AppInterface;
import com.tencent.component.network.downloader.impl.ipc.Const;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.activity.PayBridgeActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.emosm.api.IWebIPCOperatorApi;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.mini.out.nativePlugins.TenpayPlugin;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.ShortVideoConstants;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialogThreeBtns;
import com.tencent.mobileqq.vas.api.VasSkey;
import com.tencent.mobileqq.vas.report.VasCommonReporter;
import com.tencent.mobileqq.vas.theme.ThemeReporter;
import com.tencent.mobileqq.vas.webview.util.VasWebviewUtil;
import com.tencent.mobileqq.vip.api.IVipPayApi;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webviewplugin.s;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Vector;
import mqq.manager.TicketManager;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes20.dex */
public class EmojiJsPlugin extends VasWebviewJsPlugin {
    public static final String BUSINESS_NAME = "emoji";
    public static String KEY_CALLABCKID = "callbackid";
    public static String KEY_DEMOJI_MAKE_ID = "qFace_material_id";
    public static String KEY_DEMOJI_MAKE_RESULT = "makeresultcode";
    public static final String KEY_EMOJIMALL_CLOSE_BACK = "back_from_emojimall";
    public static final String KEY_EMOJIMALL_DETAIL_ID = "emojimall_detail_id";
    public static final String KEY_EMOJIMALL_QFACE = "emojimall_qFace";
    public static final String KEY_EMOJIMALL_SID = "emojimall_sid";
    public static final String KEY_EMOJIMALL_SRC_FROM = "emojimall_src";
    protected static final String KEY_MALL_NEW_TIMESTAMP = "emomall_new_time";
    protected static final String KEY_PAGE_OPEN_TIME = "openpagetime";
    public static final String OBJECT_NAME = "_qqJSBridge_";
    public static final int REQUEST_CODE_QFACE = 201;
    public static final int RESULT_QFACE_LOSSY = 102;
    public static final int RESULT_QFACE_PATH_ERROR = 101;
    public static String TAG = "EmojiJsPlugin";
    protected String mSelfUin;
    private MakeDynamicEmojiInfo makeInfo;
    QQProgressDialog progressDialog;
    private Vector<Pair<Integer, String>> mDownloadingFunctions = new Vector<>();
    protected int mSrcFromType = 1;
    protected int mEmomallNewTimeFlag = -1;

    /* loaded from: classes20.dex */
    public static class JSONWrapper {
        JSONObject json;

        public JSONWrapper(JSONObject jSONObject) {
            this.json = jSONObject;
        }

        public boolean getBoolean(String str, boolean z16) {
            JSONObject jSONObject = this.json;
            if (jSONObject != null && !jSONObject.isNull(str)) {
                try {
                    return this.json.getBoolean(str);
                } catch (JSONException e16) {
                    e16.printStackTrace();
                }
            }
            return z16;
        }

        public int getInt(String str, int i3) {
            JSONObject jSONObject = this.json;
            if (jSONObject != null && !jSONObject.isNull(str)) {
                try {
                    return this.json.getInt(str);
                } catch (JSONException e16) {
                    e16.printStackTrace();
                }
            }
            return i3;
        }

        public String getString(String str) {
            JSONObject jSONObject = this.json;
            if (jSONObject != null && !jSONObject.isNull(str)) {
                try {
                    return this.json.getString(str);
                } catch (JSONException e16) {
                    e16.printStackTrace();
                    return null;
                }
            }
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes20.dex */
    public class MakeDynamicEmojiInfo {
        String callbackid;
        int emoPackId;

        public MakeDynamicEmojiInfo(String str, int i3) {
            this.callbackid = str;
            this.emoPackId = i3;
        }
    }

    private void buyEmoji(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11) {
        AppInterface b16 = this.mRuntime.b();
        if (b16 != null) {
            showProgressDialog();
            TicketManager ticketManager = (TicketManager) b16.getManager(2);
            String account = b16.getAccount();
            if (ticketManager != null && account != null) {
                String skey = VasSkey.getSkey(ticketManager, account);
                dismissProgressDialog();
                if (!TextUtils.isEmpty(skey)) {
                    if (!NetworkUtil.isNetSupport(this.mRuntime.a().getApplicationContext())) {
                        onPayResultCallback("net unsupport", 4, 0, -1, -1, -1, str);
                        return;
                    } else {
                        PayBridgeActivity.startEmojimallPay(this.mRuntime.a(), str, str2, str3, skey, str9, str7, str8, str10, str11);
                        return;
                    }
                }
                onPayResultCallback("skey null", 8, 0, -1, -1, -1, str);
                return;
            }
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.e(TAG, 2, "buyEmoji, AppInterface null.");
        }
    }

    private void buyGoods(String str, String str2) {
        PayBridgeActivity.tenpay(this.mRuntime.a(), str2, 7, str);
    }

    private void clearDownloadingObservers() {
        synchronized (this.mDownloadingFunctions) {
            this.mDownloadingFunctions.clear();
            if (QLog.isColorLevel()) {
                QLog.i(TAG, 2, "clearDownloadingObservers clear all:");
            }
        }
    }

    private void closePage(int i3) {
        if (this.mRuntime.a() != null) {
            this.mRuntime.a().finish();
        }
    }

    private void collectEmoji(JSONWrapper jSONWrapper, String str) {
        Emoticon emoticon = new Emoticon();
        emoticon.epId = jSONWrapper.getString("pkgId");
        emoticon.eId = jSONWrapper.getString("itemId");
        Bundle bundle = new Bundle();
        bundle.putSerializable("emoticon", emoticon);
        ((IWebIPCOperatorApi) QRoute.api(IWebIPCOperatorApi.class)).sendServiceIpcReq(com.tencent.mobileqq.emosm.a.a("collectEmoji", str, this.mOnRemoteResp.key, bundle));
    }

    private void dismissProgressDialog() {
        WebViewPlugin.b bVar = this.mRuntime;
        if (bVar != null && bVar.a() != null) {
            this.mRuntime.a().runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.vaswebviewplugin.EmojiJsPlugin.9
                @Override // java.lang.Runnable
                public void run() {
                    QQProgressDialog qQProgressDialog = EmojiJsPlugin.this.progressDialog;
                    if (qQProgressDialog != null) {
                        qQProgressDialog.cancel();
                        EmojiJsPlugin.this.progressDialog = null;
                    }
                }
            });
        }
    }

    private void emojiStickerAddFavorites(String str, String str2) {
        if (!TextUtils.isEmpty(str)) {
            Bundle bundle = new Bundle();
            bundle.putString("messageSeq", str);
            ((IWebIPCOperatorApi) QRoute.api(IWebIPCOperatorApi.class)).sendServiceIpcReq(com.tencent.mobileqq.emosm.a.a("emojiStickerAddFavorites", str2, this.mOnRemoteResp.key, bundle));
            showProgressDialog();
        }
    }

    private void emojiStickerRecall(String str, String str2) {
        if (!TextUtils.isEmpty(str)) {
            Bundle bundle = new Bundle();
            bundle.putString("messageSeq", str);
            bundle.putString("recallCallbackId", str2);
            bundle.putInt("reCallKey", this.mOnRemoteResp.key);
            ((IWebIPCOperatorApi) QRoute.api(IWebIPCOperatorApi.class)).sendServiceIpcReq(com.tencent.mobileqq.emosm.a.a("emojiStickerRecall", str2, this.mOnRemoteResp.key, bundle));
            showProgressDialog();
        }
    }

    private void getCollectEmojiStatus(JSONWrapper jSONWrapper, String str) {
        Emoticon emoticon = new Emoticon();
        emoticon.epId = jSONWrapper.getString("pkgId");
        emoticon.eId = jSONWrapper.getString("itemId");
        Bundle bundle = new Bundle();
        bundle.putSerializable("emoticon", emoticon);
        ((IWebIPCOperatorApi) QRoute.api(IWebIPCOperatorApi.class)).sendServiceIpcReq(com.tencent.mobileqq.emosm.a.a("getCollectEmojiStatus", str, this.mOnRemoteResp.key, bundle));
    }

    private void getNetwork(String str) {
        int systemNetwork = NetworkUtil.getSystemNetwork(this.mRuntime.a().getApplicationContext());
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("result", 0);
            jSONObject.put("message", "");
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("status", systemNetwork);
            jSONObject.put("data", jSONObject2);
            onAppResponse(str, jSONObject.toString());
        } catch (JSONException e16) {
            e16.printStackTrace();
        }
    }

    private void getSessionKey(String str, String str2) {
        int i3;
        String str3;
        AppInterface b16 = this.mRuntime.b();
        if (b16 != null) {
            showProgressDialog();
            TicketManager ticketManager = (TicketManager) b16.getManager(2);
            String account = b16.getAccount();
            if (ticketManager != null && account != null && !"sid".equals(str) && "skey".equals(str)) {
                String skey = VasSkey.getSkey(ticketManager, account);
                dismissProgressDialog();
                if (TextUtils.isEmpty(skey)) {
                    i3 = -1;
                    str3 = "getsession skey error";
                } else {
                    i3 = 0;
                    str3 = "getsession skey ok";
                }
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("result", i3);
                    jSONObject.put("message", str3);
                    jSONObject.put("data", skey);
                    onAppResponse(str2, jSONObject.toString());
                    return;
                } catch (JSONException e16) {
                    if (QLog.isColorLevel()) {
                        QLog.e(TAG, 2, "getSessionKey, skey, onAppResponse exception: " + e16.getMessage());
                        return;
                    }
                    return;
                }
            }
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.e(TAG, 2, "getSessionKey, AppInterface null.");
        }
    }

    private void makeToast(String str) {
        QQToast.makeText(this.mRuntime.a(), str, 0).show(this.mRuntime.a().getResources().getDimensionPixelSize(R.dimen.title_bar_height));
    }

    private void onPayResultCallback(String str, int i3, int i16, int i17, int i18, int i19, String str2) {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject.put("result", i3);
            jSONObject.put("message", str);
            jSONObject2.put("realSaveNum", i16);
            jSONObject2.put("payChannel", i17);
            jSONObject2.put("payState", i18);
            jSONObject2.put("provideState", i19);
            jSONObject.put("data", jSONObject2);
            if (QLog.isColorLevel()) {
                QLog.i(TAG, 2, "queryEmojiInfo resp to js:" + jSONObject.toString());
            }
            onAppResponse(str2, jSONObject.toString());
        } catch (JSONException e16) {
            e16.printStackTrace();
        }
    }

    private void openPage(String str, String str2, String str3, boolean z16) {
        if (z16) {
            if (!TextUtils.isEmpty(str2)) {
                AppInterface b16 = this.mRuntime.b();
                if (b16 != null) {
                    showProgressDialog();
                    TicketManager ticketManager = (TicketManager) b16.getManager(2);
                    String account = b16.getAccount();
                    if (ticketManager != null && account != null) {
                        dismissProgressDialog();
                        if (!TextUtils.isEmpty(VasSkey.getSkey(ticketManager, account))) {
                            openSubPage(str2, str3);
                            return;
                        } else {
                            if (QLog.isColorLevel()) {
                                QLog.w(TAG, 2, "Open page failed, skey null");
                                return;
                            }
                            return;
                        }
                    }
                    if (QLog.isColorLevel()) {
                        QLog.w(TAG, 2, "Open page failed, ticketmanager or uin null");
                        return;
                    }
                    return;
                }
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.w(TAG, 2, "Open page failed, pageUrl null");
                return;
            }
            return;
        }
        openSubPage(str2, str3);
    }

    private void openService(String str, String str2) {
        PayBridgeActivity.tenpay(this.mRuntime.a(), str2, 4, str);
    }

    private void openSubPage(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        String string = getInfoIntent().getExtras().getString(VasWebviewConstants.KEY_EMOJIMALL_DETAIL_CHAT_UIN);
        int i3 = getInfoIntent().getExtras().getInt(VasWebviewConstants.KEY_EMOJIMALL_DETAIL_CHAT_TYPE);
        Intent intent = new Intent();
        intent.putExtra("emojimall_src", this.mSrcFromType);
        intent.putExtra("selfuin", this.mSelfUin);
        intent.putExtra("url", str);
        intent.putExtra(VasWebviewConstants.KEY_PAGE_TITLE, str2);
        intent.putExtra(VasWebviewConstants.KEY_EMOJIMALL_DETAIL_CHAT_UIN, string);
        intent.putExtra(VasWebviewConstants.KEY_EMOJIMALL_DETAIL_CHAT_TYPE, i3);
        intent.putExtra(KEY_PAGE_OPEN_TIME, System.currentTimeMillis());
        intent.putExtra("emomall_new_time", this.mEmomallNewTimeFlag);
        intent.putExtra("reqType", 6);
        VasWebviewUtil.openQQBrowserWithoutAD(this.mRuntime.a(), null, 8L, intent, false, -1);
    }

    private void openTenpayView(String str, String str2) {
        PayBridgeActivity.tenpay(this.mRuntime.a(), str2, 5, str);
    }

    private void queryEmojiInfo(String str, String str2, int i3, int i16) {
        Bundle bundle = new Bundle();
        bundle.putString("id", str2);
        bundle.putInt("businessType", i3);
        bundle.putInt("sceneType", i16);
        ((IWebIPCOperatorApi) QRoute.api(IWebIPCOperatorApi.class)).sendServiceIpcReq(com.tencent.mobileqq.emosm.a.a("queryEmojiInfo", str, this.mOnRemoteResp.key, bundle));
    }

    private void queryEmojiInfos(String str, int i3) {
        Bundle bundle = new Bundle();
        bundle.putInt("sceneType", i3);
        ((IWebIPCOperatorApi) QRoute.api(IWebIPCOperatorApi.class)).sendServiceIpcReq(com.tencent.mobileqq.emosm.a.a("queryEmojiInfos", str, this.mOnRemoteResp.key, bundle));
    }

    private void queryEmojiStickerInfos(String str) {
        ((IWebIPCOperatorApi) QRoute.api(IWebIPCOperatorApi.class)).sendServiceIpcReq(com.tencent.mobileqq.emosm.a.a("queryEmojiStickerInfos", str, this.mOnRemoteResp.key, new Bundle()));
    }

    private void rechargeGameCurrency(String str, String str2) {
        PayBridgeActivity.tenpay(this.mRuntime.a(), str2, 6, str);
    }

    private void rechargeQb(String str, String str2) {
        PayBridgeActivity.tenpay(this.mRuntime.a(), str2, 8, str);
    }

    private void respMakeDynamicEmoji(int i3, String str) {
        MakeDynamicEmojiInfo makeDynamicEmojiInfo = this.makeInfo;
        if (makeDynamicEmojiInfo == null) {
            return;
        }
        if ((str == null || makeDynamicEmojiInfo == null || !str.equals(Integer.toString(makeDynamicEmojiInfo.emoPackId))) && i3 != 4) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("result", i3);
            onAppResponse(this.makeInfo.callbackid, jSONObject.toString());
        } catch (JSONException e16) {
            e16.printStackTrace();
        }
    }

    private void sendEmojiToAIO(JSONWrapper jSONWrapper, String str) {
        Emoticon emoticon = new Emoticon();
        emoticon.epId = jSONWrapper.getString("pkgId");
        emoticon.eId = jSONWrapper.getString("itemId");
        emoticon.isAPNG = jSONWrapper.getBoolean("isAPNG", false);
        emoticon.name = jSONWrapper.getString("itemName");
        Bundle bundle = new Bundle();
        bundle.putSerializable("emoticon", emoticon);
        ((IWebIPCOperatorApi) QRoute.api(IWebIPCOperatorApi.class)).sendServiceIpcReq(com.tencent.mobileqq.emosm.a.a("sendEmojiToAIO", str, this.mOnRemoteResp.key, bundle));
    }

    private void sendEmojiToFriend(int i3) {
        try {
            String string = getInfoIntent().getExtras().getString(VasWebviewConstants.KEY_EMOJIMALL_DETAIL_CHAT_UIN);
            int i16 = getInfoIntent().getExtras().getInt(VasWebviewConstants.KEY_EMOJIMALL_DETAIL_CHAT_TYPE);
            ReportController.r(null, "CliOper", "", "", "ep_mall", "Clk_send_detail", 0, 0, "", "", "", i3 + "");
            int i17 = this.mSrcFromType;
            if ((i17 == 1 || i17 == 8) && string != null) {
                Bundle bundle = new Bundle();
                bundle.putString("uin", string);
                bundle.putInt("uintype", i16);
                bundle.putInt(AppConstants.Key.FORWARD_EMOPGK_ID, i3);
                bundle.putBoolean("isBack2Root", true);
                Intent m3 = BaseAIOUtils.m(SplashActivity.getAliasIntent(this.mRuntime.a().getApplicationContext()), new int[]{2});
                this.mRuntime.a().getSharedPreferences("mobileQQ", 4).edit().putBoolean(AppConstants.Key.FORWARD_EMOPGK_ID, true).commit();
                m3.putExtras(bundle);
                this.mRuntime.a().startActivity(m3);
            } else {
                Bundle bundle2 = new Bundle();
                bundle2.putInt("forward_type", 14);
                bundle2.putInt(AppConstants.Key.FORWARD_EMOPGK_ID, i3);
                Intent intent = new Intent(this.mRuntime.a().getApplicationContext(), (Class<?>) ForwardRecentActivity.class);
                intent.addFlags(268435456);
                intent.addFlags(67108864);
                intent.putExtras(bundle2);
                this.mRuntime.a().startActivity(intent);
            }
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.e(TAG, 2, e16.getMessage());
            }
        }
    }

    private void showMsgBox(final String str, String str2, String str3, String str4) {
        String[] split = str4.split("\t");
        if (split.length >= 1) {
            final QQCustomDialogThreeBtns leftButton = DialogUtil.createCustomThreeBtnsDialog(this.mRuntime.a(), 230).setTitle(str3).setMessage(str2).setLeftButton(split[0], new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.vaswebviewplugin.EmojiJsPlugin.1
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i3) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("result", 0);
                        jSONObject.put("message", "btn0 press");
                        EmojiJsPlugin.this.onAppResponse(str, jSONObject.toString());
                    } catch (JSONException e16) {
                        e16.printStackTrace();
                    }
                }
            });
            if (split.length >= 2) {
                leftButton.setMiddleButton(split[1], new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.vaswebviewplugin.EmojiJsPlugin.2
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i3) {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("result", 1);
                            jSONObject.put("message", "btn1 press");
                            EmojiJsPlugin.this.onAppResponse(str, jSONObject.toString());
                        } catch (JSONException e16) {
                            e16.printStackTrace();
                        }
                    }
                });
            }
            if (split.length >= 3) {
                leftButton.setRightButton(split[2], new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.vaswebviewplugin.EmojiJsPlugin.3
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i3) {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("result", 2);
                            jSONObject.put("message", "btn2 press");
                            EmojiJsPlugin.this.onAppResponse(str, jSONObject.toString());
                        } catch (JSONException e16) {
                            e16.printStackTrace();
                        }
                    }
                });
            }
            leftButton.setCanceledOnTouchOutside(false);
            leftButton.setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: com.tencent.mobileqq.vaswebviewplugin.EmojiJsPlugin.4
                @Override // android.content.DialogInterface.OnKeyListener
                public boolean onKey(DialogInterface dialogInterface, int i3, KeyEvent keyEvent) {
                    if (i3 == 4 && leftButton.isShowing()) {
                        leftButton.dismiss();
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("message", "press");
                            EmojiJsPlugin.this.onAppResponse(str, jSONObject.toString());
                            return true;
                        } catch (JSONException e16) {
                            e16.printStackTrace();
                            return true;
                        }
                    }
                    return false;
                }
            });
            leftButton.show();
        }
    }

    private void showProgressDialog() {
        WebViewPlugin.b bVar = this.mRuntime;
        if (bVar != null && bVar.a() != null) {
            this.mRuntime.a().runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.vaswebviewplugin.EmojiJsPlugin.8
                @Override // java.lang.Runnable
                public void run() {
                    s g16 = EmojiJsPlugin.this.mRuntime.g();
                    if (g16 != null && g16.getWebTitleBarInterface() != null) {
                        EmojiJsPlugin.this.progressDialog = new QQProgressDialog(EmojiJsPlugin.this.mRuntime.a(), g16.getWebTitleBarInterface().getTitleBarHeight());
                        EmojiJsPlugin.this.progressDialog.show();
                    }
                }
            });
        }
    }

    private void startDownloadEmoji(final String str, final int i3, final int i16, boolean z16, final int i17) {
        try {
        } catch (JSONException e16) {
            e16.printStackTrace();
        }
        if (!Utils.B()) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "SDCard not available.");
            }
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("result", 6);
            jSONObject.put("message", "SDCard not available.");
            onAppResponse(str, jSONObject.toString());
            return;
        }
        long z17 = Utils.z();
        if (z17 < 5242880) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "Insufficient SDCard space, required: reserved:5242880|available:" + z17);
            }
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("result", 1);
            jSONObject2.put("message", "Insufficient SDCard space.");
            onAppResponse(str, jSONObject2.toString());
            return;
        }
        if (NetworkUtil.isNetSupport(this.mRuntime.a().getApplicationContext())) {
            if (z16 && NetworkUtil.getNetworkType(this.mRuntime.a().getApplicationContext()) != 1) {
                if (QLog.isColorLevel()) {
                    QLog.i(TAG, 2, "startDownloadEmoji non wifi net");
                }
                final QQCustomDialogThreeBtns rightButton = DialogUtil.createCustomThreeBtnsDialog(this.mRuntime.a(), 230).setTitle(this.mRuntime.a().getString(R.string.axa)).setMessage(this.mRuntime.a().getString(R.string.ax_)).setLeftButton(this.mRuntime.a().getString(R.string.ax8), new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.vaswebviewplugin.EmojiJsPlugin.6
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i18) {
                        JSONObject jSONObject3 = new JSONObject();
                        try {
                            jSONObject3.put("result", 2);
                            jSONObject3.put("message", EmojiJsPlugin.this.mRuntime.a().getString(R.string.axc));
                            if (QLog.isColorLevel()) {
                                QLog.i(EmojiJsPlugin.TAG, 2, "startDownloadEmoji resp to js:" + jSONObject3.toString());
                            }
                            EmojiJsPlugin.this.onAppResponse(str, jSONObject3.toString());
                        } catch (JSONException e17) {
                            e17.printStackTrace();
                        }
                    }
                }).setRightButton(this.mRuntime.a().getString(R.string.ax9), new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.vaswebviewplugin.EmojiJsPlugin.5
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i18) {
                        Bundle bundle = new Bundle();
                        bundle.putInt("id", i3);
                        bundle.putInt("businessType", i16);
                        bundle.putInt("sceneType", i17);
                        Bundle a16 = com.tencent.mobileqq.emosm.a.a("startDownloadEmoji", str, EmojiJsPlugin.this.mOnRemoteResp.key, bundle);
                        EmojiJsPlugin.this.addDownloadingStateObserver(new Pair<>(Integer.valueOf(i3), str));
                        ((IWebIPCOperatorApi) QRoute.api(IWebIPCOperatorApi.class)).sendServiceIpcReqWithoutTimeout(a16);
                    }
                });
                rightButton.setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: com.tencent.mobileqq.vaswebviewplugin.EmojiJsPlugin.7
                    @Override // android.content.DialogInterface.OnKeyListener
                    public boolean onKey(DialogInterface dialogInterface, int i18, KeyEvent keyEvent) {
                        if (i18 == 4 && rightButton.isShowing()) {
                            rightButton.dismiss();
                            JSONObject jSONObject3 = new JSONObject();
                            try {
                                jSONObject3.put("result", 2);
                                jSONObject3.put("message", EmojiJsPlugin.this.mRuntime.a().getString(R.string.axc));
                                if (QLog.isColorLevel()) {
                                    QLog.i(EmojiJsPlugin.TAG, 2, "startDownloadEmoji resp to js:" + jSONObject3.toString());
                                }
                                EmojiJsPlugin.this.onAppResponse(str, jSONObject3.toString());
                                return true;
                            } catch (JSONException e17) {
                                e17.printStackTrace();
                                return true;
                            }
                        }
                        return false;
                    }
                });
                rightButton.setCanceledOnTouchOutside(false);
                rightButton.show();
            } else {
                Bundle bundle = new Bundle();
                bundle.putInt("id", i3);
                bundle.putInt("businessType", i16);
                bundle.putInt("sceneType", i17);
                Bundle a16 = com.tencent.mobileqq.emosm.a.a("startDownloadEmoji", str, this.mOnRemoteResp.key, bundle);
                addDownloadingStateObserver(new Pair<>(Integer.valueOf(i3), str));
                ((IWebIPCOperatorApi) QRoute.api(IWebIPCOperatorApi.class)).sendServiceIpcReqWithoutTimeout(a16);
            }
        } else {
            JSONObject jSONObject3 = new JSONObject();
            try {
                jSONObject3.put("result", 5);
                jSONObject3.put("message", "no net");
                if (QLog.isColorLevel()) {
                    QLog.i(TAG, 2, "startDownloadEmoji resp to js onDownloadingResultSingle:" + jSONObject3.toString());
                }
                onAppResponse(str, jSONObject3.toString());
            } catch (JSONException e17) {
                e17.printStackTrace();
            }
            com.tencent.mobileqq.emosm.e.G(this.mRuntime.a());
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "js startDownloadEmoji ,callbackid:" + str + "emoPackId" + i3);
        }
    }

    private void stopDownloadEmoji(String str, int i3, int i16) {
        Bundle bundle = new Bundle();
        bundle.putInt("id", i3);
        bundle.putInt("sceneType", i16);
        ((IWebIPCOperatorApi) QRoute.api(IWebIPCOperatorApi.class)).sendServiceIpcReq(com.tencent.mobileqq.emosm.a.a("stopDownloadEmoji", str, this.mOnRemoteResp.key, bundle));
    }

    protected void OnActivityCreate() {
        this.mSrcFromType = getInfoIntent().getExtras().getInt("emojimall_src", 1);
        this.mEmomallNewTimeFlag = getInfoIntent().getExtras().getInt("emomall_new_time", -1);
    }

    void addDownloadingStateObserver(Pair<Integer, String> pair) {
        synchronized (this.mDownloadingFunctions) {
            if (pair != null) {
                if (!this.mDownloadingFunctions.contains(pair)) {
                    this.mDownloadingFunctions.add(pair);
                    if (QLog.isColorLevel()) {
                        QLog.i(TAG, 2, "addDownloadingStateObserver id:" + pair.first + "callbackid:" + ((String) pair.second));
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.vaswebviewplugin.VasWebviewJsPlugin
    public boolean excuteEvent(String str, long j3, Map<String, Object> map) {
        if (8589934603L == j3) {
            if (map != null) {
                respMakeDynamicEmoji(((Integer) map.get(KEY_DEMOJI_MAKE_RESULT)).intValue(), (String) map.get(KEY_DEMOJI_MAKE_ID));
                return true;
            }
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public String getNameSpace() {
        return "emoji";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.vaswebviewplugin.VasBasePlugin
    public long getPluginBusiness() {
        return 2147483662L;
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public long getWebViewSchemaByNameSpace(String str) {
        return 32L;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public boolean handleJsRequest(JsBridgeListener jsBridgeListener, String str, String str2, String str3, String... strArr) {
        JSONObject jsonFromJSBridge;
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "handleJsRequest, url=" + str + ", pkgName=" + str2 + ", methodName=" + str3);
        }
        if (str == null || !"emoji".equals(str2) || str3 == null) {
            return false;
        }
        if (TextUtils.isEmpty(this.mSelfUin) && this.mRuntime.b() != null) {
            this.mSelfUin = this.mRuntime.b().getAccount();
        }
        try {
            jsonFromJSBridge = WebViewPlugin.getJsonFromJSBridge(str);
        } catch (Throwable th5) {
            if (QLog.isColorLevel()) {
                QLog.e(TAG, 2, th5.getMessage());
            }
        }
        if (jsonFromJSBridge == null) {
            return true;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "handleJsRequest JSON = " + jsonFromJSBridge.toString());
        }
        String optString = jsonFromJSBridge.optString("callback");
        if (TextUtils.isEmpty(optString)) {
            QLog.e(TAG, 1, "callback id is null, so return");
            return true;
        }
        if ("demojiremake".equals(str3)) {
            JSONObject jSONObject = new JSONObject(strArr[0]);
            respMakeDynamicEmoji(((Integer) jSONObject.get(KEY_DEMOJI_MAKE_RESULT)).intValue(), (String) jSONObject.get(KEY_DEMOJI_MAKE_ID));
        } else {
            invoke(str3, jsonFromJSBridge.toString(), optString);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public boolean handleSchemaRequest(String str, String str2) {
        if (TextUtils.isEmpty(this.mSelfUin) && this.mRuntime.b() != null) {
            this.mSelfUin = this.mRuntime.b().getAccount();
        }
        return handleEmojiSchemaRequest(str, str2);
    }

    public void invoke(String str, String str2, String str3) {
        boolean z16;
        if (!((IWebIPCOperatorApi) QRoute.api(IWebIPCOperatorApi.class)).isServiceClientBinded()) {
            ((IWebIPCOperatorApi) QRoute.api(IWebIPCOperatorApi.class)).doBindService(this.mRuntime.a().getApplicationContext());
        }
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str3)) {
            try {
                JSONObject jSONObject = new JSONObject(str2);
                JSONWrapper jSONWrapper = new JSONWrapper(jSONObject);
                VasCommonReporter.getHistoryFeature("emoji_js").setValue2(str).report();
                if (str.equals(IndividuationPlugin.Method_OpenPage)) {
                    openPage(str3, jSONWrapper.getString(VasWebviewConstants.KEY_PAGE_URL), jSONWrapper.getString(VasWebviewConstants.KEY_PAGE_TITLE), jSONWrapper.getBoolean("pageSession", false));
                    return;
                }
                if (str.equals("showMsgBox")) {
                    showMsgBox(str3, jSONWrapper.getString("prompt"), jSONWrapper.getString("title"), jSONWrapper.getString("button"));
                    return;
                }
                if (str.equals("buyEmoji")) {
                    buyEmoji(str3, jSONWrapper.getString("appId"), jSONWrapper.getString("userId"), jSONWrapper.getString("userKey"), jSONWrapper.getString("sessionId"), jSONWrapper.getString(ShortVideoConstants.PARAM_KEY_SESSION_TYPE), jSONWrapper.getString(AdParam.PF), jSONWrapper.getString("pfKey"), jSONWrapper.getString("zoneId"), jSONWrapper.getString("tokenUrl"), jSONWrapper.getString("drmInfo"));
                    return;
                }
                if (str.equals("queryEmojiInfo")) {
                    queryEmojiInfo(str3, jSONWrapper.getString("id"), jSONWrapper.getInt("businessType", 1), jSONWrapper.getInt("sceneType", 0));
                    return;
                }
                if (str.equals("queryEmojiInfos")) {
                    queryEmojiInfos(str3, jSONWrapper.getInt("sceneType", 0));
                    return;
                }
                if (str.equals("startDownloadEmoji")) {
                    int i3 = jSONWrapper.getInt("id", 0);
                    int i16 = jSONWrapper.getInt("businessType", 1);
                    int i17 = jSONWrapper.getInt("sceneType", 0);
                    if (jSONObject.has(ThemeReporter.BUNDLE_KEY_WITHOUT_NET_TIPS) && jSONObject.getBoolean(ThemeReporter.BUNDLE_KEY_WITHOUT_NET_TIPS)) {
                        z16 = false;
                        startDownloadEmoji(str3, i3, i16, z16, i17);
                        return;
                    }
                    z16 = true;
                    startDownloadEmoji(str3, i3, i16, z16, i17);
                    return;
                }
                if (str.equals("sendEmojiToFrd")) {
                    sendEmojiToFriend(jSONWrapper.getInt("id", 0));
                    return;
                }
                if (str.equals("stopDownloadEmoji")) {
                    stopDownloadEmoji(str3, jSONWrapper.getInt("id", 0), jSONWrapper.getInt("sceneType", 0));
                    return;
                }
                if (str.equals("closePage")) {
                    closePage(0);
                    return;
                }
                if (str.equals("getSessionKey")) {
                    getSessionKey(jSONWrapper.getString("type"), str3);
                    return;
                }
                if (str.equals("getNetwork")) {
                    getNetwork(str3);
                    return;
                }
                if ("makeDynamicEmoji".equals(str)) {
                    jSONWrapper.getInt("id", 0);
                    return;
                }
                if ("openService".equals(str)) {
                    openService(str3, str2);
                    return;
                }
                if ("rechargeGameCurrency".equals(str)) {
                    rechargeGameCurrency(str3, str2);
                    return;
                }
                if (IVipPayApi.METHOD_BUYGOODS.equals(str)) {
                    buyGoods(str3, str2);
                    return;
                }
                if ("rechargeQb".equals(str)) {
                    rechargeQb(str3, str2);
                    return;
                }
                if (TenpayPlugin.PLUGIN_NAME.equals(str)) {
                    openTenpayView(str3, str2);
                    return;
                }
                if ("getVipType".equals(str)) {
                    getVipType(jSONObject, str3);
                    return;
                }
                if ("queryEmojiStickerInfos".equals(str)) {
                    queryEmojiStickerInfos(str3);
                    return;
                }
                if ("emojiStickerRecall".equals(str)) {
                    emojiStickerRecall(jSONWrapper.getString("hash"), str3);
                    return;
                }
                if ("emojiStickerAddFavorites".equals(str)) {
                    emojiStickerAddFavorites(jSONWrapper.getString("hash"), str3);
                    return;
                }
                if ("sendEmojiToAIO".equals(str)) {
                    sendEmojiToAIO(jSONWrapper, str3);
                    return;
                }
                if ("collectEmoji".equals(str)) {
                    collectEmoji(jSONWrapper, str3);
                    return;
                }
                if ("getCollectEmojiStatus".equals(str)) {
                    getCollectEmojiStatus(jSONWrapper, str3);
                    return;
                }
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jSONObject.put("result", -1);
                    jSONObject.put("message", "error handler");
                    onAppResponse(str3, jSONObject2.toString());
                } catch (JSONException e16) {
                    e16.printStackTrace();
                }
            } catch (JSONException e17) {
                e17.printStackTrace();
            }
        }
    }

    public void onAppResponse(String str, String str2) {
        super.callJs(str + "(" + str2 + ");");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.vaswebviewplugin.VasWebviewJsPlugin, com.tencent.mobileqq.vaswebviewplugin.VasBasePlugin, com.tencent.mobileqq.webview.swift.WebViewPlugin
    public void onCreate() {
        super.onCreate();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.vaswebviewplugin.VasWebviewJsPlugin, com.tencent.mobileqq.webview.swift.WebViewPlugin
    public void onDestroy() {
        super.onDestroy();
        clearDownloadingObservers();
    }

    @Override // com.tencent.mobileqq.vaswebviewplugin.VasWebviewJsPlugin
    public void onDisconnectWithService() {
        onDownloadingResultAll(-1, "service disconnect");
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "onDisconnectWithService");
        }
    }

    void onDownloadingResultAll(int i3, String str) {
        synchronized (this.mDownloadingFunctions) {
            Iterator<Pair<Integer, String>> it = this.mDownloadingFunctions.iterator();
            while (it.hasNext()) {
                Pair<Integer, String> next = it.next();
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("result", i3);
                    jSONObject.put("message", str);
                    if (QLog.isColorLevel()) {
                        QLog.i(TAG, 2, "onDownloadingResultAll startDownloadEmoji resp to js onDownloadingResultall:" + jSONObject.toString());
                    }
                    onAppResponse((String) next.second, jSONObject.toString());
                } catch (JSONException e16) {
                    e16.printStackTrace();
                }
            }
            this.mDownloadingFunctions.clear();
            if (QLog.isColorLevel()) {
                QLog.i(TAG, 2, "onDownloadingResultAll clear all:");
            }
        }
    }

    void onDownloadingResultSingle(int i3, int i16, String str) {
        synchronized (this.mDownloadingFunctions) {
            if (i3 > 0) {
                Vector vector = new Vector();
                Iterator<Pair<Integer, String>> it = this.mDownloadingFunctions.iterator();
                while (it.hasNext()) {
                    Pair<Integer, String> next = it.next();
                    if (((Integer) next.first).intValue() == i3) {
                        vector.add(next);
                    }
                }
                Iterator it5 = vector.iterator();
                while (it5.hasNext()) {
                    Pair pair = (Pair) it5.next();
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("result", i16);
                        jSONObject.put("message", str);
                        if (QLog.isColorLevel()) {
                            QLog.i(TAG, 2, "onDownloadingResultSingle startDownloadEmoji resp to js onDownloadingResultSingle:" + jSONObject.toString());
                        }
                        onAppResponse((String) pair.second, jSONObject.toString());
                    } catch (JSONException e16) {
                        e16.printStackTrace();
                    }
                    this.mDownloadingFunctions.remove(pair);
                    if (QLog.isColorLevel()) {
                        QLog.i(TAG, 2, "onDownloadingResultSingle remove id:" + pair.first + "callbackid:" + ((String) pair.second) + "mDownloadingFunctions size:" + this.mDownloadingFunctions.size());
                    }
                }
            }
        }
    }

    @Override // com.tencent.mobileqq.vaswebviewplugin.VasWebviewJsPlugin
    public void onPushMsg(Bundle bundle) {
        if (bundle != null) {
            int i3 = bundle.getInt("packetid", -1);
            int i16 = bundle.getInt("resultcode", -1);
            onDownloadingResultSingle(i3, i16, "");
            if (QLog.isColorLevel()) {
                QLog.i(TAG, 2, "onPushMsg + id:" + i3 + ",resultcode:" + i16);
            }
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(8:65|(2:67|(1:(6:70|71|72|73|74|75))(1:80))(1:81)|79|71|72|73|74|75) */
    /* JADX WARN: Code restructure failed: missing block: B:168:0x0421, code lost:
    
        if (r2 == 4) goto L130;
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x028c, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x028d, code lost:
    
        r0.printStackTrace();
     */
    /* JADX WARN: Removed duplicated region for block: B:152:0x042b  */
    @Override // com.tencent.mobileqq.vaswebviewplugin.VasWebviewJsPlugin
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onResponse(Bundle bundle) {
        int i3;
        int i16;
        int i17;
        int i18;
        int i19;
        int i26;
        int i27;
        ArrayList parcelableArrayList;
        int i28;
        ArrayList<String> arrayList;
        Object obj;
        String str = "subid";
        if (bundle != null && bundle.getInt("respkey", 0) == this.mOnRemoteResp.key) {
            String string = bundle.getString("cmd");
            String string2 = bundle.getString("callbackid");
            Bundle bundle2 = bundle.getBundle(Const.BUNDLE_KEY_REQUEST);
            Bundle bundle3 = bundle.getBundle("response");
            int i29 = bundle.getInt("failcode");
            if (string != null) {
                if (string.equals("queryEmojiInfo")) {
                    int i36 = bundle3.getInt("result");
                    Object string3 = bundle3.getString("messge");
                    int i37 = bundle3.getInt("status");
                    int i38 = bundle3.getInt("pluginStatus");
                    long j3 = bundle3.getLong("pluginSize");
                    int i39 = bundle3.getInt("progress");
                    int i46 = bundle3.getInt("dynamicEmojiId");
                    ArrayList<String> stringArrayList = bundle3.getStringArrayList("dynamicEmojiList");
                    ArrayList<String> stringArrayList2 = bundle3.getStringArrayList("urlParamsList");
                    if (i29 != 1000) {
                        obj = "queryEmojiInfo error";
                        arrayList = stringArrayList2;
                        i28 = -1;
                    } else {
                        i28 = i36;
                        arrayList = stringArrayList2;
                        obj = string3;
                    }
                    JSONObject jSONObject = new JSONObject();
                    ArrayList<String> arrayList2 = stringArrayList;
                    JSONObject jSONObject2 = new JSONObject();
                    try {
                        jSONObject.put("result", i28);
                        jSONObject.put("message", obj);
                        jSONObject2.put("status", i37);
                        jSONObject2.put("progress", i39);
                        jSONObject2.put("pluginSize", j3);
                        jSONObject2.put("pluginStatus", i38);
                        if (i46 > 0) {
                            jSONObject2.put("dynamicEmojiId", i46);
                        }
                        if (arrayList2 != null && arrayList2.size() > 0) {
                            JSONArray jSONArray = new JSONArray();
                            int i47 = 0;
                            while (i47 < arrayList2.size()) {
                                JSONObject jSONObject3 = new JSONObject();
                                ArrayList<String> arrayList3 = arrayList2;
                                jSONObject3.put("src", arrayList3.get(i47));
                                ArrayList<String> arrayList4 = arrayList;
                                jSONObject3.put("urlParam", arrayList4.get(i47));
                                jSONArray.mo162put(jSONObject3);
                                i47++;
                                arrayList2 = arrayList3;
                                arrayList = arrayList4;
                            }
                            jSONObject2.put("dynamicEmojiList", jSONArray);
                        }
                        jSONObject.put("data", jSONObject2);
                        if (QLog.isColorLevel()) {
                            QLog.i(TAG, 2, "queryEmojiInfo resp to js:" + jSONObject.toString());
                        }
                        try {
                            onAppResponse(string2, jSONObject.toString());
                        } catch (JSONException e16) {
                            e = e16;
                            e.printStackTrace();
                        }
                    } catch (JSONException e17) {
                        e = e17;
                    }
                } else {
                    if ("queryEmojiStickerInfos".equals(string)) {
                        if (bundle3 != null && (parcelableArrayList = bundle3.getParcelableArrayList("stickerInfos")) != null) {
                            try {
                                JSONObject jSONObject4 = new JSONObject();
                                JSONArray jSONArray2 = new JSONArray();
                                Iterator it = parcelableArrayList.iterator();
                                while (it.hasNext()) {
                                    Bundle bundle4 = (Bundle) it.next();
                                    JSONObject jSONObject5 = new JSONObject();
                                    jSONObject5.put("id", bundle4.getString("id"));
                                    jSONObject5.put(str, bundle4.getString(str));
                                    jSONObject5.put("name", bundle4.getString("name"));
                                    jSONObject5.put("time", bundle4.getLong("time"));
                                    jSONObject5.put("nickName", bundle4.getString("nickName"));
                                    jSONObject5.put("status", bundle4.getInt("status"));
                                    jSONObject5.put("type", bundle4.getInt("type"));
                                    jSONObject5.put("url", bundle4.getString("url"));
                                    jSONObject5.put("hash", bundle4.getString("hash"));
                                    jSONObject5.put("isSelf", bundle4.getInt("isSelf"));
                                    jSONObject5.put("base64", bundle4.getString("base64"));
                                    jSONArray2.mo162put(jSONObject5);
                                    it = it;
                                    str = str;
                                }
                                JSONObject jSONObject6 = new JSONObject();
                                jSONObject6.put("data", jSONArray2);
                                jSONObject4.put("data", jSONObject6);
                                jSONObject4.put("result", 0);
                                jSONObject4.put("message", "success");
                                onAppResponse(string2, jSONObject4.toString());
                                return;
                            } catch (JSONException e18) {
                                e18.printStackTrace();
                                return;
                            }
                        }
                        return;
                    }
                    String str2 = "";
                    if ("emojiStickerRecall".equals(string)) {
                        if (bundle3 != null) {
                            dismissProgressDialog();
                            int i48 = bundle3.getInt("result");
                            String string4 = bundle3.getString("QQ");
                            int i49 = bundle3.getInt("chatType");
                            if (i48 != -2) {
                                if (i48 != -1) {
                                    if (i48 == 0) {
                                        str2 = HardCodeUtil.qqStr(R.string.m5x);
                                        i27 = 0;
                                        makeToast(str2);
                                        JSONObject jSONObject7 = new JSONObject();
                                        jSONObject7.put("result", i48);
                                        onAppResponse(string2, jSONObject7.toString());
                                        VasWebviewUtil.reportCommercialDrainage(string4, "Stick", "Recall", String.valueOf(i49), 0, i27, 0, "", "", "", "", "", "", "", 0, 0, 0, 0);
                                        return;
                                    }
                                } else {
                                    str2 = HardCodeUtil.qqStr(R.string.m5u);
                                }
                            } else {
                                str2 = HardCodeUtil.qqStr(R.string.m5v);
                            }
                            i27 = 1;
                            makeToast(str2);
                            JSONObject jSONObject72 = new JSONObject();
                            jSONObject72.put("result", i48);
                            onAppResponse(string2, jSONObject72.toString());
                            VasWebviewUtil.reportCommercialDrainage(string4, "Stick", "Recall", String.valueOf(i49), 0, i27, 0, "", "", "", "", "", "", "", 0, 0, 0, 0);
                            return;
                        }
                        return;
                    }
                    if ("emojiStickerAddFavorites".equals(string)) {
                        if (bundle3 != null) {
                            dismissProgressDialog();
                            int i56 = bundle3.getInt("result");
                            if (i56 != -2) {
                                if (i56 != -1) {
                                    if (i56 == 0) {
                                        str2 = HardCodeUtil.qqStr(R.string.m5y);
                                    }
                                } else {
                                    str2 = HardCodeUtil.qqStr(R.string.m5z);
                                }
                            } else {
                                str2 = HardCodeUtil.qqStr(R.string.m5w);
                            }
                            makeToast(str2);
                            try {
                                JSONObject jSONObject8 = new JSONObject();
                                jSONObject8.put("result", i56);
                                onAppResponse(string2, jSONObject8.toString());
                                return;
                            } catch (JSONException e19) {
                                e19.printStackTrace();
                                return;
                            }
                        }
                        return;
                    }
                    if ("queryEmojiInfos".equals(string)) {
                        if (i29 != 1000) {
                            str2 = "queryEmojiInfos error";
                            i26 = -1;
                        } else {
                            i26 = 0;
                        }
                        JSONObject jSONObject9 = new JSONObject();
                        ArrayList parcelableArrayList2 = bundle3.getParcelableArrayList("pkgStatusList");
                        try {
                            jSONObject9.put("result", i26);
                            jSONObject9.put("message", str2);
                            if (parcelableArrayList2 != null) {
                                JSONObject jSONObject10 = new JSONObject();
                                Iterator it5 = parcelableArrayList2.iterator();
                                while (it5.hasNext()) {
                                    Bundle bundle5 = (Bundle) it5.next();
                                    JSONObject jSONObject11 = new JSONObject();
                                    jSONObject11.put("status", bundle5.getInt("status"));
                                    jSONObject11.put("progress", bundle5.getInt("progress"));
                                    jSONObject11.put("usable", bundle5.getInt("flag"));
                                    int i57 = bundle5.getInt("dEmojiId");
                                    if (i57 > 0) {
                                        jSONObject11.put("dynamicEmojiId", i57);
                                    }
                                    jSONObject10.put(bundle5.getString("id"), jSONObject11);
                                }
                                jSONObject9.put("data", jSONObject10);
                            }
                            onAppResponse(string2, jSONObject9.toString());
                            return;
                        } catch (JSONException e26) {
                            e26.printStackTrace();
                            return;
                        }
                    }
                    if ("writeQFaceResult".equals(string)) {
                        int i58 = bundle3.getInt("result", -1);
                        String string5 = bundle3.getString("messge");
                        if (i29 != 1000) {
                            string5 = "QFaceResult error";
                            i19 = -1;
                        } else {
                            i19 = i58;
                        }
                        if (QLog.isColorLevel()) {
                            QLog.d("Q.emoji.EmoQFace", 2, "write qface result, result:" + i19 + " msg:" + string5);
                            return;
                        }
                        return;
                    }
                    if (string.equals("startDownloadEmoji")) {
                        int i59 = bundle3.getInt("result", -1);
                        int i65 = bundle2.getInt("id");
                        if (i29 == 1000) {
                            if (i59 == 0) {
                                if (QLog.isColorLevel()) {
                                    QLog.i(TAG, 2, "startDownloadEmoji resp + addDownloadingStateObserver + id:" + i65 + "callbackid:" + string2);
                                }
                            } else {
                                if (i59 == 1) {
                                    i18 = -1;
                                } else {
                                    int i66 = 3;
                                    if (i59 != 3) {
                                        i66 = 4;
                                    }
                                    i18 = i66;
                                }
                                if (QLog.isColorLevel()) {
                                    QLog.d(TAG, 2, "startDownloadEmoji resp suc:result:" + i59);
                                }
                                i17 = 2;
                            }
                            i18 = Integer.MIN_VALUE;
                            if (QLog.isColorLevel()) {
                            }
                            i17 = 2;
                        } else {
                            if (QLog.isColorLevel()) {
                                i17 = 2;
                                QLog.d(TAG, 2, "startDownloadEmoji resp error: failcode:" + i29);
                            } else {
                                i17 = 2;
                            }
                            i18 = -1;
                        }
                        if (i18 != Integer.MIN_VALUE) {
                            if (QLog.isColorLevel()) {
                                QLog.i(TAG, i17, "startDownloadEmoji resp error");
                            }
                            onDownloadingResultSingle(i65, i18, "");
                            return;
                        }
                        return;
                    }
                    if (string.equals("stopDownloadEmoji")) {
                        int i67 = bundle3.getInt("result", -1);
                        String string6 = bundle3.getString("messge");
                        if (i29 != 1000) {
                            string6 = "startDownloadEmoji error";
                            i16 = 1;
                        } else {
                            i16 = i67;
                        }
                        JSONObject jSONObject12 = new JSONObject();
                        try {
                            jSONObject12.put("result", i16);
                            jSONObject12.put("message", string6);
                            if (QLog.isColorLevel()) {
                                QLog.i(TAG, 2, "stopDownloadEmoji resp to js:" + jSONObject12.toString());
                            }
                            onAppResponse(string2, jSONObject12.toString());
                            return;
                        } catch (JSONException e27) {
                            e27.printStackTrace();
                            return;
                        }
                    }
                    if (string.equals("sendEmojiToAIO")) {
                        if (bundle3.getBoolean("result", false)) {
                            try {
                                Bundle bundle6 = new Bundle();
                                bundle6.putInt("forward_type", 9);
                                bundle6.putBoolean(AppConstants.Key.KEY_DIRECT_SEND_EMOJI, true);
                                Intent intent = new Intent();
                                intent.putExtras(bundle6);
                                ForwardBaseOption.startForwardActivityForResult(this.mRuntime.a(), intent, 21);
                            } catch (Exception e28) {
                                QLog.e(TAG, 2, "", e28);
                            }
                            i3 = 0;
                        } else {
                            i3 = -1;
                        }
                        JSONObject jSONObject13 = new JSONObject();
                        try {
                            jSONObject13.put("result", i3);
                            if (QLog.isColorLevel()) {
                                QLog.i(TAG, 2, "sendEmojiToAIO resp to js:" + jSONObject13.toString());
                            }
                            onAppResponse(string2, jSONObject13.toString());
                            return;
                        } catch (JSONException e29) {
                            QLog.e(TAG, 2, "", e29);
                            return;
                        }
                    }
                    if (string.equals("getCollectEmojiStatus")) {
                        boolean z16 = bundle3.getBoolean("result", false);
                        JSONObject jSONObject14 = new JSONObject();
                        try {
                            jSONObject14.put("result", z16 ? 1 : 0);
                            if (QLog.isColorLevel()) {
                                QLog.i(TAG, 2, "getCollectEmojiStatus resp to js:" + jSONObject14.toString());
                            }
                            onAppResponse(string2, jSONObject14.toString());
                            return;
                        } catch (JSONException e36) {
                            QLog.e(TAG, 2, "", e36);
                            return;
                        }
                    }
                    if (string.equals("collectEmoji")) {
                        int i68 = bundle3.getInt("result");
                        JSONObject jSONObject15 = new JSONObject();
                        try {
                            jSONObject15.put("result", i68);
                            if (QLog.isColorLevel()) {
                                QLog.i(TAG, 2, "collectEmoji resp to js:" + jSONObject15.toString());
                            }
                            onAppResponse(string2, jSONObject15.toString());
                            return;
                        } catch (JSONException e37) {
                            QLog.e(TAG, 2, "", e37);
                            return;
                        }
                    }
                    super.onResponse(bundle);
                }
            }
        }
    }
}
