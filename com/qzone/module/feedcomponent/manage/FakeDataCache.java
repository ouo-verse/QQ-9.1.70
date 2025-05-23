package com.qzone.module.feedcomponent.manage;

import android.text.TextUtils;
import com.qzone.adapter.feedcomponent.QZoneFakeFeedStatus;
import com.qzone.adapter.feedcomponent.i;
import com.qzone.adapter.feedcomponent.m;
import com.qzone.proxy.feedcomponent.b;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.model.CellFeedCommInfo;
import com.qzone.proxy.feedcomponent.util.f;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* compiled from: P */
/* loaded from: classes39.dex */
public class FakeDataCache {
    static final String TAG = "FakeDataCache";
    ConcurrentHashMap<String, BusinessFeedData> mFakeFeedsMap;
    List<BusinessFeedData> mFakedFeedsMemoryCache;
    long mOwnerUin;
    String mTableName;
    long mUin;
    ReadWriteLock mLock = new ReentrantReadWriteLock();
    protected CacheHolder mCacheHolder = new CacheHolder();

    public FakeDataCache(String str) {
        this.mTableName = str;
    }

    public void clearCache() {
        try {
            this.mLock.writeLock().lock();
            clearMemoryCache();
            m dbCacheManager = getDbCacheManager();
            if (dbCacheManager != null) {
                dbCacheManager.clearData();
            }
        } finally {
            this.mLock.writeLock().unlock();
        }
    }

    public void clearMemoryCache() {
        try {
            this.mLock.writeLock().lock();
            List<BusinessFeedData> list = this.mFakedFeedsMemoryCache;
            ConcurrentHashMap<String, BusinessFeedData> concurrentHashMap = this.mFakeFeedsMap;
            if (list != null) {
                list.clear();
            }
            if (concurrentHashMap != null) {
                concurrentHashMap.clear();
            }
            this.mFakedFeedsMemoryCache = null;
            this.mFakeFeedsMap = null;
        } finally {
            this.mLock.writeLock().unlock();
        }
    }

    public void close() {
        try {
            this.mLock.writeLock().lock();
            clearMemoryCache();
            m dbCacheManager = getDbCacheManager();
            if (dbCacheManager != null) {
                dbCacheManager.close();
            }
            this.mUin = 0L;
            this.mOwnerUin = 0L;
            this.mCacheHolder.reset();
        } finally {
            this.mLock.writeLock().unlock();
        }
    }

    public void deleteByFeedsKey(String str, QZoneFakeFeedStatus qZoneFakeFeedStatus) {
        if (!TextUtils.isEmpty(str)) {
            i.H().H1(str, qZoneFakeFeedStatus);
            deleteFeedData("feed_key=?", new String[]{str});
        } else {
            b.a(TAG, "deleteByFeedsKey failed (feedsKey is empty)");
        }
    }

    int deleteDataInner(Collection<String> collection) {
        m dbCacheManager;
        int i3 = 0;
        if (collection != null && collection.size() != 0 && (dbCacheManager = getDbCacheManager()) != null) {
            try {
                this.mLock.writeLock().lock();
                i3 = dbCacheManager.a(collection);
            } finally {
                this.mLock.writeLock().unlock();
            }
        }
        return i3;
    }

    public ArrayList<BusinessFeedData> deleteFakeFeedByClientKey(ArrayList<String> arrayList) {
        return deleteFakeFeed(arrayList, "client_key");
    }

    public ArrayList<BusinessFeedData> deleteFakeFeedByFeedKey(ArrayList<String> arrayList) {
        return deleteFakeFeed(arrayList, "feed_key");
    }

    public boolean deleteFeedData(String str, String[] strArr) {
        int i3;
        if (!TextUtils.isEmpty(str)) {
            try {
                this.mLock.writeLock().lock();
                try {
                    i3 = getDbCacheManager().deleteData(str, strArr);
                } catch (Exception unused) {
                    i3 = 0;
                }
                boolean z16 = i3 > 0;
                if (z16) {
                    reloadFakeFeeds();
                }
                return z16;
            } finally {
                this.mLock.writeLock().unlock();
            }
        }
        b.a(TAG, "deleteFeedData failed (whereClause is empty)");
        return false;
    }

