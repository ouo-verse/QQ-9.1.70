package com.tencent.mobileqq.vaswebviewplugin;

import Wallet.AuthCodeItem;
import Wallet.AuthCodeRsp;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.Cursor;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Parcel;
import android.os.ResultReceiver;
import android.os.SystemClock;
import android.provider.ContactsContract;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.biz.webviewbase.AbsBaseWebViewActivity;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.component.media.MtpConstants;
import com.tencent.ecommerce.base.runtime.api.IECScreenReceiver;
import com.tencent.hippy.qq.view.scroll.HippyHeaderListViewController;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.RouterConstants;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.emosm.api.IWebIPCOperatorApi;
import com.tencent.mobileqq.microapp.sdk.MiniAppLauncher;
import com.tencent.mobileqq.mini.appbrand.ui.PreloadingFragment;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msf.core.c0.j;
import com.tencent.mobileqq.msf.core.stepcount.StepCounterConstants;
import com.tencent.mobileqq.perf.block.BinderMethodProxy;
import com.tencent.mobileqq.profilecard.api.IProfileProtocolConst;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qqpermission.QQPermission;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.qqpermission.QQPermissionFactory;
import com.tencent.mobileqq.qqpermission.business.BusinessConfig;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.IQWalletApi;
import com.tencent.mobileqq.qwallet.api.IQWalletHomeApi;
import com.tencent.mobileqq.qwallet.preload.IPreloadService;
import com.tencent.mobileqq.qwallet.preload.IPreloadServiceProxy;
import com.tencent.mobileqq.qwallet.preload.ResourceInfo;
import com.tencent.mobileqq.statistics.DcReportUtil;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.bj;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.widget.QQVideoView;
import com.tencent.mobileqq.winkpublish.api.constant.FSPublishConstants;
import com.tencent.qmethod.pandoraex.monitor.ContactsMonitor;
import com.tencent.qmethod.pandoraex.monitor.OaidMonitor;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qq.minibox.api.data.MiniBoxNoticeInfo;
import com.tencent.thread.monitor.plugin.proxy.ProxyExecutors;
import com.tencent.util.WeakReferenceHandler;
import com.tenpay.proxy.dlg.location.QbAddrData;
import cooperation.qwallet.plugin.IPayLogic;
import cooperation.qwallet.plugin.IQWalletHelper;
import cooperation.qwallet.plugin.QWalletPayBridge;
import cooperation.qwallet.pluginshare.ITenCookie;
import eipc.EIPCResult;
import java.io.File;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.lang.ref.WeakReference;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.regex.Pattern;
import mqq.app.AppActivity;
import mqq.app.AppRuntime;
import mqq.app.QQPermissionCallback;
import mqq.app.api.ProcessConstant;
import org.jf.dexlib2.analysis.RegisterType;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tl.h;

