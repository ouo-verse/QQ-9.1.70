package com.tencent.component.network.downloader.strategy;

import android.text.TextUtils;
import com.tencent.component.network.NetworkManager;
import com.tencent.component.network.downloader.common.IPInfo;
import com.tencent.component.network.downloader.common.Utils;
import com.tencent.component.network.module.base.QDLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes5.dex */
public class IPConfigStrategy implements IPStrategy {
    private static final String TAG = "IPConfigStrategy";
    private ReadWriteLock RW_LOCK = new ReentrantReadWriteLock();
    private Map<String, Map<Integer, IPConfig>> mIPConfigs = new HashMap();
    private Map<String, Map<Integer, IPConfig>> mCacheIPConfigs = new HashMap();
    private Map<String, String> mValidIPCache = new ConcurrentHashMap();
    private Map<String, Pattern> mDominPatterns = new HashMap();
    private byte[] CONFIG_LOCK = new byte[0];
    private Map<String, String> mConfigs = new HashMap();
    private int mDefaultIsp = -1;

    /* loaded from: classes5.dex */
    public static class IPConfig {
        private int failCount = -1;
        public ArrayList<IPInfo> ipInfos = new ArrayList<>();

        public void appendIP(IPInfo iPInfo) {
            if (iPInfo == null) {
                return;
            }
            this.ipInfos.add(iPInfo);
        }

        public int getCurrFailCount() {
            return this.failCount;
        }

        public int getFailCount() {
            if (this.failCount < 0) {
                initStrarIndex();
            }
            return this.failCount;
        }

        public void initFailCount(String str) {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            Iterator<IPInfo> it = this.ipInfos.iterator();
            int i3 = -1;
            while (it.hasNext()) {
                i3++;
                if (str.endsWith(it.next().f99897ip)) {
                    this.failCount = i3;
                    return;
                }
            }
        }

        public void initStrarIndex() {
            ArrayList<IPInfo> arrayList = this.ipInfos;
            if (arrayList != null && arrayList.size() > 0) {
                this.failCount = Math.abs(new Random(System.currentTimeMillis()).nextInt()) % this.ipInfos.size();
            }
        }

        public void setFailCount(int i3) {
            this.failCount = i3;
        }
    }

