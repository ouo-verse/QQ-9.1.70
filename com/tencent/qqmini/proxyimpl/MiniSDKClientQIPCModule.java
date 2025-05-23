package com.tencent.qqmini.proxyimpl;

import android.os.Bundle;
import android.os.RemoteException;
import android.text.TextUtils;
import android.webkit.URLUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.miniaio.MiniChatActivity;
import com.tencent.mobileqq.activity.miniaio.MiniChatConstants;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.mini.api.MiniConst;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.appbrand.jsapi.PluginConst;
import com.tencent.mobileqq.mini.launch.CmdCallback;
import com.tencent.mobileqq.mini.report.MiniProgramLpReportDC04239;
import com.tencent.mobileqq.mini.report.MiniProgramReporter;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdUtil;
import com.tencent.mobileqq.mini.util.ApiUtil;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.minigame.plugins.RaffleJsPlugin;
import com.tencent.qqmini.sdk.launcher.AppLoaderFactory;
import com.tencent.qqmini.sdk.launcher.action.ActionBridge;
import com.tencent.qqmini.sdk.launcher.core.BaseRuntime;
import com.tencent.qqmini.sdk.launcher.core.ICapsuleButton;
import com.tencent.qqmini.sdk.launcher.core.IJsService;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.ShareState;
import com.tencent.qqmini.sdk.plugins.ShareJsPlugin;
import com.tencent.qqmini.sdk.report.SDKMiniProgramLpReportDC04239;
import com.tencent.util.QQCustomArkDialogUtil;
import cooperation.qzone.QzoneIPCModule;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes34.dex */
public class MiniSDKClientQIPCModule extends QIPCModule {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes34.dex */
    public class a extends CmdCallback.Stub {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ BaseRuntime f347458d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f347459e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ String f347460f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ String f347461h;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ int f347462i;

        /* renamed from: m, reason: collision with root package name */
        final /* synthetic */ RequestEvent f347463m;

        a(BaseRuntime baseRuntime, String str, String str2, String str3, int i3, RequestEvent requestEvent) {
            this.f347458d = baseRuntime;
            this.f347459e = str;
            this.f347460f = str2;
            this.f347461h = str3;
            this.f347462i = i3;
            this.f347463m = requestEvent;
        }

