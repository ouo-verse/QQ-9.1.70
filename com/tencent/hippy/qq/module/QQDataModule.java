package com.tencent.hippy.qq.module;

import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.biz.pubaccount.api.IPublicAccountObserver;
import com.tencent.biz.pubaccount.util.api.IPublicAccountUtil;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.subscribe.event.FollowUpdateEvent;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.hippy.qq.api.HippyInterpolator;
import com.tencent.hippy.qq.api.IHippyAccessHelper;
import com.tencent.hippy.qq.app.HippyQQEngine;
import com.tencent.hippy.qq.fragment.BaseHippyFragment;
import com.tencent.hippy.qq.interpolators.HippyInterpolatorConfig;
import com.tencent.hippy.qq.utils.HippyModuleUtils;
import com.tencent.hippy.qq.utils.WebSSOUtils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseFragment;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.jsp.am;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.pluginsdk.PluginBaseInfoHelper;
import com.tencent.mobileqq.pskey.api.IPskeyManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.vas.report.VasCommonReporter;
import com.tencent.mobileqq.vas.toggle.VasNormalToggle;
import com.tencent.mtt.hippy.HippyEngineContext;
import com.tencent.mtt.hippy.annotation.HippyMethod;
import com.tencent.mtt.hippy.annotation.HippyNativeModule;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.modules.Promise;
import com.tencent.pb.webssoagent.WebSSOAgent$UniSsoServerReq;
import com.tencent.pb.webssoagent.WebSSOAgent$UniSsoServerReqComm;
import com.tencent.pb.webssoagent.WebSSOAgent$UniSsoServerRsp;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.tvkplayer.api.ITVKPlayerEventListener;
import java.io.IOException;
import java.util.Map;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;
import mqq.observer.BusinessObserver;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
@HippyNativeModule(name = QQDataModule.CLASSNAME)
/* loaded from: classes7.dex */
public class QQDataModule extends QQBaseModule {
    public static final String CLASSNAME = "QQDataModule";
    private static final String EMPTY_JSON = "{}";
    private static final boolean ENABLE_NEW_PSKEY = VasNormalToggle.VAS_HIPPY_PSKEY_NEW_COMPONENT.isEnable(true);
    public static final String PUBLIC_ACCOUNT_TOP_STATE = "publicAccountTopState";
    public static final String PUBLIC_ACCOUNT_UIN = "publicAccountUin";
    public static final String RET_CODE = "retCode";

    public QQDataModule(HippyEngineContext hippyEngineContext) {
        super(hippyEngineContext);
    }

