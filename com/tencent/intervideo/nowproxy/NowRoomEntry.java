package com.tencent.intervideo.nowproxy;

import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;
import com.tencent.avcore.netchannel.INetChannelCallback;
import com.tencent.beacon.upload.TunnelInfo;
import com.tencent.intervideo.nowproxy.ability.ExtSdkBizAbilityImpl;
import com.tencent.intervideo.nowproxy.ability.SdkBaseAbilityImpl;
import com.tencent.intervideo.nowproxy.ability.SdkBizAbilityImpl;
import com.tencent.intervideo.nowproxy.baseability.report.BeaconAdapter;
import com.tencent.intervideo.nowproxy.baseability.report.DataReport;
import com.tencent.intervideo.nowproxy.baseability.ticket.UnifyAccountMgr;
import com.tencent.intervideo.nowproxy.common.AccountUtil;
import com.tencent.intervideo.nowproxy.common.ThreadManager;
import com.tencent.intervideo.nowproxy.common.log.XLog;
import com.tencent.intervideo.nowproxy.common.login.AccountInfo;
import com.tencent.intervideo.nowproxy.common.login.LoginData;
import com.tencent.intervideo.nowproxy.common.login.LoginObserver;
import com.tencent.intervideo.nowproxy.common.login.LoginType;
import com.tencent.intervideo.nowproxy.common.login.NowLoginInfo;
import com.tencent.intervideo.nowproxy.common.roomparam.RoomParam;
import com.tencent.intervideo.nowproxy.common.util.NetworkUtil;
import com.tencent.intervideo.nowproxy.common.util.ToastUtil;
import com.tencent.intervideo.nowproxy.customized_interface.ActionCallback;
import com.tencent.intervideo.nowproxy.customized_interface.CustomKey;
import com.tencent.intervideo.nowproxy.customized_interface.IShadow;
import com.tencent.intervideo.nowproxy.proxyinner.util.NowSchemeUtil;
import com.tencent.intervideo.shadow_updater.Shadow;
import com.tencent.intervideo.shadow_updater.ShadowImpl;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqmini.sdk.utils.MiniSDKConst;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import com.tencent.shadow.dynamic.host.DynamicRuntime;
import com.tencent.shadow.dynamic.host.EnterCallback;
import com.tencent.shadow.dynamic.host.PluginManager;
import com.tencent.shadow.dynamic.host.PluginProcessService;
import cooperation.qzone.video.QzoneVideoBeaconReport;
import java.util.Iterator;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes7.dex */
public class NowRoomEntry {
    static IPatchRedirector $redirector_ = null;
    public static final long DYNAMIC_ENTER_FROMID_PREFIX = 10000001;
    protected static final String TAG = "NowPluginManager | NowRoomEntry";
    int currentAction;
    private boolean isInitBeacon;
    long lastLoadingTime;
    long lastOpenTime;
    DataReport mDataReport;
    Context mGlobalContext;
    InitData mInitData;
    boolean mIsInit;
    boolean mIsLoading;
    LoginData mLoginData;
    LoginObserver mLoginObserver;
    SdkBaseAbilityImpl sdkBaseAbility;
    SdkBizAbilityImpl sdkBizAbility;
    IShadow shadowImpl;

