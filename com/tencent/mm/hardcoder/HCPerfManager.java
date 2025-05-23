package com.tencent.mm.hardcoder;

import android.os.Build;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.commonsdk.pool.RecyclablePool;
import com.tencent.open.base.g;
import com.tencent.opentelemetry.semconv.resource.attributes.ResourceAttributes;
import com.tencent.qmethod.pandoraex.monitor.RuntimeMonitor;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import com.tencent.util.AppSetting;
import com.tencent.util.AssertUtil;
import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/* loaded from: classes9.dex */
public class HCPerfManager {
    private static final long DEFAULT_WAKE_INTERVAL = 30000;
    public static boolean IS_TEST = false;
    static final String SO_MD5_FOR_32 = "7b7ea04cc0529c57e7ae3613fe7ab8e1";
    static final String SO_MD5_FOR_64 = "054edaffe59bfdcd2c229ec9b6e4ea35";
    private static final String TAG = "HardCoder.HCPerfManager";
    private static final String sClientsock = "testapp.hardcoder.client.sock";
    private static HCPerfManager sInstance = null;
    private static final String sServerPropKey = "persist.sys.hardcoder.name";
    private LinkedBlockingQueue<Object> queueTask = new LinkedBlockingQueue<>();
    private boolean running = false;
    private static final int[] CPU_LEVEL = {0, 1, 2, 3};
    private static final int[] IO_LEVEL = {0, 1, 2, 3};
    static RecyclablePool sStartTaskPool = new RecyclablePool(PerformanceTask.class, 4);
    static RecyclablePool sStopTaskPool = new RecyclablePool(PerformanceTaskStop.class, 4);
    static final String SO_PATH_OLD = BaseApplication.getContext().getFilesDir() + "/pddata/prd/hc/hardcoder.so";
    static final String SO_PATH_FOR_64 = BaseApplication.getContext().getFilesDir() + "/pddata/prd/hc/arm64/hardcoder_new.so";
    static final String SO_PATH_FOR_32 = BaseApplication.getContext().getFilesDir() + "/pddata/prd/hc/arm/hardcoder_new.so";

    /* loaded from: classes9.dex */
    public static class PerformanceTask extends RecyclablePool.Recyclable {
        public String tag;
        public long sceneStopTime = 0;
        public int delay = 0;
        public int timeout = 0;
        public int cpuLevel = 0;
        public int gpuLevel = 0;
        public int ioLevel = 0;
        public int[] bindTids = null;
        public int scene = 0;
        public long action = 0;
        public long startTime = 0;
        public long initTime = 0;
        public long stopTime = 0;
        public int callerTid = 0;
        public int lastCpuLevel = 0;
        public int lastIoLevel = 0;
        public long lastUpdateTime = 0;
        public int[] cpuLevelTimeArray = new int[HCPerfManager.CPU_LEVEL.length];
        public int[] ioLevelTimeArray = new int[HCPerfManager.IO_LEVEL.length];
        public int[] bindCoreThreadIdArray = null;
        public long averageCoreFreq = 0;

        public String bindTidsToString() {
            if (isNeedBindTids()) {
                StringBuilder sb5 = new StringBuilder("[");
                for (int i3 : this.bindTids) {
                    sb5.append("" + i3 + " ");
                }
                sb5.append("]");
                return sb5.toString();
            }
            return "[ ]";
        }

        public boolean isNeedBindTids() {
            int[] iArr = this.bindTids;
            if (iArr == null || iArr.length <= 0 || (iArr.length == 1 && iArr[0] <= 0)) {
                return false;
            }
            return true;
        }

        public String toString(long j3) {
            return String.format("hashCode:%x time:[init:%d, start:%d, stop:%d][delay:%d, timeout:%d][scene:%d, action:%d, callerTid:%d][cpu:%d, io:%d, gpu:%d] bindTids:%s [TAG:%s]", Integer.valueOf(hashCode()), Long.valueOf(this.initTime - j3), Long.valueOf(this.startTime - j3), Long.valueOf(this.stopTime - j3), Integer.valueOf(this.delay), Integer.valueOf(this.timeout), Integer.valueOf(this.scene), Long.valueOf(this.action), Integer.valueOf(this.callerTid), Integer.valueOf(this.cpuLevel), Integer.valueOf(this.ioLevel), Integer.valueOf(this.gpuLevel), bindTidsToString(), this.tag);
        }

        public void update(long j3) {
            this.averageCoreFreq = (this.averageCoreFreq + j3) / 2;
        }
    }

    /* loaded from: classes9.dex */
    public static final class PerformanceTaskStop extends RecyclablePool.Recyclable {
        public long sceneStopTime = 0;
        public int hashCode = 0;
    }

    public static HCPerfManager getInstance() {
        if (sInstance == null) {
            synchronized (HCPerfManager.class) {
                if (sInstance == null) {
                    sInstance = new HCPerfManager();
                }
            }
        }
        return sInstance;
    }

    public static String getSoMd5() {
        if (AppSetting.isCpu64Bit()) {
            return SO_MD5_FOR_64;
        }
        return SO_MD5_FOR_32;
    }

    public static String getSoPath() {
        if (AppSetting.isCpu64Bit()) {
            return SO_PATH_FOR_64;
        }
        return SO_PATH_FOR_32;
    }

