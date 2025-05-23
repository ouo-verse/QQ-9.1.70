package com.qzone.module.feedcomponent.manage;

import NS_MOBILE_FEEDS.SimpleComment;
import NS_MOBILE_FEEDS.cell_comm;
import NS_MOBILE_FEEDS.cell_comment;
import NS_MOBILE_FEEDS.s_commment;
import NS_MOBILE_FEEDS.s_reply;
import NS_MOBILE_FEEDS.single_feed;
import PUSH_UPDATE_FEEDS.CommentReplyInfo;
import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import com.qzone.adapter.feedcomponent.i;
import com.qzone.proxy.feedcomponent.FeedGlobalEnv;
import com.qzone.proxy.feedcomponent.b;
import com.qzone.proxy.feedcomponent.manager.e;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.model.CellBottomRecomm;
import com.qzone.proxy.feedcomponent.model.CellCommentInfo;
import com.qzone.proxy.feedcomponent.model.CellFeedCommInfo;
import com.qzone.proxy.feedcomponent.model.CellFollowGuide;
import com.qzone.proxy.feedcomponent.model.CellForwardListInfo;
import com.qzone.proxy.feedcomponent.model.CellLikeInfo;
import com.qzone.proxy.feedcomponent.model.CellLocalInfo;
import com.qzone.proxy.feedcomponent.model.Comment;
import com.qzone.proxy.feedcomponent.model.Reply;
import com.qzone.proxy.feedcomponent.model.l;
import com.qzone.proxy.feedcomponent.service.FeedIncrementalUpdateService;
import com.qzone.reborn.feedx.util.aa;
import cooperation.qzone.util.WiFiDash;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: P */
/* loaded from: classes39.dex */
public class FeedDataManager implements e {
    private static final int PRE_DECODE_IMAGE_TOTAL_SIZE_10M = 10485760;
    private static final int PRE_DECODE_IMAGE_TOTAL_SIZE_15M = 15728640;
    private static final int PRE_DECODE_IMAGE_TOTAL_SIZE_1M = 1048576;
    private static final int PRE_DECODE_IMAGE_TOTAL_SIZE_2M = 2097152;
    private static final int PRE_DECODE_IMAGE_TOTAL_SIZE_4M = 4194304;
    static final int PRE_DECODE_OFFSET = 10;
    private static final String TAG = "FeedDataManager";
    private static float sTrimRation = 1.0f;
    volatile int mCurrentDataSize;
    volatile FakeDataCache mFakeDataCache;
    FeedDataCache mFeedDataCache;
    int mLikeFeedSubType;
    int mLikeFeedType;
    boolean mNeedFakeCache;
    String mTableName;
    List<BusinessFeedData> mCurrentUIDatas = Collections.synchronizedList(new ArrayList());
    List<BusinessFeedData> mFakeDataSpecial = Collections.synchronizedList(new ArrayList());
    int preLoadBigImageTotalMemSize = -1;
    Comparator<BusinessFeedData> mFeedComparator = new Comparator<BusinessFeedData>() { // from class: com.qzone.module.feedcomponent.manage.FeedDataManager.1
        @Override // java.util.Comparator
        public int compare(BusinessFeedData businessFeedData, BusinessFeedData businessFeedData2) {
            int i3 = businessFeedData.getLocalInfo().dbPriority;
            int i16 = businessFeedData2.getLocalInfo().dbPriority;
            if (i3 != i16) {
                return i3 > i16 ? -1 : 1;
            }
            long time = businessFeedData.getFeedCommInfo().getTime();
            long time2 = businessFeedData2.getFeedCommInfo().getTime();
            if (time > time2) {
                return -1;
            }
            return time == time2 ? 0 : 1;
        }
    };
    private final List<BusinessFeedData> mOutCacheData = new ArrayList();

    public FeedDataManager(String str, boolean z16, int i3, int i16) {
        this.mTableName = str;
        this.mNeedFakeCache = z16;
        this.mLikeFeedType = i3;
        this.mLikeFeedSubType = i16;
        FeedDataCache feedDataCache = new FeedDataCache(str);
        this.mFeedDataCache = feedDataCache;
        int i17 = this.mLikeFeedType;
        if (i17 == 23 || i17 == 24) {
            feedDataCache.setSortOrder(" '' ");
        }
    }

    private boolean canSaveFakeFeed(BusinessFeedData businessFeedData) {
        boolean z16 = false;
        if (this.mFeedDataCache != null && businessFeedData != null) {
            if (this.mFeedDataCache.querySingle("client_key='" + businessFeedData.getFeedCommInfo().ugckey + "'") != null) {
                z16 = true;
            }
        }
        return !z16;
    }

    private void updateFeedInfo(BusinessFeedData businessFeedData, Map<Integer, String> map) {
        try {
            String str = businessFeedData.feedInfo;
            for (Integer num : map.keySet()) {
                String str2 = num + ContainerUtils.KEY_VALUE_DELIMITER + map.get(num);
                Matcher matcher = Pattern.compile("(?<=&)" + num + "=.*?(?=&|#)").matcher(str);
                if (matcher.find()) {
                    str = matcher.replaceFirst(str2);
                } else {
                    int lastIndexOf = str.lastIndexOf("#");
                    if (lastIndexOf > 0) {
                        str = str.substring(0, lastIndexOf - 1) + ContainerUtils.FIELD_DELIMITER + str2 + "#";
                    }
                }
            }
            businessFeedData.feedInfo = str;
        } catch (Exception unused) {
        }
    }

