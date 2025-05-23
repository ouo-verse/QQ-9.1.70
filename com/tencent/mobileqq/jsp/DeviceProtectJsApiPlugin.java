package com.tencent.mobileqq.jsp;

import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.perf.block.BinderMethodProxy;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.tvkplayer.vinfo.live.TVKLiveRequestBuilder;
import eipc.EIPCResult;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes15.dex */
public class DeviceProtectJsApiPlugin extends WebViewPlugin {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private String f238583d;

    public DeviceProtectJsApiPlugin() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q() {
        DeviceProtectJsApiPlugin deviceProtectJsApiPlugin;
        String str;
        String str2;
        Exception exc;
        int i3;
        try {
            EIPCResult callServer = BinderMethodProxy.callServer(QIPCClientHelper.getInstance().getClient(), "DeviceProtectQIPCModule", "ACTION_GET_DEVICE_INFO", null);
            if (callServer.code != 0) {
                try {
                    QLog.e("DeviceProtectJsApiPlugin", 1, "handleGetDeviceInfo error: result.code != EIPCResult.CODE_NO_ERR");
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("retCode", -1);
                    callJs(this.f238583d, jSONObject.toString());
                    return;
                } catch (Exception e16) {
                    exc = e16;
                    deviceProtectJsApiPlugin = this;
                    str = "retCode";
                    str2 = "DeviceProtectJsApiPlugin";
                    try {
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put(str, -1);
                        deviceProtectJsApiPlugin.callJs(deviceProtectJsApiPlugin.f238583d, jSONObject2.toString());
                        i3 = 1;
                    } catch (JSONException e17) {
                        i3 = 1;
                        QLog.e(str2, 1, "GetDeviceInfo callJs JSONException", e17);
                    }
                    QLog.e(str2, i3, "GetDeviceInfo callJs error", exc);
                }
            }
            JSONObject jSONObject3 = new JSONObject();
            JSONObject jSONObject4 = new JSONObject();
            String string = callServer.data.getString("guid", "");
            try {
                String string2 = callServer.data.getString(TVKLiveRequestBuilder.RequestParamKey.QIMEI36, "");
                try {
                    String string3 = callServer.data.getString("qimei36", "");
                    try {
                        String string4 = callServer.data.getString("subappid", "");
                        String string5 = callServer.data.getString("platform", "");
                        String string6 = callServer.data.getString("brand", "");
                        String string7 = callServer.data.getString("model", "");
                        String string8 = callServer.data.getString("bssid", "");
                        jSONObject4.put("guid", string);
                        jSONObject4.put(TVKLiveRequestBuilder.RequestParamKey.QIMEI36, string2);
                        jSONObject4.put("qimei36", string3);
                        jSONObject4.put("subappid", string4);
                        jSONObject4.put("platform", string5);
                        jSONObject4.put("brand", string6);
                        jSONObject4.put("model", string7);
                        jSONObject4.put("bssid", string8);
                        jSONObject4.put("devInfo", string6 + " " + string7);
                        str = "retCode";
                        try {
                            jSONObject3.put(str, 0);
                            jSONObject3.put("retData", jSONObject4);
                            deviceProtectJsApiPlugin = this;
                            try {
                                deviceProtectJsApiPlugin.callJs(deviceProtectJsApiPlugin.f238583d, jSONObject3.toString());
                                StringBuilder sb5 = new StringBuilder();
                                sb5.append("guid:");
                                sb5.append(string);
                                sb5.append("qimei:");
                                sb5.append(string2);
                                sb5.append("subappid:");
                                sb5.append(string4);
                                sb5.append("platform:");
                                sb5.append(string5);
                                sb5.append("brand:");
                                sb5.append(string6);
                                sb5.append("model:");
                                sb5.append(string7);
                                sb5.append("bssid:");
                                sb5.append(string8);
                                str2 = "DeviceProtectJsApiPlugin";
                                try {
                                    QLog.d(str2, 1, "handleGetDeviceInfo info: " + ((Object) sb5));
                                } catch (Exception e18) {
                                    e = e18;
                                    exc = e;
                                    JSONObject jSONObject22 = new JSONObject();
                                    jSONObject22.put(str, -1);
                                    deviceProtectJsApiPlugin.callJs(deviceProtectJsApiPlugin.f238583d, jSONObject22.toString());
                                    i3 = 1;
                                    QLog.e(str2, i3, "GetDeviceInfo callJs error", exc);
                                }
                            } catch (Exception e19) {
                                e = e19;
                                str2 = "DeviceProtectJsApiPlugin";
                                exc = e;
                                JSONObject jSONObject222 = new JSONObject();
                                jSONObject222.put(str, -1);
                                deviceProtectJsApiPlugin.callJs(deviceProtectJsApiPlugin.f238583d, jSONObject222.toString());
                                i3 = 1;
                                QLog.e(str2, i3, "GetDeviceInfo callJs error", exc);
                            }
                        } catch (Exception e26) {
                            e = e26;
                            deviceProtectJsApiPlugin = this;
                        }
                    } catch (Exception e27) {
                        e = e27;
                        deviceProtectJsApiPlugin = this;
                        str2 = "DeviceProtectJsApiPlugin";
                        str = "retCode";
                    }
                } catch (Exception e28) {
                    e = e28;
                    deviceProtectJsApiPlugin = this;
                    str = "retCode";
                    str2 = "DeviceProtectJsApiPlugin";
                    exc = e;
                    JSONObject jSONObject2222 = new JSONObject();
                    jSONObject2222.put(str, -1);
                    deviceProtectJsApiPlugin.callJs(deviceProtectJsApiPlugin.f238583d, jSONObject2222.toString());
                    i3 = 1;
                    QLog.e(str2, i3, "GetDeviceInfo callJs error", exc);
                }
            } catch (Exception e29) {
                e = e29;
                deviceProtectJsApiPlugin = this;
            }
        } catch (Exception e36) {
            e = e36;
            deviceProtectJsApiPlugin = this;
            str = "retCode";
            str2 = "DeviceProtectJsApiPlugin";
        }
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public String getNameSpace() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return "deviceProtect";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public boolean handleJsRequest(JsBridgeListener jsBridgeListener, String str, String str2, String str3, String... strArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, this, jsBridgeListener, str, str2, str3, strArr)).booleanValue();
        }
        if (TextUtils.isEmpty(str)) {
            QLog.e("DeviceProtectJsApiPlugin", 1, "Call getDeviceInfo error, url is empty");
            return false;
        }
        QLog.d("DeviceProtectJsApiPlugin", 1, "Call DeviceProtectJsApiPlugin handleJsRequest, url" + str + " pkgName:" + str2);
        if ("deviceProtect".equals(str2)) {
            if ("getDeviceInfo".equals(str3)) {
                QLog.d("DeviceProtectJsApiPlugin", 1, "Call getDeviceInfo, args:" + strArr);
                String[] split = str.split("#");
                if (split != null && split.length == 2) {
                    this.f238583d = split[1];
                    ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.jsp.DeviceProtectJsApiPlugin.1
                        static IPatchRedirector $redirector_;

                        {
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                iPatchRedirector2.redirect((short) 1, (Object) this, (Object) DeviceProtectJsApiPlugin.this);
                            }
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                                DeviceProtectJsApiPlugin.this.q();
                            } else {
                                iPatchRedirector2.redirect((short) 2, (Object) this);
                            }
                        }
                    }, 16, null, false);
                    return true;
                }
                QLog.e("DeviceProtectJsApiPlugin", 1, "Call getDeviceInfo error, jsapi does not contain callback");
                return false;
            }
            if ("changePhoneNo".equals(str3)) {
                QLog.d("DeviceProtectJsApiPlugin", 1, "handleJsRequest: changePhoneNo");
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public void onCreate() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            super.onCreate();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            super.onDestroy();
        }
    }
}