    public boolean deleteFeedDataDbOnly(String str, String[] strArr) {
        int i3;
        m dbCacheManager = getDbCacheManager();
        if (dbCacheManager == null) {
            return false;
        }
        ArrayList arrayList = (ArrayList) dbCacheManager.f(str, strArr, null, 0, 0);
        if (arrayList == null || arrayList.size() <= 0) {
            i3 = 0;
        } else {
            try {
                this.mLock.writeLock().lock();
                i3 = dbCacheManager.deleteData(str, strArr);
            } finally {
                this.mLock.writeLock().unlock();
            }
        }
        return i3 > 0;
    }

    public void deleteInvalidFakeFeed() {
        boolean z16;
        List<BusinessFeedData> fakeFeeds = getFakeFeeds();
        if (fakeFeeds != null) {
            try {
                this.mLock.writeLock().lock();
                int size = fakeFeeds.size();
                for (int i3 = 0; i3 < size; i3++) {
                    BusinessFeedData businessFeedData = fakeFeeds.get(i3);
                    if (businessFeedData != null && businessFeedData.getLocalInfo().fakeType != 3) {
                        List<String> v06 = i.H().v0();
                        if (v06 != null) {
                            Iterator<String> it = v06.iterator();
                            z16 = false;
                            while (it.hasNext()) {
                                if (it.next().equals(businessFeedData.getFeedCommInfo().clientkey)) {
                                    if (System.currentTimeMillis() - businessFeedData.getFeedCommInfo().getTime() > 3600000) {
                                        if (businessFeedData.getVideoInfo() == null || businessFeedData.getFeedCommInfo().appid != 4) {
                                            if (f.c(businessFeedData)) {
                                                deleteByFeedsKey(businessFeedData.getFeedCommInfo().feedskey, QZoneFakeFeedStatus.CLIENT_NO_PUBLISH);
                                            } else {
                                                deleteByFeedsKey(businessFeedData.getFeedCommInfo().feedskey, QZoneFakeFeedStatus.CLIENT_NO_PUBLISH);
                                            }
                                        } else if (System.currentTimeMillis() - businessFeedData.getFeedCommInfo().getTime() > 14400000) {
                                            deleteByFeedsKey(businessFeedData.getFeedCommInfo().feedskey, QZoneFakeFeedStatus.CLIENT_NO_PUBLISH);
                                        }
                                    }
                                    z16 = true;
                                }
                            }
                        } else {
                            z16 = false;
                        }
                        long Z = i.H().Z();
                        if (!z16 && System.currentTimeMillis() - businessFeedData.getFeedCommInfo().getTime() > Z) {
                            deleteByFeedsKey(businessFeedData.getFeedCommInfo().feedskey, QZoneFakeFeedStatus.CLIENT_PUBLISHED);
                        }
                    }
                }
            } finally {
                this.mLock.writeLock().unlock();
            }
        }
    }

    protected m getDbCacheManager() {
        ensureCacheHolder(this.mCacheHolder);
        return this.mCacheHolder.cache;
    }

    public BusinessFeedData getFakeFeedByClientKey(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        ConcurrentHashMap<String, BusinessFeedData> fakeFeedsCacheMap = getFakeFeedsCacheMap();
        if (fakeFeedsCacheMap == null) {
            reloadFakeFeeds();
            fakeFeedsCacheMap = getFakeFeedsCacheMap();
        }
        if (fakeFeedsCacheMap != null) {
            return fakeFeedsCacheMap.get(str);
        }
        return null;
    }

    public List<BusinessFeedData> getFakeFeeds() {
        if (getFakeFeedsCache() == null) {
            reloadFakeFeeds();
        }
        return getFakeFeedsCache();
    }

    public List<BusinessFeedData> getFakeFeedsCache() {
        try {
            this.mLock.readLock().lock();
            return this.mFakedFeedsMemoryCache;
        } finally {
            this.mLock.readLock().unlock();
        }
    }

    ConcurrentHashMap<String, BusinessFeedData> getFakeFeedsCacheMap() {
        try {
            this.mLock.readLock().lock();
            return this.mFakeFeedsMap;
        } finally {
            this.mLock.readLock().unlock();
        }
    }