    public void clearCache() {
        clearMemorCache();
        this.mFeedDataCache.clearCache();
        FakeDataCache fakeDataCache = getFakeDataCache();
        if (fakeDataCache != null) {
            fakeDataCache.clearCache();
        }
    }

    public void clearDBCache() {
        this.mFeedDataCache.clearDBCache();
    }

    public void clearMemorCache() {
        clearMemorCache(true);
    }

    public void clearPageCache() {
        this.mFeedDataCache.clearPageCache();
    }

    public void clearUIDataCache() {
        synchronized (this) {
            this.mOutCacheData.clear();
        }
    }

    public void close() {
        clearMemorCache();
        this.mFeedDataCache.close();
        FakeDataCache fakeDataCache = getFakeDataCache();
        if (fakeDataCache != null) {
            fakeDataCache.close();
        }
    }

    public void deleteByFeedsKey(String str) {
        deleteByFeedsKey(str, false);
    }

    public void deleteFakeFeedByClientKey(ArrayList<String> arrayList) {
        FakeDataCache fakeDataCache = getFakeDataCache();
        ArrayList<BusinessFeedData> deleteFakeFeedByClientKey = fakeDataCache != null ? fakeDataCache.deleteFakeFeedByClientKey(arrayList) : null;
        if (this.mCurrentUIDatas == null) {
            return;
        }
        if (deleteFakeFeedByClientKey != null && deleteFakeFeedByClientKey.size() > 0) {
            synchronized (this) {
                Iterator<BusinessFeedData> it = deleteFakeFeedByClientKey.iterator();
                while (it.hasNext()) {
                    this.mCurrentUIDatas.remove(it.next());
                }
            }
        }
        this.mCurrentDataSize = this.mCurrentUIDatas.size();
    }

    public void deleteFakeFeedByUgcKey(ArrayList<String> arrayList) {
        FakeDataCache fakeDataCache = getFakeDataCache();
        ArrayList<BusinessFeedData> deleteFakeFeedByUgcKey = fakeDataCache != null ? fakeDataCache.deleteFakeFeedByUgcKey(arrayList) : null;
        if (this.mCurrentUIDatas == null) {
            return;
        }
        if (deleteFakeFeedByUgcKey != null && deleteFakeFeedByUgcKey.size() > 0) {
            synchronized (this) {
                Iterator<BusinessFeedData> it = deleteFakeFeedByUgcKey.iterator();
                while (it.hasNext()) {
                    this.mCurrentUIDatas.remove(it.next());
                }
            }
        }
        this.mCurrentDataSize = this.mCurrentUIDatas.size();
    }

    public boolean deleteFeedData(String str) {
        return deleteFeedData(str, null);
    }

    @Override // com.qzone.proxy.feedcomponent.manager.e
    public boolean deleteFeedDataDbOnly(String str, String[] strArr) {
        if (this.mFeedDataCache.deleteFeedDataDbOnly(str, strArr)) {
            return true;
        }
        return getFakeDataCache() != null && getFakeDataCache().deleteFeedDataDbOnly(str, strArr);
    }

    public boolean deleteFeedDataMemOnly(BusinessFeedData businessFeedData) {
        if (!this.mFeedDataCache.deleteFeedDataMemOnly(businessFeedData) && (getFakeDataCache() == null || !getFakeDataCache().deleteFeedDataMemOnly(businessFeedData))) {
            return false;
        }
        reloadCacheDatas(false);
        return true;
    }

    public void deleteInvalidFakeFeed() {
        FakeDataCache fakeDataCache = getFakeDataCache();
        if (fakeDataCache != null) {
            fakeDataCache.deleteInvalidFakeFeed();
        }
        deleteInvalidFakeSpecialFeed();
    }

    public void deleteInvalidFakeSpecialFeed() {
        List<BusinessFeedData> list = this.mFakeDataSpecial;
        if (list == null || list.size() < 0) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (BusinessFeedData businessFeedData : this.mFakeDataSpecial) {
            if (businessFeedData != null && businessFeedData.isFakeRedPocketFeed() && System.currentTimeMillis() - businessFeedData.getFeedCommInfo().getTime() > 60000) {
                arrayList.add(businessFeedData);
            }
        }
        if (arrayList.size() > 0) {
            this.mCurrentUIDatas.removeAll(arrayList);
            this.mFakeDataSpecial.removeAll(arrayList);
            this.mCurrentDataSize = this.mCurrentUIDatas.size();
        }
    }

    public void deleteNotSortFeeds() {
        deleteFeedData("not_time_sort>'0'");
    }

    public void deleteOverflowFeeds() {
        this.mFeedDataCache.deleteOverflowFeeds();
    }

    public List<BusinessFeedData> getAllFakeFeeds() {
        FakeDataCache fakeDataCache = getFakeDataCache();
        if (fakeDataCache != null) {
            return fakeDataCache.getFakeFeeds();
        }
        return null;
    }

    public int getCacheSize() {
        return this.mFeedDataCache.getCacheSize();
    }

    public String getCommentListInfo(List<Comment> list) {
        if (list == null) {
            return WiFiDash.NOT_AVALIBLE;
        }
        StringBuffer stringBuffer = new StringBuffer(100);
        stringBuffer.append("total_num:");
        stringBuffer.append(list.size());
        for (Comment comment : list) {
            stringBuffer.append("[");
            stringBuffer.append(comment.commentid);
            List<Reply> list2 = comment.replies;
            if (list2 != null && list2.size() > 0) {
                stringBuffer.append("(");
                Iterator<Reply> it = comment.replies.iterator();
                while (it.hasNext()) {
                    stringBuffer.append(it.next().replyId);
                    stringBuffer.append(",");
                }
                stringBuffer.append(")");
            }
            stringBuffer.append("]");
        }
        return stringBuffer.toString();
    }

