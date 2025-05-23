package com.tencent.component.network.module.common.dns;

import com.tencent.component.network.NetworkManager;
import com.tencent.component.network.module.base.QDLog;
import java.net.InetAddress;
import java.util.LinkedHashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes5.dex */
public class HostCacheManager {
    private static HostCacheManager manager;
    private final int MAX_CACHE_SIZE = 128;
    private Cache<String, HostEntity> data = new Cache<>(128);

    /* compiled from: P */
    /* loaded from: classes5.dex */
    private class Cache<K, V> extends LinkedHashMap<K, V> {
        private static final float DEFAULT_LOAD_FACTOR = 0.75f;
        private static final long serialVersionUID = -6940751117906094384L;
        private int capacity;
        private Object lock;

        public Cache(int i3) {
            super(i3, 0.75f, true);
            this.capacity = 5;
            this.lock = new Object();
            if (i3 > 0) {
                this.capacity = i3;
            }
        }

        @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
        public void clear() {
            synchronized (this.lock) {
                super.clear();
            }
        }

        @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
        public boolean containsKey(Object obj) {
            boolean containsKey;
            synchronized (this.lock) {
                containsKey = super.containsKey(obj);
            }
            return containsKey;
        }

        @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
        public V get(Object obj) {
            V v3;
            synchronized (this.lock) {
                v3 = (V) super.get(obj);
            }
            return v3;
        }

        @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
        public V put(K k3, V v3) {
            V v16;
            synchronized (this.lock) {
                v16 = (V) super.put(k3, v3);
            }
            return v16;
        }

        @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
        public void putAll(Map<? extends K, ? extends V> map) {
            synchronized (this.lock) {
                super.putAll(map);
            }
        }

        @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
        public V remove(Object obj) {
            V v3;
            synchronized (this.lock) {
                v3 = (V) super.remove(obj);
            }
            return v3;
        }

        @Override // java.util.LinkedHashMap
        protected boolean removeEldestEntry(Map.Entry<K, V> entry) {
            if (size() > this.capacity) {
                return true;
            }
            return false;
        }

        @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
        public int size() {
            int size;
            synchronized (this.lock) {
                size = super.size();
            }
            return size;
        }
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    private class HostEntity {
        public InetAddress[] address;
        public long expireTime;
        public String networkType;

        HostEntity() {
            this.expireTime = 0L;
            this.address = null;
            this.networkType = null;
        }

        public boolean isValid() {
            boolean z16;
            boolean z17 = true;
            if (System.currentTimeMillis() < this.expireTime) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                String apnValue = NetworkManager.getApnValue();
                if (apnValue == null || !apnValue.equalsIgnoreCase(this.networkType)) {
                    z17 = false;
                }
                return z17;
            }
            return z16;
        }
    }

    public static synchronized HostCacheManager getInstance() {
        HostCacheManager hostCacheManager;
        synchronized (HostCacheManager.class) {
            if (manager == null) {
                manager = new HostCacheManager();
            }
            hostCacheManager = manager;
        }
        return hostCacheManager;
    }

    public void addCache(String str, InetAddress[] inetAddressArr, long j3) {
        if (QDLog.isDebugEnable()) {
            QDLog.d("dnstest", "$$$addCache[" + str + "]");
        }
        HostEntity hostEntity = new HostEntity();
        hostEntity.expireTime = j3;
        hostEntity.address = inetAddressArr;
        hostEntity.networkType = NetworkManager.getApnValue();
        if (this.data.containsKey(str)) {
            this.data.remove(str);
        }
        this.data.put(str, hostEntity);
    }

    public InetAddress[] getCacheItemByHost(String str) {
        HostEntity hostEntity = this.data.get(str);
        if (hostEntity != null) {
            if (!hostEntity.isValid()) {
                this.data.remove(str);
                return null;
            }
            return hostEntity.address;
        }
        return null;
    }
}