    public void init(long j3, long j16) {
        this.mUin = j3;
        this.mOwnerUin = j16;
    }

    public ArrayList<BusinessFeedData> query(String str, String str2) {
        m dbCacheManager = getDbCacheManager();
        if (dbCacheManager != null) {
            return (ArrayList) dbCacheManager.e(str, str2);
        }
        return null;
    }

    public BusinessFeedData querySingle(String str) {
        ArrayList<BusinessFeedData> query = query(str, null);
        if (query == null || query.size() <= 0) {
            return null;
        }
        return query.get(0);
    }

    void reloadFakeFeeds() {
        updateFakeFeedsDatas();
    }

    void updateFakeFeedsDatas() {
        m dbCacheManager = getDbCacheManager();
        if (dbCacheManager != null) {
            try {
                this.mLock.writeLock().lock();
                List<BusinessFeedData> synchronizedList = Collections.synchronizedList(new ArrayList());
                ConcurrentHashMap<String, BusinessFeedData> concurrentHashMap = new ConcurrentHashMap<>();
                List<? extends Object> g16 = dbCacheManager.g(null, null, 0, dbCacheManager.getCount());
                int size = g16 == null ? 0 : g16.size();
                for (int i3 = 0; i3 < size; i3++) {
                    BusinessFeedData businessFeedData = (BusinessFeedData) g16.get(i3);
                    if (businessFeedData != null) {
                        synchronizedList.add(businessFeedData);
                        putFeedDataToMapByClientKey(concurrentHashMap, businessFeedData);
                    }
                }
                this.mFakedFeedsMemoryCache = synchronizedList;
                this.mFakeFeedsMap = concurrentHashMap;
            } finally {
                this.mLock.writeLock().unlock();
            }
        }
    }

