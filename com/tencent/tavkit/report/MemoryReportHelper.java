package com.tencent.tavkit.report;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Process;
import android.util.Log;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.tencent.mobileqq.perf.block.SystemMethodProxy;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes26.dex */
public class MemoryReportHelper {
    public static final int MIN_TICK_INTERVAL_MS = 1000;
    private static final String TAG = "MemoryReportHelper";
    private static long lastTickTime;
    private Map<String, Consumer> consumerHashMap;

    @Nullable
    private Context context;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public static class Consumer {
        private final String key;
        private long totalM = 0;
        private long count = 0;
        private long maxM = 0;

        public Consumer(String str) {
            this.key = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public long getAvgMB() {
            long j3 = this.count;
            if (j3 == 0) {
                return 0L;
            }
            return this.totalM / j3;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void tick(long j3) {
            this.totalM += j3;
            this.count++;
            if (j3 > this.maxM) {
                this.maxM = j3;
            }
        }

        public long getMaxM() {
            return this.maxM;
        }
    }

    /* compiled from: P */
    /* loaded from: classes26.dex */
    private static class Instance {
        private static final MemoryReportHelper INSTANCE = new MemoryReportHelper();

        Instance() {
        }
    }

    @NotNull
    public static String appendKeys(Collection<String> collection) {
        StringBuilder sb5 = new StringBuilder();
        for (String str : collection) {
            if (sb5.length() > 0) {
                sb5.append(",");
            }
            sb5.append(str);
        }
        return sb5.toString();
    }

    @NotNull
    public static String appendReportKey(Collection<?> collection) {
        ArrayList arrayList = new ArrayList();
        for (Object obj : collection) {
            if (obj instanceof IReportable) {
                arrayList.add(((IReportable) obj).getReportKey());
            }
        }
        return appendKeys(arrayList);
    }

    public static MemoryReportHelper getInstance() {
        return Instance.INSTANCE;
    }

    public static boolean isInIntervalTime() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - lastTickTime < 1000) {
            return true;
        }
        lastTickTime = currentTimeMillis;
        return false;
    }

    public void clear() {
        this.consumerHashMap.clear();
    }

    public Map<String, Long> getAvgMBValues() {
        HashMap hashMap = new HashMap();
        for (Consumer consumer : this.consumerHashMap.values()) {
            if (consumer != null) {
                hashMap.put(consumer.key, Long.valueOf(consumer.getAvgMB()));
            }
        }
        return hashMap;
    }

    public Map<String, Long> getMaxMBValues() {
        HashMap hashMap = new HashMap();
        for (Consumer consumer : this.consumerHashMap.values()) {
            if (consumer != null) {
                hashMap.put(consumer.key, Long.valueOf(consumer.getMaxM()));
            }
        }
        return hashMap;
    }

    @RequiresApi(api = 5)
    public int getPidMemorySize(int i3, Context context) {
        return SystemMethodProxy.getProcessMemoryInfo((ActivityManager) context.getSystemService(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY), new int[]{i3})[0].getTotalPss();
    }

    public void init(Context context) {
        this.context = context;
    }

    public void tick(String str) {
        if (this.context == null) {
            return;
        }
        tick(str, getPidMemorySize(Process.myPid(), this.context) / 1024);
    }

    MemoryReportHelper() {
        this.consumerHashMap = new HashMap();
    }

    public void tick(String str, long j3) {
        Consumer consumer = this.consumerHashMap.get(str);
        if (consumer == null) {
            consumer = new Consumer(str);
            this.consumerHashMap.put(consumer.key, consumer);
        }
        consumer.tick(j3);
        Log.d(TAG, "tick() called with: key = [" + str + "], mb = [" + j3 + "]");
    }
}
