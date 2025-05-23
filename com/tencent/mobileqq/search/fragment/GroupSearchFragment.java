package com.tencent.mobileqq.search.fragment;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import androidx.activity.result.ActivityResultCaller;
import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelStoreOwner;
import com.tencent.biz.pubaccount.api.IPublicAccountDataManager;
import com.tencent.biz.qqcircle.immersive.views.search.optimise.video.QFSSearchPrerenderManager;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.framebusiness.GuildInjectImpl;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.UnifySearchHandler;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.avatar.api.IQQAvatarService;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.mini.api.data.SimpleMiniAppConfig;
import com.tencent.mobileqq.perf.tracker.SceneTracker;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.profilecard.api.IProfileCardConst;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.search.SearchUtil;
import com.tencent.mobileqq.search.activity.UniteSearchActivity;
import com.tencent.mobileqq.search.base.fragment.BaseSearchFragment;
import com.tencent.mobileqq.search.base.util.VADHelper;
import com.tencent.mobileqq.search.base.view.FitIMEInsetLayout;
import com.tencent.mobileqq.search.model.ac;
import com.tencent.mobileqq.search.model.ad;
import com.tencent.mobileqq.search.model.ah;
import com.tencent.mobileqq.search.model.v;
import com.tencent.mobileqq.search.model.x;
import com.tencent.mobileqq.search.model.z;
import com.tencent.mobileqq.search.mostused.MostUsedSearchResultManager;
import com.tencent.mobileqq.search.qqmc.SearchQQMC;
import com.tencent.mobileqq.search.report.ReportModelDC02528;
import com.tencent.mobileqq.search.searchdetail.eventbus.UniteSearchEvent;
import com.tencent.mobileqq.search.searchengine.GroupSearchEngine;
import com.tencent.mobileqq.search.util.SearchEnginePerfReporter;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.mobileqq.search.util.ao;
import com.tencent.mobileqq.search.util.ay;
import com.tencent.mobileqq.search.util.y;
import com.tencent.mobileqq.searchlocal.searchengine.PublicAccountSearchEngine;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.studymode.StudyModeManager;
import com.tencent.mobileqq.studymode.api.IStudyModeManager;
import com.tencent.mtt.hippy.views.scroll.HippyScrollViewEventHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AbsListView;
import cooperation.qqfav.globalsearch.FavoriteSearchEngine;
import do2.GroupSearchModelNtTroopResult;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import lo2.an;
import mqq.app.AppRuntime;
import org.json.JSONException;
import org.json.JSONObject;
import zn2.a;

/* compiled from: P */
/* loaded from: classes18.dex */
public class GroupSearchFragment extends BaseSearchFragment implements AbsListView.OnScrollListener, an, com.tencent.mobileqq.search.tux.a {
    public static final int DATA_STATUS_NET = 3;
    public static final int DATA_STATUS_NET_WITH_PEOPLE_OR_TROOP_DATA = 4;
    public static final int DATA_STATUS_NONE = 0;
    public static final int DATA_STATUS_ONLY_LOCAL = 1;
    public static final int DATA_STATUS_ONLY_LOCAL_WITH_PEOPLE_OR_TROOP_DATA = 2;
    private static final int FINISH_LOCAL_MSG = 11;
    private static final int FINISH_NET_MSG = 12;
    protected static final int GET_LOCAL_CALLBACK_ON_FINISH = 14;
    protected static final int GET_LOCAL_CALLBACK_ON_UPDATE = 13;
    private static final int GET_LOCAL_MSG = 10;
    public static final long MAX_UPDATE_DURATION = 50;
    private static final int START_SEARCH = 100;
    public static final String TAG = "Q.uniteSearch.GroupSearchFragment";
    protected static final int UPDATE_DURATION = 500;
    public static volatile String sCurrKeyword = null;
    private static final long sDaTongDelayTime = 2000;
    byte[] cookies;
    public volatile int dataStatus;
    private zn2.a floatIMEBar;
    public volatile String hotSearchKeyWordId;
    public boolean isViewCreated;
    private List<v> mLocalTmpData;
    private List<v> mNetTmpData;
    int mScrollState;
    protected pn2.c mSearchResultModelSuperSearch;
    u60.c searchPagePerfReporter;
    private com.tencent.mobileqq.search.util.d searchResultHandler;
    private wp2.b sortInfoConfig;
    public boolean needSearchOnLoad = false;
    public boolean isNeedColorSpan = false;
    public long lastUpdateTime = 0;
    public int searchIndex = 0;
    public String lastReqTime = "";
    public boolean isRequesting = false;
    public boolean isEnd = false;
    public volatile int forceRequestStatus = 0;
    public volatile int matchCount = 0;
    public volatile int keyWordSrc = 0;
    public boolean hasLocalData = false;
    public String traceId = "";
    protected pn2.c mSearchResultModelPeopleAndTroop = new pn2.c("", -1, R.drawable.icon_recent_troop_assistant, true);
    protected long mLastUpdateTimestamp = 0;
    int newSearchIndex = 0;
    int newSearchDataCount = 0;
    private int fromType = -1;
    private int source = 0;
    private final wo2.a searchPlayManager = new wo2.a();
    private final AtomicBoolean mIsNetFinish = new AtomicBoolean(false);
    private final AtomicBoolean mIsLocalFinish = new AtomicBoolean(false);
    private long preInitEngineCostTime = 0;
    private long preLoadFavCostTime = 0;
    private final com.tencent.mobileqq.search.tux.j tuxStatisticIoc = new com.tencent.mobileqq.search.tux.j(this);
    public Handler mHandler = new a(Looper.getMainLooper());
    private final com.tencent.mobileqq.friend.observer.a mFriendObserver = new b();
    private boolean mIsFirstClickResultItem = true;
    private volatile boolean isCacheInited = false;
    protected Runnable mDaTongReportRunnable = new Runnable() { // from class: com.tencent.mobileqq.search.fragment.GroupSearchFragment.3
        @Override // java.lang.Runnable
        public void run() {
            VideoReport.traverseExposure();
        }
    };

    /* compiled from: P */
    /* loaded from: classes18.dex */
    class a extends Handler {
        a(Looper looper) {
            super(looper);
        }

