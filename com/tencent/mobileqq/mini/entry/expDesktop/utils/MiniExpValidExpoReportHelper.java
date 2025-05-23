package com.tencent.mobileqq.mini.entry.expDesktop.utils;

import android.graphics.Rect;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.mini.entry.MiniAppExposureManager;
import com.tencent.mobileqq.mini.entry.desktop.item.DesktopAppInfo;
import com.tencent.mobileqq.mini.entry.desktop.item.DesktopItemInfo;
import com.tencent.mobileqq.mini.entry.newdesktop.part.adapter.MiniAppDesktopRvPartExpoHelper;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import mqq.util.WeakReference;

/* compiled from: P */
/* loaded from: classes33.dex */
public class MiniExpValidExpoReportHelper {
    public static final int DESKTOP_MAIN_PAGE_INDEX = 0;
    public static final int DESKTOP_SUB_PAGE_INDEX = 1;
    private static final double RATIO_VALID_VISIBLE_AREA = 0.8d;
    private static final long VALID_EXPO_DELAY_TIME = 500;
    private String logTag;
    private final Set<String> validExpoReportedData = Collections.synchronizedSet(new HashSet());
    private final ConcurrentHashMap<String, Runnable> mPendingTaskMap = new ConcurrentHashMap<>();
    private final Handler mMainHandler = ThreadManagerV2.getUIHandlerV2();

    /* compiled from: P */
    /* loaded from: classes33.dex */
    public interface ReportKeyConst {
        public static final String REPORT_KEY_HOST_SCENE = "host_scene";
        public static final String REPORT_KEY_MODULE = "module";
        public static final String REPORT_KEY_NOT_POSITION_HOST_SCENE = "not_position_host_scene";
        public static final String REPORT_KEY_POSITION = "position";
        public static final String REPORT_KEY_TAB_TITLE = "tab_title";
        public static final String REPORT_KEY_VIA = "via";
        public static final String REPORT_PAGE_ID = "page_id";
    }

