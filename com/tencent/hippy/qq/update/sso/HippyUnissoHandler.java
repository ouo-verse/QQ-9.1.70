package com.tencent.hippy.qq.update.sso;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.gamecenter.wadl.api.IQQGameTrpcService;
import com.tencent.gamecenter.wadl.biz.entity.TrpcProxy;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.gamecenter.wadl.biz.entity.WebSSOAgent$UniSsoServerReq;
import com.tencent.gamecenter.wadl.biz.entity.WebSSOAgent$UniSsoServerReqComm;
import com.tencent.gamecenter.wadl.biz.listener.WadlTrpcListener;
import com.tencent.hippy.qq.api.IHippySetting;
import com.tencent.hippy.qq.api.IHippyUpdate;
import com.tencent.hippy.qq.preload.TabPreloadManager;
import com.tencent.hippy.qq.update.HippyQQConstants;
import com.tencent.hippy.qq.update.HippyQQUpdateManager;
import com.tencent.hippy.qq.update.HippyTabConfigManager;
import com.tencent.hippy.qq.update.HippyUpdateManager;
import com.tencent.hippy.qq.update.UpdateSetting;
import com.tencent.hippy.qq.utils.HippyAccessHelper;
import com.tencent.hippy.qq.utils.HippyUtils;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.ah;
import com.tencent.mobileqq.utils.m;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.trpcprotocol.gamecenter.mobileConfSvr.mobileConfSvr.CommonMobileConfQueryReq;
import com.tencent.trpcprotocol.gamecenter.mobileConfSvr.mobileConfSvr.CommonReq;
import com.tencent.trpcprotocol.gamecenter.mobileConfSvr.mobileConfSvr.MobileConfReq;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import mqq.app.NewIntent;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes7.dex */
public class HippyUnissoHandler extends BusinessHandler {
    public static final String CMD_HIPPY_REPORT = "GameCenterHippy.Report";
    public static final String CMD_TRPC_GAME_CENTER_HIPPY_CONFIG = "/v1/33";
    private static String TAG = "HippyUnissoHandler";
    public static final int WEBSSO_PLATFORM_ANDROID = 109;
    private AppInterface mApp;
    private WadlTrpcListener mTrpcListener;

    public HippyUnissoHandler(AppInterface appInterface) {
        super(appInterface);
        this.mTrpcListener = new WadlTrpcListener() { // from class: com.tencent.hippy.qq.update.sso.HippyUnissoHandler.1
            @Override // com.tencent.gamecenter.wadl.biz.listener.WadlTrpcListener
            public HashSet<String> getFilterCmds() {
                return new HashSet<String>() { // from class: com.tencent.hippy.qq.update.sso.HippyUnissoHandler.1.1
                    {
                        add(HippyUnissoHandler.CMD_TRPC_GAME_CENTER_HIPPY_CONFIG);
                    }
                };
            }

            @Override // com.tencent.gamecenter.wadl.biz.listener.WadlTrpcListener
            public void onTrpcRsp(Intent intent, String str, long j3, TrpcProxy.TrpcInovkeRsp trpcInovkeRsp) {
                if (QLog.isColorLevel()) {
                    QLog.i("hippyUpdateAction-" + HippyUnissoHandler.TAG, 1, "WadlTrpcListener onTrpcRsp cmd:" + str + " ret:" + j3);
                }
                if (HippyUnissoHandler.CMD_TRPC_GAME_CENTER_HIPPY_CONFIG.equals(str)) {
                    HippyUpdateManager.getInstance().handleAllResponses(intent, j3, trpcInovkeRsp);
                }
            }
        };
        this.mApp = appInterface;
    }

