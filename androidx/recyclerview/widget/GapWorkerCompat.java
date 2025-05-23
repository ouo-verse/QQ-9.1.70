package androidx.recyclerview.widget;

import android.os.Handler;
import android.view.Display;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.UiThread;
import androidx.core.view.ViewCompat;
import com.tencent.biz.richframework.delegate.impl.RFWConfig;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import java.util.List;

/* compiled from: P */
/* loaded from: classes.dex */
public class GapWorkerCompat {
    private static final String TAG = "GapWorkerCompat";

    public static void addRecyclerView(@NonNull RecyclerView recyclerView) {
        GapWorker gapWorker = GapWorker.sGapWorker.get();
        if (gapWorker != null) {
            gapWorker.add(recyclerView);
        }
    }

    @UiThread
    public static void hookGapWorker(View view, Class cls, List<IRecyclerViewMonitor> list) {
        float f16;
        try {
            ThreadLocal<GapWorker> threadLocal = GapWorker.sGapWorker;
            GapWorker gapWorker = threadLocal.get();
            if (gapWorker == null) {
                GapWorker gapWorker2 = (GapWorker) cls.newInstance();
                Display display = ViewCompat.getDisplay(view);
                if (display != null) {
                    f16 = display.getRefreshRate();
                    if (f16 >= 30.0f) {
                        gapWorker2.mFrameIntervalNs = 1.0E9f / f16;
                        threadLocal.set(new GapWorkerHooker(gapWorker2, list));
                        return;
                    }
                }
                f16 = 60.0f;
                gapWorker2.mFrameIntervalNs = 1.0E9f / f16;
                threadLocal.set(new GapWorkerHooker(gapWorker2, list));
                return;
            }
            if (gapWorker instanceof GapWorkerHooker) {
                return;
            }
            threadLocal.set(new GapWorkerHooker(gapWorker, list));
        } catch (Exception e16) {
            RFWLog.e(TAG, RFWLog.USR, "[fixPrefetchIndexException]", e16);
        }
    }

    public static void removeGapTask(@NonNull RecyclerView recyclerView) {
        GapWorker gapWorker = GapWorker.sGapWorker.get();
        Handler handler = recyclerView.getHandler();
        if (handler != null) {
            handler.removeCallbacks(gapWorker);
        }
    }

    public static void removeRecyclerView(@NonNull RecyclerView recyclerView) {
        GapWorker gapWorker = GapWorker.sGapWorker.get();
        if (gapWorker != null) {
            gapWorker.remove(recyclerView);
        }
    }

    @UiThread
    public static void hookGapWorker(List<IRecyclerViewMonitor> list) {
        if (RFWConfig.getConfigValue("enable_fix_prefetch_index_exception_v2", true)) {
            RFWLog.d(TAG, RFWLog.USR, "fixPrefetchIndexException");
            try {
                ThreadLocal<GapWorker> threadLocal = GapWorker.sGapWorker;
                GapWorker gapWorker = threadLocal.get();
                if (gapWorker == null) {
                    threadLocal.set(new GapWorkerHooker(new GapWorker(), list));
                } else if (!(gapWorker instanceof GapWorkerHooker)) {
                    threadLocal.set(new GapWorkerHooker(gapWorker, list));
                }
            } catch (Exception e16) {
                RFWLog.e(TAG, RFWLog.USR, "[fixPrefetchIndexException]", e16);
            }
        }
    }
}
