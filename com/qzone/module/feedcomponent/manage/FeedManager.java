package com.qzone.module.feedcomponent.manage;

import NS_MOBILE_FEEDS.cell_comm;
import NS_MOBILE_FEEDS.cnst.GDT_ADV_COOKIE;
import NS_MOBILE_FEEDS.mobile_feeds_piece_list;
import NS_MOBILE_FEEDS.mobile_feeds_piece_public;
import NS_MOBILE_FEEDS.mobile_feeds_rsp;
import NS_MOBILE_FEEDS.single_feed;
import NS_QMALL_COVER.ProfileQzmallDeco;
import NS_QMALL_COVER.QzmallProfileDecoGetRsp;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import com.qq.taf.jce.JceStruct;
import com.qzone.adapter.feedcomponent.IResult;
import com.qzone.adapter.feedcomponent.e;
import com.qzone.adapter.feedcomponent.h;
import com.qzone.adapter.feedcomponent.i;
import com.qzone.adapter.feedcomponent.k;
import com.qzone.adapter.feedcomponent.s;
import com.qzone.adapter.feedcomponent.t;
import com.qzone.adapter.feedcomponent.u;
import com.qzone.common.business.result.QZoneResult;
import com.qzone.common.event.IObserver;
import com.qzone.commoncode.module.gdt.GdtFeedUtilForQZone;
import com.qzone.homepage.diy.util.QzoneDIYService;
import com.qzone.module.feedcomponent.ui.DataPreCalculateTool;
import com.qzone.module.feedcomponent.ui.FeedViewBuilder;
import com.qzone.module.feedcomponent.ui.FeedViewSection;
import com.qzone.module.feedcomponent.ui.NickNameArea;
import com.qzone.module.feedcomponent.ui.ViewLoader;
import com.qzone.proxy.feedcomponent.FeedGlobalEnv;
import com.qzone.proxy.feedcomponent.b;
import com.qzone.proxy.feedcomponent.manager.c;
import com.qzone.proxy.feedcomponent.manager.d;
import com.qzone.proxy.feedcomponent.manager.f;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.model.CellCanvas;
import com.qzone.proxy.feedcomponent.model.CellFeedCommInfo;
import com.qzone.proxy.feedcomponent.model.CellRecommAction;
import com.qzone.proxy.feedcomponent.model.CustomPraiseData;
import com.qzone.proxy.feedcomponent.model.User;
import com.qzone.proxy.feedcomponent.model.VideoInfo;
import com.qzone.proxy.feedcomponent.model.gdt.GdtAdFeedUtil;
import com.qzone.proxy.feedcomponent.model.l;
import com.qzone.proxy.feedcomponent.service.QzoneCustomPraiseService;
import com.qzone.proxy.feedcomponent.service.QzoneExendFeedCustomPraiseService;
import com.qzone.proxy.feedcomponent.service.QzonePolymorphicPraiseService;
import com.qzone.reborn.configx.g;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.component.media.image.ImageLoader;
import com.tencent.ditto.shell.DittoUIEngine;
import com.tencent.util.QQToastUtil;
import cooperation.qzone.remote.ServiceConst;
import cooperation.qzone.util.QZLog;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONException;
import org.json.JSONObject;
import ze.a;

/* compiled from: P */
/* loaded from: classes39.dex */
public class FeedManager implements f, Handler.Callback, f.c, c {
    static final int CLEAR_TYPE_ALL = 0;
    static final int CLEAR_TYPE_UIN = 1;
    private static final String DEBUG_DITTO_FILE_NAME = "ditto.json";
    private static final boolean DEBUG_DITTO_LOCAL = false;
    static final boolean DEFAULT_IS_SUPPORT_INCREMENT_UPDATE = true;
    static final boolean DEFAULT_IS_SUPPORT_PIECE = true;
    public static final String HANDLE_RESPONSE_DATAS = "handleResponseDatas";
    static final String KEY_GLOBAL_ATTACH_INFO = "feed_global_attachinfo";
    static final String KEY_GLOBAL_TLV_ATTACH_INFO = "feed_global_tlv_attachinfo";
    static final String KEY_GLOBAL_UP_ATTACH_INFO = "feed_global_up_attachinfo";
    static final String KEY_HAS_MORE = "feed_has_more";
    static final String KEY_PRE_SCROLL = "feed_container_pre_scroll";
    static final String KEY_REFRESH_ATTACH_INFO = "feed_refresh_glob_attachinfo";
    static final String KEY_REFRESH_FEED_KEY = "feed_refresh_feed_key";
    static final String KEY_REFRESH_FEED_SIZE = "feed_refresh_size";
    static final String KEY_REFRESH_TLV_ATTACH_INFO = "feed_refresh_tlv_attachinfo";
    static final String KEY_SOFT_CTRL = "feed_soft_ctrl";
    public static final String LOAD_MORE = "loadMore";
    public static final String LOAD_MORE_UP = "loadMoreUp";
    public static final String ON_NORMAL_RESPONSE = "onNormalResponse";
    static final int PAGE_SIZE = 10;
    static final String TAG = "FeedManager";
    static final String TAG_INIT = "FeedInit";
    static final String TAG_TIME = "FeedTime";
    static final int TASK_TYPE_MORE = 1;
    static final int TASK_TYPE_REFRESH = 0;
    static final int WHAT_BASE = 659;
    static final int WHAT_CANVAS_AD_DATA_ERROR_REPORT = 673;
    static final int WHAT_CLEAR_CACHE = 665;
    static final int WHAT_CLOSE = 664;
    static final int WHAT_FRIEND_FEED_LOAD_MORE_UP_FEED = 676;
    static final int WHAT_GET_MORE_FEED = 662;
    static final int WHAT_LOAD_DATA = 663;
    static final int WHAT_LOAD_MORE_UP_FEED = 672;
    static final int WHAT_ON_LOAD_DATA_RSP = 666;
    static final int WHAT_ON_RSP_SUCCESS = 667;
    static final int WHAT_PRE_DECODE_LOCAL_IMAGE = 668;
    static final int WHAT_PRE_DOWNLOAD_PERNALIZED_CUSTOM_TRAKE = 675;
    static final int WHAT_PRE_DOWNLOAD_PERNALIZED_DIAMOND_IMAGE = 670;
    static final int WHAT_PRE_DOWNLOAD_PERNALIZED_PASSIVE_IMAGE = 674;
    static final int WHAT_QUERY_INIT_DATA = 661;
    static final int WHAT_REFRESH_FEED = 660;
    static final int WHAT_REPORT_APP_INSTALLED = 669;
    static final int WHAT_SET_LOCAL_TEST_DATA = 671;
    public static CopyOnWriteArrayList<String> sDeletedFakeFeedClientKey = new CopyOnWriteArrayList<>();
    IObserver adAsyncReportManager;
    f.b env;
    final boolean isActiveFeed;
    volatile SharedPreferences mAttachInfoPreferences;
    f.a mDataChangedListener;
    volatile int mDataPieceSeqNum;
    d mFakeFeedLogic;
    volatile FeedDataManager mFeedDataManager;
    Handler mFeedHandler;
    mobile_feeds_piece_public mFeedsPublicInfo;
    volatile boolean mForceChangeInfo;
    u mGetMoreTaskReference;
    Boolean mHasMore;
    volatile int mInitialFeedsCount;
    volatile boolean mIsFriendFeedLoadingMoreUp;
    volatile boolean mIsLoadingData;
    volatile boolean mIsLoadingMore;
    volatile boolean mIsLoadingMoreUp;
    volatile boolean mIsRefreshing;
    int mLikeFeedSubType;
    int mLikeFeedType;
    u mLoadMoreUpTaskReference;
    volatile long mOwnerUin;
    SharedPreferences mPrescrollPreference;
    u mRefreshTaskReference;
    long mStartRequestTime;
    volatile long mUin;
    long time;
    Object mLightLock = new Object();
    volatile boolean mIsSupportIncrementUpdate = true;
    volatile boolean mIsSupportPiece = true;
    volatile int mNextPageSize = 10;
    int mFeedServiceTypeOpt = -1;
    volatile int mNewFeedsCount = 6;
    private int mCurrentAdvPos = -1;
    private boolean isEffectiveAdvJump = false;
    private k mFeedTimeInfo = new k();
    ConcurrentHashMap<String, String> mAttachInfoMap = new ConcurrentHashMap<>();
    private final long mIntervalThresholdFromPublishMoodToPublishQueue = (long) (h.b("QZoneSetting", "IntervalThresholdFromPublishMoodToPublishQueue", 3) * 1000);

    /* compiled from: P */
    /* loaded from: classes39.dex */
    private static class ResponseInfo {
        public static final int POOL_SIZE = 6;
        static ResponseInfo[] sOwnedPool = new ResponseInfo[6];
        boolean isLoadMoreUp;
        boolean isRefresh;
        com.qzone.adapter.feedcomponent.c response;
        s result;
        u task;

        ResponseInfo() {
        }

        public static ResponseInfo obtain() {
            ResponseInfo[] responseInfoArr = sOwnedPool;
            synchronized (responseInfoArr) {
                for (int i3 = 0; i3 < 6; i3++) {
                    ResponseInfo responseInfo = responseInfoArr[i3];
                    if (responseInfo != null) {
                        responseInfoArr[i3] = null;
                        return responseInfo;
                    }
                }
                return new ResponseInfo();
            }
        }

        public static void recycle(ResponseInfo responseInfo) {
            ResponseInfo[] responseInfoArr = sOwnedPool;
            synchronized (responseInfoArr) {
                for (int i3 = 0; i3 < 6; i3++) {
                    if (responseInfoArr[i3] == null) {
                        responseInfoArr[i3] = responseInfo;
                        responseInfo.task = null;
                        responseInfo.response = null;
                        responseInfo.result = null;
                        responseInfo.isRefresh = false;
                        responseInfo.isLoadMoreUp = false;
                        return;
                    }
                }
            }
        }
    }

    public FeedManager(int i3, int i16, boolean z16) {
        this.mLikeFeedType = i3;
        this.mLikeFeedSubType = i16;
        this.mFeedDataManager = new FeedDataManager("likeFeedType_" + i3 + "_" + i16, z16, i3, i16);
        this.isActiveFeed = isActiveFriendFeed(i3, i16);
    }

    public static void addDeletedFakeFeedClientKey(String str) {
        CopyOnWriteArrayList<String> copyOnWriteArrayList;
        if (TextUtils.isEmpty(str) || (copyOnWriteArrayList = sDeletedFakeFeedClientKey) == null || copyOnWriteArrayList.size() > 100) {
            return;
        }
        sDeletedFakeFeedClientKey.add(str);
    }

    static Bundle getBundle(s sVar) {
        Object data = sVar.getData();
        if (data != null && (data instanceof Bundle)) {
            return (Bundle) data;
        }
        if (sVar.getBundle() != null) {
            return sVar.getBundle();
        }
        if (sVar.getBundle() != null) {
            return sVar.getBundle();
        }
        return new Bundle();
    }

