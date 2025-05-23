package com.tencent.qqmini.sdk.launcher.model;

import android.text.TextUtils;
import com.tencent.mobileqq.minigame.utils.GameLog;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.utils.FastClickUtils;
import java.net.MalformedURLException;
import java.net.URL;

/* compiled from: P */
/* loaded from: classes23.dex */
public class DomainConfig {
    public static final String DEFAULT_PREFIX = "https://";
    public static final String HTTP_PREFIX = "http://";
    public static final String WSS_PREFIX = "wss://";
    public static final String WS_PREFIX = "ws://";
    private static final int needCheckPort = 0;
    public String host;
    public int port;

    public DomainConfig(String str, int i3) {
        this.host = str;
        this.port = i3;
    }

    public static DomainConfig getDomainConfig(String str) {
        int port;
        String str2;
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
            URL url = new URL(str);
            str2 = url.getHost();
            port = url.getPort();
        } catch (MalformedURLException e16) {
            try {
                URL url2 = new URL("https://" + str);
                String host = url2.getHost();
                port = url2.getPort();
                str2 = host;
            } catch (MalformedURLException unused) {
                QMLog.e(GameLog.MINIHTTP_TAG, "getDomainConfig url error" + str, e16);
                return null;
            }
        }
        if (!TextUtils.isEmpty(str2) && str2.startsWith("www.")) {
            str2 = str2.substring(4);
        }
        return new DomainConfig(str2, port);
    }

    public static boolean isDomainConfigMatch(DomainConfig domainConfig, DomainConfig domainConfig2) {
        if (domainConfig != null && domainConfig2 != null) {
            return isDomainMatchRfc2019(domainConfig.host, domainConfig2);
        }
        return false;
    }

    public static boolean isDomainMatchRfc2019(String str, DomainConfig domainConfig) {
        if (domainConfig == null) {
            return false;
        }
        if (!FastClickUtils.isFastDoubleClick("domainValid", 500L)) {
            QMLog.d("domainValid", "isDomainMatchRfc2019 allowedDomainHost=" + str + ", requestDomain=" + domainConfig);
        }
        if ((TextUtils.isEmpty(str) || TextUtils.isEmpty(domainConfig.host) || !str.startsWith(".") || str.split("\\.").length < 1 || !domainConfig.host.endsWith(str)) && !str.equals(domainConfig.host)) {
            return false;
        }
        return true;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        DomainConfig domainConfig = (DomainConfig) obj;
        if (this.port != domainConfig.port) {
            return false;
        }
        return this.host.equals(domainConfig.host);
    }

    public int hashCode() {
        return (this.host.hashCode() * 31) + this.port;
    }

    public String toString() {
        String str;
        if (this.port > 0) {
            str = ", port=" + this.port;
        } else {
            str = "";
        }
        return "DomainConfig{host='" + this.host + '\'' + str + '}';
    }
}