    private boolean isParamsValid(int i3, int i16, int i17, int i18, int[] iArr, int i19) {
        if (i3 >= 0 && i16 >= 0 && i18 >= 0 && i17 >= 0 && iArr != null && iArr.length >= 0 && i19 > 0) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:273:0x092b  */
    /* JADX WARN: Removed duplicated region for block: B:276:0x0937  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void run() {
        PerformanceTask performanceTask;
        HashSet hashSet;
        long j3;
        PerformanceTask performanceTask2;
        PerformanceTask performanceTask3;
        String str;
        String str2;
        PerformanceTask performanceTask4;
        long j16;
        HashSet hashSet2;
        PerformanceTask performanceTask5;
        PerformanceTask performanceTask6;
        long j17;
        PerformanceTask performanceTask7;
        PerformanceTask performanceTask8;
        int i3;
        int i16;
        PerformanceTask performanceTask9;
        HashSet hashSet3;
        int i17;
        int i18;
        int i19;
        int i26;
        PerformanceTask performanceTask10;
        HashSet hashSet4;
        int i27;
        int i28;
        PerformanceTask performanceTask11;
        PerformanceTask performanceTask12;
        int i29;
        int i36;
        int i37;
        int i38;
        long j18;
        int i39;
        PerformanceTask performanceTask13;
        int i46;
        String str3;
        PerformanceTask performanceTask14;
        HashSet hashSet5;
        PerformanceTask performanceTask15;
        int i47;
        String str4;
        PerformanceTask performanceTask16;
        int i48;
        String str5;
        HashSet hashSet6;
        HashSet hashSet7;
        String performanceTask17;
        String str6;
        String performanceTask18;
        String performanceTask19;
        String performanceTask20;
        PerformanceTask performanceTask21;
        HashMap hashMap;
        HashSet hashSet8;
        HashSet hashSet9;
        int i49;
        int i56;
        int i57;
        Object obj;
        HCPerfManager hCPerfManager = this;
        Object[] objArr = new Object[2];
        int i58 = 0;
        objArr[0] = Long.valueOf(Thread.currentThread() == null ? -1L : Thread.currentThread().getId());
        int i59 = 1;
        objArr[1] = Thread.currentThread().getName();
        String format = String.format("HCPerfManager thread run start, id:%d, name:%s", objArr);
        String str7 = TAG;
        Log.i(TAG, format);
        HashSet hashSet10 = new HashSet();
        ArrayList arrayList = new ArrayList();
        HashMap hashMap2 = new HashMap();
        HashSet hashSet11 = new HashSet();
        HashSet hashSet12 = hashSet10;
        PerformanceTask performanceTask22 = null;
        PerformanceTask performanceTask23 = null;
        long j19 = 30000;
        PerformanceTask performanceTask24 = null;
        while (hCPerfManager.running) {
            long currentTimeMillis = System.currentTimeMillis();
            int size = hCPerfManager.queueTask.size();
            if (HardCoderJNI.hcDebug) {
                Log.d(str7, "StartLoop queue:" + size + " startTask:" + arrayList.size() + " nextWakeInterval:" + j19);
            }
            int i65 = i58;
            while (true) {
                if (i65 >= (size == 0 ? i59 : size)) {
                    break;
                }
                try {
                    obj = hCPerfManager.queueTask.poll(j19, TimeUnit.MILLISECONDS);
                } catch (Exception e16) {
                    Log.e(str7, "queueTask poll: " + e16.getMessage());
                    obj = null;
                }
                if (obj == null) {
                    break;
                }
                if (obj instanceof PerformanceTask) {
                    PerformanceTask performanceTask25 = (PerformanceTask) obj;
                    arrayList.add(performanceTask25);
                    hashSet11.add(Integer.valueOf(performanceTask25.hashCode()));
                } else if (obj instanceof PerformanceTaskStop) {
                    PerformanceTaskStop performanceTaskStop = (PerformanceTaskStop) obj;
                    int i66 = performanceTaskStop.hashCode;
                    if (hashSet11.contains(Integer.valueOf(i66))) {
                        hashMap2.put(Integer.valueOf(i66), performanceTaskStop);
                    } else {
                        performanceTaskStop.recycle();
                    }
                } else if (HardCoderJNI.checkEnv) {
                    AssertUtil.fail("queueTask poll invalid object");
                } else {
                    uninit();
                    break;
                }
                i65++;
                i59 = 1;
            }
            HashSet hashSet13 = new HashSet();
            long currentTimeMillis2 = System.currentTimeMillis();
            if (HardCoderJNI.hcDebug) {
                Log.d(str7, "InLoop startSize:" + arrayList.size());
            }
            PerformanceTask performanceTask26 = performanceTask22;
            PerformanceTask performanceTask27 = performanceTask23;
            PerformanceTask performanceTask28 = null;
            int i67 = 0;
            PerformanceTask performanceTask29 = null;
            PerformanceTask performanceTask30 = null;
            long j26 = 30000;
            while (true) {
                performanceTask = performanceTask24;
                hashSet = hashSet12;
                if (i67 >= arrayList.size()) {
                    break;
                }
                PerformanceTask performanceTask31 = (PerformanceTask) arrayList.get(i67);
                long j27 = currentTimeMillis2;
                long currentTimeMillis3 = System.currentTimeMillis();
                if (performanceTask31 == null) {
                    hashSet9 = hashSet13;
                    hashMap = hashMap2;
                    hashSet8 = hashSet11;
                } else {
                    HashSet hashSet14 = hashSet13;
                    if (hashMap2.containsKey(Integer.valueOf(performanceTask31.hashCode()))) {
                        performanceTask31.stopTime = currentTimeMillis3;
                        performanceTask21 = performanceTask28;
                        performanceTask31.sceneStopTime = ((PerformanceTaskStop) hashMap2.get(Integer.valueOf(performanceTask31.hashCode()))).sceneStopTime;
                        hashMap2.remove(Integer.valueOf(performanceTask31.hashCode()));
                    } else {
                        performanceTask21 = performanceTask28;
                    }
                    long j28 = performanceTask31.stopTime - currentTimeMillis3;
                    if (j28 <= 0) {
                        if (HardCoderJNI.hcDebug) {
                            Log.d(str7, "InLoop STOP:" + i67 + "/" + arrayList.size() + " task:" + performanceTask31.toString(currentTimeMillis3));
                        }
                        arrayList.remove(performanceTask31);
                        hashSet11.remove(Integer.valueOf(performanceTask31.hashCode()));
                        performanceTask31.recycle();
                        i67--;
                        hashMap = hashMap2;
                        hashSet8 = hashSet11;
                    } else {
                        j26 = Math.min(j26, j28);
                        long j29 = performanceTask31.startTime - currentTimeMillis3;
                        if (j29 > 0) {
                            if (HardCoderJNI.hcDebug) {
                                hashSet8 = hashSet11;
                                StringBuilder sb5 = new StringBuilder();
                                hashMap = hashMap2;
                                sb5.append("InLoop WAIT:");
                                sb5.append(i67);
                                sb5.append("/");
                                sb5.append(arrayList.size());
                                sb5.append(" task:");
                                sb5.append(performanceTask31.toString(currentTimeMillis3));
                                Log.d(str7, sb5.toString());
                            } else {
                                hashMap = hashMap2;
                                hashSet8 = hashSet11;
                            }
                            j26 = Math.min(j26, j29);
                        } else {
                            hashMap = hashMap2;
                            hashSet8 = hashSet11;
                            if (HardCoderJNI.hcDebug) {
                                Log.d(str7, "InLoop  RUN:" + i67 + "/" + arrayList.size() + " task:" + performanceTask31.toString(currentTimeMillis3));
                            }
                            int i68 = performanceTask31.cpuLevel;
                            if (i68 > 0 && (performanceTask30 == null || (i57 = performanceTask30.cpuLevel) > i68 || (i57 == i68 && performanceTask30.stopTime < performanceTask31.stopTime))) {
                                performanceTask30 = performanceTask31;
                            }
                            int i69 = performanceTask31.gpuLevel;
                            if (i69 <= 0) {
                                performanceTask28 = performanceTask21;
                            } else if (performanceTask21 == null || (i56 = (performanceTask28 = performanceTask21).gpuLevel) > i69 || (i56 == i69 && performanceTask28.stopTime < performanceTask31.stopTime)) {
                                performanceTask28 = performanceTask31;
                            }
                            int i75 = performanceTask31.ioLevel;
                            if (i75 > 0 && (performanceTask29 == null || (i49 = performanceTask29.ioLevel) > i75 || (i49 == i75 && performanceTask29.stopTime < performanceTask31.stopTime))) {
                                performanceTask29 = performanceTask31;
                            }
                            for (int i76 : performanceTask31.bindTids) {
                                if (i76 > 0) {
                                    hashSet9 = hashSet14;
                                    hashSet9.add(performanceTask31);
                                    break;
                                }
                            }
                            hashSet9 = hashSet14;
                        }
                    }
                    performanceTask28 = performanceTask21;
                    hashSet9 = hashSet14;
                }
                i67++;
                hashSet13 = hashSet9;
                performanceTask24 = performanceTask;
                hashSet12 = hashSet;
                currentTimeMillis2 = j27;
                hashSet11 = hashSet8;
                hashMap2 = hashMap;
            }
            long j36 = currentTimeMillis2;
            HashMap hashMap3 = hashMap2;
            HashSet hashSet15 = hashSet11;
            HashSet hashSet16 = hashSet13;
            long currentTimeMillis4 = System.currentTimeMillis();
            if (HardCoderJNI.hcDebug) {
                Log.d(str7, String.format("EndLoop time:[%d,%d] list:%d stop:%d bindCore:%d -> %d", Long.valueOf(currentTimeMillis4 - j36), Long.valueOf(currentTimeMillis4 - currentTimeMillis), Integer.valueOf(arrayList.size()), Integer.valueOf(hashMap3.size()), Integer.valueOf(hashSet.size()), Integer.valueOf(hashSet16.size())));
                StringBuilder sb6 = new StringBuilder();
                sb6.append("EndLoop CurrCpu:");
                if (performanceTask == null) {
                    performanceTask3 = performanceTask;
                    performanceTask18 = "null";
                    str = " task:";
                    j16 = j36;
                } else {
                    performanceTask3 = performanceTask;
                    j16 = j36;
                    str = " task:";
                    performanceTask18 = performanceTask3.toString(j16);
                }
                sb6.append(performanceTask18);
                sb6.append(" -> MaxCpu:");
                sb6.append(performanceTask30 == null ? "null" : performanceTask30.toString(j16));
                Log.d(str7, sb6.toString());
                StringBuilder sb7 = new StringBuilder();
                sb7.append("EndLoop CurrGpu:");
                if (performanceTask27 == null) {
                    str2 = "/";
                    performanceTask2 = performanceTask27;
                    performanceTask19 = "null";
                } else {
                    performanceTask2 = performanceTask27;
                    str2 = "/";
                    performanceTask19 = performanceTask2.toString(j16);
                }
                sb7.append(performanceTask19);
                sb7.append(" -> MaxGpu:");
                sb7.append(performanceTask2 == null ? "null" : performanceTask2.toString(j16));
                Log.d(str7, sb7.toString());
                StringBuilder sb8 = new StringBuilder();
                sb8.append("EndLoop CurrIO:");
                if (performanceTask26 == null) {
                    j3 = j26;
                    performanceTask4 = performanceTask26;
                    performanceTask20 = "null";
                } else {
                    performanceTask4 = performanceTask26;
                    j3 = j26;
                    performanceTask20 = performanceTask4.toString(j16);
                }
                sb8.append(performanceTask20);
                sb8.append(" -> MaxIO:");
                sb8.append(performanceTask29 == null ? "null" : performanceTask29.toString(j16));
                Log.d(str7, sb8.toString());
                Log.d(str7, String.format("EndLoop BindCore.size cur: %d, need: %d", Integer.valueOf(hashSet.size()), Integer.valueOf(hashSet16.size())));
            } else {
                j3 = j26;
                performanceTask2 = performanceTask27;
                performanceTask3 = performanceTask;
                str = " task:";
                str2 = "/";
                performanceTask4 = performanceTask26;
                j16 = j36;
            }
            HashSet hashSet17 = new HashSet();
            hashSet17.addAll(hashSet);
            hashSet17.removeAll(hashSet16);
            if (performanceTask30 == performanceTask3 && performanceTask28 == performanceTask2 && performanceTask29 == performanceTask4 && hashSet.size() == hashSet16.size() && hashSet17.isEmpty()) {
                if (HardCoderJNI.hcDebug) {
                    Log.i(str7, "EndLoop Nothing Changed , Continue.");
                }
                hCPerfManager = this;
                performanceTask23 = performanceTask2;
                performanceTask22 = performanceTask4;
                hashSet12 = hashSet;
                hashSet11 = hashSet15;
                hashMap2 = hashMap3;
                j19 = j3;
                i59 = 1;
                performanceTask24 = performanceTask3;
            } else {
                Iterator it = hashSet17.iterator();
                int i77 = 0;
                while (it.hasNext()) {
                    Iterator it5 = it;
                    int[] iArr = ((PerformanceTask) it.next()).bindTids;
                    if (iArr != null) {
                        i77 += iArr.length;
                    }
                    it = it5;
                }
                ArrayList arrayList2 = arrayList;
                PerformanceTask performanceTask32 = performanceTask3;
                String str8 = "stopTime:";
                if (i77 > 0) {
                    int[] iArr2 = new int[i77];
                    Iterator it6 = hashSet17.iterator();
                    int i78 = 0;
                    while (true) {
                        if (!it6.hasNext()) {
                            hashSet2 = hashSet17;
                            performanceTask5 = performanceTask28;
                            performanceTask6 = performanceTask2;
                            j17 = currentTimeMillis4;
                            performanceTask7 = performanceTask30;
                            performanceTask8 = performanceTask29;
                            break;
                        }
                        hashSet2 = hashSet17;
                        PerformanceTask performanceTask33 = (PerformanceTask) it6.next();
                        performanceTask5 = performanceTask28;
                        performanceTask6 = performanceTask2;
                        long currentTimeMillis5 = System.currentTimeMillis();
                        performanceTask7 = performanceTask30;
                        StringBuilder sb9 = new StringBuilder();
                        j17 = currentTimeMillis4;
                        sb9.append("!cancelBindCore task:");
                        sb9.append(performanceTask33.toString(currentTimeMillis5));
                        Log.i(str7, sb9.toString());
                        if (performanceTask33.stopTime > currentTimeMillis5) {
                            StringBuilder sb10 = new StringBuilder();
                            sb10.append("stopTime:");
                            performanceTask8 = performanceTask29;
                            sb10.append(performanceTask33.stopTime - currentTimeMillis5);
                            sb10.append(". Error !");
                            Log.e(str7, sb10.toString());
                        } else {
                            performanceTask8 = performanceTask29;
                            if (!performanceTask33.isNeedBindTids()) {
                                if (!HardCoderJNI.checkEnv) {
                                    uninit();
                                    break;
                                }
                                AssertUtil.fail("bindTids:" + performanceTask33.bindTidsToString());
                            }
                            for (int i79 : performanceTask33.bindTids) {
                                iArr2[i78] = i79;
                                i78++;
                            }
                        }
                        performanceTask29 = performanceTask8;
                        performanceTask2 = performanceTask6;
                        hashSet17 = hashSet2;
                        performanceTask28 = performanceTask5;
                        performanceTask30 = performanceTask7;
                        currentTimeMillis4 = j17;
                    }
                    if (!IS_TEST && HardCoderJNI.checkEnv) {
                        HardCoderJNI.cancelCpuCoreForThread(iArr2, Process.myTid(), SystemClock.elapsedRealtimeNanos());
                    }
                } else {
                    hashSet2 = hashSet17;
                    performanceTask5 = performanceTask28;
                    performanceTask6 = performanceTask2;
                    j17 = currentTimeMillis4;
                    performanceTask7 = performanceTask30;
                    performanceTask8 = performanceTask29;
                }
                Iterator it7 = hashSet16.iterator();
                int i85 = 0;
                while (it7.hasNext()) {
                    int[] iArr3 = ((PerformanceTask) it7.next()).bindTids;
                    if (iArr3 != null) {
                        i85 += iArr3.length;
                    }
                }
                int[] iArr4 = new int[i85];
                Iterator it8 = hashSet16.iterator();
                long j37 = 0;
                int i86 = Integer.MAX_VALUE;
                int i87 = 0;
                int i88 = 0;
                int i89 = 0;
                while (true) {
                    if (!it8.hasNext()) {
                        i3 = i88;
                        i16 = i89;
                        performanceTask9 = performanceTask4;
                        hashSet3 = hashSet16;
                        break;
                    }
                    Iterator it9 = it8;
                    PerformanceTask performanceTask34 = (PerformanceTask) it8.next();
                    int i95 = i87;
                    StringBuilder sb11 = new StringBuilder();
                    i3 = i88;
                    sb11.append("requestBindCore task:");
                    sb11.append(performanceTask34.toString(j16));
                    Log.i(str7, sb11.toString());
                    long currentTimeMillis6 = System.currentTimeMillis();
                    i16 = i89;
                    performanceTask9 = performanceTask4;
                    if (performanceTask34.stopTime <= currentTimeMillis6) {
                        StringBuilder sb12 = new StringBuilder();
                        sb12.append(str8);
                        str6 = str8;
                        sb12.append(performanceTask34.stopTime - currentTimeMillis6);
                        sb12.append(". Error !");
                        Log.e(str7, sb12.toString());
                        hashSet16 = hashSet16;
                        i87 = i95;
                        it8 = it9;
                        i88 = i3;
                        performanceTask4 = performanceTask9;
                        i89 = i16;
                    } else {
                        str6 = str8;
                        hashSet3 = hashSet16;
                        if (!performanceTask34.isNeedBindTids()) {
                            if (!HardCoderJNI.checkEnv) {
                                uninit();
                                break;
                            }
                            AssertUtil.fail("bindTids:" + performanceTask34.bindTidsToString());
                        }
                        i87 = i95;
                        for (int i96 : performanceTask34.bindTids) {
                            iArr4[i87] = i96;
                            i87++;
                        }
                        i88 = performanceTask34.scene;
                        long j38 = performanceTask34.action;
                        i89 = performanceTask34.callerTid;
                        j37 = j38;
                        i86 = Math.min((int) (performanceTask34.stopTime - j16), i86);
                        hashSet16 = hashSet3;
                        it8 = it9;
                        performanceTask4 = performanceTask9;
                    }
                    str8 = str6;
                }
                if (performanceTask8 != null) {
                    PerformanceTask performanceTask35 = performanceTask9;
                    if (performanceTask35 != performanceTask8 && HardCoderJNI.hcDebug) {
                        StringBuilder sb13 = new StringBuilder();
                        sb13.append("IOReq:");
                        sb13.append(performanceTask35 == null ? "null" : performanceTask35.toString(j16));
                        sb13.append(" -> ");
                        sb13.append(performanceTask8.toString(j16));
                        sb13.append(" delay:");
                        sb13.append(j17 - performanceTask8.startTime);
                        Log.d(str7, sb13.toString());
                    }
                } else if (performanceTask9 != null) {
                    StringBuilder sb14 = new StringBuilder();
                    sb14.append("!cancelHighIOFreq task:");
                    PerformanceTask performanceTask36 = performanceTask9;
                    sb14.append(performanceTask36.toString(j16));
                    Log.i(str7, sb14.toString());
                    if (!IS_TEST && HardCoderJNI.checkEnv) {
                        HardCoderJNI.cancelHighIOFreq(performanceTask36.callerTid, SystemClock.elapsedRealtimeNanos());
                    }
                }
                if (performanceTask8 != null) {
                    int i97 = performanceTask8.ioLevel;
                    i17 = performanceTask8.scene;
                    long j39 = performanceTask8.action;
                    int i98 = performanceTask8.callerTid;
                    i19 = i97;
                    i86 = Math.min((int) (performanceTask8.stopTime - j16), i86);
                    j37 = j39;
                    i18 = i98;
                } else {
                    i17 = i3;
                    i18 = i16;
                    i19 = 0;
                }
                if (performanceTask5 == null) {
                    if (performanceTask6 != null) {
                        StringBuilder sb15 = new StringBuilder();
                        sb15.append("!cancelGpuHighFreq task:");
                        PerformanceTask performanceTask37 = performanceTask6;
                        sb15.append(performanceTask37.toString(j16));
                        Log.i(str7, sb15.toString());
                        if (!IS_TEST && HardCoderJNI.checkEnv) {
                            i26 = i18;
                            HardCoderJNI.cancelGpuHighFreq(performanceTask37.callerTid, SystemClock.elapsedRealtimeNanos());
                            hashSet4 = hashSet3;
                            performanceTask10 = performanceTask5;
                        }
                    }
                    i26 = i18;
                    hashSet4 = hashSet3;
                    performanceTask10 = performanceTask5;
                } else {
                    i26 = i18;
                    PerformanceTask performanceTask38 = performanceTask6;
                    performanceTask10 = performanceTask5;
                    if (performanceTask38 != performanceTask10) {
                        StringBuilder sb16 = new StringBuilder();
                        sb16.append("GPUReq:");
                        sb16.append(performanceTask38 == null ? "null" : performanceTask38.toString(j16));
                        sb16.append(" -> ");
                        sb16.append(performanceTask10.toString(j16));
                        sb16.append(" delay:");
                        hashSet4 = hashSet3;
                        sb16.append(j17 - performanceTask10.startTime);
                        Log.d(str7, sb16.toString());
                    } else {
                        hashSet4 = hashSet3;
                    }
                }
                if (performanceTask10 != null) {
                    int i99 = performanceTask10.gpuLevel;
                    int i100 = performanceTask10.scene;
                    long j46 = performanceTask10.action;
                    i28 = i99;
                    int i101 = performanceTask10.callerTid;
                    j37 = j46;
                    i86 = Math.min((int) (performanceTask10.stopTime - j16), i86);
                    i27 = i101;
                    i17 = i100;
                } else {
                    i27 = i26;
                    i28 = 0;
                }
                if (performanceTask7 == null) {
                    if (performanceTask32 != null) {
                        Log.i(str7, "!cancelCpuHighFreq task:" + performanceTask32.toString(j16));
                        if (!IS_TEST && HardCoderJNI.checkEnv) {
                            HardCoderJNI.cancelCpuHighFreq(performanceTask32.callerTid, SystemClock.elapsedRealtimeNanos());
                            performanceTask12 = performanceTask10;
                            i29 = i17;
                            i36 = i27;
                            performanceTask11 = performanceTask7;
                        }
                    }
                    performanceTask12 = performanceTask10;
                    i29 = i17;
                    i36 = i27;
                    performanceTask11 = performanceTask7;
                } else {
                    int i102 = i27;
                    performanceTask11 = performanceTask7;
                    if (performanceTask32 == performanceTask11 || !HardCoderJNI.hcDebug) {
                        performanceTask12 = performanceTask10;
                        i29 = i17;
                        i36 = i102;
                    } else {
                        i29 = i17;
                        StringBuilder sb17 = new StringBuilder();
                        i36 = i102;
                        sb17.append("CPUReq:");
                        sb17.append(performanceTask32 == null ? "null" : performanceTask32.toString(j16));
                        sb17.append(" -> ");
                        sb17.append(performanceTask11.toString(j16));
                        sb17.append(" delay:");
                        performanceTask12 = performanceTask10;
                        sb17.append(j17 - performanceTask11.startTime);
                        Log.d(str7, sb17.toString());
                    }
                }
                if (performanceTask11 != null) {
                    i39 = performanceTask11.cpuLevel;
                    i37 = performanceTask11.scene;
                    long j47 = performanceTask11.action;
                    int i103 = performanceTask11.callerTid;
                    j18 = j47;
                    i86 = Math.min((int) (performanceTask11.stopTime - j16), i86);
                    i38 = i103;
                } else {
                    i37 = i29;
                    i38 = i36;
                    j18 = j37;
                    i39 = 0;
                }
                if (i86 < Integer.MAX_VALUE) {
                    Object[] objArr2 = new Object[14];
                    objArr2[0] = Integer.valueOf(i37);
                    objArr2[1] = Long.valueOf(j18);
                    objArr2[2] = Integer.valueOf(i38);
                    objArr2[3] = Integer.valueOf(i39);
                    objArr2[4] = Integer.valueOf(i28);
                    objArr2[5] = Integer.valueOf(i19);
                    objArr2[6] = Integer.valueOf(i85);
                    objArr2[7] = Integer.valueOf(i86);
                    objArr2[8] = performanceTask11 == null ? "null" : performanceTask11.toString(j16);
                    if (performanceTask12 == null) {
                        performanceTask17 = "null";
                        performanceTask13 = performanceTask12;
                    } else {
                        performanceTask13 = performanceTask12;
                        performanceTask17 = performanceTask13.toString(j16);
                    }
                    objArr2[9] = performanceTask17;
                    objArr2[10] = performanceTask8 == null ? "null" : performanceTask8.toString(j16);
                    objArr2[11] = performanceTask11 == null ? "null" : performanceTask11.toString(j16);
                    objArr2[12] = performanceTask13 == null ? "null" : performanceTask13.toString(j16);
                    objArr2[13] = performanceTask8 != null ? performanceTask8.toString(j16) : "null";
                    Log.i(str7, String.format("!UnifyRequest [%d,%d,%d] [%d,%d,%d,%d] TO:%d max CPU:%s GPU:%s IO:%s cur CPU:%s GPU:%s IO:%s", objArr2));
                    AssertUtil.assertTrue(i86 > 0);
                    AssertUtil.assertTrue(i37 > 0 || j18 > 0);
                    AssertUtil.assertTrue(i38 > 0);
                    AssertUtil.assertTrue(i39 > 0 || i28 > 0 || i19 > 0 || i85 > 0);
                    if (!IS_TEST) {
                        Log.i(str7, String.format("hardcoder requestUnifyCpuIOThreadCore reqScene[%d, %d, %d, %d, %d, %d] requestId[%d]", Integer.valueOf(i37), Long.valueOf(j18), Integer.valueOf(i39), Integer.valueOf(i28), Integer.valueOf(i19), Integer.valueOf(i86), Long.valueOf(HardCoderJNI.requestUnifyCpuIOThreadCoreGpu(i37, j18, i39, i28, i19, iArr4, i86, i38, SystemClock.elapsedRealtimeNanos()))));
                        if (i85 > 0) {
                            i46 = 0;
                            Log.i(str7, String.format("hardcoder requestUnifyCpuIOThreadCore bindTid=%d", Integer.valueOf(iArr4[0])));
                        } else {
                            i46 = 0;
                        }
                        if (IS_TEST) {
                            str3 = str7;
                            performanceTask14 = performanceTask13;
                            hashSet5 = hashSet4;
                            performanceTask15 = performanceTask11;
                            i47 = 1;
                        } else {
                            AssertUtil.assertTrue(true);
                            AssertUtil.assertTrue(true);
                            if (arrayList2.isEmpty()) {
                                AssertUtil.assertTrue(j3 == 30000 ? 1 : i46);
                                AssertUtil.assertTrue(i86 == Integer.MAX_VALUE ? 1 : i46);
                                AssertUtil.assertTrue(hashSet4.isEmpty());
                                AssertUtil.assertTrue(performanceTask11 == null ? 1 : i46);
                                AssertUtil.assertTrue(performanceTask8 == null ? 1 : i46);
                            }
                            int i104 = i46;
                            while (i104 < arrayList2.size()) {
                                ArrayList arrayList3 = arrayList2;
                                PerformanceTask performanceTask39 = (PerformanceTask) arrayList3.get(i104);
                                if (HardCoderJNI.hcDebug) {
                                    StringBuilder sb18 = new StringBuilder();
                                    sb18.append("CheckTask:");
                                    sb18.append(i104);
                                    sb18.append(str2);
                                    sb18.append(arrayList3.size());
                                    str4 = str;
                                    sb18.append(str4);
                                    sb18.append(performanceTask39.toString(j16));
                                    Log.d(str7, sb18.toString());
                                } else {
                                    str4 = str;
                                }
                                AssertUtil.assertTrue(performanceTask39.cpuLevel > 0 || performanceTask39.ioLevel > 0 || performanceTask39.isNeedBindTids());
                                String str9 = str7;
                                arrayList2 = arrayList3;
                                AssertUtil.assertTrue(performanceTask39.action > 0 || performanceTask39.scene > 0);
                                StringBuilder sb19 = new StringBuilder();
                                sb19.append("taskInintTime:");
                                PerformanceTask performanceTask40 = performanceTask13;
                                sb19.append(performanceTask39.initTime - j16);
                                AssertUtil.assertTrue(sb19.toString(), performanceTask39.initTime <= j16);
                                AssertUtil.assertTrue("taskStopTime:" + (performanceTask39.stopTime - j16), performanceTask39.stopTime >= j16);
                                HashMap hashMap4 = hashMap3;
                                AssertUtil.assertTrue("taskHash:" + performanceTask39.hashCode(), !hashMap4.containsKey(Integer.valueOf(performanceTask39.hashCode())));
                                if (performanceTask39.startTime > j16) {
                                    AssertUtil.assertTrue(performanceTask39 != performanceTask11);
                                    AssertUtil.assertTrue(performanceTask39 != performanceTask8);
                                    HashSet hashSet18 = hashSet4;
                                    AssertUtil.assertTrue(!hashSet18.contains(performanceTask39));
                                    StringBuilder sb20 = new StringBuilder();
                                    sb20.append("next:");
                                    hashMap3 = hashMap4;
                                    long j48 = j3;
                                    sb20.append(j48);
                                    sb20.append(" start:");
                                    performanceTask16 = performanceTask11;
                                    sb20.append(performanceTask39.startTime - j16);
                                    AssertUtil.assertTrue(sb20.toString(), j48 <= performanceTask39.startTime - j16);
                                    i48 = i104;
                                    str5 = str9;
                                    hashSet6 = hashSet18;
                                    j3 = j48;
                                } else {
                                    hashMap3 = hashMap4;
                                    HashSet hashSet19 = hashSet4;
                                    performanceTask16 = performanceTask11;
                                    long j49 = j3;
                                    StringBuilder sb21 = new StringBuilder();
                                    sb21.append("nextWake:");
                                    sb21.append(j49);
                                    sb21.append(" stop:");
                                    i48 = i104;
                                    str5 = str9;
                                    sb21.append(performanceTask39.stopTime - j16);
                                    AssertUtil.assertTrue(sb21.toString(), j49 <= performanceTask39.stopTime - j16);
                                    AssertUtil.assertTrue("reqTimeStamp:" + i86, i86 > 0 && ((long) i86) < Long.MAX_VALUE);
                                    j3 = j49;
                                    AssertUtil.assertTrue("reqTimeStamp:" + i86 + " stop:" + (performanceTask39.stopTime - j16), ((long) i86) <= performanceTask39.stopTime - j16);
                                    AssertUtil.assertTrue("reqCpu:" + i39 + str4 + performanceTask39.cpuLevel, i39 <= performanceTask39.cpuLevel);
                                    AssertUtil.assertTrue("reqIO:" + i19 + str4 + performanceTask39.ioLevel, i19 <= performanceTask39.ioLevel);
                                    if (performanceTask39.isNeedBindTids()) {
                                        hashSet6 = hashSet19;
                                        AssertUtil.assertTrue(hashSet6.contains(performanceTask39));
                                        hashSet7 = hashSet2;
                                        AssertUtil.assertTrue(!hashSet7.contains(performanceTask39));
                                        hashSet4 = hashSet6;
                                        hashSet2 = hashSet7;
                                        i104 = i48 + 1;
                                        str = str4;
                                        str7 = str5;
                                        performanceTask13 = performanceTask40;
                                        performanceTask11 = performanceTask16;
                                    } else {
                                        hashSet6 = hashSet19;
                                    }
                                }
                                hashSet7 = hashSet2;
                                hashSet4 = hashSet6;
                                hashSet2 = hashSet7;
                                i104 = i48 + 1;
                                str = str4;
                                str7 = str5;
                                performanceTask13 = performanceTask40;
                                performanceTask11 = performanceTask16;
                            }
                            str3 = str7;
                            performanceTask14 = performanceTask13;
                            hashSet5 = hashSet4;
                            performanceTask15 = performanceTask11;
                            i47 = 1;
                        }
                        hCPerfManager = this;
                        hashSet12 = hashSet5;
                        i59 = i47;
                        performanceTask22 = performanceTask8;
                        str7 = str3;
                        arrayList = arrayList2;
                        performanceTask23 = performanceTask14;
                        hashSet11 = hashSet15;
                        hashMap2 = hashMap3;
                        j19 = j3;
                        performanceTask24 = performanceTask15;
                    }
                } else {
                    performanceTask13 = performanceTask12;
                }
                i46 = 0;
                if (IS_TEST) {
                }
                hCPerfManager = this;
                hashSet12 = hashSet5;
                i59 = i47;
                performanceTask22 = performanceTask8;
                str7 = str3;
                arrayList = arrayList2;
                performanceTask23 = performanceTask14;
                hashSet11 = hashSet15;
                hashMap2 = hashMap3;
                j19 = j3;
                performanceTask24 = performanceTask15;
            }
            i58 = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int init() {
        String str;
        boolean z16;
        try {
            str = new BufferedReader(new InputStreamReader(RuntimeMonitor.exec(Runtime.getRuntime(), "getprop persist.sys.hardcoder.name").getInputStream())).readLine();
        } catch (Throwable th5) {
            QLog.d(TAG, 1, "", th5);
            str = null;
        }
        String str2 = Build.CPU_ABI;
        if (str2 != null && !str2.contains(ResourceAttributes.HostArchValues.X86) && !str2.contains("mips")) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (TextUtils.isEmpty(str) || !z16) {
            return 1;
        }
        File file = new File(getSoPath());
        int i3 = 4;
        if (file.exists()) {
            try {
                if (!getSoMd5().equalsIgnoreCase(g.b(file))) {
                    file.delete();
                    QLog.d(TAG, 1, "HardCoder lib md5 check fail");
                } else {
                    System.load(getSoPath());
                    HardCoderJNI.initHardCoder(str, 0, sClientsock);
                    this.running = true;
                    BaseThread baseThread = new BaseThread(new Runnable() { // from class: com.tencent.mm.hardcoder.HCPerfManager.1
                        @Override // java.lang.Runnable
                        public void run() {
                            HCPerfManager.this.run();
                        }
                    }, "hardcoder-0");
                    baseThread.setPriority(1);
                    baseThread.start();
                    i3 = 10;
                }
            } catch (Throwable th6) {
                QLog.d(TAG, 1, "", th6);
                return 7;
            }
        }
        return i3;
    }

    public int start(int i3, int i16, int i17, int i18, int[] iArr, int i19, int i26, long j3, int i27, String str) {
        if (isParamsValid(i3, i16, i17, i18, iArr, i19) && (i16 != 0 || i17 != 0 || i18 != 0 || iArr.length != 1 || iArr[0] != 0)) {
            PerformanceTask performanceTask = new PerformanceTask();
            performanceTask.delay = i3;
            performanceTask.cpuLevel = i16;
            performanceTask.ioLevel = i17;
            performanceTask.bindTids = (int[]) iArr.clone();
            performanceTask.gpuLevel = i18;
            performanceTask.timeout = i19;
            performanceTask.scene = i26;
            performanceTask.action = j3;
            performanceTask.callerTid = i27;
            long currentTimeMillis = System.currentTimeMillis();
            performanceTask.initTime = currentTimeMillis;
            long j16 = i3;
            long j17 = currentTimeMillis + j16;
            performanceTask.startTime = j17;
            performanceTask.stopTime = currentTimeMillis + j16 + i19;
            performanceTask.tag = str;
            performanceTask.lastUpdateTime = j17;
            boolean offer = this.queueTask.offer(performanceTask);
            Log.d(TAG, String.format("start ret:%b ,task:%s, scene:%s", Boolean.valueOf(offer), performanceTask.toString(performanceTask.initTime), Integer.valueOf(i26)));
            if (offer) {
                return performanceTask.hashCode();
            }
            return 0;
        }
        Object[] objArr = new Object[6];
        objArr[0] = Integer.valueOf(i3);
        objArr[1] = Integer.valueOf(i16);
        objArr[2] = Integer.valueOf(i17);
        objArr[3] = Integer.valueOf(i18);
        objArr[4] = Integer.valueOf(iArr == null ? 0 : iArr.length);
        objArr[5] = Integer.valueOf(i19);
        Log.e(TAG, String.format("start error params, ignore this task! delay:%d, [cpu:%d, io:%d, gpu:%d], bindTids:%d, timeout:%d", objArr));
        return 0;
    }

    public boolean stop(int i3) {
        boolean z16;
        PerformanceTaskStop performanceTaskStop = (PerformanceTaskStop) sStopTaskPool.obtain(PerformanceTaskStop.class);
        performanceTaskStop.sceneStopTime = System.currentTimeMillis();
        performanceTaskStop.hashCode = i3;
        if (i3 != 0) {
            z16 = this.queueTask.offer(performanceTaskStop);
        } else {
            z16 = false;
        }
        if (HardCoderJNI.hcDebug) {
            Log.d(TAG, String.format("OutCallStopTask ret:%b, hashcode:%x", Boolean.valueOf(z16), Integer.valueOf(i3)));
        }
        return z16;
    }

    public void uninit() {
        QLog.d(TAG, 1, "uninit");
        this.running = false;
    }

    @Deprecated
    public int start(int i3, int i16, int i17, int i18, int i19, int i26, long j3, int i27, String str) {
        return start(i3, i16, i17, 0, new int[]{i18}, i19, i26, j3, i27, str);
    }
}
