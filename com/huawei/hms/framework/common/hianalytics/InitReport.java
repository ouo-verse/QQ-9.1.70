package com.huawei.hms.framework.common.hianalytics;

import com.huawei.hms.framework.common.Logger;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.RejectedExecutionException;

/* compiled from: P */
/* loaded from: classes2.dex */
public class InitReport {
    private static final int EVENT_LIMIT = 10;
    private static final String TAG = "HaReport";
    private static List<Runnable> eventsToReport = new CopyOnWriteArrayList();
    private static boolean hasConnectNet = false;

    public static void enableConnectNet() {
        hasConnectNet = true;
        try {
            HianalyticsHelper.getInstance().getReportExecutor().submit(new Runnable() { // from class: com.huawei.hms.framework.common.hianalytics.InitReport.1
                @Override // java.lang.Runnable
                public void run() {
                    InitReport.submitAllEvents();
                }
            });
        } catch (RejectedExecutionException unused) {
            Logger.e(TAG, "the thread submit has rejectedExecutionException!");
        } catch (Throwable unused2) {
            Logger.e(TAG, "the thread submit has fatal error!");
        }
    }

    public static void reportWhenInit(Runnable runnable) {
        if (hasConnectNet) {
            try {
                HianalyticsHelper.getInstance().getReportExecutor().execute(runnable);
                return;
            } catch (RejectedExecutionException unused) {
                Logger.e(TAG, "the thread submit has rejectedExecutionException!");
                return;
            } catch (Throwable unused2) {
                Logger.e(TAG, "the thread submit has fatal error!");
                return;
            }
        }
        if (eventsToReport.size() > 10) {
            Logger.e("TAG", "the event to be report when init exceed the limit!");
        } else {
            eventsToReport.add(runnable);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void submitAllEvents() {
        try {
            Iterator<Runnable> it = eventsToReport.iterator();
            while (it.hasNext()) {
                HianalyticsHelper.getInstance().getReportExecutor().submit(it.next());
            }
            eventsToReport.clear();
        } catch (NullPointerException unused) {
            Logger.e(TAG, "event is null occured");
        } catch (RejectedExecutionException unused2) {
            Logger.e(TAG, "submit failed of rejected execution exception");
        } catch (Exception unused3) {
            Logger.e(TAG, "submit failed because of some exception");
        }
    }
}
