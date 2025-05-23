package com.tencent.mobileqq.mini.report;

import android.graphics.Rect;
import android.os.Handler;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ListAdapter;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.mini.entry.MiniAppExposureManager;
import com.tencent.mobileqq.mini.entry.desktop.item.DesktopAppInfo;
import com.tencent.mobileqq.mini.entry.desktop.item.DesktopItemInfo;
import com.tencent.mobileqq.mini.entry.newdesktop.part.adapter.MiniAppDesktopRvPartExpoHelper;
import com.tencent.mobileqq.mini.entry.search.comm.SearchInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import mqq.util.WeakReference;

/* compiled from: P */
/* loaded from: classes33.dex */
public class MiniValidExpoReportHelper {
    private static final long DATA_UPDATE_DELAY_TIME = 500;
    private static final String IDENTITY_SEARCH_REPORT_TASK = "identity_search_report_task";
    private static final double RATIO_VALID_VISIBLE_AREA = 0.8d;
    private static final long VALID_EXPO_DELAY_TIME = 500;
    private String logTag;
    private final Handler mMainHandler;
    private final ConcurrentHashMap<String, Runnable> mPendingTaskMap;
    private final Set<String> validExpoReportedData;

    public MiniValidExpoReportHelper() {
        this.logTag = "MiniValidExpoReportHelper";
        this.validExpoReportedData = Collections.synchronizedSet(new HashSet());
        this.mPendingTaskMap = new ConcurrentHashMap<>();
        this.mMainHandler = ThreadManagerV2.getUIHandlerV2();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$sendMiniAppExpoReport$1(DesktopItemInfo desktopItemInfo, int i3, RecyclerView.ViewHolder viewHolder) {
        String str;
        String str2;
        if (desktopItemInfo instanceof DesktopAppInfo) {
            DesktopAppInfo desktopAppInfo = (DesktopAppInfo) desktopItemInfo;
            if (desktopAppInfo.mMiniAppInfo != null) {
                MiniAppConfig miniAppConfig = new MiniAppConfig(desktopAppInfo.mMiniAppInfo);
                miniAppConfig.launchParam.scene = 3422;
                String buildMiniAppExpoReportIdentity = MiniAppDesktopRvPartExpoHelper.INSTANCE.buildMiniAppExpoReportIdentity(desktopAppInfo.mMiniAppInfo);
                if (desktopAppInfo.isRecommendBadgeShow()) {
                    str = "1";
                } else {
                    str = "0";
                }
                if (desktopAppInfo.isBubbleShown()) {
                    str2 = "1";
                } else {
                    str2 = "0";
                }
                String str3 = str;
                String str4 = str2;
                MiniAppExposureManager.MiniAppModuleExposureData miniAppModuleExposureData = new MiniAppExposureManager.MiniAppModuleExposureData(miniAppConfig, "page_view", "expo_valid", null, String.valueOf(i3), str3, str4);
                beginExpoReport(viewHolder.itemView, miniAppModuleExposureData, buildMiniAppExpoReportIdentity + MiniAppExposureManager.EXPO_VALID);
                MiniAppExposureManager.MiniAppModuleExposureData miniAppModuleExposureData2 = new MiniAppExposureManager.MiniAppModuleExposureData(miniAppConfig, "page_view", "expo", null, null, str3, str4);
                beginExpoReport(viewHolder.itemView, miniAppModuleExposureData2, buildMiniAppExpoReportIdentity + MiniAppExposureManager.EXPO);
                MiniAppExposureManager.MiniAppModuleExposureData miniAppModuleExposureData3 = new MiniAppExposureManager.MiniAppModuleExposureData(miniAppConfig, "desktop", MiniProgramLpReportDC04239.DESKTOP_SUB_ACTION_TYPE_MY_APP, "expo", null);
                beginExpoReport(viewHolder.itemView, miniAppModuleExposureData3, buildMiniAppExpoReportIdentity + MiniAppExposureManager.EXPO_CATEGORY);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reportImpl(String str, final MiniAppExposureManager.BaseExposureReport baseExposureReport, WeakReference<View> weakReference) {
        if (this.validExpoReportedData.contains(str) || !isViewVisibleAreaValid(weakReference.get()) || baseExposureReport == null) {
            return;
        }
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.mini.report.g
            @Override // java.lang.Runnable
            public final void run() {
                MiniAppExposureManager.BaseExposureReport.this.report();
            }
        }, 64, null, false);
        this.validExpoReportedData.add(str);
        if (QLog.isDevelopLevel()) {
            QLog.d(this.logTag, 4, "valid expo report data: " + str + ", reportData:" + baseExposureReport);
        }
    }

    private void sendMiniAppExpoReport(final RecyclerView.ViewHolder viewHolder, final int i3) {
        final DesktopItemInfo desktopItemInfo = (DesktopItemInfo) viewHolder.itemView.getTag();
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.mini.report.f
            @Override // java.lang.Runnable
            public final void run() {
                MiniValidExpoReportHelper.this.lambda$sendMiniAppExpoReport$1(desktopItemInfo, i3, viewHolder);
            }
        }, 16, null, true);
    }

