package com.tencent.component.network.downloader.strategy;

import android.text.TextUtils;
import com.tencent.component.network.downloader.common.Utils;
import com.tencent.component.network.downloader.strategy.KeepAliveStrategy;
import com.tencent.component.network.module.base.Config;
import com.tencent.component.network.module.base.QDLog;
import com.tencent.component.network.utils.http.HttpUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.regex.Pattern;
import org.apache.http.HttpRequest;

/* compiled from: P */
/* loaded from: classes5.dex */
public class ConfigKeepAliveStrategy implements KeepAliveStrategy {
    private static final String CONFIG_SPLIT = ",";
    private static final String DEFAULT_KP_DOMAIN_CONFIG = "m.qpic.cn,a[0-9].qpic.cn";
    private static final String TAG = "ConfigKeepAliveStrategy";
    private String mStrCurrConfig;
    private List<String> mKpDomainRegularList = new ArrayList();
    private List<String> mKpDomainCacheList = new ArrayList();
    private Map<String, Pattern> mDominPatterns = new HashMap();
    private ReadWriteLock RW_LOCK = new ReentrantReadWriteLock();

    @Override // com.tencent.component.network.downloader.strategy.KeepAliveStrategy
    public final KeepAliveStrategy.KeepAlive keepAlive(String str, HttpRequest httpRequest, HttpUtil.RequestOptions requestOptions) {
        int photoDownloadKeepAliveProxyConfig;
        if (TextUtils.isEmpty(str)) {
            return KeepAliveStrategy.KeepAlive.DISABLE;
        }
        if (!supportKeepAlive(str)) {
            return KeepAliveStrategy.KeepAlive.DISABLE;
        }
        boolean containsProxy = HttpUtil.containsProxy(httpRequest, requestOptions);
        int photoDownloadKeepAliveConfig = Config.photoDownloadKeepAliveConfig();
        if (containsProxy && (photoDownloadKeepAliveProxyConfig = Config.photoDownloadKeepAliveProxyConfig()) != -1) {
            photoDownloadKeepAliveConfig = photoDownloadKeepAliveProxyConfig;
        }
        if (photoDownloadKeepAliveConfig != 0) {
            if (photoDownloadKeepAliveConfig != 1) {
                if (photoDownloadKeepAliveConfig != 2) {
                    return null;
                }
                return KeepAliveStrategy.KeepAlive.IGNORE;
            }
            return KeepAliveStrategy.KeepAlive.DISABLE;
        }
        return KeepAliveStrategy.KeepAlive.ENABLE;
    }

    public void setConfig(String str) {
        if (str != null && !str.equals(this.mStrCurrConfig)) {
            if (QDLog.isInfoEnable()) {
                QDLog.i(TAG, "keep alive domain:" + str);
            }
            ArrayList arrayList = new ArrayList();
            HashMap hashMap = new HashMap();
            try {
                String[] split = str.split(",");
                if (split != null) {
                    for (String str2 : split) {
                        if (!TextUtils.isEmpty(str2)) {
                            arrayList.add(str2);
                            hashMap.put(str2, Pattern.compile(str2, 2));
                        }
                    }
                }
            } catch (Throwable th5) {
                th5.printStackTrace();
            }
            try {
                this.RW_LOCK.writeLock().lock();
                this.mStrCurrConfig = str;
                this.mKpDomainRegularList.clear();
                this.mKpDomainRegularList.addAll(arrayList);
                this.mKpDomainCacheList.clear();
                this.mDominPatterns.clear();
                this.mDominPatterns.putAll(hashMap);
            } finally {
                this.RW_LOCK.writeLock().unlock();
            }
        }
    }

    @Override // com.tencent.component.network.downloader.strategy.KeepAliveStrategy
    public final boolean supportKeepAlive(String str) {
        boolean z16 = false;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            this.RW_LOCK.readLock().lock();
            if (this.mKpDomainCacheList.contains(str)) {
                return true;
            }
            Iterator<Map.Entry<String, Pattern>> it = this.mDominPatterns.entrySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                if (Utils.match(this.mDominPatterns.get(it.next().getKey()), str)) {
                    z16 = true;
                    break;
                }
            }
            if (z16) {
                try {
                    this.RW_LOCK.writeLock().lock();
                    this.mKpDomainCacheList.add(str);
                } finally {
                    this.RW_LOCK.writeLock().unlock();
                }
            }
            return z16;
        } finally {
            this.RW_LOCK.readLock().unlock();
        }
    }
}
