package com.tencent.mobileqq.vaswebviewplugin;

import Wallet.AcsBatchSubNoticeRsp;
import Wallet.AcsDelMsgRsp;
import Wallet.AcsMsg;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.activateFriend.QQNotifySettingBaseFragment;
import com.tencent.mobileqq.activity.activateFriend.QQNotifySettingInnerFragment;
import com.tencent.mobileqq.activity.activateFriend.ae;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.emosm.api.IWebIPCOperatorApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.reminder.api.IQQReminderCalendarService;
import com.tencent.mobileqq.reminder.api.IQQReminderDataService;
import com.tencent.mobileqq.reminder.api.IQQReminderService;
import com.tencent.mobileqq.reminder.biz.entity.CalendarEntity;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import mqq.app.AppActivity;
import mqq.observer.BusinessObserver;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes20.dex */
public class QWalletMixJsPlugin extends VasWebviewJsPlugin {
    public static final String ERROR_MSG_PARAM_ERROR = "params error";
    public static final String ERROR_MSG_UNKNOWN_ERROR = "client_unknown_error";
    public static final int ERROR_RETURN_CODE_PARAM_ERROR = 4;
    public static final int ERROR_RETURN_CODE_UNKNOWN_ERROR = -100;
    private static final String METHOD_ACTION_BATCH_SUBSCRIBE = "batchSubscribe";
    private static final String METHOD_ACTION_DELETE_NOTIFY = "delete";
    public static final String METHOD_ACTION_NOTIFY_NEW_SUBSCRIBE = "newSubscribe";
    public static final String METHOD_ACTION_NOTIFY_QUERY = "query";
    private static final String METHOD_ACTION_NPTITY_SUBSCRIBE = "subscribe";
    private static final String METHOD_ACTION_REMOVE_NOTIFY = "remove";
    public static final String METHOD_ACTION_SUBSCRIBE_CALENDAR_DIRECTLY = "subscribeCalendarDirectly";
    public static final String METHOD_ACTION_SUBSCRIBE_DIRECTLY = "subscribe_directly";
    private static final String METHOD_NAME_QQ_NOTIFY = "qqNotify";
    public static final String OBJECT_NAME_QWALLET_MIX = "qw_mix";
    public static final String PARAMS_BUSINESS_ID = "busiid";
    public static final String PARAMS_CALLBACK_ID = "callback_id";
    public static final String PARAMS_DOMAIN = "domain";
    public static final String PARAMS_ERROR_MSG = "retmsg";
    public static final String PARAMS_HAS_SUBSCRIBE = "has_subscribe";
    public static final String PARAMS_IS_SET_CALENDAR = "is_set_calendar";
    public static final String PARAMS_MSG_ID = "msgid";
    public static final String PARAMS_RETURN_CODE = "retcode";
    private static final String TAG = "QWalletMixJsPlugin";
    public static SparseArray<String> mFirstUrls = new SparseArray<>();
    public static ArrayList<Integer> mSequence = new ArrayList<>();
    private AppInterface app;
    private String mActivityCallback;
    private Context mContext;
    private Handler mMainHandler = new Handler(Looper.getMainLooper());

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes20.dex */
    public static class NotifyListener implements ae.b {
        private final String mCallback;
        private final WeakReference<QWalletMixJsPlugin> mPlugin;

        public NotifyListener(QWalletMixJsPlugin qWalletMixJsPlugin, String str) {
            this.mPlugin = new WeakReference<>(qWalletMixJsPlugin);
            this.mCallback = str;
        }

        @Override // com.tencent.mobileqq.activity.activateFriend.ae.b
        public void queryHasSetNotify(Bundle bundle, Bundle bundle2) {
            QWalletMixJsPlugin qWalletMixJsPlugin = this.mPlugin.get();
            if (qWalletMixJsPlugin != null) {
                qWalletMixJsPlugin.doCallback(this.mCallback, ae.i(bundle));
            }
        }
    }

