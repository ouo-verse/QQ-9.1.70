package com.tencent.qq.minibox.api.metadream.impl;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import b3.a;
import b3.b;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.minibox.business.api.IMiniBoxDataCallback;
import com.tencent.minibox.business.api.MiniBoxAppInfo;
import com.tencent.minibox.business.api.MiniBoxSDK;
import com.tencent.minibox.contract.IMiniBoxServiceConnection;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.minigame.api.IMiniGameVAUtilsApi;
import com.tencent.mobileqq.minigame.api.IMiniGameVaConfigApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qq.minibox.api.IMiniBoxLauncher;
import com.tencent.qq.minibox.api.metadream.IMetaDreamServiceApi;
import com.tencent.qq.minibox.api.metadream.impl.MetaDreamServiceApiImpl;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import com.tencent.util.WeakReferenceHandler;
import cs3.MetaDreamAppExtraInfo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;
import us3.e;
import us3.m;

/* compiled from: P */
/* loaded from: classes22.dex */
public class MetaDreamServiceApiImpl implements IMetaDreamServiceApi, Handler.Callback {
    private static final String BIND_SERVICE_NAME = "android.intent.action.tgpa.PREDOWNLOAD";
    public static final String DOWNLOAD_CONFIG = "{\"canDownloadMobile\":\"true\",\"isAutoResumeByWiFi\":\"true\"}";
    public static final String EXTRA_KEY_DIFF_ENABLE = "va_diff_enable";
    public static final String EXTRA_KEY_VA_IS_DEBUG = "va_preload_is_debug";
    private static final String EXTRA_KEY_VA_PRELOAD_ENV = "va_preload_env";
    private static final String EXTRA_KEY_VA_PRELOAD_PUFFER_INFO = "va_preload_puffer_info";
    private static final String EXTRA_KEY_VA_PRELOAD_RES_READY = "va_preload_res_ready";
    public static final String EXTRA_KEY_VA_SWITCH_INFO = "va_switch_info";
    private static final int MSG_CODE_RETRY_BIND = 256;
    private static final int MSG_CODE_UPDATE_PROGRESS = 255;
    private static final String TAG = "MiniGameVA_MetaDreamServiceApiImpl";
    private MetaDreamAppExtraInfo appExtraInfo;
    private long downloadFileSize;
    private b3.a downloadService;
    private long downloadStartTime;
    private boolean isReportStart;
    private boolean mHasBindService;
    private final ArrayList<cs3.b> callbacks = new ArrayList<>();
    private volatile boolean autoDownloadOnBind = false;
    private volatile boolean isPreloadResReady = false;
    private final WeakReferenceHandler mUIHandler = new WeakReferenceHandler(Looper.getMainLooper(), this);
    private final IMiniBoxServiceConnection serviceConnection = new a();
    private b3.b remoteDownloadCallback = new b();

    /* compiled from: P */
    /* loaded from: classes22.dex */
    class a extends IMiniBoxServiceConnection.Stub {
        a() {
        }

        @Override // com.tencent.minibox.contract.IMiniBoxServiceConnection
        public String getBindKey() throws RemoteException {
            return "com.tencent.letsgoandroid.intent.action.tgpa.PREDOWNLOAD";
        }

        @Override // com.tencent.minibox.contract.IMiniBoxServiceConnection
        public void onConnectFailed(int i3) throws RemoteException {
            MetaDreamServiceApiImpl.this.downloadService = null;
            QLog.e(MetaDreamServiceApiImpl.TAG, 1, "onConnectFailed code:" + i3);
        }

        @Override // com.tencent.minibox.contract.IMiniBoxServiceConnection
        public void onConnected(ComponentName componentName, IBinder iBinder, boolean z16) throws RemoteException {
            QLog.i(MetaDreamServiceApiImpl.TAG, 1, "onConnected iBinder:" + iBinder);
            try {
                MetaDreamServiceApiImpl.this.mUIHandler.removeMessages(256);
                MetaDreamServiceApiImpl.this.downloadService = a.AbstractBinderC0088a.j(iBinder);
                MetaDreamServiceApiImpl.this.downloadService.F0(MetaDreamServiceApiImpl.this.remoteDownloadCallback);
                if (MetaDreamServiceApiImpl.this.autoDownloadOnBind) {
                    MetaDreamServiceApiImpl.this.downloadService.c4(MetaDreamServiceApiImpl.DOWNLOAD_CONFIG);
                    MetaDreamServiceApiImpl.this.reportDownloadReq();
                    QLog.i(MetaDreamServiceApiImpl.TAG, 1, "onConnected startPreDownload real");
                    MetaDreamServiceApiImpl.this.autoDownloadOnBind = false;
                }
            } catch (Exception e16) {
                QLog.e(MetaDreamServiceApiImpl.TAG, 1, "onConnectFailed e:", e16);
            }
        }