/* loaded from: classes35.dex */
public class QWalletCommonJsPlugin extends VasWebviewJsPlugin {
    public static final String ACTION_NOTIFY_VIEW_UPDATE = "action_notify_view_update";
    public static final String PLUGIN_NAMESPACE = "qw_charge";
    private static byte REQUESTCODE_TRANSFER = 2;
    private static byte REQUESTCODE_TRANSFER_CHOOSE = 1;
    private static final int SKIN_ACTION_CLOSE = 0;
    private static final int SKIN_ACTION_GET = 2;
    private static final int SKIN_ACTION_SET = 1;
    private static final int SKIN_RESULT_FAIL = 1;
    private static final int SKIN_RESULT_SUCC = 0;
    private static final int SKIN_STATUS_CLOSE = 0;
    private static final int SKIN_STATUS_OPEN = 1;
    static final String TAG = "QWalletCommonJsPlugin";
    static String mListid = "";
    static String mParamForGarpHb = "";
    protected ChooseQQFriendForTransferReceiver aioChoFriReceiver;
    AppInterface app;
    private ExecutorService executorService;
    private long mAuthCodeAppId;
    String mContactId;
    private Context mContext;
    private long mLastAuthCodeReqTime;
    protected MyResultRecevicer mRecevicer;
    private long mReqAuthCodeStartTime;
    QWVideoJsPlugin mVideoJsPlugin;
    private final int REQ_CODE_OPENCTCONTACT = 1;
    private final int REQ_CODE_GETSELECTCONTACT = 2;
    private final int REQ_CODE_GETALLCONTACT = 3;
    private final String QWALLET_TOKEN_GET_SELECT_CONTACT = "qw_charge_getSelectContact";
    private final String QWALLET_TOKEN_GET_ALL_CONTATC = "qw_charge_getAllContact";
    private final String QWALLET_TOKEN_GOTO_QWALLET_HOME = "qw_charge_gotoQWalletHome";
    private final String QWALLET_TOKEN_AIO_TRANSFER = "qw_charge_tenpayTransfer";
    private final String EMOJI_USER_CHARGE_RESULT = "qw_charge_emojiPayResultOk";
    private final String QQPIMSECURE_SAFE_SECURITYPAY_ISOPEN = "qw_charge_qqpimsecure_safe_isopen_securitypay";
    private final String QWALLET_CHECK_WEBANK_PERMISSION = "qw_charge_checkPermission";
    private final String QWALLET_GET_APP_AUTHCODE = "qw_charge_getAppAuthorizationCode";
    private final String QWALLET_NOTIFY_VIEW_UPDATE = "qw_charge_notifyViewUpdate";
    private final byte QWALLET_REQUEST_CONTACT = RegisterType.UNINIT_REF;
    private final byte QWALLET_REQUEST_CHECK_PERMISSION = 17;
    private String mCallback = null;
    BroadcastReceiver mScreenReceiver = new BroadcastReceiver() { // from class: com.tencent.mobileqq.vaswebviewplugin.QWalletCommonJsPlugin.1
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            QWVideoJsPlugin qWVideoJsPlugin;
            if (QLog.isColorLevel()) {
                QLog.d(QWalletCommonJsPlugin.TAG, 2, "onReceive:" + intent.getAction());
            }
            if (!"android.intent.action.USER_PRESENT".equals(intent.getAction()) || (qWVideoJsPlugin = QWalletCommonJsPlugin.this.mVideoJsPlugin) == null) {
                return;
            }
            qWVideoJsPlugin.resumeOrPause(true, false);
        }
    };
    protected QQPermissionCallback mOpenContactCallBack = new QQPermissionCallback() { // from class: com.tencent.mobileqq.vaswebviewplugin.QWalletCommonJsPlugin.5
        @Override // mqq.app.QQPermissionCallback
        public void deny(int i3, String[] strArr, int[] iArr) {
            DialogUtil.showPermissionSettingDialog2(QWalletCommonJsPlugin.this.mRuntime.a(), strArr, iArr);
            QWalletCommonJsPlugin qWalletCommonJsPlugin = QWalletCommonJsPlugin.this;
            qWalletCommonJsPlugin.callJs(qWalletCommonJsPlugin.mCallback, "{'result':-1, 'msg': 'no permission to read contact number'}");
        }

        @Override // mqq.app.QQPermissionCallback
        public void grant(int i3, String[] strArr, int[] iArr) {
            QWalletCommonJsPlugin.this.openContact();
        }
    };
    protected QQPermissionCallback mGetSelectContactCallBack = new QQPermissionCallback() { // from class: com.tencent.mobileqq.vaswebviewplugin.QWalletCommonJsPlugin.6
        @Override // mqq.app.QQPermissionCallback
        public void deny(int i3, String[] strArr, int[] iArr) {
            DialogUtil.showPermissionSettingDialog2(QWalletCommonJsPlugin.this.mRuntime.a(), strArr, iArr);
            QWalletCommonJsPlugin qWalletCommonJsPlugin = QWalletCommonJsPlugin.this;
            qWalletCommonJsPlugin.callJs(qWalletCommonJsPlugin.mCallback, "{'result':-1, 'msg': 'no permission to read contact number'}");
        }

        @Override // mqq.app.QQPermissionCallback
        public void grant(int i3, String[] strArr, int[] iArr) {
            new SelectContactTask().execute(QWalletCommonJsPlugin.this.mContactId);
        }
    };
    protected QQPermission.BasePermissionsListener mGetAllContactCallBack = new QQPermission.BasePermissionsListener() { // from class: com.tencent.mobileqq.vaswebviewplugin.QWalletCommonJsPlugin.7
        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onAllGranted() {
            super.onAllGranted();
            new GetAllContactTask().execute(new Void[0]);
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onDenied(List<String> list, List<Integer> list2) {
            super.onDenied(list, list2);
            QWalletCommonJsPlugin qWalletCommonJsPlugin = QWalletCommonJsPlugin.this;
            qWalletCommonJsPlugin.callJs(qWalletCommonJsPlugin.mCallback, "{'result':-1, 'msg': 'no permission to read contact number'}");
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes35.dex */
    public static class ChooseQQFriendForTransferReceiver extends ResultReceiver {
        private WeakReference<QWalletCommonJsPlugin> mJsPluginRef;

        public ChooseQQFriendForTransferReceiver(QWalletCommonJsPlugin qWalletCommonJsPlugin, Handler handler) {
            super(handler);
            this.mJsPluginRef = new WeakReference<>(qWalletCommonJsPlugin);
        }

        @Override // android.os.ResultReceiver
        protected void onReceiveResult(int i3, Bundle bundle) {
            super.onReceiveResult(i3, bundle);
            QWalletCommonJsPlugin qWalletCommonJsPlugin = this.mJsPluginRef.get();
            if (qWalletCommonJsPlugin == null) {
                return;
            }
            if (i3 == 0 && bundle != null) {
                ArrayList<String> stringArrayList = bundle.getStringArrayList("choose_friend_uins");
                ArrayList<String> stringArrayList2 = bundle.getStringArrayList("choose_friend_names");
                if (stringArrayList != null && !stringArrayList.isEmpty() && stringArrayList2 != null && !stringArrayList2.isEmpty()) {
                    qWalletCommonJsPlugin.startTransactionActivity(stringArrayList.get(0), stringArrayList2.get(0));
                    return;
                } else {
                    qWalletCommonJsPlugin.dochooseQQFriendsForTransferResult(null);
                    return;
                }
            }
            qWalletCommonJsPlugin.dochooseQQFriendsForTransferResult(null);
        }
    }

    /* loaded from: classes35.dex */
    class GetAllContactTask extends AsyncTask<Void, Void, String> {
        GetAllContactTask() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public String doInBackground(Void... voidArr) {
            JSONObject allContact = QWalletCommonJsPlugin.this.getAllContact();
            if (allContact != null) {
                return allContact.toString();
            }
            return null;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public void onPostExecute(String str) {
            QWalletCommonJsPlugin.this.doCallback(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes35.dex */
    public static class MyResultRecevicer extends ResultReceiver {
        protected QWalletCommonJsPlugin mJsPlugin;

        public MyResultRecevicer(QWalletCommonJsPlugin qWalletCommonJsPlugin, Handler handler) {
            super(handler);
            this.mJsPlugin = qWalletCommonJsPlugin;
        }

        @Override // android.os.ResultReceiver
        protected void onReceiveResult(int i3, Bundle bundle) {
            String str;
            super.onReceiveResult(i3, bundle);
            if (QLog.isColorLevel()) {
                QLog.i(QWalletCommonJsPlugin.TAG, 2, "resultCode = " + i3 + " resultData = " + bundle);
            }
            if (this.mJsPlugin == null || bundle == null) {
                return;
            }
            String string = bundle.getString("detail");
            if (TextUtils.isEmpty(QWalletCommonJsPlugin.mParamForGarpHb) && !TextUtils.isEmpty(QWalletCommonJsPlugin.mListid)) {
                QWalletCommonJsPlugin.mParamForGarpHb = ((ITenCookie) QRoute.api(ITenCookie.class)).getTempArgs(QWalletCommonJsPlugin.mListid);
            }
            if (i3 == 0) {
                JSONObject jSONObject = new JSONObject();
                try {
                    if (!TextUtils.isEmpty(QWalletCommonJsPlugin.mParamForGarpHb)) {
                        jSONObject.put("param", QWalletCommonJsPlugin.mParamForGarpHb);
                    }
                    if (!TextUtils.isEmpty(string)) {
                        jSONObject.put("detail", string);
                    }
                    str = jSONObject.toString();
                } catch (JSONException e16) {
                    e16.printStackTrace();
                }
                this.mJsPlugin.doCallback(str);
            }
            str = "";
            this.mJsPlugin.doCallback(str);
        }
    }

    /* loaded from: classes35.dex */
    class SelectContactTask extends AsyncTask<String, Void, String> {
        SelectContactTask() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public String doInBackground(String... strArr) {
            JSONObject selectContact = QWalletCommonJsPlugin.this.getSelectContact(strArr[0]);
            if (selectContact != null) {
                return selectContact.toString();
            }
            return null;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public void onPostExecute(String str) {
            QWalletCommonJsPlugin.this.doCallback(str);
        }
    }

    private void checkWebankPermission() {
        Bundle bundle = new Bundle();
        bundle.putInt("pay_requestcode", 13);
        Intent payBridgeIntent = ((IQWalletApi) QRoute.api(IQWalletApi.class)).getPayBridgeIntent(this.mContext);
        payBridgeIntent.putExtras(bundle);
        startActivityForResult(payBridgeIntent, (byte) 17);
    }

    private void chooseQQFriendsForTransfer(String str) {
        WebViewPlugin.b bVar = this.mRuntime;
        if (bVar == null) {
            return;
        }
        Activity a16 = bVar.a();
        if (a16 != null && !TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                String optString = jSONObject.optString("title", HardCodeUtil.qqStr(R.string.rk7));
                int optInt = jSONObject.optInt("type", 1);
                this.mCallback = jSONObject.optString("callback");
                boolean z16 = (optInt & 1) != 0;
                boolean z17 = (optInt & 2) != 0;
                if (this.aioChoFriReceiver == null) {
                    this.aioChoFriReceiver = new ChooseQQFriendForTransferReceiver(this, new Handler());
                }
                Parcel obtain = Parcel.obtain();
                this.aioChoFriReceiver.writeToParcel(obtain, 0);
                obtain.setDataPosition(0);
                ResultReceiver resultReceiver = (ResultReceiver) ResultReceiver.CREATOR.createFromParcel(obtain);
                OaidMonitor.parcelRecycle(obtain);
                Intent intent = new Intent(a16, (Class<?>) ForwardRecentActivity.class);
                intent.putExtra("forward_type", 15);
                intent.putExtra("choose_friend_title", optString);
                intent.putExtra("choose_friend_is_qqfriends", z16);
                intent.putExtra("choose_friend_is_contacts", z17);
                intent.putExtra("choose_friend_callback", resultReceiver);
                super.startActivityForResult(intent, REQUESTCODE_TRANSFER_CHOOSE);
                return;
            } catch (JSONException e16) {
                e16.printStackTrace();
                dochooseQQFriendsForTransferResult(null);
                return;
            }
        }
        dochooseQQFriendsForTransferResult(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doCallback(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        callJs(str, str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x002e, code lost:
    
        if (r7.moveToFirst() != false) goto L10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x0030, code lost:
    
        r0 = r7.getColumnIndex("display_name");
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x0037, code lost:
    
        if (r0 < 0) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x0039, code lost:
    
        r0 = r7.getString(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x0041, code lost:
    
        if (android.text.TextUtils.isEmpty(r0) == false) goto L15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x0045, code lost:
    
        r0 = trimPhoneName(r0);
        r8 = r7.getColumnIndex("has_phone_number");
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x0050, code lost:
    
        if (r8 < 0) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x0056, code lost:
    
        if (r7.getInt(r8) <= 0) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x0058, code lost:
    
        r8 = r7.getColumnIndex("_id");
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x005f, code lost:
    
        if (r8 < 0) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x0061, code lost:
    
        r8 = r7.getString(r8);
        r4 = com.tencent.qmethod.pandoraex.monitor.ContactsMonitor.query(r17.mContext.getContentResolver(), android.provider.ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null, "contact_id = " + r8, null, null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x0086, code lost:
    
        if (r4 == null) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x008c, code lost:
    
        if (r4.moveToFirst() == false) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x008e, code lost:
    
        r8 = r4.getColumnIndex(com.tencent.mobileqq.msf.core.stepcount.StepCounterConstants.BEACON_PARAM_KEY_DATA1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x0095, code lost:
    
        if (r8 < 0) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x0097, code lost:
    
        r8 = r4.getString(r8);
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x009f, code lost:
    
        if (android.text.TextUtils.isEmpty(r8) == false) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x00a2, code lost:
    
        r8 = trimPhoneNumPre(r8);
        r9 = new org.json.JSONObject();
        r9.put("name", r0);
        r9.put("number", r8);
        r6.mo162put(r9);
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x00be, code lost:
    
        if (r4.moveToNext() != false) goto L105;
     */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x00c0, code lost:
    
        if (r4 == null) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:88:0x00c2, code lost:
    
        r4.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x00c9, code lost:
    
        if (r7.moveToNext() != false) goto L103;
     */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0115 A[Catch: Exception -> 0x0119, TRY_ENTER, TRY_LEAVE, TryCatch #3 {Exception -> 0x0119, blocks: (B:12:0x00ef, B:30:0x0115), top: B:6:0x0018 }] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x010a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x012e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:51:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0123 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public JSONObject getAllContact() {
        Throwable th5;
        Cursor cursor;
        Cursor cursor2 = null;
        if (this.mContext == null) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        JSONArray jSONArray = new JSONArray();
        try {
            try {
                Cursor query = ContactsMonitor.query(this.mContext.getContentResolver(), ContactsContract.Contacts.CONTENT_URI, null, null, null, null);
                if (query != null) {
                    try {
                    } catch (Exception e16) {
                        e = e16;
                        cursor = cursor2;
                        cursor2 = query;
                        try {
                            e.printStackTrace();
                            try {
                                jSONObject.put("list", jSONArray);
                                jSONObject.put("code", -1);
                            } catch (JSONException e17) {
                                e17.printStackTrace();
                                if (cursor2 != null) {
                                    try {
                                        cursor2.close();
                                    } catch (Exception e18) {
                                        e18.printStackTrace();
                                    }
                                }
                                if (cursor != null) {
                                    cursor.close();
                                }
                                return jSONObject;
                            }
                            if (cursor2 != null) {
                            }
                            if (cursor != null) {
                            }
                            return jSONObject;
                        } catch (Throwable th6) {
                            th5 = th6;
                            if (cursor2 != null) {
                                try {
                                    cursor2.close();
                                } catch (Exception e19) {
                                    e19.printStackTrace();
                                }
                            }
                            if (cursor == null) {
                                try {
                                    cursor.close();
                                    throw th5;
                                } catch (Exception e26) {
                                    e26.printStackTrace();
                                    throw th5;
                                }
                            }
                            throw th5;
                        }
                    } catch (Throwable th7) {
                        th5 = th7;
                        cursor = cursor2;
                        cursor2 = query;
                        if (cursor2 != null) {
                        }
                        if (cursor == null) {
                        }
                    }
                }
                jSONObject.put("list", jSONArray);
                jSONObject.put("code", 0);
                if (query != null) {
                    try {
                        query.close();
                    } catch (Exception e27) {
                        e27.printStackTrace();
                    }
                }
            } catch (Exception e28) {
                e = e28;
                cursor = null;
            } catch (Throwable th8) {
                th5 = th8;
                cursor = null;
            }
            if (cursor2 != null) {
                cursor2.close();
            }
        } catch (Exception e29) {
            e29.printStackTrace();
        }
        return jSONObject;
    }

    private void getAppAuthCode(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        long uptimeMillis = SystemClock.uptimeMillis();
        long j3 = this.mLastAuthCodeReqTime;
        if (uptimeMillis <= j3 || uptimeMillis - j3 >= 200) {
            this.mLastAuthCodeReqTime = uptimeMillis;
            this.mReqAuthCodeStartTime = uptimeMillis;
            try {
                String optString = new JSONObject(str).optString("appid");
                if (TextUtils.isEmpty(optString)) {
                    return;
                }
                this.mAuthCodeAppId = Long.valueOf(optString).longValue();
                WebViewPlugin.b bVar = this.mRuntime;
                String currentAccountUin = (bVar == null || bVar.b() == null) ? null : this.mRuntime.b().getCurrentAccountUin();
                if (TextUtils.isEmpty(currentAccountUin)) {
                    sendAuthCodeReq();
                    return;
                }
                final String str2 = this.mRuntime.a().getFilesDir() + "/QWallet/cache_ac_" + currentAccountUin;
                if (!new File(str2).exists()) {
                    sendAuthCodeReq();
                    return;
                }
                ExecutorService executorService = this.executorService;
                if (executorService == null || executorService.isShutdown()) {
                    this.executorService = ProxyExecutors.newFixedThreadPool(1);
                }
                this.executorService.execute(new Runnable() { // from class: com.tencent.mobileqq.vaswebviewplugin.QWalletCommonJsPlugin.2
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            byte[] readFile = FileUtils.readFile(str2);
                            if (readFile == null) {
                                QWalletCommonJsPlugin.this.sendAuthCodeReq();
                                return;
                            }
                            JceInputStream jceInputStream = new JceInputStream(readFile);
                            AuthCodeRsp authCodeRsp = new AuthCodeRsp();
                            authCodeRsp.readFrom(jceInputStream);
                            long serverTimeMillis = NetConnInfoCenter.getServerTimeMillis() / 1000;
                            if (authCodeRsp.items != null) {
                                for (int i3 = 0; i3 < authCodeRsp.items.size(); i3++) {
                                    if (authCodeRsp.items.get(i3) != null && authCodeRsp.items.get(i3).appid == QWalletCommonJsPlugin.this.mAuthCodeAppId && authCodeRsp.items.get(i3).expireTime > serverTimeMillis) {
                                        QWalletCommonJsPlugin qWalletCommonJsPlugin = QWalletCommonJsPlugin.this;
                                        qWalletCommonJsPlugin.doAuthCodeCallback(qWalletCommonJsPlugin.mCallback, authCodeRsp.items.get(i3));
                                        authCodeRsp.items.remove(i3);
                                        if (authCodeRsp.items.size() <= 0) {
                                            new File(str2).delete();
                                            return;
                                        }
                                        JceOutputStream jceOutputStream = new JceOutputStream();
                                        authCodeRsp.writeTo(jceOutputStream);
                                        FileUtils.writeFile(jceOutputStream.toByteArray(), str2);
                                        return;
                                    }
                                }
                            }
                            QWalletCommonJsPlugin.this.sendAuthCodeReq();
                        } catch (Exception unused) {
                            QWalletCommonJsPlugin.this.sendAuthCodeReq();
                        }
                    }
                });
            } catch (NumberFormatException e16) {
                e16.printStackTrace();
            } catch (JSONException e17) {
                e17.printStackTrace();
            }
        }
    }

    private JSONObject getSecurityPayIsOpenJson() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("isSecurityPayOpen", isSecurityPayOpen());
        } catch (JSONException e16) {
            e16.printStackTrace();
        }
        return jSONObject;
    }

    private void handleMiniApp(String str, int i3, int i16) {
        if (i3 == 20 && i16 == 1) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.optInt("action") == 1) {
                    String optString = jSONObject.optString(PreloadingFragment.KEY_APPID);
                    JSONObject jSONObject2 = new JSONObject();
                    if (MiniAppLauncher.launchMiniApp(this.mContext, optString, 1201)) {
                        jSONObject2.put("result_code", 0);
                    } else {
                        jSONObject2.put("result_code", 1);
                    }
                    doCallback(jSONObject2.toString());
                }
            } catch (Exception e16) {
                e16.printStackTrace();
                try {
                    JSONObject jSONObject3 = new JSONObject();
                    jSONObject3.put("result_code", 1);
                    doCallback(jSONObject3.toString());
                } catch (Throwable unused) {
                }
            }
        }
    }

    private boolean handleOpenContact() {
        Activity a16 = this.mRuntime.a();
        if (a16 instanceof AppActivity) {
            AppActivity appActivity = (AppActivity) a16;
            if (appActivity.checkSelfPermission(QQPermissionConstants.Permission.READ_CONTACTS) != 0) {
                appActivity.requestPermissions(this.mOpenContactCallBack, 1, QQPermissionConstants.Permission.READ_CONTACTS);
            } else {
                openContact();
            }
        } else {
            callJs(this.mCallback, "false", "no record activity");
        }
        return true;
    }

    private void handleQQShop(String str) {
        if (TextUtils.isEmpty(str)) {
            QLog.d(TAG, 1, "-->handleQQShop extstr is null");
            return;
        }
        try {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 1, "extstr:" + str);
            }
            JSONObject jSONObject = new JSONObject(str);
            String optString = jSONObject.optString("action");
            if ("isTop".equals(optString)) {
                EIPCResult callServer = BinderMethodProxy.callServer(QIPCClientHelper.getInstance().getClient(), "EcshopIPCModule", "queryPublicAccountTop", null);
                if (callServer != null) {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("retcode", 0);
                    jSONObject2.put("retmsg", "success");
                    jSONObject2.put("isTop", callServer.code);
                    doCallback(jSONObject2.toString());
                    return;
                }
                return;
            }
            if ("setTop".equals(optString)) {
                int optInt = jSONObject.optInt("isTop", -1);
                JSONObject jSONObject3 = new JSONObject();
                if (optInt != 1 && optInt != 0) {
                    jSONObject3.put("retcode", 1);
                    jSONObject3.put("retmsg", "isTop error");
                    doCallback(jSONObject3.toString());
                    QLog.d(TAG, 1, "notifyViewUpdate -->handleQQShop error,extstr:" + str);
                    return;
                }
                Bundle bundle = new Bundle();
                bundle.putInt("isTop", optInt);
                if (BinderMethodProxy.callServer(QIPCClientHelper.getInstance().getClient(), "EcshopIPCModule", "setPublicAccountTop", bundle) != null) {
                    jSONObject3.put("retcode", 0);
                    jSONObject3.put("retmsg", "success");
                    doCallback(jSONObject3.toString());
                    return;
                }
                return;
            }
            if ("openShopAccount".equals(optString)) {
                Bundle bundle2 = new Bundle();
                bundle2.putInt("shouldOpenCard", jSONObject.optInt("shouldOpenCard"));
                JSONObject optJSONObject = jSONObject.optJSONObject("qggExt");
                if (optJSONObject != null) {
                    bundle2.putString("qggExt", optJSONObject.toString());
                }
                if (BinderMethodProxy.callServer(QIPCClientHelper.getInstance().getClient(), "EcshopIPCModule", "startQQShopPublicAccount", bundle2) != null) {
                    JSONObject jSONObject4 = new JSONObject();
                    jSONObject4.put("retcode", 0);
                    jSONObject4.put("retmsg", "success");
                    doCallback(jSONObject4.toString());
                }
            }
        } catch (Throwable th5) {
            QLog.d(TAG, 1, "notifyViewUpdate -->handleQQShop error:" + th5.getMessage());
        }
    }

    private boolean isSecurityPayOpen() {
        Context context = this.mContext;
        if (context == null) {
            return false;
        }
        return bj.f(context);
    }

    private void jumpToUin(String str) {
        if (TextUtils.isEmpty(str)) {
            QLog.e(TAG, 1, "jumpToUin is empty");
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            WebViewPlugin.b bVar = this.mRuntime;
            if (bVar == null) {
                QLog.e(TAG, 1, "mRuntime is null");
                return;
            }
            Activity a16 = bVar.a();
            if (a16 != null && !a16.isFinishing()) {
                String optString = jSONObject.optString("uin");
                if (TextUtils.isEmpty(optString)) {
                    QLog.e(TAG, 1, "uin is empty");
                    return;
                }
                Intent m3 = BaseAIOUtils.m(new Intent(), null);
                m3.putExtra("uin", optString);
                m3.putExtra("uintype", 0);
                m3.putExtra("isBack2Root", true);
                RouteUtils.startActivity(a16, m3, RouterConstants.UI_ROUTER_SPLASH);
                return;
            }
            QLog.e(TAG, 1, "activity is null or finish");
        } catch (JSONException e16) {
            QLog.d(TAG, 1, "jumpToUin json error", e16);
        }
    }

    private void notifyViewUpdate(String str, String str2) {
        int optInt;
        int optInt2;
        String optString;
        try {
            JSONObject jSONObject = new JSONObject(str);
            optInt = jSONObject.optInt("bid");
            optInt2 = jSONObject.optInt("viewid");
            optString = jSONObject.optString("extstr");
        } catch (Exception e16) {
            e16.printStackTrace();
        }
        if (optInt == 2 || optInt == 4) {
            handleSkin(optString, optInt, optInt2);
            return;
        }
        if ((optInt == 3 && optInt2 == 1) || optInt == 5) {
            return;
        }
        if (optInt == 10) {
            String str3 = "";
            try {
                if (!TextUtils.isEmpty(optString)) {
                    JSONObject jSONObject2 = new JSONObject(optString);
                    String optString2 = jSONObject2.optString("listid");
                    String optString3 = jSONObject2.optString("feedsid");
                    String tempArgs = ((ITenCookie) QRoute.api(ITenCookie.class)).getTempArgs(optString2);
                    if (!TextUtils.isEmpty(optString3) && !TextUtils.isEmpty(tempArgs)) {
                        JSONObject jSONObject3 = new JSONObject(tempArgs);
                        String optString4 = jSONObject3.optString("feedsid");
                        if (!TextUtils.isEmpty(optString4) && optString3.equals(optString4)) {
                            JSONObject jSONObject4 = new JSONObject();
                            jSONObject4.put("amount", jSONObject3.optString("amount"));
                            jSONObject4.put("wishing", jSONObject3.optString("wishing"));
                            str3 = jSONObject4.toString();
                        }
                    }
                }
            } catch (Throwable th5) {
                th5.printStackTrace();
            }
            doCallback(str3);
            return;
        }
        if (optInt != 17 || optInt2 != 1) {
            if (optInt == 20 && optInt2 == 1) {
                handleMiniApp(optString, optInt, optInt2);
                return;
            }
            if (optInt == 21 && optInt2 == 1) {
                return;
            }
            if (optInt == 25 && optInt2 == 2) {
                handleQQShop(optString);
                return;
            }
            if (optInt == 22 && optInt2 == 1) {
                sendUIRefreshBroadcast(optInt, optInt2, optString);
                return;
            }
            if (optInt == 25 && optInt2 == 1) {
                sendUIRefreshBroadcast(optInt, optInt2, optString);
                return;
            }
            if (optInt == 26) {
                doCallback(((IQWalletHomeApi) QRoute.api(IQWalletHomeApi.class)).getH5RedPointsAsJson());
                return;
            } else if (optInt == 27) {
                ((IQWalletHomeApi) QRoute.api(IQWalletHomeApi.class)).onH5RedPointClick(optString);
                return;
            } else {
                if (optInt == 28) {
                    ((IQWalletHomeApi) QRoute.api(IQWalletHomeApi.class)).onH5TechReport(this.mRuntime.e().getUrl(), optString);
                    return;
                }
                return;
            }
        }
        try {
            if (TextUtils.isEmpty(optString)) {
                return;
            }
            JSONObject jSONObject5 = new JSONObject(optString);
            String optString5 = jSONObject5.optString("listid");
            String optString6 = jSONObject5.optString("uin");
            String optString7 = jSONObject5.optString("offset");
            String optString8 = jSONObject5.optString("limit");
            if (!TextUtils.isEmpty(optString6) && optString6.equals(this.app.getCurrentAccountUin()) && !TextUtils.isEmpty(optString5)) {
                mListid = optString5;
                mParamForGarpHb = ((ITenCookie) QRoute.api(ITenCookie.class)).getTempArgs(optString5);
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, "paramForGarpHb paramForGarpHb:" + mParamForGarpHb);
                }
                if (!TextUtils.isEmpty(mParamForGarpHb)) {
                    JSONObject jSONObject6 = new JSONObject(mParamForGarpHb);
                    JSONObject jSONObject7 = new JSONObject();
                    jSONObject7.put("listid", optString5);
                    jSONObject7.put("uin", optString6);
                    jSONObject7.put("offset", optString7);
                    jSONObject7.put("limit", optString8);
                    jSONObject7.put("authkey", jSONObject6.optString("authkey"));
                    jSONObject7.put("grouptype", jSONObject6.optString("grouptype"));
                    jSONObject7.put(FSPublishConstants.FSPublishJsBridge.JSON_OBJECT_KEY_GROUP_ID, jSONObject6.optString(FSPublishConstants.FSPublishJsBridge.JSON_OBJECT_KEY_GROUP_ID));
                    jSONObject7.put(HippyHeaderListViewController.VIEW_TAG, "redgiftDetail");
                    getHbDetail(this.app, jSONObject7.toString(), this.mRecevicer);
                    return;
                }
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, "paramForGarpHb is null");
                    return;
                }
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "notifyViewUpdate extstr = " + optString);
                return;
            }
            return;
        } catch (Throwable th6) {
            th6.printStackTrace();
            return;
        }
        e16.printStackTrace();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void openContact() {
        Intent intent = new Intent();
        intent.setAction("android.intent.action.PICK");
        intent.setData(ContactsContract.Contacts.CONTENT_URI);
        super.startActivityForResult(intent, RegisterType.UNINIT_REF);
    }

    private void parseCallback(String str) {
        if (TextUtils.isEmpty(str) || str.toLowerCase().indexOf("callback") < 0) {
            return;
        }
        try {
            this.mCallback = new JSONObject(str).optString("callback");
        } catch (JSONException e16) {
            e16.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reportAuthCode(final String str, final long j3, final long j16) {
        final CustomWebView e16 = this.mRuntime.e();
        e16.post(new Runnable() { // from class: com.tencent.mobileqq.vaswebviewplugin.QWalletCommonJsPlugin.4
            /* JADX WARN: Removed duplicated region for block: B:13:0x002f  */
            /* JADX WARN: Removed duplicated region for block: B:9:0x002a  */
            @Override // java.lang.Runnable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public void run() {
                String str2;
                String encode;
                String str3;
                String str4;
                int i3;
                long j17;
                long j18 = j16;
                CustomWebView customWebView = e16;
                if (customWebView == null) {
                    str2 = "";
                } else {
                    str2 = customWebView.getUrl();
                }
                if (!TextUtils.isEmpty(str2)) {
                    try {
                        encode = URLEncoder.encode(str2, "utf-8");
                    } catch (UnsupportedEncodingException e17) {
                        e17.printStackTrace();
                    }
                    str3 = str;
                    if (TextUtils.isEmpty(str3)) {
                        str4 = str3;
                        i3 = 3;
                        j17 = j18;
                    } else {
                        i3 = 4;
                        j17 = 0;
                        str4 = "";
                    }
                    DcReportUtil.c(null, "dc01021", "" + i3 + QbAddrData.DATA_SPLITER + str4 + QbAddrData.DATA_SPLITER + encode + QbAddrData.DATA_SPLITER + "2|" + j3 + "|||" + j17, false);
                }
                encode = "";
                str3 = str;
                if (TextUtils.isEmpty(str3)) {
                }
                DcReportUtil.c(null, "dc01021", "" + i3 + QbAddrData.DATA_SPLITER + str4 + QbAddrData.DATA_SPLITER + encode + QbAddrData.DATA_SPLITER + "2|" + j3 + "|||" + j17, false);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendAuthCodeReq() {
        Bundle bundle = new Bundle();
        bundle.putLong("appId", this.mAuthCodeAppId);
        ((IWebIPCOperatorApi) QRoute.api(IWebIPCOperatorApi.class)).sendServiceIpcReq(com.tencent.mobileqq.emosm.a.a("qwallet_getAuthCode", this.mCallback, this.mOnRemoteResp.key, bundle));
    }

    private void sendUIRefreshBroadcast(int i3, int i16, String str) {
        Intent intent = new Intent(ACTION_NOTIFY_VIEW_UPDATE);
        intent.putExtra("businessId", i3);
        intent.putExtra("viewId", i16);
        intent.putExtra("extstr", str);
        this.mContext.sendBroadcast(intent);
    }

    protected void doAuthCodeCallback(final String str, final AuthCodeItem authCodeItem) {
        final long uptimeMillis = SystemClock.uptimeMillis() - this.mReqAuthCodeStartTime;
        final CustomWebView e16 = this.mRuntime.e();
        e16.post(new Runnable() { // from class: com.tencent.mobileqq.vaswebviewplugin.QWalletCommonJsPlugin.3
            @Override // java.lang.Runnable
            public void run() {
                try {
                    JSONObject jSONObject = new JSONObject();
                    if (authCodeItem != null) {
                        long j3 = QWalletCommonJsPlugin.this.mAuthCodeAppId;
                        AuthCodeItem authCodeItem2 = authCodeItem;
                        if (j3 == authCodeItem2.appid) {
                            boolean z16 = true;
                            if (!TextUtils.isEmpty(authCodeItem2.urlDomain)) {
                                String[] split = (authCodeItem.urlDomain + "|#").split("\\|");
                                String host = Uri.parse(e16.getUrl()).getHost();
                                if (!TextUtils.isEmpty(host)) {
                                    String lowerCase = host.toLowerCase();
                                    int i3 = 0;
                                    while (i3 < split.length - 1 && !lowerCase.contains(split[i3])) {
                                        i3++;
                                    }
                                    if (i3 >= split.length - 1) {
                                        z16 = false;
                                    }
                                }
                            }
                            if (z16) {
                                jSONObject.put("code", authCodeItem.authCode);
                                QWalletCommonJsPlugin.this.doCallback(str, jSONObject.toString());
                                QWalletCommonJsPlugin qWalletCommonJsPlugin = QWalletCommonJsPlugin.this;
                                qWalletCommonJsPlugin.reportAuthCode(authCodeItem.authCode, qWalletCommonJsPlugin.mAuthCodeAppId, uptimeMillis);
                                return;
                            }
                        }
                    }
                    jSONObject.put("code", "");
                    QWalletCommonJsPlugin.this.doCallback(str, jSONObject.toString());
                    QWalletCommonJsPlugin qWalletCommonJsPlugin2 = QWalletCommonJsPlugin.this;
                    qWalletCommonJsPlugin2.reportAuthCode(null, qWalletCommonJsPlugin2.mAuthCodeAppId, uptimeMillis);
                } catch (JSONException e17) {
                    e17.printStackTrace();
                }
            }
        });
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public String getNameSpace() {
        return PLUGIN_NAMESPACE;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.vaswebviewplugin.VasBasePlugin
    public long getPluginBusiness() {
        return 2415919104L;
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public long getWebViewEventByNameSpace(String str) {
        return 2L;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.vaswebviewplugin.VasWebviewJsPlugin, com.tencent.mobileqq.webview.swift.WebViewPlugin
    public boolean handleEvent(String str, long j3, Map<String, Object> map) {
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "handleEvent, type=" + j3);
        }
        if (j3 == 8589934610L || j3 == 8589934601L) {
            QWVideoJsPlugin qWVideoJsPlugin = this.mVideoJsPlugin;
            if (qWVideoJsPlugin != null && qWVideoJsPlugin.stopPlay(qWVideoJsPlugin.mVid)) {
                if (QLog.isColorLevel()) {
                    QLog.i(TAG, 2, "handleEvent_Back,stopVideo:" + this.mVideoJsPlugin.mVid);
                }
                return true;
            }
        } else if (j3 != 8589934611L) {
            if (j3 == 8589934597L) {
                QWVideoJsPlugin qWVideoJsPlugin2 = this.mVideoJsPlugin;
                if (qWVideoJsPlugin2 != null) {
                    qWVideoJsPlugin2.resumeOrPause(false, false);
                }
            } else if (j3 == 2) {
                QWVideoJsPlugin qWVideoJsPlugin3 = this.mVideoJsPlugin;
                if (qWVideoJsPlugin3 != null) {
                    qWVideoJsPlugin3.resumeOrPause(true, false);
                }
            } else {
                if (j3 == 8589934619L) {
                    JSONObject jSONObject = new JSONObject();
                    if (map != null) {
                        try {
                            jSONObject.put("action", (Integer) map.get("action"));
                        } catch (ClassCastException e16) {
                            if (QLog.isColorLevel()) {
                                QLog.d(TAG, 2, "action, " + map.get("action"));
                            }
                            e16.printStackTrace();
                        } catch (JSONException e17) {
                            e17.printStackTrace();
                        }
                    }
                    dispatchJsEvent("walletFeedsEvent", jSONObject, null);
                    return true;
                }
                if (j3 == 8589934620L) {
                    JSONObject jSONObject2 = new JSONObject();
                    if (map != null) {
                        try {
                            jSONObject2.put("action", (Integer) map.get("action"));
                            jSONObject2.put("height", (Integer) map.get("height"));
                            jSONObject2.put("sHeight", (Integer) map.get("sHeight"));
                        } catch (ClassCastException e18) {
                            e18.printStackTrace();
                        } catch (JSONException e19) {
                            e19.printStackTrace();
                        }
                    }
                    dispatchJsEvent("walletFeedsEvent", jSONObject2, null);
                    return true;
                }
            }
        }
        return super.handleEvent(str, j3, map);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public boolean handleJsRequest(JsBridgeListener jsBridgeListener, String str, String str2, String str3, String... strArr) {
        if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3) && this.mContext != null) {
            String str4 = str2 + "_" + str3;
            if (strArr.length > 0) {
                parseCallback(strArr[0]);
            }
            if ("qw_charge_getSelectContact".equals(str4)) {
                handleOpenContact();
                return true;
            }
            if ("qw_charge_getAllContact".equals(str4)) {
                Activity a16 = this.mRuntime.a();
                if (a16 instanceof AppActivity) {
                    QQPermission qQPermission = QQPermissionFactory.getQQPermission(a16, new BusinessConfig(QQPermissionConstants.Business.ID.QQ_QWALLET, QQPermissionConstants.Business.SCENE.QWALLET_JS_BRIDGE_GET_CONTACTS));
                    if (qQPermission == null) {
                        callJs(this.mCallback, "false", "request permissions error");
                    } else if (qQPermission.hasPermission(QQPermissionConstants.Permission.READ_CONTACTS) != 0) {
                        qQPermission.requestPermissions(new String[]{QQPermissionConstants.Permission.READ_CONTACTS}, 2, this.mGetAllContactCallBack);
                    } else {
                        new GetAllContactTask().execute(new Void[0]);
                    }
                } else {
                    callJs(this.mCallback, "false", "no record activity");
                }
                return true;
            }
            if ("qw_charge_gotoQWalletHome".equals(str4)) {
                WebViewPlugin.b bVar = this.mRuntime;
                if (bVar != null && bVar.a() != null) {
                    ((IQWalletHelper) QRoute.api(IQWalletHelper.class)).gotoQWalletHome(this.mRuntime.a());
                }
                return true;
            }
            if ("qw_charge_qqpimsecure_safe_isopen_securitypay".equals(str4)) {
                doCallback(getSecurityPayIsOpenJson().toString());
                return true;
            }
            if ("qw_charge_tenpayTransfer".equals(str4)) {
                if (strArr.length <= 0) {
                    chooseQQFriendsForTransfer(null);
                } else {
                    chooseQQFriendsForTransfer(strArr[0]);
                }
                return true;
            }
            if ("qw_charge_checkPermission".equals(str4)) {
                checkWebankPermission();
                return true;
            }
            if ("qw_charge_emojiPayResultOk".equals(str4)) {
                WebViewPlugin.b bVar2 = this.mRuntime;
                if (bVar2 != null && bVar2.a() != null) {
                    this.mRuntime.a().setResult(MtpConstants.RESPONSE_NO_VALID_OBJECT_INFO);
                    this.mRuntime.a().finish();
                }
                return true;
            }
            if ("qw_charge_getAppAuthorizationCode".equals(str4)) {
                if (strArr.length > 0) {
                    getAppAuthCode(strArr[0]);
                }
                return true;
            }
            if ("qw_charge_notifyViewUpdate".equals(str4)) {
                notifyViewUpdate(strArr[0], str);
                return true;
            }
        }
        return false;
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public void onActivityResult(Intent intent, byte b16, int i3) {
        String lastPathSegment;
        super.onActivityResult(intent, b16, i3);
        if (b16 == 16) {
            if (i3 != -1 || intent == null || intent.getData() == null || (lastPathSegment = intent.getData().getLastPathSegment()) == null || lastPathSegment.length() <= 0) {
                return;
            }
            this.mContactId = lastPathSegment;
            Activity a16 = this.mRuntime.a();
            if (a16 instanceof AppActivity) {
                AppActivity appActivity = (AppActivity) a16;
                if (appActivity.checkSelfPermission(QQPermissionConstants.Permission.READ_CONTACTS) != 0) {
                    appActivity.requestPermissions(this.mGetSelectContactCallBack, 2, QQPermissionConstants.Permission.READ_CONTACTS);
                    return;
                } else {
                    new SelectContactTask().execute(lastPathSegment);
                    return;
                }
            }
            callJs(this.mCallback, "false", "no record activity");
            return;
        }
        if (b16 == REQUESTCODE_TRANSFER_CHOOSE) {
            if (intent == null) {
                dochooseQQFriendsForTransferResult(null);
                return;
            } else {
                dochooseQQFriendsForTransferResult(intent.getStringExtra("result"));
                return;
            }
        }
        if (b16 == REQUESTCODE_TRANSFER) {
            if (intent == null) {
                dochooseQQFriendsForTransferResult(null);
                return;
            }
            String stringExtra = intent.getStringExtra("result");
            dochooseQQFriendsForTransferResult(stringExtra);
            jumpToUin(stringExtra);
            return;
        }
        if (b16 == 17) {
            if (intent == null) {
                intent = new Intent();
            }
            JSONObject jSONObject = new JSONObject();
            try {
                int intExtra = intent.getIntExtra("retCode", 0);
                String stringExtra2 = intent.getStringExtra("card_status");
                String stringExtra3 = intent.getStringExtra("available_amount");
                String stringExtra4 = intent.getStringExtra("overdue_amount");
                jSONObject.put("retCode", intExtra);
                JSONObject jSONObject2 = new JSONObject();
                if (stringExtra2 == null) {
                    stringExtra2 = "0";
                }
                jSONObject2.put("card_status", stringExtra2);
                if (stringExtra3 == null) {
                    stringExtra3 = "0";
                }
                jSONObject2.put("available_amount", stringExtra3);
                if (stringExtra4 == null) {
                    stringExtra4 = "0";
                }
                jSONObject2.put("overdue_amount", stringExtra4);
                jSONObject.put("data", jSONObject2);
                doCallback(jSONObject.toString());
            } catch (JSONException e16) {
                e16.printStackTrace();
                doCallback("{'retCode':-1,data:{}}");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.vaswebviewplugin.VasWebviewJsPlugin, com.tencent.mobileqq.vaswebviewplugin.VasBasePlugin, com.tencent.mobileqq.webview.swift.WebViewPlugin
    public void onCreate() {
        Activity a16;
        super.onCreate();
        WebViewPlugin.b bVar = this.mRuntime;
        if (bVar == null || (a16 = bVar.a()) == null) {
            return;
        }
        this.app = this.mRuntime.b();
        Context applicationContext = a16.getApplicationContext();
        this.mContext = applicationContext;
        this.mVideoJsPlugin = new QWVideoJsPlugin(applicationContext, this, this.mRuntime.b());
        try {
            IntentFilter intentFilter = new IntentFilter(IECScreenReceiver.ACTION_SCREEN_ON);
            intentFilter.addAction(IECScreenReceiver.ACTION_SCREEN_OFF);
            intentFilter.addAction("android.intent.action.USER_PRESENT");
            a16.registerReceiver(this.mScreenReceiver, intentFilter);
        } catch (Exception e16) {
            QLog.e(TAG, 1, "onCreate: ", e16);
        }
        this.mRecevicer = new MyResultRecevicer(this, new Handler());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.vaswebviewplugin.VasWebviewJsPlugin, com.tencent.mobileqq.webview.swift.WebViewPlugin
    public void onDestroy() {
        Activity a16;
        WebViewPlugin.b bVar = this.mRuntime;
        if (bVar != null && (a16 = bVar.a()) != null) {
            try {
                a16.unregisterReceiver(this.mScreenReceiver);
            } catch (Exception e16) {
                QLog.e(TAG, 1, "onDestroy: unregisterReceiver", e16);
            }
        }
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.vaswebviewplugin.VasWebviewJsPlugin
    public void onResponse(Bundle bundle) {
        Bundle bundle2;
        AuthCodeRsp authCodeRsp;
        ArrayList<AuthCodeItem> arrayList;
        if (QLog.isDevelopLevel()) {
            QLog.i(TAG, 4, "onResponse i:" + toString());
        }
        if (this.mRuntime == null || bundle == null || bundle.getInt("respkey", -1) != this.mOnRemoteResp.key) {
            return;
        }
        String string = bundle.getString("callbackid");
        String string2 = bundle.getString("cmd");
        if (TextUtils.isEmpty(string2) || string2.compareTo("qwallet_getAuthCode") != 0 || (bundle2 = bundle.getBundle("response")) == null) {
            return;
        }
        int i3 = bundle2.getInt("qwallet.type");
        boolean z16 = bundle2.getBoolean("qwallet.isSuccess");
        Serializable serializable = bundle2.getSerializable("qwallet.data");
        if (i3 != 4 || this.mAuthCodeAppId == 0) {
            return;
        }
        doAuthCodeCallback(string, (!z16 || serializable == null || !(serializable instanceof AuthCodeRsp) || (arrayList = (authCodeRsp = (AuthCodeRsp) serializable).items) == null || arrayList.size() <= 0) ? null : authCodeRsp.items.get(0));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public void onWebViewCreated(CustomWebView customWebView) {
        super.onWebViewCreated(customWebView);
        QWVideoJsPlugin qWVideoJsPlugin = this.mVideoJsPlugin;
        if (qWVideoJsPlugin != null) {
            qWVideoJsPlugin.onWebViewCreated(this.mRuntime);
        }
    }

    void startTransactionActivity(String str, String str2) {
        Intent intent = new Intent();
        intent.putExtra("come_from", 2);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(IProfileProtocolConst.PARAM_TARGET_UIN, str);
            jSONObject.put("targetNickname", str2);
            jSONObject.put("sign", "");
        } catch (JSONException e16) {
            e16.printStackTrace();
        }
        intent.putExtra("extra_data", jSONObject.toString());
        intent.putExtra(j.T0, "appid#20000001|bargainor_id#1000026901|channel#wallet");
        intent.putExtra("isJumpToH5", false);
        WebViewPlugin.b bVar = this.mRuntime;
        Context a16 = bVar != null ? bVar.a() : null;
        if (a16 == null) {
            a16 = this.mContext;
        }
        RouteUtils.startActivityForResult(a16, intent, "/qwallet/transaction", AbsBaseWebViewActivity.switchRequestCodeImpl(this, REQUESTCODE_TRANSFER));
    }

    public String trimPhoneName(String str) {
        String str2 = "";
        if (str == null || str.equals("")) {
            return "";
        }
        int i3 = 0;
        int i16 = 0;
        while (i3 < str.length()) {
            if (i16 >= 10) {
                return str2 + MiniBoxNoticeInfo.APPNAME_SUFFIX;
            }
            int i17 = i3 + 1;
            String substring = str.substring(i3, i17);
            i16 = substring.matches("[\u0391-\uffe5]") ? i16 + 2 : i16 + 1;
            str2 = str2 + substring;
            i3 = i17;
        }
        return str2;
    }

    public String trimPhoneNumPre(String str) {
        if (str == null || str.equals("")) {
            return "";
        }
        if (str.contains("+86")) {
            if (str.length() == 3) {
                return "";
            }
            if (str.length() > 3 && str.startsWith("+86")) {
                str = str.substring(3);
            }
        }
        String trim = Pattern.compile("[^0-9]").matcher(str).replaceAll("").trim();
        return trim.length() > 11 ? trim.subSequence(trim.length() - 11, trim.length()).toString() : trim;
    }

    /* loaded from: classes35.dex */
    public class QWVideoJsPlugin implements Handler.Callback, MediaPlayer.OnPreparedListener, MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener {
        static final String ACTION_DOWNLOAD = "downloadVideo";
        static final String ACTION_INIT = "initVideo";
        static final String ACTION_ISVIDEOEXIST = "isExistVideo";
        static final String ACTION_PAUSE = "pauseVideo";
        static final String ACTION_PLAY = "playVideo";
        static final String ACTION_STOP = "stopVideo";
        static final String KEY_DURATION = "videoDuration";
        static final String KEY_PLAYTIMEINTERVAL = "callbackInterval";
        static final String KEY_POS = "currentTime";
        static final String KEY_RESULTCODE = "resultCode";
        static final String KEY_RESULTMSG = "resultMsg";
        static final String KEY_STATUS = "videoStatus";
        static final String KEY_VID = "videoID";
        static final String KEY_VIDEOCFG = "videoConfig";
        static final String KEY_VIDEOURL = "downloadURLs";
        static final int MSG_PLAY_STATUS = 2;
        static final int MSG_PROGRESS = 1;
        static final int RESULTCODE_ERR = -1;
        static final int RESULTCODE_NO_MEM = -2;
        static final int RESULTCODE_OK = 0;
        static final int RSP_PLAYING = 2;
        static final int RSP_PLAY_END = 3;
        static final int RSP_PLAY_START = 1;
        static final int STATUS_END = 4;
        static final int STATUS_ERR = 5;
        static final int STATUS_PAUSE = 3;
        static final int STATUS_PLAYING = 2;
        static final int STATUS_READY = 1;
        static final int STATUS_UNKNOWN = 0;
        static final String TAG = "QWalletCommonJsPlugin";
        private Context mContext;
        WebViewPlugin mExtPlugin;
        private String mVid;
        private ViewGroup videoLayout;
        private ViewGroup videoParent;
        final HashMap<String, MyVideoView> mVideoViews = new HashMap<>();
        final HashMap<String, HashMap<String, String>> mCallbacks = new HashMap<>();
        private long mDelayMillis = 0;
        private Handler mHandler = new WeakReferenceHandler(this);

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes35.dex */
        public class MyVideoView extends QQVideoView {
            static final int FLAG_PAUSE_BY_USER = 4;
            static final int FLAG_PLAY = 3;
            static final int FLAG_READY = 2;
            static final int FLAG_RELEASE = 0;
            int mCurrTime;
            int playState;

            public MyVideoView(Context context) {
                super(context);
                this.playState = 0;
                this.mCurrTime = 0;
            }

            boolean testFlag(int i3) {
                return ((1 << i3) & this.playState) != 0;
            }

            @Override // com.tencent.mobileqq.widget.QQVideoView
            public void release() {
                this.playState = 0;
                this.mCurrTime = 0;
                super.release();
            }

            void setFlag(int i3, boolean z16) {
                if (z16) {
                    this.playState = (1 << i3) | this.playState;
                } else {
                    this.playState = (~(1 << i3)) & this.playState;
                }
            }
        }

        public QWVideoJsPlugin(Context context, WebViewPlugin webViewPlugin, AppInterface appInterface) {
            this.mContext = context;
            this.mExtPlugin = webViewPlugin;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void callbackJs(String str, String str2, JSONObject jSONObject) {
            String jSONObject2;
            String cacheCallback = getCacheCallback(str, str2);
            if (this.mExtPlugin != null && !TextUtils.isEmpty(cacheCallback)) {
                if (jSONObject != null) {
                    try {
                        jSONObject.put("videoID", str2);
                        jSONObject2 = jSONObject.toString();
                    } catch (JSONException e16) {
                        if (QLog.isColorLevel()) {
                            QLog.e(TAG, 2, "callbackJs,exc.", e16);
                        }
                    }
                    this.mExtPlugin.callJs(cacheCallback, jSONObject2);
                }
                jSONObject2 = "";
                this.mExtPlugin.callJs(cacheCallback, jSONObject2);
            }
            if (QLog.isColorLevel()) {
                QLog.i(TAG, 2, "callbackJs,action:" + str + ",cbId:" + cacheCallback + ",vid:" + str2 + ",cb_json:" + jSONObject);
            }
        }

        private String getCacheCallback(String str, String str2) {
            HashMap<String, String> hashMap = this.mCallbacks.get(str);
            if (hashMap != null) {
                return hashMap.get(str2);
            }
            return null;
        }

        private String getInnerVideoPath(String str) {
            IPreloadServiceProxy preloadManger = getPreloadManger();
            if (preloadManger == null) {
                return null;
            }
            return preloadManger.getVideoResPathByID(str);
        }

        private IPreloadServiceProxy getPreloadManger() {
            AppRuntime c16;
            WebViewPlugin.b bVar = QWalletCommonJsPlugin.this.mRuntime;
            if (bVar == null || (c16 = bVar.c()) == null) {
                return null;
            }
            return (IPreloadServiceProxy) c16.getRuntimeService(IPreloadServiceProxy.class, ProcessConstant.MULTI);
        }

        private void js_download(final String str, String str2, JSONObject jSONObject) {
            setCacheCallback(ACTION_DOWNLOAD, str, str2);
            String optString = jSONObject != null ? jSONObject.optString(KEY_VIDEOCFG) : null;
            IPreloadServiceProxy preloadManger = getPreloadManger();
            if (preloadManger == null) {
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jSONObject2.put("resultCode", -1);
                } catch (JSONException e16) {
                    QLog.e(TAG, 2, e16, new Object[0]);
                }
                callbackJs(ACTION_DOWNLOAD, str, jSONObject2);
                return;
            }
            preloadManger.downloadModule(str, optString, new IPreloadService.a() { // from class: com.tencent.mobileqq.vaswebviewplugin.QWalletCommonJsPlugin.QWVideoJsPlugin.1
                @Override // com.tencent.mobileqq.qwallet.preload.IPreloadService.a
                public void onDownloadResFinished(String str3, int i3, String str4, ResourceInfo resourceInfo) {
                    if (QLog.isColorLevel()) {
                        QLog.i(QWVideoJsPlugin.TAG, 2, "onDownloadVideoFinished,id:" + str3 + ",path:" + str4 + ", resInfo:" + resourceInfo);
                    }
                    if (resourceInfo == null || resourceInfo.type != 5) {
                        return;
                    }
                    JSONObject jSONObject3 = new JSONObject();
                    try {
                        jSONObject3.put("resultCode", i3 == 0 ? 0 : i3 == -4 ? -2 : -1);
                    } catch (JSONException e17) {
                        if (QLog.isColorLevel()) {
                            QLog.e(QWVideoJsPlugin.TAG, 2, e17, new Object[0]);
                        }
                    }
                    QWVideoJsPlugin.this.callbackJs(QWVideoJsPlugin.ACTION_DOWNLOAD, str, jSONObject3);
                }
            });
        }

        private void js_init(String str, String str2, JSONObject jSONObject) {
            int i3;
            int i16;
            setCacheCallback(ACTION_INIT, str, str2);
            JSONObject jSONObject2 = new JSONObject();
            try {
                int i17 = this.mContext.getResources().getDisplayMetrics().widthPixels;
                int i18 = this.mContext.getResources().getDisplayMetrics().heightPixels;
                try {
                    i3 = jSONObject.optInt(HippyTKDListViewAdapter.X, 0);
                    try {
                        i16 = jSONObject.optInt("y", 0);
                        try {
                            i17 = jSONObject.optInt("w", i17);
                            i18 = jSONObject.optInt(h.F, i18);
                        } catch (Exception e16) {
                            e = e16;
                            if (QLog.isColorLevel()) {
                                QLog.e(TAG, 2, e, new Object[0]);
                            }
                            MyVideoView myVideoView = new MyVideoView(this.mContext);
                            myVideoView.setTag(str);
                            float f16 = this.mContext.getResources().getDisplayMetrics().density;
                            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i17, i18);
                            layoutParams.setMargins((int) (i3 * f16), (int) (i16 * f16), 0, 0);
                            this.videoLayout.addView(myVideoView, layoutParams);
                            this.mVideoViews.put(str, myVideoView);
                            jSONObject2.put("resultCode", 0);
                            jSONObject2.put(KEY_STATUS, 0);
                            callbackJs(ACTION_INIT, str, jSONObject2);
                        }
                    } catch (Exception e17) {
                        e = e17;
                        i16 = 0;
                    }
                } catch (Exception e18) {
                    e = e18;
                    i3 = 0;
                    i16 = 0;
                }
                MyVideoView myVideoView2 = new MyVideoView(this.mContext);
                myVideoView2.setTag(str);
                float f162 = this.mContext.getResources().getDisplayMetrics().density;
                FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(i17, i18);
                layoutParams2.setMargins((int) (i3 * f162), (int) (i16 * f162), 0, 0);
                this.videoLayout.addView(myVideoView2, layoutParams2);
                this.mVideoViews.put(str, myVideoView2);
                jSONObject2.put("resultCode", 0);
                jSONObject2.put(KEY_STATUS, 0);
            } catch (Exception e19) {
                if (QLog.isColorLevel()) {
                    QLog.e(TAG, 2, e19, new Object[0]);
                }
                try {
                    jSONObject2.put("resultCode", -1);
                } catch (JSONException e26) {
                    if (QLog.isColorLevel()) {
                        QLog.e(TAG, 2, e26, new Object[0]);
                    }
                }
            }
            callbackJs(ACTION_INIT, str, jSONObject2);
        }

        private void js_isVideoExist(String str, String str2, JSONObject jSONObject) {
            setCacheCallback(ACTION_ISVIDEOEXIST, str, str2);
            int i3 = TextUtils.isEmpty(getInnerVideoPath(str)) ? -1 : 0;
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("resultCode", i3);
            } catch (JSONException e16) {
                if (QLog.isColorLevel()) {
                    QLog.e(TAG, 2, e16, new Object[0]);
                }
            }
            callbackJs(ACTION_ISVIDEOEXIST, str, jSONObject2);
        }

        private void js_play(String str, String str2, JSONObject jSONObject) {
            setCacheCallback(ACTION_PLAY, str, str2);
            MyVideoView myVideoView = this.mVideoViews.get(str);
            if (myVideoView != null) {
                if (myVideoView.testFlag(2)) {
                    resumeOrPause(true, false);
                } else {
                    String innerVideoPath = getInnerVideoPath(str);
                    if (!TextUtils.isEmpty(innerVideoPath)) {
                        myVideoView.setOnPreparedListener(this);
                        myVideoView.setOnCompletionListener(this);
                        myVideoView.setOnErrorListener(this);
                        myVideoView.setVideoPath(innerVideoPath);
                        myVideoView.mCurrTime = 0;
                        myVideoView.start();
                        int i3 = myVideoView.getLayoutParams().width;
                        myVideoView.setDimension(i3, (i3 * 1334) / 750);
                        this.mVid = str;
                        this.mDelayMillis = jSONObject.optInt(KEY_PLAYTIMEINTERVAL, 0);
                    }
                }
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jSONObject2.put("resultCode", 0);
                    jSONObject2.put(KEY_STATUS, 1);
                } catch (JSONException e16) {
                    if (QLog.isColorLevel()) {
                        QLog.e(TAG, 2, e16, new Object[0]);
                    }
                }
                callbackJs(ACTION_PLAY, str, jSONObject2);
                return;
            }
            JSONObject jSONObject3 = new JSONObject();
            try {
                jSONObject3.put("resultCode", -1);
            } catch (JSONException e17) {
                if (QLog.isColorLevel()) {
                    QLog.e(TAG, 2, e17, new Object[0]);
                }
            }
            callbackJs(ACTION_PLAY, str, jSONObject3);
        }

        private void js_stop(String str, String str2, JSONObject jSONObject) {
            stopPlay(str);
            setCacheCallback(ACTION_STOP, str, str2);
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("resultCode", 0);
                jSONObject2.put(KEY_STATUS, 0);
            } catch (JSONException e16) {
                if (QLog.isColorLevel()) {
                    QLog.e(TAG, 2, e16, new Object[0]);
                }
            }
            callbackJs(ACTION_STOP, this.mVid, jSONObject2);
        }

        private void refreshVideoFlag(int i3, boolean z16) {
            MyVideoView myVideoView = this.mVideoViews.get(this.mVid);
            if (myVideoView != null) {
                myVideoView.setFlag(i3, z16);
            }
        }

        private void setCacheCallback(String str, String str2, String str3) {
            HashMap<String, String> hashMap = this.mCallbacks.get(str);
            if (hashMap == null) {
                hashMap = new HashMap<>();
            }
            hashMap.put(str2, str3);
            this.mCallbacks.put(str, hashMap);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean stopPlay(String str) {
            MyVideoView myVideoView = this.mVideoViews.get(str);
            if (myVideoView == null) {
                return false;
            }
            try {
                if (myVideoView.isPlaying()) {
                    myVideoView.stopPlayback();
                }
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.e(TAG, 2, e16, new Object[0]);
                }
            }
            myVideoView.release();
            this.mHandler.removeMessages(1);
            this.mVideoViews.remove(str);
            this.videoLayout.removeView(myVideoView);
            this.videoLayout.setVisibility(4);
            return true;
        }

        /* JADX WARN: Removed duplicated region for block: B:18:0x00c3  */
        /* JADX WARN: Removed duplicated region for block: B:23:0x00e8  */
        /* JADX WARN: Removed duplicated region for block: B:26:? A[RETURN, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:6:0x001c A[Catch: all -> 0x0011, TryCatch #0 {all -> 0x0011, blocks: (B:68:0x000b, B:70:0x000e, B:4:0x0016, B:6:0x001c, B:7:0x0043, B:9:0x0049, B:12:0x004f), top: B:67:0x000b }] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        protected boolean handleJsRequest(JsBridgeListener jsBridgeListener, String str, String str2, String str3, String... strArr) {
            String str4;
            String str5;
            Throwable th5;
            boolean z16 = false;
            String str6 = null;
            if (strArr != null) {
                try {
                    if (strArr.length > 0) {
                        str4 = strArr[0];
                        if (QLog.isColorLevel()) {
                            QLog.i(TAG, 2, "handleJsRequest, pkgName:" + str2 + ", method:=" + str3 + ", arg:" + str4);
                        }
                        if (!TextUtils.isEmpty(str3) || this.videoParent == null || str4 == null) {
                            return false;
                        }
                        JSONObject jSONObject = new JSONObject(str4);
                        String optString = jSONObject.optString("videoID");
                        try {
                            str6 = jSONObject.optString("callback");
                            if (TextUtils.isEmpty(optString)) {
                                return false;
                            }
                            try {
                                if (ACTION_INIT.equals(str3)) {
                                    js_init(optString, str6, jSONObject);
                                } else if (ACTION_PLAY.equals(str3)) {
                                    js_play(optString, str6, jSONObject);
                                } else if (ACTION_PAUSE.equals(str3)) {
                                    js_pause(optString, str6, jSONObject);
                                } else if (ACTION_STOP.equals(str3)) {
                                    js_stop(optString, str6, jSONObject);
                                } else if (ACTION_DOWNLOAD.equals(str3)) {
                                    js_download(optString, str6, jSONObject);
                                } else {
                                    if (!ACTION_ISVIDEOEXIST.equals(str3)) {
                                        return false;
                                    }
                                    js_isVideoExist(optString, str6, jSONObject);
                                }
                                return true;
                            } catch (Throwable th6) {
                                th5 = th6;
                                str5 = str6;
                                str6 = optString;
                                z16 = true;
                                if (QLog.isColorLevel()) {
                                }
                                JSONObject jSONObject2 = new JSONObject();
                                try {
                                    jSONObject2.put("resultCode", -1);
                                    jSONObject2.put("videoID", str6);
                                } catch (JSONException e16) {
                                    if (QLog.isColorLevel()) {
                                        QLog.e(TAG, 2, "handleJsRequest JSONException:", e16);
                                    }
                                }
                                if (str5 != null) {
                                }
                            }
                        } catch (Throwable th7) {
                            th5 = th7;
                            str5 = str6;
                            str6 = optString;
                        }
                    }
                } catch (Throwable th8) {
                    th5 = th8;
                    str5 = null;
                    if (QLog.isColorLevel()) {
                        QLog.e(TAG, 2, "handleJsRequest Throwable:", th5);
                    }
                    JSONObject jSONObject22 = new JSONObject();
                    jSONObject22.put("resultCode", -1);
                    jSONObject22.put("videoID", str6);
                    if (str5 != null) {
                        return z16;
                    }
                    QWalletCommonJsPlugin.this.callJs(str5, strArr);
                    return z16;
                }
            }
            str4 = null;
            if (QLog.isColorLevel()) {
            }
            return TextUtils.isEmpty(str3) ? false : false;
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            String str;
            MyVideoView myVideoView;
            int intValue;
            if (QLog.isColorLevel()) {
                QLog.i(TAG, 2, "handleMessage, what:" + message.what + ",obj:" + message.obj);
            }
            try {
                int i3 = message.what;
                if (i3 != 1) {
                    if (i3 != 2) {
                        return false;
                    }
                    Object obj = message.obj;
                    if (!(obj instanceof Integer) || 1 == (intValue = ((Integer) obj).intValue()) || 4 != intValue) {
                        return true;
                    }
                    String str2 = this.mVid;
                    js_stop(str2, getCacheCallback(ACTION_PLAY, str2), new JSONObject());
                    return true;
                }
                Object obj2 = message.obj;
                if (!(obj2 instanceof String) || this.mDelayMillis <= 0 || (myVideoView = this.mVideoViews.get((str = (String) obj2))) == null || !myVideoView.isPlaying()) {
                    return true;
                }
                int currentPosition = myVideoView.getCurrentPosition();
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put(KEY_STATUS, 2);
                    jSONObject.put("currentTime", currentPosition);
                } catch (JSONException e16) {
                    if (QLog.isColorLevel()) {
                        QLog.e(TAG, 2, e16, new Object[0]);
                    }
                }
                callbackJs(ACTION_PLAY, str, jSONObject);
                Handler handler = this.mHandler;
                handler.sendMessageDelayed(handler.obtainMessage(1, str), this.mDelayMillis);
                return true;
            } catch (Throwable th5) {
                if (!QLog.isColorLevel()) {
                    return true;
                }
                QLog.e(TAG, 2, "handleMessage, Throwable:", th5);
                return true;
            }
        }

        @Override // android.media.MediaPlayer.OnCompletionListener
        public void onCompletion(MediaPlayer mediaPlayer) {
            if (QLog.isColorLevel()) {
                QLog.i(TAG, 2, "onCompletion");
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("resultCode", 0);
                jSONObject.put(KEY_STATUS, 4);
            } catch (JSONException e16) {
                if (QLog.isColorLevel()) {
                    QLog.e(TAG, 2, e16, new Object[0]);
                }
            }
            refreshVideoFlag(2, false);
            callbackJs(ACTION_PLAY, this.mVid, jSONObject);
            this.mHandler.obtainMessage(2, 4).sendToTarget();
        }

        @Override // android.media.MediaPlayer.OnErrorListener
        public boolean onError(MediaPlayer mediaPlayer, int i3, int i16) {
            if (QLog.isColorLevel()) {
                QLog.e(TAG, 2, "onError,what:" + i3 + "extra:" + i16);
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("resultCode", -1);
                jSONObject.put(KEY_STATUS, 5);
            } catch (JSONException e16) {
                if (QLog.isColorLevel()) {
                    QLog.e(TAG, 2, e16, new Object[0]);
                }
            }
            refreshVideoFlag(2, false);
            callbackJs(ACTION_PLAY, this.mVid, jSONObject);
            stopPlay(this.mVid);
            return false;
        }

        /* JADX WARN: Removed duplicated region for block: B:38:0x00a6  */
        @Override // android.media.MediaPlayer.OnPreparedListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onPrepared(MediaPlayer mediaPlayer) {
            int i3;
            if (QLog.isColorLevel()) {
                QLog.i(TAG, 2, "onPrepared");
            }
            JSONObject jSONObject = new JSONObject();
            MyVideoView myVideoView = this.mVideoViews.get(this.mVid);
            try {
                if (myVideoView == null) {
                    try {
                        jSONObject.put("resultCode", -1);
                        jSONObject.put(KEY_STATUS, 0);
                    } catch (JSONException e16) {
                        if (QLog.isColorLevel()) {
                            QLog.e(TAG, 2, e16, new Object[0]);
                        }
                    }
                    callbackJs(ACTION_PLAY, this.mVid, jSONObject);
                    return;
                }
                int i16 = myVideoView.mCurrTime;
                if (i16 > 0) {
                    mediaPlayer.seekTo(i16);
                    if (QLog.isColorLevel()) {
                        QLog.i(TAG, 2, "resumeplay,time:" + i16);
                    }
                }
                if (myVideoView.testFlag(4)) {
                    i3 = 3;
                } else {
                    mediaPlayer.start();
                    this.mHandler.obtainMessage(1, this.mVid).sendToTarget();
                    i3 = 2;
                }
                myVideoView.requestFocus();
                this.videoLayout.setVisibility(0);
                refreshVideoFlag(2, true);
                try {
                    jSONObject.put("resultCode", 0);
                    jSONObject.put(KEY_STATUS, i3);
                } catch (JSONException e17) {
                    if (QLog.isColorLevel()) {
                        QLog.e(TAG, 2, e17, new Object[0]);
                    }
                }
                callbackJs(ACTION_PLAY, this.mVid, jSONObject);
                return;
            } catch (IllegalStateException e18) {
                if (QLog.isColorLevel()) {
                }
                jSONObject.put("resultCode", -1);
                jSONObject.put(KEY_STATUS, 0);
                stopPlay(this.mVid);
                callbackJs(ACTION_PLAY, this.mVid, jSONObject);
            }
            if (QLog.isColorLevel()) {
                QLog.e(TAG, 2, e18, new Object[0]);
            }
            try {
                jSONObject.put("resultCode", -1);
                jSONObject.put(KEY_STATUS, 0);
            } catch (JSONException e19) {
                if (QLog.isColorLevel()) {
                    QLog.e(TAG, 2, e19, new Object[0]);
                }
            }
            stopPlay(this.mVid);
            callbackJs(ACTION_PLAY, this.mVid, jSONObject);
        }

        protected void onWebViewCreated(WebViewPlugin.b bVar) {
            ViewGroup viewGroup = (ViewGroup) bVar.a().findViewById(R.id.l2a);
            this.videoParent = viewGroup;
            if (viewGroup != null) {
                this.videoLayout = new FrameLayout(this.mContext);
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.mContext.getResources().getDisplayMetrics().widthPixels, this.mContext.getResources().getDisplayMetrics().heightPixels);
                layoutParams.setMargins(0, 0, 0, 0);
                this.videoParent.addView(this.videoLayout, layoutParams);
                this.videoLayout.setBackgroundColor(0);
                this.videoLayout.setVisibility(4);
            }
        }

        public void resumeOrPause(boolean z16, boolean z17) {
            MyVideoView myVideoView = this.mVideoViews.get(this.mVid);
            if (myVideoView == null || !myVideoView.testFlag(2)) {
                return;
            }
            if (!z16) {
                if (myVideoView.isPlaying()) {
                    myVideoView.mCurrTime = myVideoView.getCurrentPosition();
                    if (QLog.isColorLevel()) {
                        QLog.i(TAG, 2, "pause,time:" + myVideoView.mCurrTime);
                    }
                    myVideoView.pause();
                    this.mHandler.removeMessages(1);
                }
            } else if (!myVideoView.isPlaying()) {
                myVideoView.resume();
                this.mHandler.obtainMessage(1, this.mVid).sendToTarget();
            }
            myVideoView.setFlag(3, z16);
            myVideoView.setFlag(4, z16 ? false : myVideoView.testFlag(4) | z17);
        }

        private void js_pause(String str, String str2, JSONObject jSONObject) {
            resumeOrPause(false, true);
            this.mHandler.removeMessages(1);
            setCacheCallback(ACTION_PAUSE, str, str2);
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("resultCode", 0);
                jSONObject2.put(KEY_STATUS, 3);
            } catch (JSONException e16) {
                if (QLog.isColorLevel()) {
                    QLog.e(TAG, 2, e16, new Object[0]);
                }
            }
            callbackJs(ACTION_PAUSE, this.mVid, jSONObject2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doCallback(String str) {
        doCallback(this.mCallback, str);
    }

    protected void dochooseQQFriendsForTransferResult(String str) {
        if (str == null || str.length() == 0) {
            str = "{\"resultCode\":-1}";
        }
        doCallback(str);
    }

    public static void getHbDetail(AppInterface appInterface, String str, MyResultRecevicer myResultRecevicer) {
        if (appInterface == null) {
            return;
        }
        try {
            Bundle bundle = new Bundle();
            bundle.putString("extra_data", str.toString());
            bundle.putString("callbackSn", "0");
            Bundle bundle2 = new Bundle();
            bundle2.putInt(QWalletPayBridge.Key.PAY_INVOKER_ID, 22);
            Parcel obtain = Parcel.obtain();
            myResultRecevicer.writeToParcel(obtain, 0);
            obtain.setDataPosition(0);
            ResultReceiver resultReceiver = (ResultReceiver) ResultReceiver.CREATOR.createFromParcel(obtain);
            OaidMonitor.parcelRecycle(obtain);
            bundle2.putParcelable(IPayLogic.RECEIVER_COM_KEY, resultReceiver);
            bundle2.putBundle("_qwallet_payparams_data", bundle);
            bundle2.putString("_qwallet_payparams_tag", "redgiftDetail");
            QWalletPayBridge.launchBackground(BaseApplicationImpl.sApplication, bundle2);
        } catch (Throwable th5) {
            th5.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00ee A[Catch: Exception -> 0x00f2, TRY_ENTER, TRY_LEAVE, TryCatch #7 {Exception -> 0x00f2, blocks: (B:57:0x00be, B:21:0x00ee), top: B:2:0x0016 }] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00e3 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0107 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:46:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00fc A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00be A[Catch: Exception -> 0x00f2, TRY_ENTER, TRY_LEAVE, TryCatch #7 {Exception -> 0x00f2, blocks: (B:57:0x00be, B:21:0x00ee), top: B:2:0x0016 }] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00b3 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public JSONObject getSelectContact(String str) {
        Throwable th5;
        Cursor cursor;
        Cursor query;
        int columnIndex;
        String trimPhoneName;
        JSONObject jSONObject = new JSONObject();
        Cursor cursor2 = null;
        r7 = null;
        r7 = null;
        r7 = null;
        String trimPhoneNumPre = null;
        cursor2 = null;
        try {
            try {
                query = ContactsMonitor.query(this.mContext.getContentResolver(), ContactsContract.Contacts.CONTENT_URI, null, "_id=?", new String[]{str}, null);
            } catch (Exception e16) {
                e = e16;
                cursor = null;
            } catch (Throwable th6) {
                th5 = th6;
                cursor = null;
            }
        } catch (Exception e17) {
            e17.printStackTrace();
        }
        if (query != null) {
            try {
            } catch (Exception e18) {
                e = e18;
                cursor = null;
                cursor2 = query;
                try {
                    e.printStackTrace();
                    try {
                        jSONObject.put("code", -1);
                        jSONObject.put("name", "");
                        jSONObject.put("number", "");
                    } catch (JSONException e19) {
                        e19.printStackTrace();
                        if (cursor2 != null) {
                            try {
                                cursor2.close();
                            } catch (Exception e26) {
                                e26.printStackTrace();
                            }
                        }
                        if (cursor != null) {
                            cursor.close();
                        }
                        return jSONObject;
                    }
                    if (cursor2 != null) {
                    }
                    if (cursor != null) {
                    }
                    return jSONObject;
                } catch (Throwable th7) {
                    th5 = th7;
                    if (cursor2 != null) {
                        try {
                            cursor2.close();
                        } catch (Exception e27) {
                            e27.printStackTrace();
                        }
                    }
                    if (cursor != null) {
                        try {
                            cursor.close();
                            throw th5;
                        } catch (Exception e28) {
                            e28.printStackTrace();
                            throw th5;
                        }
                    }
                    throw th5;
                }
            } catch (Throwable th8) {
                th5 = th8;
                cursor = null;
                cursor2 = query;
                if (cursor2 != null) {
                }
                if (cursor != null) {
                }
            }
            if (query.moveToFirst() && (columnIndex = query.getColumnIndex("display_name")) >= 0) {
                trimPhoneName = trimPhoneName(query.getString(columnIndex));
                int columnIndex2 = query.getColumnIndex("has_phone_number");
                if (columnIndex2 < 0 || query.getInt(columnIndex2) <= 0) {
                    cursor = null;
                } else {
                    cursor = ContactsMonitor.query(this.mContext.getContentResolver(), ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null, "contact_id = " + str, null, null);
                    if (cursor != null) {
                        try {
                            if (cursor.moveToFirst()) {
                                trimPhoneNumPre = trimPhoneNumPre(cursor.getString(cursor.getColumnIndex(StepCounterConstants.BEACON_PARAM_KEY_DATA1)));
                            }
                        } catch (Exception e29) {
                            e = e29;
                            cursor2 = query;
                            e.printStackTrace();
                            jSONObject.put("code", -1);
                            jSONObject.put("name", "");
                            jSONObject.put("number", "");
                            if (cursor2 != null) {
                            }
                            if (cursor != null) {
                            }
                            return jSONObject;
                        } catch (Throwable th9) {
                            th5 = th9;
                            cursor2 = query;
                            if (cursor2 != null) {
                            }
                            if (cursor != null) {
                            }
                        }
                    }
                }
                if (!TextUtils.isEmpty(trimPhoneNumPre) && !TextUtils.isEmpty(trimPhoneName)) {
                    jSONObject.put("code", 0);
                    jSONObject.put("name", trimPhoneName);
                    jSONObject.put("number", trimPhoneNumPre);
                }
                if (query != null) {
                    try {
                        query.close();
                    } catch (Exception e36) {
                        e36.printStackTrace();
                    }
                }
                if (cursor != null) {
                    cursor.close();
                }
                return jSONObject;
            }
        }
        trimPhoneName = null;
        cursor = null;
        if (!TextUtils.isEmpty(trimPhoneNumPre)) {
            jSONObject.put("code", 0);
            jSONObject.put("name", trimPhoneName);
            jSONObject.put("number", trimPhoneNumPre);
        }
        if (query != null) {
        }
        if (cursor != null) {
        }
        return jSONObject;
    }

    private void handleSkin(String str, int i3, int i16) {
    }
}