    public void beginExpoReport(View view, final MiniAppExposureManager.BaseExposureReport baseExposureReport, final String str) {
        if (this.validExpoReportedData.contains(str)) {
            return;
        }
        final WeakReference weakReference = new WeakReference(view);
        Runnable runnable = new Runnable() { // from class: com.tencent.mobileqq.mini.report.MiniValidExpoReportHelper.1
            @Override // java.lang.Runnable
            public void run() {
                MiniValidExpoReportHelper.this.reportImpl(str, baseExposureReport, weakReference);
            }
        };
        this.mMainHandler.postDelayed(runnable, 500L);
        recordPendingTask(str, runnable);
    }

    public void cancelExpoReport(String str) {
        Runnable runnable = this.mPendingTaskMap.get(str);
        if (runnable != null) {
            this.mMainHandler.removeCallbacks(runnable);
        }
    }

    public void doValidExpoReportInSearchResultDelay(final AbsListView absListView, final int i3) {
        Runnable runnable = new Runnable() { // from class: com.tencent.mobileqq.mini.report.MiniValidExpoReportHelper.2
            @Override // java.lang.Runnable
            public void run() {
                MiniValidExpoReportHelper.this.doValidExpoReportInSearchResult(absListView, i3);
            }
        };
        this.mMainHandler.postDelayed(runnable, 500L);
        recordPendingTask(IDENTITY_SEARCH_REPORT_TASK, runnable);
    }

    public void stopValidExpoReport(boolean z16) {
        ArrayList arrayList = new ArrayList(this.mPendingTaskMap.values());
        this.mPendingTaskMap.clear();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            this.mMainHandler.removeCallbacks((Runnable) it.next());
        }
        if (z16) {
            this.validExpoReportedData.clear();
        }
    }

    public void reportMiniAppExpoEvent(RecyclerView recyclerView) {
        if (recyclerView != null && recyclerView.getLayoutManager() != null) {
            LinearLayoutManager linearLayoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
            int findLastVisibleItemPosition = linearLayoutManager.findLastVisibleItemPosition();
            for (int findFirstVisibleItemPosition = linearLayoutManager.findFirstVisibleItemPosition(); findFirstVisibleItemPosition < findLastVisibleItemPosition; findFirstVisibleItemPosition++) {
                RecyclerView.ViewHolder findViewHolderForAdapterPosition = recyclerView.findViewHolderForAdapterPosition(findFirstVisibleItemPosition);
                if (findViewHolderForAdapterPosition != null) {
                    sendMiniAppExpoReport(findViewHolderForAdapterPosition, findFirstVisibleItemPosition);
                }
            }
            return;
        }
        QLog.i(this.logTag, 1, "reportMiniAppExpoEvent miniAppRv or getLayoutManager is null!");
    }

    private void recordPendingTask(String str, Runnable runnable) {
        if (runnable == null) {
            return;
        }
        this.mPendingTaskMap.put(str, runnable);
    }

    private static boolean isViewVisibleAreaValid(View view) {
        if (view == null || !view.isShown()) {
            return false;
        }
        Rect rect = new Rect();
        Boolean valueOf = Boolean.valueOf(view.getGlobalVisibleRect(rect));
        if (!(((double) rect.height()) > ((double) view.getHeight()) * RATIO_VALID_VISIBLE_AREA)) {
            return false;
        }
        Rect rect2 = new Rect();
        view.getWindowVisibleDisplayFrame(rect2);
        return valueOf.booleanValue() && Boolean.valueOf(rect2.contains(rect)).booleanValue();
    }

    public void doValidExpoReportInSearchResult(AbsListView absListView, int i3) {
        String str;
        int firstVisiblePosition = absListView.getFirstVisiblePosition();
        int lastVisiblePosition = absListView.getLastVisiblePosition();
        for (int i16 = 0; i16 < absListView.getChildCount(); i16++) {
            View childAt = absListView.getChildAt(i16);
            int positionForView = absListView.getPositionForView(childAt);
            if (positionForView >= firstVisiblePosition && positionForView <= lastVisiblePosition && positionForView < ((ListAdapter) absListView.getAdapter()).getCount()) {
                Object item = ((ListAdapter) absListView.getAdapter()).getItem(positionForView);
                if (item instanceof SearchInfo) {
                    MiniAppInfo miniAppInfo = ((SearchInfo) item).getMiniAppInfo();
                    MiniAppConfig miniAppConfig = new MiniAppConfig(miniAppInfo);
                    miniAppConfig.launchParam.scene = i3;
                    if (i3 == 3026) {
                        str = "search_expo_valid";
                    } else {
                        str = "search_expo_valid_recommend";
                    }
                    beginExpoReport(childAt, new MiniAppExposureManager.MiniAppModuleExposureData(miniAppConfig, "desktop", str, null, String.valueOf(positionForView)), "expo_data: appName:" + miniAppInfo.name + " position:" + positionForView + " scene:" + miniAppConfig.launchParam.scene);
                }
            }
        }
    }

    public MiniValidExpoReportHelper(String str) {
        this.logTag = "MiniValidExpoReportHelper";
        this.validExpoReportedData = Collections.synchronizedSet(new HashSet());
        this.mPendingTaskMap = new ConcurrentHashMap<>();
        this.mMainHandler = ThreadManagerV2.getUIHandlerV2();
        this.logTag = str + "." + this.logTag;
    }
}