    public boolean updateFeedData(BusinessFeedData businessFeedData, String str) {
        m dbCacheManager = getDbCacheManager();
        if (dbCacheManager == null || businessFeedData == null) {
            return false;
        }
        try {
            this.mLock.writeLock().lock();
            if (dbCacheManager.b(businessFeedData, str) <= 0) {
                return false;
            }
            reloadFakeFeeds();
            this.mLock.writeLock().unlock();
            return true;
        } finally {
            this.mLock.writeLock().unlock();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public static final class CacheHolder {
        m cache;
        long ownerUin;
        long uin;

        CacheHolder() {
        }

        public void reset() {
            this.uin = 0L;
            this.ownerUin = 0L;
            this.cache = null;
        }
    }

    public boolean deleteFeedDataMemOnly(BusinessFeedData businessFeedData) {
        if (businessFeedData == null || this.mFakedFeedsMemoryCache == null || this.mFakeFeedsMap == null) {
            return false;
        }
        try {
            this.mLock.writeLock().lock();
            boolean remove = this.mFakedFeedsMemoryCache.remove(businessFeedData);
            this.mFakeFeedsMap.remove(businessFeedData.getFeedCommInfo().clientkey);
            return remove;
        } finally {
            this.mLock.writeLock().unlock();
        }
    }

    public ArrayList<BusinessFeedData> query(String str, String str2, String[] strArr) {
        m dbCacheManager = getDbCacheManager();
        if (dbCacheManager != null) {
            return (ArrayList) dbCacheManager.f(str, strArr, str2, -1, 0);
        }
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0030, code lost:
    
        if (r0 != null) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0032, code lost:
    
        r0 = new java.util.ArrayList<>();
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0037, code lost:
    
        r4 = r1.get(r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x003d, code lost:
    
        if (r4 == null) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x003f, code lost:
    
        r0.add(r4);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public ArrayList<BusinessFeedData> deleteFakeFeed(ArrayList<String> arrayList, String str) {
        ArrayList<BusinessFeedData> arrayList2 = null;
        if (arrayList != null) {
            ConcurrentHashMap<String, BusinessFeedData> concurrentHashMap = this.mFakeFeedsMap;
            ArrayList arrayList3 = new ArrayList();
            Iterator<String> it = arrayList.iterator();
            while (it.hasNext()) {
                String next = it.next();
                if (!TextUtils.isEmpty(next) && (concurrentHashMap == null || concurrentHashMap.size() == 0 || concurrentHashMap.containsKey(next))) {
                    arrayList3.add(str + "='" + next + "'");
                }
            }
            if (deleteDataInner(arrayList3) > 0) {
                reloadFakeFeeds();
            }
        }
        return arrayList2;
    }

    public ArrayList<BusinessFeedData> deleteFakeFeedByUgcKey(ArrayList<String> arrayList) {
        ArrayList<BusinessFeedData> arrayList2 = null;
        if (arrayList != null) {
            List<BusinessFeedData> fakeFeeds = getFakeFeeds();
            if (fakeFeeds == null) {
                return null;
            }
            ArrayList arrayList3 = new ArrayList();
            Iterator<String> it = arrayList.iterator();
            while (it.hasNext()) {
                String next = it.next();
                if (!TextUtils.isEmpty(next)) {
                    Iterator<BusinessFeedData> it5 = fakeFeeds.iterator();
                    while (true) {
                        if (!it5.hasNext()) {
                            break;
                        }
                        BusinessFeedData next2 = it5.next();
                        if (next2 != null && next.equals(next2.getFeedCommInfo().ugckey)) {
                            if (arrayList2 == null) {
                                arrayList2 = new ArrayList<>();
                            }
                            arrayList2.add(next2);
                            arrayList3.add("ugc_key='" + next + "'");
                        }
                    }
                }
            }
            if (deleteDataInner(arrayList3) > 0) {
                reloadFakeFeeds();
            }
        }
        return arrayList2;
    }

    void ensureCacheHolder(CacheHolder cacheHolder) {
        m mVar;
        if (cacheHolder == null) {
            return;
        }
        long j3 = this.mUin;
        long j16 = this.mOwnerUin;
        if (j3 != cacheHolder.uin || j16 != cacheHolder.ownerUin || (mVar = cacheHolder.cache) == null || mVar.isClosed()) {
            cacheHolder.uin = j3;
            cacheHolder.ownerUin = j16;
            cacheHolder.cache = i.H().y1(BusinessFeedData.class, j3, "_fake_" + this.mTableName + j16);
        }
    }

    public BusinessFeedData querySingle(String str, String[] strArr) {
        ArrayList<BusinessFeedData> query = query(str, null, strArr);
        if (query == null || query.size() <= 0) {
            return null;
        }
        return query.get(0);
    }

    public boolean saveFeedData(BusinessFeedData businessFeedData) {
        if (businessFeedData == null || !businessFeedData.needSaveToDb()) {
            return true;
        }
        m dbCacheManager = getDbCacheManager();
        if (dbCacheManager == null) {
            return false;
        }
        try {
            this.mLock.writeLock().lock();
            dbCacheManager.appendData(businessFeedData);
            reloadFakeFeeds();
            return true;
        } finally {
            this.mLock.writeLock().unlock();
        }
    }

    void putFeedDataToMapByClientKey(ConcurrentHashMap<String, BusinessFeedData> concurrentHashMap, BusinessFeedData businessFeedData) {
        if (concurrentHashMap == null || businessFeedData == null) {
            return;
        }
        CellFeedCommInfo feedCommInfo = businessFeedData.getFeedCommInfo();
        String str = feedCommInfo.clientkey;
        if (!TextUtils.isEmpty(str)) {
            concurrentHashMap.put(str, businessFeedData);
            return;
        }
        b.c(TAG, "updateFeedData failed(clientKey is empty , ugckey(encrypted):" + feedCommInfo.ugckey + "| feedsKey:" + feedCommInfo.feedskey + "| time:" + feedCommInfo.getTime() + "| appId:" + feedCommInfo.appid + "| subId:" + feedCommInfo.subid + ")");
    }

    public int deleteDataInner(String str) {
        m dbCacheManager = getDbCacheManager();
        if (dbCacheManager == null) {
            return 0;
        }
        try {
            this.mLock.writeLock().lock();
            return dbCacheManager.o(str);
        } finally {
            this.mLock.writeLock().unlock();
        }
    }
}
