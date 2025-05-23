package com.tencent.mobileqq.mini.utils;

import android.text.TextUtils;
import android.webkit.URLUtil;
import com.tencent.mobileqq.mini.apkg.DomainConfig;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes33.dex */
public class OpenDataDomainUtil {
    private static final String CONFIG_SPLIT = ";";
    private static String TAG = "OpenDataDomainUtil";
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
                String config = QzoneConfig.getInstance().getConfig("qqminiapp", "opendatahosts", ".qlogo.com;.qlogo.cn;.qq.com;.tcb.qcloud.la");
                if (config != null && !config.equals(this.mCurWhiteListConfig)) {
                    QLog.i("[mini] http.openDataDomainValid", 1, "Default white domain:" + config);
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

    public boolean isDomainValid(String str) {
        if (TextUtils.isEmpty(str)) {
            QLog.e("[mini] http.domainValid", 1, "url is null. url : " + str);
            return false;
        }
        String lowerCase = str.toLowerCase();
        if (!(URLUtil.isHttpUrl(str) || URLUtil.isHttpsUrl(str))) {
            return false;
        }
        DomainConfig domainConfig = DomainConfig.getDomainConfig(lowerCase);
        return isDomainConfigCached(domainConfig, 0) || checkWnsConfig(str, 0, domainConfig);
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
        if (arrayList.contains(domainConfig)) {
            return;
        }
        arrayList.add(domainConfig);
    }

    private boolean isDomainConfigCached(DomainConfig domainConfig, int i3) {
        ConcurrentHashMap<Integer, ArrayList<DomainConfig>> concurrentHashMap;
        ArrayList<DomainConfig> arrayList;
        return (domainConfig == null || (concurrentHashMap = this.mCachedDomainConfigMap) == null || (arrayList = concurrentHashMap.get(Integer.valueOf(i3))) == null || !arrayList.contains(domainConfig)) ? false : true;
    }
}