    private MobileConfReq createCheckPreloadReq(String str, int i3) {
        int i16;
        MobileConfReq mobileConfReq = new MobileConfReq();
        try {
            mobileConfReq.configType.set(6);
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("bundleName", str);
            int i17 = 0;
            if (((IHippySetting) QRoute.api(IHippySetting.class)).getModuleVersion(str) > 0) {
                i16 = 1;
            } else {
                i16 = 0;
            }
            jSONObject.put("isBundleExist", i16);
            if (TabPreloadManager.getInstance().hasNewMessage(str)) {
                i17 = 1;
            }
            jSONObject.put("isHighPriority", i17);
            jSONObject.put("scene", i3);
            mobileConfReq.busiReq.set(jSONObject.toString());
            if (QLog.isColorLevel()) {
                QLog.d("hippyUpdateAction-" + TAG, 2, "[createCheckPreloadReq] jsonData: " + jSONObject);
            }
        } catch (Throwable th5) {
            QLog.e("hippyUpdateAction-" + TAG, 1, "createCheckPreloadReq e:" + th5);
        }
        return mobileConfReq;
    }

    private CommonReq createCommonHippyReq(long j3, long j16) {
        CommonReq commonReq = new CommonReq();
        try {
            commonReq.cpuCoreCount.set(ah.n());
            commonReq.manufacturer.set(Build.BRAND);
            commonReq.model.set(DeviceInfoMonitor.getModel());
            commonReq.osVersionCode.set(Build.VERSION.SDK_INT);
            commonReq.qqVersion.set(ah.Q(BaseApplication.getContext()));
            commonReq.totalMemory.set((int) (m.c() / 1048576));
            commonReq.lastPreDownloadTime.set(j3);
            commonReq.lastUpdateTime.set(j16);
        } catch (Throwable th5) {
            QLog.e("hippyUpdateAction-" + TAG, 1, "createCommonHippyReq e:" + th5);
        }
        return commonReq;
    }

    private MobileConfReq createHippyConfigReq() {
        MobileConfReq mobileConfReq = new MobileConfReq();
        try {
            mobileConfReq.configType.set(1);
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("qqGameCenterBundleVersion", UpdateSetting.getInstance().getModuleVersion(HippyQQConstants.ModuleName.QQ_GAME_CENTER));
            mobileConfReq.busiReq.set(jSONObject.toString());
            if (QLog.isColorLevel()) {
                QLog.d("hippyUpdateAction-" + TAG, 2, "[createPreloadConfigReq] hippyConfig: " + jSONObject);
            }
        } catch (Throwable th5) {
            QLog.e("hippyUpdateAction-" + TAG, 1, "createHippyConfigReq e:" + th5);
        }
        return mobileConfReq;
    }

    private MobileConfReq createHippyUpdateReq(int i3, Map<String, Integer> map, int i16) {
        MobileConfReq mobileConfReq = new MobileConfReq();
        try {
            mobileConfReq.configType.set(2);
            JSONObject jSONObject = new JSONObject();
            JSONArray jSONArray = new JSONArray();
            if (map != null && map.size() > 0) {
                for (String str : map.keySet()) {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("bundleName", str);
                    jSONObject2.put(HippyQQConstants.KEY_BUNDLE_VERSION, map.get(str));
                    jSONArray.mo162put(jSONObject2);
                }
            }
            jSONObject.put("bundleList", jSONArray);
            jSONObject.put("sdkVersion", "3.0");
            jSONObject.put(WadlProxyConsts.CHANNEL, HippyQQConstants.HIPPY_CHANNEL);
            jSONObject.put("guid", HippyQQUpdateManager.getGuid());
            jSONObject.put("type", i16);
            jSONObject.put("source", i3);
            mobileConfReq.busiReq.set(jSONObject.toString());
            if (QLog.isColorLevel()) {
                QLog.d("hippyUpdateAction-" + TAG, 2, "[createPreloadConfigReq] hippyBundleJson: " + jSONObject);
            }
        } catch (Throwable th5) {
            QLog.e("hippyUpdateAction-" + TAG, 1, "createPreloadConfigReq e:" + th5);
        }
        return mobileConfReq;
    }

    private MobileConfReq createTabConfigReq(Map<String, String> map) {
        MobileConfReq mobileConfReq = new MobileConfReq();
        try {
            mobileConfReq.configType.set(3);
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            if (map != null && map.size() > 0) {
                for (String str : map.keySet()) {
                    jSONObject2.put(str, map.get(str));
                }
            }
            jSONObject.put("tabFileMd5", jSONObject2);
            jSONObject.put("source", 1);
            mobileConfReq.busiReq.set(jSONObject.toString());
        } catch (Throwable th5) {
            QLog.e("hippyUpdateAction-" + TAG, 1, "createTabConfigReq e:" + th5);
        }
        return mobileConfReq;
    }

