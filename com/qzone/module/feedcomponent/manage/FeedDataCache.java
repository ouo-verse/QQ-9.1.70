package com.qzone.module.feedcomponent.manage;

import android.text.TextUtils;
import com.qzone.adapter.feedcomponent.d;
import com.qzone.adapter.feedcomponent.i;
import com.qzone.adapter.feedcomponent.m;
import com.qzone.module.feedcomponent.ui.FeedViewBuilder;
import com.qzone.module.feedcomponent.ui.FeedViewSection;
import com.qzone.module.feedcomponent.ui.ViewLoader;
import com.qzone.proxy.feedcomponent.FeedGlobalEnv;
import com.qzone.proxy.feedcomponent.b;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.model.CellFeedCommInfo;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* compiled from: P */
/* loaded from: classes39.dex */
public class FeedDataCache {
    public static final int ACTIVITY_ID_PRELOAD = Integer.MAX_VALUE;
    static final int DATABASE_OVERFLOW_COUNT = 600;
    static final int DATABASE_SECONDARY_REMAIN_COUNT = 400;
    static final String KEY_LAST_UI_DATA_POSITION = "key_last_ui_data_pos";
    static final String TAG = "FeedDataCache";
    long mOwnerUin;
    String mTableName;
    long mUin;
    ConcurrentHashMap<String, BusinessFeedData> mCurrentDataMap = new ConcurrentHashMap<>();
    ConcurrentHashMap<String, BusinessFeedData> mTempPageCache = new ConcurrentHashMap<>();
    List<BusinessFeedData> mCurrentDatas = Collections.synchronizedList(new ArrayList());
    ReadWriteLock mLock = new ReentrantReadWriteLock();
    String mSortOrder = null;
    protected CacheHolder mCacheHolder = new CacheHolder();

    public FeedDataCache(String str) {
        this.mTableName = str;
    }

    public static int getPreloadActivityId() {
        return (int) ((System.currentTimeMillis() & 1895825407) | 251658240);
    }

    public void clearCache() {
        clearMemoryCache();
        clearPageCache();
        m dbCacheManager = getDbCacheManager();
        if (dbCacheManager != null) {
            dbCacheManager.clearData();
        }
    }

    public void clearDBCache() {
        m dbCacheManager = getDbCacheManager();
        if (dbCacheManager != null) {
            dbCacheManager.clearData();
        }
    }

    public void clearMemoryCache() {
        try {
            this.mLock.writeLock().lock();
            List<BusinessFeedData> list = this.mCurrentDatas;
            ConcurrentHashMap<String, BusinessFeedData> concurrentHashMap = this.mCurrentDataMap;
            if (list != null) {
                list.clear();
            }
            if (concurrentHashMap != null) {
                concurrentHashMap.clear();
            }
        } finally {
            this.mLock.writeLock().unlock();
        }
    }

    public void clearPageCache() {
        try {
            this.mLock.writeLock().lock();
            ConcurrentHashMap<String, BusinessFeedData> concurrentHashMap = this.mTempPageCache;
            if (concurrentHashMap != null) {
                concurrentHashMap.clear();
            }
        } finally {
            this.mLock.writeLock().unlock();
        }
    }

    public void close() {
        clearMemoryCache();
        clearPageCache();
        m dbCacheManager = getDbCacheManager();
        if (dbCacheManager != null) {
            dbCacheManager.close();
        }
        try {
            this.mLock.writeLock().lock();
            this.mUin = 0L;
            this.mOwnerUin = 0L;
            this.mCacheHolder.reset();
        } finally {
            this.mLock.writeLock().unlock();
        }
    }

