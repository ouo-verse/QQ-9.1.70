package com.tencent.mobileqq.qqfeatureswitch.impl;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.guard.guardinterface.GuardManagerCallbackDispatcher;
import com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface;
import com.tencent.mobileqq.app.privacy.PrivacyPolicyHelper;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
import com.tencent.mobileqq.msf.sdk.handler.IWeakNetStatusHandler;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqfeatureswitch.FeatureSwitch;
import com.tencent.mobileqq.qqfeatureswitch.IFeatureRuntimeService;
import com.tencent.mobileqq.qqfeatureswitch.IShiply;
import com.tencent.mobileqq.qqfeatureswitch.impl.ShiplyImpl;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import iz3.e;
import iz3.h;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes16.dex */
public class FeatureRuntimeServiceImpl implements IFeatureRuntimeService, INetInfoHandler, IWeakNetStatusHandler, IGuardInterface {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "FeatureRuntimeServiceImpl";
    protected static boolean sHasInitSdk;
    private boolean fetchFailed;
    protected com.tencent.mobileqq.qqfeatureswitch.b mModel;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes16.dex */
    public class a implements e {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) FeatureRuntimeServiceImpl.this);
            }
        }

        @Override // iz3.e, iz3.m
        public /* synthetic */ void a(List list, List list2, List list3) {
            iz3.d.a(this, list, list2, list3);
        }

        @Override // iz3.m
        public void onFail(@NonNull String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
                return;
            }
            QLog.e(FeatureRuntimeServiceImpl.TAG, 1, "shiply full request failed: " + str);
            if (!"req_freq_limit".equals(str)) {
                FeatureRuntimeServiceImpl.this.fetchFailed = true;
            }
            FeatureRuntimeServiceImpl.this.checkUserIdChanged(false);
        }

        @Override // iz3.e
        public void onSuccess() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d(FeatureRuntimeServiceImpl.TAG, 2, "shiply onSuccess");
            }
            FeatureRuntimeServiceImpl.this.fetchFailed = false;
            FeatureRuntimeServiceImpl.this.checkUserIdChanged(false);
            FeatureRuntimeServiceImpl.this.notifyListeners();
        }
    }

    public FeatureRuntimeServiceImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.mModel = generateModel();
        }
    }

    private void checkShiplyUserIdChanged() {
        String str;
        if (MobileQQ.sProcessId == 1) {
            return;
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        String str2 = "";
        if (peekAppRuntime == null) {
            str = "";
        } else {
            str = peekAppRuntime.getCurrentUin();
        }
        if (str != null) {
            str2 = str;
        }
        ShiplyImpl shiplyImpl = (ShiplyImpl) QRoute.api(IShiply.class);
        if (!TextUtils.equals(str2, shiplyImpl.getUserId())) {
            shiplyImpl.switchUserId(str2, null);
        }
    }

    private void fetchAll(final ShiplyImpl.FetchFrom fetchFrom) {
        final ShiplyImpl shiplyImpl = (ShiplyImpl) QRoute.api(IShiply.class);
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.qqfeatureswitch.impl.c
            @Override // java.lang.Runnable
            public final void run() {
                FeatureRuntimeServiceImpl.this.lambda$fetchAll$0(shiplyImpl, fetchFrom);
            }
        }, 128, null, true);
    }

    private void initSdkFirst() {
        if (!sHasInitSdk) {
            initSdk();
        }
    }

    private void initShiply() {
        if (1 != MobileQQ.sProcessId) {
            return;
        }
        QLog.d(TAG, 1, "init shiply");
        AppNetConnInfo.registerConnectionChangeReceiver(null, this);
        AppNetConnInfo.registerWeakNetStatusHandler(null, this);
        GuardManagerCallbackDispatcher.registerCallBack(this);
        fetchAll(ShiplyImpl.FetchFrom.Init);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$checkUserIdChanged$1() {
        if (1 == MobileQQ.sProcessId) {
            fetchAll(ShiplyImpl.FetchFrom.UserIdChanged);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$fetchAll$0(ShiplyImpl shiplyImpl, ShiplyImpl.FetchFrom fetchFrom) {
        shiplyImpl.fetchAll(new a(), fetchFrom);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyListeners() {
        CopyOnWriteArrayList<com.tencent.mobileqq.qqfeatureswitch.c> a16 = com.tencent.mobileqq.qqfeatureswitch.a.a();
        if (!a16.isEmpty()) {
            QLog.d(TAG, 2, "updateListenerList=" + a16);
            for (com.tencent.mobileqq.qqfeatureswitch.c cVar : a16) {
                if (cVar != null) {
                    cVar.a();
                }
            }
        }
    }

    private void refetch() {
        if (this.fetchFailed) {
            fetchAll(ShiplyImpl.FetchFrom.NetChanged);
        }
    }

    @Nullable
    private JSONObject toJsonObject(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                return new JSONObject(str);
            } catch (JSONException e16) {
                QLog.e(TAG, 1, e16, new Object[0]);
            }
        }
        return null;
    }

    protected void checkUserIdChanged(boolean z16) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, z16);
            return;
        }
        if (sHasInitSdk) {
            synchronized (FeatureRuntimeServiceImpl.class) {
                AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
                if (peekAppRuntime != null) {
                    str = peekAppRuntime.getCurrentUin();
                } else {
                    str = "";
                }
                if (!TextUtils.isEmpty(str)) {
                    final ShiplyImpl shiplyImpl = (ShiplyImpl) QRoute.api(IShiply.class);
                    if (!TextUtils.equals(str, shiplyImpl.getUserId())) {
                        QLog.d(TAG, 1, "checkUserIdChanged:" + str);
                        shiplyImpl.switchUserId(str, new h() { // from class: com.tencent.mobileqq.qqfeatureswitch.impl.a
                            @Override // iz3.h
                            public final void onInitFinish() {
                                FeatureRuntimeServiceImpl.this.lambda$checkUserIdChanged$1();
                            }
                        });
                    } else if (z16) {
                        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.qqfeatureswitch.impl.b
                            @Override // java.lang.Runnable
                            public final void run() {
                                ShiplyImpl.this.reLogin();
                            }
                        }, 16, null, false);
                    }
                }
            }
        }
    }

    @Override // com.tencent.mobileqq.qqfeatureswitch.IFeatureRuntimeService
    public boolean clearAllData() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return ((Boolean) iPatchRedirector.redirect((short) 17, (Object) this)).booleanValue();
        }
        com.tencent.qqperf.crashdefend.c.a(BaseApplication.getContext());
        try {
            initSdkFirst();
            if (!sHasInitSdk) {
                QLog.w(TAG, 1, "clearAllData, sHasInitSdk is false");
                return false;
            }
            ((IShiply) QRoute.api(IShiply.class)).clearAll();
            return true;
        } catch (Throwable th5) {
            QLog.e(TAG, 1, "clearAllData failed with Throwable.", th5);
            return false;
        }
    }

    @Override // com.tencent.mobileqq.qqfeatureswitch.IFeatureRuntimeService
    public boolean clearData(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return ((Boolean) iPatchRedirector.redirect((short) 16, (Object) this, (Object) str)).booleanValue();
        }
        com.tencent.qqperf.crashdefend.c.a(BaseApplication.getContext());
        try {
            initSdkFirst();
            if (TextUtils.isEmpty(str)) {
                QLog.e(TAG, 1, "clearData, name is empty");
                return false;
            }
            if (!sHasInitSdk) {
                QLog.w(TAG, 1, "clearData, sHasInitSdk is false");
                return false;
            }
            ((IShiply) QRoute.api(IShiply.class)).clearData(str);
            return true;
        } catch (Throwable th5) {
            QLog.e(TAG, 1, "clearData failed with Throwable.", th5);
            return false;
        }
    }

    protected com.tencent.mobileqq.qqfeatureswitch.b generateModel() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (com.tencent.mobileqq.qqfeatureswitch.b) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return new com.tencent.mobileqq.qqfeatureswitch.e();
    }

    @Override // com.tencent.mobileqq.qqfeatureswitch.IFeatureRuntimeService
    public FeatureSwitch getFeatureSwitch(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (FeatureSwitch) iPatchRedirector.redirect((short) 6, (Object) this, (Object) str);
        }
        initSdkFirst();
        if (TextUtils.isEmpty(str)) {
            QLog.e(TAG, 1, "getFeatureSwitch, name is empty");
            return null;
        }
        if (!sHasInitSdk) {
            FeatureSwitch featureSwitch = new FeatureSwitch();
            featureSwitch.mSwitchName = str;
            featureSwitch.mSwitchEnable = true;
            return featureSwitch;
        }
        checkShiplyUserIdChanged();
        FeatureSwitch c16 = this.mModel.c(str, true);
        com.tencent.mobileqq.qqfeatureswitch.a.c(str, c16);
        return c16;
    }

    @Override // com.tencent.mobileqq.qqfeatureswitch.IFeatureRuntimeService
    public int getInt(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Integer) iPatchRedirector.redirect((short) 14, (Object) this, (Object) str, i3)).intValue();
        }
        initSdkFirst();
        if (TextUtils.isEmpty(str)) {
            QLog.e(TAG, 1, "getFeatureSwitch, name is empty");
            return 0;
        }
        if (!sHasInitSdk) {
            return i3;
        }
        checkShiplyUserIdChanged();
        return ((IShiply) QRoute.api(IShiply.class)).getInt(str, i3);
    }

    @Override // com.tencent.mobileqq.qqfeatureswitch.IFeatureRuntimeService
    public JSONObject getJSONObject(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (JSONObject) iPatchRedirector.redirect((short) 12, (Object) this, (Object) str, (Object) str2);
        }
        initSdkFirst();
        if (TextUtils.isEmpty(str)) {
            QLog.e(TAG, 1, "getFeatureSwitch, name is empty");
            return null;
        }
        if (!sHasInitSdk) {
            return toJsonObject(str2);
        }
        checkShiplyUserIdChanged();
        return ((IShiply) QRoute.api(IShiply.class)).getJSONObject(str, toJsonObject(str2));
    }

    @Override // com.tencent.mobileqq.qqfeatureswitch.IFeatureRuntimeService
    public String getString(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (String) iPatchRedirector.redirect((short) 13, (Object) this, (Object) str, (Object) str2);
        }
        initSdkFirst();
        if (TextUtils.isEmpty(str)) {
            QLog.e(TAG, 1, "getFeatureSwitch, name is empty");
            return null;
        }
        if (!sHasInitSdk) {
            return str2;
        }
        checkShiplyUserIdChanged();
        return ((IShiply) QRoute.api(IShiply.class)).getString(str, str2);
    }

    public Map<String, FeatureSwitch> getSwitchList() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (Map) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        initSdkFirst();
        if (!sHasInitSdk) {
            return new HashMap();
        }
        return this.mModel.b();
    }

    @Override // com.tencent.mobileqq.qqfeatureswitch.IFeatureRuntimeService
    public void initSdk() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        synchronized (FeatureRuntimeServiceImpl.class) {
            if (sHasInitSdk) {
                QLog.d(TAG, 1, "duplicate initToggle. ignore");
            } else if (!PrivacyPolicyHelper.isUserAllow()) {
                QLog.e(TAG, 1, new Throwable("can not init before user allow to"), new Object[0]);
            } else {
                initShiply();
                sHasInitSdk = true;
            }
        }
    }

    @Override // com.tencent.mobileqq.qqfeatureswitch.IFeatureRuntimeService
    public Map<String, String> isEnabledWithDataSet(String str, String str2) {
        JSONObject jSONObject;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return (Map) iPatchRedirector.redirect((short) 15, (Object) this, (Object) str, (Object) str2);
        }
        initSdkFirst();
        if (TextUtils.isEmpty(str)) {
            QLog.e(TAG, 1, "getFeatureSwitch, name is empty");
            return null;
        }
        if (!sHasInitSdk) {
            return new HashMap();
        }
        checkShiplyUserIdChanged();
        HashMap hashMap = new HashMap();
        try {
            jSONObject = ((IShiply) QRoute.api(IShiply.class)).getJSONObject(str, null);
        } catch (NullPointerException | JSONException e16) {
            QLog.e(TAG, 1, e16, new Object[0]);
        }
        if (jSONObject == null) {
            return hashMap;
        }
        Iterator keys = jSONObject.keys();
        while (keys.hasNext()) {
            String str3 = (String) keys.next();
            hashMap.put(str3, jSONObject.get(str3).toString());
        }
        return hashMap;
    }

    @Override // com.tencent.mobileqq.qqfeatureswitch.IFeatureRuntimeService
    public boolean isFeatureSwitchEnable(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 7)) ? isFeatureSwitchEnable(str, true) : ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this, (Object) str)).booleanValue();
    }

    @Override // com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface
    public void onApplicationBackground() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            iPatchRedirector.redirect((short) 28, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface
    public void onApplicationForeground() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            iPatchRedirector.redirect((short) 27, (Object) this);
        } else {
            fetchAll(ShiplyImpl.FetchFrom.Foreground);
        }
    }

    @Override // com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface
    public void onBackgroundTimeTick(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            iPatchRedirector.redirect((short) 30, (Object) this, j3);
        }
    }

    @Override // com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface
    public void onBackgroundUnguardTimeTick(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            iPatchRedirector.redirect((short) 32, (Object) this, j3);
        }
    }

    @Override // mqq.app.api.IRuntimeService
    public void onCreate(AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) appRuntime);
        } else {
            QLog.d(TAG, 1, "onCreate");
            checkUserIdChanged(true);
        }
    }

    @Override // mqq.app.api.IRuntimeService
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
            return;
        }
        QLog.d(TAG, 1, MosaicConstants$JsFunction.FUNC_ON_DESTROY);
        resetSwitchState();
        AppNetConnInfo.unregisterNetInfoHandler(this);
        AppNetConnInfo.unRegisterWeakNetStatusHandler(this);
        GuardManagerCallbackDispatcher.unregisterCallBack(this);
    }

    @Override // com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface
    public void onLiteTimeTick(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            iPatchRedirector.redirect((short) 31, (Object) this, j3);
        }
    }

    @Override // com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler
    public void onNetMobile2None() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler
    public void onNetMobile2Wifi(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this, (Object) str);
        }
    }

    @Override // com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler
    public void onNetNone2Mobile(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, (Object) str);
        } else {
            refetch();
        }
    }

    @Override // com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler
    public void onNetNone2Wifi(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this, (Object) str);
        } else {
            refetch();
        }
    }

    @Override // com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler
    public void onNetWifi2Mobile(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this, (Object) str);
        }
    }

    @Override // com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler
    public void onNetWifi2None() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.msf.sdk.handler.IWeakNetStatusHandler
    public void onNormalToWeakNet(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, (Object) this, i3);
        }
    }

    @Override // com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface
    public void onScreensStateChanged(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            iPatchRedirector.redirect((short) 29, (Object) this, z16);
        }
    }

    @Override // com.tencent.mobileqq.msf.sdk.handler.IWeakNetStatusHandler
    public void onWeakNetToNormal(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, (Object) this, i3);
        } else {
            refetch();
        }
    }

    public void resetSwitchState() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            this.mModel.e();
        }
    }

    public void setSwitchState(String str, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, str, Boolean.valueOf(z16));
        } else if (str == null) {
            QLog.e(TAG, 1, "setSwitchState, name is null");
        } else {
            this.mModel.a(str, z16);
        }
    }

    @Override // com.tencent.mobileqq.qqfeatureswitch.IFeatureRuntimeService
    public boolean isFeatureSwitchEnable(String str, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, this, str, Boolean.valueOf(z16))).booleanValue();
        }
        initSdkFirst();
        if (!sHasInitSdk) {
            return z16;
        }
        checkShiplyUserIdChanged();
        return this.mModel.d(str, z16);
    }
}