    private final void addConfig(String str, Map<String, Map<Integer, IPConfig>> map, Map<String, Pattern> map2) {
        if (!TextUtils.isEmpty(str) && map != null && map2 != null) {
            String trim = str.trim();
            if (trim.startsWith(",")) {
                trim = "{" + trim.substring(1);
            }
            try {
                JSONObject jSONObject = new JSONObject(trim);
                JSONArray names = jSONObject.names();
                if (names != null) {
                    for (int i3 = 0; i3 < names.length(); i3++) {
                        String string = names.getString(i3);
                        Map<Integer, IPConfig> map3 = map.get(string);
                        if (map3 == null) {
                            map3 = new HashMap<>();
                            map.put(string, map3);
                        }
                        JSONArray jSONArray = jSONObject.getJSONArray(names.getString(i3));
                        if (jSONArray != null) {
                            for (int i16 = 0; i16 < jSONArray.length(); i16++) {
                                JSONObject jSONObject2 = jSONArray.getJSONObject(i16);
                                String string2 = jSONObject2.getString("ip");
                                Integer valueOf = Integer.valueOf(jSONObject2.getInt("port"));
                                Integer valueOf2 = Integer.valueOf(jSONObject2.getInt("apn"));
                                IPInfo iPInfo = new IPInfo(string2, valueOf.intValue());
                                IPConfig iPConfig = map3.get(valueOf2);
                                if (iPConfig == null) {
                                    iPConfig = new IPConfig();
                                    map3.put(valueOf2, iPConfig);
                                }
                                iPConfig.appendIP(iPInfo);
                            }
                        }
                        map2.put(string, Pattern.compile(string, 2));
                    }
                }
            } catch (Throwable th5) {
                QDLog.e(TAG, "exception when add ip config: " + trim, th5);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0055 A[ADDED_TO_REGION] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private Map<Integer, IPConfig> findIPConfigs(String str) {
        Map<Integer, IPConfig> map;
        Map<Integer, IPConfig> map2 = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        this.RW_LOCK.readLock().lock();
        boolean z16 = true;
        try {
        } finally {
            try {
                if (!z16) {
                }
                return map2;
            } finally {
            }
        }
        if (this.mCacheIPConfigs.containsKey(str)) {
            map = this.mCacheIPConfigs.get(str);
        } else {
            z16 = false;
            String dominKey = getDominKey(str);
            if (!TextUtils.isEmpty(dominKey) && this.mIPConfigs.containsKey(dominKey)) {
                map = this.mIPConfigs.get(dominKey);
            }
            if (!z16 && map2 != null) {
                try {
                    this.RW_LOCK.writeLock().lock();
                    this.mCacheIPConfigs.put(str, map2);
                } finally {
                    this.RW_LOCK.writeLock().unlock();
                }
            }
            return map2;
        }
        map2 = map;
        if (!z16) {
            this.RW_LOCK.writeLock().lock();
            this.mCacheIPConfigs.put(str, map2);
        }
        return map2;
    }

    private String getDominKey(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        Iterator<Map.Entry<String, Map<Integer, IPConfig>>> it = this.mIPConfigs.entrySet().iterator();
        while (it.hasNext()) {
            String key = it.next().getKey();
            if (Utils.match(this.mDominPatterns.get(key), str)) {
                return key;
            }
        }
        return null;
    }

    private boolean strEqual(String str, String str2) {
        if (str != null) {
            return str.equals(str2);
        }
        if (str2 == null) {
            return true;
        }
        return false;
    }

    protected String getLogTag() {
        return TAG;
    }

    @Override // com.tencent.component.network.downloader.strategy.IPStrategy
    public boolean isIPValid(String str, String str2) {
        ArrayList<IPInfo> arrayList;
        int i3;
        boolean z16 = false;
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            int ispType = NetworkManager.getIspType();
            String str3 = str + "_" + ispType;
            if (str2.equals(this.mValidIPCache.get(str3))) {
                return true;
            }
            Map<Integer, IPConfig> findIPConfigs = findIPConfigs(str);
            this.RW_LOCK.readLock().lock();
            if (findIPConfigs != null) {
                try {
                    IPConfig iPConfig = findIPConfigs.get(Integer.valueOf(ispType));
                    if (iPConfig == null && (i3 = this.mDefaultIsp) != -1) {
                        iPConfig = findIPConfigs.get(Integer.valueOf(i3));
                    }
                    if (iPConfig != null && (arrayList = iPConfig.ipInfos) != null) {
                        Iterator<IPInfo> it = arrayList.iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                break;
                            }
                            if (str2.equals(it.next().f99897ip)) {
                                z16 = true;
                                break;
                            }
                        }
                    }
                } finally {
                    try {
                    } finally {
                    }
                }
            }
            if (z16) {
                this.mValidIPCache.put(str3, str2);
            }
        }
        return z16;
    }

    @Override // com.tencent.component.network.downloader.strategy.IPStrategy
    public void onIPAccessResult(String str, String str2, boolean z16) {
        if (!TextUtils.isEmpty(str) && !z16 && !TextUtils.isEmpty(str2)) {
            int ispType = NetworkManager.getIspType();
            Map<Integer, IPConfig> findIPConfigs = findIPConfigs(str);
            this.RW_LOCK.writeLock().lock();
            if (findIPConfigs != null) {
                try {
                    IPConfig iPConfig = findIPConfigs.get(Integer.valueOf(ispType));
                    if (iPConfig != null && iPConfig.ipInfos != null) {
                        if (iPConfig.getCurrFailCount() < 0) {
                            iPConfig.initFailCount(str2);
                        }
                        if (str2.equals(iPConfig.ipInfos.get(iPConfig.getFailCount() % iPConfig.ipInfos.size()).f99897ip)) {
                            iPConfig.setFailCount(iPConfig.getFailCount() + 1);
                        }
                    }
                } finally {
                    try {
                    } finally {
                    }
                }
            }
        }
    }

