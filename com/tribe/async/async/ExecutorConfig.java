package com.tribe.async.async;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.SparseArray;
import com.tencent.qmethod.pandoraex.monitor.NetworkMonitor;
import com.tribe.async.log.SLog;
import java.util.concurrent.TimeUnit;

/* compiled from: P */
/* loaded from: classes27.dex */
public interface ExecutorConfig {
    public static final String TAG = "ExecutorConfig";

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static class CpuExecutorConfig implements ExecutorConfig {
        @Override // com.tribe.async.async.ExecutorConfig
        public int getAliveTime() {
            return 10000;
        }

        @Override // com.tribe.async.async.ExecutorConfig
        public int getCore() {
            int availableProcessors = Runtime.getRuntime().availableProcessors() + 1;
            SLog.d(ExecutorConfig.TAG, "cpu core = " + availableProcessors);
            return availableProcessors;
        }

        @Override // com.tribe.async.async.ExecutorConfig
        public int getMaximum() {
            int availableProcessors = (Runtime.getRuntime().availableProcessors() * 2) + 1;
            SLog.d(ExecutorConfig.TAG, "cpu max = " + availableProcessors);
            return availableProcessors;
        }

        @Override // com.tribe.async.async.ExecutorConfig
        public TimeUnit getTimeUnit() {
            return TimeUnit.MILLISECONDS;
        }
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static class NetworkExecutorConfig implements ExecutorConfig {
        private static final int DEFAULT_THREAD_COUNT = 3;
        private static final int NETWORK_TYPE_2G = 4;
        private static final int NETWORK_TYPE_3G = 3;
        private static final int NETWORK_TYPE_4G = 2;
        private static final int NETWORK_TYPE_UNKNOWN = 5;
        private static final int NETWORK_TYPE_WIFI = 1;
        private static final int NO_NETWORK = 0;
        private static final SparseArray<Integer> sThreadCountMap;
        private Context mApplication;
        private NetworkInfo mNetworkInfo;

        static {
            SparseArray<Integer> sparseArray = new SparseArray<>(6);
            sThreadCountMap = sparseArray;
            sparseArray.append(0, 3);
            sparseArray.append(1, 5);
            sparseArray.append(2, 4);
            sparseArray.append(3, 3);
            sparseArray.append(4, 2);
            sparseArray.append(5, 3);
        }

        public NetworkExecutorConfig(Context context) {
            this.mApplication = context;
        }

        private static int getCurrentNetType(NetworkInfo networkInfo) {
            if (networkInfo != null && networkInfo.isConnectedOrConnecting()) {
                int type = NetworkMonitor.getType(networkInfo);
                if (type != 0) {
                    if (type != 1 && type != 6 && type != 9) {
                        return 5;
                    }
                    return 1;
                }
                int subtype = NetworkMonitor.getSubtype(networkInfo);
                switch (subtype) {
                    case 1:
                    case 2:
                        return 4;
                    case 3:
                    case 4:
                    case 5:
                    case 6:
                        return 3;
                    default:
                        switch (subtype) {
                            case 12:
                                return 3;
                            case 13:
                            case 14:
                            case 15:
                                return 2;
                            default:
                                return 5;
                        }
                }
            }
            return 0;
        }

        private int getThreadCount(NetworkInfo networkInfo) {
            return sThreadCountMap.get(getCurrentNetType(networkInfo)).intValue();
        }

        @Override // com.tribe.async.async.ExecutorConfig
        public int getAliveTime() {
            return 15000;
        }

        @Override // com.tribe.async.async.ExecutorConfig
        public int getCore() {
            Context context = this.mApplication;
            if (context == null) {
                SLog.d(ExecutorConfig.TAG, "mApplication is null, network core is default: 3");
                return 3;
            }
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            this.mNetworkInfo = activeNetworkInfo;
            int threadCount = getThreadCount(activeNetworkInfo);
            SLog.d(ExecutorConfig.TAG, "network core = " + threadCount);
            return threadCount;
        }

        @Override // com.tribe.async.async.ExecutorConfig
        public int getMaximum() {
            int core = getCore() * 2;
            SLog.d(ExecutorConfig.TAG, "network max = " + core);
            return core;
        }

        @Override // com.tribe.async.async.ExecutorConfig
        public TimeUnit getTimeUnit() {
            return TimeUnit.MILLISECONDS;
        }
    }

    int getAliveTime();

    int getCore();

    int getMaximum();

    TimeUnit getTimeUnit();
}
