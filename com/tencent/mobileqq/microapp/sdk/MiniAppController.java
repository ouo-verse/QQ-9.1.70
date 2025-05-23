package com.tencent.mobileqq.microapp.sdk;

import Wallet.ApkgConfig;
import android.app.Activity;
import android.app.Application;
import android.content.Intent;
import android.os.ResultReceiver;
import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.qwallet.preload.DownloadParam;
import com.tencent.mobileqq.activity.qwallet.preload.PreloadManager;
import com.tencent.mobileqq.activity.qwallet.report.VACDReportUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.microapp.a.c;
import com.tencent.mobileqq.microapp.apkg.AppInfo;
import com.tencent.mobileqq.microapp.apkg.MiniAppConfig;
import com.tencent.mobileqq.microapp.apkg.UsedAppListManager;
import com.tencent.mobileqq.microapp.apkg.g;
import com.tencent.mobileqq.microapp.app.AppBrandTaskPreloadReceiver;
import com.tencent.mobileqq.microapp.appbrand.b.b;
import com.tencent.mobileqq.microapp.appbrand.ui.AppBrandUI;
import com.tencent.mobileqq.microapp.ext.ManagerProxy;
import com.tencent.mobileqq.microapp.webview.BaseAppBrandWebview;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.app.AppRuntime;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes15.dex */
public class MiniAppController {
    static IPatchRedirector $redirector_ = null;
    public static final int ACTION_REQUEST_API_PERMISSION = 5;
    public static final int ACTION_REQUEST_CODE_CAMERA = 4;
    public static final int ACTION_REQUEST_CODE_CHOOSE_LOCATION = 3;
    public static final int ACTION_REQUEST_CODE_GET_VIDEO = 2;
    public static final int ACTION_REQUEST_CODE_LOAD_MINI_CONF = 1;
    public static final int ACTION_REQUEST_CODE_PAY = 3001;
    public static final int ACTION_REQUEST_OPEN_BLUETOOTH = 6;
    public static final int ACTION_REQUEST_SHARE = 7;
    public static final String TAG = "MiniAppController";
    private static MiniAppController instance;
    private static byte[] lock;
    private static final AtomicInteger seqFactory;
    private ActivityResultListener activityResultListener;
    private SparseArray bridgeListenerMap;
    private SparseArray bridgeMap;
    private List outJsPluginList;

    /* compiled from: P */
    /* loaded from: classes15.dex */
    public interface ActivityResultListener {
        void doOnActivityResult(int i3, int i16, Intent intent);
    }