    private void batchSubscribeNotify(JSONObject jSONObject, final String str) {
        JSONArray optJSONArray = jSONObject.optJSONArray("msg_id_list");
        String optString = jSONObject.optString("domain");
        WebViewPlugin.b bVar = this.mRuntime;
        if (bVar != null) {
            optString = Uri.parse(bVar.e().getUrl()).getHost();
        }
        ArrayList<String> arrayList = new ArrayList<>();
        for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
            try {
                arrayList.add(optJSONArray.getString(i3));
            } catch (JSONException e16) {
                if (QLog.isColorLevel()) {
                    QLog.e(TAG, 2, e16, new Object[0]);
                }
            }
        }
        IQQReminderService iQQReminderService = (IQQReminderService) this.app.getRuntimeService(IQQReminderService.class, "");
        if (iQQReminderService == null) {
            return;
        }
        iQQReminderService.sendBatchSubscribeReminder(arrayList, optString, new BusinessObserver() { // from class: com.tencent.mobileqq.vaswebviewplugin.QWalletMixJsPlugin.2
            @Override // mqq.observer.BusinessObserver
            public void onReceive(int i16, boolean z16, Bundle bundle) {
                try {
                    if (i16 == 2007 && z16) {
                        AcsBatchSubNoticeRsp acsBatchSubNoticeRsp = (AcsBatchSubNoticeRsp) bundle.getSerializable("rsp");
                        if (acsBatchSubNoticeRsp != null) {
                            QLog.i(QWalletMixJsPlugin.TAG, 2, "batchSubscribeNotify#onReceive, rsp retCode:" + acsBatchSubNoticeRsp.ret_code);
                            JSONObject jSONObject2 = new JSONObject();
                            jSONObject2.put("retcode", acsBatchSubNoticeRsp.ret_code);
                            jSONObject2.put("retmsg", acsBatchSubNoticeRsp.err_str);
                            jSONObject2.put("success_count", acsBatchSubNoticeRsp.succeed_count);
                            jSONObject2.put("retry_msgs", acsBatchSubNoticeRsp.retry_msgs);
                            QWalletMixJsPlugin.this.doCallback(str, jSONObject2.toString());
                            ArrayList<AcsMsg> arrayList2 = acsBatchSubNoticeRsp.msgs;
                            if (arrayList2 != null && !arrayList2.isEmpty()) {
                                IQQReminderDataService iQQReminderDataService = (IQQReminderDataService) QWalletMixJsPlugin.this.app.getRuntimeService(IQQReminderDataService.class, "");
                                Iterator<AcsMsg> it = arrayList2.iterator();
                                while (it.hasNext()) {
                                    iQQReminderDataService.doNotifyByPush(it.next());
                                }
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    QLog.i(QWalletMixJsPlugin.TAG, 2, "batchSubscribeNotify#onReceive, not success");
                } catch (Exception e17) {
                    QLog.e(QWalletMixJsPlugin.TAG, 1, "batchSubscribeNotify#onReceive", e17);
                }
            }
        });
    }

    private void deleteNotify(JSONObject jSONObject, final String str) {
        final String optString = jSONObject.optString("msgid");
        final String optString2 = jSONObject.optString("busiid");
        if (!StringUtil.isEmpty(optString) && !StringUtil.isEmpty(optString)) {
            final Handler handler = new Handler(Looper.getMainLooper());
            IQQReminderService iQQReminderService = (IQQReminderService) this.app.getRuntimeService(IQQReminderService.class, "");
            if (iQQReminderService == null) {
                return;
            }
            iQQReminderService.sendDelReminderListById(optString, 0L, 2, new BusinessObserver() { // from class: com.tencent.mobileqq.vaswebviewplugin.QWalletMixJsPlugin.1
                @Override // mqq.observer.BusinessObserver
                public void onReceive(final int i3, final boolean z16, final Bundle bundle) {
                    handler.post(new Runnable() { // from class: com.tencent.mobileqq.vaswebviewplugin.QWalletMixJsPlugin.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            try {
                                if (i3 == 2001) {
                                    if (z16) {
                                        AcsDelMsgRsp acsDelMsgRsp = (AcsDelMsgRsp) bundle.getSerializable("rsp");
                                        if (acsDelMsgRsp != null && acsDelMsgRsp.ret_code == 0) {
                                            QLog.i(QWalletMixJsPlugin.TAG, 2, "@qqnotify req success ");
                                            AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                                            QWalletMixJsPlugin.this.notifydelMsgUI(optString2, optString, str);
                                            AnonymousClass1 anonymousClass12 = AnonymousClass1.this;
                                            QWalletMixJsPlugin.this.handJsResult(0, str);
                                        } else {
                                            AnonymousClass1 anonymousClass13 = AnonymousClass1.this;
                                            QWalletMixJsPlugin.this.handJsResult(1, str);
                                            if (acsDelMsgRsp != null) {
                                                QLog.i(QWalletMixJsPlugin.TAG, 2, "@qqnotify ret_code =  " + acsDelMsgRsp.ret_code);
                                            }
                                        }
                                    } else {
                                        AnonymousClass1 anonymousClass14 = AnonymousClass1.this;
                                        QWalletMixJsPlugin.this.handJsResult(2, str);
                                        QLog.i(QWalletMixJsPlugin.TAG, 2, "@qqnotify delete faield not success  ");
                                    }
                                }
                            } catch (Exception e16) {
                                if (QLog.isColorLevel()) {
                                    QLog.e(QWalletMixJsPlugin.TAG, 1, "sendDelReminderListById onReceive", e16);
                                }
                            }
                        }
                    });
                }
            });
            IQQReminderCalendarService iQQReminderCalendarService = (IQQReminderCalendarService) this.app.getRuntimeService(IQQReminderCalendarService.class, "");
            CalendarEntity calendarEntity = new CalendarEntity();
            calendarEntity.msg_id = optString;
            iQQReminderCalendarService.deleteCalendarAlarm((AppActivity) this.mRuntime.a(), calendarEntity);
            return;
        }
        handJsError("4", ERROR_MSG_PARAM_ERROR, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doCallback(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            callJs(str, str2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handJsError(String str, String str2, String str3) {
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "handJsError: " + str2);
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("retcode", str);
            jSONObject.put("retmsg", str2);
            doCallback(str3, jSONObject.toString());
        } catch (Throwable th5) {
            th5.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handJsResult(int i3, String str) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("retcode", i3);
            doCallback(str, jSONObject.toString());
        } catch (Throwable th5) {
            th5.printStackTrace();
        }
    }

    private boolean handleQQNotifyJsAPi(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            String optString = jSONObject.optString("action");
            JSONObject optJSONObject = jSONObject.optJSONObject("params");
            String parseCallback = parseCallback(str);
            if ("subscribe".equals(optString)) {
                subscribeNotify(optJSONObject, parseCallback);
            } else if ("delete".equals(optString)) {
                deleteNotify(optJSONObject, parseCallback);
            } else if ("newSubscribe".equals(optString)) {
                newSubscribeRecurrentNotifyFragment(optJSONObject, parseCallback);
            } else if ("query".equals(optString)) {
                queryBusinessHasSet(optJSONObject, parseCallback);
            } else if ("remove".equals(optString)) {
                deleteNotify(optJSONObject, parseCallback);
            } else if ("batchSubscribe".equals(optString)) {
                batchSubscribeNotify(optJSONObject, parseCallback);
            } else if ("subscribeCalendarDirectly".equals(optString)) {
                subscribeCalendarNotify(optJSONObject, parseCallback);
            }
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.e(TAG, 1, "handleQQNotifyJsAPi", e16);
            }
        }
        return true;
    }