        /* JADX WARN: Removed duplicated region for block: B:156:0x059e  */
        /* JADX WARN: Removed duplicated region for block: B:170:0x05e4 A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:187:0x0494 A[SYNTHETIC] */
        @Override // android.os.Handler
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void handleMessage(Message message) {
            int i3;
            int i16;
            boolean z16;
            boolean z17;
            do2.j jVar;
            Object obj;
            com.tencent.mobileqq.search.model.i iVar;
            do2.g gVar;
            Object obj2;
            int i17;
            int i18;
            super.handleMessage(message);
            int i19 = message.what;
            if (i19 != 100) {
                switch (i19) {
                    case 10:
                        QLog.i(GroupSearchFragment.TAG, 2, "log for search GET_LOCAL_MSG");
                        GroupSearchFragment.this.lastUpdateTime = System.currentTimeMillis();
                        GroupSearchFragment.this.updateResultList(false);
                        GroupSearchFragment groupSearchFragment = GroupSearchFragment.this;
                        groupSearchFragment.updateSearchResult(groupSearchFragment.mResultList);
                        GroupSearchFragment groupSearchFragment2 = GroupSearchFragment.this;
                        groupSearchFragment2.updateLoadingUI(groupSearchFragment2.mResultList);
                        return;
                    case 11:
                        QLog.i(GroupSearchFragment.TAG, 2, "log for search FINISH_LOCAL_MSG");
                        GroupSearchFragment.this.updateResultList(false);
                        GroupSearchFragment groupSearchFragment3 = GroupSearchFragment.this;
                        groupSearchFragment3.updateLoadingUI(groupSearchFragment3.mResultList);
                        GroupSearchFragment groupSearchFragment4 = GroupSearchFragment.this;
                        groupSearchFragment4.updateSearchResult(groupSearchFragment4.mResultList);
                        return;
                    case 12:
                        QLog.i(GroupSearchFragment.TAG, 2, "log for search FINISH_NET_MSG");
                        GroupSearchFragment.this.updateResultList(false);
                        GroupSearchFragment groupSearchFragment5 = GroupSearchFragment.this;
                        groupSearchFragment5.updateLoadingUI(groupSearchFragment5.mResultList);
                        GroupSearchFragment groupSearchFragment6 = GroupSearchFragment.this;
                        groupSearchFragment6.updateSearchResult(groupSearchFragment6.mResultList);
                        List<M> list = GroupSearchFragment.this.mResultList;
                        int size = list == 0 ? 0 : list.size();
                        if (size <= 2 && GroupSearchFragment.this.mResultList != null) {
                            for (int i26 = 0; i26 < GroupSearchFragment.this.mResultList.size(); i26++) {
                                if (GroupSearchFragment.this.mResultList.get(i26) instanceof pn2.c) {
                                    size--;
                                }
                            }
                        }
                        if (size <= 0) {
                            SearchUtils.W0("all_result", "noresult_local", "" + GroupSearchFragment.this.keyword);
                            return;
                        }
                        return;
                    case 13:
                        List list2 = (List) message.obj;
                        if (list2 == null || list2.size() == 0) {
                            return;
                        }
                        if (!y.b()) {
                            long currentTimeMillis = System.currentTimeMillis();
                            GroupSearchFragment groupSearchFragment7 = GroupSearchFragment.this;
                            if (currentTimeMillis - groupSearchFragment7.mLastUpdateTimestamp < 500) {
                                groupSearchFragment7.mLastUpdateTimestamp = System.currentTimeMillis();
                                QLog.i(GroupSearchFragment.TAG, 2, "handleMessage, log for search GET_LOCAL_CALLBACK_ON_UPDATE, refresh too fast! ");
                                GroupSearchFragment.this.mHandler.sendMessageDelayed(GroupSearchFragment.this.mHandler.obtainMessage(13, list2), 500 - (System.currentTimeMillis() - GroupSearchFragment.this.mLastUpdateTimestamp));
                                return;
                            }
                        }
                        QLog.i(GroupSearchFragment.TAG, 2, "handleMessage, log for search GET_LOCAL_CALLBACK_ON_UPDATE, onUpdate ");
                        GroupSearchFragment.this.mLastUpdateTimestamp = System.currentTimeMillis();
                        GroupSearchFragment.this.mLocalTmpData = list2;
                        GroupSearchFragment groupSearchFragment8 = GroupSearchFragment.this;
                        pn2.c cVar = groupSearchFragment8.mSearchResultModelSuperSearch;
                        if (cVar != null && !groupSearchFragment8.mResultList.contains(cVar)) {
                            GroupSearchFragment.this.mLocalTmpData.add(GroupSearchFragment.this.mSearchResultModelSuperSearch);
                            GroupSearchFragment groupSearchFragment9 = GroupSearchFragment.this;
                            groupSearchFragment9.mSearchResultModelSuperSearch.G = groupSearchFragment9.keyword;
                        }
                        long currentTimeMillis2 = System.currentTimeMillis();
                        GroupSearchFragment groupSearchFragment10 = GroupSearchFragment.this;
                        if (currentTimeMillis2 - groupSearchFragment10.lastUpdateTime >= 50) {
                            groupSearchFragment10.mHandler.removeMessages(10);
                            GroupSearchFragment.this.mHandler.sendEmptyMessage(10);
                            return;
                        } else {
                            groupSearchFragment10.mHandler.removeMessages(10);
                            GroupSearchFragment groupSearchFragment11 = GroupSearchFragment.this;
                            groupSearchFragment11.mHandler.sendEmptyMessageDelayed(10, 50 - (currentTimeMillis2 - groupSearchFragment11.lastUpdateTime));
                            return;
                        }
                    case 14:
                        GroupSearchFragment.this.mHandler.removeMessages(13);
                        List list3 = (List) message.obj;
                        int i27 = message.arg1;
                        boolean z18 = i27 == 4 || i27 == 5;
                        QLog.d(GroupSearchFragment.TAG, 2, "handleMessage log for search , GET_LOCAL_CALLBACK_ON_FINISH, onFinish  status=", Integer.valueOf(i27), " isFinish=", Boolean.valueOf(z18), " forceRequestStatus=", Integer.valueOf(GroupSearchFragment.this.forceRequestStatus));
                        if (list3 == null) {
                            list3 = new ArrayList();
                        }
                        if (list3.size() != 0 || z18) {
                            long currentTimeMillis3 = System.currentTimeMillis();
                            GroupSearchFragment groupSearchFragment12 = GroupSearchFragment.this;
                            if (currentTimeMillis3 - groupSearchFragment12.mLastUpdateTimestamp < 500 && !z18) {
                                groupSearchFragment12.mLastUpdateTimestamp = System.currentTimeMillis();
                                return;
                            }
                            groupSearchFragment12.mLastUpdateTimestamp = System.currentTimeMillis();
                            GroupSearchFragment.this.mLocalTmpData = list3;
                            if (z18) {
                                if (GroupSearchFragment.this.fromType != 21 || nn2.a.a() != 0) {
                                    int i28 = 0;
                                    while (true) {
                                        obj = null;
                                        if (i28 >= list3.size()) {
                                            iVar = null;
                                            gVar = null;
                                        } else if (list3.get(i28) instanceof do2.g) {
                                            gVar = (do2.g) list3.get(i28);
                                            iVar = (com.tencent.mobileqq.search.model.i) list3.get(i28 - 1);
                                        } else {
                                            i28++;
                                        }
                                    }
                                    int i29 = 0;
                                    while (true) {
                                        if (i29 >= list3.size()) {
                                            obj2 = null;
                                        } else if (list3.get(i29) instanceof do2.j) {
                                            obj = (do2.j) list3.get(i29);
                                            obj2 = (com.tencent.mobileqq.search.model.i) list3.get(i29 - 1);
                                        } else {
                                            i29++;
                                        }
                                    }
                                    list3.remove(iVar);
                                    list3.remove(gVar);
                                    list3.remove(obj);
                                    list3.remove(obj2);
                                    int i36 = 0;
                                    int i37 = -1;
                                    for (int i38 = 0; i38 < list3.size(); i38++) {
                                        SearchUtil.b(list3.get(i38), GroupSearchFragment.this.keyword, GroupSearchFragment.this.fromType);
                                        if (list3.get(i38) instanceof do2.l) {
                                            i37 = i38;
                                        }
                                        if ((list3.get(i38) instanceof do2.h) || (list3.get(i38) instanceof do2.n)) {
                                            i36 = i38 + 1;
                                        }
                                        if ((list3.get(i38) instanceof com.tencent.mobileqq.search.model.j) || (list3.get(i38) instanceof GroupSearchModelNtTroopResult)) {
                                            i36 = i38 + 1;
                                        }
                                    }
                                    GroupSearchFragment groupSearchFragment13 = GroupSearchFragment.this;
                                    groupSearchFragment13.mSearchResultModelPeopleAndTroop.G = groupSearchFragment13.keyword;
                                    GroupSearchFragment groupSearchFragment14 = GroupSearchFragment.this;
                                    groupSearchFragment14.mSearchResultModelPeopleAndTroop.O(groupSearchFragment14.keyword);
                                    GroupSearchFragment groupSearchFragment15 = GroupSearchFragment.this;
                                    groupSearchFragment15.mSearchResultModelPeopleAndTroop.F(groupSearchFragment15.source);
                                    GroupSearchFragment.this.mSearchResultModelPeopleAndTroop.j(SearchUtil.s());
                                    if (i36 == 0 && i37 >= 0) {
                                        int i39 = i37 + 1;
                                        i17 = i39 + 1;
                                        list3.add(i39, GroupSearchFragment.this.mSearchResultModelPeopleAndTroop);
                                    } else {
                                        i17 = i36 + 1;
                                        list3.add(i36, GroupSearchFragment.this.mSearchResultModelPeopleAndTroop);
                                    }
                                    SearchUtils.W0("all_result", "exp_people_group", GroupSearchFragment.this.keyword);
                                    com.tencent.mobileqq.search.report.b.e(null, 0, GroupSearchFragment.this.fromType, "0X8009D3E", 0, 0, null, null);
                                    if (gVar != null && gVar.o() != null && gVar.o().size() > 0) {
                                        StringBuilder sb5 = new StringBuilder();
                                        for (int i46 = 1; i46 < gVar.o().size() - 1; i46++) {
                                            ((lo2.c) gVar.o().get(i46)).f415203u0 = i46 - 1;
                                        }
                                        int min = Math.min(gVar.o().size(), gVar.n());
                                        if (min > 0) {
                                            int i47 = 0;
                                            while (true) {
                                                int i48 = min - 1;
                                                if (i47 < i48) {
                                                    sb5.append(((lo2.c) gVar.o().get(i47)).H + "::");
                                                    i47++;
                                                } else {
                                                    sb5.append(((lo2.c) gVar.o().get(i48)).H + "");
                                                }
                                            }
                                        }
                                        if (((lo2.c) gVar.o().get(0)).I.equals(GroupSearchFragment.this.keyword)) {
                                            if (i37 < 0) {
                                                list3.add(0, iVar);
                                                list3.add(1, gVar);
                                            } else {
                                                list3.add(i37 + 1, iVar);
                                                list3.add(i37 + 2, gVar);
                                            }
                                            SearchUtils.W0("all_result", "exp_function", "" + GroupSearchFragment.this.keyword, "" + sb5.toString(), "", "1");
                                            com.tencent.mobileqq.search.report.b.e(null, 0, GroupSearchFragment.this.fromType, "0X8009D34", 0, 0, gVar.o().get(0).getUin(), null);
                                            list3.size();
                                        } else {
                                            list3.add(i17, iVar);
                                            list3.add(i17 + 1, gVar);
                                            SearchUtils.W0("all_result", "exp_function", "" + GroupSearchFragment.this.keyword, "" + sb5.toString(), "", "0");
                                            com.tencent.mobileqq.search.report.b.e(null, 0, GroupSearchFragment.this.fromType, "0X8009D48", 0, 0, com.tencent.mobileqq.search.util.t.c(gVar.o(), gVar.n()), null);
                                        }
                                        if (iVar != null && iVar.A()) {
                                            com.tencent.mobileqq.search.report.b.e(null, 0, GroupSearchFragment.this.fromType, "0X8009D4A", 0, 0, null, null);
                                        }
                                    }
                                }
                                if (GroupSearchFragment.this.forceRequestStatus == 6) {
                                    GroupSearchFragment.this.matchCount = 0;
                                    if (GroupSearchFragment.this.forceRequestStatus == 0) {
                                        for (Object obj3 : list3) {
                                            if ((obj3 instanceof do2.d) || (obj3 instanceof do2.e) || (obj3 instanceof do2.h) || (obj3 instanceof do2.m) || (obj3 instanceof com.tencent.mobileqq.search.model.j) || (obj3 instanceof do2.i) || (obj3 instanceof com.tencent.mobileqq.search.ftsmsg.a) || ((obj3 instanceof lo2.c) && ((lo2.c) obj3).J() == 268435456)) {
                                                if (obj3 instanceof x) {
                                                    x xVar = (x) obj3;
                                                    int size2 = (xVar == null || xVar.o() == null) ? 0 : xVar.o().size();
                                                    GroupSearchFragment.this.matchCount += Math.min(size2, xVar.n());
                                                } else {
                                                    GroupSearchFragment.this.matchCount++;
                                                }
                                            }
                                        }
                                    }
                                    GroupSearchFragment.this.dataStatus = i27 == 4 ? 1 : 2;
                                }
                                if (QLog.isColorLevel() && GroupSearchFragment.this.matchCount > 0) {
                                    QLog.d(GroupSearchFragment.TAG, 2, "onFinish(). matchCount=" + GroupSearchFragment.this.matchCount + " forceRequestStatus=" + GroupSearchFragment.this.forceRequestStatus);
                                }
                                if (GroupSearchFragment.this.forceRequestStatus == 0) {
                                    i18 = 4;
                                    GroupSearchFragment.this.forceRequestStatus = 4;
                                } else {
                                    i18 = 4;
                                }
                                SearchEnginePerfReporter.k(GroupSearchFragment.this.keyword);
                                if (GroupSearchFragment.this.isInputPinyin()) {
                                    GroupSearchFragment.this.mIsNetFinish.set(true);
                                    i3 = 11;
                                } else {
                                    GroupSearchFragment.this.dataStatus = i27 == 5 ? i18 : 3;
                                    if (!y.b()) {
                                        GroupSearchFragment.this.startNetSearch("onFinish isOptSearch=false");
                                    }
                                    i3 = 12;
                                }
                            } else {
                                i3 = 10;
                            }
                            long currentTimeMillis4 = System.currentTimeMillis();
                            GroupSearchFragment groupSearchFragment16 = GroupSearchFragment.this;
                            if (currentTimeMillis4 - groupSearchFragment16.lastUpdateTime >= 50) {
                                groupSearchFragment16.mHandler.removeMessages(i3);
                                GroupSearchFragment.this.mHandler.sendEmptyMessage(i3);
                            } else {
                                groupSearchFragment16.mHandler.removeMessages(i3);
                                GroupSearchFragment groupSearchFragment17 = GroupSearchFragment.this;
                                groupSearchFragment17.mHandler.sendEmptyMessageDelayed(i3, 50 - (currentTimeMillis4 - groupSearchFragment17.lastUpdateTime));
                            }
                            if (z18) {
                                if (list3.isEmpty()) {
                                    i16 = 0;
                                } else {
                                    i16 = 0;
                                    int i49 = 0;
                                    for (Object obj4 : list3) {
                                        if (!(obj4 instanceof do2.d) && !(obj4 instanceof do2.e)) {
                                            if (obj4 instanceof x) {
                                                x xVar2 = (x) obj4;
                                                List<com.tencent.mobileqq.search.model.y> o16 = xVar2.o();
                                                if (o16 != null) {
                                                    i16 += Math.min(o16.size(), xVar2.n());
                                                    for (int i56 = 0; i56 < Math.min(o16.size(), xVar2.n()); i56++) {
                                                        SearchUtils.d dVar = new SearchUtils.d();
                                                        i49++;
                                                        dVar.f284978c = i49;
                                                        dVar.f284977b = SearchUtil.q(xVar2);
                                                        dVar.f284976a = xVar2.getKeyword();
                                                        SearchUtils.f284965n.put(o16.get(i56), dVar);
                                                    }
                                                }
                                            } else {
                                                i16++;
                                            }
                                        } else {
                                            i16++;
                                            SearchUtils.d dVar2 = new SearchUtils.d();
                                            i49++;
                                            dVar2.f284978c = i49;
                                            x xVar3 = (x) obj4;
                                            dVar2.f284977b = SearchUtil.q(xVar3);
                                            dVar2.f284976a = xVar3.getKeyword();
                                            SearchUtils.f284965n.put(xVar3, dVar2);
                                        }
                                        if (obj4 instanceof pn2.c) {
                                            pn2.c cVar2 = (pn2.c) obj4;
                                            if (cVar2.I == -1) {
                                                SearchUtils.d dVar3 = new SearchUtils.d();
                                                i49++;
                                                dVar3.f284978c = i49;
                                                dVar3.f284977b = SearchUtil.q(cVar2);
                                                dVar3.f284976a = cVar2.G;
                                                SearchUtils.f284965n.put(cVar2, dVar3);
                                            }
                                        }
                                        if (obj4 instanceof x) {
                                            x xVar4 = (x) obj4;
                                            if (xVar4.o() != null) {
                                                for (com.tencent.mobileqq.search.model.y yVar : xVar4.o()) {
                                                    if (yVar instanceof z) {
                                                        ((z) yVar).F(GroupSearchFragment.this.source);
                                                    }
                                                }
                                                if (obj4 instanceof com.tencent.mobileqq.search.model.a) {
                                                    ((com.tencent.mobileqq.search.model.a) obj4).t(GroupSearchFragment.this.source);
                                                }
                                            }
                                        }
                                        if (obj4 != null && (obj4 instanceof do2.g)) {
                                            do2.g gVar2 = (do2.g) obj4;
                                            if (gVar2.o() != null && gVar2.o().size() > 0) {
                                                z16 = true;
                                                if (z16) {
                                                    com.tencent.mobileqq.search.model.y yVar2 = ((do2.g) obj4).o().get(0);
                                                    if (yVar2 instanceof lo2.c) {
                                                        TextUtils.isEmpty(((lo2.c) yVar2).I);
                                                    }
                                                    if (z16) {
                                                        ((lo2.c) yVar2).I.equals(GroupSearchFragment.this.keyword);
                                                    }
                                                }
                                                if (obj4 != null && (obj4 instanceof do2.j)) {
                                                    jVar = (do2.j) obj4;
                                                    if (jVar.o() != null && jVar.o().size() > 0) {
                                                        z17 = true;
                                                        if (!z17) {
                                                            com.tencent.mobileqq.search.model.y yVar3 = ((do2.j) obj4).o().get(0);
                                                            if ((yVar3 instanceof up2.a) && !TextUtils.isEmpty(((up2.a) yVar3).getTitle())) {
                                                                up2.a aVar = (up2.a) yVar3;
                                                                if (aVar.getTitle().equals(GroupSearchFragment.this.keyword)) {
                                                                    com.tencent.mobileqq.search.report.b.e(((BaseSearchFragment) GroupSearchFragment.this).appInterface, GroupSearchFragment.this.source, GroupSearchFragment.this.fromType, "0X8009D32", 0, 0, aVar.G(), null);
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                                z17 = false;
                                                if (!z17) {
                                                }
                                            }
                                        }
                                        z16 = false;
                                        if (z16) {
                                        }
                                        if (obj4 != null) {
                                            jVar = (do2.j) obj4;
                                            if (jVar.o() != null) {
                                                z17 = true;
                                                if (!z17) {
                                                }
                                            }
                                        }
                                        z17 = false;
                                        if (!z17) {
                                        }
                                    }
                                }
                                JSONObject jSONObject = new JSONObject();
                                try {
                                    jSONObject.put("project", com.tencent.mobileqq.search.report.b.c());
                                    jSONObject.put("event_src", "client");
                                    jSONObject.put("nav_num", i16);
                                } catch (JSONException e16) {
                                    QLog.e(GroupSearchFragment.TAG, 2, "e = " + e16);
                                }
                                QQAppInterface qQAppInterface = (QQAppInterface) BaseApplicationImpl.getApplication().getRuntime();
                                com.tencent.mobileqq.search.report.b.h(qQAppInterface, new ReportModelDC02528().module("all_result").action("exp_items").ver1(GroupSearchFragment.this.keyword).ver2(com.tencent.mobileqq.search.report.b.a(GroupSearchFragment.this.fromType)).ver7(jSONObject.toString()).session_id(qQAppInterface.getCurrentAccountUin() + SearchUtils.f284963l));
                                SearchUtils.W0("all_result", "exp_all_result", GroupSearchFragment.this.keyword);
                                return;
                            }
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
            if (TextUtils.isEmpty(GroupSearchFragment.this.keyword)) {
                return;
            }
            ((BaseSearchFragment) GroupSearchFragment.this).footerLoadingJuhuaView.setVisibility(8);
            GroupSearchFragment.this.showLoading();
            GroupSearchFragment groupSearchFragment18 = GroupSearchFragment.this;
            groupSearchFragment18.startSearch(groupSearchFragment18.keyword);
        }
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    class b extends com.tencent.mobileqq.friend.observer.a {
        b() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Code restructure failed: missing block: B:31:0x00af, code lost:
        
            continue;
         */
        @Override // com.tencent.mobileqq.friend.observer.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onUpdateDelFriend(boolean z16, Object obj) {
            if (z16 && (obj instanceof Long)) {
                for (int i3 = 0; i3 < GroupSearchFragment.this.mResultList.size(); i3++) {
                    Object obj2 = GroupSearchFragment.this.mResultList.get(i3);
                    if (obj2 instanceof do2.l) {
                        int i16 = 0;
                        while (true) {
                            do2.l lVar = (do2.l) obj2;
                            if (i16 >= lVar.o().size()) {
                                break;
                            }
                            if (TextUtils.equals(String.valueOf(obj), lVar.o().get(i16).getUin())) {
                                QLog.i(GroupSearchFragment.TAG, 1, "onUpdateDelFriend startSearch uin=" + obj);
                                GroupSearchFragment groupSearchFragment = GroupSearchFragment.this;
                                groupSearchFragment.startSearch(groupSearchFragment.keyword);
                                return;
                            }
                            i16++;
                        }
                    }
                    if (obj2 instanceof do2.n) {
                        int i17 = 0;
                        while (true) {
                            do2.n nVar = (do2.n) obj2;
                            if (i17 < nVar.o().size()) {
                                if (TextUtils.equals(String.valueOf(obj), nVar.o().get(i17).getUin())) {
                                    QLog.i(GroupSearchFragment.TAG, 1, "onUpdateDelFriend startSearch uin=" + obj);
                                    GroupSearchFragment groupSearchFragment2 = GroupSearchFragment.this;
                                    groupSearchFragment2.startSearch(groupSearchFragment2.keyword);
                                    return;
                                }
                                i17++;
                            }
                        }
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class c implements View.OnClickListener {
        c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            GroupSearchFragment.this.forceRequestStatus = 1;
            GroupSearchFragment.this.startNetNewSearch("onResultError retry");
            ((BaseSearchFragment) GroupSearchFragment.this).footerErrorView.setVisibility(8);
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    private void addSearchTuxModelIfNeed(ArrayList arrayList) {
        if (!SearchQQMC.INSTANCE.enableSearchTux().getEnableDirect()) {
            return;
        }
        if (((IStudyModeManager) QRoute.api(IStudyModeManager.class)).getStudyModeSwitch()) {
            QLog.d(TAG, 4, "addSearchTuxModelIfNeed is study mode");
            return;
        }
        if (this.tuxStatisticIoc.getHasSearchTuxClosed()) {
            QLog.d(TAG, 4, "addSearchTuxModelIfNeed has closed");
        } else if (arrayList != null) {
            com.tencent.mobileqq.search.tux.g gVar = new com.tencent.mobileqq.search.tux.g(new com.tencent.mobileqq.search.tux.i(this.keyword, this.traceId), this.tuxStatisticIoc);
            gVar.j(SearchUtil.s());
            arrayList.add(gVar);
        }
    }

    private List<v> doPreProcessBeforeUpdate(List<v> list) {
        boolean z16;
        if (this.sortInfoConfig != null) {
            list = ay.d().i(list, this.sortInfoConfig);
        }
        if (this.mIsNetFinish.get() && this.mIsLocalFinish.get()) {
            ao.a();
            List<M> list2 = this.mResultList;
            if (list2 != 0 && !list2.isEmpty()) {
                z16 = true;
            } else {
                z16 = false;
            }
            showNoMoreResult(z16);
        } else {
            ao.c("doPreProcessBeforeUpdate", this.mIsLocalFinish.get() ? 1 : 0);
        }
        return list;
    }

    private do2.l findMostUsedGroupModel() {
        for (int i3 = 0; i3 < this.mResultList.size(); i3++) {
            if (this.mResultList.get(i3) instanceof do2.l) {
                return (do2.l) this.mResultList.get(i3);
            }
        }
        return null;
    }

    private List<Long> getPublicAccountIdList() {
        List<up2.b> a16 = new PublicAccountSearchEngine((QQAppInterface) this.appInterface, this.fromType).a(new pn2.a(this.keyword));
        if (a16 != null && a16.size() != 0) {
            List<Entity> publicAccountList = ((IPublicAccountDataManager) this.appInterface.getRuntimeService(IPublicAccountDataManager.class, "all")).getPublicAccountList();
            ArrayList arrayList = new ArrayList();
            if (publicAccountList != null && !publicAccountList.isEmpty()) {
                for (int i3 = 0; i3 < a16.size(); i3++) {
                    up2.b bVar = a16.get(i3);
                    for (int i16 = 0; i16 < publicAccountList.size(); i16++) {
                        PublicAccountInfo publicAccountInfo = (PublicAccountInfo) publicAccountList.get(i16);
                        if (TextUtils.equals(String.valueOf(publicAccountInfo.uin), String.valueOf(bVar.X.getUinString()))) {
                            arrayList.add(Long.valueOf(publicAccountInfo.uin));
                        }
                    }
                }
            } else if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "all publicAccountInfoList is null or empty");
            }
            return arrayList;
        }
        return null;
    }

    private int getUnifyReportId(int i3) {
        int i16 = 2;
        if (i3 != 2) {
            i16 = 3;
            if (i3 != 3) {
                i16 = 4;
                if (i3 != 4) {
                    i16 = 5;
                    if (i3 != 5) {
                        return 1;
                    }
                }
            }
        }
        return i16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isInputPinyin() {
        ActivityResultCaller parentFragment = getParentFragment();
        if (parentFragment instanceof nn2.b) {
            return ((nn2.b) parentFragment).isInputPinyin();
        }
        if (getQBaseActivity() instanceof nn2.b) {
            return ((nn2.b) getQBaseActivity()).isInputPinyin();
        }
        return false;
    }

    private void isShowNetSearchView(List<v> list) {
        if (list == null) {
            return;
        }
        boolean K = this.mSearchResultModelPeopleAndTroop.K();
        String keyword = this.mSearchResultModelPeopleAndTroop.getKeyword();
        if (!K) {
            list.remove(this.mSearchResultModelPeopleAndTroop);
        } else if (!list.contains(this.mSearchResultModelPeopleAndTroop) && !TextUtils.isEmpty(keyword)) {
            list.add(this.mSearchResultModelPeopleAndTroop);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$preInitEngine$1() {
        long currentTimeMillis = System.currentTimeMillis();
        initEngine();
        this.preInitEngineCostTime = System.currentTimeMillis() - currentTimeMillis;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$preStartFavProcess$2(AppInterface appInterface) {
        long currentTimeMillis = System.currentTimeMillis();
        FavoriteSearchEngine.l(appInterface);
        this.preLoadFavCostTime = System.currentTimeMillis() - currentTimeMillis;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$startSearchLocalAndNet$0() {
        initEngine();
        if (!this.isCacheInited) {
            MostUsedSearchResultManager mostUsedSearchResultManager = (MostUsedSearchResultManager) this.appInterface.getManager(QQManagerFactory.MOST_USE_SEARCH_MANAGER);
            if (mostUsedSearchResultManager != null) {
                mostUsedSearchResultManager.e();
            }
            this.isCacheInited = true;
        }
        this.mHandler.removeMessages(100);
        this.mHandler.sendEmptyMessage(100);
    }

    public static GroupSearchFragment newInstance(int i3, int i16) {
        Bundle bundle = new Bundle();
        bundle.putInt(IProfileCardConst.KEY_FROM_TYPE, i3);
        bundle.putInt("source", i16);
        GroupSearchFragment groupSearchFragment = new GroupSearchFragment();
        groupSearchFragment.setArguments(bundle);
        return groupSearchFragment;
    }

    private void preInitEngine() {
        if (this.searchEngine == null) {
            QLog.i(TAG, 1, "preInitEngine searchEngine == null");
        } else {
            ThreadManagerV2.postImmediately(new Runnable() { // from class: com.tencent.mobileqq.search.fragment.h
                @Override // java.lang.Runnable
                public final void run() {
                    GroupSearchFragment.this.lambda$preInitEngine$1();
                }
            }, null, true);
        }
    }

    private void preStartFavProcess(final AppInterface appInterface) {
        ThreadManagerV2.postImmediately(new Runnable() { // from class: com.tencent.mobileqq.search.fragment.g
            @Override // java.lang.Runnable
            public final void run() {
                GroupSearchFragment.this.lambda$preStartFavProcess$2(appInterface);
            }
        }, null, true);
    }

    private void removeSearchResultByWtiLight(List<v> list, int i3) {
        if (list != null && i3 == 1) {
            list.remove(this.mSearchResultModelPeopleAndTroop);
        }
    }

    private void reportSearchResult(int i3, String str, List<v> list) {
        String str2;
        QQAppInterface qQAppInterface;
        HashMap hashMap = new HashMap();
        boolean z16 = true;
        if (list != null) {
            try {
                if (list.size() > 0) {
                    for (v vVar : list) {
                        if (vVar instanceof com.tencent.mobileqq.search.model.i) {
                            String l3 = ((com.tencent.mobileqq.search.model.i) vVar).l();
                            if (HardCodeUtil.qqStr(R.string.n5r).equals(l3)) {
                                hashMap.put(1, 1);
                            } else if (HardCodeUtil.qqStr(R.string.n5e).equals(l3)) {
                                hashMap.put(2, 2);
                            } else if (HardCodeUtil.qqStr(R.string.n59).equals(l3)) {
                                hashMap.put(3, 3);
                            } else if (HardCodeUtil.qqStr(R.string.n57).equals(l3)) {
                                hashMap.put(4, 4);
                            } else if (HardCodeUtil.qqStr(R.string.f172079n62).equals(l3)) {
                                hashMap.put(5, 5);
                            } else if (HardCodeUtil.qqStr(R.string.c08).equals(l3)) {
                                hashMap.put(6, 6);
                            } else if (HardCodeUtil.qqStr(R.string.n5i).equals(l3)) {
                                hashMap.put(7, 7);
                            } else if (HardCodeUtil.qqStr(R.string.hvk).equals(l3)) {
                                hashMap.put(8, 8);
                            } else if (HardCodeUtil.qqStr(R.string.n5j).equals(l3)) {
                                hashMap.put(9, 9);
                            } else if (HardCodeUtil.qqStr(R.string.n5n).equals(l3)) {
                                hashMap.put(10, 10);
                            } else {
                                hashMap.put(11, 11);
                            }
                        }
                    }
                }
            } catch (Throwable unused) {
                return;
            }
        }
        if (hashMap.size() > 0) {
            StringBuilder sb5 = new StringBuilder();
            for (Integer num : hashMap.values()) {
                if (!z16) {
                    sb5.append("_");
                } else {
                    z16 = false;
                }
                sb5.append(num);
            }
            str2 = sb5.toString();
        } else {
            str2 = "";
        }
        String str3 = str2;
        AppRuntime runtime = BaseApplicationImpl.getApplication().getRuntime();
        if (runtime instanceof QQAppInterface) {
            qQAppInterface = (QQAppInterface) runtime;
        } else {
            qQAppInterface = null;
        }
        ReportController.o(qQAppInterface, "dc00898", "", "", "0X800973C", "0X800973C", i3, 0, "", "", str, str3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startNetSearch(String str) {
        String str2;
        double d16;
        double d17;
        boolean z16;
        SearchEnginePerfReporter.t(this.keyword);
        SearchEnginePerfReporter.v(this.keyword, "netQueryCost");
        if (this.keyword == null) {
            str2 = "";
        } else {
            str2 = this.keyword;
        }
        QLog.i(TAG, 2, "log for search startNetSearch from=" + str + " keyword=" + str2);
        ao.c("startNetSearch", -1);
        if (getQBaseActivity() instanceof com.tencent.mobileqq.search.m) {
            d16 = ((com.tencent.mobileqq.search.m) getQBaseActivity()).getLat();
            d17 = ((com.tencent.mobileqq.search.m) getQBaseActivity()).getLon();
        } else {
            d16 = 0.0d;
            d17 = 0.0d;
        }
        this.newSearchDataCount = 0;
        this.newSearchIndex = 0;
        this.isRequesting = true;
        this.isEnd = false;
        this.lastReqTime = System.currentTimeMillis() + "";
        if (this.forceRequestStatus == 0) {
            this.forceRequestStatus = 4;
        }
        SearchUtils.W0("all_result", "active_net", "" + this.keyword, "" + getUnifyReportId(this.forceRequestStatus));
        Bundle bundle = new Bundle();
        bundle.putInt("matchCount", this.matchCount);
        bundle.putInt("source", this.source);
        bundle.putInt("keyWordSrc", this.keyWordSrc);
        List<Long> publicAccountIdList = getPublicAccountIdList();
        String str3 = this.keyword;
        String str4 = this.lastReqTime;
        List<Long> j3 = SearchUtils.j(UnifySearchHandler.f195167h);
        int i3 = this.forceRequestStatus;
        if (this.dataStatus == 2) {
            z16 = true;
        } else {
            z16 = false;
        }
        SimpleEventBus.getInstance().dispatchEvent(new UniteSearchEvent(str3, str4, 20, j3, publicAccountIdList, i3, null, d16, d17, false, z16, this.fromType, bundle));
        this.forceRequestStatus = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateLoadingUI(List list) {
        boolean z16;
        if (list != null && !list.isEmpty()) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (this.mIsNetFinish.get() && this.mIsLocalFinish.get()) {
            hideLoading();
            this.footerLoadingJuhuaView.setVisibility(8);
            showNoMoreResult(true);
            showNoResultLayout(z16);
            return;
        }
        showNoMoreResult(false);
        showNoResultLayout(false);
        if (z16) {
            showLoading();
            this.footerLoadingJuhuaView.setVisibility(8);
        } else {
            hideLoading();
            this.footerLoadingJuhuaView.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateResultList(boolean z16) {
        ArrayList arrayList = new ArrayList();
        List<v> list = this.mLocalTmpData;
        if (list != null && !list.isEmpty()) {
            arrayList.addAll(this.mLocalTmpData);
        }
        List<v> list2 = this.mNetTmpData;
        if (list2 != null && !list2.isEmpty() && (z16 || y.b())) {
            arrayList.addAll(this.mNetTmpData);
            if (y.b()) {
                this.searchResultHandler.c(arrayList, this.keyword);
            }
        }
        this.mResultList = arrayList;
        isShowNetSearchView(arrayList);
        u60.c cVar = this.searchPagePerfReporter;
        if (cVar != null) {
            cVar.a("pg_search_result");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void updateSearchResult(List<v> list) {
        List doPreProcessBeforeUpdate = doPreProcessBeforeUpdate(list);
        this.mResultList = doPreProcessBeforeUpdate;
        ((jn2.c) this.adapter).p(doPreProcessBeforeUpdate);
        this.mHandler.removeCallbacks(this.mDaTongReportRunnable);
        this.mHandler.postDelayed(this.mDaTongReportRunnable, 2000L);
        com.tencent.mobileqq.search.util.x.b(this.listView, this.mResultList);
    }

    public ArrayList WashResultList(List list) {
        if (list == null) {
            return null;
        }
        if (list.size() != 0 && !StudyModeManager.w()) {
            return com.tencent.mobileqq.search.mostused.b.l(sCurrKeyword, ((MostUsedSearchResultManager) this.appInterface.getManager(QQManagerFactory.MOST_USE_SEARCH_MANAGER)).f(sCurrKeyword), list);
        }
        return new ArrayList(list);
    }

    public void clearSearchResult() {
        List<M> list = this.mResultList;
        if (list != 0) {
            list.clear();
        }
        this.mNetTmpData = null;
        this.mLocalTmpData = null;
        if (this.adapter != null) {
            updateSearchResult(this.mResultList);
        }
        this.mSearchResultModelPeopleAndTroop.P(false);
        this.hasLocalData = false;
    }

    public void destroyEngine() {
        on2.b bVar = this.searchEngine;
        if (bVar != null) {
            bVar.cancel();
            this.searchEngine.destroy();
        }
        this.isEngineInited = false;
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment
    public /* bridge */ /* synthetic */ boolean doOnKeyDown(int i3, KeyEvent keyEvent) {
        return com.tencent.biz.richframework.compat.f.b(this, i3, keyEvent);
    }

    @Override // com.tencent.mobileqq.search.base.fragment.BaseSearchFragment
    protected String getRightTvText() {
        return "\u5185\u5bb9";
    }

    @Override // com.tencent.mobileqq.search.base.fragment.BaseSearchFragment
    protected int getSearchModule() {
        return 0;
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public /* bridge */ /* synthetic */ ViewModel getViewModel(ViewModelStoreOwner viewModelStoreOwner, String str, @NonNull Class cls) {
        return ne0.a.a(this, viewModelStoreOwner, str, cls);
    }

    @Override // com.tencent.mobileqq.search.base.fragment.BaseSearchFragment
    protected boolean ignoreDestroyEngine() {
        return true;
    }

    public synchronized void initEngine() {
        if (!this.isEngineInited) {
            this.searchEngine.init();
            this.isEngineInited = true;
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment
    public /* bridge */ /* synthetic */ void initWindowStyleAndAnimation(Activity activity) {
        com.tencent.biz.richframework.compat.f.c(this, activity);
    }

    @Override // lo2.an
    public boolean isFirstClickResultItem() {
        return this.mIsFirstClickResultItem;
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment
    public /* bridge */ /* synthetic */ boolean isSupportScreenShot() {
        return com.tencent.biz.richframework.compat.f.d(this);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment
    public /* bridge */ /* synthetic */ boolean isWrapContent() {
        return com.tencent.biz.richframework.compat.f.e(this);
    }

    public void loadData() {
        hideLoading();
        updateSearchResult(this.mResultList);
        this.footerLoadingView.setVisibility(8);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment
    public /* bridge */ /* synthetic */ boolean needImmersive() {
        return com.tencent.biz.richframework.compat.f.f(this);
    }

    @Override // com.tencent.mobileqq.search.base.fragment.BaseSearchFragment
    protected boolean needShowHeader() {
        return false;
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment
    public /* bridge */ /* synthetic */ boolean needStatusTrans() {
        return com.tencent.biz.richframework.compat.f.g(this);
    }

    @Override // com.tencent.mobileqq.search.base.fragment.BaseSearchFragment
    protected mn2.a newAdapter() {
        return new jn2.c(this.listView, this.faceDecoder, this, this.fromType);
    }

    @Override // com.tencent.mobileqq.search.base.fragment.BaseSearchFragment
    protected on2.b newSearchEngine() {
        on2.b bVar = this.searchEngine;
        if (bVar != null) {
            return bVar;
        }
        return new GroupSearchEngine((QQAppInterface) this.appInterface, this.fromType);
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override // com.tencent.mobileqq.search.base.fragment.BaseSearchFragment, on2.d
    public /* bridge */ /* synthetic */ void onCancelSearch() {
        on2.c.a(this);
    }

    @Override // com.tencent.mobileqq.search.base.fragment.BaseSearchFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.fromType = arguments.getInt(IProfileCardConst.KEY_FROM_TYPE, -1);
            this.source = arguments.getInt("source", 0);
        }
        super.onCreate(bundle);
        this.searchResultHandler = new com.tencent.mobileqq.search.util.d();
        this.appInterface.addObserver(this.mFriendObserver);
    }

    @Override // com.tencent.mobileqq.search.base.fragment.BaseSearchFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        IFaceDecoder iFaceDecoder = this.faceDecoder;
        if (iFaceDecoder != null) {
            iFaceDecoder.destory();
        }
        this.mHandler.removeCallbacksAndMessages(null);
        this.searchPlayManager.onDestroy();
        this.appInterface.removeObserver(this.mFriendObserver);
        ReportController.o(null, "CliOper", "", "", "0X8005ECE", "0X8005ECE", getSearchModule(), 0, String.valueOf(this.searchTimes), "", this.keyword, "");
        super.onDestroy();
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this.isViewCreated = false;
        this.searchPlayManager.k();
        QFSSearchPrerenderManager.E(getActivity()).q();
    }

    @Override // com.tencent.mobileqq.search.base.fragment.BaseSearchFragment, on2.d
    public void onFinish(List list, pn2.b bVar) {
        if (bVar.a(this.keyword)) {
            onFinish(list, bVar.f426500c);
        } else if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "onFinish not match keyword1:", bVar.f426498a, " keyword2:", this.keyword);
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    @Deprecated
    public /* bridge */ /* synthetic */ void onPartTimeCostReport(String str, String str2, long j3) {
        ne0.a.e(this, str, str2, j3);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        this.searchPlayManager.l();
        SceneTracker.f258213d.traceEnd(TAG);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, com.tencent.biz.richframework.compat.IFragmentCallbacks
    public /* bridge */ /* synthetic */ void onPostThemeChanged() {
        com.tencent.biz.richframework.compat.f.k(this);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment
    public /* bridge */ /* synthetic */ void onPreThemeChanged() {
        com.tencent.biz.richframework.compat.f.l(this);
    }

    public void onResultError(String str, int i3, String str2) {
        QLog.i(TAG, 2, "log for search onResultError, keyword = " + str);
        this.footerLoadingJuhuaView.setVisibility(8);
        hideLoading();
        this.isRequesting = false;
        this.isEnd = true;
        if (this.mResultList.size() != 1 || !(this.mResultList.get(0) instanceof pn2.c) || !((pn2.c) this.mResultList.get(0)).J()) {
            this.footerErrorView.setVisibility(0);
            this.footerErrorView.setOnClickListener(new c());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x027e  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x0274  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x014c  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x026f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onResultSuc(String str, boolean z16, byte[] bArr, boolean z17, List<v> list, int i3, boolean z18, wp2.b bVar) {
        List<v> list2;
        boolean z19;
        List<v> list3;
        boolean z26;
        List<v> list4;
        int i16;
        int i17;
        if (list == null) {
            list2 = new ArrayList();
        } else {
            list2 = list;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "onResultNetSuc, keyword = " + str + ", isFirstReq = " + z16 + ", cookie = " + bArr + ", isEnd = " + z17 + ", resultsize = " + list2.size());
        }
        this.mSearchResultModelPeopleAndTroop.P(z18);
        if (z16) {
            int i18 = 0;
            for (int i19 = 0; i19 < list2.size(); i19++) {
                if (!(list2.get(i19) instanceof com.tencent.mobileqq.search.model.i)) {
                    i18++;
                }
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("project", com.tencent.mobileqq.search.report.b.c());
                jSONObject.put("event_src", "client");
                jSONObject.put("web_num", i18);
            } catch (JSONException e16) {
                QLog.e(TAG, 2, "e = " + e16);
            }
            QQAppInterface qQAppInterface = (QQAppInterface) BaseApplicationImpl.getApplication().getRuntime();
            com.tencent.mobileqq.search.report.b.h(qQAppInterface, new ReportModelDC02528().module("all_result").action("exp_items").ver1(str).ver2(com.tencent.mobileqq.search.report.b.a(this.fromType)).ver7(jSONObject.toString()).session_id(qQAppInterface.getCurrentAccountUin() + SearchUtils.f284963l));
        }
        if (z16) {
            boolean z27 = false;
            boolean z28 = false;
            for (int i26 = 0; i26 < list2.size(); i26++) {
                if (list2.get(i26) instanceof lo2.c) {
                    if (((lo2.c) list2.get(i26)).J() == 1001) {
                        z27 = true;
                    }
                    if (((lo2.c) list2.get(i26)).J() == 1001) {
                        z28 = true;
                    }
                }
            }
            if (z27 && z28) {
                i17 = 90;
            } else if (z27) {
                i17 = 70;
            } else if (z28) {
                i17 = 80;
            } else {
                i16 = 0;
                if (i16 != 0) {
                    ReportController.o(null, "CliOper", "", "", "0X8005ECF", "0X8005ECF", i16, 0, "", "", "", "");
                }
            }
            i16 = i17;
            if (i16 != 0) {
            }
        }
        this.isRequesting = false;
        setCookie(bArr);
        this.isEnd = z17;
        this.footerLoadingJuhuaView.setVisibility(8);
        this.footerErrorView.setVisibility(8);
        int i27 = 0;
        for (v vVar : list2) {
            if (vVar instanceof x) {
                x xVar = (x) vVar;
                if (xVar.o() != null) {
                    i27 += xVar.o().size();
                }
            } else {
                i27++;
            }
        }
        if (z16) {
            if (i27 > 0) {
                SearchUtils.W0("all_result", "exp_net_result", "" + str);
            } else {
                SearchUtils.W0("all_result", "noresult_net", "" + str);
            }
        }
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "handleTabSearchResult isFirstReq==" + z16 + " newSearchDataCount:" + this.newSearchDataCount + "   newSearchIndex:" + this.newSearchIndex + " result.size():" + i27);
        }
        if (!this.isEnd) {
            int i28 = this.newSearchDataCount + i27;
            this.newSearchDataCount = i28;
            int i29 = this.newSearchIndex + 1;
            this.newSearchIndex = i29;
            if (i28 > 20) {
                this.newSearchIndex = 0;
                this.newSearchDataCount = 0;
                this.tempFirstReq = z16;
            } else if (i29 >= 3) {
                if (QLog.isColorLevel()) {
                    QLog.i(TAG, 2, "handleTabSearchResult \u89e6\u53d1\u9650\u9891\u903b\u8f91");
                }
                this.isEnd = true;
            } else {
                startNetNewSearch("onResultSuc not end");
                z19 = true;
                list3 = this.mNetTmpData;
                if (list3 == null && !list3.isEmpty()) {
                    z26 = true;
                } else {
                    z26 = false;
                }
                this.tempFirstReq = z26;
                List<v> b16 = this.searchResultHandler.b(list2, this.fromType);
                list4 = this.mNetTmpData;
                if (list4 != null) {
                    this.tempFirstReq = z16;
                    this.mNetTmpData = b16;
                } else {
                    removeSearchResultByWtiLight(list4, i3);
                    this.mNetTmpData.addAll(b16);
                }
                if (!z19) {
                    this.mIsNetFinish.compareAndSet(false, true);
                    this.sortInfoConfig = bVar;
                    updateData(this.mNetTmpData, this.tempFirstReq, i3);
                    this.tempFirstReq = false;
                }
                this.searchIndex++;
                SearchEnginePerfReporter.m(str, "netUICost");
                SearchEnginePerfReporter.g(str, "netQueryCount", Integer.valueOf(this.newSearchIndex));
                SearchEnginePerfReporter.l(str);
                reportSearchResult(this.fromType, str, this.mResultList);
            }
        }
        z19 = false;
        list3 = this.mNetTmpData;
        if (list3 == null) {
        }
        z26 = false;
        this.tempFirstReq = z26;
        List<v> b162 = this.searchResultHandler.b(list2, this.fromType);
        list4 = this.mNetTmpData;
        if (list4 != null) {
        }
        if (!z19) {
        }
        this.searchIndex++;
        SearchEnginePerfReporter.m(str, "netUICost");
        SearchEnginePerfReporter.g(str, "netQueryCount", Integer.valueOf(this.newSearchIndex));
        SearchEnginePerfReporter.l(str);
        reportSearchResult(this.fromType, str, this.mResultList);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        this.adapter.notifyDataSetChanged();
        this.searchPlayManager.m();
        SceneTracker.f258213d.m(TAG);
    }

    @Override // com.tencent.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i3, int i16, int i17) {
        QLog.d("Q.uniteSearch.GroupSearchFragment arend ", 4, " onScroll" + i3);
        if (this.mScrollState == 0) {
            return;
        }
        if (getQBaseActivity() instanceof UniteSearchActivity) {
        }
        mn2.a aVar = this.adapter;
        if (aVar != null && aVar.getCount() != 0 && this.dataStatus != 0 && (i17 - i3) - i16 < 10 && !this.isRequesting && !this.isEnd) {
            if (this.cookies == null) {
                this.forceRequestStatus = 3;
                startNetSearch(HippyScrollViewEventHelper.EVENT_TYPE_SCROLL);
                showNoMoreResult(false);
                this.footerErrorView.setVisibility(8);
            } else {
                startNetNewSearch(HippyScrollViewEventHelper.EVENT_TYPE_SCROLL);
            }
            this.footerLoadingJuhuaView.setVisibility(0);
        }
    }

    @Override // com.tencent.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i3) {
        List<M> list;
        QLog.d(TAG, 4, " onScrollStateChanged" + i3);
        if (getQBaseActivity() instanceof UniteSearchActivity) {
        }
        this.mScrollState = i3;
        mn2.a aVar = this.adapter;
        if (aVar == null || aVar.getCount() == 0 || this.dataStatus == 0) {
            return;
        }
        if (this.mScrollState != 0 && this.isViewCreated && !this.isRequesting && !this.isEnd && ((list = this.mResultList) == 0 || list.size() < 20)) {
            if (this.cookies == null) {
                this.forceRequestStatus = 3;
                startNetSearch("onScrollStateChanged");
                showNoMoreResult(false);
                this.footerErrorView.setVisibility(8);
            } else {
                startNetNewSearch("onScrollStateChanged");
            }
            this.footerLoadingJuhuaView.setVisibility(0);
        }
        if (i3 == 0) {
            oy3.a.a().c("list_unite_search", false);
        } else {
            oy3.a.a().b("list_unite_search");
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        ((GroupSearchEngine) this.searchEngine).m();
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        ((GroupSearchEngine) this.searchEngine).v();
    }

    @Override // com.tencent.mobileqq.search.base.fragment.BaseSearchFragment, on2.d
    public void onUpdate(List list) {
        if (isDetached()) {
            return;
        }
        QLog.e(TAG, 2, "onUpdate, resultList length= " + list.size());
        if (QLog.isDebugVersion()) {
            ArrayList arrayList = new ArrayList(list.size());
            arrayList.addAll(list);
            QLog.e(TAG, 2, "onUpdate, resultList = " + arrayList);
        }
        ArrayList WashResultList = WashResultList(list);
        this.searchResultHandler.c(WashResultList, this.keyword);
        this.hasLocalData = !WashResultList.isEmpty();
        this.mHandler.sendMessage(this.mHandler.obtainMessage(13, WashResultList));
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment
    public /* bridge */ /* synthetic */ void onUserLeaveHint() {
        com.tencent.biz.richframework.compat.f.m(this);
    }

    @Override // com.tencent.mobileqq.search.base.fragment.BaseSearchFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        QFSSearchPrerenderManager.E(getContext()).c(getActivity());
        this.faceDecoder = ((IQQAvatarService) super.getQBaseActivity().getAppRuntime().getRuntimeService(IQQAvatarService.class, "")).getInstance((AppInterface) getQBaseActivity().getAppRuntime());
        this.adapter = newAdapter();
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
        this.listView.addFooterView(linearLayout);
        this.listView.setAdapter((ListAdapter) this.adapter);
        this.searchPlayManager.j(this.listView);
        showLoading();
        this.noMoreResultView.setText("\u6ca1\u6709\u66f4\u591a\u641c\u7d22\u7ed3\u679c");
        loadData();
        this.isViewCreated = true;
        if (getQBaseActivity() instanceof UniteSearchActivity) {
            ((UniteSearchActivity) getQBaseActivity()).F2(UniteSearchActivity.f282690h0, this.needSearchOnLoad, this.isNeedColorSpan);
            this.needSearchOnLoad = false;
            this.isNeedColorSpan = false;
        }
        preInitEngine();
        preStartFavProcess(this.appInterface);
        FitIMEInsetLayout fitIMEInsetLayout = (FitIMEInsetLayout) view.findViewById(R.id.f72683ri);
        QQAppInterface qQAppInterface = (QQAppInterface) BaseApplicationImpl.getApplication().getRuntime();
        zn2.a aVar = new zn2.a(fitIMEInsetLayout, new d());
        this.floatIMEBar = aVar;
        aVar.d(qQAppInterface);
        this.mSearchResultModelPeopleAndTroop.S = GuildInjectImpl.N();
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment
    public /* bridge */ /* synthetic */ boolean overrideFinish() {
        return com.tencent.biz.richframework.compat.f.o(this);
    }

    @Override // com.tencent.mobileqq.search.tux.a
    public void removeTuxItem() {
        if (this.mResultList == null) {
            return;
        }
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.search.fragment.GroupSearchFragment.5
            @Override // java.lang.Runnable
            public void run() {
                int i3 = 0;
                while (true) {
                    if (i3 < GroupSearchFragment.this.mResultList.size()) {
                        if (GroupSearchFragment.this.mResultList.get(i3) instanceof com.tencent.mobileqq.search.tux.g) {
                            break;
                        } else {
                            i3++;
                        }
                    } else {
                        i3 = -1;
                        break;
                    }
                }
                if (i3 < 0) {
                    return;
                }
                GroupSearchFragment.this.mResultList.remove(i3);
                ((jn2.c) ((BaseSearchFragment) GroupSearchFragment.this).adapter).p(GroupSearchFragment.this.mResultList);
                ((BaseSearchFragment) GroupSearchFragment.this).adapter.notifyDataSetChanged();
            }
        });
    }

    public void resetData() {
        this.dataStatus = 0;
        this.lastReqTime = "";
        this.isRequesting = false;
        this.isEnd = false;
        setFirstClickResultItemFlag(false);
        if (this.isViewCreated) {
            showNoMoreResult(false);
            showLoading();
            this.adapter.notifyDataSetChanged();
            this.footerLoadingJuhuaView.setVisibility(8);
            this.footerErrorView.setVisibility(8);
        }
        this.searchIndex = 0;
    }

    public void setCookie(byte[] bArr) {
        this.cookies = bArr;
    }

    @Override // lo2.an
    public void setFirstClickResultItemFlag(boolean z16) {
        this.mIsFirstClickResultItem = z16;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.search.base.fragment.BaseSearchFragment
    public void showNoMoreResult(boolean z16) {
        TextView textView = this.noMoreResultView;
        if (textView != null) {
            textView.setVisibility(8);
        }
    }

    public void startNetNewSearch(String str) {
        double d16;
        double d17;
        this.isRequesting = true;
        showNoMoreResult(false);
        hideLoading();
        this.footerLoadingJuhuaView.setVisibility(0);
        this.footerErrorView.setVisibility(8);
        if (getQBaseActivity() instanceof com.tencent.mobileqq.search.m) {
            d16 = ((com.tencent.mobileqq.search.m) getQBaseActivity()).getLat();
            d17 = ((com.tencent.mobileqq.search.m) getQBaseActivity()).getLon();
        } else {
            d16 = 0.0d;
            d17 = 0.0d;
        }
        this.lastReqTime = System.currentTimeMillis() + "";
        QLog.i(TAG, 1, "start search index=" + this.searchIndex + " from=" + str);
        if (this.forceRequestStatus == 0) {
            this.forceRequestStatus = 5;
        }
        Bundle bundle = new Bundle();
        bundle.putInt("matchCount", this.matchCount);
        SimpleEventBus.getInstance().dispatchEvent(new UniteSearchEvent(this.keyword, this.lastReqTime, 20, SearchUtils.j(UnifySearchHandler.f195167h), getPublicAccountIdList(), this.forceRequestStatus, this.cookies, d16, d17, true, false, this.fromType, bundle));
        this.forceRequestStatus = 0;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("project", com.tencent.mobileqq.search.report.b.c());
            jSONObject.put("event_src", "client");
            jSONObject.put("get_src", "web");
        } catch (JSONException e16) {
            QLog.e(TAG, 2, "e = " + e16);
        }
        QQAppInterface qQAppInterface = (QQAppInterface) BaseApplicationImpl.getApplication().getRuntime();
        com.tencent.mobileqq.search.report.b.h(qQAppInterface, new ReportModelDC02528().module("all_result").action("load_more").ver1(this.keyword).ver2(com.tencent.mobileqq.search.report.b.a(UniteSearchActivity.f282684b0)).ver7(jSONObject.toString()).session_id(qQAppInterface.getCurrentAccountUin() + SearchUtils.f284963l));
    }

    @Override // com.tencent.mobileqq.search.base.fragment.BaseSearchFragment
    public void startSearch(String str) {
        ao.b();
        VADHelper.f("voice_search_als_cost");
        startSearch(str, 1);
    }

    public void startSearchLocalAndNet(String str) {
        startSearchLocalAndNet(str, false, 0);
    }

    public void updateData(List<v> list, boolean z16, int i3) {
        boolean z17;
        String str;
        List<M> list2;
        long j3;
        String str2;
        if (list.size() > 0) {
            int size = SearchUtils.f284965n.size();
            long j16 = -1;
            for (int i16 = 0; i16 < list.size(); i16++) {
                v vVar = list.get(i16);
                if (vVar instanceof lo2.b) {
                    lo2.b bVar = (lo2.b) vVar;
                    if (bVar.o() != null && bVar.o().size() > 0) {
                        for (int i17 = 0; i17 < bVar.o().size(); i17++) {
                            com.tencent.mobileqq.search.model.y yVar = bVar.o().get(i16);
                            if (yVar instanceof lo2.m) {
                                lo2.m mVar = (lo2.m) yVar;
                                j3 = mVar.J;
                                str2 = mVar.G;
                            } else if (yVar instanceof lo2.c) {
                                lo2.c cVar = (lo2.c) yVar;
                                j3 = cVar.J();
                                str2 = cVar.H;
                            } else {
                                j3 = 0;
                                str2 = "";
                            }
                            SearchUtils.d dVar = new SearchUtils.d();
                            size++;
                            dVar.f284978c = size;
                            dVar.f284977b = j3;
                            dVar.f284980e = str2;
                            dVar.f284976a = bVar.getKeyword();
                            SearchUtils.f284965n.put(yVar, dVar);
                        }
                    }
                    if (j16 == -1) {
                        j16 = bVar.D;
                    }
                } else if (vVar instanceof ad) {
                    size++;
                    ArrayList<lo2.u> arrayList = ((ad) vVar).f283479c0;
                    if (arrayList != null) {
                        Iterator<lo2.u> it = arrayList.iterator();
                        while (it.hasNext()) {
                            lo2.u next = it.next();
                            SearchUtils.d dVar2 = new SearchUtils.d();
                            dVar2.f284978c = size;
                            dVar2.f284976a = ((lo2.m) vVar).getKeyword();
                            SearchUtils.f284965n.put(next, dVar2);
                        }
                    }
                } else if (vVar instanceof ac) {
                    size++;
                    ArrayList<lo2.u> arrayList2 = ((ac) vVar).f283475i0;
                    if (arrayList2 != null) {
                        Iterator<lo2.u> it5 = arrayList2.iterator();
                        while (it5.hasNext()) {
                            lo2.u next2 = it5.next();
                            SearchUtils.d dVar3 = new SearchUtils.d();
                            dVar3.f284978c = size;
                            dVar3.f284976a = ((lo2.m) vVar).getKeyword();
                            SearchUtils.f284965n.put(next2, dVar3);
                        }
                    }
                } else if (vVar instanceof lo2.m) {
                    SearchUtils.d dVar4 = new SearchUtils.d();
                    size++;
                    dVar4.f284978c = size;
                    lo2.m mVar2 = (lo2.m) vVar;
                    dVar4.f284977b = mVar2.J;
                    dVar4.f284980e = mVar2.G;
                    dVar4.f284976a = mVar2.getKeyword();
                    SearchUtils.f284965n.put(vVar, dVar4);
                } else if (vVar instanceof lo2.c) {
                    lo2.c cVar2 = (lo2.c) vVar;
                    long J = cVar2.J();
                    String str3 = cVar2.H;
                    SearchUtils.d dVar5 = new SearchUtils.d();
                    size++;
                    dVar5.f284978c = size;
                    dVar5.f284977b = J;
                    dVar5.f284980e = str3;
                    dVar5.f284976a = cVar2.getKeyword();
                    SearchUtils.f284965n.put(vVar, dVar5);
                } else {
                    if (vVar instanceof pn2.c) {
                        pn2.c cVar3 = (pn2.c) vVar;
                        if (cVar3.I == -4) {
                            SearchUtils.d dVar6 = new SearchUtils.d();
                            size++;
                            dVar6.f284978c = size;
                            dVar6.f284977b = 2073745984L;
                            dVar6.f284976a = cVar3.getSubTitleSpans().toString();
                            SearchUtils.f284965n.put(vVar, dVar6);
                        }
                    }
                    if (vVar instanceof do2.f) {
                        SearchUtils.d dVar7 = new SearchUtils.d();
                        do2.f fVar = (do2.f) vVar;
                        dVar7.f284977b = fVar.F;
                        dVar7.f284980e = fVar.G;
                        SearchUtils.f284965n.put(vVar, dVar7);
                    }
                }
            }
        }
        do2.l findMostUsedGroupModel = findMostUsedGroupModel();
        if (findMostUsedGroupModel != null) {
            this.mNetTmpData = com.tencent.mobileqq.search.mostused.b.m(findMostUsedGroupModel.o(), list);
        } else {
            this.mNetTmpData = list;
        }
        updateResultList(true);
        if (z16 && ((list2 = this.mResultList) == 0 || list2.isEmpty())) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (!y.b()) {
            this.searchResultHandler.c(this.mResultList, this.keyword);
        }
        for (int i18 = 0; i18 < this.mResultList.size(); i18++) {
            if (this.mResultList.get(i18) instanceof ah) {
                SimpleMiniAppConfig.SimpleMiniAppInfo simpleMiniAppInfo = new SimpleMiniAppConfig.SimpleMiniAppInfo();
                simpleMiniAppInfo.appId = ((ah) this.mResultList.get(i18)).f283512b0.X.appId;
                SimpleMiniAppConfig simpleMiniAppConfig = new SimpleMiniAppConfig(simpleMiniAppInfo);
                if (((ah) this.mResultList.get(i18)).f283512b0.X.showMask == 1) {
                    str = "used";
                } else {
                    str = "unused";
                }
                ((IMiniAppService) QRoute.api(IMiniAppService.class)).report4239Async(simpleMiniAppConfig, "search", "click_button", str, this.keyword);
            }
        }
        updateLoadingUI(this.mResultList);
        if (!this.mResultList.isEmpty()) {
            removeSearchResultByWtiLight(this.mResultList, i3);
            updateSearchResult(this.mResultList);
            if (z17) {
                this.listView.setSelection(0);
                return;
            }
            return;
        }
        updateSearchResult(this.mResultList);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public /* bridge */ /* synthetic */ boolean useArgusLifecycle() {
        return ne0.a.f(this);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public /* bridge */ /* synthetic */ ViewModel getViewModel(String str, @NonNull Class cls) {
        return ne0.a.c(this, str, cls);
    }

    public void startSearchLocalAndNet(String str, boolean z16, int i3) {
        this.keyword = str;
        sCurrKeyword = str;
        this.keyWordSrc = i3;
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "GroupSearchFragment isViewCreated " + this.isViewCreated + " startSearch:" + str + "  forceRequestStatus=" + this.forceRequestStatus);
        }
        if (this.isViewCreated && this.appInterface != null) {
            this.floatIMEBar.e(str);
            SearchUtils.f284963l = System.currentTimeMillis();
            SearchUtils.f284965n.clear();
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("project", com.tencent.mobileqq.search.report.b.c());
                jSONObject.put("event_src", "client");
            } catch (JSONException e16) {
                QLog.e(TAG, 2, "e = " + e16);
            }
            SearchEnginePerfReporter.g(str, "preInitEngineCost", Long.valueOf(this.preInitEngineCostTime));
            SearchEnginePerfReporter.g(str, "preloadFavoriteEngineCost", Long.valueOf(this.preLoadFavCostTime));
            com.tencent.mobileqq.search.report.b.h((QQAppInterface) this.appInterface, new ReportModelDC02528().module("all_result").action("search_request").ver1(str).ver2(com.tencent.mobileqq.search.report.b.a(this.fromType)).ver7(jSONObject.toString()).session_id(this.appInterface.getCurrentAccountUin() + SearchUtils.f284963l));
            mn2.a aVar = this.adapter;
            if (aVar instanceof jn2.c) {
                ((jn2.c) aVar).D = str;
            }
            if (z16) {
                if (aVar instanceof jn2.c) {
                    ((jn2.c) aVar).C = this.hotSearchKeyWordId;
                }
                SearchUtils.W0("all_result", "exp_pure_net_result", str);
                showLoading();
                onFinish(new ArrayList(), 4);
                return;
            }
            if (this.fromType == 21 && nn2.a.a() == 0) {
                SearchUtils.W0("all_result", "exp_pure_net_result", str);
                this.forceRequestStatus = 6;
                showLoading();
                onFinish(new ArrayList(), 4);
                return;
            }
            hideLoading();
            SearchEnginePerfReporter.g(str, "isEnginePreInit", Boolean.valueOf(this.isEngineInited));
            if (this.isEngineInited) {
                this.mHandler.removeMessages(100);
                this.mHandler.sendEmptyMessage(100);
                return;
            } else {
                ThreadManagerV2.postImmediately(new Runnable() { // from class: com.tencent.mobileqq.search.fragment.i
                    @Override // java.lang.Runnable
                    public final void run() {
                        GroupSearchFragment.this.lambda$startSearchLocalAndNet$0();
                    }
                }, null, true);
                return;
            }
        }
        QLog.w(TAG, 1, "startSearchForHotWord called  isViewCreated == false!! ");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.search.base.fragment.BaseSearchFragment
    public boolean startSearch(String str, byte[] bArr, int i3) {
        SearchEnginePerfReporter.s(str);
        this.mIsLocalFinish.set(false);
        this.mIsNetFinish.set(false);
        this.mNetTmpData = null;
        this.mLocalTmpData = null;
        boolean startSearch = super.startSearch(str, bArr, i3);
        if (startSearch && y.b() && !isInputPinyin()) {
            startNetSearch("startSearch isOptSearch=true");
        }
        if (i3 == 1) {
            this.mHandler.removeMessages(14);
        }
        return startSearch;
    }

    @Override // com.tencent.mobileqq.search.base.fragment.BaseSearchFragment, on2.d
    public void onFinish(List list, int i3) {
        ArrayList WashResultList;
        if (list == null) {
            list = new ArrayList();
        }
        if (isDetached()) {
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.e(TAG, 2, "onFinish, resultList.size = " + list.size() + ", status = " + i3, new RuntimeException("onfinish"));
        }
        if (i3 != 4 && i3 != 5) {
            WashResultList = new ArrayList(list);
        } else {
            WashResultList = WashResultList(list);
            this.mIsLocalFinish.compareAndSet(false, true);
        }
        addSearchTuxModelIfNeed(WashResultList);
        this.mHandler.removeMessages(14);
        Message obtainMessage = this.mHandler.obtainMessage(14, WashResultList);
        obtainMessage.arg1 = i3;
        this.mHandler.sendMessage(obtainMessage);
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    private class d implements a.b {
        d() {
        }

        @Override // zn2.a.b
        public void a(String str) {
        }
    }
}
