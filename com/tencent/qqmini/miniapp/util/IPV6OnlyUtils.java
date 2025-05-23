package com.tencent.qqmini.miniapp.util;

import android.text.TextUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.mobileqq.utils.httputils.HttpMsg;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.core.utils.WnsConfig;
import com.tencent.qqmini.sdk.launcher.core.proxy.RequestStrategyProxy;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import java.net.MalformedURLException;

/* loaded from: classes23.dex */
public class IPV6OnlyUtils {
    public static final String DEFAULT_PREFIX = "https://";
    public static final String HTTP_PREFIX = "http://";
    public static final String TAG = "IPV6OnlyUtils";
    public static final String WSS_PREFIX = "wss://";
    public static final String WS_PREFIX = "ws://";

    private static boolean checkEnableIPV6Only() {
        if (WnsConfig.getConfig("qqminiapp", "ipv6_proxy_enable", 0) != 1) {
            return false;
        }
        return true;
    }

    public static String getDomain(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (str.startsWith("wss://")) {
            if (str.length() > 6) {
                str = "https://" + str.substring(6);
            }
        } else if (!str.startsWith("https://")) {
            if (str.startsWith("http://")) {
                str = "https://" + str.substring(7);
            } else {
                str = "https://" + str;
            }
        }
        try {
            java.net.URL url = new java.net.URL(str);
            String host = url.getHost();
            url.getPort();
            if (!TextUtils.isEmpty(host) && host.startsWith("www.")) {
                return host.substring(4);
            }
            return host;
        } catch (MalformedURLException e16) {
            QMLog.e("IPV6OnlyUtils", "getDomainConfig url error" + str, e16);
            return null;
        }
    }

    public static String getEncoding(String str) {
        QMLog.d("IPV6OnlyUtils", "getMiniType " + str);
        if (TextUtils.isEmpty(str)) {
            return "utf-8";
        }
        try {
            for (String str2 : str.split(";")) {
                if (str2.trim().toLowerCase().startsWith(HttpMsg.CHARSET)) {
                    return str2.split(ContainerUtils.KEY_VALUE_DELIMITER)[1];
                }
            }
        } catch (Exception e16) {
            QMLog.e("IPV6OnlyUtils", "getEncoding failed, ", e16);
        }
        return "utf-8";
    }

    public static String getMimeType(String str) {
        QMLog.d("IPV6OnlyUtils", "getMiniType " + str);
        if (TextUtils.isEmpty(str)) {
            return "text/html";
        }
        for (String str2 : str.split(";")) {
            if (!str2.trim().toLowerCase().startsWith(HttpMsg.CHARSET)) {
                return str2;
            }
        }
        return "text/html";
    }

    public static boolean isDomainMatchRfc2109(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            QMLog.d("IPV6OnlyUtils", "isDomainMatchRfc2109 candidateDomain=" + str + ", checkDomain=" + str2);
            String lowerCase = str.toLowerCase();
            String lowerCase2 = str2.toLowerCase();
            if (lowerCase2.startsWith(".")) {
                return lowerCase.endsWith(lowerCase2);
            }
            return lowerCase.equals(lowerCase2);
        }
        return false;
    }

    public static boolean isIPV6Enable() {
        RequestStrategyProxy requestStrategyProxy = (RequestStrategyProxy) ProxyManager.get(RequestStrategyProxy.class);
        return requestStrategyProxy != null && requestStrategyProxy.isOpenIpv6Request() && checkEnableIPV6Only() && requestStrategyProxy.isIPV6Only();
    }

    public static boolean isUrlAllowedProxy(String str) {
        String config = WnsConfig.getConfig("qqminiapp", "ipv6_domain_black_list", ".idqqimg.com,.qq.com");
        String config2 = WnsConfig.getConfig("qqminiapp", "ipv6_domain_white_list", ".huanle.qq.com");
        if (TextUtils.isEmpty(config)) {
            return true;
        }
        String domain = getDomain(str);
        if (TextUtils.isEmpty(domain)) {
            return true;
        }
        for (String str2 : config2.split(",")) {
            if (isDomainMatchRfc2109(domain, str2)) {
                return true;
            }
        }
        for (String str3 : config.split(",")) {
            if (isDomainMatchRfc2109(domain, str3)) {
                return false;
            }
        }
        return true;
    }

    public static boolean isIPV6Enable(String str) {
        if (!TextUtils.isEmpty(str) && isIPV6Enable()) {
            return (str.toLowerCase().startsWith("http://") || str.toLowerCase().startsWith("https:")) && isUrlAllowedProxy(str);
        }
        return false;
    }
}
