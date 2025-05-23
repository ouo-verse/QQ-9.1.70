package com.tencent.mobileqq.rainbow;

import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.rainbow.api.IRainbowApi;
import com.tencent.mobileqq.rainbow.pb.RainbowData$GetRainbowConfigReq;
import com.tencent.mobileqq.rainbow.pb.RainbowData$GetRainbowConfigRsp;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes16.dex */
public class RainbowBusinessHandler extends BusinessHandler {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    public static final String f280191d;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(43121);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            f280191d = RainbowBusinessHandler.class.getName();
        }
    }

    protected RainbowBusinessHandler(AppInterface appInterface) {
        super(appInterface);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) appInterface);
        }
    }

    private JSONObject E2(FromServiceMsg fromServiceMsg, Object obj) {
        boolean z16;
        String obj2;
        if (fromServiceMsg != null && fromServiceMsg.isSuccess()) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            if (QLog.isColorLevel()) {
                QLog.d(IRainbowApi.TAG, 2, "parseData");
            }
            if (obj instanceof byte[]) {
                String trim = new String((byte[]) obj).trim();
                try {
                    return new JSONObject(trim);
                } catch (JSONException unused) {
                    if (QLog.isColorLevel()) {
                        QLog.w(IRainbowApi.TAG, 2, "parseData json error\uff1a" + trim);
                    }
                    RainbowData$GetRainbowConfigRsp rainbowData$GetRainbowConfigRsp = new RainbowData$GetRainbowConfigRsp();
                    try {
                        rainbowData$GetRainbowConfigRsp.mergeFrom((byte[]) obj);
                    } catch (InvalidProtocolBufferMicroException e16) {
                        if (QLog.isColorLevel()) {
                            QLog.w(IRainbowApi.TAG, 2, "InvalidProtocolBufferMicroException", e16);
                        }
                    }
                    String str = rainbowData$GetRainbowConfigRsp.value.get();
                    try {
                        return new JSONObject(str);
                    } catch (JSONException unused2) {
                        if (QLog.isColorLevel()) {
                            QLog.w(IRainbowApi.TAG, 2, "parseData json error\uff1a" + str);
                            return null;
                        }
                        return null;
                    }
                }
            }
            if (QLog.isColorLevel()) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append("parseData no value\uff1a");
                if (obj == null) {
                    obj2 = "null";
                } else {
                    obj2 = obj.toString();
                }
                sb5.append(obj2);
                QLog.w(IRainbowApi.TAG, 2, sb5.toString());
                return null;
            }
            return null;
        }
        if (QLog.isColorLevel()) {
            QLog.w(IRainbowApi.TAG, 2, "parseData isSuc false");
            return null;
        }
        return null;
    }

    public void D2(String str, String str2, String str3, String str4, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, str, str2, str3, str4, Integer.valueOf(i3));
            return;
        }
        if ((TextUtils.isEmpty(str3) || TextUtils.isEmpty(str4)) && QLog.isColorLevel()) {
            QLog.w(IRainbowApi.TAG, 2, "getRainbowData null \u3002key\uff1a" + str3 + "\uff0cfield\uff1a" + str4);
        }
        RainbowData$GetRainbowConfigReq rainbowData$GetRainbowConfigReq = new RainbowData$GetRainbowConfigReq();
        rainbowData$GetRainbowConfigReq.project.set(str);
        rainbowData$GetRainbowConfigReq.group.set(str2);
        rainbowData$GetRainbowConfigReq.key.set(str3);
        rainbowData$GetRainbowConfigReq.field.set(str4);
        ToServiceMsg createToServiceMsg = createToServiceMsg("trpc.qq_config.qq_rainbow_config_proxy.RConfigProxy.SsoGetRainbowConfig");
        createToServiceMsg.putWupBuffer(rainbowData$GetRainbowConfigReq.toByteArray());
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("REQUEST_TYPE", Integer.valueOf(i3));
        createToServiceMsg.setAttributes(hashMap);
        sendPbReq(createToServiceMsg);
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler, com.tencent.mobileqq.app.BaseBusinessHandler
    public Set<String> getCommandList() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (Set) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        if (this.allowCmdSet == null) {
            HashSet hashSet = new HashSet();
            this.allowCmdSet = hashSet;
            hashSet.add("trpc.qq_config.qq_rainbow_config_proxy.RConfigProxy.SsoGetRainbowConfig");
        }
        return this.allowCmdSet;
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler
    protected Class<? extends BusinessObserver> observerClass() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Class) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return a.class;
    }

    @Override // com.tencent.mobileqq.app.BaseBusinessHandler
    public void onReceive(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, toServiceMsg, fromServiceMsg, obj);
            return;
        }
        String serviceCmd = fromServiceMsg.getServiceCmd();
        if (QLog.isDevelopLevel()) {
            QLog.d(IRainbowApi.TAG, 4, "onReceive:" + serviceCmd);
        }
        if (msgCmdFilter(serviceCmd)) {
            if (QLog.isColorLevel()) {
                QLog.w(IRainbowApi.TAG, 2, "cmdfilter error=" + serviceCmd);
                return;
            }
            return;
        }
        JSONObject E2 = E2(fromServiceMsg, obj);
        if (E2 == null) {
            if (QLog.isColorLevel()) {
                QLog.w(IRainbowApi.TAG, 2, "realData error");
            }
        } else {
            if (QLog.isColorLevel()) {
                QLog.d(IRainbowApi.TAG, 2, "onReceive data:" + E2);
            }
            notifyUI(((Integer) toServiceMsg.getAttribute("REQUEST_TYPE", 0)).intValue(), true, E2);
        }
    }
}
