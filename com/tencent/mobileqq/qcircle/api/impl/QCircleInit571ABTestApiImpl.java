package com.tencent.mobileqq.qcircle.api.impl;

import android.text.TextUtils;
import com.tencent.biz.richframework.network.util.StringUtils;
import com.tencent.biz.richframework.part.utils.FastClickUtils;
import com.tencent.biz.richframework.part.utils.RFSafeListUtils;
import com.tencent.mobileqq.qcircle.api.IQCircleInit571ABTestApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qzoneplayer.ui.common.PlayerResources;
import com.tencent.mobileqq.utils.abtest.ABTestController;
import com.tencent.mobileqq.utils.abtest.ExpEntityInfo;
import com.tencent.mobileqq.wink.api.IQQWinkABTestReportAPI;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.thread.RFWThreadManager;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import uq3.o;

/* compiled from: P */
/* loaded from: classes16.dex */
public class QCircleInit571ABTestApiImpl implements IQCircleInit571ABTestApi {
    private static final String TAG = "QCircleInit571ABTestApiImpl";
    private static AtomicBoolean isInit;
    private static volatile String sAccountUin;
    private static final List<String> sDefaultReportExpTAB571;
    private static final List<String> sReportExpRetryListTAB571;
    private static AtomicInteger sReportRetryTimesTAB571;
    private static final Runnable sRetryRunnableTAB571;

    static {
        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
        sDefaultReportExpTAB571 = copyOnWriteArrayList;
        sReportExpRetryListTAB571 = new CopyOnWriteArrayList();
        sReportRetryTimesTAB571 = new AtomicInteger(0);
        sRetryRunnableTAB571 = new Runnable() { // from class: com.tencent.mobileqq.qcircle.api.impl.QCircleInit571ABTestApiImpl.1
            @Override // java.lang.Runnable
            public void run() {
                for (String str : QCircleInit571ABTestApiImpl.sReportExpRetryListTAB571) {
                    String assignment = QCircleInit571ABTestApiImpl.getAssignment(str);
                    if (!StringUtils.isEmpty(assignment)) {
                        QCircleInit571ABTestApiImpl.sReportExpRetryListTAB571.remove(str);
                        QCircleInit571ABTestApiImpl.reportExperimentExport(str);
                        QLog.d(QCircleInit571ABTestApiImpl.TAG, 2, "[m571RetryRunnable] reportExperimentExport " + assignment);
                    }
                }
                QCircleInit571ABTestApiImpl.retryTab571Report();
            }
        };
        isInit = new AtomicBoolean(false);
        sAccountUin = "";
        copyOnWriteArrayList.add("exp_xsj_related_content_exp_1");
        copyOnWriteArrayList.add("exp_xsj_mianliu");
        copyOnWriteArrayList.add("exp_notification_qpush_setup_page");
        copyOnWriteArrayList.add("exp_xsj_search_button");
        copyOnWriteArrayList.add("exp_input_recom_v5");
        copyOnWriteArrayList.add("exp_xsj_cmt_hot_and_fiery_bar_1");
        copyOnWriteArrayList.add("exp_bullet2");
        copyOnWriteArrayList.add("exp_xsj_share_to_short_video_mutual_connection_users");
        copyOnWriteArrayList.add("exp_xsj_reconstruction_of_the_continuous_viewing_experience_for_feed_element");
        copyOnWriteArrayList.add("exp_xsj_change_interactive_message_video_play_experience");
        copyOnWriteArrayList.add("exp_bullet");
        copyOnWriteArrayList.add("exp_pymkpromote");
        copyOnWriteArrayList.add("exp_xsj_click_text_enter_graphic_detail_page");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String getAssignment(String str) {
        ExpEntityInfo expEntity = ABTestController.getInstance().getExpEntity(ABTestController.APPID_571, str);
        if (expEntity == null) {
            return "";
        }
        return expEntity.getAssignment();
    }

    private static void remove571RetryRunnable() {
        Runnable runnable = sRetryRunnableTAB571;
        if (runnable != null) {
            RFWThreadManager.getInstance().remove(runnable);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void reportExperimentExport(String str) {
        ExpEntityInfo expEntity = ABTestController.getInstance().getExpEntity(ABTestController.APPID_571, str);
        if (expEntity == null) {
            return;
        }
        expEntity.reportExpExposure();
        com.tencent.qcircle.cooperation.config.debug.e.a(new com.tencent.qcircle.cooperation.config.debug.e(System.currentTimeMillis(), str, PlayerResources.ViewId.EXTENDED_VIEW_LEFT_TOP_CIRCLE, expEntity.getAssignment()));
    }

    private static void resetLastRetryRunnableWhenAccountChange(String str) {
        if (TextUtils.equals(sAccountUin, str)) {
            QLog.d(TAG, 1, "[resetLastRetryRunnableWhenAccountChange] the same account");
            return;
        }
        QLog.d(TAG, 4, "[resetLastRetryRunnableWhenAccountChange]");
        sReportExpRetryListTAB571.clear();
        sReportRetryTimesTAB571.set(0);
        remove571RetryRunnable();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void retryTab571Report() {
        StringBuilder sb5 = new StringBuilder();
        sb5.append("[retryTab571Report] retry size = ");
        List<String> list = sReportExpRetryListTAB571;
        sb5.append(RFSafeListUtils.getSize(list));
        QLog.d(TAG, 4, sb5.toString());
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            QLog.d(TAG, 4, "[retryTab571Report] exp = " + it.next());
        }
        if (!RFSafeListUtils.isEmpty(sReportExpRetryListTAB571) && sReportRetryTimesTAB571.incrementAndGet() <= o.I()) {
            RFWThreadManager.getInstance().execOnSubThread(sRetryRunnableTAB571, o.J());
        }
    }

    public static void tab571ReportWhenEnterQCircle(String str) {
        if (!o.J0()) {
            return;
        }
        resetLastRetryRunnableWhenAccountChange(str);
        sAccountUin = str;
        for (String str2 : sDefaultReportExpTAB571) {
            String assignment = getAssignment(str2);
            if (!StringUtils.isEmpty(assignment)) {
                reportExperimentExport(str2);
                QLog.d(TAG, 2, "[tab571ReportWhenEnterQCircle] reportExperimentExport " + assignment);
            } else {
                sReportExpRetryListTAB571.add(str2);
            }
        }
        retryTab571Report();
    }

    @Override // com.tencent.mobileqq.qcircle.api.IQCircleInit571ABTestApi
    public void init571WhenLoginQCircle() {
        if (!o.W1()) {
            return;
        }
        QLog.d(TAG, 1, "[init571WhenLoginQCircle] isInit =" + isInit);
        String loginAccountUin = ABTestController.getInstance().getLoginAccountUin();
        QLog.d(TAG, 1, "[init571WhenLoginQCircle] sAccountUin =" + sAccountUin + ", account =" + loginAccountUin);
        if (FastClickUtils.isFastDoubleClick("QCircleInit571ABTestApiImpl_tab571ReportWhenEnterQCircle", 250L)) {
            return;
        }
        if (isInit.compareAndSet(false, true)) {
            ABTestController.getInstance().doInit571(loginAccountUin, true);
        }
        tab571ReportWhenEnterQCircle(loginAccountUin);
        ((IQQWinkABTestReportAPI) QRoute.api(IQQWinkABTestReportAPI.class)).reportEnterQCircleExperiment();
    }
}
