package com.tencent.qqmini.sdk.utils;

import android.text.TextUtils;
import android.webkit.URLUtil;
import com.tencent.qqmini.sdk.core.utils.WnsConfig;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.DomainConfig;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes23.dex */
public class OpenDataDomainUtil {
    private static final String CONFIG_SPLIT = ";";
    private static volatile OpenDataDomainUtil sInstance;
    private String mCurWhiteListConfig;
    private ArrayList<String> mDomainWhiteList = null;
    private ConcurrentHashMap<Integer, ArrayList<DomainConfig>> mCachedDomainConfigMap = new ConcurrentHashMap<>();

    OpenDataDomainUtil() {
    }

    private boolean checkWnsConfig(String str, int i3, DomainConfig domainConfig) {
        Iterator<String> it = getDomainWhiteList().iterator();
        while (it.hasNext()) {
            if (DomainConfig.isDomainMatchRfc2019(it.next(), domainConfig)) {
                putDomainConfigToCache(domainConfig, i3);
                return true;
            }
        }
        return false;
    }

    private List<String> getDomainWhiteList() {
        synchronized (OpenDataDomainUtil.class) {
            if (this.mDomainWhiteList == null) {
                this.mDomainWhiteList = new ArrayList<>();
                String config = WnsConfig.getConfig("qqminiapp", "opendatahosts", ".qlogo.com;.qlogo.cn;.qq.com;.tcb.qcloud.la");
                if (config != null && !config.equals(this.mCurWhiteListConfig)) {
                    QMLog.i("[mini] http.openDataDomainValid", "Default white domain:" + config);
                    String[] split = config.split(";");
                    if (split != null) {
                        for (String str : split) {
                            if (!TextUtils.isEmpty(str)) {
                                this.mDomainWhiteList.add(str);
                            }
                        }
                    }
                    this.mCurWhiteListConfig = config;
                }
            }
        }
        return this.mDomainWhiteList;
    }

    public static OpenDataDomainUtil getInstance() {
        if (sInstance == null) {
            synchronized (OpenDataDomainUtil.class) {
                if (sInstance == null) {
                    sInstance = new OpenDataDomainUtil();
                }
            }
        }
        return sInstance;
    }

    private boolean isDomainConfigCached(DomainConfig domainConfig, int i3) {
        ConcurrentHashMap<Integer, ArrayList<DomainConfig>> concurrentHashMap;
        ArrayList<DomainConfig> arrayList;
        if (domainConfig == null || (concurrentHashMap = this.mCachedDomainConfigMap) == null || (arrayList = concurrentHashMap.get(Integer.valueOf(i3))) == null || !arrayList.contains(domainConfig)) {
            return false;
        }
        return true;
    }

    private void putDomainConfigToCache(DomainConfig domainConfig, int i3) {
        if (domainConfig == null) {
            return;
        }
        if (this.mCachedDomainConfigMap == null) {
            this.mCachedDomainConfigMap = new ConcurrentHashMap<>();
        }
        ArrayList<DomainConfig> arrayList = this.mCachedDomainConfigMap.get(Integer.valueOf(i3));
        if (arrayList == null) {
            arrayList = new ArrayList<>();
            this.mCachedDomainConfigMap.put(Integer.valueOf(i3), arrayList);
        }
        if (!arrayList.contains(domainConfig)) {
            arrayList.add(domainConfig);
        }
    }

    public boolean isDomainValid(String str) {
        boolean z16;
        if (TextUtils.isEmpty(str)) {
            QMLog.e("[mini] http.domainValid", "url is null. url : " + str);
            return false;
        }
        String lowerCase = str.toLowerCase();
        if (!URLUtil.isHttpUrl(str) && !URLUtil.isHttpsUrl(str)) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (!z16) {
            return false;
        }
        DomainConfig domainConfig = DomainConfig.getDomainConfig(lowerCase);
        if (!isDomainConfigCached(domainConfig, 0) && !checkWnsConfig(str, 0, domainConfig)) {
            return false;
        }
        return true;
    }
}
