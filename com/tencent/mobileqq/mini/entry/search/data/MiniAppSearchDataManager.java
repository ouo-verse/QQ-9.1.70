package com.tencent.mobileqq.mini.entry.search.data;

import NS_COMM.COMM;
import NS_STORE_APP_CLIENT.STORE_APP_CLIENT$StGetGuessYouLikeRsp;
import NS_STORE_APP_CLIENT.STORE_APP_CLIENT$StoreAppInfo;
import NS_STORE_APP_SEARCH.MiniAppSearch$SearchExtInfo;
import NS_STORE_APP_SEARCH.MiniAppSearch$StGetHotSearchAppsRsp;
import NS_STORE_APP_SEARCH.MiniAppSearch$StGetHotSearchAppsV2Rsp;
import NS_STORE_APP_SEARCH.MiniAppSearch$StHotWatching;
import NS_STORE_APP_SEARCH.MiniAppSearch$StSearchAppRsp;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.biz.common.util.g;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.mini.entry.MiniAppUtils;
import com.tencent.mobileqq.mini.entry.search.comm.GuessYouLikeItem;
import com.tencent.mobileqq.mini.entry.search.comm.ItemInfo;
import com.tencent.mobileqq.mini.entry.search.comm.LiveInfo;
import com.tencent.mobileqq.mini.entry.search.comm.RecommendForYouItem;
import com.tencent.mobileqq.mini.entry.search.comm.SearchInfo;
import com.tencent.mobileqq.mini.entry.search.comm.TitleInfo;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdUtil;
import com.tencent.mobileqq.mini.servlet.MiniAppGetHotSearchAppsServlet;
import com.tencent.mobileqq.mini.servlet.MiniAppGetHotSearchAppsV2Servlet;
import com.tencent.mobileqq.mini.servlet.MiniAppGuessYouLikeServlet;
import com.tencent.mobileqq.mini.servlet.MiniAppSearchAppServlet;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import mqq.manager.Manager;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes33.dex */
public class MiniAppSearchDataManager implements Manager {
    public static final int GUESS_YOU_LIKE_COUNT = 4;
    public static final int MAX_HISTORY_SEARCH_NUM = 20;
    private static final String MINI_APP_NATIVE_SEARCH = "mini_app_native_search";
    public static final String TAG = "MiniAppSearchDataManager";
    private List<String> highlightWords;
    private volatile COMM.StCommonExt mExtInfo;
    private HotSearchDataChangedListener mHotSearchDataChangedListener;
    private volatile COMM.StCommonExt mHotSearchExtInfo;
    private HotSearchDataChangedListener mHotSearchV2DataChangedListener;
    private MiniAppSearch$StGetHotSearchAppsV2Rsp mHotSearchV2Rsp;
    private SearchResultDataChangedListener mResultDataChangedListener;
    private volatile String mTitle;
    private List<ItemInfo> mHotSearchList = new ArrayList();
    private List<SearchInfo> mSearchResultList = new ArrayList();
    private LinkedList<String> mHistorySearchList = new LinkedList<>();
    private List<Integer> mSortList = new ArrayList();
    private ConcurrentHashMap<Integer, List<ItemInfo>> mSearchResultMap = new ConcurrentHashMap<>();
    private Object mLock = new Object();
    private volatile boolean isFinished = true;
    private volatile boolean isLoading = false;
    private volatile boolean isNoResult = false;

    /* compiled from: P */
    /* loaded from: classes33.dex */
    public interface HotSearchDataChangedListener {
        void onHotSearchDataChanged();
    }

    /* compiled from: P */
    /* loaded from: classes33.dex */
    public interface SearchResultDataChangedListener {
        void onResultDataChanged();
    }

