package com.tencent.qqmini.proxyimpl;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Html;
import android.text.TextUtils;
import android.view.View;
import com.huawei.hms.support.feature.result.CommonConstant;
import com.qq.e.comm.pi.AppDownloadCallback;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.gamecenter.api.IYunGameChannelApi;
import com.tencent.mobileqq.gamecenter.qa.api.IMetaDreamService;
import com.tencent.mobileqq.mini.MiniAppInterface;
import com.tencent.mobileqq.mini.api.MiniConst;
import com.tencent.mobileqq.mini.app.AuthorizeCenter;
import com.tencent.mobileqq.mini.manager.MiniAppDetainManager;
import com.tencent.mobileqq.mini.qbox.QBoxMiniLoadingView;
import com.tencent.mobileqq.mini.reuse.MiniAppTransferModule;
import com.tencent.mobileqq.mini.widget.EmptyCustomMiniGameNavigationBar;
import com.tencent.mobileqq.minigame.api.IMiniGameVAManager;
import com.tencent.mobileqq.minigame.report.StartupReportDispatcher;
import com.tencent.mobileqq.minigame.ui.dialog.QQCustomDialogForExpireTip;
import com.tencent.mobileqq.minigame.ui.loading.MiniGameCustomLoadingView;
import com.tencent.mobileqq.minigame.va.VADownloadNetEventHandler;
import com.tencent.mobileqq.minigame.va.util.MiniGameVAUtil;
import com.tencent.mobileqq.minispecial.api.impl.ThirdPartyMiniApiImpl;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.handler.INetEventHandler;
import com.tencent.mobileqq.qcircle.api.utils.QCircleDeviceInfoUtils;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qqsomonitor.api.ISoMonitorApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qq.minibox.api.IHttpTransferSSOApi;
import com.tencent.qqmini.custom.MiniGameQQNavigationBar;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.launcher.core.BaseRuntime;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.proxy.AsyncObjectResult;
import com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult;
import com.tencent.qqmini.sdk.launcher.core.proxy.QQCustomizedProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.YunGameProxy;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.launcher.model.StartupReportData;
import com.tencent.qqmini.sdk.launcher.ui.BaseGameLoadingView;
import com.tencent.qqmini.sdk.launcher.ui.BaseGameNavigationBar;
import com.tencent.turingfd.sdk.xq.ITuringDID;
import com.tencent.widget.calloutpopupwindow.CalloutPopupWindow;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;
import kotlin.Pair;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes34.dex */
public class QQCustomizedProxyImpl extends QQCustomizedProxy {

    /* renamed from: b, reason: collision with root package name */
    private static final String[] f347502b = {MiniConst.QBoxConst.APP_ID};

    /* renamed from: a, reason: collision with root package name */
    private INetEventHandler f347503a = null;

    /* loaded from: classes34.dex */
    class a implements EIPCResultCallback {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ AsyncResult f347505d;

        a(AsyncResult asyncResult) {
            this.f347505d = asyncResult;
        }

        @Override // eipc.EIPCResultCallback
        public void onCallback(EIPCResult eIPCResult) {
            boolean z16;
            if (eIPCResult != null) {
                try {
                    z16 = eIPCResult.data.getBoolean("isAdded");
                } catch (Exception e16) {
                    QMLog.e("QQCustomizedProxyImpl", "[isAddedToMyApps],ex:" + e16);
                    return;
                }
            } else {
                z16 = false;
            }
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("isAdded", z16);
            this.f347505d.onReceiveResult(true, jSONObject);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes34.dex */
    public class b implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ QQCustomDialogForExpireTip f347507d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ boolean f347508e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ Activity f347509f;

        b(QQCustomDialogForExpireTip qQCustomDialogForExpireTip, boolean z16, Activity activity) {
            this.f347507d = qQCustomDialogForExpireTip;
            this.f347508e = z16;
            this.f347509f = activity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f347507d.dismiss();
            if (this.f347508e) {
                return;
            }
            this.f347509f.finish();
        }
    }

    /* loaded from: classes34.dex */
    class c implements IHttpTransferSSOApi.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ AsyncResult f347511a;