    /* compiled from: P */
    /* loaded from: classes15.dex */
    public interface IBridgeListener {
        void onResult(String str, String str2);
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(16662);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 10)) {
            redirector.redirect((short) 10);
        } else {
            lock = new byte[0];
            seqFactory = new AtomicInteger(new Random().nextInt(100000));
        }
    }

    MiniAppController() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.outJsPluginList = new ArrayList();
        this.bridgeMap = new SparseArray();
        this.bridgeListenerMap = new SparseArray();
    }

    public static MiniAppController getInstance() {
        if (instance == null) {
            synchronized (lock) {
                if (instance == null) {
                    instance = new MiniAppController();
                }
            }
        }
        return instance;
    }

    private static synchronized int getNextSeq() {
        int incrementAndGet;
        synchronized (MiniAppController.class) {
            AtomicInteger atomicInteger = seqFactory;
            incrementAndGet = atomicInteger.incrementAndGet();
            if (incrementAndGet > 1000000) {
                atomicInteger.set(new Random().nextInt(100000) + 60000);
            }
        }
        return incrementAndGet;
    }

    public static void handleNoCatchCrash(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.e("MiniAppController", 2, str);
        }
        VACDReportUtil.singleReport("no_catch_crash", "MiniAppStat", "MiniAppCrashReport", "NoCatch", (String) null, 88889, str);
    }

    private static void preDownApkgResources(MiniAppConfig miniAppConfig) {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.microapp.sdk.MiniAppController.1
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) MiniAppConfig.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                AppRuntime runtime = BaseApplicationImpl.getApplication().getRuntime();
                if (runtime != null && (runtime instanceof QQAppInterface) && MiniAppConfig.this != null) {
                    QQAppInterface qQAppInterface = (QQAppInterface) runtime;
                    if (QLog.isColorLevel()) {
                        QLog.d("MiniAppController", 2, "preDownApkgResources start");
                    }
                    PreloadManager preloadManager = ManagerProxy.getPreloadManager(qQAppInterface);
                    DownloadParam downloadParam = new DownloadParam();
                    downloadParam.filePos = 1;
                    downloadParam.url = MiniAppConfig.this.baseLibInfo.baseLibUrl;
                    preloadManager.getResPath(downloadParam, (PreloadManager.OnGetPathListener) null);
                    if (!new File(g.a(MiniAppConfig.this.config)).exists()) {
                        DownloadParam downloadParam2 = new DownloadParam();
                        downloadParam2.headers = new LinkedList();
                        downloadParam2.url = MiniAppConfig.this.config.apkg_url + "?sign=" + URLEncoder.encode(MiniAppConfig.this.config.cos_sign);
                        preloadManager.getResPath(downloadParam2, (PreloadManager.OnGetPathListener) null);
                    }
                }
            }
        }, 16, null, true);
    }

    public static void preloadMiniProcess(Application application) {
        Intent intent = new Intent();
        intent.setClass(application, AppBrandTaskPreloadReceiver.class);
        application.sendBroadcast(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void reportShareInfo(String str, String str2) {
        if (QLog.isColorLevel()) {
            QLog.d("MiniAppController", 2, "reportShareInfo appId=" + str + "pagePath=" + str2);
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("miniAppId", str);
            jSONObject.put("page", str2);
            VACDReportUtil.singleReport(jSONObject.toString(), "MiniAppStat", "MiniAppShareReport", (String) null, (String) null, 0, (String) null);
        } catch (Throwable unused) {
        }
    }

    public static void startApp(Activity activity, MiniAppConfig miniAppConfig, ResultReceiver resultReceiver) throws MiniAppException {
        if (activity != null && miniAppConfig != null) {
            Intent intent = new Intent(activity, (Class<?>) AppBrandUI.class);
            intent.addFlags(536936448);
            intent.putExtra("CONFIG", miniAppConfig);
            intent.putExtra("receiver", resultReceiver);
            activity.startActivity(intent);
            c.a(activity);
            preDownApkgResources(miniAppConfig);
            ApkgConfig apkgConfig = miniAppConfig.config;
            UsedAppListManager.recordAppStart(new AppInfo(2, apkgConfig.mini_appid, apkgConfig.icon_url, apkgConfig.app_name));
            return;
        }
        String str = "params is empty! activity=" + activity + ",appConfig=" + miniAppConfig;
        QLog.e("MiniAppController", 1, str);
        throw new MiniAppException(str);
    }

    public static void tryReportShare(MessageForStructing messageForStructing) {
        AbsStructMsg absStructMsg = messageForStructing.structingMsg;
        if (absStructMsg != null && "micro_app".equals(absStructMsg.mMsg_A_ActionData)) {
            ThreadManagerV2.excute(new Runnable(absStructMsg.mMsgActionData) { // from class: com.tencent.mobileqq.microapp.sdk.MiniAppController.2
                static IPatchRedirector $redirector_;
                final /* synthetic */ String val$actionData;

                {
                    this.val$actionData = r4;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) r4);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this);
                        return;
                    }
                    try {
                        JSONObject jSONObject = new JSONObject(this.val$actionData);
                        String optString = jSONObject.optString("appId");
                        String optString2 = jSONObject.optString("entryPath");
                        String optString3 = jSONObject.optString("entryPathInConfig");
                        if (TextUtils.isEmpty(optString2)) {
                            optString2 = optString3;
                        }
                        if (!TextUtils.isEmpty(optString)) {
                            MiniAppController.reportShareInfo(optString, optString2);
                        }
                    } catch (Throwable unused) {
                    }
                }
            }, 16, null, false);
        }
    }

    public String getAppInfoFromScheme() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (String) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        try {
            return b.a().f245947a.f245825f.launchParam.appInfo;
        } catch (Throwable th5) {
            th5.printStackTrace();
            return null;
        }
    }

    public String handleNativeRequest(Activity activity, String str, String str2, String str3, IBridgeListener iBridgeListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, this, activity, str, str2, str3, iBridgeListener);
        }
        QLog.d("MiniAppController", 1, "handleNativeRequest appid=" + str + ",eventName=" + str2 + ",jsonParams=" + str3 + ",listener=" + iBridgeListener);
        synchronized (this.outJsPluginList) {
            for (OutBaseJsPlugin outBaseJsPlugin : this.outJsPluginList) {
                if (outBaseJsPlugin.canHandleJsRequest(str2)) {
                    int nextSeq = getNextSeq();
                    if (iBridgeListener != null) {
                        synchronized (this.bridgeListenerMap) {
                            this.bridgeListenerMap.put(nextSeq, iBridgeListener);
                        }
                    }
                    return outBaseJsPlugin.handleNativeRequest(activity, str, str2, str3, nextSeq);
                }
            }
            return "";
        }
    }

    public void handleNativeResponse(OutBaseJsPlugin outBaseJsPlugin, String str, String str2, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, outBaseJsPlugin, str, str2, Integer.valueOf(i3));
            return;
        }
        if (outBaseJsPlugin instanceof OutBaseBridgeJsPlugin) {
            IBridgeListener iBridgeListener = (IBridgeListener) this.bridgeListenerMap.get(i3);
            if (iBridgeListener != null) {
                synchronized (this.bridgeListenerMap) {
                    this.bridgeListenerMap.remove(i3);
                }
                iBridgeListener.onResult(str, str2);
                return;
            }
            return;
        }
        BridgeInfo bridgeInfo = (BridgeInfo) this.bridgeMap.get(i3);
        if (bridgeInfo == null) {
            return;
        }
        synchronized (this.bridgeMap) {
            this.bridgeMap.remove(i3);
        }
        BaseAppBrandWebview webView = bridgeInfo.getWebView();
        if (webView != null) {
            webView.evaluateCallbackJs(bridgeInfo.callbackId, str2);
        }
    }

    public void notifyResultListener(int i3, int i16, Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Integer.valueOf(i3), Integer.valueOf(i16), intent);
            return;
        }
        ActivityResultListener activityResultListener = this.activityResultListener;
        if (activityResultListener != null) {
            activityResultListener.doOnActivityResult(i3, i16, intent);
            this.activityResultListener = null;
        }
    }

    public void onDestory() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        synchronized (this.outJsPluginList) {
            this.outJsPluginList.clear();
        }
        synchronized (this.bridgeMap) {
            this.bridgeMap.clear();
        }
        synchronized (this.bridgeListenerMap) {
            this.bridgeListenerMap.clear();
        }
    }

    public void registeJsPlugin(List list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) list);
        } else {
            if (list == null) {
                return;
            }
            synchronized (this.outJsPluginList) {
                this.outJsPluginList.clear();
                this.outJsPluginList.addAll(list);
            }
        }
    }

    public void setActivityResultListener(ActivityResultListener activityResultListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) activityResultListener);
        } else {
            if (activityResultListener == null) {
                return;
            }
            this.activityResultListener = activityResultListener;
        }
    }

    public String handleNativeRequest(Activity activity, String str, String str2, String str3, BaseAppBrandWebview baseAppBrandWebview, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, this, activity, str, str2, str3, baseAppBrandWebview, Integer.valueOf(i3));
        }
        QLog.d("MiniAppController", 1, "handleNativeRequest appid=" + str + ",eventName=" + str2 + ",jsonParams=" + str3 + ",webview=" + baseAppBrandWebview + ",callbackId=" + i3);
        synchronized (this.outJsPluginList) {
            for (OutBaseJsPlugin outBaseJsPlugin : this.outJsPluginList) {
                if (outBaseJsPlugin.canHandleJsRequest(str2)) {
                    int nextSeq = getNextSeq();
                    synchronized (this.bridgeMap) {
                        this.bridgeMap.put(nextSeq, new BridgeInfo(baseAppBrandWebview, i3));
                    }
                    return outBaseJsPlugin.handleNativeRequest(activity, str, str2, str3, nextSeq);
                }
            }
            return "";
        }
    }
}
