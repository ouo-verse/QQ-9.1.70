package com.tencent.mobileqq.mini.network;

import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.mini.appbrand.utils.IPV6OnlyUtils;
import com.tencent.mobileqq.mini.util.JSONObjectFix;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes33.dex */
public class RequestStrategy {
    static final String TAG = "MiniAppInterface";
    private boolean mIPv6Only = false;

    /* renamed from: g, reason: collision with root package name */
    public static RequestStrategy f246656g = new RequestStrategy();
    private static int forceIpv6Switch = -1;

    RequestStrategy() {
        updateIPv6Status();
    }

    private boolean checkEnable() {
        return QzoneConfig.getInstance().getConfig("qqminiapp", "ipv6_proxy_enable", 0) == 1;
    }

    private String getUrlPrefix(String str) {
        if (TextUtils.isEmpty(str)) {
            QLog.e(TAG, 2, "getUrlPrefix fail ! originUrl is empty.");
            return "";
        }
        return str.startsWith("wss://") ? QzoneConfig.getInstance().getConfig("qqminiapp", "ipv6_websocket_proxy_url", "wss://proxy.gtimg.cn/tx_tls_gate=") : QzoneConfig.getInstance().getConfig("qqminiapp", "ipv6_http_proxy_url", "https://proxy.gtimg.cn/tx_tls_gate=");
    }

    private boolean isForceIpv6() {
        return false;
    }

    private void updateIPv6Status() {
        ThreadManagerV2.executeOnFileThread(new Runnable() { // from class: com.tencent.mobileqq.mini.network.RequestStrategy.1
            @Override // java.lang.Runnable
            public void run() {
                RequestStrategy.this.mIPv6Only = NetConnInfoCenter.getActiveNetIpFamily(true) == 2;
                QLog.d(RequestStrategy.TAG, 2, "updateIPv6Status ipv6: " + RequestStrategy.this.mIPv6Only);
            }
        });
    }

    public boolean addHttpForwardingInfo(JSONObject jSONObject) {
        boolean isForceIpv6 = isForceIpv6();
        if (!isForceIpv6 && !checkEnable()) {
            return false;
        }
        if (this.mIPv6Only || isForceIpv6) {
            Object config = QzoneConfig.getInstance().getConfig("qqminiapp", "MiniAppIPv6OnlyForwardingReferer", "https://appservice.qq.com");
            if (jSONObject.has("url")) {
                try {
                    String optString = jSONObject.optString("url");
                    if (!IPV6OnlyUtils.isUrlAllowedProxy(optString)) {
                        return false;
                    }
                    String urlPrefix = getUrlPrefix(optString);
                    jSONObject.put("origin_url", optString);
                    jSONObject.put("url", urlPrefix + optString);
                    JSONObject optJSONObject = jSONObject.has("header") ? jSONObject.optJSONObject("header") : new JSONObjectFix();
                    optJSONObject.put("Referer", config);
                    jSONObject.put("header", optJSONObject);
                    return true;
                } catch (Throwable unused) {
                }
            }
        }
        return false;
    }

    public boolean isIPv6Only() {
        return this.mIPv6Only;
    }

    public void notifyNetWorkStatusChange() {
        updateIPv6Status();
    }

    public String addHttpForwardingInfo(String str, Map<String, String> map) {
        boolean isForceIpv6 = isForceIpv6();
        if ((!isForceIpv6 && !checkEnable()) || !IPV6OnlyUtils.isUrlAllowedProxy(str)) {
            return str;
        }
        if (this.mIPv6Only || isForceIpv6) {
            String config = QzoneConfig.getInstance().getConfig("qqminiapp", "MiniAppIPv6OnlyForwardingReferer", "https://appservice.qq.com");
            if (!str.isEmpty()) {
                try {
                    str = getUrlPrefix(str) + str;
                    if (map != null) {
                        map.put("Referer", config);
                    }
                } catch (Throwable unused) {
                }
            }
        }
        return str;
    }
}
