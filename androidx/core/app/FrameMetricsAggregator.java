package androidx.core.app;

import android.app.Activity;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.util.SparseIntArray;
import android.view.FrameMetrics;
import android.view.Window;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes.dex */
public class FrameMetricsAggregator {
    public static final int ANIMATION_DURATION = 256;
    public static final int ANIMATION_INDEX = 8;
    public static final int COMMAND_DURATION = 32;
    public static final int COMMAND_INDEX = 5;
    public static final int DELAY_DURATION = 128;
    public static final int DELAY_INDEX = 7;
    public static final int DRAW_DURATION = 8;
    public static final int DRAW_INDEX = 3;
    public static final int EVERY_DURATION = 511;
    public static final int INPUT_DURATION = 2;
    public static final int INPUT_INDEX = 1;
    private static final int LAST_INDEX = 8;
    public static final int LAYOUT_MEASURE_DURATION = 4;
    public static final int LAYOUT_MEASURE_INDEX = 2;
    public static final int SWAP_DURATION = 64;
    public static final int SWAP_INDEX = 6;
    public static final int SYNC_DURATION = 16;
    public static final int SYNC_INDEX = 4;
    public static final int TOTAL_DURATION = 1;
    public static final int TOTAL_INDEX = 0;
    private FrameMetricsBaseImpl mInstance;

    /* compiled from: P */
    @RequiresApi(24)
    /* loaded from: classes.dex */
    private static class FrameMetricsApi24Impl extends FrameMetricsBaseImpl {
        private static final int NANOS_PER_MS = 1000000;
        private static final int NANOS_ROUNDING_VALUE = 500000;
        private static Handler sHandler;
        private static HandlerThread sHandlerThread;
        int mTrackingFlags;
        SparseIntArray[] mMetrics = new SparseIntArray[9];
        private ArrayList<WeakReference<Activity>> mActivities = new ArrayList<>();
        Window.OnFrameMetricsAvailableListener mListener = new Window.OnFrameMetricsAvailableListener() { // from class: androidx.core.app.FrameMetricsAggregator.FrameMetricsApi24Impl.1
            @Override // android.view.Window.OnFrameMetricsAvailableListener
            public void onFrameMetricsAvailable(Window window, FrameMetrics frameMetrics, int i3) {
                long metric;
                long metric2;
                long metric3;
                long metric4;
                long metric5;
                long metric6;
                long metric7;
                long metric8;
                long metric9;
                FrameMetricsApi24Impl frameMetricsApi24Impl = FrameMetricsApi24Impl.this;
                if ((frameMetricsApi24Impl.mTrackingFlags & 1) != 0) {
                    SparseIntArray sparseIntArray = frameMetricsApi24Impl.mMetrics[0];
                    metric9 = frameMetrics.getMetric(8);
                    frameMetricsApi24Impl.addDurationItem(sparseIntArray, metric9);
                }
                FrameMetricsApi24Impl frameMetricsApi24Impl2 = FrameMetricsApi24Impl.this;
                if ((frameMetricsApi24Impl2.mTrackingFlags & 2) != 0) {
                    SparseIntArray sparseIntArray2 = frameMetricsApi24Impl2.mMetrics[1];
                    metric8 = frameMetrics.getMetric(1);
                    frameMetricsApi24Impl2.addDurationItem(sparseIntArray2, metric8);
                }
                FrameMetricsApi24Impl frameMetricsApi24Impl3 = FrameMetricsApi24Impl.this;
                if ((frameMetricsApi24Impl3.mTrackingFlags & 4) != 0) {
                    SparseIntArray sparseIntArray3 = frameMetricsApi24Impl3.mMetrics[2];
                    metric7 = frameMetrics.getMetric(3);
                    frameMetricsApi24Impl3.addDurationItem(sparseIntArray3, metric7);
                }
                FrameMetricsApi24Impl frameMetricsApi24Impl4 = FrameMetricsApi24Impl.this;
                if ((frameMetricsApi24Impl4.mTrackingFlags & 8) != 0) {
                    SparseIntArray sparseIntArray4 = frameMetricsApi24Impl4.mMetrics[3];
                    metric6 = frameMetrics.getMetric(4);
                    frameMetricsApi24Impl4.addDurationItem(sparseIntArray4, metric6);
                }
                FrameMetricsApi24Impl frameMetricsApi24Impl5 = FrameMetricsApi24Impl.this;
                if ((frameMetricsApi24Impl5.mTrackingFlags & 16) != 0) {
                    SparseIntArray sparseIntArray5 = frameMetricsApi24Impl5.mMetrics[4];
                    metric5 = frameMetrics.getMetric(5);
                    frameMetricsApi24Impl5.addDurationItem(sparseIntArray5, metric5);
                }
                FrameMetricsApi24Impl frameMetricsApi24Impl6 = FrameMetricsApi24Impl.this;
                if ((frameMetricsApi24Impl6.mTrackingFlags & 64) != 0) {
                    SparseIntArray sparseIntArray6 = frameMetricsApi24Impl6.mMetrics[6];
                    metric4 = frameMetrics.getMetric(7);
                    frameMetricsApi24Impl6.addDurationItem(sparseIntArray6, metric4);
                }
                FrameMetricsApi24Impl frameMetricsApi24Impl7 = FrameMetricsApi24Impl.this;
                if ((frameMetricsApi24Impl7.mTrackingFlags & 32) != 0) {
                    SparseIntArray sparseIntArray7 = frameMetricsApi24Impl7.mMetrics[5];
                    metric3 = frameMetrics.getMetric(6);
                    frameMetricsApi24Impl7.addDurationItem(sparseIntArray7, metric3);
                }
                FrameMetricsApi24Impl frameMetricsApi24Impl8 = FrameMetricsApi24Impl.this;
                if ((frameMetricsApi24Impl8.mTrackingFlags & 128) != 0) {
                    SparseIntArray sparseIntArray8 = frameMetricsApi24Impl8.mMetrics[7];
                    metric2 = frameMetrics.getMetric(0);
                    frameMetricsApi24Impl8.addDurationItem(sparseIntArray8, metric2);
                }
                FrameMetricsApi24Impl frameMetricsApi24Impl9 = FrameMetricsApi24Impl.this;
                if ((frameMetricsApi24Impl9.mTrackingFlags & 256) != 0) {
                    SparseIntArray sparseIntArray9 = frameMetricsApi24Impl9.mMetrics[8];
                    metric = frameMetrics.getMetric(2);
                    frameMetricsApi24Impl9.addDurationItem(sparseIntArray9, metric);
                }
            }
        };