    @Override // com.tencent.component.network.downloader.strategy.IPStrategy
    public String resolveIP(String str) {
        return resolveIP(str, NetworkManager.getIspType(), this.mDefaultIsp);
    }

    @Override // com.tencent.component.network.downloader.strategy.IPStrategy
    public List<IPInfo> resolveVideoIP(String str) {
        return resolveVideoIP(str, NetworkManager.getIspType(), this.mDefaultIsp);
    }

    public final void setConfig(Map<String, String> map) {
        boolean z16;
        if (map == null) {
            return;
        }
        synchronized (this.CONFIG_LOCK) {
            z16 = true;
            if (map.size() == this.mConfigs.size()) {
                Iterator<Map.Entry<String, String>> it = map.entrySet().iterator();
                while (true) {
                    if (it.hasNext()) {
                        Map.Entry<String, String> next = it.next();
                        if (!strEqual(next.getValue(), this.mConfigs.get(next.getKey()))) {
                            break;
                        }
                    } else {
                        z16 = false;
                        break;
                    }
                }
            }
            if (z16) {
                this.mConfigs.clear();
                this.mConfigs.putAll(map);
            }
        }
        if (z16) {
            HashMap hashMap = new HashMap();
            HashMap hashMap2 = new HashMap();
            for (Map.Entry<String, String> entry : map.entrySet()) {
                String key = entry.getKey();
                String value = entry.getValue();
                QDLog.i(getLogTag(), "IP Config -- " + key + ":" + value, null);
                addConfig(value, hashMap, hashMap2);
            }
            try {
                this.RW_LOCK.writeLock().lock();
                this.mIPConfigs.clear();
                this.mIPConfigs.putAll(hashMap);
                this.mDominPatterns.clear();
                this.mDominPatterns.putAll(hashMap2);
                this.mCacheIPConfigs.clear();
                this.mValidIPCache.clear();
            } finally {
                this.RW_LOCK.writeLock().unlock();
            }
        }
    }

    public void setDefaultIsp(int i3) {
        this.mDefaultIsp = i3;
    }

    private List<IPInfo> resolveVideoIP(String str, int i3, int i16) {
        ArrayList<IPInfo> arrayList = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        Map<Integer, IPConfig> findIPConfigs = findIPConfigs(str);
        this.RW_LOCK.readLock().lock();
        if (findIPConfigs != null) {
            try {
                IPConfig iPConfig = findIPConfigs.get(Integer.valueOf(i3));
                if (iPConfig == null && i16 != -1) {
                    iPConfig = findIPConfigs.get(Integer.valueOf(i16));
                }
                if (iPConfig != null) {
                    arrayList = iPConfig.ipInfos;
                }
            } finally {
                try {
                } finally {
                }
            }
        }
        return arrayList;
    }

    @Override // com.tencent.component.network.downloader.strategy.IPStrategy
    public String resolveIP(String str, int i3) {
        return resolveIP(str, i3, -1);
    }

    private String resolveIP(String str, int i3, int i16) {
        ArrayList<IPInfo> arrayList;
        String str2 = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        Map<Integer, IPConfig> findIPConfigs = findIPConfigs(str);
        this.RW_LOCK.readLock().lock();
        if (findIPConfigs != null) {
            try {
                IPConfig iPConfig = findIPConfigs.get(Integer.valueOf(i3));
                if (iPConfig == null && i16 != -1) {
                    iPConfig = findIPConfigs.get(Integer.valueOf(i16));
                }
                if (iPConfig != null && (arrayList = iPConfig.ipInfos) != null && arrayList.size() > 0) {
                    IPInfo iPInfo = iPConfig.ipInfos.get(iPConfig.getFailCount() % iPConfig.ipInfos.size());
                    if (iPInfo != null) {
                        str2 = iPInfo.f99897ip;
                    }
                }
            } finally {
                try {
                } finally {
                }
            }
        }
        return str2;
    }
}