    public boolean deleteByFeedsKey(String str) {
        char c16;
        BusinessFeedData businessFeedData;
        if (TextUtils.isEmpty(str)) {
            b.a(TAG, "deleteByFeedsKey failed (feedsKey is empty)");
            return false;
        }
        if (getDbCacheManager() == null) {
            return false;
        }
        int deleteDataInner = deleteDataInner("feed_key='" + str + "'");
        List<BusinessFeedData> list = this.mCurrentDatas;
        ConcurrentHashMap<String, BusinessFeedData> concurrentHashMap = this.mCurrentDataMap;
        ConcurrentHashMap<String, BusinessFeedData> concurrentHashMap2 = this.mTempPageCache;
        try {
            this.mLock.writeLock().lock();
            if (list == null || list.size() <= 0 || (businessFeedData = concurrentHashMap.get(str)) == null) {
                c16 = 0;
            } else {
                list.remove(businessFeedData);
                concurrentHashMap.remove(str);
                if (concurrentHashMap2 != null) {
                    concurrentHashMap2.remove(str);
                }
                c16 = 1;
            }
            this.mLock.writeLock().unlock();
            updateCurrentDatas(list);
            setPageCacheMap(concurrentHashMap2);
            return deleteDataInner > 0 || c16 > 0;
        } catch (Throwable th5) {
            this.mLock.writeLock().unlock();
            throw th5;
        }
    }

    int deleteDataInner(String str) {
        m dbCacheManager = getDbCacheManager();
        if (dbCacheManager != null) {
            return dbCacheManager.o(str);
        }
        return 0;
    }

