package com.tencent.mobileqq.wxapi.impl;

import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.accountbinding.d;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.mobileqq.qqfeatureswitch.IFeatureRuntimeService;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.o;
import com.tencent.mobileqq.wxapi.IWXAuthApi;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ProcessUtil;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes21.dex */
public class WXAuthApiImpl implements IWXAuthApi {
    static IPatchRedirector $redirector_ = null;
    private static final String KEY_DEVICE_BLACK_LIST = "device_black_list";
    private static final String TAG = "WXAuthApiImpl";
    public static final String T_REPORT_WECHAT_AUTH_RESP = "0X800C2DF";

    /* compiled from: P */
    /* loaded from: classes21.dex */
    class a implements EIPCResultCallback {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ IWXAuthApi.a f327583d;

        a(IWXAuthApi.a aVar) {
            this.f327583d = aVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) WXAuthApiImpl.this, (Object) aVar);
            }
        }

        @Override // eipc.EIPCResultCallback
        public void onCallback(EIPCResult eIPCResult) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) eIPCResult);
                return;
            }
            QLog.d(WXAuthApiImpl.TAG, 1, "reqWXAuthCode IPC onCallback result: " + eIPCResult.isSuccess());
            if (!eIPCResult.isSuccess()) {
                QLog.e(WXAuthApiImpl.TAG, 1, "IPC get wechat code failed ");
                this.f327583d.a(-1, "ipc failed", "");
                return;
            }
            int i3 = eIPCResult.data.getInt("ret_code", -1);
            String string = eIPCResult.data.getString("error_msg", "");
            String string2 = eIPCResult.data.getString("result_auth_code", "");
            QLog.d(WXAuthApiImpl.TAG, 2, "reqWXAuthCode onCallback errCode: " + i3);
            this.f327583d.a(i3, string, string2);
        }
    }

    public WXAuthApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private AppRuntime getAppRuntime() {
        return MobileQQ.sMobileQQ.peekAppRuntime();
    }

    @Override // com.tencent.mobileqq.wxapi.IWXAuthApi
    public void checkWXNeedShowRedDotGuide(IWXAuthApi.b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) bVar);
        } else {
            d.f174609a.f(bVar);
        }
    }

    @Override // com.tencent.mobileqq.wxapi.IWXAuthApi
    public String getWXAppId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return com.tencent.mobileqq.wxapi.impl.a.a().b();
    }

    @Override // com.tencent.mobileqq.wxapi.IWXAuthApi
    public QIPCModule getWXIPCModule() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (QIPCModule) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return new c();
    }

    @Override // com.tencent.mobileqq.wxapi.IWXAuthApi
    public void handleWXEntryIntent(Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) intent);
        } else {
            com.tencent.mobileqq.wxapi.impl.a.a().d(intent);
        }
    }

    @Override // com.tencent.mobileqq.wxapi.IWXAuthApi
    public boolean isInBlackDeviceList() {
        JSONArray jSONArray;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this)).booleanValue();
        }
        if (getAppRuntime() == null) {
            QLog.w(TAG, 1, "isVivoBlackList, app is null.");
            return false;
        }
        IFeatureRuntimeService iFeatureRuntimeService = (IFeatureRuntimeService) getAppRuntime().getRuntimeService(IFeatureRuntimeService.class, "all");
        if (!iFeatureRuntimeService.isFeatureSwitchEnable("wxlogin_entry_device_black_list")) {
            QLog.d(TAG, 1, "isVivoBlackList, featureSwitch not enable.");
            return false;
        }
        JSONObject jSONObject = iFeatureRuntimeService.getJSONObject("wxlogin_entry_device_black_list", "");
        if (jSONObject == null) {
            return false;
        }
        try {
            jSONArray = jSONObject.getJSONArray(KEY_DEVICE_BLACK_LIST);
        } catch (JSONException e16) {
            QLog.e(TAG, 1, "loadDeviceList error : " + e16);
        }
        if (jSONArray == null) {
            return false;
        }
        String model = DeviceInfoMonitor.getModel();
        if (TextUtils.isEmpty(model)) {
            QLog.d(TAG, 1, "Build.MODEL is empty.");
            return false;
        }
        for (int i3 = 0; i3 < jSONArray.length(); i3++) {
            if (model.equalsIgnoreCase(jSONArray.getString(i3))) {
                return true;
            }
        }
        return false;
    }

    @Override // com.tencent.mobileqq.wxapi.IWXAuthApi
    public boolean isWXAppInstalled() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        if (!TextUtils.equals(ProcessUtil.getCurrentProcessName(BaseApplication.context), "com.tencent.mobileqq")) {
            EIPCResult callServer = QIPCClientHelper.getInstance().callServer("WeChatIPCModule", "action_check_wechat_installed", null);
            QLog.d(TAG, 1, "isWXAppInstalled IPC onCallback result: " + callServer.isSuccess());
            if (!callServer.isSuccess()) {
                return false;
            }
            return callServer.data.getBoolean("ret_code", false);
        }
        return com.tencent.mobileqq.wxapi.impl.a.a().f();
    }

    @Override // com.tencent.mobileqq.wxapi.IWXAuthApi
    public void reportWXAuthResult(int i3, int i16) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        if (i16 == 0) {
            str = "1";
        } else if (i16 == -4) {
            str = "2";
        } else if (i16 == -2) {
            str = "3";
        } else {
            str = "4";
        }
        ReportController.r(getAppRuntime(), "dc00898", "", "", T_REPORT_WECHAT_AUTH_RESP, T_REPORT_WECHAT_AUTH_RESP, i3, 0, str, "", o.c(), "");
    }

    @Override // com.tencent.mobileqq.wxapi.IWXAuthApi
    public void reqWXAuthCode(IWXAuthApi.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) aVar);
        } else if (!TextUtils.equals(ProcessUtil.getCurrentProcessName(BaseApplication.context), "com.tencent.mobileqq")) {
            QIPCClientHelper.getInstance().callServer("WeChatIPCModule", "action_get_wechat_code", null, new a(aVar));
        } else {
            com.tencent.mobileqq.wxapi.impl.a.a().g(aVar);
        }
    }
}