    private void newSubscribeRecurrentNotifyFragment(JSONObject jSONObject, String str) {
        String optString = jSONObject.optString("msgid");
        String optString2 = jSONObject.optString("busiid");
        if (StringUtil.isEmpty(optString)) {
            handJsError("4", ERROR_MSG_PARAM_ERROR, str);
            return;
        }
        WebViewPlugin.b bVar = this.mRuntime;
        if (bVar != null) {
            this.mActivityCallback = str;
            ae.p(this.mRuntime.a(), optString, Uri.parse(bVar.e().getUrl()).getHost(), optString2, QQNotifySettingBaseFragment.U);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifydelMsgUI(String str, String str2, String str3) {
        Bundle bundle = new Bundle();
        bundle.putString("busiid", str);
        bundle.putString("msgid", str2);
        ((IWebIPCOperatorApi) QRoute.api(IWebIPCOperatorApi.class)).sendServiceIpcReq(com.tencent.mobileqq.emosm.a.a("ipc_cmd_is_qq_notify_all_notify", str3, this.mOnRemoteResp.key, bundle));
    }

    private String parseCallback(String str) {
        if (!TextUtils.isEmpty(str) && str.toLowerCase().indexOf("callback") >= 0) {
            try {
                return new JSONObject(str).optString("callback");
            } catch (JSONException e16) {
                e16.printStackTrace();
            }
        }
        return "";
    }

    private void queryBusinessHasSet(JSONObject jSONObject, String str) {
        String optString = jSONObject.optString("msgid");
        String optString2 = jSONObject.optString("busiid");
        if (StringUtil.isEmpty(optString)) {
            handJsError("4", ERROR_MSG_PARAM_ERROR, str);
            return;
        }
        WebViewPlugin.b bVar = this.mRuntime;
        if (bVar != null) {
            ae.k(optString, Uri.parse(bVar.e().getUrl()).getHost(), optString2, new NotifyListener(this, str));
        }
    }

    private void subscribeCalendarNotify(JSONObject jSONObject, final String str) {
        String optString = jSONObject.optString("domain");
        WebViewPlugin.b bVar = this.mRuntime;
        if (bVar != null) {
            optString = Uri.parse(bVar.e().getUrl()).getHost();
        }
        String str2 = optString;
        String optString2 = jSONObject.optString("msgid");
        String optString3 = jSONObject.optString("busiid");
        String optString4 = jSONObject.optString("ifAddCalendar");
        if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(optString2) && !TextUtils.isEmpty(optString3) && !TextUtils.isEmpty(optString4)) {
            WebViewPlugin.b bVar2 = this.mRuntime;
            if (bVar2 != null && bVar2.a() != null) {
                ae.r(this.app, (AppActivity) this.mRuntime.a(), optString2, str2, optString3, optString4, new ae.c() { // from class: com.tencent.mobileqq.vaswebviewplugin.QWalletMixJsPlugin.3
                    @Override // com.tencent.mobileqq.activity.activateFriend.ae.c
                    public void onResult(Bundle bundle, @Nullable Bundle bundle2) {
                        int i3 = bundle.getInt("retcode", -100);
                        QWalletMixJsPlugin.this.handJsError(String.valueOf(i3), bundle.getString("retmsg", ""), str);
                    }
                });
                return;
            } else {
                handJsError("3", "system error", str);
                return;
            }
        }
        handJsError(String.valueOf(4), ERROR_MSG_PARAM_ERROR, str);
        QLog.i(TAG, 1, "subscribeCalendarNotify,params error");
    }

    private void subscribeNotify(JSONObject jSONObject, String str) {
        String optString = jSONObject.optString("msgid");
        String optString2 = jSONObject.optString("busiid");
        if (!StringUtil.isEmpty(optString) && !StringUtil.isEmpty(optString)) {
            WebViewPlugin.b bVar = this.mRuntime;
            if (bVar != null) {
                this.mActivityCallback = str;
                QQNotifySettingInnerFragment.Ih(this.mRuntime.a(), optString, optString2, Uri.parse(bVar.e().getUrl()).getHost());
                return;
            }
            return;
        }
        handJsError("4", ERROR_MSG_PARAM_ERROR, str);
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public String getNameSpace() {
        return OBJECT_NAME_QWALLET_MIX;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public boolean handleJsRequest(JsBridgeListener jsBridgeListener, String str, String str2, String str3, String... strArr) {
        String str4;
        if (QLog.isColorLevel()) {
            String str5 = TAG;
            StringBuilder sb5 = new StringBuilder();
            sb5.append("handleJsRequeste pkgName :");
            sb5.append(str2);
            sb5.append(" method: ");
            sb5.append(str3);
            if (strArr != null && strArr.length > 0) {
                str4 = " arg: " + strArr[0];
            } else {
                str4 = "";
            }
            sb5.append(str4);
            QLog.i(str5, 2, sb5.toString());
        }
        if (!OBJECT_NAME_QWALLET_MIX.equals(str2) || !METHOD_NAME_QQ_NOTIFY.equals(str3) || strArr == null || strArr.length <= 0) {
            return false;
        }
        return handleQQNotifyJsAPi(strArr[0]);
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public void onActivityResult(Intent intent, byte b16, int i3) {
        super.onActivityResult(intent, b16, i3);
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "resultCode: " + i3 + " requestCode: " + getRequestCode(b16));
        }
        if (i3 == -1 && getRequestCode(b16) == QQNotifySettingBaseFragment.U) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("retcode", intent.getIntExtra("errorCode", 0));
                jSONObject.put("retmsg", intent.getStringExtra("msg"));
                doCallback(this.mActivityCallback, jSONObject.toString());
            } catch (JSONException e16) {
                e16.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.vaswebviewplugin.VasWebviewJsPlugin, com.tencent.mobileqq.vaswebviewplugin.VasBasePlugin, com.tencent.mobileqq.webview.swift.WebViewPlugin
    public void onCreate() {
        Activity a16;
        super.onCreate();
        WebViewPlugin.b bVar = this.mRuntime;
        if (bVar != null && (a16 = bVar.a()) != null) {
            this.app = this.mRuntime.b();
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "is QQAppInterface: " + (this.app instanceof QQAppInterface));
            }
            this.mContext = a16.getApplicationContext();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.vaswebviewplugin.VasWebviewJsPlugin, com.tencent.mobileqq.webview.swift.WebViewPlugin
    public void onDestroy() {
        WebViewPlugin.b bVar = this.mRuntime;
        if (bVar != null && bVar.a() != null) {
            Activity a16 = this.mRuntime.a();
            mFirstUrls.remove(a16.hashCode());
            mSequence.remove(Integer.valueOf(a16.hashCode()));
        }
        Handler handler = this.mMainHandler;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public void onWebViewCreated(CustomWebView customWebView) {
        Activity a16;
        Intent intent;
        super.onWebViewCreated(customWebView);
        WebViewPlugin.b bVar = this.mRuntime;
        if (bVar != null && bVar.a() != null && (intent = (a16 = this.mRuntime.a()).getIntent()) != null) {
            String stringExtra = intent.getStringExtra("homepage");
            if (TextUtils.isEmpty(stringExtra)) {
                stringExtra = intent.getStringExtra("url");
            }
            if (stringExtra != null) {
                mFirstUrls.append(a16.hashCode(), stringExtra);
                mSequence.add(0, Integer.valueOf(a16.hashCode()));
            }
        }
    }
}