    private int getOpenId() {
        QBaseFragment fragment = getFragment();
        if (fragment instanceof BaseHippyFragment) {
            return ((BaseHippyFragment) fragment).getOpenId();
        }
        if (fragment != null && fragment.getArguments() != null) {
            return fragment.getArguments().getInt("openId");
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getPreRequestData$0(Promise promise, String str) {
        HippyQQEngine hippyQQEngine = getHippyQQEngine();
        if (hippyQQEngine != null && !hippyQQEngine.isDestroyed()) {
            if (str != null) {
                promise.resolve(str);
            } else {
                promise.resolve("");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onGetPskey(String str, Promise promise) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("p_skey", str);
            promise.resolve(jSONObject.toString());
        } catch (JSONException e16) {
            QLog.e(CLASSNAME, 1, "onGetPskey error:", e16);
            promise.resolve("{}");
        }
    }

    @HippyMethod(name = "getCurrentJsBundleVersion")
    public void getCurrentJsBundleVersion(Promise promise) {
        int moduleVersion;
        if (promise == null) {
            return;
        }
        HippyQQEngine engineInstance = HippyQQEngine.getEngineInstance(this.mContext.getEngineId());
        if (engineInstance == null) {
            moduleVersion = 0;
        } else {
            moduleVersion = engineInstance.getModuleVersion();
        }
        promise.resolve(Integer.valueOf(moduleVersion));
    }

    @HippyMethod(name = "getOpenFrom")
    public void getOpenFrom(Promise promise) {
        if (promise == null) {
            return;
        }
        String openHippyFrom = HippyModuleUtils.getOpenHippyFrom(getFragment());
        if (openHippyFrom == null) {
            openHippyFrom = "";
        }
        promise.resolve(openHippyFrom);
    }

    @HippyMethod(name = "getPreRequestData")
    public void getPreRequestData(String str, final Promise promise) {
        String bundleName = getBundleName();
        if (promise != null && !TextUtils.isEmpty(bundleName)) {
            HippyInterpolator interpolator = HippyInterpolatorConfig.getInterpolator(bundleName);
            if (interpolator == null) {
                QLog.w(CLASSNAME, 1, "getPreRequestData interpolator null");
            } else {
                interpolator.getPreRequestData(getOpenId(), str, new HippyInterpolator.OnPreRequestListener() { // from class: com.tencent.hippy.qq.module.e
                    @Override // com.tencent.hippy.qq.api.HippyInterpolator.OnPreRequestListener
                    public final void onGetPreRequestData(String str2) {
                        QQDataModule.this.lambda$getPreRequestData$0(promise, str2);
                    }
                });
            }
        }
    }

    @HippyMethod(name = "getPskey")
    public void getPskey(final Promise promise) {
        if (promise == null) {
            return;
        }
        final String domain = HippyModuleUtils.getDomain(getFragment(), getHippyQQEngine());
        if (!((IHippyAccessHelper) QRoute.api(IHippyAccessHelper.class)).checkDomainPermission(domain)) {
            domain = null;
        }
        AppInterface appInterface = getAppInterface();
        if (appInterface != null && appInterface.isLogin() && !TextUtils.isEmpty(domain)) {
            ((IPskeyManager) appInterface.getRuntimeService(IPskeyManager.class, "all")).getPskey(new String[]{domain}, new sd2.a() { // from class: com.tencent.hippy.qq.module.QQDataModule.1
                @Override // sd2.a
                public void onFail(@NonNull String str) {
                    QLog.e(QQDataModule.CLASSNAME, 1, "asyncTicket failed:", str);
                    promise.resolve("{}");
                    VasCommonReporter.getNewPsKey().setNum1(-1L).setValue1(str).report(true);
                }

                @Override // sd2.a
                public void onSuccess(@NonNull Map<String, String> map) {
                    String str = map.get(domain);
                    if (QLog.isColorLevel()) {
                        QLog.e(QQDataModule.CLASSNAME, 1, "getPskey onSuccess");
                    }
                    QQDataModule.this.onGetPskey(str, promise);
                    VasCommonReporter.getNewPsKey().setNum1(0L).setValue1(str).report(true);
                }
            });
        } else {
            promise.resolve("{}");
        }
    }

    @HippyMethod(name = "getUrlImage")
    public void getUrlImage(final String str, final Promise promise) {
        if (promise == null) {
            return;
        }
        if (TextUtils.isEmpty(str)) {
            HippyMap hippyMap = new HippyMap();
            hippyMap.pushInt("ret", -3);
            hippyMap.pushMap("response", new HippyMap());
            promise.resolve(hippyMap);
            return;
        }
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.hippy.qq.module.QQDataModule.4
            @Override // java.lang.Runnable
            public void run() {
                try {
                    HippyMap hippyMap2 = new HippyMap();
                    if (!TextUtils.isEmpty(str)) {
                        byte[] openUrlForByte = HttpUtil.openUrlForByte(BaseApplication.getContext(), MsfSdkUtils.insertMtype("GameCenter", str), "GET", null, null);
                        if (openUrlForByte == null || BitmapFactory.decodeByteArray(openUrlForByte, 0, openUrlForByte.length) == null) {
                            return;
                        }
                        String str2 = "data:image;base64,";
                        byte b16 = openUrlForByte[0];
                        if ((b16 & 255) == 255 && (openUrlForByte[1] & 255) == 216) {
                            str2 = "data:image/jpeg;base64,";
                        } else if ((b16 & 255) == 66 && (openUrlForByte[1] & 255) == 77) {
                            str2 = "data:image/bmp;base64,";
                        } else if ((b16 & 255) == 137 && (openUrlForByte[1] & 255) == 80) {
                            str2 = "data:image/png;base64,";
                        } else if ((b16 & 255) == 71 && (openUrlForByte[1] & 255) == 73) {
                            str2 = "data:image/gif;base64,";
                        }
                        String str3 = str2 + PluginBaseInfoHelper.Base64Helper.encodeToString(openUrlForByte, 2);
                        if (str3 != null) {
                            hippyMap2.pushString("data", str3.replace("\\", "\\\\").replace("'", "\\'"));
                            HippyMap hippyMap3 = new HippyMap();
                            hippyMap3.pushInt("ret", 0);
                            hippyMap3.pushMap("response", hippyMap2);
                            promise.resolve(hippyMap3);
                            return;
                        }
                        HippyMap hippyMap4 = new HippyMap();
                        hippyMap4.pushInt("ret", -10);
                        hippyMap4.pushMap("response", hippyMap2);
                        promise.resolve(hippyMap4);
                        return;
                    }
                    HippyMap hippyMap5 = new HippyMap();
                    hippyMap5.pushInt("ret", -4);
                    hippyMap5.pushMap("response", hippyMap2);
                    promise.resolve(hippyMap5);
                } catch (IOException unused) {
                    HippyMap hippyMap6 = new HippyMap();
                    hippyMap6.pushInt("ret", -2);
                    hippyMap6.pushMap("response", new HippyMap());
                    promise.resolve(hippyMap6);
                }
            }
        }, 128, null, false);
    }

    @HippyMethod(name = "isPublicAccountTop")
    public void isPublicAccountTop(HippyMap hippyMap, Promise promise) {
        int i3;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        try {
            String string = hippyMap.getString(PUBLIC_ACCOUNT_UIN);
            if (!TextUtils.isEmpty(string) && (peekAppRuntime instanceof BaseQQAppInterface)) {
                boolean isPublicAccountTop = HippyModuleUtils.isPublicAccountTop((BaseQQAppInterface) peekAppRuntime, string);
                HippyMap hippyMap2 = new HippyMap();
                if (isPublicAccountTop) {
                    i3 = 0;
                } else {
                    i3 = -1;
                }
                hippyMap2.pushInt("retCode", i3);
                promise.resolve(hippyMap2);
            }
        } catch (Exception e16) {
            QLog.e(CLASSNAME, 1, "get PublicAccountTopState error , e:" + e16);
            promise.reject(e16);
        }
    }

    protected void onUniAgent(String str, boolean z16, Bundle bundle, Promise promise) {
        long j3;
        long j16;
        String str2;
        String str3;
        if (promise != null && bundle != null) {
            if (!z16) {
                int i3 = bundle.getInt(WadlProxyConsts.EXTRA_RESULT_CODE);
                if (i3 == 1001) {
                    uniAgentCallBack(promise, 201, 0, HardCodeUtil.qqStr(R.string.f238617k9));
                    return;
                } else if (i3 != 1002 && i3 != 1013) {
                    uniAgentCallBack(promise, 255, 0, HardCodeUtil.qqStr(R.string.f238637ka));
                    return;
                } else {
                    uniAgentCallBack(promise, 202, 0, HardCodeUtil.qqStr(R.string.f238627k_));
                    return;
                }
            }
            try {
                byte[] byteArray = bundle.getByteArray("extra_data");
                if (byteArray == null) {
                    uniAgentCallBack(promise, 255, 0, "SSO\u8fd4\u56de\u6570\u636e\u5305\u4e3a\u7a7a");
                    return;
                }
                WebSSOAgent$UniSsoServerRsp webSSOAgent$UniSsoServerRsp = new WebSSOAgent$UniSsoServerRsp();
                webSSOAgent$UniSsoServerRsp.mergeFrom(byteArray);
                if (webSSOAgent$UniSsoServerRsp.comm.has() && webSSOAgent$UniSsoServerRsp.comm.proctime.has()) {
                    j3 = webSSOAgent$UniSsoServerRsp.comm.proctime.get();
                } else {
                    j3 = -1;
                }
                if (webSSOAgent$UniSsoServerRsp.ret.has()) {
                    j16 = webSSOAgent$UniSsoServerRsp.ret.get();
                } else {
                    j16 = 0;
                }
                if (webSSOAgent$UniSsoServerRsp.errmsg.has()) {
                    str2 = webSSOAgent$UniSsoServerRsp.errmsg.get();
                } else {
                    str2 = "SSO\u53d1\u9001\u6210\u529f";
                }
                if (webSSOAgent$UniSsoServerRsp.rspdata.has()) {
                    str3 = webSSOAgent$UniSsoServerRsp.rspdata.get();
                } else {
                    str3 = null;
                }
                JSONObject generateAgentCostData = WebSSOUtils.generateAgentCostData(j3);
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(WebSSOUtils.CALLBACK_COLUMN_BUSINESSRET, j16);
                jSONObject.put("msg", str2);
                jSONObject.put("data", str3);
                jSONObject.put(WebSSOUtils.CALLBACK_COLUMN_SSORET, 0);
                jSONObject.put("speedPoint", generateAgentCostData);
                promise.resolve(jSONObject.toString());
            } catch (Throwable th5) {
                QLog.e(CLASSNAME, 1, "onUniAgent, onReceive, Exception: " + th5);
                uniAgentCallBack(promise, 255, 0, "parse error");
            }
        }
    }

    @HippyMethod(name = "publicFollow")
    public void publicFollow(HippyMap hippyMap, final Promise promise) {
        if (hippyMap == null) {
            promise.reject("params is null");
            return;
        }
        if (getAppInterface() == null) {
            promise.reject("appInterface is null");
            return;
        }
        try {
            boolean z16 = true;
            if (hippyMap.getInt("follow") != 1) {
                z16 = false;
            }
            String str = hippyMap.getLong("uin") + "";
            Bundle bundle = new Bundle();
            bundle.putBoolean("isFollow", z16);
            bundle.putString("uin", str);
            IPublicAccountObserver iPublicAccountObserver = (IPublicAccountObserver) QRoute.api(IPublicAccountObserver.class);
            iPublicAccountObserver.setOnCallback(new IPublicAccountObserver.c() { // from class: com.tencent.hippy.qq.module.QQDataModule.3
                @Override // com.tencent.biz.pubaccount.api.IPublicAccountObserver.c
                public void onFollowPublicAccount(boolean z17, String str2) {
                    super.onFollowPublicAccount(z17, str2);
                    promise.resolve(Integer.valueOf(!z17 ? 1 : 0));
                    try {
                        Intent intent = new Intent("com.tencent.mobileqq.PublicAccountObserver");
                        intent.putExtra("action", "follow");
                        intent.putExtra("isSuccess", z17);
                        intent.putExtra("uin", str2);
                        BaseApplication.getContext().sendBroadcast(intent);
                        SimpleEventBus.getInstance().dispatchEvent(new FollowUpdateEvent(1, str2));
                    } catch (Throwable th5) {
                        QLog.e(QQDataModule.CLASSNAME, 2, "onFollowPublicAccount sendBroadcast failed! " + QLog.getStackTraceString(th5));
                    }
                }

                @Override // com.tencent.biz.pubaccount.api.IPublicAccountObserver.c
                public void onUnfollowPublicAccount(boolean z17, String str2) {
                    super.onUnfollowPublicAccount(z17, str2);
                    promise.resolve(Integer.valueOf(!z17 ? 1 : 0));
                    try {
                        Intent intent = new Intent("com.tencent.mobileqq.PublicAccountObserver");
                        intent.putExtra("action", "unFollow");
                        intent.putExtra("isSuccess", z17);
                        intent.putExtra("uin", str2);
                        BaseApplication.getContext().sendBroadcast(intent);
                        SimpleEventBus.getInstance().dispatchEvent(new FollowUpdateEvent(0, str2));
                    } catch (Throwable th5) {
                        QLog.e(QQDataModule.CLASSNAME, 2, "onUnfollowPublicAccount sendBroadcast failed! " + QLog.getStackTraceString(th5));
                    }
                }
            });
            AppRuntime waitAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
            if (waitAppRuntime instanceof AppInterface) {
                AppInterface appInterface = (AppInterface) waitAppRuntime;
                if (z16) {
                    ((IPublicAccountUtil) QRoute.api(IPublicAccountUtil.class)).followUin(appInterface, BaseApplication.getContext(), str, iPublicAccountObserver, false, 0, true);
                } else {
                    ((IPublicAccountUtil) QRoute.api(IPublicAccountUtil.class)).unfollowUin(appInterface, BaseApplication.getContext(), str, false, iPublicAccountObserver, true);
                }
            }
        } catch (Throwable th5) {
            QLog.d(CLASSNAME, 2, "uniAgent e:" + th5);
        }
    }

    protected void sendUniAgentRequest(AppInterface appInterface, String str, long j3, String str2, BusinessObserver businessObserver) {
        WebSSOAgent$UniSsoServerReqComm webSSOAgent$UniSsoServerReqComm = new WebSSOAgent$UniSsoServerReqComm();
        webSSOAgent$UniSsoServerReqComm.platform.set(109L);
        webSSOAgent$UniSsoServerReqComm.osver.set(Build.VERSION.RELEASE);
        webSSOAgent$UniSsoServerReqComm.mqqver.set(AppSetting.f99551k);
        WebSSOAgent$UniSsoServerReq webSSOAgent$UniSsoServerReq = new WebSSOAgent$UniSsoServerReq();
        webSSOAgent$UniSsoServerReq.comm.set(webSSOAgent$UniSsoServerReqComm);
        webSSOAgent$UniSsoServerReq.reqdata.set(str2);
        NewIntent newIntent = new NewIntent(appInterface.getApplicationContext(), am.class);
        newIntent.putExtra(WadlProxyConsts.EXTRA_CMD, str);
        newIntent.putExtra("extra_data", webSSOAgent$UniSsoServerReq.toByteArray());
        newIntent.putExtra("extra_callbackid", "0");
        newIntent.putExtra("extra_timeout", j3);
        newIntent.setObserver(businessObserver);
        appInterface.startServlet(newIntent);
    }

    @HippyMethod(name = "setPublicAccountTopState")
    public void setPublicAccountTopState(HippyMap hippyMap, Promise promise) {
        boolean z16;
        try {
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            String string = hippyMap.getString(PUBLIC_ACCOUNT_UIN);
            int i3 = hippyMap.getInt(PUBLIC_ACCOUNT_TOP_STATE);
            if (!TextUtils.isEmpty(string) && (peekAppRuntime instanceof BaseQQAppInterface)) {
                BaseQQAppInterface baseQQAppInterface = (BaseQQAppInterface) peekAppRuntime;
                if (i3 == 1) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                int publicAccountTabTopState = HippyModuleUtils.setPublicAccountTabTopState(baseQQAppInterface, string, z16);
                HippyMap hippyMap2 = new HippyMap();
                hippyMap2.pushInt("retCode", publicAccountTabTopState);
                promise.resolve(hippyMap2);
            }
        } catch (Exception e16) {
            QLog.e(CLASSNAME, 1, "setPublicAccountTopState can't set pubAccount top, e:" + e16);
            promise.reject(e16);
        }
    }

    @HippyMethod(name = "uniAgent")
    public void uniAgent(HippyMap hippyMap, final Promise promise) {
        AppInterface appInterface;
        long j3;
        if (hippyMap == null || (appInterface = getAppInterface()) == null) {
            return;
        }
        try {
            final String string = hippyMap.getString("cmd");
            if (hippyMap.containsKey("timeout")) {
                j3 = hippyMap.getLong("timeout");
            } else {
                j3 = -1;
            }
            long j16 = j3;
            if (TextUtils.isEmpty(string)) {
                uniAgentCallBack(promise, 255, 0, HardCodeUtil.qqStr(R.string.f238607k8));
                return;
            }
            if (!NetworkUtil.isNetworkAvailable(BaseApplication.getContext())) {
                uniAgentCallBack(promise, 103, 0, "MSF\u672a\u8fde\u63a5");
                return;
            }
            JSONObject jSONObject = hippyMap.toJSONObject();
            WebSSOUtils.removeAgentUnusedData(jSONObject);
            jSONObject.put("option", WebSSOUtils.generateDeviceInfo());
            sendUniAgentRequest(appInterface, string, j16, jSONObject.toString(), new BusinessObserver() { // from class: com.tencent.hippy.qq.module.QQDataModule.2
                @Override // mqq.observer.BusinessObserver
                public void onReceive(int i3, boolean z16, Bundle bundle) {
                    QQDataModule.this.onUniAgent(string, z16, bundle, promise);
                }
            });
        } catch (Throwable th5) {
            QLog.d(CLASSNAME, 2, "uniAgent e:" + th5);
        }
    }

    protected void uniAgentCallBack(Promise promise, int i3, int i16, String str) {
        if (promise == null) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(WebSSOUtils.CALLBACK_COLUMN_SSORET, i3);
            jSONObject.put(WebSSOUtils.CALLBACK_COLUMN_BUSINESSRET, i16);
            jSONObject.put("msg", str);
            promise.resolve(jSONObject.toString());
            if (QLog.isColorLevel()) {
                QLog.d(CLASSNAME, 2, "uniAgentCallBack ssoRet:" + i3 + " businessRet:" + i16 + " msg:" + str);
            }
        } catch (Throwable th5) {
            QLog.e(CLASSNAME, 1, "uniAgentCallBack e:" + th5);
        }
    }

    @HippyMethod(name = ITVKPlayerEventListener.KEY_USER_INFO)
    public void userInfo(Promise promise) {
        if (promise == null) {
            return;
        }
        String domain = HippyModuleUtils.getDomain(getFragment(), getHippyQQEngine());
        if (!((IHippyAccessHelper) QRoute.api(IHippyAccessHelper.class)).checkDomainPermission(domain)) {
            domain = null;
        }
        promise.resolve(HippyModuleUtils.getUserInfo(domain));
    }
}