    public int getCurrentFeedsCount() {
        return this.mCurrentDataSize;
    }

    @Override // com.qzone.proxy.feedcomponent.manager.e
    public synchronized List<BusinessFeedData> getCurrentUIDatas() {
        ArrayList arrayList;
        CellFollowGuide cellFollowGuide;
        List<BusinessFeedData> unreadFollowFeeds;
        boolean z16;
        arrayList = new ArrayList();
        List<BusinessFeedData> list = this.mCurrentUIDatas;
        if (list != null) {
            arrayList.addAll(list);
            int i3 = 0;
            while (true) {
                if (i3 >= this.mCurrentUIDatas.size()) {
                    break;
                }
                BusinessFeedData businessFeedData = this.mCurrentUIDatas.get(i3);
                if (businessFeedData == null || (cellFollowGuide = businessFeedData.cellFollowGuide) == null) {
                    i3++;
                } else if (cellFollowGuide.getStatus() == 2 && (unreadFollowFeeds = businessFeedData.cellFollowGuide.getUnreadFollowFeeds()) != null && unreadFollowFeeds.size() > 0) {
                    ArrayList arrayList2 = new ArrayList(this.mCurrentUIDatas);
                    for (int size = unreadFollowFeeds.size() - 1; size >= 0; size--) {
                        BusinessFeedData businessFeedData2 = unreadFollowFeeds.get(size);
                        Iterator it = arrayList2.iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                z16 = false;
                                break;
                            }
                            BusinessFeedData businessFeedData3 = (BusinessFeedData) it.next();
                            if (businessFeedData3.getFeedCommInfo().feedskey != null && businessFeedData3.getFeedCommInfo().feedskey.equals(businessFeedData2.getFeedCommInfo().feedskey)) {
                                z16 = true;
                                break;
                            }
                        }
                        if (z16) {
                            unreadFollowFeeds.remove(size);
                        }
                    }
                    arrayList.addAll(i3 + 1, unreadFollowFeeds);
                }
            }
        }
        arrayList.addAll(this.mOutCacheData);
        return arrayList;
    }

    FakeDataCache getFakeDataCache() {
        if (this.mNeedFakeCache && this.mFakeDataCache == null) {
            this.mFakeDataCache = new FakeDataCache(this.mTableName);
        }
        return this.mFakeDataCache;
    }

    public BusinessFeedData getFakeFeedByClientKey(String str) {
        FakeDataCache fakeDataCache = getFakeDataCache();
        if (fakeDataCache != null) {
            return fakeDataCache.getFakeFeedByClientKey(str);
        }
        return null;
    }

    @Override // com.qzone.proxy.feedcomponent.manager.e
    public BusinessFeedData getFeedDataByFeedsKey(String str) {
        return getFeedDataByFeedsKey(str, false);
    }

    public ArrayList<BusinessFeedData> getFirstPageDatas(int i3) {
        return this.mFeedDataCache.getFirstPageDatas(i3);
    }

    public ArrayList<BusinessFeedData> getNextPageDatas(int i3) {
        return this.mFeedDataCache.getNextPageDatas(i3);
    }

    @Override // com.qzone.proxy.feedcomponent.manager.e
    public List<BusinessFeedData> increaseUpdate(HashMap<String, FeedIncrementalUpdateService.a> hashMap, List<BusinessFeedData> list) {
        if (hashMap == null || hashMap.size() <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (BusinessFeedData businessFeedData : new ArrayList(this.mCurrentUIDatas)) {
            if (hashMap.containsKey(businessFeedData.getFeedCommInfo().ugckey)) {
                FeedIncrementalUpdateService.a aVar = hashMap.get(businessFeedData.getFeedCommInfo().ugckey);
                boolean mergeCommentList = mergeCommentList(businessFeedData, aVar);
                mergeFeedData(businessFeedData, new l(aVar.f50455b));
                businessFeedData.feeds_update_time = aVar.f50459f;
                Map<Integer, String> map = aVar.f50457d;
                if (map != null && map.size() > 0) {
                    updateFeedInfo(businessFeedData, aVar.f50457d);
                }
                updateFeedData(businessFeedData);
                arrayList.add(businessFeedData);
                if (mergeCommentList && list != null) {
                    list.add(businessFeedData);
                }
            }
        }
        return arrayList;
    }

    public void init(long j3, long j16) {
        this.mFeedDataCache.init(j3, j16);
        FakeDataCache fakeDataCache = getFakeDataCache();
        if (fakeDataCache != null) {
            fakeDataCache.init(j3, j16);
        }
    }

    public boolean isAllDBDataLoaded() {
        return this.mFeedDataCache.isAllDBDataLoaded();
    }

    public List<BusinessFeedData> loadMoreUp(List<String> list) {
        List<BusinessFeedData> load = this.mFeedDataCache.load(list, true);
        if (load != null && load.size() > 0) {
            synchronized (this) {
                for (int i3 = 0; i3 < load.size(); i3++) {
                    this.mCurrentUIDatas.add(0, load.get(i3));
                }
            }
            this.mCurrentDataSize = this.mCurrentUIDatas.size();
        }
        return getCurrentUIDatas();
    }

    public void preDownloadFeedsPernalizeDiamondImage(int i3, int i16) {
        Context context = FeedGlobalEnv.getContext();
        if (i16 > -1 && i16 < this.mCurrentUIDatas.size() && i16 < this.mCurrentUIDatas.size() - 1) {
            int i17 = i16 + 10;
            if (i17 > this.mCurrentUIDatas.size()) {
                i17 = this.mCurrentUIDatas.size();
            }
            while (i16 < i17 && i16 < this.mCurrentUIDatas.size()) {
                BusinessFeedData businessFeedData = this.mCurrentUIDatas.get(i16);
                if (businessFeedData != null) {
                    i.H().K1(context, businessFeedData, true);
                }
                i16++;
            }
        }
        if (i3 <= -1 || i3 >= this.mCurrentUIDatas.size() || i3 <= 0) {
            return;
        }
        int i18 = i3 - 10;
        if (i18 < 0) {
            i18 = 0;
        }
        while (i18 < i3 && i18 < this.mCurrentUIDatas.size()) {
            BusinessFeedData businessFeedData2 = this.mCurrentUIDatas.get(i18);
            if (businessFeedData2 != null) {
                i.H().K1(context, businessFeedData2, true);
            }
            i18++;
        }
    }

    public void preDownloadFeedsPernalizePassivePraise(int i3, int i16) {
        Context context = FeedGlobalEnv.getContext();
        if (i16 > -1 && i16 < this.mCurrentUIDatas.size() && i16 < this.mCurrentUIDatas.size() - 1) {
            int i17 = i16 + 10;
            if (i17 > this.mCurrentUIDatas.size()) {
                i17 = this.mCurrentUIDatas.size();
            }
            while (i16 < i17 && i16 < this.mCurrentUIDatas.size()) {
                BusinessFeedData businessFeedData = this.mCurrentUIDatas.get(i16);
                if (businessFeedData != null) {
                    i.H().L1(context, businessFeedData, true);
                }
                i16++;
            }
        }
        if (i3 <= -1 || i3 >= this.mCurrentUIDatas.size() || i3 <= 0) {
            return;
        }
        int i18 = i3 - 10;
        if (i18 < 0) {
            i18 = 0;
        }
        while (i18 < i3 && i18 < this.mCurrentUIDatas.size()) {
            BusinessFeedData businessFeedData2 = this.mCurrentUIDatas.get(i18);
            if (businessFeedData2 != null) {
                i.H().L1(context, businessFeedData2, true);
            }
            i18++;
        }
    }

    public void preloadDownloadFeedsCustomTrack(int i3, int i16) {
        try {
            Context context = FeedGlobalEnv.getContext();
            ArrayList arrayList = new ArrayList(this.mCurrentUIDatas);
            int size = arrayList.size();
            if (i16 <= -1 || i16 >= size || i3 <= -1 || i3 >= size) {
                return;
            }
            int i17 = i16 + 10;
            if (i17 > size) {
                i17 = size;
            }
            while (i3 < i17 && i3 < size) {
                BusinessFeedData businessFeedData = (BusinessFeedData) arrayList.get(i3);
                if (businessFeedData != null) {
                    i.H().N1(context, businessFeedData, true);
                }
                i3++;
            }
        } catch (Exception e16) {
            b.c(TAG, "preloadDownloadFeedsCustomTrack" + e16.toString());
        }
    }

    @Override // com.qzone.proxy.feedcomponent.manager.e
    public BusinessFeedData query(String str, String[] strArr) {
        FeedDataCache feedDataCache = this.mFeedDataCache;
        BusinessFeedData querySingle = feedDataCache != null ? feedDataCache.querySingle(str, strArr) : null;
        FakeDataCache fakeDataCache = getFakeDataCache();
        return (querySingle != null || fakeDataCache == null) ? querySingle : fakeDataCache.querySingle(str, strArr);
    }

    @Override // com.qzone.proxy.feedcomponent.manager.e
    public BusinessFeedData queryWithMem(String str, String str2, String str3) {
        b.e(TAG, "queryWithMem: " + str2 + " " + str3);
        List<BusinessFeedData> currentUIDatas = getCurrentUIDatas();
        if (currentUIDatas != null && !TextUtils.isEmpty(str2)) {
            for (BusinessFeedData businessFeedData : currentUIDatas) {
                if (businessFeedData != null) {
                    if (businessFeedData.getRecBusinessFeedDatas() != null && businessFeedData.getRecBusinessFeedDatas().size() > 0 && !businessFeedData.isSingleAdvContainerFeed()) {
                        Iterator<BusinessFeedData> it = businessFeedData.getRecBusinessFeedDatas().iterator();
                        while (it.hasNext()) {
                            BusinessFeedData next = it.next();
                            if (next != null && str2.equals(next.getFeedCommInfo().ugckey) && (str3 == null || str3.equals(next.getFeedCommInfo().feedskey))) {
                                return next;
                            }
                        }
                    } else if (str2.equals(businessFeedData.getFeedCommInfo().ugckey) && (str3 == null || str3.equals(businessFeedData.getFeedCommInfo().feedskey))) {
                        return businessFeedData;
                    }
                }
            }
        }
        if (currentUIDatas != null && !TextUtils.isEmpty(str3)) {
            for (BusinessFeedData businessFeedData2 : currentUIDatas) {
                if (businessFeedData2 != null) {
                    if (businessFeedData2.getRecBusinessFeedDatas() != null && businessFeedData2.getRecBusinessFeedDatas().size() > 0 && !businessFeedData2.isSingleAdvContainerFeed()) {
                        Iterator<BusinessFeedData> it5 = businessFeedData2.getRecBusinessFeedDatas().iterator();
                        while (it5.hasNext()) {
                            BusinessFeedData next2 = it5.next();
                            if (next2 != null && str3.equals(next2.getFeedCommInfo().feedskey)) {
                                return next2;
                            }
                        }
                    } else if (str3.equals(businessFeedData2.getFeedCommInfo().feedskey)) {
                        return businessFeedData2;
                    }
                }
            }
        }
        String[] strArr = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        if (str2 != null) {
            arrayList.add(str2);
        }
        if (str3 != null) {
            arrayList.add(str3);
        }
        if (arrayList.size() != 0) {
            strArr = new String[arrayList.size()];
            arrayList.toArray(strArr);
        }
        return query(str, strArr);
    }

    public void reloadCacheDatas(boolean z16) {
        FakeDataCache fakeDataCache = getFakeDataCache();
        updateCurrentDatas(this.mFeedDataCache.getCurrentUIDatas(), fakeDataCache != null ? fakeDataCache.getFakeFeedsCache() : null, z16);
    }

    public void replaceAndSave(ArrayList<BusinessFeedData> arrayList) {
        this.mFeedDataCache.replaceAndSave(arrayList);
    }

    public List<BusinessFeedData> restoreLastUIDatas(String str, int i3) {
        List<BusinessFeedData> restoreLastUIDatas = this.mFeedDataCache.restoreLastUIDatas(str, i3);
        FakeDataCache fakeDataCache = getFakeDataCache();
        updateCurrentDatas(restoreLastUIDatas, fakeDataCache != null ? fakeDataCache.getFakeFeeds() : null, true);
        return getCurrentUIDatas();
    }

    @Override // com.qzone.proxy.feedcomponent.manager.e
    public boolean saveFakeFeed(BusinessFeedData businessFeedData) {
        if (!canSaveFakeFeed(businessFeedData)) {
            return false;
        }
        FakeDataCache fakeDataCache = getFakeDataCache();
        if (!businessFeedData.needSaveToDb()) {
            this.mFakeDataSpecial.add(businessFeedData);
        }
        if (fakeDataCache == null || !fakeDataCache.saveFeedData(businessFeedData)) {
            return false;
        }
        reloadCacheDatas(false);
        return true;
    }

    public void saveFeedDatas(ArrayList<BusinessFeedData> arrayList) {
        this.mFeedDataCache.saveOrUpdate(arrayList);
    }

    public void saveOrUpdateServerResponse(ArrayList<BusinessFeedData> arrayList, ArrayList<BusinessFeedData> arrayList2) {
        this.mFeedDataCache.saveOrUpdate(arrayList2);
        this.mFeedDataCache.updatePageCache(arrayList);
    }

    synchronized void updateCurrentDatas(List<BusinessFeedData> list, List<BusinessFeedData> list2, boolean z16) {
        List<BusinessFeedData> synchronizedList = Collections.synchronizedList(new ArrayList());
        if (list2 != null) {
            synchronizedList.addAll(list2);
        }
        List<BusinessFeedData> list3 = this.mFakeDataSpecial;
        if (list3 != null) {
            synchronizedList.addAll(list3);
        }
        if (!z16) {
            Collections.sort(synchronizedList, this.mFeedComparator);
        }
        if (list != null) {
            synchronizedList.addAll(list);
            if (list.size() > 0) {
                BusinessFeedData businessFeedData = list.get(0);
                if (businessFeedData.isCardFriendsRecommendContainerFeed() || businessFeedData.isCardSpecialFollowMoreRecommendContainerFeed() || businessFeedData.isCardSchoolRecommendContainerFeed() || businessFeedData.isSpecialCareInContainerFeed() || businessFeedData.isFriendBirthdayContainerFeed() || businessFeedData.isFriendAnniversaryFeed() || businessFeedData.isRecomEventTagFeed() || businessFeedData.isRecomMyEventTagContainerFeed() || businessFeedData.getFeedCommInfo().isTopFeed()) {
                    synchronizedList.remove(businessFeedData);
                    synchronizedList.add(0, businessFeedData);
                }
            }
        }
        if (z16 && list2 != null && list2.size() > 0) {
            Collections.sort(synchronizedList, this.mFeedComparator);
        }
        this.mCurrentUIDatas = synchronizedList;
        this.mCurrentDataSize = synchronizedList.size();
    }

    public void clearCache2Refresh() {
        clearMemorCache(false);
        this.mFeedDataCache.clearCache();
    }

    public void clearMemorCache(boolean z16) {
        synchronized (this) {
            List<BusinessFeedData> list = this.mCurrentUIDatas;
            if (list != null) {
                list.clear();
            }
        }
        this.mFeedDataCache.clearMemoryCache();
        FakeDataCache fakeDataCache = getFakeDataCache();
        if (z16 && fakeDataCache != null) {
            fakeDataCache.clearMemoryCache();
        }
        this.mCurrentDataSize = 0;
    }

    @Override // com.qzone.proxy.feedcomponent.manager.e
    public void deleteByFeedsKey(String str, boolean z16) {
        List<BusinessFeedData> currentUIDatas;
        CellFollowGuide cellFollowGuide;
        boolean deleteByFeedsKey = this.mFeedDataCache.deleteByFeedsKey(str);
        if (!deleteByFeedsKey && (currentUIDatas = getCurrentUIDatas()) != null && !TextUtils.isEmpty(str)) {
            for (BusinessFeedData businessFeedData : currentUIDatas) {
                if (businessFeedData != null && (cellFollowGuide = businessFeedData.cellFollowGuide) != null && cellFollowGuide.getUnreadFollowFeeds() != null) {
                    Iterator<BusinessFeedData> it = businessFeedData.cellFollowGuide.getUnreadFollowFeeds().iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        BusinessFeedData next = it.next();
                        if (next != null && str.equals(next.getFeedCommInfo().feedskey)) {
                            businessFeedData.cellFollowGuide.getUnreadFollowFeeds().remove(next);
                            deleteByFeedsKey = true;
                            break;
                        }
                    }
                }
            }
        }
        if (deleteByFeedsKey && z16) {
            reloadCacheDatas(false);
        }
    }

    @Override // com.qzone.proxy.feedcomponent.manager.e
    public boolean deleteFeedData(String str, String[] strArr) {
        if (this.mFeedDataCache.deleteFeedData(str, strArr)) {
            reloadCacheDatas(false);
            return true;
        }
        if (getFakeDataCache() == null || !getFakeDataCache().deleteFeedData(str, strArr)) {
            return false;
        }
        reloadCacheDatas(false);
        return true;
    }

    public BusinessFeedData getFeedDataByFeedsKey(String str, boolean z16) {
        BusinessFeedData feedDataByFeedsKey = this.mFeedDataCache.getFeedDataByFeedsKey(str);
        if (feedDataByFeedsKey != null) {
            return feedDataByFeedsKey;
        }
        List<BusinessFeedData> currentUIDatas = getCurrentUIDatas();
        if (currentUIDatas == null || TextUtils.isEmpty(str)) {
            return null;
        }
        for (BusinessFeedData businessFeedData : currentUIDatas) {
            if (businessFeedData != null) {
                if (businessFeedData.getRecBusinessFeedDatas() != null && businessFeedData.getRecBusinessFeedDatas().size() > 0 && !businessFeedData.isSingleAdvContainerFeed()) {
                    Iterator<BusinessFeedData> it = businessFeedData.getRecBusinessFeedDatas().iterator();
                    while (it.hasNext()) {
                        BusinessFeedData next = it.next();
                        if (next != null && str.equals(next.getFeedCommInfo().feedskey)) {
                            return next;
                        }
                    }
                } else {
                    CellFollowGuide cellFollowGuide = businessFeedData.cellFollowGuide;
                    if (cellFollowGuide != null && cellFollowGuide.getUnreadFollowFeeds() != null) {
                        for (BusinessFeedData businessFeedData2 : businessFeedData.cellFollowGuide.getUnreadFollowFeeds()) {
                            if (businessFeedData2 != null && str.equals(businessFeedData2.getFeedCommInfo().feedskey)) {
                                return businessFeedData2;
                            }
                        }
                    } else if (str.equals(businessFeedData.getFeedCommInfo().feedskey)) {
                        return businessFeedData;
                    }
                }
            }
        }
        return null;
    }

    public void deleteFakeDataSpecialFeed(ArrayList<String> arrayList) {
        if (arrayList == null || arrayList.size() <= 0) {
            return;
        }
        ArrayList arrayList2 = new ArrayList();
        for (BusinessFeedData businessFeedData : this.mFakeDataSpecial) {
            if (businessFeedData != null && businessFeedData.isFakeRedPocketFeed() && arrayList.contains(businessFeedData.getCellLuckyMoney().luckyMoneyPayId)) {
                arrayList2.add(businessFeedData);
            }
        }
        if (arrayList2.size() > 0) {
            this.mCurrentUIDatas.removeAll(arrayList2);
            this.mFakeDataSpecial.removeAll(arrayList2);
            this.mCurrentDataSize = this.mCurrentUIDatas.size();
        }
    }

    public List<BusinessFeedData> loadMore(List<String> list, boolean z16) {
        if (z16) {
            updateCurrentDatas(this.mFeedDataCache.loadMore(list), getAllFakeFeeds(), false);
        } else {
            List<BusinessFeedData> load = this.mFeedDataCache.load(list);
            if (load != null && load.size() > 0) {
                synchronized (this) {
                    for (BusinessFeedData businessFeedData : load) {
                        if (businessFeedData != null) {
                            this.mCurrentUIDatas.add(businessFeedData);
                        }
                    }
                }
                this.mCurrentDataSize = this.mCurrentUIDatas.size();
            }
        }
        return getCurrentUIDatas();
    }

    public void addUIDataCache(Collection<BusinessFeedData> collection) {
        if (collection == null) {
            return;
        }
        synchronized (this) {
            this.mOutCacheData.addAll(collection);
        }
    }

    private BusinessFeedData queryMem(String str) {
        if (str == null) {
            return null;
        }
        for (BusinessFeedData businessFeedData : getCurrentUIDatas()) {
            if (str.equals(businessFeedData.getFeedCommInfo().ugckey)) {
                return businessFeedData;
            }
        }
        return null;
    }

    public void clearCache(long j3) {
        init(j3, j3);
        clearCache();
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x00aa  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00cc A[ORIG_RETURN, RETURN] */
    @Override // com.qzone.proxy.feedcomponent.manager.e
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean updateFeedData(BusinessFeedData businessFeedData) {
        boolean z16;
        CellLocalInfo cellLocalInfo;
        boolean z17 = true;
        if (businessFeedData != null) {
            BusinessFeedData businessFeedData2 = businessFeedData.parentFeedData;
            if (businessFeedData2 != null) {
                businessFeedData = businessFeedData2;
            }
            if (businessFeedData.getLocalInfo().fakeType == 2) {
                if (this.mFeedDataCache != null) {
                    z16 = this.mFeedDataCache.updateFeedData(businessFeedData, "feed_key='" + businessFeedData.getFeedCommInfo().feedskey + "'");
                }
            } else if (canSaveFakeFeed(businessFeedData)) {
                FakeDataCache fakeDataCache = getFakeDataCache();
                if (fakeDataCache != null) {
                    BusinessFeedData fakeFeedByClientKey = fakeDataCache.getFakeFeedByClientKey(businessFeedData.getFeedCommInfo().clientkey);
                    if (fakeFeedByClientKey != null && fakeFeedByClientKey.getCellBottomRecomm() != null && fakeFeedByClientKey.getCellBottomRecomm().anonymity == CellBottomRecomm.TYPE_EVENT_TAG && businessFeedData.getCellBottomRecomm() == null) {
                        businessFeedData.setCellBottomRecomm(fakeFeedByClientKey.getCellBottomRecomm());
                    }
                    if (fakeFeedByClientKey != null && (cellLocalInfo = fakeFeedByClientKey.cellLocalInfo) != null && cellLocalInfo.showBottomContainer == 1) {
                        CellLocalInfo cellLocalInfo2 = businessFeedData.cellLocalInfo;
                        if (cellLocalInfo2.showBottomContainer != 2) {
                            cellLocalInfo2.showBottomContainer = 1;
                        }
                    }
                }
                if (fakeDataCache != null) {
                    z16 = fakeDataCache.updateFeedData(businessFeedData, "client_key='" + businessFeedData.getFeedCommInfo().clientkey + "'");
                }
            }
            if (z16) {
                reloadCacheDatas(false);
            }
            if (!z16) {
                return z16;
            }
            synchronized (this) {
                Iterator<BusinessFeedData> it = this.mOutCacheData.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        z17 = z16;
                        break;
                    }
                    if (it.next() == businessFeedData) {
                        break;
                    }
                }
            }
            return z17;
        }
        z16 = false;
        if (z16) {
        }
        if (!z16) {
        }
    }

    private boolean mergeCommentList(BusinessFeedData businessFeedData, FeedIncrementalUpdateService.a aVar) {
        List<CommentReplyInfo> list;
        boolean z16;
        if (businessFeedData == null || aVar == null || (list = aVar.f50458e) == null || list.size() <= 0) {
            return false;
        }
        while (true) {
            for (CommentReplyInfo commentReplyInfo : aVar.f50458e) {
                CellCommentInfo commentInfo = businessFeedData.getCommentInfo();
                b.e("FeedUpdate", "mergeCommentList ugcKey:" + businessFeedData.getFeedCommInfo().ugckey + " localSize:" + commentInfo.commentNum + " newSize:" + commentReplyInfo.total_num);
                int i3 = commentReplyInfo.total_num;
                if (i3 > 0) {
                    commentInfo.commentNum = i3;
                }
                if (commentInfo.realCount > 0) {
                    commentInfo.realCount = commentReplyInfo.real_num;
                }
                s_commment s_commmentVar = commentReplyInfo.cur_comment_reply;
                if (s_commmentVar != null) {
                    String str = null;
                    try {
                        ArrayList<SimpleComment> arrayList = commentReplyInfo.all_commont_list;
                        if (arrayList != null) {
                            Iterator<SimpleComment> it = arrayList.iterator();
                            SimpleComment simpleComment = null;
                            while (it.hasNext()) {
                                SimpleComment next = it.next();
                                if (s_commmentVar.commentid.equals(String.valueOf(next.f24981id)) && simpleComment != null) {
                                    str = String.valueOf(simpleComment.f24981id);
                                }
                                simpleComment = next;
                            }
                        }
                    } catch (Exception unused) {
                    }
                    commentInfo.mergeComment(s_commmentVar, str);
                    commentInfo.preCalculate();
                }
                b.e("FeedUpdate", "mergeCommentList result from push. ugcKey:" + businessFeedData.getFeedCommInfo().ugckey + " localSize:" + businessFeedData.getCommentInfo().commentNum + " content:" + getCommentListInfo(commentInfo.commments));
                z16 = compareCommentInfo(commentInfo, commentReplyInfo.all_commont_list) != 0;
            }
            return z16;
        }
    }

    private void mergeFeedData(BusinessFeedData businessFeedData, l lVar) {
        if (businessFeedData == null || lVar == null) {
            return;
        }
        CellLikeInfo create = CellLikeInfo.create(lVar);
        if (create != null) {
            businessFeedData.cellLikeInfo = create;
        }
        CellForwardListInfo create2 = CellForwardListInfo.create(lVar);
        if (create2 != null) {
            businessFeedData.cellForwardInfo = create2;
            create2.calculateDisplayStr(businessFeedData.getFeedCommInfo().feedskey, false);
        }
    }

    private int compareCommentInfo(CellCommentInfo cellCommentInfo, ArrayList<SimpleComment> arrayList) {
        ArrayList<Comment> arrayList2;
        if (arrayList == null) {
            return 0;
        }
        if (cellCommentInfo != null) {
            ArrayList<Comment> arrayList3 = cellCommentInfo.commments;
        }
        int size = (cellCommentInfo == null || (arrayList2 = cellCommentInfo.commments) == null) ? 0 : arrayList2.size();
        if (size != 0 && size == arrayList.size()) {
            for (int i3 = 0; i3 < cellCommentInfo.commments.size(); i3++) {
                Comment comment = cellCommentInfo.commments.get(i3);
                SimpleComment simpleComment = arrayList.get(i3);
                if (comment == null || !TextUtils.equals(comment.commentid, String.valueOf(simpleComment.f24981id))) {
                    return -1;
                }
                List<Reply> list = comment.replies;
                ArrayList<Long> arrayList4 = simpleComment.reply_ids;
                int size2 = list != null ? list.size() : 0;
                int size3 = arrayList4 != null ? arrayList4.size() : 0;
                if (size2 == 0 || size3 == 0) {
                    if (size2 == size3) {
                        return 0;
                    }
                    return size2 - size3;
                }
                if (size2 != size3) {
                    return size2 - size3;
                }
                for (int i16 = 0; i16 < list.size(); i16++) {
                    if (!list.get(i16).replyId.equals(String.valueOf(arrayList4.get(i16)))) {
                        return -1;
                    }
                }
            }
            return 0;
        }
        return size - arrayList.size();
    }

    public static void setTrimRation(float f16) {
        if (f16 > 0.0f && f16 < 1.0f) {
            sTrimRation = f16;
        } else {
            sTrimRation = 1.0f;
        }
        b.i(TAG, "setTrimRation, trimRation = " + f16);
    }

    public String getCommentListInfo(List<s_commment> list, boolean z16) {
        if (list == null) {
            return WiFiDash.NOT_AVALIBLE;
        }
        StringBuffer stringBuffer = new StringBuffer(100);
        stringBuffer.append("total_num:");
        stringBuffer.append(list.size());
        for (s_commment s_commmentVar : list) {
            stringBuffer.append("[");
            stringBuffer.append(s_commmentVar.commentid);
            stringBuffer.append("**del:");
            stringBuffer.append(s_commmentVar.isDeleted);
            stringBuffer.append("**");
            if (!TextUtils.isEmpty(s_commmentVar.content) && z16) {
                stringBuffer.append("**");
                stringBuffer.append(s_commmentVar.content);
                stringBuffer.append("**");
            }
            ArrayList<s_reply> arrayList = s_commmentVar.replys;
            if (arrayList != null && arrayList.size() > 0) {
                stringBuffer.append("(");
                Iterator<s_reply> it = s_commmentVar.replys.iterator();
                while (it.hasNext()) {
                    s_reply next = it.next();
                    stringBuffer.append(next.replyid);
                    stringBuffer.append("**del:");
                    stringBuffer.append(s_commmentVar.isDeleted);
                    stringBuffer.append("**");
                    if (!TextUtils.isEmpty(next.content) && z16) {
                        stringBuffer.append("**");
                        stringBuffer.append(next.content);
                        stringBuffer.append("**");
                    }
                    stringBuffer.append(",");
                }
                stringBuffer.append(")");
            }
            stringBuffer.append("]");
        }
        return stringBuffer.toString();
    }

    @Override // com.qzone.proxy.feedcomponent.manager.e
    public List<BusinessFeedData> increaseUpdate(List<single_feed> list, List<BusinessFeedData> list2) {
        BusinessFeedData queryMem;
        if (list == null || list.size() <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        new ArrayList(this.mCurrentUIDatas);
        for (single_feed single_feedVar : list) {
            l lVar = new l(single_feedVar.singlefeed);
            cell_comm cell_commVar = lVar.f50340a;
            if (cell_commVar != null && (queryMem = queryMem(cell_commVar.ugckey)) != null) {
                b.e("FeedUpdate", "increaseUpdate ugcKey:" + cell_commVar.ugckey + " localTime:" + queryMem.getFeedCommInfo().time + " time:" + single_feedVar.time);
                mergeFeedData(queryMem, lVar);
                if (aa.i(lVar) && CellFeedCommInfo.create(lVar) != null) {
                    queryMem.setCellFeedCommInfo(CellFeedCommInfo.create(lVar));
                }
                cell_comment cell_commentVar = lVar.f50362l;
                if (single_feedVar.pullAll) {
                    CellCommentInfo create = CellCommentInfo.create(lVar);
                    if (create != null) {
                        queryMem.setCommentInfo(create);
                        queryMem.getCommentInfo().preCalculate();
                    }
                } else if (cell_commentVar != null && cell_commentVar.commments != null) {
                    b.e("FeedUpdate", "mergeCommentList ugcKey:" + queryMem.getFeedCommInfo().ugckey + " localSize:" + queryMem.getCommentInfo().commentNum + " newSize:" + cell_commentVar.num + " rsp:" + getCommentListInfo(cell_commentVar.commments, true));
                    queryMem.getCommentInfo().mergeComment(cell_commentVar.commments);
                    queryMem.getCommentInfo().preCalculate();
                    if (cell_commentVar.num > 0) {
                        queryMem.getCommentInfo().commentNum = cell_commentVar.num;
                    }
                    if (queryMem.getCommentInfo().realCount > 0) {
                        queryMem.getCommentInfo().realCount = cell_commentVar.iRealCount;
                    }
                    b.e("FeedUpdate", "mergeCommentList result. ugcKey:" + queryMem.getFeedCommInfo().ugckey + " localSize:" + queryMem.getCommentInfo().commentNum + " content:" + getCommentListInfo(cell_commentVar.commments, false));
                }
                if (single_feedVar.time > 0) {
                    queryMem.getFeedCommInfo().time = single_feedVar.time * 1000;
                }
                arrayList.add(queryMem);
            }
        }
        return arrayList;
    }
}