        c(AsyncResult asyncResult) {
            this.f347511a = asyncResult;
        }

        @Override // com.tencent.qq.minibox.api.IHttpTransferSSOApi.a
        public void a(boolean z16, JSONObject jSONObject) {
            if (z16) {
                QLog.d("QQCustomizedProxyImpl", 2, "httpToSsoRequest isSuccess:true rspJson:" + jSONObject);
            } else {
                QLog.i("QQCustomizedProxyImpl", 1, "httpToSsoRequest isSuccess:false rspJson:" + jSONObject);
            }
            this.f347511a.onReceiveResult(z16, jSONObject);
        }
    }

    private String f(MiniAppInfo miniAppInfo) {
        if (miniAppInfo == null) {
            return null;
        }
        String str = miniAppInfo.extInfo;
        if (!TextUtils.isEmpty(str) && str.contains(ThirdPartyMiniApiImpl.KEY_GAME_APP_ID)) {
            try {
                JSONArray optJSONArray = new JSONObject(str).optJSONArray(ThirdPartyMiniApiImpl.KEY_MAP_INFO);
                if (optJSONArray != null && optJSONArray.length() > 0) {
                    for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                        JSONObject jSONObject = optJSONArray.getJSONObject(i3);
                        if (jSONObject != null && ThirdPartyMiniApiImpl.KEY_GAME_APP_ID.equals(jSONObject.optString("key"))) {
                            String optString = jSONObject.optString("value");
                            if (QLog.isColorLevel()) {
                                QLog.d("QQCustomizedProxyImpl", 2, "getGameAppIdFromExt id=" + miniAppInfo.appId + ", gameAppId=" + optString);
                            }
                            return optString;
                        }
                    }
                }
                return null;
            } catch (Throwable th5) {
                QLog.e("QQCustomizedProxyImpl", 1, "getGameAppIdFromExt throw t:", th5);
            }
        }
        return null;
    }

    private MiniGameCustomLoadingView g(Context context, String str) {
        Pair<String, String> loadingBgUrl = ((IMiniGameVAManager) QRoute.api(IMiniGameVAManager.class)).getLoadingBgUrl(str);
        if (loadingBgUrl == null) {
            return null;
        }
        String first = loadingBgUrl.getFirst();
        String second = loadingBgUrl.getSecond();
        if (TextUtils.isEmpty(first) || TextUtils.isEmpty(second)) {
            return null;
        }
        return new MiniGameCustomLoadingView(context, first, second, false).setMiniAppId(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void i(Context context, String str) {
        AuthorizeCenter authorizeCenter;
        if (context instanceof QBaseActivity) {
            AppInterface appInterface = ((BaseActivity) context).getAppInterface();
            if (!(appInterface instanceof MiniAppInterface) || (authorizeCenter = ((MiniAppInterface) appInterface).getAuthorizeCenter(str)) == null) {
                return;
            }
            authorizeCenter.roamAuthState(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void j(Activity activity, String str, String str2, String str3, boolean z16) {
        QQCustomDialogForExpireTip qQCustomDialogForExpireTip = new QQCustomDialogForExpireTip(activity, R.style.ayi);
        qQCustomDialogForExpireTip.setButtonTitle(str).setTitle(str2).setMessage(Html.fromHtml(str3)).setClickListener(new b(qQCustomDialogForExpireTip, z16, activity));
        qQCustomDialogForExpireTip.setCancelable(z16);
        qQCustomDialogForExpireTip.setCanceledOnTouchOutside(false);
        qQCustomDialogForExpireTip.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void k(AsyncResult asyncResult, String str, String str2, String str3, String str4, String str5) {
        if (!TextUtils.isEmpty(str4) && !TextUtils.isEmpty(str2)) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("openId", str4);
                jSONObject.put(CommonConstant.KEY_ACCESS_TOKEN, str2);
                jSONObject.put("payToken", str3);
                jSONObject.put("qqAppId", str);
                asyncResult.onReceiveResult(true, jSONObject);
                return;
            } catch (Exception e16) {
                asyncResult.onReceiveResult(false, null);
                QLog.e("QQCustomizedProxyImpl", 1, "fastLogin get resultJsonObj exception=", e16);
                return;
            }
        }
        QLog.e("QQCustomizedProxyImpl", 1, "fastLogin get ticket failed");
        asyncResult.onReceiveResult(false, null);
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.QQCustomizedProxy
    public void add2MyApps(MiniAppInfo miniAppInfo) {
        QLog.i("QQCustomizedProxyImpl", 1, "[add2MyApps]");
        if (miniAppInfo == null) {
            return;
        }
        miniAppInfo.topType = 1;
        MiniAppProxyImpl.W(miniAppInfo);
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.QQCustomizedProxy
    public void checkShowExpireDialog(final MiniAppInfo miniAppInfo, final Activity activity, JSONObject jSONObject) {
        JSONObject optJSONObject;
        super.checkShowExpireDialog(miniAppInfo, activity, jSONObject);
        if (QLog.isColorLevel()) {
            QLog.d("QQCustomizedProxyImpl", 2, "checkShowExpireDialog appId=" + miniAppInfo.appId + ", jsonRsp=" + jSONObject);
        }
        if (activity != null && jSONObject != null && (optJSONObject = jSONObject.optJSONObject("miniPopupInfo")) != null) {
            final String optString = optJSONObject.optString("title");
            final String optString2 = optJSONObject.optString("popupContent");
            final String optString3 = optJSONObject.optString(AppDownloadCallback.BUTTON_TXT);
            final boolean optBoolean = optJSONObject.optBoolean("enableGame", true);
            if (!TextUtils.isEmpty(optString2)) {
                activity.runOnUiThread(new Runnable() { // from class: com.tencent.qqmini.proxyimpl.ay
                    @Override // java.lang.Runnable
                    public final void run() {
                        QQCustomizedProxyImpl.this.j(activity, optString3, optString, optString2, optBoolean);
                    }
                });
            }
        }
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.qqmini.proxyimpl.QQCustomizedProxyImpl.3
            @Override // java.lang.Runnable
            public void run() {
                MiniAppDetainManager.INSTANCE.checkInitMiniGameRetainInfo(miniAppInfo);
            }
        }, 64, null, false);
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.QQCustomizedProxy
    public void clearNetEventHandler(Context context) {
        INetEventHandler iNetEventHandler = this.f347503a;
        if (iNetEventHandler != null) {
            AppNetConnInfo.unregisterNetEventHandler(iNetEventHandler);
            this.f347503a = null;
        }
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.QQCustomizedProxy
    public Dialog createQQCenterTextDialog(Context context, int i3, String str, String str2, String str3, String str4, DialogInterface.OnClickListener onClickListener, DialogInterface.OnClickListener onClickListener2) {
        return DialogUtil.createCenterTextDialog(context, i3, str, str2, str3, str4, onClickListener, onClickListener2);
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.QQCustomizedProxy
    public boolean disableHeartBeatCheck(MiniAppInfo miniAppInfo) {
        return isCustomMiniGame(miniAppInfo);
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.QQCustomizedProxy
    public boolean disableNewTask(MiniAppInfo miniAppInfo) {
        return aq.i(miniAppInfo);
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.QQCustomizedProxy
    public String getCustomPackageLoadFailToast(Context context, MiniAppInfo miniAppInfo) {
        return null;
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.QQCustomizedProxy
    public String getDebugJsPath() {
        return null;
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.QQCustomizedProxy
    public String getDebugTritonPath() {
        return null;
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.QQCustomizedProxy
    public int getDeviceLevel() {
        return QCircleDeviceInfoUtils.getLevel();
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.QQCustomizedProxy
    public void getOAID(boolean z16, final AsyncResult asyncResult) {
        final IMetaDreamService iMetaDreamService;
        if (QLog.isColorLevel()) {
            QLog.d("QQCustomizedProxyImpl", 2, "getOAID shouldDecode=", Boolean.valueOf(z16));
        }
        if (z16) {
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            if (peekAppRuntime == null) {
                QLog.d("QQCustomizedProxyImpl", 1, "getOAID appRuntime null");
                asyncResult.onReceiveResult(false, null);
                return;
            }
            iMetaDreamService = (IMetaDreamService) peekAppRuntime.getRuntimeService(IMetaDreamService.class, "all");
            String savedOAID = iMetaDreamService.getSavedOAID();
            if (!TextUtils.isEmpty(savedOAID)) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("oaid", savedOAID);
                    asyncResult.onReceiveResult(true, jSONObject);
                    QLog.d("QQCustomizedProxyImpl", 1, "getOAID from local saved");
                    return;
                } catch (Exception e16) {
                    asyncResult.onReceiveResult(false, null);
                    QLog.e("QQCustomizedProxyImpl", 1, "getOAID get resultJsonObj exception1=", e16);
                    return;
                }
            }
        } else {
            iMetaDreamService = null;
        }
        ITuringDID c16 = com.tencent.mobileqq.turingfd.c.a().c(true);
        if (c16 == null) {
            QLog.d("QQCustomizedProxyImpl", 1, "getOAID turingDID null");
            asyncResult.onReceiveResult(false, null);
            return;
        }
        String aIDTicket = c16.getAIDTicket();
        if (TextUtils.isEmpty(aIDTicket)) {
            QLog.d("QQCustomizedProxyImpl", 1, "getOAID oaidTicket null");
            asyncResult.onReceiveResult(false, null);
        } else {
            if (z16) {
                iMetaDreamService.getOAIDFromServer(aIDTicket, new sd1.a() { // from class: com.tencent.qqmini.proxyimpl.az
                    @Override // sd1.a
                    public final void onGetOAID(boolean z17, String str) {
                        QQCustomizedProxyImpl.l(IMetaDreamService.this, asyncResult, z17, str);
                    }
                });
                return;
            }
            try {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("oaid", aIDTicket);
                asyncResult.onReceiveResult(true, jSONObject2);
            } catch (Exception e17) {
                asyncResult.onReceiveResult(false, null);
                QLog.e("QQCustomizedProxyImpl", 1, "getOAID get resultJsonObj exception3=", e17);
            }
        }
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.QQCustomizedProxy
    public String getRequiredContainerVersion() {
        return "3.2.0";
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.QQCustomizedProxy
    public void httpToSsoRequest(JSONObject jSONObject, AsyncResult asyncResult) {
        super.httpToSsoRequest(jSONObject, asyncResult);
        ((IHttpTransferSSOApi) QRoute.api(IHttpTransferSSOApi.class)).sendReq(jSONObject, new c(asyncResult));
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.QQCustomizedProxy
    public void isAdded2MyApps(String str, AsyncResult asyncResult) {
        if (TextUtils.isEmpty(str) || asyncResult == null) {
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putString("appId", str);
        QIPCClientHelper.getInstance().callServer("MiniAppTransferModule", MiniAppTransferModule.ACTION_CHECK_IS_IN_MY_APP_LIST, bundle, new a(asyncResult));
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.QQCustomizedProxy
    public boolean isCustomMiniGame(MiniAppInfo miniAppInfo) {
        return h(miniAppInfo);
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.QQCustomizedProxy
    public boolean isMiniAppConsumeBackPress(MiniAppInfo miniAppInfo) {
        return aq.i(miniAppInfo);
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.QQCustomizedProxy
    public boolean needCustomActivityAnim(MiniAppInfo miniAppInfo) {
        return aq.i(miniAppInfo);
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.QQCustomizedProxy
    public void registerSoFilePath(String str) {
        ((ISoMonitorApi) QRoute.api(ISoMonitorApi.class)).registerSoFilePath(MobileQQ.sMobileQQ, str);
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.QQCustomizedProxy
    public void reportStartup(StartupReportData startupReportData) {
        StartupReportDispatcher.reportAsync(startupReportData);
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.QQCustomizedProxy
    public void setActivityAnim(MiniAppInfo miniAppInfo, Activity activity) {
        if (aq.i(miniAppInfo)) {
            activity.overridePendingTransition(R.anim.f154454a3, 0);
        }
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.QQCustomizedProxy
    public void setNetChangeReceiver(Context context, AsyncObjectResult asyncObjectResult) {
        INetEventHandler iNetEventHandler = this.f347503a;
        if (iNetEventHandler != null) {
            AppNetConnInfo.unregisterNetEventHandler(iNetEventHandler);
        }
        VADownloadNetEventHandler vADownloadNetEventHandler = new VADownloadNetEventHandler(asyncObjectResult);
        this.f347503a = vADownloadNetEventHandler;
        AppNetConnInfo.registerNetChangeReceiver(context, vADownloadNetEventHandler);
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.QQCustomizedProxy
    public void showCallOutPopupWindow(View view, String str) {
        CalloutPopupWindow build = new CalloutPopupWindow.DrawableBuilder(CalloutPopupWindow.builder(view.getContext()).setText(str).setTextSize(14.0f).setVerticalPaddingDp(6).setHorizontalPaddingDp(12).setTextColor(-1).setPosition(50).setLifetime(3)).setBackgroundColor(Color.parseColor("#7F000000")).setBackgroundRadius(8).build().build();
        build.setMarginScreen(ViewUtils.dip2px(8.0f));
        build.showAsPointer(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void l(IMetaDreamService iMetaDreamService, AsyncResult asyncResult, boolean z16, String str) {
        QLog.d("QQCustomizedProxyImpl", 1, "getOAID from server, success=", Boolean.valueOf(z16));
        iMetaDreamService.removeGetOAIDCallback();
        if (!z16) {
            asyncResult.onReceiveResult(false, null);
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("oaid", str);
            asyncResult.onReceiveResult(true, jSONObject);
        } catch (Exception e16) {
            asyncResult.onReceiveResult(false, null);
            QLog.e("QQCustomizedProxyImpl", 1, "getOAID get resultJsonObj exception2=", e16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void m() {
        QLog.i("QQCustomizedProxyImpl", 1, "handleMiniExit check guide bubble");
        QIPCClientHelper.getInstance().callServer("MiniAppTransferModule", MiniAppTransferModule.ACTION_CHECK_META_GUIDE_BUBBLE_RED_TOUCH, new Bundle());
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.QQCustomizedProxy
    public void checkRoamLocalAuthState(final Context context, final String str) {
        QLog.i("QQCustomizedProxyImpl", 1, "checkRoamLocalAuthState");
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.qqmini.proxyimpl.ba
            @Override // java.lang.Runnable
            public final void run() {
                QQCustomizedProxyImpl.i(context, str);
            }
        }, 64, null, false);
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.QQCustomizedProxy
    public void openFeedbackPage(IMiniAppContext iMiniAppContext) {
        aq.n(iMiniAppContext, false);
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.QQCustomizedProxy
    public void fastLogin(MiniAppInfo miniAppInfo, final AsyncResult asyncResult) {
        YunGameProxyImpl yunGameProxyImpl;
        JSONObject o16;
        if (miniAppInfo == null) {
            QLog.e("QQCustomizedProxyImpl", 1, "fastLogin miniAppInfo null");
            asyncResult.onReceiveResult(false, null);
            return;
        }
        final String f16 = f(miniAppInfo);
        if (TextUtils.isEmpty(f16)) {
            QLog.e("QQCustomizedProxyImpl", 1, "fastLogin gameAppId null");
            asyncResult.onReceiveResult(false, null);
            return;
        }
        if (MobileQQ.sProcessId != 1) {
            YunGameProxy yunGameProxy = (YunGameProxy) ProxyManager.get(YunGameProxy.class);
            if ((yunGameProxy instanceof YunGameProxyImpl) && (o16 = (yunGameProxyImpl = (YunGameProxyImpl) yunGameProxy).o(f16)) != null) {
                QLog.i("QQCustomizedProxyImpl", 1, "YunGame fastLogin use cache info");
                yunGameProxyImpl.u(f16, Boolean.FALSE, null);
                asyncResult.onReceiveResult(true, o16);
                return;
            }
        }
        QLog.i("QQCustomizedProxyImpl", 1, "YunGame start fastLogin");
        ((IYunGameChannelApi) QRoute.api(IYunGameChannelApi.class)).startGetLaunchKeys(f16, new IYunGameChannelApi.OnGetLaunchKeyListener() { // from class: com.tencent.qqmini.proxyimpl.bb
            @Override // com.tencent.mobileqq.gamecenter.api.IYunGameChannelApi.OnGetLaunchKeyListener
            public final void onResult(String str, String str2, String str3, String str4) {
                QQCustomizedProxyImpl.k(AsyncResult.this, f16, str, str2, str3, str4);
            }
        });
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.QQCustomizedProxy
    public void handleMiniExit(Activity activity, BaseRuntime baseRuntime, boolean z16, boolean z17, boolean z18) {
        if (baseRuntime == null || baseRuntime.getMiniAppInfo() == null || !MiniGameVAUtil.META_MINI_GAME_APPID.equals(baseRuntime.getMiniAppInfo().appId)) {
            return;
        }
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.qqmini.proxyimpl.ax
            @Override // java.lang.Runnable
            public final void run() {
                QQCustomizedProxyImpl.m();
            }
        }, 64, null, false);
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.QQCustomizedProxy
    public BaseGameLoadingView createCustomLoadingView(Context context, MiniAppInfo miniAppInfo) {
        String str;
        if (miniAppInfo == null || (str = miniAppInfo.appId) == null) {
            return null;
        }
        str.hashCode();
        if (!str.equals(MiniConst.QBoxConst.APP_ID)) {
            if (!str.equals(MiniConst.MetaRoomConst.META_ROOM_MINI_APP_ID)) {
                MiniGameCustomLoadingView g16 = g(context, miniAppInfo.appId);
                if (g16 != null) {
                    return g16;
                }
                return null;
            }
            QLog.e("QQCustomizedProxyImpl", 1, "createCustomLoadingView: is meta room");
            return null;
        }
        QLog.d("QQCustomizedProxyImpl", 1, "createCustomLoadingView: is qbox");
        return new QBoxMiniLoadingView(context);
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.QQCustomizedProxy
    public BaseGameNavigationBar createCustomNavigationBar(Context context, MiniAppInfo miniAppInfo) {
        String str;
        if (miniAppInfo == null || (str = miniAppInfo.appId) == null) {
            return null;
        }
        str.hashCode();
        if (!str.equals(MiniConst.QBoxConst.APP_ID)) {
            if (!str.equals(MiniConst.MetaRoomConst.META_ROOM_MINI_APP_ID)) {
                if (miniAppInfo.isEngineTypeMiniGame()) {
                    return new MiniGameQQNavigationBar(context);
                }
                return null;
            }
            QLog.e("QQCustomizedProxyImpl", 1, "createCustomNavigationBar: is meta room");
            return null;
        }
        QLog.d("QQCustomizedProxyImpl", 1, "createCustomNavigationBar: is qbox");
        return new EmptyCustomMiniGameNavigationBar(context);
    }

    private static boolean h(MiniAppInfo miniAppInfo) {
        if (miniAppInfo == null) {
            return false;
        }
        for (String str : f347502b) {
            if (str.equals(miniAppInfo.appId)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.QQCustomizedProxy
    public long getRequestLandscapeDelay(Activity activity) {
        int intExtra;
        if (activity == null) {
            return 0L;
        }
        Intent intent = activity.getIntent();
        if (intent != null && (intExtra = intent.getIntExtra(MiniGameVAUtil.KEY_META_MINI_GAME_ACTIVITY_ANIM_DURATION, 0)) > 0) {
            long currentTimeMillis = System.currentTimeMillis() - intent.getLongExtra(MiniGameVAUtil.KEY_META_MINI_GAME_ACTIVITY_ANIM_START_TS, 0L);
            long j3 = intExtra;
            long j16 = (currentTimeMillis < j3 ? j3 - currentTimeMillis : 0L) + 50;
            QLog.d("QQCustomizedProxyImpl", 1, "getRequestLandscapeDelay delay=", Long.valueOf(j16), ", animDuration=", Integer.valueOf(intExtra), ", currentDuration=", Long.valueOf(currentTimeMillis));
            return j16;
        }
        return super.getRequestLandscapeDelay(activity);
    }
}