        FrameMetricsApi24Impl(int i3) {
            this.mTrackingFlags = i3;
        }

        @Override // androidx.core.app.FrameMetricsAggregator.FrameMetricsBaseImpl
        public void add(Activity activity) {
            if (sHandlerThread == null) {
                BaseHandlerThread baseHandlerThread = new BaseHandlerThread("FrameMetricsAggregator");
                sHandlerThread = baseHandlerThread;
                baseHandlerThread.start();
                sHandler = new Handler(sHandlerThread.getLooper());
            }
            for (int i3 = 0; i3 <= 8; i3++) {
                SparseIntArray[] sparseIntArrayArr = this.mMetrics;
                if (sparseIntArrayArr[i3] == null && (this.mTrackingFlags & (1 << i3)) != 0) {
                    sparseIntArrayArr[i3] = new SparseIntArray();
                }
            }
            activity.getWindow().addOnFrameMetricsAvailableListener(this.mListener, sHandler);
            this.mActivities.add(new WeakReference<>(activity));
        }

        void addDurationItem(SparseIntArray sparseIntArray, long j3) {
            if (sparseIntArray != null) {
                int i3 = (int) ((500000 + j3) / 1000000);
                if (j3 >= 0) {
                    sparseIntArray.put(i3, sparseIntArray.get(i3) + 1);
                }
            }
        }

        @Override // androidx.core.app.FrameMetricsAggregator.FrameMetricsBaseImpl
        public SparseIntArray[] getMetrics() {
            return this.mMetrics;
        }

        @Override // androidx.core.app.FrameMetricsAggregator.FrameMetricsBaseImpl
        public SparseIntArray[] remove(Activity activity) {
            Iterator<WeakReference<Activity>> it = this.mActivities.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                WeakReference<Activity> next = it.next();
                if (next.get() == activity) {
                    this.mActivities.remove(next);
                    break;
                }
            }
            activity.getWindow().removeOnFrameMetricsAvailableListener(this.mListener);
            return this.mMetrics;
        }

        @Override // androidx.core.app.FrameMetricsAggregator.FrameMetricsBaseImpl
        public SparseIntArray[] reset() {
            SparseIntArray[] sparseIntArrayArr = this.mMetrics;
            this.mMetrics = new SparseIntArray[9];
            return sparseIntArrayArr;
        }

        @Override // androidx.core.app.FrameMetricsAggregator.FrameMetricsBaseImpl
        public SparseIntArray[] stop() {
            for (int size = this.mActivities.size() - 1; size >= 0; size--) {
                WeakReference<Activity> weakReference = this.mActivities.get(size);
                Activity activity = weakReference.get();
                if (weakReference.get() != null) {
                    activity.getWindow().removeOnFrameMetricsAvailableListener(this.mListener);
                    this.mActivities.remove(size);
                }
            }
            return this.mMetrics;
        }
    }

    /* compiled from: P */
    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    /* loaded from: classes.dex */
    public @interface MetricType {
    }

    public FrameMetricsAggregator() {
        this(1);
    }

    public void add(@NonNull Activity activity) {
        this.mInstance.add(activity);
    }

    @Nullable
    public SparseIntArray[] getMetrics() {
        return this.mInstance.getMetrics();
    }

    @Nullable
    public SparseIntArray[] remove(@NonNull Activity activity) {
        return this.mInstance.remove(activity);
    }

    @Nullable
    public SparseIntArray[] reset() {
        return this.mInstance.reset();
    }

    @Nullable
    public SparseIntArray[] stop() {
        return this.mInstance.stop();
    }

    public FrameMetricsAggregator(int i3) {
        if (Build.VERSION.SDK_INT >= 24) {
            this.mInstance = new FrameMetricsApi24Impl(i3);
        } else {
            this.mInstance = new FrameMetricsBaseImpl();
        }
    }

    /* compiled from: P */
    /* loaded from: classes.dex */
    private static class FrameMetricsBaseImpl {
        FrameMetricsBaseImpl() {
        }

        public SparseIntArray[] getMetrics() {
            return null;
        }

        public SparseIntArray[] remove(Activity activity) {
            return null;
        }

        public SparseIntArray[] reset() {
            return null;
        }

        public SparseIntArray[] stop() {
            return null;
        }

        public void add(Activity activity) {
        }
    }
}