    public NowRoomEntry() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.mIsLoading = false;
        this.isInitBeacon = false;
        this.sdkBizAbility = SdkBizAbilityImpl.getInstance();
        this.sdkBaseAbility = SdkBaseAbilityImpl.getsInstance();
        this.currentAction = 0;
        this.lastLoadingTime = System.currentTimeMillis();
    }

    public static String bytesToHexString(byte[] bArr) {
        StringBuilder sb5 = new StringBuilder("");
        if (bArr != null && bArr.length > 0) {
            for (byte b16 : bArr) {
                String hexString = Integer.toHexString(b16 & 255);
                if (hexString.length() < 2) {
                    sb5.append(0);
                }
                sb5.append(hexString);
            }
            return sb5.toString();
        }
        return null;
    }

    private boolean checkInitParam() {
        if (this.mInitData == null) {
            XLog.i(TAG, " \u8fd8\u6ca1\u6709\u521d\u59cb\u5316\uff0cpreInstall\u4e0d\u5904\u7406");
            return false;
        }
        return true;
    }

    private void exChangeTicket(int i3, LoginData loginData, boolean z16) {
        AccountInfo accountInfo = new AccountInfo();
        accountInfo.login_appid = loginData.getLoginAppid();
        LoginType loginType = loginData.getLoginType();
        if (loginType == LoginType.CUSTOM) {
            accountInfo.login_type = 4;
        } else if (loginType == LoginType.WTLOGIN) {
            accountInfo.login_type = 0;
        } else if (loginType == LoginType.WXBind) {
            accountInfo.login_type = 9;
        } else if (loginType == LoginType.QQConnect) {
            accountInfo.login_type = 8;
        } else if (loginType == LoginType.TOURIST) {
            accountInfo.login_type = 2;
        }
        accountInfo.authappid = loginData.getAuthAppId();
        accountInfo.skey = loginData.getSkey();
        accountInfo.user_id = loginData.getUserId();
        if (loginType == LoginType.WTLOGIN) {
            accountInfo.token = bytesToHexString(loginData.getKey());
        } else {
            accountInfo.token = new String(loginData.getKey());
        }
        UnifyAccountMgr.getInstance().exchageUnifyAccount((Integer.valueOf(this.mInitData.mAppID).intValue() * 16) + 2, accountInfo, new UnifyAccountMgr.IExchangeCallback(accountInfo, i3, z16, loginData) { // from class: com.tencent.intervideo.nowproxy.NowRoomEntry.1
            static IPatchRedirector $redirector_;
            final /* synthetic */ AccountInfo val$accountInfo;
            final /* synthetic */ LoginData val$loginData;
            final /* synthetic */ boolean val$notifyPlugin;
            final /* synthetic */ int val$source;

            {
                this.val$accountInfo = accountInfo;
                this.val$source = i3;
                this.val$notifyPlugin = z16;
                this.val$loginData = loginData;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, NowRoomEntry.this, accountInfo, Integer.valueOf(i3), Boolean.valueOf(z16), loginData);
                }
            }

            public void onAccountInfoRecv(JSONObject jSONObject) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) jSONObject);
                    return;
                }
                NowLoginInfo nowLoginInfo = new NowLoginInfo();
                long optLong = jSONObject.optLong(INetChannelCallback.KEY_TINY_ID);
                String optString = jSONObject.optString(ICustomDataEditor.STRING_ARRAY_PARAM_2);
                long optLong2 = jSONObject.optLong("uid");
                nowLoginInfo.ilive_a2 = optString;
                nowLoginInfo.ilive_tinyid = String.valueOf(optLong);
                String str = NowRoomEntry.this.mInitData.mAppID;
                nowLoginInfo.appid = str;
                nowLoginInfo.__client_type = String.valueOf((Integer.valueOf(str).intValue() * 16) + 2);
                nowLoginInfo.ilive_uin = optLong2;
                nowLoginInfo.lastLoginTime = System.currentTimeMillis();
                nowLoginInfo.loginType = this.val$accountInfo.login_type;
                Global.sNowLoginInfo = nowLoginInfo;
                LoginObserver loginObserver = NowRoomEntry.this.mLoginObserver;
                if (loginObserver != null) {
                    loginObserver.onGetNowTicket(this.val$source, 0, nowLoginInfo);
                }
                if (this.val$notifyPlugin) {
                    NowRoomEntry.this.enterPluginManager(3, LoginData.getLoginBundle(this.val$loginData));
                }
            }

            public void onError(int i16) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                    iPatchRedirector.redirect((short) 3, (Object) this, i16);
                    return;
                }
                XLog.e(NowRoomEntry.TAG, "exChangeTicket error, code=" + i16);
                LoginObserver loginObserver = NowRoomEntry.this.mLoginObserver;
                if (loginObserver != null) {
                    loginObserver.onGetNowTicket(this.val$source, i16, null);
                }
            }
        });
    }

    private PluginManager getPluginManager(String str) throws InterruptedException, TimeoutException, ExecutionException {
        try {
            return this.shadowImpl.getPluginManager(this.mGlobalContext, str, this.mInitData.mAppID);
        } catch (Exception e16) {
            throw e16;
        }
    }

    private void openRoom(Bundle bundle) {
        String userId;
        bundle.putAll(RoomParam.getRoomInitParam(this.mInitData));
        LoginData loginData = this.mLoginData;
        if (loginData == null || loginData.getLoginType() == LoginType.TOURIST) {
            bundle.putInt("platform", AccountUtil.getAccountType(LoginType.TOURIST));
        }
        bundle.putAll(RoomParam.getRoomLoginTicket(this.mLoginData));
        bundle.putAll(CustomInterfaceLogic.getsInstance().getCustomiseData());
        Bundle bundle2 = new Bundle();
        if (System.currentTimeMillis() - this.lastLoadingTime > 3000) {
            this.mIsLoading = false;
        }
        if (this.mIsLoading) {
            XLog.e(TAG, "enterShadowSdk \u6b63\u5728\u52a0\u8f7d\uff0c\u4e0d\u80fd\u91cd\u590d\u70b9\u51fb\u5165\u53e3");
            ToastUtil.show(this.mGlobalContext, "\u7f51\u7edc\u72b6\u51b5\u4e0d\u4f73\uff0c\u8bf7\u7a0d\u540e\u91cd\u8bd5", 0);
            bundle2.putString("op_name", "repeated_entry");
            this.sdkBaseAbility.reportData(bundle2);
            return;
        }
        this.mIsLoading = true;
        this.lastLoadingTime = System.currentTimeMillis();
        bundle2.putString("op_name", "begin_enter_shadow");
        this.sdkBaseAbility.reportData(bundle2);
        if (AppidConfig.isBrowserPlugin(this.mInitData.mAppID)) {
            ExtSdkBizAbilityImpl.getInstance().setQueryPhoneAuthStateCallback(new IQueryPhoneAuthStateCallback() { // from class: com.tencent.intervideo.nowproxy.NowRoomEntry.2
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) NowRoomEntry.this);
                    }
                }

                public void onQueryPhoneAuthState(int i3) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this, i3);
                    } else {
                        NowLive.onQueryPhoneAuthState(i3);
                    }
                }
            });
        }
        try {
            IShadow iShadow = this.shadowImpl;
            Context context = this.mGlobalContext;
            long parseLong = Long.parseLong(10000001L + this.mInitData.mAppID);
            LoginData loginData2 = this.mLoginData;
            if (loginData2 == null) {
                userId = "";
            } else {
                userId = loginData2.getUserId();
            }
            iShadow.enter(context, parseLong, userId, this.mInitData.mAppID, bundle, new EnterCallback(bundle) { // from class: com.tencent.intervideo.nowproxy.NowRoomEntry.3
                static IPatchRedirector $redirector_;
                final /* synthetic */ Bundle val$extras;

                {
                    this.val$extras = bundle;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) NowRoomEntry.this, (Object) bundle);
                    }
                }

                @Override // com.tencent.shadow.dynamic.host.EnterCallback
                public void onCloseLoadingView() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                        iPatchRedirector.redirect((short) 3, (Object) this);
                    } else {
                        ThreadManager.getUIThreadHandler().post(new Runnable() { // from class: com.tencent.intervideo.nowproxy.NowRoomEntry.3.2
                            static IPatchRedirector $redirector_;

                            {
                                IPatchRedirector iPatchRedirector2 = $redirector_;
                                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AnonymousClass3.this);
                                }
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                IPatchRedirector iPatchRedirector2 = $redirector_;
                                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                                    iPatchRedirector2.redirect((short) 2, (Object) this);
                                    return;
                                }
                                Iterator<NowPluginObserver> it = Global.getPluginObservers().iterator();
                                while (it.hasNext()) {
                                    it.next().onCloseLoadingView();
                                }
                            }
                        });
                    }
                }

                @Override // com.tencent.shadow.dynamic.host.EnterCallback
                public void onEnterComplete() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                        iPatchRedirector.redirect((short) 4, (Object) this);
                    } else {
                        ThreadManager.getUIThreadHandler().post(new Runnable() { // from class: com.tencent.intervideo.nowproxy.NowRoomEntry.3.3
                            static IPatchRedirector $redirector_;

                            {
                                IPatchRedirector iPatchRedirector2 = $redirector_;
                                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AnonymousClass3.this);
                                }
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                IPatchRedirector iPatchRedirector2 = $redirector_;
                                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                                    iPatchRedirector2.redirect((short) 2, (Object) this);
                                } else {
                                    XLog.i(NowRoomEntry.TAG, "enterShadowSdk complete");
                                    NowRoomEntry.this.mIsLoading = false;
                                }
                            }
                        });
                    }
                }

                @Override // com.tencent.shadow.dynamic.host.EnterCallback
                public void onShowLoadingView(View view) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
                    } else {
                        ThreadManager.getUIThreadHandler().post(new Runnable(view) { // from class: com.tencent.intervideo.nowproxy.NowRoomEntry.3.1
                            static IPatchRedirector $redirector_;
                            final /* synthetic */ View val$view;

                            {
                                this.val$view = view;
                                IPatchRedirector iPatchRedirector2 = $redirector_;
                                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AnonymousClass3.this, (Object) view);
                                }
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                IPatchRedirector iPatchRedirector2 = $redirector_;
                                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                                    iPatchRedirector2.redirect((short) 2, (Object) this);
                                    return;
                                }
                                XLog.i(NowRoomEntry.TAG, "enterShadowSdk onShowLoadingView");
                                SdkBaseAbilityImpl sdkBaseAbilityImpl = SdkBaseAbilityImpl.getsInstance();
                                AnonymousClass3 anonymousClass3 = AnonymousClass3.this;
                                sdkBaseAbilityImpl.showLoadingUI(NowRoomEntry.this.mGlobalContext, anonymousClass3.val$extras, this.val$view);
                            }
                        });
                    }
                }
            });
        } catch (Exception e16) {
            bundle2.putString("op_name", "enter_shadow_exp");
            bundle2.putString("d1", e16.getMessage());
            this.sdkBaseAbility.reportData(bundle2);
            e16.printStackTrace();
        }
    }

    private void showTips(String str) {
        ThreadManager.getUIThreadHandler().post(new Runnable(str) { // from class: com.tencent.intervideo.nowproxy.NowRoomEntry.4
            static IPatchRedirector $redirector_;
            final /* synthetic */ String val$msg;

            {
                this.val$msg = str;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) NowRoomEntry.this, (Object) str);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                } else {
                    Toast.makeText(NowRoomEntry.this.mGlobalContext, this.val$msg, 0).show();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void closeRoom(Bundle bundle) {
        enterPluginManager(12, bundle);
    }

    public void doAction(String str, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 27)) {
            NowSchemeUtil.doActionByScheme(this.mGlobalContext, str, bundle, 0L);
        } else {
            iPatchRedirector.redirect((short) 27, (Object) this, (Object) str, (Object) bundle);
        }
    }

    public void enterPluginManager(int i3, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            iPatchRedirector.redirect((short) 29, (Object) this, i3, (Object) bundle);
            return;
        }
        XLog.d(TAG, "enterPluginManager\uff0c action\uff1a" + i3);
        bundle.putInt("action", i3);
        bundle.putBoolean("has_assetsApk", false);
        bundle.putString("assetsApk_version", AssetsLocalConfig.version);
        this.currentAction = i3;
        if (i3 == 1) {
            openRoom(bundle);
            return;
        }
        if (i3 == 2 || i3 == 8 || i3 == 10) {
            enterPluginManager(bundle, true, false);
        } else if (i3 == 6) {
            enterPluginManager(bundle, true, true);
        } else {
            enterPluginManager(bundle, false, false);
        }
    }

    public void exit() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this);
            return;
        }
        XLog.i(TAG, "exit");
        if (this.mInitData == null) {
            return;
        }
        CustomInterfaceLogic.sInstance.unInit();
    }

    public int getCurrentAction() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            return ((Integer) iPatchRedirector.redirect((short) 30, (Object) this)).intValue();
        }
        return this.currentAction;
    }

    public InitData getHostInfo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (InitData) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.mInitData;
    }

    public void getLiveOverPluginState() {
        String userId;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            iPatchRedirector.redirect((short) 32, (Object) this);
            return;
        }
        if (!this.shadowImpl.hasPluginManager()) {
            XLog.i(TAG, "getLiveOverPluginState--pluginmanager\u672a\u52a0\u8f7d--");
            ExtSdkBizAbilityImpl.getInstance().onLiveOverIsInstalled(false);
            return;
        }
        try {
            Bundle bundle = new Bundle();
            bundle.putInt("action", 9);
            IShadow iShadow = this.shadowImpl;
            Context context = this.mGlobalContext;
            long parseLong = Long.parseLong(10000001L + this.mInitData.mAppID);
            LoginData loginData = this.mLoginData;
            if (loginData == null) {
                userId = "";
            } else {
                userId = loginData.getUserId();
            }
            iShadow.enter(context, parseLong, userId, this.mInitData.mAppID, bundle, null);
        } catch (Exception e16) {
            XLog.e(TAG, "getLiveOverPluginState--\u52a0\u8f7dPluginManager\u5931\u8d25,e = " + e16.getMessage());
            ExtSdkBizAbilityImpl.getInstance().onLiveOverIsInstalled(false);
        }
    }

    public LoginData getLoginData() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (LoginData) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.mLoginData;
    }

    public LoginObserver getLoginObserver() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (LoginObserver) iPatchRedirector.redirect((short) 14, (Object) this);
        }
        return this.mLoginObserver;
    }

    public synchronized void init(Context context, InitData initData) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) initData);
            return;
        }
        if (this.mIsInit) {
            return;
        }
        Global.setApplicationContext(context);
        this.mGlobalContext = context;
        this.mInitData = initData;
        Global.sAppid = initData.mAppID;
        Global.sInitData = initData;
        CustomInterfaceLogic.getsInstance().init(this.mInitData.mAppID);
        IShadow shadowImpl = SdkBaseAbilityImpl.getsInstance().getShadowImpl();
        this.shadowImpl = shadowImpl;
        Global.sShadowImpl = shadowImpl;
        if (initData.mSetILoggerFactoryInside) {
            shadowImpl.setILoggerFactory();
        }
        if (!AppidConfig.isQQPlugin(this.mInitData.mAppID)) {
            this.mDataReport = DataReport.getInstance(initData.mAppID, context);
        }
        if (!TextUtils.isEmpty(initData.mGuid)) {
            UnifyAccountMgr.getInstance().setGuid(initData.mGuid);
        }
        this.mIsInit = true;
    }

    public void initNowSubProcess(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) context);
            return;
        }
        Global.sShadowImpl = new ShadowImpl();
        Shadow.setILoggerFactory();
        DynamicRuntime.recoveryRuntime(context);
        if (context instanceof Application) {
            ((Application) context).registerActivityLifecycleCallbacks(PluginProcessService.getActivityHolder());
        }
    }

    public boolean isInitData() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return ((Boolean) iPatchRedirector.redirect((short) 23, (Object) this)).booleanValue();
        }
        return true;
    }

    public void killPluginProcess() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this);
        } else {
            enterPluginManager(4, new Bundle());
        }
    }

    public void logout() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
        } else {
            this.mLoginData = null;
        }
    }

    public void onJumpApp(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, this, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putInt("id", i3);
        bundle.putInt("jumpapp_action", i16);
        bundle.putString("doAction", "jumpApp");
        enterPluginManager(6, bundle);
    }

    public void onQueryPhoneAuthState(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this, i3);
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putInt("phone_auth_state", i3);
        enterPluginManager(7, bundle);
    }

    public boolean openroom(ListNameData listNameData, long j3, String str, String str2, int i3, Bundle bundle) {
        String userId;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return ((Boolean) iPatchRedirector.redirect((short) 16, this, listNameData, Long.valueOf(j3), str, str2, Integer.valueOf(i3), bundle)).booleanValue();
        }
        XLog.i(TAG, "openroom roomid = " + j3 + " firstJump =" + i3);
        if (System.currentTimeMillis() - this.lastOpenTime < 1000) {
            XLog.i(TAG, "\u9891\u7387\u9650\u5236\uff0c\u70b9\u51fb\u592a\u5feb\u4e86\uff01");
            return false;
        }
        this.lastOpenTime = System.currentTimeMillis();
        DataReport dataReport = this.mDataReport;
        String str3 = "";
        if (dataReport != null) {
            Context context = this.mGlobalContext;
            String str4 = this.mInitData.mSourceVersion;
            LoginData loginData = this.mLoginData;
            if (loginData == null) {
                userId = "";
            } else {
                userId = loginData.getUserId();
            }
            dataReport.setReportCommonData(context, false, str4, userId, this.mInitData.mGuid);
        }
        Context context2 = this.mGlobalContext;
        if (context2 != null && this.mInitData != null) {
            if (!NetworkUtil.isNetworkAvailable(context2)) {
                ToastUtil.show(this.mGlobalContext, "\u5f53\u524d\u7f51\u7edc\u4e0d\u53ef\u7528\uff0c\u8bf7\u7a0d\u5019\u518d\u8bd5", 0);
                return false;
            }
            if (listNameData == null && j3 == 0 && TextUtils.isEmpty(str)) {
                XLog.i(TAG, "\u65e2\u6ca1\u6709\u586broomid\u4e5f\u6ca1\u6709\u586blistNamesData\uff0c\u4e0d\u5904\u7406");
                ToastUtil.show(this.mGlobalContext, MiniSDKConst.AdConst.ERROR_MSG_PARAM_ERROR, 0);
                return false;
            }
            bundle.putLong("entryTime", this.lastOpenTime);
            if (!AppidConfig.isBrowserPlugin(this.mInitData.mAppID)) {
                NowEntryData nowEntryData = new NowEntryData();
                nowEntryData.roomid = String.valueOf(j3);
                nowEntryData.roomType = String.valueOf(bundle.getString("roomtype"));
                nowEntryData.pluginstatus = "0";
                nowEntryData.pluginversion = "0";
                nowEntryData.source = str2;
                LoginData loginData2 = this.mLoginData;
                if (loginData2 != null) {
                    str3 = loginData2.getUserId();
                }
                nowEntryData.uid = str3;
                nowEntryData.networktype = String.valueOf(NetworkUtil.getNetworkType(this.mGlobalContext));
                this.sdkBaseAbility.reportNowEntry(nowEntryData);
            }
            enterPluginManager(1, bundle);
            return true;
        }
        XLog.i(TAG, "\u8fd8\u6ca1\u6709\u521d\u59cb\u5316\uff0c\u4e0d\u5904\u7406");
        return false;
    }

    public boolean preLogin(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this, (Object) bundle)).booleanValue();
        }
        return true;
    }

    public boolean preinstall(Bundle bundle) {
        String userId;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this, (Object) bundle)).booleanValue();
        }
        if (!checkInitParam()) {
            return false;
        }
        NowEntryData nowEntryData = new NowEntryData();
        nowEntryData.pluginstatus = "0";
        nowEntryData.pluginversion = "0";
        LoginData loginData = this.mLoginData;
        if (loginData == null) {
            userId = "";
        } else {
            userId = loginData.getUserId();
        }
        nowEntryData.uid = userId;
        nowEntryData.networktype = String.valueOf(NetworkUtil.getNetworkType(this.mGlobalContext));
        this.sdkBaseAbility.reportNowEntry(nowEntryData);
        Bundle bundle2 = new Bundle();
        bundle2.putAll(RoomParam.getRoomInitParam(this.mInitData));
        if (bundle != null) {
            bundle2.putBundle("userdata", bundle);
        }
        bundle2.putAll(CustomInterfaceLogic.getsInstance().getCustomiseData());
        enterPluginManager(8, bundle2);
        return true;
    }

    public boolean preload(Bundle bundle) {
        String userId;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this, (Object) bundle)).booleanValue();
        }
        XLog.i(TAG, "preload");
        InitData initData = this.mInitData;
        if (initData == null) {
            XLog.i(TAG, " \u8fd8\u6ca1\u6709\u521d\u59cb\u5316\uff0cpreload\u4e0d\u5904\u7406");
            return false;
        }
        DataReport dataReport = this.mDataReport;
        if (dataReport != null) {
            Context context = this.mGlobalContext;
            String str = initData.mSourceVersion;
            LoginData loginData = this.mLoginData;
            if (loginData == null) {
                userId = "";
            } else {
                userId = loginData.getUserId();
            }
            dataReport.setReportCommonData(context, false, str, userId, this.mInitData.mGuid);
        }
        Bundle bundle2 = new Bundle();
        bundle2.putAll(RoomParam.getRoomInitParam(this.mInitData));
        bundle2.putAll(CustomInterfaceLogic.getsInstance().getCustomiseData());
        if (bundle != null) {
            bundle2.putBundle("userdata", bundle);
        }
        enterPluginManager(2, bundle2);
        return true;
    }

    public boolean preloadParKey(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this, (Object) bundle)).booleanValue();
        }
        XLog.i(TAG, "preloadParKey");
        if (!checkInitParam()) {
            return false;
        }
        Bundle bundle2 = new Bundle();
        bundle2.putAll(RoomParam.getRoomInitParam(this.mInitData));
        bundle2.putAll(CustomInterfaceLogic.getsInstance().getCustomiseData());
        if (bundle != null) {
            bundle2.putBundle("userdata", bundle);
        }
        if (bundle != null) {
            String string = bundle.getString("preload_subaction", null);
            if (!TextUtils.isEmpty(string)) {
                bundle2.putString("doAction", string);
            }
            XLog.i(TAG, "preload--subaction = " + string);
        }
        enterPluginManager(10, bundle2);
        return true;
    }

    public void pushMessage(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, (Object) this, (Object) bundle);
        } else {
            XLog.i(TAG, "pushMessage");
        }
    }

    public void registerCustomisedPay(CustomizedPayment customizedPayment) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, (Object) this, (Object) customizedPayment);
        }
    }

    public void reportHostNowEntry() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            iPatchRedirector.redirect((short) 31, (Object) this);
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putString("op_name", "host_now_entry");
        bundle.putString("opername", "now_jiehe");
        this.sdkBaseAbility.reportData(bundle);
    }

    public void reportNowEntry(long j3, String str, int i3, Bundle bundle) {
        String userId;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, this, Long.valueOf(j3), str, Integer.valueOf(i3), bundle);
            return;
        }
        DataReport dataReport = this.mDataReport;
        String str2 = "";
        if (dataReport != null) {
            Context context = this.mGlobalContext;
            String str3 = this.mInitData.mSourceVersion;
            LoginData loginData = this.mLoginData;
            if (loginData == null) {
                userId = "";
            } else {
                userId = loginData.getUserId();
            }
            dataReport.setReportCommonData(context, false, str3, userId, this.mInitData.mGuid);
        }
        NowEntryData nowEntryData = new NowEntryData();
        nowEntryData.roomid = String.valueOf(j3);
        nowEntryData.roomType = String.valueOf(bundle.getString("roomtype"));
        nowEntryData.pluginstatus = "0";
        nowEntryData.pluginversion = "0";
        nowEntryData.source = str;
        LoginData loginData2 = this.mLoginData;
        if (loginData2 != null) {
            str2 = loginData2.getUserId();
        }
        nowEntryData.uid = str2;
        nowEntryData.networktype = String.valueOf(NetworkUtil.getNetworkType(this.mGlobalContext));
        this.sdkBaseAbility.reportNowEntry(nowEntryData);
    }

    public void resetLoadingStatus() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this);
        } else {
            this.mIsLoading = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void sendServerPushMessage(Bundle bundle) {
        if (bundle != null) {
            XLog.d(TAG, "sendServerPushMessage\uff0c cmd\uff1a" + bundle.get("ctrl_cmd"));
        }
        enterPluginManager(11, bundle);
    }

    public void setLiveRoomLifeCycleObserver(LiveRoomLifeCycleObserver liveRoomLifeCycleObserver) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, (Object) this, (Object) liveRoomLifeCycleObserver);
        }
    }

    public void setLoginData(LoginData loginData) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) loginData);
            return;
        }
        if (loginData == null) {
            XLog.e(TAG, "setLoginData but loginData is null!");
            return;
        }
        if (TextUtils.isEmpty(loginData.getUserId())) {
            XLog.i(TAG, "setLoginData but userid is null!");
            return;
        }
        XLog.i(TAG, "setLoginData,loginType = " + loginData.getLoginType() + " userid = " + loginData.getUserId() + " loginkey = " + loginData.getKey());
        this.mLoginData = loginData;
        Global.sLoginData = loginData;
    }

    public void setLoginObserver(LoginObserver loginObserver) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) loginObserver);
        } else {
            this.mLoginObserver = loginObserver;
        }
    }

    public void updateFreeFlow(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            iPatchRedirector.redirect((short) 33, (Object) this, z16);
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putBoolean(CustomKey.FREE_FLOW, z16);
        enterPluginManager(13, bundle);
    }

    public void updateLoginData(LoginData loginData, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, this, loginData, Boolean.valueOf(z16));
            return;
        }
        this.mLoginData = loginData;
        if (z16) {
            exChangeTicket(2, loginData, true);
        } else {
            enterPluginManager(3, LoginData.getLoginBundle(loginData));
        }
    }

    public void doAction(String str, Bundle bundle, ActionCallback actionCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            iPatchRedirector.redirect((short) 28, this, str, bundle, actionCallback);
            return;
        }
        if (!this.isInitBeacon && !AppidConfig.isQQPlugin(this.mInitData.mAppID) && !this.mInitData.mAppID.equals(QzoneVideoBeaconReport.RESULTCODE_VIDEO_TRIIMRECORD_DOWNLOADERROR)) {
            XLog.i(TAG, "nowsdk \u706f\u5854\u521d\u59cb\u5316");
            InitData initData = this.mInitData;
            BeaconAdapter.registerTunnel(new TunnelInfo("00000QCKA83QV1AA", "1.0.0", initData == null ? "0" : initData.mAppID));
            this.isInitBeacon = true;
        }
        NowSchemeUtil.doActionByScheme(this.mGlobalContext, str, bundle, !AppidConfig.isQQPlugin(this.mInitData.mAppID) ? SdkBizAbilityImpl.getInstance().putActionCallback(actionCallback) : 0L);
    }

    public void setLoginData(LoginData loginData, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, loginData, Boolean.valueOf(z16));
            return;
        }
        setLoginData(loginData);
        if (z16) {
            exChangeTicket(1, loginData, true);
        }
    }

    private void enterPluginManager(Bundle bundle, boolean z16, boolean z17) {
        if (!z16 && !this.shadowImpl.hasPluginManager()) {
            XLog.e(TAG, "pluginmanager\u672a\u52a0\u8f7d\uff0c\u65e0\u6cd5\u5904\u7406\u8be5action");
            return;
        }
        try {
            IShadow iShadow = this.shadowImpl;
            Context context = this.mGlobalContext;
            long parseLong = Long.parseLong(10000001L + this.mInitData.mAppID);
            LoginData loginData = this.mLoginData;
            iShadow.enter(context, parseLong, loginData == null ? "" : loginData.getUserId(), this.mInitData.mAppID, bundle, null);
        } catch (Exception e16) {
            XLog.e(TAG, "\u52a0\u8f7dPluginManager\u5931\u8d25,e = " + e16.getMessage());
            if (z17) {
                showTips("\u52a0\u8f7d\u76f4\u64ad\u7ec4\u4ef6\u5931\u8d25\uff0c\u8bf7\u68c0\u67e5\u7f51\u7edc");
            }
        }
    }
}