    public static HippyUnissoHandler getInstance() {
        AppInterface appInterface = HippyUtils.getAppInterface();
        if (appInterface != null) {
            return (HippyUnissoHandler) appInterface.getBusinessHandler(HippyUnissoHandler.class.getName());
        }
        return null;
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler, com.tencent.mobileqq.app.BaseBusinessHandler
    public Set<String> getCommandList() {
        if (this.allowCmdSet == null) {
            HashSet hashSet = new HashSet();
            this.allowCmdSet = hashSet;
            hashSet.add(CMD_HIPPY_REPORT);
        }
        return this.allowCmdSet;
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler
    protected Class<? extends BusinessObserver> observerClass() {
        return HippyUnissoObserver.class;
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler
    public void onDestroy() {
        super.onDestroy();
        ((IQQGameTrpcService) QRoute.api(IQQGameTrpcService.class)).removeListener(this.mTrpcListener);
    }

    @Override // com.tencent.mobileqq.app.BaseBusinessHandler
    public void onReceive(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
    }

    public void preRequestHippyConfig(long j3, Bundle bundle) {
        if (QLog.isColorLevel()) {
            QLog.d("hippyUpdateAction-" + TAG, 2, "[requestPreDownloadConfig]");
        }
        try {
            CommonReq createCommonHippyReq = createCommonHippyReq(j3, 0L);
            MobileConfReq createHippyConfigReq = createHippyConfigReq();
            MobileConfReq mobileConfReq = new MobileConfReq();
            mobileConfReq.configType.set(5);
            mobileConfReq.busiReq.set("");
            MobileConfReq mobileConfReq2 = new MobileConfReq();
            mobileConfReq2.configType.set(9);
            mobileConfReq2.busiReq.set("");
            CommonMobileConfQueryReq commonMobileConfQueryReq = new CommonMobileConfQueryReq();
            commonMobileConfQueryReq.commonReq.set(createCommonHippyReq);
            commonMobileConfQueryReq.reqConfList.add(createHippyConfigReq);
            commonMobileConfQueryReq.reqConfList.add(mobileConfReq);
            commonMobileConfQueryReq.reqConfList.add(mobileConfReq2);
            TrpcProxy.TrpcInovkeReq createTrpcInvokeReq = ((IQQGameTrpcService) QRoute.api(IQQGameTrpcService.class)).createTrpcInvokeReq(CMD_TRPC_GAME_CENTER_HIPPY_CONFIG, false, commonMobileConfQueryReq.toByteArray());
            TrpcProxy.TrpcListReq trpcListReq = new TrpcProxy.TrpcListReq();
            trpcListReq.list.add(createTrpcInvokeReq);
            ((IQQGameTrpcService) QRoute.api(IQQGameTrpcService.class)).addListener(this.mTrpcListener);
            ((IQQGameTrpcService) QRoute.api(IQQGameTrpcService.class)).requestTrpc(trpcListReq, bundle);
        } catch (Throwable th5) {
            QLog.e("hippyUpdateAction-" + TAG, 1, th5.toString());
        }
    }

    public void reportHippy(JSONObject jSONObject) {
        try {
            WebSSOAgent$UniSsoServerReqComm webSSOAgent$UniSsoServerReqComm = new WebSSOAgent$UniSsoServerReqComm();
            webSSOAgent$UniSsoServerReqComm.platform.set(109L);
            webSSOAgent$UniSsoServerReqComm.osver.set(Build.VERSION.RELEASE);
            webSSOAgent$UniSsoServerReqComm.mqqver.set(AppSetting.f99554n);
            WebSSOAgent$UniSsoServerReq webSSOAgent$UniSsoServerReq = new WebSSOAgent$UniSsoServerReq();
            webSSOAgent$UniSsoServerReq.comm.set(webSSOAgent$UniSsoServerReqComm);
            JSONObject jSONObject2 = new JSONObject();
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("req", jSONObject);
            jSONObject2.put(CMD_HIPPY_REPORT, jSONObject3);
            webSSOAgent$UniSsoServerReq.reqdata.set(jSONObject2.toString());
            NewIntent newIntent = new NewIntent(this.mApp.getApp(), HippyUnissoServlet.class);
            newIntent.putExtra("cmd", CMD_HIPPY_REPORT);
            newIntent.putExtra("data", webSSOAgent$UniSsoServerReq.toByteArray());
            this.mApp.startServlet(newIntent);
        } catch (Throwable th5) {
            th5.printStackTrace();
        }
    }

    public void requestHippyConfig(int i3, String str, int i16, long j3, Bundle bundle) {
        boolean z16;
        MobileConfReq mobileConfReq;
        int i17;
        if (QLog.isColorLevel()) {
            QLog.d("hippyUpdateAction-" + TAG, 2, "[requestHippyConfig]");
        }
        if (TextUtils.isEmpty(str)) {
            QLog.e("hippyUpdateAction-" + TAG, 1, "[requestHippyConfig] moduleName is empty, return.");
            return;
        }
        try {
            String tabConfigFileMd5 = HippyTabConfigManager.getTabConfigFileMd5(HippyAccessHelper.getCurrentUin(), str);
            HashMap hashMap = new HashMap();
            hashMap.put(str, tabConfigFileMd5);
            MobileConfReq createTabConfigReq = createTabConfigReq(hashMap);
            MobileConfReq createHippyConfigReq = createHippyConfigReq();
            HashMap hashMap2 = new HashMap();
            hashMap2.put(str, Integer.valueOf(i16));
            MobileConfReq createHippyUpdateReq = createHippyUpdateReq(i3, hashMap2, 2);
            if (bundle == null) {
                z16 = false;
            } else {
                z16 = bundle.getBoolean(IHippyUpdate.EXTRA_KEY_IS_CHECK_PRELOAD);
            }
            if (z16) {
                if (bundle == null) {
                    i17 = 0;
                } else {
                    i17 = bundle.getInt(IHippyUpdate.EXTRA_KEY_PRELOAD_SCENE_TYPE);
                }
                mobileConfReq = createCheckPreloadReq(str, i17);
            } else {
                mobileConfReq = null;
            }
            CommonMobileConfQueryReq commonMobileConfQueryReq = new CommonMobileConfQueryReq();
            commonMobileConfQueryReq.commonReq.set(createCommonHippyReq(0L, j3));
            commonMobileConfQueryReq.reqConfList.add(createHippyUpdateReq);
            commonMobileConfQueryReq.reqConfList.add(createHippyConfigReq);
            commonMobileConfQueryReq.reqConfList.add(createTabConfigReq);
            if (mobileConfReq != null) {
                commonMobileConfQueryReq.reqConfList.add(mobileConfReq);
            }
            TrpcProxy.TrpcInovkeReq createTrpcInvokeReq = ((IQQGameTrpcService) QRoute.api(IQQGameTrpcService.class)).createTrpcInvokeReq(CMD_TRPC_GAME_CENTER_HIPPY_CONFIG, false, commonMobileConfQueryReq.toByteArray());
            TrpcProxy.TrpcListReq trpcListReq = new TrpcProxy.TrpcListReq();
            trpcListReq.list.add(createTrpcInvokeReq);
            ((IQQGameTrpcService) QRoute.api(IQQGameTrpcService.class)).addListener(this.mTrpcListener);
            ((IQQGameTrpcService) QRoute.api(IQQGameTrpcService.class)).requestTrpc(trpcListReq, bundle);
        } catch (Exception e16) {
            QLog.e("hippyUpdateAction-" + TAG, 1, e16.toString());
        }
    }

    public void onReceive(Intent intent, FromServiceMsg fromServiceMsg, byte[] bArr) {
        String stringExtra = intent.getStringExtra("cmd");
        if (!TextUtils.isEmpty(stringExtra) && QLog.isColorLevel()) {
            QLog.d(TAG, 2, "[onReceive], cmd:" + stringExtra);
        }
    }
}