    public boolean deleteFeedData(String str, String[] strArr) {
        int i3;
        int i16;
        m dbCacheManager = getDbCacheManager();
        if (dbCacheManager == null) {
            return false;
        }
        ArrayList arrayList = (ArrayList) dbCacheManager.f(str, strArr, null, 0, 0);
        if (arrayList == null || arrayList.size() <= 0) {
            i3 = 0;
            i16 = 0;
        } else {
            i3 = dbCacheManager.deleteData(str, strArr);
            List<BusinessFeedData> list = this.mCurrentDatas;
            ConcurrentHashMap<String, BusinessFeedData> concurrentHashMap = this.mCurrentDataMap;
            ConcurrentHashMap<String, BusinessFeedData> concurrentHashMap2 = this.mTempPageCache;
            if (list == null || list.size() <= 0) {
                i16 = 0;
            } else {
                try {
                    this.mLock.writeLock().lock();
                    Iterator it = arrayList.iterator();
                    i16 = 0;
                    while (it.hasNext()) {
                        String str2 = ((BusinessFeedData) it.next()).getFeedCommInfo().feedskey;
                        BusinessFeedData businessFeedData = concurrentHashMap.get(str2);
                        if (businessFeedData != null) {
                            i16++;
                            list.remove(businessFeedData);
                            concurrentHashMap.remove(str2);
                            if (concurrentHashMap2 != null) {
                                concurrentHashMap2.remove(str2);
                            }
                        }
                    }
                    this.mLock.writeLock().unlock();
                    updateCurrentDatas(list);
                    setPageCacheMap(concurrentHashMap2);
                } catch (Throwable th5) {
                    this.mLock.writeLock().unlock();
                    throw th5;
                }
            }
        }
        return i3 > 0 && i16 > 0;
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

    public void deleteOverflowFeeds() {
        m dbCacheManager = getDbCacheManager();
        if (dbCacheManager != null) {
            int count = dbCacheManager.getCount();
            if (count > 600) {
                int currentFeedsCount = getCurrentFeedsCount();
                int max = Math.max(currentFeedsCount, 400);
                b.a(TAG, "start deleteOverflowFeeds-> total:" + count + "| currentUICount:" + currentFeedsCount + "| capacity:" + max);
                dbCacheManager.j(max, null);
                StringBuilder sb5 = new StringBuilder();
                sb5.append("end deleteOverflowFeeds-> total:");
                sb5.append(dbCacheManager.getCount());
                b.e(TAG, sb5.toString());
                return;
            }
            b.e(TAG, "needn't to deleteOverflowFeeds-> total:" + count);
        }
    }

    public int getCacheSize() {
        m dbCacheManager = getDbCacheManager();
        if (dbCacheManager != null) {
            return dbCacheManager.getCount();
        }
        return 0;
    }

    public int getCurrentFeedsCount() {
        List<BusinessFeedData> list = this.mCurrentDatas;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    public List<BusinessFeedData> getCurrentUIDatas() {
        try {
            this.mLock.readLock().lock();
            return this.mCurrentDatas;
        } finally {
            this.mLock.readLock().unlock();
        }
    }

    protected m getDbCacheManager() {
        ensureCacheHolder(this.mCacheHolder);
        return this.mCacheHolder.cache;
    }

    public BusinessFeedData getFeedDataByFeedsKey(String str) {
        ConcurrentHashMap<String, BusinessFeedData> concurrentHashMap;
        if (!TextUtils.isEmpty(str)) {
            try {
                this.mLock.readLock().lock();
                BusinessFeedData businessFeedData = this.mCurrentDataMap.get(str);
                if (businessFeedData == null && (concurrentHashMap = this.mTempPageCache) != null) {
                    businessFeedData = concurrentHashMap.get(str);
                }
                return businessFeedData == null ? queryByFeedsKey(str) : businessFeedData;
            } finally {
                this.mLock.readLock().unlock();
            }
        }
        b.a(TAG, "getFeedDataByFeedsKey failed (feedsKey is empty)");
        return null;
    }

    ArrayList<BusinessFeedData> getFeeds(List<String> list) {
        if (list == null) {
            return null;
        }
        int preloadActivityId = getPreloadActivityId();
        ArrayList<BusinessFeedData> arrayList = new ArrayList<>();
        Iterator<String> it = list.iterator();
        int i3 = -1;
        while (true) {
            if (it.hasNext()) {
                int i16 = i3 + 1;
                BusinessFeedData feedDataByFeedsKey = getFeedDataByFeedsKey(it.next());
                if (feedDataByFeedsKey != null) {
                    if (!feedDataByFeedsKey.hasCalculate) {
                        d.x(feedDataByFeedsKey, i16 > 1);
                        feedDataByFeedsKey.hasCalculate = true;
                        if (feedDataByFeedsKey.needCalculateFeedView()) {
                            FeedViewSection.FeedViewOptions feedViewOptions = new FeedViewSection.FeedViewOptions();
                            feedViewOptions.isPreGenerateView = true;
                            FeedViewBuilder.setFeedDataInternal(FeedGlobalEnv.g().getPluginContext(), ViewLoader.getInstance().obtianFeedView(FeedGlobalEnv.g().getPluginContext(), null, false, false, preloadActivityId), feedDataByFeedsKey, feedViewOptions);
                        }
                    }
                    arrayList.add(feedDataByFeedsKey);
                }
                i3 = i16;
            } else {
                ViewLoader.getInstance().recyleFeedView(false, preloadActivityId);
                return arrayList;
            }
        }
    }

    int getLastUIDataPosition() {
        return FeedGlobalEnv.g().getCachePreference(FeedGlobalEnv.getContext(), this.mUin).getInt(KEY_LAST_UI_DATA_POSITION + this.mTableName, 0);
    }

    public ArrayList<BusinessFeedData> getNextPageDatas(int i3) {
        return getPageDatas(getStartIndex(), i3, true);
    }

    int getStartIndex() {
        try {
            this.mLock.readLock().lock();
            List<BusinessFeedData> list = this.mCurrentDatas;
            if (list == null) {
                this.mLock.readLock().unlock();
                return 0;
            }
            return list.size();
        } finally {
            this.mLock.readLock().unlock();
        }
    }

    public void init(long j3, long j16) {
        this.mUin = j3;
        this.mOwnerUin = j16;
    }

    public boolean isAllDBDataLoaded() {
        m dbCacheManager = getDbCacheManager();
        return dbCacheManager != null && dbCacheManager.getCount() <= getCurrentFeedsCount();
    }

    public List<BusinessFeedData> load(List<String> list) {
        return load(list, false);
    }

    public ArrayList<BusinessFeedData> query(String str, String str2) {
        m dbCacheManager = getDbCacheManager();
        if (dbCacheManager != null) {
            return (ArrayList) dbCacheManager.e(str, str2);
        }
        return null;
    }

    BusinessFeedData queryByFeedsKey(String str) {
        if (!TextUtils.isEmpty(str)) {
            return querySingle("feed_key= ?", new String[]{str});
        }
        b.a(TAG, "queryByFeedsKey failed (feedsKey is empty)");
        return null;
    }

    public BusinessFeedData querySingle(String str) {
        ArrayList<BusinessFeedData> query = query(str, null);
        if (query == null || query.size() <= 0) {
            return null;
        }
        return query.get(0);
    }

    void saveLastUIDataPosition(int i3) {
        FeedGlobalEnv.g().getCachePreference(FeedGlobalEnv.getContext(), this.mUin).edit().putInt(KEY_LAST_UI_DATA_POSITION + this.mTableName, i3).commit();
    }

    void setPageCacheMap(ConcurrentHashMap<String, BusinessFeedData> concurrentHashMap) {
        try {
            this.mLock.writeLock().lock();
            if (concurrentHashMap == null) {
                this.mTempPageCache = new ConcurrentHashMap<>();
            } else {
                ConcurrentHashMap<String, BusinessFeedData> concurrentHashMap2 = new ConcurrentHashMap<>();
                concurrentHashMap2.putAll(concurrentHashMap);
                this.mTempPageCache = concurrentHashMap2;
            }
        } finally {
            this.mLock.writeLock().unlock();
        }
    }

    public void setSortOrder(String str) {
        this.mSortOrder = str;
    }

    void updateCurrentDatas(List<BusinessFeedData> list) {
        try {
            this.mLock.writeLock().lock();
            if (list != null) {
                ConcurrentHashMap<String, BusinessFeedData> concurrentHashMap = new ConcurrentHashMap<>();
                Iterator<BusinessFeedData> it = list.iterator();
                while (it.hasNext()) {
                    putFeedDataToMapByFeedsKey(concurrentHashMap, it.next());
                }
                List<BusinessFeedData> synchronizedList = Collections.synchronizedList(new ArrayList());
                synchronizedList.addAll(list);
                this.mCurrentDatas = synchronizedList;
                this.mCurrentDataMap = concurrentHashMap;
            } else {
                List<BusinessFeedData> list2 = this.mCurrentDatas;
                ConcurrentHashMap<String, BusinessFeedData> concurrentHashMap2 = this.mCurrentDataMap;
                if (list2 != null) {
                    list2.clear();
                }
                if (concurrentHashMap2 != null) {
                    concurrentHashMap2.clear();
                }
            }
        } finally {
            this.mLock.writeLock().unlock();
        }
    }

    int updateDataInner(BusinessFeedData businessFeedData, String str) {
        m dbCacheManager = getDbCacheManager();
        if (dbCacheManager != null) {
            return dbCacheManager.b(businessFeedData, str);
        }
        return 0;
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

    public ArrayList<BusinessFeedData> getFirstPageDatas(int i3) {
        return getPageDatas(0, i3, false);
    }

    public List<BusinessFeedData> load(List<String> list, boolean z16) {
        if (list == null) {
            return null;
        }
        ArrayList<BusinessFeedData> feeds = getFeeds(list);
        if (feeds != null && feeds.size() > 0) {
            List<BusinessFeedData> list2 = this.mCurrentDatas;
            if (list2 != null && list2.size() > 0) {
                ArrayList arrayList = new ArrayList();
                try {
                    this.mLock.writeLock().lock();
                    ConcurrentHashMap<String, BusinessFeedData> concurrentHashMap = this.mCurrentDataMap;
                    for (BusinessFeedData businessFeedData : feeds) {
                        String str = businessFeedData.getFeedCommInfo().feedskey;
                        if (!TextUtils.isEmpty(str) && (concurrentHashMap == null || !concurrentHashMap.containsKey(str))) {
                            arrayList.add(businessFeedData);
                            if (z16) {
                                list2.add(0, businessFeedData);
                            } else {
                                list2.add(businessFeedData);
                            }
                        }
                    }
                    this.mLock.writeLock().unlock();
                    updateCurrentDatas(list2);
                    return arrayList;
                } catch (Throwable th5) {
                    this.mLock.writeLock().unlock();
                    throw th5;
                }
            }
            updateCurrentDatas(feeds);
        }
        return feeds;
    }

    public List<BusinessFeedData> restoreLastUIDatas(String str, int i3) {
        boolean z16 = false;
        int max = Math.max(i3, 0) * 2;
        m dbCacheManager = getDbCacheManager();
        ArrayList arrayList = null;
        if (dbCacheManager != null && max > 0 && !TextUtils.isEmpty(str)) {
            ArrayList arrayList2 = new ArrayList();
            List<? extends Object> g16 = dbCacheManager.g(null, this.mSortOrder, 0, max);
            int size = g16 == null ? 0 : g16.size();
            if (!TextUtils.isEmpty(str)) {
                int i16 = 0;
                while (true) {
                    if (i16 >= size) {
                        break;
                    }
                    BusinessFeedData businessFeedData = (BusinessFeedData) g16.get(i16);
                    if (businessFeedData != null) {
                        arrayList2.add(businessFeedData);
                        if (str.equalsIgnoreCase(businessFeedData.getFeedCommInfo().feedskey)) {
                            z16 = true;
                            break;
                        }
                    }
                    i16++;
                }
            }
            if (z16) {
                arrayList = arrayList2;
            }
        }
        updateCurrentDatas(arrayList);
        b.e(TAG, "restoreLastUIDatas --> lastUIDataPosition:" + i3 + "| count:" + max + "(" + this.mTableName + ")");
        return getCurrentUIDatas();
    }

    ArrayList<BusinessFeedData> getPageDatas(int i3, int i16, boolean z16) {
        if (i16 <= 0) {
            return null;
        }
        ArrayList<BusinessFeedData> feeds = getFeeds(i3, i16, z16);
        ConcurrentHashMap<String, BusinessFeedData> concurrentHashMap = new ConcurrentHashMap<>();
        if (feeds != null) {
            Iterator<BusinessFeedData> it = feeds.iterator();
            while (it.hasNext()) {
                putFeedDataToMapByFeedsKey(concurrentHashMap, it.next());
            }
        }
        setPageCacheMap(concurrentHashMap);
        return feeds;
    }

    public List<BusinessFeedData> loadMore(List<String> list) {
        ArrayList<BusinessFeedData> feeds;
        if (list != null && (feeds = getFeeds(list)) != null && feeds.size() > 0) {
            List<BusinessFeedData> list2 = this.mCurrentDatas;
            if (list2 != null && list2.size() > 0) {
                try {
                    this.mLock.writeLock().lock();
                    ConcurrentHashMap<String, BusinessFeedData> concurrentHashMap = this.mCurrentDataMap;
                    for (BusinessFeedData businessFeedData : feeds) {
                        String str = businessFeedData.getFeedCommInfo().feedskey;
                        if (!TextUtils.isEmpty(str) && (concurrentHashMap == null || !concurrentHashMap.containsKey(str))) {
                            list2.add(businessFeedData);
                        }
                    }
                    this.mLock.writeLock().unlock();
                    updateCurrentDatas(list2);
                } catch (Throwable th5) {
                    this.mLock.writeLock().unlock();
                    throw th5;
                }
            } else {
                updateCurrentDatas(feeds);
            }
        }
        return getCurrentUIDatas();
    }

    public ArrayList<BusinessFeedData> query(String str, String[] strArr, String str2) {
        m dbCacheManager = getDbCacheManager();
        if (dbCacheManager != null) {
            return (ArrayList) dbCacheManager.f(str, strArr, str2, -1, 0);
        }
        return null;
    }

    public void replaceAndSave(ArrayList<BusinessFeedData> arrayList) {
        m dbCacheManager;
        if (arrayList == null || (dbCacheManager = getDbCacheManager()) == null) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        dbCacheManager.h(arrayList);
        b.a("FeedCost", "feed data db replace cost : " + (System.currentTimeMillis() - currentTimeMillis));
    }

    public void saveOrUpdate(ArrayList<BusinessFeedData> arrayList) {
        m dbCacheManager;
        if (arrayList == null || (dbCacheManager = getDbCacheManager()) == null) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        dbCacheManager.m(arrayList);
        b.a("FeedCost", "feed data db save cost : " + (System.currentTimeMillis() - currentTimeMillis));
    }

    public void updatePageCache(ArrayList<BusinessFeedData> arrayList) {
        if (arrayList == null || arrayList.size() <= 0) {
            return;
        }
        ConcurrentHashMap<String, BusinessFeedData> concurrentHashMap = new ConcurrentHashMap<>();
        Iterator<BusinessFeedData> it = arrayList.iterator();
        while (it.hasNext()) {
            BusinessFeedData next = it.next();
            if (next != null) {
                putFeedDataToMapByFeedsKey(concurrentHashMap, next);
            }
        }
        setPageCacheMap(concurrentHashMap);
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
            cacheHolder.cache = i.H().y1(BusinessFeedData.class, j3, this.mTableName + "_" + j16);
        }
    }

    public BusinessFeedData querySingle(String str, String[] strArr) {
        ArrayList<BusinessFeedData> query = query(str, strArr, null, 0, 1);
        if (query == null || query.size() <= 0) {
            return null;
        }
        return query.get(0);
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x005e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean updateFeedData(BusinessFeedData businessFeedData, String str) {
        BusinessFeedData businessFeedData2;
        char c16;
        if (businessFeedData != null) {
            CellFeedCommInfo feedCommInfo = businessFeedData.getFeedCommInfo();
            String str2 = feedCommInfo.feedskey;
            if (!TextUtils.isEmpty(str2)) {
                int updateDataInner = updateDataInner(businessFeedData, str);
                List<BusinessFeedData> list = this.mCurrentDatas;
                ConcurrentHashMap<String, BusinessFeedData> concurrentHashMap = this.mCurrentDataMap;
                ConcurrentHashMap<String, BusinessFeedData> concurrentHashMap2 = this.mTempPageCache;
                try {
                    this.mLock.writeLock().lock();
                    if (list == null || list.size() <= 0) {
                        businessFeedData2 = null;
                    } else {
                        businessFeedData2 = concurrentHashMap.get(str2);
                        if (businessFeedData2 != null) {
                            int indexOf = list.indexOf(businessFeedData2);
                            if (indexOf >= 0) {
                                list.remove(businessFeedData2);
                                list.add(indexOf, businessFeedData);
                                c16 = 1;
                            } else {
                                c16 = 0;
                            }
                            concurrentHashMap.put(str2, businessFeedData);
                            if (concurrentHashMap2 != null && concurrentHashMap2.containsKey(str2)) {
                                concurrentHashMap2.put(str2, businessFeedData);
                            }
                            if (businessFeedData2 != null) {
                                updateCurrentDatas(list);
                                setPageCacheMap(concurrentHashMap2);
                            }
                            return updateDataInner <= 0 || c16 > 0;
                        }
                    }
                    c16 = 0;
                    if (businessFeedData2 != null) {
                    }
                    if (updateDataInner <= 0) {
                    }
                } finally {
                    this.mLock.writeLock().unlock();
                }
            }
            b.c(TAG, "updateFeedData failed(feeds key is null , ugckey(encrypted):" + feedCommInfo.ugckey + "| time:" + feedCommInfo.getTime() + "| appId:" + feedCommInfo.appid + "| subId:" + feedCommInfo.subid + ")");
        }
        return false;
    }

    public boolean deleteFeedDataMemOnly(BusinessFeedData businessFeedData) {
        String str;
        BusinessFeedData businessFeedData2;
        if (businessFeedData == null || (businessFeedData2 = this.mCurrentDataMap.get((str = businessFeedData.getFeedCommInfo().feedskey))) == null) {
            return false;
        }
        try {
            this.mLock.writeLock().lock();
            this.mCurrentDatas.remove(businessFeedData2);
            this.mCurrentDataMap.remove(str);
            ConcurrentHashMap<String, BusinessFeedData> concurrentHashMap = this.mTempPageCache;
            if (concurrentHashMap != null) {
                concurrentHashMap.remove(str);
            }
            this.mLock.writeLock().unlock();
            return true;
        } catch (Throwable th5) {
            this.mLock.writeLock().unlock();
            throw th5;
        }
    }

    void putFeedDataToMapByFeedsKey(ConcurrentHashMap<String, BusinessFeedData> concurrentHashMap, BusinessFeedData businessFeedData) {
        if (concurrentHashMap == null || businessFeedData == null) {
            return;
        }
        CellFeedCommInfo feedCommInfo = businessFeedData.getFeedCommInfo();
        String str = feedCommInfo.feedskey;
        if (!TextUtils.isEmpty(str)) {
            concurrentHashMap.put(str, businessFeedData);
            return;
        }
        b.c(TAG, "put feedData to map failed(feeds key is empty , ugckey(encrypted):" + feedCommInfo.ugckey + "| time:" + feedCommInfo.getTime() + "| appId:" + feedCommInfo.appid + "| subId:" + feedCommInfo.subid + ")");
    }

    public ArrayList<BusinessFeedData> query(String str, String[] strArr, String str2, int i3, int i16) {
        m dbCacheManager = getDbCacheManager();
        if (dbCacheManager != null) {
            return (ArrayList) dbCacheManager.f(str, strArr, str2, i3, i16);
        }
        return null;
    }

    ArrayList<BusinessFeedData> getFeeds(int i3, int i16, boolean z16) {
        m dbCacheManager = getDbCacheManager();
        if (dbCacheManager == null) {
            return null;
        }
        ArrayList<BusinessFeedData> arrayList = new ArrayList<>();
        try {
            this.mLock.readLock().lock();
            ConcurrentHashMap<String, BusinessFeedData> concurrentHashMap = this.mCurrentDataMap;
            List<? extends Object> g16 = dbCacheManager.g(null, null, i3, i16);
            int size = g16 == null ? 0 : g16.size();
            for (int i17 = 0; i17 < size; i17++) {
                BusinessFeedData businessFeedData = (BusinessFeedData) g16.get(i17);
                if (businessFeedData == null || TextUtils.isEmpty(businessFeedData.getFeedCommInfo().feedskey)) {
                    if (businessFeedData != null) {
                        b.i(TAG, "error feedskye will be null!!");
                    }
                } else if (!z16 || concurrentHashMap == null || !concurrentHashMap.containsKey(businessFeedData.getFeedCommInfo().feedskey)) {
                    arrayList.add(businessFeedData);
                }
            }
            return arrayList;
        } finally {
            this.mLock.readLock().unlock();
        }
    }

    public boolean deleteFeedData(String str) {
        int i3;
        if (getDbCacheManager() == null) {
            return false;
        }
        ArrayList<BusinessFeedData> query = query(str, null);
        if (query == null || query.size() <= 0) {
            return deleteDataInner(str) > 0;
        }
        int deleteDataInner = deleteDataInner(str);
        List<BusinessFeedData> list = this.mCurrentDatas;
        ConcurrentHashMap<String, BusinessFeedData> concurrentHashMap = this.mCurrentDataMap;
        ConcurrentHashMap<String, BusinessFeedData> concurrentHashMap2 = this.mTempPageCache;
        if (list == null || list.size() <= 0) {
            i3 = 0;
        } else {
            try {
                this.mLock.writeLock().lock();
                Iterator<BusinessFeedData> it = query.iterator();
                i3 = 0;
                while (it.hasNext()) {
                    String str2 = it.next().getFeedCommInfo().feedskey;
                    BusinessFeedData businessFeedData = concurrentHashMap.get(str2);
                    if (businessFeedData != null) {
                        i3++;
                        list.remove(businessFeedData);
                        concurrentHashMap.remove(str2);
                        if (concurrentHashMap2 != null) {
                            concurrentHashMap2.remove(str2);
                        }
                    }
                }
                this.mLock.writeLock().unlock();
                updateCurrentDatas(list);
                setPageCacheMap(concurrentHashMap2);
            } catch (Throwable th5) {
                this.mLock.writeLock().unlock();
                throw th5;
            }
        }
        return deleteDataInner > 0 || i3 > 0;
    }
}