        @Override // com.tencent.mobileqq.mini.launch.CmdCallback
        public void onCmdResult(boolean z16, Bundle bundle) throws RemoteException {
            String string = bundle.getString("shareJson");
            QLog.d("MiniSDKClientQIPCModule", 1, "handleDirectShareSucCallback shareJsonString after = " + string);
            MiniSDKClientQIPCModule.this.r(this.f347458d, this.f347459e, this.f347460f, this.f347461h, string, this.f347462i, this.f347463m);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes34.dex */
    public class b implements EIPCResultCallback {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ JSONObject f347464d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ CmdCallback f347465e;

        b(JSONObject jSONObject, CmdCallback cmdCallback) {
            this.f347464d = jSONObject;
            this.f347465e = cmdCallback;
        }

        @Override // eipc.EIPCResultCallback
        public void onCallback(EIPCResult eIPCResult) {
            try {
                this.f347464d.optJSONObject(QQCustomArkDialogUtil.META_DATA).optJSONObject("detail").put("preview", eIPCResult.data.getString("preview"));
            } catch (JSONException e16) {
                QLog.e("MiniSDKClientQIPCModule", 1, "getReplaceJsonString JSONException,", e16);
            }
            MiniSDKClientQIPCModule.this.h(this.f347464d.toString(), this.f347465e);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes34.dex */
    public class d implements MiniAppCmdInterface {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f347472a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ IJsService f347473b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ int f347474c;

        d(String str, IJsService iJsService, int i3) {
            this.f347472a = str;
            this.f347473b = iJsService;
            this.f347474c = i3;
        }

        @Override // com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface
        public void onCmdListener(boolean z16, JSONObject jSONObject) {
            QLog.i("MiniSDKClientQIPCModule", 2, "createUpdatableMsg receive isSuc= " + z16 + " ret=" + String.valueOf(jSONObject));
            if (jSONObject != null) {
                int optInt = jSONObject.optInt("retCode");
                String optString = jSONObject.optString("errMsg");
                JSONObject jSONObject2 = new JSONObject();
                try {
                    if (optInt == 0) {
                        jSONObject2.put("retCode", optInt);
                        jSONObject2.put("errMsg", optString);
                    } else {
                        jSONObject2.put("retCode", 2);
                        jSONObject2.put("errMsg", this.f347472a + ":fail " + optString + "(" + optInt + ")");
                    }
                } catch (Throwable th5) {
                    th5.printStackTrace();
                }
                IJsService iJsService = this.f347473b;
                if (iJsService != null) {
                    iJsService.evaluateCallbackJs(this.f347474c, jSONObject2.toString());
                    return;
                } else {
                    QLog.d("MiniSDKClientQIPCModule", 1, "createUpdatableMsg error, null jsService");
                    return;
                }
            }
            QLog.d("MiniSDKClientQIPCModule", 1, "createUpdatableMsg error, null ret");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes34.dex */
    public static class e {

        /* renamed from: a, reason: collision with root package name */
        private static MiniSDKClientQIPCModule f347476a = new MiniSDKClientQIPCModule(MiniConst.MiniSDKClientQIPCModuleConst.MODULE_NAME);
    }

    MiniSDKClientQIPCModule(String str) {
        super(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(JSONObject jSONObject, BaseRuntime baseRuntime, int i3, String str, boolean z16, JSONObject jSONObject2) {
        try {
            jSONObject.put("errMsg", str);
            jSONObject.put("success", z16);
        } catch (JSONException e16) {
            QLog.e("MiniSDKClientQIPCModule", 1, "callOnShareMessageToFriend error,", e16);
        }
        if (baseRuntime.getJsService() != null) {
            baseRuntime.getJsService().evaluateSubscribeJS("onShareMessageToFriend", jSONObject.toString(), baseRuntime.isMiniGame() ? -1 : ActionBridge.PageActionBridge.getPageId(baseRuntime));
        } else {
            QLog.e("MiniSDKClientQIPCModule", 1, "runtime.getJsService == null");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(String str, CmdCallback cmdCallback) {
        try {
            Bundle bundle = new Bundle();
            bundle.putString("shareJson", str);
            cmdCallback.onCmdResult(true, bundle);
        } catch (RemoteException e16) {
            e16.printStackTrace();
        }
    }

    public static MiniSDKClientQIPCModule i() {
        return e.f347476a;
    }

    private void j(String str, CmdCallback cmdCallback) {
        if (TextUtils.isEmpty(str)) {
            h(str, cmdCallback);
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has(QQCustomArkDialogUtil.META_DATA) && jSONObject.optJSONObject(QQCustomArkDialogUtil.META_DATA).has("detail") && jSONObject.optJSONObject(QQCustomArkDialogUtil.META_DATA).optJSONObject("detail").has("preview")) {
                String optString = jSONObject.optJSONObject(QQCustomArkDialogUtil.META_DATA).optJSONObject("detail").optString("preview");
                if (!URLUtil.isNetworkUrl(optString)) {
                    Bundle bundle = new Bundle();
                    bundle.putString("preview", optString);
                    QIPCClientHelper.getInstance().getClient().callServer("MiniMsgIPCServer", MiniChatConstants.CMD_MINI_SHARE_UPLOAD_IMAGE, bundle, new b(jSONObject, cmdCallback));
                    return;
                }
                h(str, cmdCallback);
                return;
            }
            h(str, cmdCallback);
        } catch (Throwable th5) {
            QLog.e("MiniSDKClientQIPCModule", 1, "getReplaceJsonString error,", th5);
            h(str, cmdCallback);
        }
    }

    private void k(BaseRuntime baseRuntime, String str, String str2, String str3, String str4, int i3, RequestEvent requestEvent) {
        j(str4, new a(baseRuntime, str, str2, str3, i3, requestEvent));
    }

    private void l(boolean z16) {
        BaseRuntime currentRuntime = AppLoaderFactory.g().getCommonManager().getCurrentRuntime();
        if (currentRuntime == null) {
            QLog.e("MiniSDKClientQIPCModule", 1, "runtime == null");
            return;
        }
        ShareState shareState = currentRuntime.getShareState();
        if (shareState == null) {
            QLog.e("MiniSDKClientQIPCModule", 1, "shareState == null");
            return;
        }
        String str = shareState.shareEvent;
        String str2 = shareState.shareOpenid;
        String str3 = shareState.shareAppid;
        String str4 = shareState.shareJson;
        int i3 = shareState.shareCallbackId;
        RequestEvent requestEvent = shareState.requestEvent;
        if (z16) {
            k(currentRuntime, str, str2, str3, str4, i3, requestEvent);
            return;
        }
        requestEvent.fail();
        JSONObject jSONObject = new JSONObject();
        g(jSONObject, currentRuntime, i3, "cancel", false, ApiUtil.wrapCallbackFail(str, jSONObject));
        q(currentRuntime, "shareMessageToFriend_fail");
        p(currentRuntime, SDKMiniProgramLpReportDC04239.MORE_BUTTON_RESERVERS_SHARE_OTHER + requestEvent.event, "fail", 3, "cancel");
    }

    private void m(boolean z16) {
        IJsService iJsService;
        BaseRuntime currentRuntime = AppLoaderFactory.g().getCommonManager().getCurrentRuntime();
        if (currentRuntime == null) {
            QLog.e("MiniSDKClientQIPCModule", 1, "runtime == null");
            return;
        }
        ShareState shareState = currentRuntime.getShareState();
        if (shareState == null) {
            QLog.e("MiniSDKClientQIPCModule", 1, "shareState == null");
            return;
        }
        JSONObject jSONObject = null;
        try {
            RequestEvent requestEvent = shareState.requestEvent;
            if (requestEvent != null) {
                iJsService = requestEvent.jsService;
            } else {
                iJsService = currentRuntime.getJsService();
            }
        } catch (Throwable th5) {
            QLog.e("MiniSDKClientQIPCModule", 1, "runtime.getJsService exception", th5);
            iJsService = null;
        }
        if (iJsService == null) {
            QLog.e("MiniSDKClientQIPCModule", 1, "jsService == null");
            return;
        }
        if (RaffleJsPlugin.RAFFLE_SHARE_ACTION.equals(shareState.shareEvent)) {
            if (z16) {
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jSONObject2.put("state", "share");
                } catch (JSONException e16) {
                    QLog.e("MiniSDKClientQIPCModule", 1, "onShareCallback exception", e16);
                }
                iJsService.evaluateSubscribeJS(RaffleJsPlugin.EVENT_ON_RAFFLE_STATE_CHANGE, jSONObject2.toString(), 0);
                return;
            }
            return;
        }
        String str = "";
        if (z16) {
            if (PluginConst.PayJsPluginConst.API_PAY_BY_FRIEND.equals(shareState.shareEvent)) {
                jSONObject = new JSONObject();
                try {
                    jSONObject.put(QzoneIPCModule.RESULT_CODE, 0);
                } catch (JSONException e17) {
                    QLog.e("MiniSDKClientQIPCModule", 1, "API_PAY_BY_FRIEND put resultCode error", e17);
                }
            }
            JSONObject wrapCallbackOk = ApiUtil.wrapCallbackOk(shareState.shareEvent, jSONObject);
            if (wrapCallbackOk != null) {
                str = wrapCallbackOk.toString();
            }
            iJsService.evaluateCallbackJs(shareState.shareCallbackId, str);
            QLog.i("MiniSDKClientQIPCModule", 1, "callback: " + str);
            q(currentRuntime, "share_success");
            return;
        }
        JSONObject wrapCallbackFail = ApiUtil.wrapCallbackFail(shareState.shareEvent, null);
        if (wrapCallbackFail != null) {
            str = wrapCallbackFail.toString();
        }
        iJsService.evaluateCallbackJs(shareState.shareCallbackId, str);
        q(currentRuntime, "share_fail");
    }

    private void n(Bundle bundle) {
        IJsService iJsService;
        BaseRuntime currentRuntime = AppLoaderFactory.g().getCommonManager().getCurrentRuntime();
        if (currentRuntime == null) {
            QLog.e("MiniSDKClientQIPCModule", 1, "runtime == null");
            return;
        }
        ShareState shareState = currentRuntime.getShareState();
        if (shareState == null) {
            QLog.e("MiniSDKClientQIPCModule", 1, "onShareUpdatableMsgCallback shareState == null");
            return;
        }
        try {
            RequestEvent requestEvent = shareState.requestEvent;
            if (requestEvent != null) {
                iJsService = requestEvent.jsService;
            } else {
                iJsService = currentRuntime.getJsService();
            }
        } catch (Throwable th5) {
            QLog.e("MiniSDKClientQIPCModule", 1, "runtime.getJsService exception", th5);
            iJsService = null;
        }
        IJsService iJsService2 = iJsService;
        if (iJsService2 == null) {
            QLog.e("MiniSDKClientQIPCModule", 1, "jsService == null");
            return;
        }
        boolean z16 = bundle.getBoolean("miniAppShareIsComplete", false);
        String string = bundle.getString("miniAppShareEvent");
        String string2 = bundle.getString("miniAppShareAppid");
        String string3 = bundle.getString("miniAppShareTemplateId");
        int i3 = bundle.getInt("miniAppShareCallbackId");
        int i16 = bundle.getInt("miniAppShareUpdatableMsgFrom");
        int i17 = bundle.getInt("miniAppShareSubScene", -1);
        if (z16) {
            int i18 = bundle.getInt("uintype");
            int i19 = (i18 != 1 && i18 == 0) ? 1 : 0;
            String string4 = bundle.getString("uin");
            if (QLog.isColorLevel()) {
                QLog.i("MiniSDKClientQIPCModule", 1, "doCreateUpdatableMsgCallback, appid:" + string2 + ", templateId:" + string3 + ", from:" + i16 + ", scene:" + i19 + ", uin:" + string4 + ", subScene:" + i17);
            }
            s(iJsService2, string, string2, string3, i16, i19, i17, string4, i3);
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("retCode", 1);
            jSONObject = ApiUtil.wrapCallbackFail(string, jSONObject, ShareJsPlugin.ERRMSG_INVITE_CANCEL);
        } catch (Throwable th6) {
            th6.printStackTrace();
        }
        iJsService2.evaluateCallbackJs(i3, jSONObject.toString());
    }

    private void o(Bundle bundle) {
        if (bundle != null) {
            try {
                int i3 = bundle.getInt(MiniChatConstants.PARAM_PROC_BADGE_COUNT);
                if (QMLog.isDebugEnabled()) {
                    QMLog.d("MiniSDKClientQIPCModule", "count is " + i3);
                }
                BaseRuntime currentRuntime = AppLoaderFactory.g().getCommonManager().getCurrentRuntime();
                if (currentRuntime != null && currentRuntime.getPage() != null) {
                    ICapsuleButton capsuleButton = currentRuntime.getPage().getCapsuleButton();
                    if (capsuleButton == null) {
                        QMLog.w("MiniSDKClientQIPCModule", "capsule button is null");
                        return;
                    }
                    QMLog.i("MiniSDKClientQIPCModule", BaseApplicationImpl.getApplication().getQQProcessName() + " msg count = " + i3);
                    capsuleButton.setUnReadCount(i3, true);
                    return;
                }
                QMLog.w("MiniSDKClientQIPCModule", "runtime or page is null");
            } catch (Exception e16) {
                QMLog.e("MiniSDKClientQIPCModule", "onSyncUnReadCount error", e16);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p(final BaseRuntime baseRuntime, final String str, final String str2, final int i3, final String str3) {
        ThreadManager.getSubThreadHandler().post(new Runnable() { // from class: com.tencent.qqmini.proxyimpl.MiniSDKClientQIPCModule.4
            @Override // java.lang.Runnable
            public void run() {
                MiniAppConfig h16 = aq.h(baseRuntime.getMiniAppInfo());
                String appType = MiniProgramLpReportDC04239.getAppType(h16);
                String pageUrl = "0".equals(appType) ? ActionBridge.PageActionBridge.getPageUrl(baseRuntime) : null;
                MiniProgramLpReportDC04239.report(h16, appType, pageUrl, "user_click", "custom_button", str, str2, String.valueOf(i3), pageUrl, str3, null);
                MiniProgramReporter.getInstance().flush();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q(final BaseRuntime baseRuntime, final String str) {
        ThreadManager.getSubThreadHandler().post(new Runnable() { // from class: com.tencent.qqmini.proxyimpl.MiniSDKClientQIPCModule.5
            @Override // java.lang.Runnable
            public void run() {
                MiniProgramLpReportDC04239.reportApiInvoke(aq.h(baseRuntime.getMiniAppInfo()), str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r(BaseRuntime baseRuntime, String str, String str2, String str3, String str4, int i3, RequestEvent requestEvent) {
        MiniAppCmdUtil.getInstance().sendArkMsg(null, str3, str2, str4, requestEvent.event, new c(requestEvent, baseRuntime, str, i3));
    }

    public static void registerModule() {
        MiniSDKClientQIPCModule i3 = i();
        try {
            QMLog.i("MiniSDKClientQIPCModule", "register " + i3);
            QIPCClientHelper.getInstance().register(i3);
        } catch (Exception e16) {
            QLog.e("MiniSDKClientQIPCModule", 1, "register ipc module error.", e16);
        }
    }

    private void s(IJsService iJsService, String str, String str2, String str3, int i3, int i16, int i17, String str4, int i18) {
        MiniAppCmdUtil.getInstance().createUpdatableMsg(str2, str3, i3, i16, i17, str4, new d(str, iJsService, i18));
    }

    public static void unRegisterModule() {
        QMLog.i("MiniSDKClientQIPCModule", "unregister");
        QIPCClientHelper.getInstance().getClient().unRegisterModule(i());
    }

    @Override // eipc.EIPCModule
    public EIPCResult onCall(String str, Bundle bundle, int i3) {
        if (QLog.isColorLevel()) {
            QLog.d("MiniSDKClientQIPCModule", 2, "onCall main server action=" + str);
        }
        if (MiniChatConstants.ACTION_SYNC_UNREADCOUNT.equals(str)) {
            o(bundle);
            return null;
        }
        if (MiniChatConstants.ACTION_MINI_SHARE_SUC_CALLBACK.equals(str)) {
            m(true);
            return null;
        }
        if (MiniChatConstants.ACTION_MINI_SHARE_FAIL_CALLBACK.equals(str)) {
            m(false);
            return null;
        }
        if (MiniChatConstants.ACTION_MINI_DIRECT_SHARE_SUC_CALLBACK.equals(str)) {
            l(true);
            return null;
        }
        if (MiniChatConstants.ACTION_MINI_DIRECT_SHARE_FAIL_CALLBACK.equals(str)) {
            l(false);
            return null;
        }
        if (MiniChatConstants.ACTION_MINI_REPORT_EVENT.equals(str)) {
            return null;
        }
        if (MiniChatConstants.ACTION_MINI_CREATE_UPDATABLE_MSG_CALLBACK.equals(str)) {
            n(bundle);
            return null;
        }
        if (!MiniChatConstants.ACTION_MINI_START_MINI_AIO.equals(str)) {
            return null;
        }
        MiniChatActivity.J2(bundle, true, false, false);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes34.dex */
    public class c implements MiniAppCmdInterface {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ RequestEvent f347467a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ BaseRuntime f347468b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f347469c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f347470d;

        c(RequestEvent requestEvent, BaseRuntime baseRuntime, String str, int i3) {
            this.f347467a = requestEvent;
            this.f347468b = baseRuntime;
            this.f347469c = str;
            this.f347470d = i3;
        }

        @Override // com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface
        public void onCmdListener(boolean z16, JSONObject jSONObject) {
            if (jSONObject == null) {
                this.f347467a.fail();
                MiniSDKClientQIPCModule.this.p(this.f347468b, SDKMiniProgramLpReportDC04239.MORE_BUTTON_RESERVERS_SHARE_OTHER + this.f347467a.event, "fail", 3, "request fail");
                return;
            }
            QLog.d("MiniSDKClientQIPCModule", 1, "ret:" + jSONObject);
            JSONObject jSONObject2 = new JSONObject();
            try {
                if (z16) {
                    int i3 = jSONObject.getInt("retCode");
                    String string = jSONObject.getString("errMsg");
                    if (i3 == 0) {
                        this.f347467a.ok();
                        MiniSDKClientQIPCModule.this.p(this.f347468b, SDKMiniProgramLpReportDC04239.MORE_BUTTON_RESERVERS_SHARE_OTHER + this.f347467a.event, "success", 3, null);
                        MiniSDKClientQIPCModule.this.q(this.f347468b, "share_success");
                        if (this.f347469c.equals("shareMessageToFriend")) {
                            MiniSDKClientQIPCModule.this.g(jSONObject2, this.f347468b, this.f347470d, "", true, ApiUtil.wrapCallbackOk(this.f347469c, jSONObject2));
                        }
                    } else {
                        jSONObject2.put("errMsg", string);
                        jSONObject2.put("errCode", i3);
                        this.f347467a.fail(jSONObject2, string);
                        MiniSDKClientQIPCModule.this.g(jSONObject2, this.f347468b, this.f347470d, string, false, ApiUtil.wrapCallbackFail(this.f347469c, jSONObject2));
                        MiniSDKClientQIPCModule.this.p(this.f347468b, SDKMiniProgramLpReportDC04239.MORE_BUTTON_RESERVERS_SHARE_OTHER + this.f347467a.event, "fail", 3, i3 + "," + string);
                    }
                } else {
                    this.f347467a.fail();
                    MiniSDKClientQIPCModule.this.g(jSONObject2, this.f347468b, this.f347470d, "\u8bf7\u6c42\u5931\u8d25", false, ApiUtil.wrapCallbackFail(this.f347469c, jSONObject2));
                    MiniSDKClientQIPCModule.this.p(this.f347468b, SDKMiniProgramLpReportDC04239.MORE_BUTTON_RESERVERS_SHARE_OTHER + this.f347467a.event, "fail", 3, "request fail");
                }
            } catch (Throwable unused) {
                this.f347467a.fail();
                MiniSDKClientQIPCModule.this.g(jSONObject2, this.f347468b, this.f347470d, "\u8bf7\u6c42\u5931\u8d25", false, ApiUtil.wrapCallbackFail(this.f347469c, jSONObject2));
                MiniSDKClientQIPCModule.this.p(this.f347468b, SDKMiniProgramLpReportDC04239.MORE_BUTTON_RESERVERS_SHARE_OTHER + this.f347467a.event, "fail", 3, "request exception");
            }
        }
    }
}
