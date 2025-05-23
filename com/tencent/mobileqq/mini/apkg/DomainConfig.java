package com.tencent.mobileqq.mini.apkg;

import android.text.TextUtils;
import com.tencent.mobileqq.minigame.utils.GameLog;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes33.dex */
public class DomainConfig {
    public static final String DEFAULT_PREFIX = "https://";
    public static final String HTTP_PREFIX = "http://";
    public static final String WSS_PREFIX = "wss://";
    public static final String WS_PREFIX = "ws://";
    public String host;
    public int port;
    private static final int needCheckPost = QzoneConfig.getInstance().getConfig("qqtriton", "MiniGameDomainNeedCheckPort", 0);
    private static ConcurrentHashMap<String, DomainConfig> domainConfigMap = new ConcurrentHashMap<>();

    public DomainConfig(String str, int i3) {
        this.host = str;
        this.port = i3;
    }

    public static DomainConfig getDomainConfig(String str) {
        return getDomainConfig(str, false);
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

    public static DomainConfig getDomainConfig(String str, boolean z16) {
        int port;
        String str2;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (domainConfigMap.contains(str)) {
            return domainConfigMap.get(str);
        }
        long currentTimeMillis = System.currentTimeMillis();
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
                QLog.e(GameLog.MINIHTTP_TAG, 1, "getDomainConfig url error" + str, e16);
                return null;
            }
        }
        if (!TextUtils.isEmpty(str2) && str2.startsWith("www.")) {
            str2 = str2.substring(4);
        }
        DomainConfig domainConfig = new DomainConfig(str2, port);
        if (z16) {
            domainConfigMap.put(str, domainConfig);
        }
        if (QLog.isColorLevel()) {
            QLog.i(GameLog.MINIHTTP_TAG, 2, "getDomainConfig url for " + str + " costTime:" + (System.currentTimeMillis() - currentTimeMillis));
        }
        return domainConfig;
    }

    public static boolean isDomainMatchRfc2019(String str, DomainConfig domainConfig) {
        if (domainConfig == null) {
            return false;
        }
        QLog.d("domainValid", 1, "isDomainMatchRfc2019 allowedDomainHost=" + str + ", requestDomain=" + domainConfig);
        return (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(domainConfig.host) && str.startsWith(".") && str.split("\\.").length >= 1 && domainConfig.host.endsWith(str)) || str.equals(domainConfig.host);
    }

    public static boolean isDomainConfigMatch(DomainConfig domainConfig, DomainConfig domainConfig2) {
        if (domainConfig == null || domainConfig2 == null) {
            return false;
        }
        boolean isDomainMatchRfc2019 = isDomainMatchRfc2019(domainConfig.host, domainConfig2);
        int i3 = domainConfig.port;
        int i16 = domainConfig2.port;
        boolean z16 = i3 == i16;
        if (!z16 && i3 <= 0) {
            z16 = i16 == 80 || i16 == 8080 || i16 <= 0;
        }
        if (!z16 && i16 <= 0) {
            z16 = i3 == 80 || i3 == 8080 || i3 <= 0;
        }
        int i17 = needCheckPost;
        if (i17 <= 0) {
            return isDomainMatchRfc2019;
        }
        QLog.i(GameLog.MINIHTTP_TAG, 1, "isDomainConfigMatch needCheckPost:" + i17);
        return isDomainMatchRfc2019 && z16;
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
}