    public MiniExpValidExpoReportHelper(String str) {
        this.logTag = "MiniExpValidExpoReportHelper";
        this.logTag = str + "." + this.logTag;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reportImpl(String str, final MiniAppExposureManager.BaseExposureReport baseExposureReport, WeakReference<View> weakReference) {
        if (this.validExpoReportedData.contains(str) && QLog.isDevelopLevel()) {
            QLog.d(this.logTag, 4, "reportImpl");
            return;
        }
        if (!isViewVisibleAreaValid(weakReference.get()) || baseExposureReport == null) {
            return;
        }
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.mini.entry.expDesktop.utils.c
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

    private void resetExtraParams(int i3, Map<String, String> map) {
        String valueOf;
        map.put("position", String.valueOf(i3));
        String str = map.get(ReportKeyConst.REPORT_KEY_NOT_POSITION_HOST_SCENE);
        if (i3 < 9) {
            valueOf = "0" + (i3 + 1);
        } else {
            valueOf = String.valueOf(i3 + 1);
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        map.put("host_scene", str + valueOf);
    }

    public void beginExpoReport(View view, final MiniAppExposureManager.BaseExposureReport baseExposureReport, final String str) {
        if (this.validExpoReportedData.contains(str)) {
            QLog.d(this.logTag, 4, "beginExpoReport");
            return;
        }
        final WeakReference weakReference = new WeakReference(view);
        Runnable runnable = new Runnable() { // from class: com.tencent.mobileqq.mini.entry.expDesktop.utils.MiniExpValidExpoReportHelper.1
            @Override // java.lang.Runnable
            public void run() {
                MiniExpValidExpoReportHelper.this.reportImpl(str, baseExposureReport, weakReference);
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

    public void reportMiniAppExpoEvent(RecyclerView recyclerView, Map<String, String> map) {
        if (recyclerView != null && recyclerView.getLayoutManager() != null) {
            LinearLayoutManager linearLayoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
            int findLastVisibleItemPosition = linearLayoutManager.findLastVisibleItemPosition();
            for (int findFirstVisibleItemPosition = linearLayoutManager.findFirstVisibleItemPosition(); findFirstVisibleItemPosition <= findLastVisibleItemPosition; findFirstVisibleItemPosition++) {
                RecyclerView.ViewHolder findViewHolderForAdapterPosition = recyclerView.findViewHolderForAdapterPosition(findFirstVisibleItemPosition);
                if (findViewHolderForAdapterPosition != null) {
                    resetExtraParams(findFirstVisibleItemPosition, map);
                    sendMiniAppExpoReport(findViewHolderForAdapterPosition, map);
                }
            }
            return;
        }
        QLog.d(this.logTag, 1, "reportMiniAppExpoEvent miniAppRv or getLayoutManager is null!");
    }

    private void recordPendingTask(String str, Runnable runnable) {
        if (runnable == null) {
            return;
        }
        this.mPendingTaskMap.put(str, runnable);
    }

    public void sendMiniAppExpoReport(RecyclerView.ViewHolder viewHolder, Map<String, String> map) {
        String str;
        String str2;
        if (map != null && !map.isEmpty() && map.containsKey("position")) {
            DesktopItemInfo desktopItemInfo = (DesktopItemInfo) viewHolder.itemView.getTag();
            if (desktopItemInfo instanceof DesktopAppInfo) {
                DesktopAppInfo desktopAppInfo = (DesktopAppInfo) desktopItemInfo;
                if (desktopAppInfo.mMiniAppInfo != null) {
                    MiniAppConfig miniAppConfig = new MiniAppConfig(desktopAppInfo.mMiniAppInfo);
                    if (miniAppConfig.config.isWxMiniApp()) {
                        if (map.containsKey("host_scene")) {
                            miniAppConfig.config.hostScene = map.get("host_scene");
                        }
                        miniAppConfig.launchParam.scene = 9999;
                        MiniAppInfo miniAppInfo = miniAppConfig.config;
                        miniAppInfo.extInfo = "";
                        miniAppInfo.via = "";
                    } else {
                        MiniAppInfo miniAppInfo2 = miniAppConfig.config;
                        miniAppInfo2.hostScene = "";
                        miniAppConfig.launchParam.scene = 3422;
                        miniAppInfo2.extInfo = String.valueOf(3422);
                        miniAppConfig.config.via = map.get("via");
                    }
                    if (map.containsKey("position") && map.get("position") != null) {
                        miniAppConfig.config.position = Integer.parseInt(map.get("position")) + 1;
                    }
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
                    MiniAppExposureManager.MiniAppModuleExposureData miniAppModuleExposureData = new MiniAppExposureManager.MiniAppModuleExposureData(miniAppConfig, "page_view", "expo", null, null, str, str2);
                    miniAppModuleExposureData.setModule(map.get("module"));
                    miniAppModuleExposureData.setPageId(map.get("page_id"));
                    miniAppModuleExposureData.setTabTitle(map.get(ReportKeyConst.REPORT_KEY_TAB_TITLE));
                    miniAppModuleExposureData.setHostScene(map.get("host_scene"));
                    beginExpoReport(viewHolder.itemView, miniAppModuleExposureData, buildMiniAppExpoReportIdentity + MiniAppExposureManager.EXPO);
                    return;
                }
                return;
            }
            return;
        }
        QLog.d(this.logTag, 1, "sendMiniAppExpoReport is invalid!");
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

    public void cancelMiniAppExpoReport(RecyclerView.ViewHolder viewHolder, DesktopItemInfo desktopItemInfo) {
        MiniAppInfo miniAppInfo;
        if (viewHolder == null || desktopItemInfo == null || !(desktopItemInfo instanceof DesktopAppInfo) || (miniAppInfo = ((DesktopAppInfo) desktopItemInfo).mMiniAppInfo) == null) {
            return;
        }
        cancelExpoReport(MiniAppDesktopRvPartExpoHelper.INSTANCE.buildMiniAppExpoReportIdentity(miniAppInfo) + MiniAppExposureManager.EXPO);
    }

    public int getPositionInfoByViewHolder(List<DesktopAppInfo> list, RecyclerView.ViewHolder viewHolder) {
        if (list != null && viewHolder != null && !list.isEmpty()) {
            Object tag = viewHolder.itemView.getTag();
            int size = list.size();
            for (int i3 = 0; i3 < size; i3++) {
                if ((tag instanceof DesktopAppInfo) && ((DesktopAppInfo) tag).mMiniAppInfo.appId.equals(list.get(i3).mMiniAppInfo.appId)) {
                    return i3;
                }
            }
        }
        return 0;
    }
}