        @Override // com.tencent.minibox.contract.IMiniBoxServiceConnection
        public void onDisconnected() throws RemoteException {
            MetaDreamServiceApiImpl.this.downloadService = null;
            QLog.i(MetaDreamServiceApiImpl.TAG, 1, "onDisconnected");
        }
    }

    /* compiled from: P */
    /* loaded from: classes22.dex */
    class b extends b.a {
        b() {
        }

        @Override // b3.b
        public void onEvent(String str, String str2) throws RemoteException {
            str.hashCode();
            char c16 = '\uffff';
            switch (str.hashCode()) {
                case -2124458952:
                    if (str.equals("onComplete")) {
                        c16 = 0;
                        break;
                    }
                    break;
                case -1340212393:
                    if (str.equals(MiniSDKConst.NOTIFY_EVENT_ONPAUSE)) {
                        c16 = 1;
                        break;
                    }
                    break;
                case -1336895037:
                    if (str.equals("onStart")) {
                        c16 = 2;
                        break;
                    }
                    break;
                case -1013362275:
                    if (str.equals("onFail")) {
                        c16 = 3;
                        break;
                    }
                    break;
                case 1557665045:
                    if (str.equals("onUnbind")) {
                        c16 = 4;
                        break;
                    }
                    break;
                case 2034094921:
                    if (str.equals("onFileInfo")) {
                        c16 = 5;
                        break;
                    }
                    break;
            }
            switch (c16) {
                case 0:
                    MetaDreamServiceApiImpl.this.handleOnComplete(str2);
                    MetaDreamServiceApiImpl.this.mUIHandler.removeMessages(255);
                    MetaDreamServiceApiImpl.this.reportDownloadUpdate(1);
                    return;
                case 1:
                    MetaDreamServiceApiImpl.this.handleOnPause(str2);
                    MetaDreamServiceApiImpl.this.mUIHandler.removeMessages(255);
                    MetaDreamServiceApiImpl.this.reportDownloadUpdate(3);
                    return;
                case 2:
                    MetaDreamServiceApiImpl.this.handleOnStart(str2);
                    MetaDreamServiceApiImpl.this.mUIHandler.removeMessages(255);
                    MetaDreamServiceApiImpl.this.mUIHandler.sendEmptyMessageDelayed(255, 3000L);
                    MetaDreamServiceApiImpl.this.reportDownloadUpdate(0);
                    return;
                case 3:
                    MetaDreamServiceApiImpl.this.handleOnFail(str2);
                    MetaDreamServiceApiImpl.this.mUIHandler.removeMessages(255);
                    MetaDreamServiceApiImpl.this.reportDownloadUpdate(2);
                    return;
                case 4:
                    MetaDreamServiceApiImpl.this.handleOnUnbind();
                    MetaDreamServiceApiImpl.this.mUIHandler.removeMessages(255);
                    return;
                case 5:
                    MetaDreamServiceApiImpl.this.handleOnFileInfo(str2);
                    return;
                default:
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes22.dex */
    public class c implements cs3.c {
        c() {
        }

        @Override // cs3.c
        public void onExtraRsp(MetaDreamAppExtraInfo metaDreamAppExtraInfo) {
            if (metaDreamAppExtraInfo != null) {
                MetaDreamServiceApiImpl.this.bindService(metaDreamAppExtraInfo);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes22.dex */
    public class d implements IMiniBoxDataCallback<String> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ cs3.c f344534a;

        d(cs3.c cVar) {
            this.f344534a = cVar;
        }

        @Override // com.tencent.minibox.business.api.IMiniBoxDataCallback
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onSuccess(String str) {
            QLog.i(MetaDreamServiceApiImpl.TAG, 1, "getExtraInfo getAppExtraInfo onSuccess:" + str);
            MetaDreamServiceApiImpl.this.appExtraInfo = e.f439984a.a(str);
            this.f344534a.onExtraRsp(MetaDreamServiceApiImpl.this.appExtraInfo);
        }

        @Override // com.tencent.minibox.business.api.IMiniBoxDataCallback
        public void onFail(int i3, String str) {
            QLog.e(MetaDreamServiceApiImpl.TAG, 1, "getExtraInfo getAppExtraInfo onFail:" + i3 + " errorMessage:" + str);
            MetaDreamServiceApiImpl.this.showToastOnDebug("meta dream getAppExtraInfo error");
            this.f344534a.onExtraRsp(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bindService(MetaDreamAppExtraInfo metaDreamAppExtraInfo) {
        if (metaDreamAppExtraInfo != null && metaDreamAppExtraInfo.getPufferInfo() != null) {
            String preDownloadInfo = metaDreamAppExtraInfo.getPufferInfo().getPreDownloadInfo();
            if (!TextUtils.isEmpty(preDownloadInfo) && !"{}".equals(preDownloadInfo)) {
                QLog.i(TAG, 1, "bindService preDownloadInfo:" + preDownloadInfo);
                Intent intent = new Intent(BIND_SERVICE_NAME);
                intent.putExtra("init_param", preDownloadInfo);
                ((IMiniBoxLauncher) QRoute.api(IMiniBoxLauncher.class)).init(BaseApplication.getContext());
                MiniBoxSDK.bindService(intent, "com.tencent.letsgo", this.serviceConnection);
                this.mHasBindService = true;
                return;
            }
            QLog.e(TAG, 1, "bindService preDownloadInfo is empty");
            callbackExtraInfoEmpty();
            return;
        }
        QLog.e(TAG, 1, "bindService appExtraInfo.getPufferInfo() is null");
        callbackExtraInfoEmpty();
    }

    private void callbackExtraInfoEmpty() {
        synchronized (this.callbacks) {
            Iterator<cs3.b> it = this.callbacks.iterator();
            while (it.hasNext()) {
                cs3.b next = it.next();
                next.onDownloadStart(1L);
                next.onDownloadComplete(0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleOnComplete(String str) {
        try {
            int optInt = new JSONObject(str).optInt("state");
            synchronized (this.callbacks) {
                Iterator<cs3.b> it = this.callbacks.iterator();
                while (it.hasNext()) {
                    it.next().onDownloadComplete(optInt);
                }
            }
            this.isPreloadResReady = true;
            QLog.i(TAG, 1, "handleOnComplete data:" + str);
        } catch (Exception e16) {
            QLog.e(TAG, 1, "handleOnComplete", e16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleOnFail(String str) {
        try {
            int optInt = new JSONObject(str).optInt("errorCode");
            synchronized (this.callbacks) {
                Iterator<cs3.b> it = this.callbacks.iterator();
                while (it.hasNext()) {
                    it.next().onDownloadFail(optInt);
                }
            }
            QLog.i(TAG, 1, "handleOnFail data:" + str);
        } catch (Exception e16) {
            QLog.e(TAG, 1, "handleOnFail", e16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleOnFileInfo(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            long optLong = jSONObject.optLong("totalSize");
            this.downloadFileSize = optLong;
            JSONArray optJSONArray = jSONObject.optJSONArray("fileList");
            int i3 = 0;
            if (optJSONArray != null && optJSONArray.length() > 0) {
                int i16 = 0;
                while (i3 < optJSONArray.length()) {
                    i16 += optJSONArray.optJSONObject(i3).optInt("progress");
                    i3++;
                }
                i3 = i16 / optJSONArray.length();
            }
            if (i3 != 0) {
                synchronized (this.callbacks) {
                    Iterator<cs3.b> it = this.callbacks.iterator();
                    while (it.hasNext()) {
                        it.next().onDownloadProgress(i3, optLong);
                    }
                }
            }
            QLog.d(TAG, 2, "handleOnFileInfo data:" + str + " sumProgress:" + i3);
        } catch (Exception e16) {
            QLog.e(TAG, 1, "handleOnFileInfo", e16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleOnPause(String str) {
        try {
            int optInt = new JSONObject(str).optInt("state");
            synchronized (this.callbacks) {
                Iterator<cs3.b> it = this.callbacks.iterator();
                while (it.hasNext()) {
                    it.next().onDownloadPaused(optInt);
                }
            }
            QLog.i(TAG, 1, "handleOnPause data:" + str);
        } catch (Exception e16) {
            QLog.e(TAG, 1, "handleOnPause", e16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleOnStart(String str) {
        try {
            int optInt = new JSONObject(str).optInt("totalSize");
            synchronized (this.callbacks) {
                Iterator<cs3.b> it = this.callbacks.iterator();
                while (it.hasNext()) {
                    it.next().onDownloadStart(optInt);
                }
            }
            QLog.i(TAG, 1, "handleOnStart data:" + str);
        } catch (Exception e16) {
            QLog.e(TAG, 1, "handleOnStart", e16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleOnUnbind() {
        this.downloadService = null;
        this.autoDownloadOnBind = false;
        MiniBoxSDK.unbindService(this.serviceConnection);
        QLog.i(TAG, 1, "handleOnUnbind");
    }

    private synchronized void initService() {
        if (this.downloadService == null) {
            getExtraInfo(new c());
            QLog.i(TAG, 1, "initService start");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$handleMessage$0() {
        b3.a aVar = this.downloadService;
        if (aVar != null) {
            try {
                aVar.F2();
                this.mUIHandler.sendEmptyMessageDelayed(255, 3000L);
            } catch (RemoteException e16) {
                QLog.e(TAG, 1, "fetchDownloadFileInfo ", e16);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reportDownloadReq() {
        if (this.isReportStart) {
            return;
        }
        this.isReportStart = true;
        this.downloadStartTime = SystemClock.uptimeMillis();
        HashMap hashMap = new HashMap();
        MiniBoxAppInfo installedAppInfo = MiniBoxSDK.getInstalledAppInfo("com.tencent.letsgo");
        if (installedAppInfo != null) {
            hashMap.put("ext7", installedAppInfo.getVersionName());
        }
        ((IMiniGameVAUtilsApi) QRoute.api(IMiniGameVAUtilsApi.class)).reportMiniGameCenterDC00087("1", WadlProxyConsts.PAGE_ID_DOWNLOAD, "9080", "908015", "989685", "18", "", hashMap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reportDownloadUpdate(int i3) {
        if (this.isReportStart) {
            HashMap hashMap = new HashMap();
            MiniBoxAppInfo installedAppInfo = MiniBoxSDK.getInstalledAppInfo("com.tencent.letsgo");
            if (installedAppInfo != null) {
                hashMap.put("ext7", installedAppInfo.getVersionName());
                hashMap.put("ext8", String.valueOf(i3));
                hashMap.put("ext2", String.valueOf(this.downloadFileSize));
                hashMap.put("ext46", String.valueOf(SystemClock.uptimeMillis() - this.downloadStartTime));
            }
            ((IMiniGameVAUtilsApi) QRoute.api(IMiniGameVAUtilsApi.class)).reportMiniGameCenterDC00087("1", WadlProxyConsts.PAGE_ID_DOWNLOAD, "9080", "908015", "989686", "18", "", hashMap);
        }
    }

    @Override // com.tencent.qq.minibox.api.metadream.IMetaDreamServiceApi
    public void getExtraInfo(cs3.c cVar) {
        if (cVar == null) {
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putBoolean("isDebug", isMetaDreamEnvDebug());
        boolean isDiffPatchEnable = ((IMiniGameVaConfigApi) QRoute.api(IMiniGameVaConfigApi.class)).isDiffPatchEnable();
        QLog.i(TAG, 1, "getExtraInfo isDiffPatchEnable:" + isDiffPatchEnable);
        bundle.putBoolean("diffPatchDownloadEnable", isDiffPatchEnable);
        MiniBoxSDK.getAppExtraInfo("com.tencent.letsgo", bundle, new d(cVar));
    }

    @Override // com.tencent.qq.minibox.api.metadream.IMetaDreamServiceApi
    public Bundle getLaunchExtendBundle() {
        Bundle bundle = new Bundle();
        bundle.putBoolean(EXTRA_KEY_VA_PRELOAD_RES_READY, this.isPreloadResReady);
        MetaDreamAppExtraInfo metaDreamAppExtraInfo = this.appExtraInfo;
        if (metaDreamAppExtraInfo != null) {
            if (metaDreamAppExtraInfo.getPufferInfo() != null) {
                bundle.putString(EXTRA_KEY_VA_PRELOAD_PUFFER_INFO, this.appExtraInfo.getPufferInfo().getOriginalPufferInfo());
            }
            if (!TextUtils.isEmpty(this.appExtraInfo.getEnv())) {
                bundle.putString(EXTRA_KEY_VA_PRELOAD_ENV, this.appExtraInfo.getEnv());
            }
        }
        bundle.putBoolean(EXTRA_KEY_VA_IS_DEBUG, isMetaDreamEnvDebug());
        String vASwitchInfo = ((IMiniGameVaConfigApi) QRoute.api(IMiniGameVaConfigApi.class)).getVASwitchInfo();
        if (!TextUtils.isEmpty(vASwitchInfo)) {
            bundle.putString(EXTRA_KEY_VA_SWITCH_INFO, vASwitchInfo);
        }
        this.isPreloadResReady = false;
        QLog.i(TAG, 1, "getLaunchExtendBundle bundle:" + bundle);
        return bundle;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(@NonNull Message message) {
        int i3 = message.what;
        if (i3 != 255) {
            if (i3 == 256) {
                QLog.i(TAG, 1, "handle rebind service");
                this.mUIHandler.removeMessages(256);
                initService();
            }
        } else {
            ThreadManagerV2.excute(new Runnable() { // from class: ds3.a
                @Override // java.lang.Runnable
                public final void run() {
                    MetaDreamServiceApiImpl.this.lambda$handleMessage$0();
                }
            }, 128, null, false);
        }
        return false;
    }

    @Override // com.tencent.qq.minibox.api.metadream.IMetaDreamServiceApi
    public boolean isMetaDreamEnvDebug() {
        boolean z16;
        es3.a aVar = (es3.a) ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadConfig("102839");
        StringBuilder sb5 = new StringBuilder();
        sb5.append("isMetaDreamEnvDebug config.isDebug:");
        if (aVar != null && aVar.getIsMetaDreamEnvDebug()) {
            z16 = true;
        } else {
            z16 = false;
        }
        sb5.append(z16);
        QLog.i(TAG, 1, sb5.toString());
        if (aVar != null && aVar.getIsMetaDreamEnvDebug()) {
            showToastOnDebug("\u62c9\u53d6\u5143\u68a6\u914d\u7f6e:\u6d4b\u8bd5\u73af\u5883");
            return true;
        }
        QLog.i(TAG, 1, "isMetaDreamEnvDebug isDebug:" + m.f439991a.g("meta_dream_env_is_debug"));
        showToastOnDebug("\u62c9\u53d6\u5143\u68a6\u914d\u7f6e:\u6b63\u5f0f\u73af\u5883");
        return false;
    }

    @Override // com.tencent.qq.minibox.api.metadream.IMetaDreamServiceApi
    public void pauseDownloadRes() {
        this.mUIHandler.removeMessages(256);
        this.autoDownloadOnBind = false;
        this.mUIHandler.removeMessages(255);
        b3.a aVar = this.downloadService;
        if (aVar != null) {
            try {
                aVar.U0();
                QLog.i(TAG, 1, "pauseDownloadRes");
                return;
            } catch (RemoteException e16) {
                QLog.e(TAG, 1, "pauseDownloadRes ", e16);
                return;
            }
        }
        QLog.e(TAG, 1, "pauseDownloadRes , but downloadService is null");
    }

    @Override // com.tencent.qq.minibox.api.metadream.IMetaDreamServiceApi
    public void registerDownloadCallback(cs3.b bVar) {
        synchronized (this.callbacks) {
            this.callbacks.add(bVar);
        }
    }

    @Override // com.tencent.qq.minibox.api.metadream.IMetaDreamServiceApi
    public void startDownloadRes() {
        if (!MiniBoxSDK.isAppInstalled("com.tencent.letsgo")) {
            Iterator<cs3.b> it = this.callbacks.iterator();
            while (it.hasNext()) {
                it.next().onDownloadFail(-1);
            }
            QLog.e(TAG, 1, "startDownloadRes fail no install");
            return;
        }
        b3.a aVar = this.downloadService;
        if (aVar != null) {
            try {
                aVar.c4(DOWNLOAD_CONFIG);
                reportDownloadReq();
                return;
            } catch (RemoteException unused) {
                MiniBoxSDK.unbindService(this.serviceConnection);
                QLog.i(TAG, 1, "startDownloadRes unbind old service");
                this.downloadService = null;
            }
        }
        initService();
        this.autoDownloadOnBind = true;
        this.mUIHandler.removeMessages(256);
    }

    @Override // com.tencent.qq.minibox.api.metadream.IMetaDreamServiceApi
    public void stopDownloadRes() {
        this.mUIHandler.removeMessages(256);
        this.autoDownloadOnBind = false;
        this.mUIHandler.removeMessages(255);
        QLog.i(TAG, 1, "pauseDownloadRes");
        b3.a aVar = this.downloadService;
        if (aVar != null) {
            try {
                aVar.U0();
                this.downloadService.Z3();
                MiniBoxSDK.unbindService(this.serviceConnection);
            } catch (RemoteException e16) {
                this.downloadService = null;
                QLog.e(TAG, 1, "stopDownloadRes ", e16);
            }
            this.downloadService = null;
            return;
        }
        if (this.mHasBindService) {
            MiniBoxSDK.unbindService(this.serviceConnection);
            this.mHasBindService = false;
        }
        QLog.e(TAG, 1, "stopDownloadRes , but downloadService is null");
    }

    @Override // com.tencent.qq.minibox.api.metadream.IMetaDreamServiceApi
    public void unregisterDownloadCallback(cs3.b bVar) {
        synchronized (this.callbacks) {
            this.callbacks.remove(bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showToastOnDebug(String str) {
    }
}
