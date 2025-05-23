package androidx.recyclerview.widget;

import android.view.Display;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.GapWorker;
import com.tencent.biz.richframework.delegate.impl.RFWApplication;
import com.tencent.biz.richframework.delegate.impl.RFWConfig;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.delegate.impl.RFWReporter;
import com.tencent.biz.richframework.hook.util.RFWFieldUtil;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes.dex */
public class GapWorkerHooker extends GapWorker {
    private static final String TAG = "GapWorkerHooker";
    GapWorker mDelegateGapWorker;
    List<IRecyclerViewMonitor> mMonitors;

    public GapWorkerHooker() {
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x0022, code lost:
    
        if (r5 >= 30.0f) goto L13;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void initFrameInterval(RecyclerView recyclerView) {
        float f16;
        if (recyclerView != null && this.mFrameIntervalNs == 0 && RFWConfig.getConfigValue("enable_fix_prefetch_index_exception_v2", true)) {
            Display display = ViewCompat.getDisplay(recyclerView);
            if (display != null) {
                f16 = display.getRefreshRate();
            }
            f16 = 60.0f;
            this.mFrameIntervalNs = 1.0E9f / f16;
        }
    }

    public static boolean needThrowException(Throwable th5) {
        if (RFWApplication.isDebug()) {
            if (!(th5 instanceof IndexOutOfBoundsException)) {
                return true;
            }
            RFWLog.e(TAG, RFWLog.USR, "catch IndexOutOfBoundsException", th5);
            RFWReporter.reportThrowableCache(th5);
            return false;
        }
        RFWLog.e(TAG, RFWLog.USR, "handleException e:" + th5);
        RFWReporter.reportThrowableCache(th5);
        return false;
    }

    @Override // androidx.recyclerview.widget.GapWorker
    public void add(RecyclerView recyclerView) {
        GapWorker gapWorker = this.mDelegateGapWorker;
        if (gapWorker != null) {
            gapWorker.add(recyclerView);
            initFrameInterval(recyclerView);
        }
        List<IRecyclerViewMonitor> list = this.mMonitors;
        if (list != null) {
            Iterator<IRecyclerViewMonitor> it = list.iterator();
            while (it.hasNext()) {
                it.next().addRecyclerView(recyclerView);
            }
        }
    }

    public void clearTask() {
        GapWorker gapWorker = this.mDelegateGapWorker;
        if (gapWorker == null) {
            return;
        }
        try {
            Object field = RFWFieldUtil.getField(GapWorker.class, gapWorker, "mTasks");
            if (field instanceof List) {
                List list = (List) field;
                for (int i3 = 0; i3 < list.size(); i3++) {
                    GapWorker.Task task = (GapWorker.Task) list.get(i3);
                    if (task.view != null) {
                        task.clear();
                    } else {
                        return;
                    }
                }
            }
        } catch (Exception e16) {
            RFWLog.e(TAG, RFWLog.USR, "clearTask", e16);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // androidx.recyclerview.widget.GapWorker
    public void postFromTraversal(RecyclerView recyclerView, int i3, int i16) {
        if (recyclerView.isAttachedToWindow()) {
            GapWorker gapWorker = this.mDelegateGapWorker;
            if (gapWorker.mPostTimeNs == 0) {
                gapWorker.mPostTimeNs = recyclerView.getNanoTime();
                recyclerView.post(this);
            }
        }
        recyclerView.mPrefetchRegistry.setPrefetchVector(i3, i16);
    }

    @Override // androidx.recyclerview.widget.GapWorker
    public void remove(RecyclerView recyclerView) {
        GapWorker gapWorker = this.mDelegateGapWorker;
        if (gapWorker != null) {
            gapWorker.remove(recyclerView);
        }
        List<IRecyclerViewMonitor> list = this.mMonitors;
        if (list != null) {
            Iterator<IRecyclerViewMonitor> it = list.iterator();
            while (it.hasNext()) {
                it.next().removeRecyclerView(recyclerView);
            }
        }
    }

    @Override // androidx.recyclerview.widget.GapWorker, java.lang.Runnable
    public void run() {
        try {
            GapWorker gapWorker = this.mDelegateGapWorker;
            if (gapWorker != null) {
                gapWorker.run();
            }
        } catch (Throwable th5) {
            if (!needThrowException(th5)) {
                clearTask();
                return;
            }
            throw th5;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public GapWorkerHooker(GapWorker gapWorker, List<IRecyclerViewMonitor> list) {
        this.mDelegateGapWorker = gapWorker;
        this.mMonitors = list;
    }
}