    public static int getBusiFeedType(int i3) {
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 19) {
                    if (i3 == 24 || i3 == 26) {
                        return 12290;
                    }
                    return 4097;
                }
                return 12289;
            }
            return 3;
        }
        return 4098;
    }

    public static boolean isActiveFriendFeed(int i3, int i16) {
        if (i3 == 0 && i16 == 3) {
            return true;
        }
        return false;
    }

    private void preloadFeedData(ArrayList<BusinessFeedData> arrayList) {
        QzoneDIYService.L().F(arrayList);
        QzoneCustomPraiseService.i().c(arrayList);
    }

    public static void replaceVideoInfoIfNecessary(BusinessFeedData businessFeedData) {
        VideoInfo I0;
        VideoInfo videoInfo = businessFeedData.getVideoInfo();
        if (videoInfo != null) {
            if (!videoInfo.isVideoUrlIntact()) {
                if (TextUtils.isEmpty(businessFeedData.getFeedCommInfo().clientkey) || (I0 = i.H().I0(businessFeedData.getFeedCommInfo().clientkey)) == null) {
                    return;
                }
                I0.isFakeFeed = businessFeedData.getVideoInfo().isFakeFeed;
                businessFeedData.setVideoInfo(I0);
                return;
            }
            i.H().Q1(businessFeedData.getFeedCommInfo().clientkey);
        }
    }

    private void traceEnd(boolean z16, String str) {
        if (this.isActiveFeed) {
            if (z16) {
                i.H().L2(str);
            } else {
                i.H().J2(str);
            }
        }
    }

    private void traceStart(boolean z16, String str) {
        if (this.isActiveFeed) {
            if (z16) {
                i.H().M2(str);
            } else {
                i.H().K2(str);
            }
        }
    }

    public static void updateCertificationJumpInfo(List<User> list) {
        Iterator<User> it = list.iterator();
        while (it.hasNext()) {
            i.H().O2(it.next());
        }
    }

    public void addUIDataCache(Collection<BusinessFeedData> collection) {
        if (this.mFeedDataManager != null) {
            this.mFeedDataManager.addUIDataCache(collection);
        }
    }

    void clearAllAttachInfo() {
        this.mAttachInfoMap.clear();
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add(KEY_HAS_MORE);
        arrayList.add(KEY_GLOBAL_ATTACH_INFO);
        arrayList.add(KEY_GLOBAL_TLV_ATTACH_INFO);
        arrayList.add(KEY_REFRESH_FEED_SIZE);
        arrayList.add(KEY_REFRESH_ATTACH_INFO);
        arrayList.add(KEY_REFRESH_TLV_ATTACH_INFO);
        arrayList.add(KEY_REFRESH_FEED_KEY);
        clearAttachInfoByOneCommit(arrayList);
        logInfo("clear KEY_REFRESH_FEED_KEY", true);
    }

    @Override // com.qzone.proxy.feedcomponent.manager.f
    public void clearAllCache() {
        this.mFeedHandler.sendEmptyMessage(665);
    }

    void clearAttachInfo(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.mAttachInfoMap.remove(str);
        SharedPreferences attachInfoPreferences = getAttachInfoPreferences();
        logInfo("clearAttachInfo key:" + str + "_" + this.mOwnerUin + "_" + this.mLikeFeedType, true);
        attachInfoPreferences.edit().remove(str + "_" + this.mOwnerUin + "_" + this.mLikeFeedType).commit();
    }

    void clearAttachInfoByNotCommit(SharedPreferences.Editor editor, String str) {
        if (TextUtils.isEmpty(str) || editor == null) {
            return;
        }
        this.mAttachInfoMap.remove(str);
        logInfo("clearAttachInfo key:" + str + "_" + this.mOwnerUin + "_" + this.mLikeFeedType, true);
        StringBuilder sb5 = new StringBuilder();
        sb5.append(str);
        sb5.append("_");
        sb5.append(this.mOwnerUin);
        sb5.append("_");
        sb5.append(this.mLikeFeedType);
        editor.remove(sb5.toString());
    }

    public void clearGlobalAttachInfo() {
        clearAttachInfo(KEY_GLOBAL_ATTACH_INFO);
    }

    @Override // com.qzone.proxy.feedcomponent.manager.f
    public void clearMemoryCache() {
        if (this.mFeedDataManager != null) {
            this.mFeedDataManager.clearMemorCache();
        }
    }

    public void clearNotStoredData() {
        deleteNotSortedFeeds();
    }

    void clearTlvAttachInfo() {
        clearAttachInfo(KEY_GLOBAL_TLV_ATTACH_INFO);
    }

    void clearTlvAttachInfoByNotCommit(SharedPreferences.Editor editor) {
        clearAttachInfoByNotCommit(editor, KEY_GLOBAL_TLV_ATTACH_INFO);
    }

    public void clearUIDataCache() {
        if (this.mFeedDataManager != null) {
            this.mFeedDataManager.clearUIDataCache();
        }
    }

    @Override // com.qzone.proxy.feedcomponent.manager.f
    public void close() {
        if (this.mFeedHandler.hasMessages(664)) {
            return;
        }
        this.mFeedHandler.sendEmptyMessage(664);
    }

    void deleteAbnormalFakeFeedWhenRefresh(List<BusinessFeedData> list) {
        CellFeedCommInfo feedCommInfoV2;
        int i3 = this.mLikeFeedType;
        if ((i3 == 19 || i3 == 24) && list != null && list.size() > 0) {
            BusinessFeedData businessFeedData = list.get(0);
            if (!businessFeedData.isFakeFeedSafe() || (feedCommInfoV2 = businessFeedData.getFeedCommInfoV2()) == null || System.currentTimeMillis() - feedCommInfoV2.time <= this.mIntervalThresholdFromPublishMoodToPublishQueue || i.H().Y0(feedCommInfoV2.clientkey)) {
                return;
            }
            ArrayList<String> arrayList = new ArrayList<>();
            arrayList.add(feedCommInfoV2.clientkey);
            this.mFeedDataManager.deleteFakeFeedByClientKey(arrayList);
            if (b.g()) {
                b.c(TAG, "onNormalResponse() delete abnormal fake feed when refresh -- client key: " + feedCommInfoV2.clientkey);
            }
            list.remove(0);
        }
    }

    @Override // com.qzone.proxy.feedcomponent.manager.f
    public void deleteFeedMemOnly(BusinessFeedData businessFeedData) {
        if (this.mFeedDataManager == null || !this.mFeedDataManager.deleteFeedDataMemOnly(businessFeedData)) {
            return;
        }
        onDataChange();
    }

    @Override // com.qzone.proxy.feedcomponent.manager.f
    public void deleteFeedOnTime(String str, String str2, boolean z16) {
        d dVar = this.mFakeFeedLogic;
        if (dVar != null) {
            dVar.u("ugc_key=? OR client_key=?", new String[]{str, str2}, z16);
        }
    }

    public void deleteNotSortedFeeds() {
        b.e(TAG, "deleteNotSortedFeedsIfNeeded()");
        if (this.mFeedDataManager != null) {
            this.mFeedDataManager.deleteNotSortFeeds();
        }
    }

    void deleteOverflowFeeds() {
        this.mFeedDataManager.deleteOverflowFeeds();
    }

    void dyeBusinessFeedDataIfNecessary(boolean z16, BusinessFeedData businessFeedData) {
        int i3 = this.mFeedServiceTypeOpt;
        if (i3 == 1 || i3 == 3) {
            BusinessFeedData feedDataByFeedsKey = this.mFeedDataManager.getFeedDataByFeedsKey(businessFeedData.getFeedCommInfo().feedskey);
            if (feedDataByFeedsKey != null) {
                businessFeedData.setIsRead(feedDataByFeedsKey.getIsRead());
            }
        }
    }

    String getAttachInfo(String str) {
        String str2 = this.mAttachInfoMap.get(str);
        if (!TextUtils.isEmpty(str2)) {
            return str2;
        }
        SharedPreferences attachInfoPreferences = getAttachInfoPreferences();
        String string = attachInfoPreferences.getString(str + "_" + this.mOwnerUin + "_" + this.mLikeFeedType, "");
        logInfo("getAttachInfo key:" + str + "_" + this.mOwnerUin + "_" + this.mLikeFeedType + ",attachInfo:" + string + "--preferences:" + attachInfoPreferences, true);
        return string;
    }

    SharedPreferences getAttachInfoPreferences() {
        if (this.mAttachInfoPreferences == null || this.mForceChangeInfo) {
            this.mAttachInfoPreferences = this.env.getSharedPreferences();
            this.mForceChangeInfo = false;
        }
        return this.mAttachInfoPreferences;
    }

    public List<String> getContainerPreScroll() {
        return new ArrayList(Arrays.asList(getContainerPreScrollPreferences().getString(KEY_PRE_SCROLL, "").split(",")));
    }

    public SharedPreferences getContainerPreScrollPreferences() {
        if (this.mPrescrollPreference == null) {
            this.mPrescrollPreference = this.env.getSharedPreferences();
        }
        return this.mPrescrollPreference;
    }

    @Override // com.qzone.proxy.feedcomponent.manager.f
    public List<BusinessFeedData> getCurrentDatas() {
        return this.mFeedDataManager.getCurrentUIDatas();
    }

    @Override // com.qzone.proxy.feedcomponent.manager.f
    public int getFeedCount() {
        return this.mFeedDataManager.getCurrentFeedsCount();
    }

    HashMap<String, String> getFeedInfos(ArrayList<BusinessFeedData> arrayList) {
        HashMap<String, String> hashMap = new HashMap<>();
        if (arrayList != null) {
            Iterator<BusinessFeedData> it = arrayList.iterator();
            while (it.hasNext()) {
                BusinessFeedData next = it.next();
                if (next != null) {
                    String str = next.feedInfo;
                    if (!TextUtils.isEmpty(str)) {
                        String str2 = next.getFeedCommInfo().feedskey;
                        if (!TextUtils.isEmpty(str2)) {
                            hashMap.put(str2, str);
                        }
                    }
                }
            }
        }
        return hashMap;
    }

    @Override // com.qzone.proxy.feedcomponent.manager.f
    public k getFeedTimeInfo() {
        return this.mFeedTimeInfo;
    }

    String getGlobalAttachInfo() {
        return getAttachInfo(KEY_GLOBAL_ATTACH_INFO);
    }

    String getGlobalUpAttachInfo() {
        return getAttachInfo(KEY_GLOBAL_UP_ATTACH_INFO);
    }

    public int getNewFeedsCount() {
        return this.mNewFeedsCount;
    }

    @Override // com.qzone.proxy.feedcomponent.manager.f
    public long getOwnerUin() {
        if (this.mOwnerUin == 0) {
            return i.H().j0();
        }
        return this.mOwnerUin;
    }

    String getRefreshFeedKey() {
        return getAttachInfo(KEY_REFRESH_FEED_KEY);
    }

    int getRefreshFeedSize() {
        int i3 = getAttachInfoPreferences().getInt("feed_refresh_size_" + this.mOwnerUin + "_" + this.mLikeFeedType, 0);
        if (i3 < 6 || i3 > 20) {
            return 10;
        }
        return i3;
    }

    f.d getRequestOption(int i3, boolean z16) {
        String str;
        HashMap<String, String> hashMap;
        ArrayList<BusinessFeedData> nextPageDatas;
        f.d dVar = new f.d();
        dVar.f50213c = this.mIsSupportPiece;
        dVar.f50212b = this.mOwnerUin;
        if (i3 == 2) {
            return dVar;
        }
        dVar.f50213c = this.mIsSupportPiece;
        dVar.f50211a = this.mIsSupportPiece ? 10 : 20;
        if (i3 == 4) {
            dVar.f50215e = getGlobalUpAttachInfo();
        } else {
            dVar.f50215e = getGlobalAttachInfo();
        }
        if (this.mIsSupportPiece) {
            str = getTlvAttachInfo();
        } else {
            str = "";
        }
        dVar.f50216f = str;
        dVar.f50214d = z16;
        int i16 = this.mNextPageSize;
        boolean z17 = i3 == 0;
        if (this.mIsSupportIncrementUpdate && i16 > 0) {
            if (z17) {
                nextPageDatas = this.mFeedDataManager.getFirstPageDatas(i16);
            } else {
                nextPageDatas = this.mFeedDataManager.getNextPageDatas(i16);
            }
            hashMap = getFeedInfos(nextPageDatas);
        } else {
            logInfo("not support increment update for load more (supportIncementUpdate:" + this.mIsSupportIncrementUpdate + "| nextPageSize:" + i16 + ")", true);
            hashMap = null;
        }
        if (!isListEmpty(getCurrentDatas())) {
            dVar.f50217g = hashMap;
        }
        dVar.f50218h = DittoUIEngine.g().getDittoUIFileInfo();
        b.a(TAG, "getRequestOption:" + z17 + ",isSupportPiece:" + this.mIsSupportPiece);
        return dVar;
    }

    String getTlvAttachInfo() {
        return getAttachInfo(KEY_GLOBAL_TLV_ATTACH_INFO);
    }

    @Override // com.qzone.proxy.feedcomponent.manager.f
    public long getUin() {
        return this.mUin;
    }

    void handleClose() {
        this.mFeedDataManager.close();
        this.mFakeFeedLogic.close();
        logInfo("reset state by close!", true);
        resetState();
        i.H().r(this.adAsyncReportManager);
        this.mForceChangeInfo = true;
        onFeedDataChange(this.mFeedDataManager.getCurrentUIDatas(), false, false, false);
        synchronized (this.mLightLock) {
            this.mUin = 0L;
            this.mOwnerUin = 0L;
        }
    }

    void handleEmptyDataPieceResponse(com.qzone.adapter.feedcomponent.c cVar, boolean z16) {
        if (cVar.k() || this.mDataPieceSeqNum != 0) {
            return;
        }
        logInfo("not receive any data piece -->  refresh:" + z16, true);
        if (z16) {
            this.mFeedDataManager.deleteInvalidFakeFeed();
            this.mFeedDataManager.clearMemorCache(false);
        }
        onFeedDataChange(getCurrentDatas(), true, false, false);
    }

    void handleJustLoadData(t tVar) {
        if (!this.mIsLoadingMore && !this.mIsRefreshing && !this.mIsLoadingMoreUp && !this.mIsFriendFeedLoadingMoreUp) {
            if (this.mLikeFeedType != 1 && this.mFeedDataManager.getCacheSize() > 0) {
                RFWLog.i("request_feedx", RFWLog.USR, "has data in memory, just return");
                return;
            } else {
                sendRequestMsg(2, tVar, false);
                return;
            }
        }
        RFWLog.i("request_feedx", RFWLog.USR, "is loading, just return");
    }

    void handleReportAppInstalled(BusinessFeedData businessFeedData, boolean z16) {
        i.H().S1(businessFeedData, z16);
    }

    void handleResponseDatas(boolean z16, ArrayList<single_feed> arrayList, List<String> list, List<BusinessFeedData> list2) {
        handleResponseDatas(z16, arrayList, list, list2, null);
    }

    @Override // com.qzone.proxy.feedcomponent.manager.f
    public boolean hasMore() {
        if (this.mHasMore == null) {
            this.mHasMore = Boolean.valueOf(getAttachInfoPreferences().getBoolean("feed_has_more_" + this.mOwnerUin + "_" + this.mLikeFeedType, true));
        }
        return this.mHasMore.booleanValue();
    }

    @Override // com.qzone.proxy.feedcomponent.manager.f
    public void init(e.a aVar, f.b bVar, f.a aVar2) {
        this.mFeedHandler = new Handler(bVar.x().getLooper(), this);
        this.env = bVar;
        d r16 = bVar.r(this.mFeedDataManager, aVar, this.mLikeFeedType, this.mLikeFeedSubType);
        this.mFakeFeedLogic = r16;
        r16.p(this);
        this.mDataChangedListener = aVar2;
        this.adAsyncReportManager = i.H().Q0(this.mFeedDataManager);
    }

    boolean isTimeOut() {
        long currentTimeMillis = System.currentTimeMillis() - this.mStartRequestTime;
        return currentTimeMillis > ((long) g.f53821a.b().S0()) || currentTimeMillis < 0;
    }

    void onBuildRequestException(t tVar, int i3) {
        logError("onBuildRequestException,sendFakeResponse(what:" + i3 + ")", true);
        resetState();
        sendFakeResponse(tVar, -66, "", i3);
    }

    @Override // com.qzone.proxy.feedcomponent.manager.f
    public void onDataChange() {
        List<BusinessFeedData> currentUIDatas = this.mFeedDataManager.getCurrentUIDatas();
        if (currentUIDatas != null) {
            Iterator<BusinessFeedData> it = currentUIDatas.iterator();
            while (it.hasNext()) {
                it.next().feedType = getBusiFeedType(this.mLikeFeedType);
            }
        }
        onFeedDataChange(currentUIDatas, false, false, false);
    }

    @Override // com.qzone.proxy.feedcomponent.manager.f.c
    public void onFailed(u uVar, s sVar) {
        onReponseFailed(uVar, sVar);
    }

    @Override // com.qzone.proxy.feedcomponent.manager.c
    public void onFeedCreate(BusinessFeedData businessFeedData) {
        onDataChange();
    }

    void onFeedDataChange(List<BusinessFeedData> list, boolean z16, boolean z17, boolean z18) {
        onFeedDataChange(list, z16, z17, z18, 0);
    }

    void onFeedDataPartionChange(List<BusinessFeedData> list, List<BusinessFeedData> list2) {
        this.mDataChangedListener.t(list, list2);
    }

    @Override // com.qzone.proxy.feedcomponent.manager.c
    public void onFeedDelete() {
        onDataChange();
    }

    void onLoadDataResponse(u uVar, s sVar, com.qzone.adapter.feedcomponent.c cVar) {
        ArrayList<single_feed> b16;
        if (!this.mIsRefreshing && !this.mIsLoadingMore && !this.mIsLoadingMoreUp && !this.mIsFriendFeedLoadingMoreUp) {
            JceStruct d16 = cVar.d();
            DittoUIEngine.g().updateLayoutFile(cVar.e());
            SharedPreferences.Editor edit = getAttachInfoPreferences().edit();
            if (d16 != null) {
                this.env.h(cVar.g() == 1);
                if (cVar.m() != 1 && (b16 = cVar.b()) != null) {
                    List<String> arrayList = new ArrayList<>();
                    List<BusinessFeedData> arrayList2 = new ArrayList<>();
                    ArrayList<BusinessFeedData> arrayList3 = new ArrayList<>();
                    String c16 = cVar.c();
                    List<BusinessFeedData> transformFeedData = transformFeedData(true, b16, arrayList, arrayList2, arrayList3, c16);
                    if (transformFeedData != null) {
                        if (this.mLikeFeedType == 1) {
                            this.mFeedDataManager.replaceAndSave(arrayList3);
                        } else {
                            this.mFeedDataManager.saveFeedDatas(arrayList3);
                        }
                    }
                    r0 = cVar.j() != 0;
                    handleRefreshAttachInfo(true, c16, null, transformFeedData);
                    saveGlobalAttachInfo(c16, edit);
                    saveHasMore(r0, edit);
                    r0 = true;
                }
            }
            if (r0) {
                edit.commit();
            }
            this.mFeedDataManager.clearPageCache();
            resetState();
            return;
        }
        b.e(TAG, "onLoadDataResponse abandon result, because isRefreshing:" + this.mIsRefreshing + ",mIsLoadingMore:" + this.mIsLoadingMore);
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00f2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    void onPieceResponse(u uVar, s sVar, com.qzone.adapter.feedcomponent.c cVar, boolean z16) {
        boolean z17;
        Bundle bundle = getBundle(sVar);
        boolean k3 = cVar.k();
        int h16 = cVar.h();
        logInfo("receiving piece response --> pieceType:" + h16 + "| hasNext:" + k3 + "| refresh:" + z16, true);
        if (h16 == 1) {
            onReceivePublicInfo(cVar, z16);
        } else if (h16 == 2) {
            onReceiveSingleFeedPiece(cVar, z16);
        }
        handleEmptyDataPieceResponse(cVar, z16);
        SharedPreferences.Editor edit = getAttachInfoPreferences().edit();
        this.env.h(cVar.g() == 1);
        if (!k3) {
            mobile_feeds_piece_public mobile_feeds_piece_publicVar = this.mFeedsPublicInfo;
            if (mobile_feeds_piece_publicVar != null) {
                saveHasMore(mobile_feeds_piece_publicVar.hasmore != 0, edit);
                if (mobile_feeds_piece_publicVar.no_update != 1) {
                    saveGlobalAttachInfo(mobile_feeds_piece_publicVar.attach_info, edit);
                }
                z17 = true;
                if (z17) {
                    edit.commit();
                }
                boolean z18 = (this.mDataPieceSeqNum == 1 && !isNoUpdate(this.mFeedsPublicInfo) && k3) ? false : true;
                boolean hasMore = hasMore();
                bundle.putBoolean("end_refreshing", z18);
                bundle.putBoolean("hasMore", hasMore);
                bundle.putBoolean("hasNext", k3);
                sVar.setData(bundle);
                logInfo("send piece response(refresh:" + z16 + ",type:" + this.mLikeFeedType + "|endRefresh:" + z18 + "|hasMore:" + hasMore + "|hasNext:" + k3 + "),task:" + this.mRefreshTaskReference, true);
                if (!k3) {
                    if (z16) {
                        deleteOverflowFeeds();
                    }
                    if (h16 != 2) {
                        this.env.j(cVar, z18, h16);
                    }
                    updateNewFeedsCount();
                    if (z16) {
                        b.a(TAG, "piece refresh_feed_size:" + this.mNewFeedsCount);
                        saveAttachInfo(KEY_REFRESH_FEED_SIZE, this.mNewFeedsCount, (SharedPreferences.Editor) null);
                    }
                    onResponseFinish();
                }
                uVar.a(sVar);
            }
            logInfo("save hasMore&attachInfo failed, publicInfo is Null!", true);
        }
        z17 = false;
        if (z17) {
        }
        if (this.mDataPieceSeqNum == 1) {
        }
        boolean hasMore2 = hasMore();
        bundle.putBoolean("end_refreshing", z18);
        bundle.putBoolean("hasMore", hasMore2);
        bundle.putBoolean("hasNext", k3);
        sVar.setData(bundle);
        logInfo("send piece response(refresh:" + z16 + ",type:" + this.mLikeFeedType + "|endRefresh:" + z18 + "|hasMore:" + hasMore2 + "|hasNext:" + k3 + "),task:" + this.mRefreshTaskReference, true);
        if (!k3) {
        }
        uVar.a(sVar);
    }

    void onReceivePublicInfo(com.qzone.adapter.feedcomponent.c cVar, boolean z16) {
        if (cVar.f() instanceof mobile_feeds_piece_public) {
            mobile_feeds_piece_public mobile_feeds_piece_publicVar = (mobile_feeds_piece_public) cVar.f();
            this.mFeedsPublicInfo = mobile_feeds_piece_publicVar;
            if (mobile_feeds_piece_publicVar != null) {
                if (!TextUtils.isEmpty(mobile_feeds_piece_publicVar.user_sid)) {
                    FeedsSidManager.setUserSid(mobile_feeds_piece_publicVar.user_sid);
                }
                int i3 = (int) mobile_feeds_piece_publicVar.req_count;
                this.mNextPageSize = i3;
                if (mobile_feeds_piece_publicVar.no_update != 1) {
                    String str = mobile_feeds_piece_publicVar.attach_info;
                    logInfo("received publicInfo (refresh:" + z16 + "| reqCount:" + i3 + "| hasmore:" + (mobile_feeds_piece_publicVar.hasmore != 0) + "| attachInfo:" + str + ")", true);
                } else {
                    logInfo("received publicInfo --> no update (refresh:" + z16 + "| reqCount:" + i3 + ")", true);
                    this.env.d(z16);
                }
                if (mobile_feeds_piece_publicVar.stMapExtendinfo != null) {
                    i.H().s2(mobile_feeds_piece_publicVar.stMapExtendinfo.get(GDT_ADV_COOKIE.value));
                    return;
                }
                return;
            }
            return;
        }
        b.c(TAG, "onReceivePublicInfo() piece is not valid, resp=" + cVar.f());
    }

    void onReceiveQzMallDeco(com.qzone.adapter.feedcomponent.c cVar, boolean z16) {
        if (cVar.f() instanceof QzmallProfileDecoGetRsp) {
            ProfileQzmallDeco profileQzmallDeco = (ProfileQzmallDeco) i.H().u(ProfileQzmallDeco.class, ((QzmallProfileDecoGetRsp) cVar.f()).vecBuff);
            if (profileQzmallDeco != null) {
                QzoneCustomPraiseService.i().p(CustomPraiseData.createFromResponse(profileQzmallDeco.stCustomPraise));
            } else {
                QzoneCustomPraiseService.i().p(null);
                b.e(TAG, "read: CustomPraise is null");
            }
        }
    }

    void onResponseFinish() {
        this.mFeedDataManager.clearPageCache();
        resetState();
    }

    void onResponseSuccess(u uVar, s sVar, com.qzone.adapter.feedcomponent.c cVar, boolean z16, boolean z17) {
        this.mFeedTimeInfo.b(1);
        if (!cVar.l()) {
            if (cVar.d() == null) {
                logInfo("BusiRsp is null,request is failed (refresh:" + z16 + ")", true);
                onReponseFailed(uVar, sVar);
                return;
            }
            logInfo("receiving normal response (refresh:" + z16 + ")", true);
            onNormalResponse(uVar, sVar, cVar, z16, z17);
            return;
        }
        onPieceResponse(uVar, sVar, cVar, z16);
    }

    @Override // com.qzone.proxy.feedcomponent.manager.f.c
    public void onSucceed(u uVar, s sVar, com.qzone.adapter.feedcomponent.c cVar, int i3) {
        QZLog.i(TAG, 1, "onSucceed, requestType: " + i3);
        Message obtain = Message.obtain();
        ResponseInfo obtain2 = ResponseInfo.obtain();
        obtain2.task = uVar;
        obtain2.response = cVar;
        obtain2.result = sVar;
        if (i3 == 2) {
            obtain.what = 666;
        } else {
            obtain.what = 667;
            obtain2.isRefresh = i3 == 0;
        }
        if (i3 == 3 || i3 == 4) {
            obtain2.isLoadMoreUp = true;
        }
        obtain.obj = obtain2;
        this.mFeedHandler.sendMessage(obtain);
    }

    @Override // com.qzone.proxy.feedcomponent.manager.f
    public void preDownloadFeedsPassiveCustomTrack(int i3, int i16) {
        Message obtain = Message.obtain();
        obtain.what = WHAT_PRE_DOWNLOAD_PERNALIZED_CUSTOM_TRAKE;
        obtain.arg1 = i3;
        obtain.arg2 = i16;
        this.mFeedHandler.sendMessage(obtain);
    }

    @Override // com.qzone.proxy.feedcomponent.manager.f
    public void preDownloadFeedsPernalizeDiamondImage(int i3, int i16) {
        Message obtain = Message.obtain();
        obtain.what = 670;
        obtain.arg1 = i3;
        obtain.arg2 = i16;
        this.mFeedHandler.sendMessage(obtain);
    }

    @Override // com.qzone.proxy.feedcomponent.manager.f
    public void preDownloadFeedsPernalizePassivePraise(int i3, int i16) {
        Message obtain = Message.obtain();
        obtain.what = WHAT_PRE_DOWNLOAD_PERNALIZED_PASSIVE_IMAGE;
        obtain.arg1 = i3;
        obtain.arg2 = i16;
        this.mFeedHandler.sendMessage(obtain);
    }

    @Override // com.qzone.proxy.feedcomponent.manager.f
    public void requestFeedDatas(int i3, t tVar, boolean z16) {
        RFWLog.i("request_feedx", RFWLog.USR, "requestFeedDatas: " + i3 + ", isForceRefresh: " + z16);
        if (i3 == 2) {
            RFWLog.i("request_feedx", RFWLog.USR, "just load data");
            handleJustLoadData(tVar);
            return;
        }
        boolean z17 = i3 == 0;
        if (z17 && !this.mIsRefreshing) {
            RFWLog.i("request_feedx", RFWLog.USR, "start refresh data");
            sendRequestMsg(i3, tVar, z16);
            return;
        }
        if (this.mIsLoadingData) {
            RFWLog.i("request_feedx", RFWLog.USR, "is loading data, just send fake reponse");
            if (i3 == 3) {
                sendFakeResponse(tVar, 0, null, z17 ? 899902 : 899904);
                return;
            } else if (i3 == 4) {
                sendFakeResponse(tVar, 0, null, z17 ? 899902 : 899905);
                return;
            } else {
                sendFakeResponse(tVar, 0, null, z17 ? 899902 : 899903);
                return;
            }
        }
        if (!this.mIsLoadingMore && !this.mIsRefreshing && !this.mIsLoadingMoreUp && !this.mIsFriendFeedLoadingMoreUp) {
            sendRequestMsg(i3, tVar, z16);
            return;
        }
        if (isTimeOut()) {
            RFWLog.i("request_feedx", RFWLog.USR, "requestFeedDatas timeout,isLoadingMore" + this.mIsLoadingMore + ",isRefresh:" + this.mIsRefreshing + ",isRefresh:" + z17);
            resetState();
            sendRequestMsg(i3, tVar, z16);
            return;
        }
        if (z17 && this.mIsRefreshing) {
            u uVar = this.mRefreshTaskReference;
            sendFakeResponse(tVar, 0, "", 899902);
            RFWLog.i("request_feedx", RFWLog.USR, "receive a refresh request but not allow to request (isRefreshing:" + this.mIsRefreshing + "|refreshTask:" + uVar + " |isLoadingMore:" + this.mIsLoadingMore + " | interval:" + (System.currentTimeMillis() - this.mStartRequestTime) + ")");
            return;
        }
        if (!z17 && this.mIsLoadingMore) {
            u uVar2 = this.mGetMoreTaskReference;
            RFWLog.i("request_feedx", RFWLog.USR, "wait for loadingMore response!(getMoreTask:" + uVar2 + ")");
            return;
        }
        if (!z17 && this.mIsLoadingMoreUp) {
            u uVar3 = this.mLoadMoreUpTaskReference;
            RFWLog.i("request_feedx", RFWLog.USR, "wait for loadingMore response!(loadMoreUpTask:" + uVar3 + ")");
            return;
        }
        RFWLog.i("request_feedx", RFWLog.USR, "sendFakeResponse" + z17);
        sendFakeResponse(tVar, 0, null, z17 ? 899902 : 899903);
    }

    void saveAttachInfo(String str, String str2, SharedPreferences.Editor editor) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (str2 == null) {
            str2 = "";
        }
        this.mAttachInfoMap.put(str, str2);
        logInfo("saveAttachInfo key:" + str + "_" + this.mOwnerUin + "_" + this.mLikeFeedType + ",attachInfo:" + str2 + "--preferences:" + getAttachInfoPreferences(), true);
        StringBuilder sb5 = new StringBuilder();
        sb5.append(str);
        sb5.append("_");
        sb5.append(this.mOwnerUin);
        sb5.append("_");
        sb5.append(this.mLikeFeedType);
        putValue(editor, sb5.toString(), str2);
    }

    public void saveContainerPreScroll(BusinessFeedData businessFeedData) {
        String str = businessFeedData.getFeedCommInfoV2().feedskey;
        List<String> containerPreScroll = getContainerPreScroll();
        containerPreScroll.add(str);
        getContainerPreScrollPreferences().edit().putString(KEY_PRE_SCROLL, TextUtils.join(",", containerPreScroll)).commit();
    }

    void saveGlobalAttachInfo(String str, SharedPreferences.Editor editor) {
        saveAttachInfo(KEY_GLOBAL_ATTACH_INFO, str, editor);
    }

    void saveGlobalUpAttachInfo(String str, SharedPreferences.Editor editor) {
        saveAttachInfo(KEY_GLOBAL_UP_ATTACH_INFO, str, editor);
    }

    void saveHasMore(boolean z16, SharedPreferences.Editor editor) {
        this.mHasMore = Boolean.valueOf(z16);
        putValue(editor, "feed_has_more_" + this.mOwnerUin + "_" + this.mLikeFeedType, new Boolean(z16));
    }

    void saveRefreshAttachInfo(String str, String str2, String str3) {
        b.a(TAG, "saveRefreshAttachInfo:" + str + ",feeskey:" + str3);
        if (TextUtils.isEmpty(str3)) {
            return;
        }
        SharedPreferences.Editor edit = getAttachInfoPreferences().edit();
        saveAttachInfo(KEY_REFRESH_ATTACH_INFO, str, edit);
        saveAttachInfo(KEY_REFRESH_TLV_ATTACH_INFO, str2, edit);
        saveAttachInfo(KEY_REFRESH_FEED_KEY, str3, edit);
        edit.commit();
    }

    void saveTlvAttachInfo(String str, SharedPreferences.Editor editor) {
        saveAttachInfo(KEY_GLOBAL_TLV_ATTACH_INFO, str, editor);
    }

    @Override // com.qzone.proxy.feedcomponent.manager.f
    public void sendInitDataMessage() {
        if (this.mFeedHandler.hasMessages(661)) {
            return;
        }
        this.mFeedHandler.sendEmptyMessage(661);
    }

    void sendRequestMsg(int i3, t tVar, boolean z16) {
        this.mStartRequestTime = System.currentTimeMillis();
        Message obtain = Message.obtain();
        if (i3 == 0) {
            this.mIsRefreshing = true;
            obtain.what = 660;
            this.mFeedTimeInfo.b(0);
        } else if (i3 == 1) {
            this.mIsLoadingMore = true;
            obtain.what = WHAT_GET_MORE_FEED;
            this.mFeedTimeInfo.b(0);
        } else if (i3 == 2) {
            this.mIsLoadingData = true;
            obtain.what = WHAT_LOAD_DATA;
        } else if (i3 == 3) {
            this.mIsLoadingMoreUp = true;
            obtain.what = WHAT_LOAD_MORE_UP_FEED;
        } else if (i3 == 4) {
            this.mIsFriendFeedLoadingMoreUp = true;
            obtain.what = WHAT_FRIEND_FEED_LOAD_MORE_UP_FEED;
        }
        obtain.obj = new Object[]{tVar, Boolean.valueOf(z16)};
        this.mFeedHandler.sendMessage(obtain);
    }

    public void setMaxFlashCount(int i3) {
        NickNameArea.setFlashCount(i3);
    }

    @Override // com.qzone.proxy.feedcomponent.manager.f
    public void setSupportIncrementUpdate(boolean z16) {
        this.mIsSupportIncrementUpdate = z16;
    }

    @Override // com.qzone.proxy.feedcomponent.manager.f
    public void setSupportPiece(boolean z16) {
        this.mIsSupportPiece = z16;
    }

    @Override // com.qzone.proxy.feedcomponent.manager.f
    public void setUin(long j3, long j16, boolean z16, boolean z17) {
        boolean z18 = false;
        if (this.mUin != j3 || this.mOwnerUin != j16) {
            synchronized (this.mLightLock) {
                if (this.mUin != j3 || this.mOwnerUin != j16) {
                    this.mUin = j3;
                    this.mOwnerUin = j16;
                    z18 = true;
                }
            }
        }
        if (z18) {
            this.mAttachInfoMap.clear();
            this.mFeedDataManager.init(j3, j16);
            this.mFakeFeedLogic.o(j3, j16);
            this.mForceChangeInfo = true;
        }
        if (z16 && z18) {
            this.time = System.currentTimeMillis();
            b.c(TAG_INIT, "setUin:" + this.isActiveFeed);
            sendInitDataMessage();
        }
    }

    ArrayList<BusinessFeedData> transformFeedData(boolean z16, ArrayList<single_feed> arrayList, List<String> list, List<BusinessFeedData> list2, List<BusinessFeedData> list3, String str) {
        long j3;
        int i3;
        int i16;
        single_feed single_feedVar;
        int i17;
        BusinessFeedData businessFeedData;
        cell_comm c16;
        cell_comm c17;
        cell_comm c18;
        StringBuilder sb5;
        ArrayList<BusinessFeedData> arrayList2 = new ArrayList<>();
        long currentTimeMillis = System.currentTimeMillis();
        int size = arrayList.size();
        int i18 = 0;
        int i19 = 0;
        int i26 = 0;
        int i27 = 0;
        int i28 = 0;
        int i29 = 0;
        while (i18 < size) {
            try {
                single_feedVar = arrayList.get(i18);
            } catch (Throwable th5) {
                th = th5;
                j3 = currentTimeMillis;
                i3 = size;
                i16 = i18;
            }
            if (single_feedVar != null) {
                i3 = size;
                try {
                } catch (Throwable th6) {
                    th = th6;
                    j3 = currentTimeMillis;
                    i16 = i18;
                }
                if (TextUtils.isEmpty(single_feedVar.feedskey)) {
                    j3 = currentTimeMillis;
                    i16 = i18;
                    i17 = i29;
                } else {
                    long j16 = single_feedVar.status;
                    j3 = currentTimeMillis;
                    if (j16 == 0) {
                        i19++;
                        try {
                            BusinessFeedData createFrom = BusinessFeedData.createFrom(single_feedVar, getBusiFeedType(this.mLikeFeedType));
                            int i36 = RFWLog.DEV;
                            Object[] objArr = new Object[1];
                            try {
                                sb5 = new StringBuilder();
                                i16 = i18;
                            } catch (Throwable th7) {
                                th = th7;
                                i16 = i18;
                            }
                            try {
                                sb5.append("create from response, feedsKey: ");
                                sb5.append(ef.b.a(createFrom));
                                sb5.append(", comment: ");
                                sb5.append(createFrom != null ? createFrom.getCommentInfo() : "");
                                sb5.append(", feedType: ");
                                sb5.append(this.mLikeFeedType);
                                try {
                                    objArr[0] = sb5.toString();
                                    RFWLog.d(TAG, i36, objArr);
                                    reportHouBuDcDC02082(createFrom);
                                    if (com.qzone.proxy.feedcomponent.model.c.d(createFrom)) {
                                        b.e(TAG, "transformFeedData() filter deleted fake feed -- feedKey: " + single_feedVar.feedskey);
                                    } else if (!shouldFilterAppAdv(createFrom)) {
                                        if (shouldFilterDeletedFakeFeed(createFrom)) {
                                            if (b.g()) {
                                                b.e(TAG, "transformFeedData() filter deleted fake feed -- feedKey: " + single_feedVar.feedskey);
                                            }
                                        } else {
                                            if (createFrom != null && createFrom.isGDTAdvFeed()) {
                                                try {
                                                    GdtFeedUtilForQZone.x(createFrom, 0);
                                                    String dynamicTagIconUrl = GdtAdFeedUtil.getDynamicTagIconUrl(createFrom);
                                                    if (!TextUtils.isEmpty(dynamicTagIconUrl)) {
                                                        if (ImageLoader.getInstance().loadImageSync(dynamicTagIconUrl) == null) {
                                                            b.c(TAG, "dynamic tag icon preload starts");
                                                            ImageLoader.getInstance().downloadImageOnly(dynamicTagIconUrl, null);
                                                        } else {
                                                            b.c(TAG, "dynamic tag icon preload successes");
                                                        }
                                                    }
                                                } catch (Throwable th8) {
                                                    th = th8;
                                                    i19 = i19;
                                                    xe.b.f447841a.d(th);
                                                    i18 = i16 + 1;
                                                    size = i3;
                                                    currentTimeMillis = j3;
                                                }
                                            }
                                            if (createFrom != null) {
                                                String str2 = createFrom.getFeedCommInfo().feedskey;
                                                if (TextUtils.isEmpty(createFrom.getFeedCommInfo().feedskey)) {
                                                    b.i("QzoneLikeFeedService", "feeds key is null !!");
                                                } else {
                                                    b.a("QzoneLikeFeedService", "add new feed" + str2);
                                                }
                                                i.H().a(createFrom);
                                                if (list != null) {
                                                    list.add(str2);
                                                }
                                                if (list2 != null) {
                                                    list2.add(createFrom);
                                                }
                                            }
                                            businessFeedData = createFrom;
                                            i19 = i19;
                                        }
                                    }
                                    i19 = i19;
                                } catch (Throwable th9) {
                                    th = th9;
                                }
                            } catch (Throwable th10) {
                                th = th10;
                                i19 = i19;
                                xe.b.f447841a.d(th);
                                i18 = i16 + 1;
                                size = i3;
                                currentTimeMillis = j3;
                            }
                        } catch (Throwable th11) {
                            th = th11;
                            i16 = i18;
                            xe.b.f447841a.d(th);
                            i18 = i16 + 1;
                            size = i3;
                            currentTimeMillis = j3;
                        }
                        i18 = i16 + 1;
                        size = i3;
                        currentTimeMillis = j3;
                    } else {
                        i16 = i18;
                        if (j16 == 1) {
                            i26++;
                            String str3 = single_feedVar.feedskey;
                            if (TextUtils.isEmpty(str3) && (c18 = l.c(single_feedVar.singlefeed)) != null) {
                                str3 = c18.feedskey;
                            }
                            if (!TextUtils.isEmpty(str3)) {
                                if (list != null) {
                                    list.add(str3);
                                }
                                b.a("QzoneLikeFeedService", "merge feed" + str3);
                                BusinessFeedData feedDataByFeedsKey = this.mFeedDataManager.getFeedDataByFeedsKey(str3);
                                if (!shouldFilterAppAdv(feedDataByFeedsKey)) {
                                    if (feedDataByFeedsKey != null) {
                                        try {
                                            logInfo("start merge feed --> " + str3, false);
                                            feedDataByFeedsKey.mergeFeedData(single_feedVar);
                                        } catch (Throwable th12) {
                                            th = th12;
                                            xe.b.f447841a.d(th);
                                            i18 = i16 + 1;
                                            size = i3;
                                            currentTimeMillis = j3;
                                        }
                                    }
                                    businessFeedData = feedDataByFeedsKey;
                                }
                            }
                            businessFeedData = null;
                        } else {
                            if (j16 == 3) {
                                i27++;
                                String str4 = single_feedVar.feedskey;
                                if (TextUtils.isEmpty(str4) && (c17 = l.c(single_feedVar.singlefeed)) != null) {
                                    str4 = c17.feedskey;
                                }
                                if (!TextUtils.isEmpty(str4)) {
                                    this.mFeedDataManager.deleteByFeedsKey(str4);
                                    try {
                                        logInfo("deleted a feed --> " + str4, false);
                                    } catch (Throwable th13) {
                                        th = th13;
                                        xe.b.f447841a.d(th);
                                        i18 = i16 + 1;
                                        size = i3;
                                        currentTimeMillis = j3;
                                    }
                                }
                            } else if (j16 == 2) {
                                i28++;
                                String str5 = single_feedVar.feedskey;
                                if (TextUtils.isEmpty(str5) && (c16 = l.c(single_feedVar.singlefeed)) != null) {
                                    str5 = c16.feedskey;
                                }
                                if (!TextUtils.isEmpty(str5)) {
                                    if (list != null) {
                                        list.add(str5);
                                    }
                                    try {
                                        logInfo("same feed --> " + str5, false);
                                        BusinessFeedData feedDataByFeedsKey2 = this.mFeedDataManager.getFeedDataByFeedsKey(str5);
                                        if (feedDataByFeedsKey2 == null || str == null || !str.equals(feedDataByFeedsKey2.attachInfo)) {
                                            businessFeedData = feedDataByFeedsKey2;
                                        }
                                    } catch (Throwable th14) {
                                        th = th14;
                                        xe.b.f447841a.d(th);
                                        i18 = i16 + 1;
                                        size = i3;
                                        currentTimeMillis = j3;
                                    }
                                }
                            } else {
                                i29++;
                            }
                            businessFeedData = null;
                        }
                        i18 = i16 + 1;
                        size = i3;
                        currentTimeMillis = j3;
                    }
                    if (businessFeedData != null) {
                        try {
                            businessFeedData.attachInfo = str;
                            replaceVideoInfoIfNecessary(businessFeedData);
                            try {
                                dyeBusinessFeedDataIfNecessary(z16, businessFeedData);
                                arrayList2.add(businessFeedData);
                                if (needSaveToDb(businessFeedData)) {
                                    try {
                                        list3.add(businessFeedData);
                                    } catch (Throwable th15) {
                                        th = th15;
                                        xe.b.f447841a.d(th);
                                        i18 = i16 + 1;
                                        size = i3;
                                        currentTimeMillis = j3;
                                    }
                                }
                            } catch (Throwable th16) {
                                th = th16;
                                xe.b.f447841a.d(th);
                                i18 = i16 + 1;
                                size = i3;
                                currentTimeMillis = j3;
                            }
                            try {
                                businessFeedData.hasHighFive = false;
                                businessFeedData.isFakeHighFive = false;
                            } catch (Throwable th17) {
                                th = th17;
                                xe.b.f447841a.d(th);
                                i18 = i16 + 1;
                                size = i3;
                                currentTimeMillis = j3;
                            }
                        } catch (Throwable th18) {
                            th = th18;
                            xe.b.f447841a.d(th);
                            i18 = i16 + 1;
                            size = i3;
                            currentTimeMillis = j3;
                        }
                        i18 = i16 + 1;
                        size = i3;
                        currentTimeMillis = j3;
                    }
                    i18 = i16 + 1;
                    size = i3;
                    currentTimeMillis = j3;
                }
            } else {
                j3 = currentTimeMillis;
                i3 = size;
                i16 = i18;
                i17 = i29;
            }
            i29 = i17;
            i18 = i16 + 1;
            size = i3;
            currentTimeMillis = j3;
        }
        b.a("FeedCost", "decode wup data cost : " + (System.currentTimeMillis() - currentTimeMillis));
        logInfo("DataPiceNum:" + this.mDataPieceSeqNum + "--> ALL: " + arrayList.size() + "| NewCount: " + i19 + "| UpdateCount: " + i26 + "| DeleteCount: " + i27 + "| SameCount:" + i28 + "| OtherCount:" + i29, true);
        return arrayList2;
    }

    void updateNewFeedsCount() {
        int currentFeedsCount = this.mFeedDataManager.getCurrentFeedsCount() - this.mInitialFeedsCount;
        if (currentFeedsCount <= 0) {
            currentFeedsCount = this.mNewFeedsCount;
        }
        this.mNewFeedsCount = currentFeedsCount;
    }

    public void clearAllCache(long j3) {
        Message obtain = Message.obtain();
        obtain.what = 665;
        obtain.arg1 = 1;
        obtain.obj = Long.valueOf(j3);
        this.mFeedHandler.sendMessage(Message.obtain());
    }

    void handleResponseDatas(boolean z16, ArrayList<single_feed> arrayList, List<String> list, List<BusinessFeedData> list2, String str) {
        ArrayList<BusinessFeedData> arrayList2 = new ArrayList<>();
        ArrayList<BusinessFeedData> transformFeedData = transformFeedData(z16, arrayList, list, list2, arrayList2, str);
        this.mFeedTimeInfo.b(2);
        if (z16) {
            this.mFeedDataManager.clearDBCache();
            logInfo("handleResponseDatas deleteDB", true);
        }
        preloadFeedData(transformFeedData);
        this.mFeedDataManager.saveOrUpdateServerResponse(transformFeedData, arrayList2);
        this.mFeedTimeInfo.b(3);
    }

    void onFeedDataChange(List<BusinessFeedData> list, boolean z16, boolean z17, boolean z18, int i3) {
        this.mDataChangedListener.v(list, z16, z17, z18, i3);
    }

    void onReponseFailed(u uVar, s sVar) {
        sVar.setSucceed(false);
        Bundle bundle = getBundle(sVar);
        bundle.putBoolean("end_refreshing", true);
        bundle.putBoolean("hasMore", hasMore());
        sVar.setData(bundle);
        uVar.a(sVar);
        onResponseFinish();
    }

    void resetState() {
        this.mDataPieceSeqNum = 0;
        this.mIsLoadingMore = false;
        this.mIsLoadingMoreUp = false;
        this.mIsFriendFeedLoadingMoreUp = false;
        this.mIsRefreshing = false;
        this.mIsLoadingData = false;
        this.mFeedsPublicInfo = null;
        this.mInitialFeedsCount = 0;
        this.mGetMoreTaskReference = null;
        this.mLoadMoreUpTaskReference = null;
        this.mRefreshTaskReference = null;
        this.mStartRequestTime = 0L;
    }

    private void filterDeletedFakeFeed(List<BusinessFeedData> list) {
        if (list == null || list.size() <= 0) {
            return;
        }
        ArrayList<String> arrayList = new ArrayList<>();
        Iterator<BusinessFeedData> it = list.iterator();
        while (it.hasNext()) {
            BusinessFeedData next = it.next();
            if (shouldFilterDeletedFakeFeed(next)) {
                if (next.getFeedCommInfoV2() != null) {
                    arrayList.add(next.getFeedCommInfoV2().clientkey);
                }
                it.remove();
            }
        }
        if (arrayList.size() <= 0 || this.mFeedDataManager == null) {
            return;
        }
        this.mFeedDataManager.deleteFakeFeedByClientKey(arrayList);
    }

    private void handleCanvasAdError(BusinessFeedData businessFeedData, int i3) {
        int i16;
        String str;
        if (businessFeedData != null && businessFeedData.getCellCanvas() != null && businessFeedData.getCellCanvas().canvasData != null) {
            str = businessFeedData.getCellCanvas().canvasData;
            i16 = str.length();
        } else {
            i16 = 0;
            str = "";
        }
        b.c(TAG, "handleCanvasAdError json string = " + str);
        HashMap hashMap = new HashMap();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("json_length", i16);
            if (businessFeedData != null) {
                int i17 = businessFeedData.feedType;
                if (i17 == 4097) {
                    jSONObject.put("scene", 1);
                } else if (i17 == 2) {
                    jSONObject.put("scene", 2);
                }
            }
        } catch (JSONException unused) {
            b.c(TAG, "handleCanvasAdError JSONException");
        }
        hashMap.put(1, jSONObject.toString());
        i.H().B(7, 54, 26, System.currentTimeMillis(), hashMap, businessFeedData, i3, 0);
    }

    protected static boolean isListEmpty(List<?> list) {
        return list == null || list.size() <= 0;
    }

    static boolean isNoUpdate(mobile_feeds_piece_public mobile_feeds_piece_publicVar) {
        return mobile_feeds_piece_publicVar != null && mobile_feeds_piece_publicVar.no_update == 1;
    }

    public void addFakeFeed(BusinessFeedData businessFeedData) {
        d dVar;
        if (businessFeedData == null || (dVar = this.mFakeFeedLogic) == null) {
            return;
        }
        dVar.w(businessFeedData);
    }

    void clearAttachInfoByOneCommit(ArrayList<String> arrayList) {
        if (arrayList == null || arrayList.size() <= 0) {
            return;
        }
        SharedPreferences.Editor edit = getAttachInfoPreferences().edit();
        Iterator<String> it = arrayList.iterator();
        while (it.hasNext()) {
            String next = it.next();
            if (!TextUtils.isEmpty(next)) {
                logInfo("clearAttachInfo key:" + next + "_" + this.mOwnerUin + "_" + this.mLikeFeedType, true);
                StringBuilder sb5 = new StringBuilder();
                sb5.append(next);
                sb5.append("_");
                sb5.append(this.mOwnerUin);
                sb5.append("_");
                sb5.append(this.mLikeFeedType);
                edit.remove(sb5.toString());
            }
        }
        edit.commit();
        arrayList.clear();
    }

    void deleteFakeFeedsIfNecessary(List<BusinessFeedData> list) {
        if (list != null) {
            ArrayList<String> arrayList = new ArrayList<>();
            ArrayList<String> arrayList2 = new ArrayList<>();
            ArrayList<String> arrayList3 = new ArrayList<>();
            for (BusinessFeedData businessFeedData : list) {
                if (businessFeedData != null) {
                    arrayList.add(businessFeedData.getFeedCommInfo().clientkey);
                    arrayList2.add(businessFeedData.getFeedCommInfo().ugckey);
                    if (com.qzone.proxy.feedcomponent.util.f.b(businessFeedData)) {
                        arrayList3.add(businessFeedData.getCellLuckyMoney().luckyMoneyPayId);
                    }
                }
            }
            this.mFeedDataManager.deleteFakeFeedByClientKey(arrayList);
            this.mFeedDataManager.deleteFakeFeedByUgcKey(arrayList2);
            this.mFeedDataManager.deleteFakeDataSpecialFeed(arrayList3);
        }
    }

    void handleClearCache(boolean z16, long j3) {
        if (z16) {
            this.mFeedDataManager.clearCache();
        } else {
            this.mFeedDataManager.clearCache(j3);
        }
        clearAllAttachInfo();
        onFeedDataChange(this.mFeedDataManager.getCurrentUIDatas(), false, false, false);
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        try {
            RFWLog.d("request_feedx", RFWLog.USR, "handleMessage:" + message.what);
        } catch (Exception e16) {
            logError(Log.getStackTraceString(e16), true);
            int i3 = message.what;
            if (i3 == 660) {
                onBuildRequestException((t) ((Object[]) message.obj)[0], 899902);
            } else if (i3 == WHAT_GET_MORE_FEED) {
                onBuildRequestException((t) ((Object[]) message.obj)[0], 899903);
            }
        }
        switch (message.what) {
            case 660:
                handleRequestMsg(message, 0);
                return true;
            case 661:
                handleQueryInitData(true);
                return true;
            case WHAT_GET_MORE_FEED /* 662 */:
                handleRequestMsg(message, 1);
                return true;
            case WHAT_LOAD_DATA /* 663 */:
                handleRequestMsg(message, 2);
                return true;
            case 664:
                handleClose();
                return true;
            case 665:
                if (message.arg1 != 1) {
                    handleClearCache(true, 0L);
                } else {
                    handleClearCache(false, ((Long) message.obj).longValue());
                }
                return true;
            case 666:
                ResponseInfo responseInfo = (ResponseInfo) message.obj;
                if (responseInfo != null) {
                    onLoadDataResponse(responseInfo.task, responseInfo.result, responseInfo.response);
                    ResponseInfo.recycle(responseInfo);
                }
                return true;
            case 667:
                ResponseInfo responseInfo2 = (ResponseInfo) message.obj;
                if (responseInfo2 != null) {
                    onResponseSuccess(responseInfo2.task, responseInfo2.result, responseInfo2.response, responseInfo2.isRefresh, responseInfo2.isLoadMoreUp);
                    ResponseInfo.recycle(responseInfo2);
                } else {
                    b.c(TAG, "WHAT_ON_RSP_SUCCESS info is null !!");
                }
                return true;
            case WHAT_PRE_DECODE_LOCAL_IMAGE /* 668 */:
            case WHAT_SET_LOCAL_TEST_DATA /* 671 */:
            default:
                return false;
            case WHAT_REPORT_APP_INSTALLED /* 669 */:
                Object obj = message.obj;
                if (obj instanceof BusinessFeedData) {
                    handleReportAppInstalled((BusinessFeedData) obj, message.arg1 != 0);
                    b.i(TAG, " handleReportAppInstalled");
                }
                return true;
            case 670:
                this.mFeedDataManager.preDownloadFeedsPernalizeDiamondImage(message.arg1, message.arg2);
                return true;
            case WHAT_LOAD_MORE_UP_FEED /* 672 */:
                handleRequestMsg(message, 3);
                return true;
            case WHAT_CANVAS_AD_DATA_ERROR_REPORT /* 673 */:
                Object obj2 = message.obj;
                if (obj2 instanceof BusinessFeedData) {
                    handleCanvasAdError((BusinessFeedData) obj2, message.arg1);
                }
                return true;
            case WHAT_PRE_DOWNLOAD_PERNALIZED_PASSIVE_IMAGE /* 674 */:
                this.mFeedDataManager.preDownloadFeedsPernalizePassivePraise(message.arg1, message.arg2);
                return true;
            case WHAT_PRE_DOWNLOAD_PERNALIZED_CUSTOM_TRAKE /* 675 */:
                this.mFeedDataManager.preloadDownloadFeedsCustomTrack(message.arg1, message.arg2);
                b.i(TAG, " handleCUSTOM_TRAKEPRELOAD");
                return true;
            case WHAT_FRIEND_FEED_LOAD_MORE_UP_FEED /* 676 */:
                handleRequestMsg(message, 4);
                return true;
        }
    }

    /* JADX WARN: Type inference failed for: r13v0 */
    /* JADX WARN: Type inference failed for: r13v1, types: [boolean] */
    /* JADX WARN: Type inference failed for: r13v2 */
    public void handleQueryInitData(boolean z16) {
        BusinessFeedData businessFeedData;
        Iterator<BusinessFeedData> it;
        int i3;
        i.H().N2("handleQueryInitData");
        b.c(TAG_INIT, "handleQueryInitData.start:" + this.isActiveFeed + ":" + (System.currentTimeMillis() - this.time));
        if (xe.b.f447841a.h()) {
            b.c(TAG_INIT, "crash protect, disable feed cache");
            return;
        }
        if (this.isActiveFeed && i.H().z1() != null) {
            i.H().z1().b(System.currentTimeMillis() / 1000, i.H().j0());
            i.H().z1().a(FeedGlobalEnv.getContext().getFilesDir().getPath());
        }
        ArrayList arrayList = new ArrayList();
        int refreshFeedSize = getRefreshFeedSize();
        String refreshFeedKey = getRefreshFeedKey();
        int preloadActivityId = FeedDataCache.getPreloadActivityId();
        ?? r132 = 1;
        try {
            try {
                List<BusinessFeedData> restoreLastUIDatas = this.mFeedDataManager.restoreLastUIDatas(refreshFeedKey, refreshFeedSize);
                StringBuilder sb5 = new StringBuilder();
                sb5.append("handleQueryInitData lastUIDatas:");
                sb5.append(restoreLastUIDatas != null ? restoreLastUIDatas.size() : 0);
                logInfo(sb5.toString(), true);
                if (restoreLastUIDatas != null) {
                    ArrayList arrayList2 = new ArrayList();
                    Iterator<BusinessFeedData> it5 = restoreLastUIDatas.iterator();
                    int i16 = 0;
                    while (it5.hasNext()) {
                        BusinessFeedData next = it5.next();
                        if (next != null) {
                            if (z16) {
                                next.preCalculate(i16 > r132 ? r132 : false);
                                next.hasCalculate = r132;
                            }
                            if (next.needCalculateFeedView()) {
                                FeedViewSection.FeedViewOptions feedViewOptions = new FeedViewSection.FeedViewOptions();
                                feedViewOptions.isPreGenerateView = r132;
                                businessFeedData = next;
                                it = it5;
                                i3 = i16;
                                FeedViewBuilder.setFeedDataInternal(FeedGlobalEnv.g().getPluginContext(), ViewLoader.getInstance().obtianFeedView(FeedGlobalEnv.g().getPluginContext(), null, false, false, preloadActivityId), businessFeedData, feedViewOptions);
                            } else {
                                businessFeedData = next;
                                it = it5;
                                i3 = i16;
                            }
                            arrayList.add(businessFeedData.getUser());
                            BusinessFeedData originalInfo = businessFeedData.getOriginalInfo();
                            if (originalInfo != null) {
                                arrayList.add(originalInfo.getUser());
                            }
                        } else {
                            businessFeedData = next;
                            it = it5;
                            i3 = i16;
                        }
                        if (i3 < 2) {
                            arrayList2.add(businessFeedData);
                        }
                        if (businessFeedData != null && businessFeedData.isBrandUgcAdvFeeds()) {
                            businessFeedData.getOperationInfoV2().hasReportExposure = 0;
                            businessFeedData.getOperationInfoV2().IsVideoPlayExpose = 0;
                        }
                        if (i3 == 1) {
                            b.i(TAG_INIT, "notifyFeedDataChange start");
                            onFeedDataChange(arrayList2, false, false, false);
                        }
                        i16 = i3 + 1;
                        it5 = it;
                        r132 = 1;
                    }
                    DataPreCalculateTool.isFirstPageFeed = false;
                    QzoneCustomPraiseService.i().o(getOwnerUin());
                    QzoneExendFeedCustomPraiseService.i().l(getOwnerUin());
                    QzonePolymorphicPraiseService.getInstance().refreshLocalCache(getOwnerUin());
                    onFeedDataChange(restoreLastUIDatas, false, false, false);
                    updateCertificationJumpInfo(arrayList);
                    SharedPreferences.Editor edit = getAttachInfoPreferences().edit();
                    saveGlobalAttachInfo(getAttachInfo(KEY_REFRESH_ATTACH_INFO), edit);
                    saveTlvAttachInfo(getAttachInfo(KEY_REFRESH_TLV_ATTACH_INFO), edit);
                    edit.commit();
                    preloadFeedData((ArrayList) restoreLastUIDatas);
                }
            } catch (Exception e16) {
                logError(e16.getMessage(), true);
            }
            ViewLoader.getInstance().recyleFeedView(false, preloadActivityId);
            b.c(TAG_INIT, "handleQueryInitData.end:" + this.isActiveFeed + "," + (System.currentTimeMillis() - this.time));
            i.H().I2("handleQueryInitData");
        } catch (Throwable th5) {
            ViewLoader.getInstance().recyleFeedView(false, preloadActivityId);
            throw th5;
        }
    }

    void handleRefreshAttachInfo(boolean z16, String str, String str2, List<BusinessFeedData> list) {
        BusinessFeedData businessFeedData;
        if (z16) {
            try {
                ArrayList arrayList = new ArrayList();
                if (list != null) {
                    arrayList.addAll(list);
                }
                int size = arrayList.size() - 1;
                while (true) {
                    if (size < 0) {
                        businessFeedData = null;
                        break;
                    }
                    businessFeedData = (BusinessFeedData) arrayList.get(size);
                    if (needSaveToDb(businessFeedData)) {
                        break;
                    } else {
                        size--;
                    }
                }
                saveRefreshAttachInfo(str, str2, businessFeedData != null ? businessFeedData.getFeedCommInfo().feedskey : null);
            } catch (Exception e16) {
                b.i(TAG, "handleRefreshAttachInfo:" + e16.toString());
            }
        }
    }

    void logError(String str, boolean z16) {
        if (z16) {
            b.c(TAG, "type:" + this.mLikeFeedType + "::" + str);
        }
    }

    void logInfo(String str, boolean z16) {
        if (z16) {
            b.e(TAG_TIME, "type:" + this.mLikeFeedType + "::" + str);
        }
    }

    @Override // com.qzone.proxy.feedcomponent.manager.c
    public void onFeedPartionUpdate(List<BusinessFeedData> list) {
        if (list == null || list.size() <= 0) {
            return;
        }
        onFeedDataPartionChange(this.mFeedDataManager.getCurrentUIDatas(), list);
    }

    @Override // com.qzone.proxy.feedcomponent.manager.c
    public void onFeedUpdate(BusinessFeedData businessFeedData, boolean z16) {
        if (z16) {
            onDataChange();
        }
    }

    void putValue(SharedPreferences.Editor editor, String str, Object obj) {
        boolean z16;
        if (editor == null) {
            editor = getAttachInfoPreferences().edit();
            z16 = true;
        } else {
            z16 = false;
        }
        if (obj instanceof Boolean) {
            editor.putBoolean(str, ((Boolean) obj).booleanValue());
        } else if (obj instanceof String) {
            editor.putString(str, (String) obj);
        } else if (obj instanceof Integer) {
            editor.putInt(str, ((Integer) obj).intValue());
        } else if (obj instanceof Long) {
            editor.putLong(str, ((Long) obj).longValue());
        } else if (obj instanceof Float) {
            editor.putFloat(str, ((Float) obj).floatValue());
        }
        if (z16) {
            editor.commit();
        }
    }

    public void reportHouBuDcDC02082(BusinessFeedData businessFeedData) {
        CellRecommAction recommAction;
        if (businessFeedData == null || !businessFeedData.isGDTAdvFeed() || (recommAction = businessFeedData.getRecommAction()) == null) {
            return;
        }
        String str = recommAction.alternate_ad_identification;
        int i3 = recommAction.advPos;
        int i16 = recommAction.multiAdvOffset;
        b.e(TAG, "reportHouBuDcDC02082 in feedPrj houBuReportValue:" + str + " advPos:" + i3 + " offSet:" + i16 + " uin:" + this.mUin + " force_id:" + businessFeedData.getOperationInfoV2().cookie.get(9));
        if (TextUtils.isEmpty(str)) {
            return;
        }
        ArrayList<Map<String, String>> arrayList = new ArrayList<>();
        HashMap hashMap = new HashMap();
        hashMap.put("uin", Long.toString(this.mUin));
        hashMap.put("op_timestamp", Long.toString(System.currentTimeMillis()));
        hashMap.put("adv_pos", Integer.toString(i3));
        if (businessFeedData.getOperationInfoV2() != null && businessFeedData.getOperationInfoV2().cookie != null) {
            hashMap.put("force_id", businessFeedData.getOperationInfoV2().cookie.get(9));
        }
        hashMap.put("multi_offset", Integer.toString(i16));
        hashMap.put(ServiceConst.PARA_SESSION_ID, str);
        hashMap.put("report_scene", Integer.toString(4));
        arrayList.clear();
        arrayList.add(hashMap);
        i.H().b2(arrayList, null);
    }

    void sendFakeResponse(t tVar, int i3, String str, int i16) {
        if (tVar != null) {
            s B1 = i.H().B1(i16);
            Bundle bundle = getBundle(B1);
            bundle.putBoolean("end_refreshing", true);
            bundle.putBoolean("hasMore", hasMore());
            B1.setReturnCode(i3);
            B1.setSucceed(i3 == 0);
            B1.setFailReason(str);
            B1.setData(bundle);
            tVar.d(B1);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [int, boolean] */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v6 */
    boolean shouldFilterAppAdv(BusinessFeedData businessFeedData) {
        String str = (businessFeedData == null || businessFeedData.getOperationInfoV2() == null) ? null : businessFeedData.getOperationInfoV2().appid;
        ?? r16 = 0;
        r16 = 0;
        r16 = 0;
        r16 = 0;
        r16 = 0;
        if (businessFeedData == null) {
            return false;
        }
        if (businessFeedData.isGDTAdvFeed() && TextUtils.isEmpty(str)) {
            return isShoudFilterAd(businessFeedData);
        }
        if (businessFeedData.getFeedCommInfo().isAppAdvFeed() && !TextUtils.isEmpty(str)) {
            FeedGlobalEnv g16 = FeedGlobalEnv.g();
            FeedGlobalEnv.g();
            boolean checkHasInstallPackage = g16.checkHasInstallPackage(FeedGlobalEnv.getContext(), str);
            if (businessFeedData.isGDTAdvFeed() && businessFeedData.getFeedCommInfoV2() != null && businessFeedData.getFeedCommInfoV2().stMapABTest != null && businessFeedData.getFeedCommInfoV2().stMapABTest.containsKey(3) && businessFeedData.getFeedCommInfoV2().stMapABTest.get(3).intValue() == 1) {
                r16 = 1;
            }
            b.a(TAG, "transformFeedData, adv packagename " + str + "is installed = " + checkHasInstallPackage + ", filterAdv = " + ((boolean) r16));
            if (!checkHasInstallPackage) {
                return isShoudFilterAd(businessFeedData);
            }
            if (r16 != 0) {
                Message obtain = Message.obtain();
                obtain.what = WHAT_REPORT_APP_INSTALLED;
                obtain.obj = businessFeedData;
                obtain.arg1 = r16;
                this.mFeedHandler.sendMessage(obtain);
                return true;
            }
            return isShoudFilterAd(businessFeedData);
        }
        if (businessFeedData.isBrandUgcAdvFeeds()) {
            return isShoudFilterAd(businessFeedData);
        }
        if (!businessFeedData.isGDTAdvFeed()) {
            this.mCurrentAdvPos = -1;
            this.isEffectiveAdvJump = false;
        }
        return false;
    }

    public boolean shouldFilterCanvasAd(BusinessFeedData businessFeedData, int i3) {
        CellCanvas cellCanvas;
        if (businessFeedData == null || !businessFeedData.isCanvasAd() || (cellCanvas = businessFeedData.getCellCanvas()) == null || !cellCanvas.jsonDataParseError()) {
            return false;
        }
        Message obtain = Message.obtain();
        obtain.what = WHAT_CANVAS_AD_DATA_ERROR_REPORT;
        obtain.obj = businessFeedData;
        obtain.arg1 = i3;
        Handler handler = this.mFeedHandler;
        if (handler != null) {
            handler.sendMessage(obtain);
        }
        return true;
    }

    @Override // com.qzone.proxy.feedcomponent.manager.f
    public void updateData(BusinessFeedData businessFeedData, boolean z16) {
        if (businessFeedData == null || this.mFeedDataManager == null || !this.mFeedDataManager.updateFeedData(businessFeedData) || !z16) {
            return;
        }
        onDataChange();
    }

    public static boolean shouldFilterDeletedFakeFeed(BusinessFeedData businessFeedData) {
        CopyOnWriteArrayList<String> copyOnWriteArrayList;
        if (businessFeedData != null && businessFeedData.getFeedCommInfoV2() != null && (copyOnWriteArrayList = sDeletedFakeFeedClientKey) != null && copyOnWriteArrayList.size() > 0) {
            String str = businessFeedData.getFeedCommInfoV2().clientkey;
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            Iterator<String> it = sDeletedFakeFeedClientKey.iterator();
            while (it.hasNext()) {
                String next = it.next();
                if (!TextUtils.isEmpty(next) && str.equals(next)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean isShoudFilterAd(BusinessFeedData businessFeedData) {
        CellRecommAction recommAction;
        if (businessFeedData == null || (recommAction = businessFeedData.getRecommAction()) == null) {
            return false;
        }
        b.i(TAG, "isShoudFilterAd currentPos:" + recommAction.advPos + " offSet:" + recommAction.multiAdvOffset);
        int i3 = recommAction.advPos;
        if (!this.isEffectiveAdvJump) {
            this.mCurrentAdvPos = i3;
            this.isEffectiveAdvJump = true;
            return false;
        }
        if (this.mCurrentAdvPos == i3) {
            return true;
        }
        this.mCurrentAdvPos = i3;
        return false;
    }

    boolean needSaveToDb(BusinessFeedData businessFeedData) {
        if (businessFeedData == null || businessFeedData.isQQLiveFeed() || businessFeedData.isFriendAnniversaryFeed()) {
            return false;
        }
        return !businessFeedData.getFeedCommInfo().isNotSortTimeFeed() || businessFeedData.getFeedCommInfo().isTopFeed() || this.mLikeFeedType == 1;
    }

    void onReceiveSingleFeedPiece(com.qzone.adapter.feedcomponent.c cVar, boolean z16) {
        String str;
        this.mDataPieceSeqNum++;
        if (this.mDataPieceSeqNum == 1) {
            this.env.e(cVar, z16);
        }
        if (cVar.f() instanceof mobile_feeds_piece_list) {
            mobile_feeds_piece_list mobile_feeds_piece_listVar = (mobile_feeds_piece_list) cVar.f();
            if (mobile_feeds_piece_listVar != null) {
                mobile_feeds_piece_public mobile_feeds_piece_publicVar = this.mFeedsPublicInfo;
                if (mobile_feeds_piece_publicVar != null) {
                    saveGlobalAttachInfo(mobile_feeds_piece_publicVar.attach_info, null);
                    str = mobile_feeds_piece_publicVar.attach_info;
                } else {
                    logInfo("onReceiveSingleFeedPiece publicInfo is Null!", true);
                    str = null;
                }
                ArrayList<single_feed> arrayList = mobile_feeds_piece_listVar.all_feeds_data;
                if (arrayList != null) {
                    ArrayList arrayList2 = new ArrayList();
                    ArrayList arrayList3 = new ArrayList();
                    handleResponseDatas(z16, arrayList, arrayList2, arrayList3, str);
                    if (z16 && this.mDataPieceSeqNum == 1) {
                        deleteFakeFeedsIfNecessary(arrayList3);
                        this.mFeedDataManager.deleteInvalidFakeFeed();
                        this.mFeedDataManager.clearMemorCache(false);
                    } else {
                        deleteFakeFeedsIfNecessary(arrayList3);
                    }
                    List<BusinessFeedData> loadMore = this.mFeedDataManager.loadMore(arrayList2, z16);
                    if (!cVar.k()) {
                        this.env.j(cVar, z16, 2);
                    }
                    handleRefreshAttachInfo(z16, str, mobile_feeds_piece_listVar.tlv_attach_info, loadMore);
                    onFeedDataChange(loadMore, true, this.mDataPieceSeqNum == 1, !cVar.k(), z16 ? 1 : 2);
                    saveTlvAttachInfo(mobile_feeds_piece_listVar.tlv_attach_info, null);
                    return;
                }
                return;
            }
            b.i(TAG, "onReceiveSingleFeedPiece() feedsPieceList == null resp=" + cVar.f());
            return;
        }
        b.c(TAG, "onReceiveSingleFeedPiece() piece is not valid, resp=" + cVar.f());
    }

    void saveAttachInfo(String str, int i3, SharedPreferences.Editor editor) {
        logInfo("saveAttachInfo key:" + str + "_" + this.mOwnerUin + "_" + this.mLikeFeedType + ",size:" + i3 + "--preferences:" + getAttachInfoPreferences(), true);
        StringBuilder sb5 = new StringBuilder();
        sb5.append(str);
        sb5.append("_");
        sb5.append(this.mOwnerUin);
        sb5.append("_");
        sb5.append(this.mLikeFeedType);
        putValue(editor, sb5.toString(), new Integer(i3));
    }

    void onNormalResponse(u uVar, s sVar, com.qzone.adapter.feedcomponent.c cVar, boolean z16, boolean z17) {
        IResult iResult;
        String str;
        JceStruct jceStruct;
        List<BusinessFeedData> loadMore;
        String str2;
        boolean z18;
        traceStart(z16, ON_NORMAL_RESPONSE);
        SharedPreferences.Editor edit = getAttachInfoPreferences().edit();
        clearTlvAttachInfoByNotCommit(edit);
        Bundle bundle = getBundle(sVar);
        JceStruct d16 = cVar.d();
        DittoUIEngine.g().updateLayoutFile(cVar.e());
        if (d16 == null) {
            iResult = sVar;
            str = ON_NORMAL_RESPONSE;
        } else {
            int o16 = cVar.o();
            this.mNextPageSize = o16;
            DittoUIEngine.g().clearRichTextAreaCache();
            this.env.h(cVar.g() == 1);
            if (cVar.m() == 1) {
                str = ON_NORMAL_RESPONSE;
                jceStruct = d16;
                logInfo("no update (autoLoad:" + cVar.a() + " |Softctrl:" + cVar.g() + " |refresh:" + z16 + "| reqCount:" + o16 + ") ", true);
                this.env.d(z16);
                iResult = sVar;
                iResult.setSucceed(false);
                bundle.putBoolean("hasMore", hasMore());
                String n3 = cVar.n();
                if (!TextUtils.isEmpty(n3)) {
                    QQToastUtil.showQQToastInUiThread(0, n3);
                }
            } else {
                ArrayList<single_feed> b16 = cVar.b();
                if (b16 == null) {
                    str = ON_NORMAL_RESPONSE;
                    jceStruct = d16;
                    logInfo("received feedData is empty (autoLoad:" + cVar.a() + " |Softctrl:" + cVar.g() + " |refresh:" + z16 + "| reqCount:" + o16 + ") ", true);
                } else {
                    if (z16 && !this.mIsSupportIncrementUpdate) {
                        this.mFeedDataManager.clearCache2Refresh();
                    }
                    if (z16 && g.f53821a.b().k()) {
                        a.a().clearAllData();
                    }
                    ArrayList arrayList = new ArrayList();
                    ArrayList arrayList2 = new ArrayList();
                    String c16 = cVar.c();
                    str = ON_NORMAL_RESPONSE;
                    traceStart(z16, HANDLE_RESPONSE_DATAS);
                    jceStruct = d16;
                    handleResponseDatas(z16, b16, arrayList, arrayList2, c16);
                    traceEnd(z16, HANDLE_RESPONSE_DATAS);
                    if (z16) {
                        deleteFakeFeedsIfNecessary(arrayList2);
                        this.mFeedDataManager.clearMemorCache(false);
                        this.mFeedDataManager.deleteInvalidFakeFeed();
                    } else {
                        deleteFakeFeedsIfNecessary(arrayList2);
                    }
                    if (z17) {
                        traceStart(z16, LOAD_MORE_UP);
                        loadMore = this.mFeedDataManager.loadMoreUp(arrayList);
                        traceEnd(z16, LOAD_MORE_UP);
                    } else {
                        traceStart(z16, LOAD_MORE);
                        loadMore = this.mFeedDataManager.loadMore(arrayList, z16);
                        if (z16) {
                            deleteAbnormalFakeFeedWhenRefresh(loadMore);
                            filterDeletedFakeFeed(loadMore);
                        }
                        traceEnd(z16, LOAD_MORE);
                    }
                    List<BusinessFeedData> list = loadMore;
                    deleteOverflowFeeds();
                    this.mFeedTimeInfo.b(4);
                    boolean z19 = cVar.j() != 0;
                    saveHasMore(z19, edit);
                    if (z17) {
                        str2 = " |refresh:";
                        z18 = z19;
                        onFeedDataChange(list, false, false, false, 3);
                    } else {
                        str2 = " |refresh:";
                        z18 = z19;
                        onFeedDataChange(list, false, false, false, z16 ? 1 : 2);
                    }
                    String p16 = cVar.p();
                    if (!TextUtils.isEmpty(p16)) {
                        FeedsSidManager.setUserSid(p16);
                    }
                    handleRefreshAttachInfo(z16, c16, null, list);
                    if (z17) {
                        saveGlobalUpAttachInfo(c16, edit);
                    } else {
                        saveGlobalAttachInfo(c16, edit);
                    }
                    bundle.putLong(QZoneResult.KEY_NEWCNT, arrayList2.size());
                    bundle.putBoolean("hasMore", z18);
                    bundle.putInt("gamebar_video_checking_num", cVar.i());
                    logInfo("received " + b16.size() + " data (autoLoad:" + cVar.a() + " |Softctrl:" + cVar.g() + str2 + z16 + " | hasMore:" + z18 + "| reqCount:" + o16 + ") ", true);
                }
                iResult = sVar;
            }
            JceStruct jceStruct2 = jceStruct;
            if (jceStruct2 instanceof mobile_feeds_rsp) {
                mobile_feeds_rsp mobile_feeds_rspVar = (mobile_feeds_rsp) jceStruct2;
                if (mobile_feeds_rspVar.stMapExtendinfo != null) {
                    i.H().s2(mobile_feeds_rspVar.stMapExtendinfo.get(GDT_ADV_COOKIE.value));
                }
            }
        }
        bundle.putBoolean("end_refreshing", true);
        iResult.setData(bundle);
        updateNewFeedsCount();
        if (z16) {
            b.a(TAG, "refresh_feed_size:" + this.mNewFeedsCount);
            saveAttachInfo(KEY_REFRESH_FEED_SIZE, this.mNewFeedsCount, edit);
        }
        edit.commit();
        onResponseFinish();
        uVar.a(sVar);
        traceEnd(z16, str);
    }

    void handleRequestMsg(Message message, int i3) {
        if (i3 != 2) {
            this.mInitialFeedsCount = i3 == 0 ? 0 : this.mFeedDataManager.getCurrentFeedsCount();
        }
        Object[] objArr = (Object[]) message.obj;
        t tVar = (t) objArr[0];
        boolean booleanValue = ((Boolean) objArr[1]).booleanValue();
        if (tVar == null) {
            b.c(TAG, "handleRefreshMessage --> callback is null!");
        }
        u g16 = this.env.g(i3, getRequestOption(i3, booleanValue), tVar, this);
        if (g16 == null || i3 == 2) {
            return;
        }
        if (i3 == 0) {
            this.mRefreshTaskReference = g16;
        } else if (i3 == 3) {
            this.mLoadMoreUpTaskReference = g16;
        } else {
            if (i3 == 4) {
                return;
            }
            this.mGetMoreTaskReference = g16;
        }
    }
}