    private void checkNetwork() {
        if (g.b(BaseApplication.getContext()) || this.mResultDataChangedListener == null) {
            return;
        }
        this.mSearchResultList.clear();
        this.mResultDataChangedListener.onResultDataChanged();
        QLog.d(TAG, 1, "checkNetwork, network not available");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$updateHotSearchDataV2$1() {
        HotSearchDataChangedListener hotSearchDataChangedListener = this.mHotSearchV2DataChangedListener;
        if (hotSearchDataChangedListener != null) {
            hotSearchDataChangedListener.onHotSearchDataChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateSearchResultData(List<STORE_APP_CLIENT$StoreAppInfo> list, List<MiniAppSearch$SearchExtInfo> list2, List<STORE_APP_CLIENT$StoreAppInfo> list3) {
        PBStringField pBStringField;
        if (list == null) {
            QLog.d(TAG, 1, "updateSearchResultData, data is null!");
            return;
        }
        this.isNoResult = false;
        HashMap hashMap = new HashMap();
        if (list2 != null && list2.size() > 0) {
            for (MiniAppSearch$SearchExtInfo miniAppSearch$SearchExtInfo : list2) {
                if (miniAppSearch$SearchExtInfo != null && (pBStringField = miniAppSearch$SearchExtInfo.appid) != null) {
                    hashMap.put(pBStringField.get(), miniAppSearch$SearchExtInfo);
                    QLog.d(TAG, 1, "updateSearchResultData, appid: " + miniAppSearch$SearchExtInfo.appid.get());
                }
            }
        }
        final ArrayList arrayList = new ArrayList();
        for (STORE_APP_CLIENT$StoreAppInfo sTORE_APP_CLIENT$StoreAppInfo : list) {
            if (sTORE_APP_CLIENT$StoreAppInfo != null && sTORE_APP_CLIENT$StoreAppInfo.userAppInfo.get() != null) {
                SearchInfo searchInfo = new SearchInfo(sTORE_APP_CLIENT$StoreAppInfo);
                if (hashMap.get(searchInfo.miniAppInfo.appId) != null) {
                    searchInfo.setSearchExtInfo((MiniAppSearch$SearchExtInfo) hashMap.get(searchInfo.miniAppInfo.appId));
                }
                arrayList.add(searchInfo);
            }
        }
        if (list.isEmpty()) {
            for (STORE_APP_CLIENT$StoreAppInfo sTORE_APP_CLIENT$StoreAppInfo2 : list3) {
                if (sTORE_APP_CLIENT$StoreAppInfo2 != null && sTORE_APP_CLIENT$StoreAppInfo2.userAppInfo.get() != null) {
                    arrayList.add(new RecommendForYouItem(sTORE_APP_CLIENT$StoreAppInfo2));
                }
            }
            this.isNoResult = true;
            QLog.d(TAG, 1, "updateSearchResultData, use recommend list");
        }
        runOnMainThread(new Runnable() { // from class: com.tencent.mobileqq.mini.entry.search.data.MiniAppSearchDataManager.6
            @Override // java.lang.Runnable
            public void run() {
                MiniAppSearchDataManager.this.mSearchResultList.clear();
                MiniAppSearchDataManager.this.mSearchResultList.addAll(arrayList);
                if (MiniAppSearchDataManager.this.mResultDataChangedListener != null) {
                    MiniAppSearchDataManager.this.mResultDataChangedListener.onResultDataChanged();
                }
            }
        });
    }

    public void clearHistorySearch() {
        this.mHistorySearchList.clear();
        AppInterface appInterface = MiniAppUtils.getAppInterface();
        if (appInterface != null) {
            String currentAccountUin = appInterface.getCurrentAccountUin();
            BaseApplication.getContext().getSharedPreferences(currentAccountUin + "_" + MINI_APP_NATIVE_SEARCH, 0).edit().remove(AppConstants.Preferences.KEY_MINI_APP_NATIVE_SEARCH_HISTORY).apply();
        }
    }

    public void clearSearchResult() {
        this.mSearchResultList.clear();
    }

    public List<String> getCachedHistorySearchList() {
        this.mHistorySearchList.clear();
        AppInterface appInterface = MiniAppUtils.getAppInterface();
        if (appInterface != null) {
            String string = BaseApplication.getContext().getSharedPreferences(appInterface.getCurrentAccountUin() + "_" + MINI_APP_NATIVE_SEARCH, 0).getString(AppConstants.Preferences.KEY_MINI_APP_NATIVE_SEARCH_HISTORY, null);
            if (!TextUtils.isEmpty(string)) {
                for (String str : string.split("_")) {
                    if (!TextUtils.isEmpty(str)) {
                        this.mHistorySearchList.add(str);
                    }
                }
            }
        }
        return this.mHistorySearchList;
    }

    public List<String> getHighLightKeywords() {
        return this.highlightWords;
    }

    public List<String> getHistorySearchList() {
        return this.mHistorySearchList;
    }

    public List<ItemInfo> getHotSearchData() {
        return this.mHotSearchList;
    }

    public String getHotSearchTitle() {
        return this.mTitle;
    }

    public MiniAppSearch$StGetHotSearchAppsV2Rsp getHotSearchV2Data() {
        return this.mHotSearchV2Rsp;
    }

    public List<SearchInfo> getSearchResultData() {
        return this.mSearchResultList;
    }

    public boolean isNoResult() {
        return this.isNoResult;
    }

    public void loadMoreSearchAppDataRequest(String str) {
        synchronized (this.mLock) {
            if (!this.isFinished && !this.isLoading) {
                this.isLoading = true;
                COMM.StCommonExt stCommonExt = this.mExtInfo;
                QLog.d(TAG, 1, "loadMoreSearchAppDataRequest, isFinished: " + this.isFinished + ", isLoading: " + this.isLoading + ", keyWord: " + str);
                MiniAppCmdUtil.getInstance().searchApp(stCommonExt, str, new MiniAppCmdInterface() { // from class: com.tencent.mobileqq.mini.entry.search.data.MiniAppSearchDataManager.4
                    @Override // com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface
                    public void onCmdListener(boolean z16, JSONObject jSONObject) {
                        boolean z17 = true;
                        if (z16 && jSONObject != null) {
                            long optLong = jSONObject.optLong("retCode");
                            QLog.d(MiniAppSearchDataManager.TAG, 1, "loadMoreSearchAppRequest, retCode = " + optLong + ", errMsg = " + jSONObject.optString("errMsg"));
                            if (optLong != 0) {
                                return;
                            }
                            MiniAppSearch$StSearchAppRsp miniAppSearch$StSearchAppRsp = (MiniAppSearch$StSearchAppRsp) jSONObject.opt(MiniAppSearchAppServlet.KEY_SEARCH_APP_RSP);
                            if (miniAppSearch$StSearchAppRsp != null) {
                                MiniAppSearchDataManager.this.appendSearchResultData(miniAppSearch$StSearchAppRsp.appList.get());
                                synchronized (MiniAppSearchDataManager.this.mLock) {
                                    MiniAppSearchDataManager miniAppSearchDataManager = MiniAppSearchDataManager.this;
                                    if (miniAppSearch$StSearchAppRsp.isFinished.get() != 1) {
                                        z17 = false;
                                    }
                                    miniAppSearchDataManager.isFinished = z17;
                                    MiniAppSearchDataManager.this.mExtInfo = miniAppSearch$StSearchAppRsp.extInfo.get();
                                }
                            }
                        } else {
                            QLog.e(MiniAppSearchDataManager.TAG, 1, "loadMoreSearchAppRequest, isSuccess = " + z16 + ", ret = " + jSONObject);
                        }
                        synchronized (MiniAppSearchDataManager.this.mLock) {
                            MiniAppSearchDataManager.this.isLoading = false;
                        }
                    }
                });
            }
        }
    }

    public void removeSearchHistory(String str) {
        if (this.mHistorySearchList.contains(str)) {
            this.mHistorySearchList.remove(str);
            updateHistorySearchList(null);
        }
    }

    public void runOnMainThread(Runnable runnable) {
        ThreadManager.getUIHandler().post(runnable);
    }

    public void sendGuessYouLikeRequest() {
        checkNetwork();
        MiniAppCmdUtil.getInstance().guessYouLike(this.mHotSearchExtInfo, 4, new MiniAppCmdInterface() { // from class: com.tencent.mobileqq.mini.entry.search.data.MiniAppSearchDataManager.3
            @Override // com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface
            public void onCmdListener(boolean z16, JSONObject jSONObject) {
                STORE_APP_CLIENT$StGetGuessYouLikeRsp sTORE_APP_CLIENT$StGetGuessYouLikeRsp;
                if (z16 && jSONObject != null) {
                    long optLong = jSONObject.optLong("retCode");
                    QLog.d(MiniAppSearchDataManager.TAG, 1, "sendGuessYouLikeRequest, retCode = " + optLong + ", errMsg = " + jSONObject.optString("errMsg"));
                    if (optLong == 0 && (sTORE_APP_CLIENT$StGetGuessYouLikeRsp = (STORE_APP_CLIENT$StGetGuessYouLikeRsp) jSONObject.opt(MiniAppGuessYouLikeServlet.KEY_SEARCH_GUESS_YOU_LIKE_RSP)) != null) {
                        MiniAppSearchDataManager.this.updateGuessYouLikeData(sTORE_APP_CLIENT$StGetGuessYouLikeRsp.appList.get());
                        return;
                    }
                    return;
                }
                QLog.e(MiniAppSearchDataManager.TAG, 1, "sendGuessYouLikeRequest, isSuccess = " + z16 + ", ret = " + jSONObject);
            }
        });
    }

    public void sendHotSearchAppRequest() {
        MiniAppCmdUtil.getInstance().getHotSearchApps(generateBlacklistFromCurAppList(), new MiniAppCmdInterface() { // from class: com.tencent.mobileqq.mini.entry.search.data.MiniAppSearchDataManager.1
            @Override // com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface
            public void onCmdListener(boolean z16, JSONObject jSONObject) {
                if (z16 && jSONObject != null) {
                    long optLong = jSONObject.optLong("retCode");
                    QLog.d(MiniAppSearchDataManager.TAG, 1, "sendHotSearchAppRequest, retCode = " + optLong + ", errMsg = " + jSONObject.optString("errMsg"));
                    if (optLong != 0) {
                        return;
                    }
                    MiniAppSearch$StGetHotSearchAppsRsp miniAppSearch$StGetHotSearchAppsRsp = (MiniAppSearch$StGetHotSearchAppsRsp) jSONObject.opt(MiniAppGetHotSearchAppsServlet.KEY_GET_HOT_SEARCH_APPS_RSP);
                    MiniAppSearchDataManager.this.updateHotSearchData(miniAppSearch$StGetHotSearchAppsRsp);
                    synchronized (MiniAppSearchDataManager.this.mLock) {
                        MiniAppSearchDataManager.this.mHotSearchExtInfo = miniAppSearch$StGetHotSearchAppsRsp.extInfo.get();
                    }
                    return;
                }
                QLog.e(MiniAppSearchDataManager.TAG, 1, "sendHotSearchAppRequest, isSuccess = " + z16 + ", ret = " + jSONObject);
            }
        });
    }

    public void sendHotSearchAppV2Request() {
        COMM.StCommonExt stCommonExt;
        synchronized (this.mLock) {
            MiniAppSearch$StGetHotSearchAppsV2Rsp miniAppSearch$StGetHotSearchAppsV2Rsp = this.mHotSearchV2Rsp;
            stCommonExt = miniAppSearch$StGetHotSearchAppsV2Rsp != null ? miniAppSearch$StGetHotSearchAppsV2Rsp.extInfo : null;
        }
        MiniAppCmdUtil.getInstance().getHotSearchAppsV2(stCommonExt, new MiniAppCmdInterface() { // from class: com.tencent.mobileqq.mini.entry.search.data.a
            @Override // com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface
            public final void onCmdListener(boolean z16, JSONObject jSONObject) {
                MiniAppSearchDataManager.this.lambda$sendHotSearchAppV2Request$0(z16, jSONObject);
            }
        });
    }

    public void sendSearchAppRequest(String str, int i3) {
        checkNetwork();
        MiniAppCmdUtil.getInstance().searchApp(null, str, i3, new MiniAppCmdInterface() { // from class: com.tencent.mobileqq.mini.entry.search.data.MiniAppSearchDataManager.2
            @Override // com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface
            public void onCmdListener(boolean z16, JSONObject jSONObject) {
                boolean z17 = true;
                if (z16 && jSONObject != null) {
                    long optLong = jSONObject.optLong("retCode");
                    QLog.d(MiniAppSearchDataManager.TAG, 1, "sendSearchAppRequest, retCode = " + optLong + ", errMsg = " + jSONObject.optString("errMsg"));
                    if (optLong != 0) {
                        return;
                    }
                    MiniAppSearch$StSearchAppRsp miniAppSearch$StSearchAppRsp = (MiniAppSearch$StSearchAppRsp) jSONObject.opt(MiniAppSearchAppServlet.KEY_SEARCH_APP_RSP);
                    if (miniAppSearch$StSearchAppRsp != null) {
                        MiniAppSearchDataManager.this.highlightWords = miniAppSearch$StSearchAppRsp.highlightWords.get();
                        MiniAppSearchDataManager.this.updateSearchResultData(miniAppSearch$StSearchAppRsp.appList.get(), miniAppSearch$StSearchAppRsp.searchExtInfo.get(), miniAppSearch$StSearchAppRsp.rcmdList.get());
                        synchronized (MiniAppSearchDataManager.this.mLock) {
                            MiniAppSearchDataManager miniAppSearchDataManager = MiniAppSearchDataManager.this;
                            if (miniAppSearch$StSearchAppRsp.isFinished.get() != 1) {
                                z17 = false;
                            }
                            miniAppSearchDataManager.isFinished = z17;
                            MiniAppSearchDataManager.this.mExtInfo = miniAppSearch$StSearchAppRsp.extInfo.get();
                        }
                    }
                } else {
                    QLog.e(MiniAppSearchDataManager.TAG, 1, "sendSearchAppRequest, isSuccess = " + z16 + ", ret = " + jSONObject);
                }
                synchronized (MiniAppSearchDataManager.this.mLock) {
                    MiniAppSearchDataManager.this.isLoading = false;
                }
            }
        });
    }

    public void setDataChangedListener(SearchResultDataChangedListener searchResultDataChangedListener) {
        this.mResultDataChangedListener = searchResultDataChangedListener;
    }

    public void setHotSearchDataChangedListener(HotSearchDataChangedListener hotSearchDataChangedListener) {
        this.mHotSearchDataChangedListener = hotSearchDataChangedListener;
    }

    public void setHotSearchV2DataChangedListener(HotSearchDataChangedListener hotSearchDataChangedListener) {
        this.mHotSearchV2DataChangedListener = hotSearchDataChangedListener;
    }

    public void updateHistorySearchList(String str) {
        if (!TextUtils.isEmpty(str)) {
            if (this.mHistorySearchList.contains(str)) {
                this.mHistorySearchList.remove(str);
            }
            this.mHistorySearchList.addFirst(str);
        }
        AppInterface appInterface = MiniAppUtils.getAppInterface();
        if (appInterface != null) {
            String currentAccountUin = appInterface.getCurrentAccountUin();
            SharedPreferences sharedPreferences = BaseApplication.getContext().getSharedPreferences(currentAccountUin + "_" + MINI_APP_NATIVE_SEARCH, 0);
            StringBuilder sb5 = new StringBuilder();
            for (int i3 = 0; i3 < 20 && i3 < this.mHistorySearchList.size(); i3++) {
                String str2 = this.mHistorySearchList.get(i3);
                if (!TextUtils.isEmpty(str2)) {
                    sb5.append(str2);
                    sb5.append("_");
                }
            }
            sharedPreferences.edit().putString(AppConstants.Preferences.KEY_MINI_APP_NATIVE_SEARCH_HISTORY, sb5.toString()).apply();
        }
    }

    private COMM.StCommonExt generateBlacklistFromCurAppList() {
        COMM.StCommonExt stCommonExt;
        Exception e16;
        try {
            List<ItemInfo> list = this.mSearchResultMap.get(3);
            if (list == null || list.isEmpty()) {
                return null;
            }
            JSONObject jSONObject = new JSONObject();
            JSONArray jSONArray = new JSONArray();
            stCommonExt = new COMM.StCommonExt();
            try {
                for (ItemInfo itemInfo : list) {
                    if (itemInfo instanceof GuessYouLikeItem) {
                        jSONArray.mo162put(((GuessYouLikeItem) itemInfo).miniAppInfo.appId);
                    }
                }
                jSONObject.put("blacklist", jSONArray);
                stCommonExt.attachInfo.set(jSONObject.toString());
                return stCommonExt;
            } catch (Exception e17) {
                e16 = e17;
                QLog.e(TAG, 1, Log.getStackTraceString(e16));
                return stCommonExt;
            }
        } catch (Exception e18) {
            stCommonExt = null;
            e16 = e18;
        }
    }

    @Override // mqq.manager.Manager
    public void onDestroy() {
        this.mHotSearchDataChangedListener = null;
        this.mHotSearchV2DataChangedListener = null;
        this.mResultDataChangedListener = null;
        List<SearchInfo> list = this.mSearchResultList;
        if (list != null) {
            list.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void appendSearchResultData(List<STORE_APP_CLIENT$StoreAppInfo> list) {
        if (list != null && list.size() > 0) {
            final ArrayList arrayList = new ArrayList();
            for (STORE_APP_CLIENT$StoreAppInfo sTORE_APP_CLIENT$StoreAppInfo : list) {
                if (sTORE_APP_CLIENT$StoreAppInfo != null && sTORE_APP_CLIENT$StoreAppInfo.userAppInfo.get() != null) {
                    arrayList.add(new SearchInfo(sTORE_APP_CLIENT$StoreAppInfo));
                }
            }
            runOnMainThread(new Runnable() { // from class: com.tencent.mobileqq.mini.entry.search.data.MiniAppSearchDataManager.8
                @Override // java.lang.Runnable
                public void run() {
                    MiniAppSearchDataManager.this.mSearchResultList.addAll(arrayList);
                    if (MiniAppSearchDataManager.this.mResultDataChangedListener != null) {
                        MiniAppSearchDataManager.this.mResultDataChangedListener.onResultDataChanged();
                    }
                }
            });
            return;
        }
        QLog.d(TAG, 1, "updateSearchResultData, data is null!");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateGuessYouLikeData(List<STORE_APP_CLIENT$StoreAppInfo> list) {
        if (list == null) {
            QLog.d(TAG, 1, "updateGuessYouLikeData, data is null!");
            return;
        }
        ArrayList arrayList = new ArrayList();
        if (list.isEmpty()) {
            return;
        }
        List<ItemInfo> list2 = this.mSearchResultMap.get(3);
        if (list2 != null && !list2.isEmpty()) {
            for (ItemInfo itemInfo : list2) {
                if (itemInfo instanceof TitleInfo) {
                    arrayList.add(itemInfo);
                }
            }
        }
        for (STORE_APP_CLIENT$StoreAppInfo sTORE_APP_CLIENT$StoreAppInfo : list) {
            if (sTORE_APP_CLIENT$StoreAppInfo != null && sTORE_APP_CLIENT$StoreAppInfo.userAppInfo.get() != null) {
                arrayList.add(new GuessYouLikeItem(sTORE_APP_CLIENT$StoreAppInfo));
            }
        }
        if (arrayList.isEmpty()) {
            return;
        }
        this.mSearchResultMap.put(3, arrayList);
        final ArrayList arrayList2 = new ArrayList();
        synchronized (this.mLock) {
            QLog.d(TAG, 1, "updateGuessYouLikeData, sortList: " + this.mSortList);
            List<Integer> list3 = this.mSortList;
            if (list3 != null && !list3.isEmpty()) {
                Iterator<Integer> it = this.mSortList.iterator();
                while (it.hasNext()) {
                    List<ItemInfo> list4 = this.mSearchResultMap.get(Integer.valueOf(it.next().intValue()));
                    if (list4 != null && !list4.isEmpty()) {
                        arrayList2.addAll(list4);
                    }
                }
            }
        }
        runOnMainThread(new Runnable() { // from class: com.tencent.mobileqq.mini.entry.search.data.MiniAppSearchDataManager.7
            @Override // java.lang.Runnable
            public void run() {
                if (arrayList2.isEmpty()) {
                    return;
                }
                MiniAppSearchDataManager.this.mHotSearchList.clear();
                MiniAppSearchDataManager.this.mHotSearchList.addAll(arrayList2);
                if (MiniAppSearchDataManager.this.mHotSearchDataChangedListener != null) {
                    MiniAppSearchDataManager.this.mHotSearchDataChangedListener.onHotSearchDataChanged();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateHotSearchData(MiniAppSearch$StGetHotSearchAppsRsp miniAppSearch$StGetHotSearchAppsRsp) {
        if (miniAppSearch$StGetHotSearchAppsRsp == null) {
            QLog.e(TAG, 1, "updateHotSearchData, response is null!");
            return;
        }
        this.mTitle = miniAppSearch$StGetHotSearchAppsRsp.title.get();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        List<STORE_APP_CLIENT$StoreAppInfo> list = miniAppSearch$StGetHotSearchAppsRsp.appList.get();
        int i3 = 0;
        if (list != null && list.size() > 0) {
            arrayList.add(new TitleInfo(miniAppSearch$StGetHotSearchAppsRsp.title.get()));
            int i16 = 0;
            for (STORE_APP_CLIENT$StoreAppInfo sTORE_APP_CLIENT$StoreAppInfo : list) {
                if (sTORE_APP_CLIENT$StoreAppInfo != null && sTORE_APP_CLIENT$StoreAppInfo.userAppInfo.get() != null) {
                    SearchInfo searchInfo = new SearchInfo(sTORE_APP_CLIENT$StoreAppInfo);
                    searchInfo.setPosition(i16);
                    arrayList.add(searchInfo);
                    i16++;
                }
            }
            this.mSearchResultMap.put(1, arrayList);
        }
        List<MiniAppSearch$StHotWatching> list2 = miniAppSearch$StGetHotSearchAppsRsp.watchingList.get();
        if (list2 != null && list2.size() > 0) {
            arrayList2.add(new TitleInfo(miniAppSearch$StGetHotSearchAppsRsp.watchTitle.get()));
            for (MiniAppSearch$StHotWatching miniAppSearch$StHotWatching : list2) {
                if (miniAppSearch$StHotWatching != null) {
                    LiveInfo liveInfo = new LiveInfo(miniAppSearch$StHotWatching);
                    liveInfo.setPosition(i3);
                    arrayList2.add(liveInfo);
                    i3++;
                }
            }
            this.mSearchResultMap.put(2, arrayList2);
        }
        List<STORE_APP_CLIENT$StoreAppInfo> list3 = miniAppSearch$StGetHotSearchAppsRsp.guessYouList.get();
        if (list3 != null && !list3.isEmpty()) {
            TitleInfo titleInfo = new TitleInfo(miniAppSearch$StGetHotSearchAppsRsp.guessTitle.get());
            titleInfo.setRefreshButtonVisibility(true);
            arrayList3.add(titleInfo);
            for (STORE_APP_CLIENT$StoreAppInfo sTORE_APP_CLIENT$StoreAppInfo2 : list3) {
                if (sTORE_APP_CLIENT$StoreAppInfo2 != null && sTORE_APP_CLIENT$StoreAppInfo2.userAppInfo.get() != null) {
                    arrayList3.add(new GuessYouLikeItem(sTORE_APP_CLIENT$StoreAppInfo2));
                }
            }
            this.mSearchResultMap.put(3, arrayList3);
        }
        final ArrayList arrayList4 = new ArrayList();
        List<Integer> list4 = miniAppSearch$StGetHotSearchAppsRsp.sortList.get();
        QLog.d(TAG, 1, "updateHotSearchData, sortList: " + list4);
        if (list4 != null && !list4.isEmpty()) {
            Iterator<Integer> it = list4.iterator();
            while (it.hasNext()) {
                List<ItemInfo> list5 = this.mSearchResultMap.get(Integer.valueOf(it.next().intValue()));
                if (list5 != null && !list5.isEmpty()) {
                    arrayList4.addAll(list5);
                }
            }
        } else if (miniAppSearch$StGetHotSearchAppsRsp.sort.get() == 2) {
            arrayList4.addAll(arrayList2);
            arrayList4.addAll(arrayList);
            arrayList4.addAll(arrayList3);
        } else {
            arrayList4.addAll(arrayList);
            arrayList4.addAll(arrayList2);
            arrayList4.addAll(arrayList3);
        }
        synchronized (this.mLock) {
            this.mSortList = list4;
        }
        runOnMainThread(new Runnable() { // from class: com.tencent.mobileqq.mini.entry.search.data.MiniAppSearchDataManager.5
            @Override // java.lang.Runnable
            public void run() {
                MiniAppSearchDataManager.this.mHotSearchList.clear();
                MiniAppSearchDataManager.this.mHotSearchList.addAll(arrayList4);
                if (MiniAppSearchDataManager.this.mHotSearchDataChangedListener != null) {
                    MiniAppSearchDataManager.this.mHotSearchDataChangedListener.onHotSearchDataChanged();
                }
            }
        });
    }

    private void updateHotSearchDataV2(MiniAppSearch$StGetHotSearchAppsV2Rsp miniAppSearch$StGetHotSearchAppsV2Rsp) {
        if (miniAppSearch$StGetHotSearchAppsV2Rsp == null) {
            QLog.e(TAG, 1, "updateHotSearchData, response is null!");
        } else {
            runOnMainThread(new Runnable() { // from class: com.tencent.mobileqq.mini.entry.search.data.b
                @Override // java.lang.Runnable
                public final void run() {
                    MiniAppSearchDataManager.this.lambda$updateHotSearchDataV2$1();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$sendHotSearchAppV2Request$0(boolean z16, JSONObject jSONObject) {
        if (z16 && jSONObject != null) {
            long optLong = jSONObject.optLong("retCode");
            String optString = jSONObject.optString("errMsg");
            if (optLong != 0) {
                QLog.d(TAG, 1, "sendHotSearchAppV2Request code=", Long.valueOf(optLong), ",msg=", optString);
                return;
            }
            MiniAppSearch$StGetHotSearchAppsV2Rsp miniAppSearch$StGetHotSearchAppsV2Rsp = (MiniAppSearch$StGetHotSearchAppsV2Rsp) jSONObject.opt(MiniAppGetHotSearchAppsV2Servlet.KEY_GET_HOT_SEARCH_APPS_RSP);
            synchronized (this.mLock) {
                this.mHotSearchV2Rsp = miniAppSearch$StGetHotSearchAppsV2Rsp;
            }
            updateHotSearchDataV2(miniAppSearch$StGetHotSearchAppsV2Rsp);
            return;
        }
        QLog.e(TAG, 1, "sendHotSearchAppV2Request isSuc=", Boolean.valueOf(z16), ",ret=", jSONObject);
    }
}
