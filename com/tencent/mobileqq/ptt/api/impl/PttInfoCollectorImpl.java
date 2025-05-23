package com.tencent.mobileqq.ptt.api.impl;

import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.ptt.api.IPttInfoCollector;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqaudio.b;
import com.tencent.mobileqq.qqaudio.c;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.m;
import com.tencent.qphone.base.BaseConstants;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.shadow.dynamic.host.Constant;
import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.util.HashMap;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;

/* loaded from: classes16.dex */
public class PttInfoCollectorImpl implements IPttInfoCollector {
    static IPatchRedirector $redirector_ = null;
    public static final String TAG = "PttInfoCollectorImpl";
    public static boolean addedObject;
    public static int consumeCount;
    public static long consumedSize;
    public static long frameConsumedSize;
    public static int gcCount;
    public static long gcReleasedSize;
    public static int releaseCount;
    protected static long sCostUntilPrepare;
    public static ConcurrentHashMap<String, Long> sPttSendCostRecorder;
    protected Random random;
    protected PhantomReference<Object> reference;
    public ReferenceQueue<Object> referenceQueue;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(21664);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 16)) {
            redirector.redirect((short) 16);
            return;
        }
        sCostUntilPrepare = 0L;
        gcCount = 0;
        addedObject = false;
        consumedSize = 0L;
        frameConsumedSize = 0L;
        gcReleasedSize = 0L;
        consumeCount = 0;
        releaseCount = 0;
        sPttSendCostRecorder = new ConcurrentHashMap<>();
    }

    public PttInfoCollectorImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.random = new Random();
            this.referenceQueue = new ReferenceQueue<>();
        }
    }

    public static final int mergeDownloadPTTFromType(int i3, int i16) {
        return (i3 * 100) + (i16 & 15);
    }

    public void checkCurrentMemory(Runtime runtime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) runtime);
            return;
        }
        try {
            long freeMemory = runtime.freeMemory();
            long j3 = runtime.totalMemory();
            long j16 = consumedSize;
            if (j16 != 0) {
                long j17 = j3 - freeMemory;
                if (j17 > j16) {
                    frameConsumedSize += j17 - j16;
                    consumeCount++;
                } else {
                    gcReleasedSize += j16 - j17;
                    releaseCount++;
                }
            }
            consumedSize = j3 - freeMemory;
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    public void checkGc() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        if (getPoll() != null) {
            gcCount++;
            addedObject = false;
            if (QLog.isColorLevel()) {
                QLog.e(TAG, 2, "gc occurred:" + gcCount);
            }
        }
        if (!addedObject) {
            this.reference = new PhantomReference<>(new Object(), this.referenceQueue);
            addedObject = true;
            if (QLog.isColorLevel()) {
                QLog.e(TAG, 2, "add object enqueue to detect gc");
            }
        }
    }

    protected Object getPoll() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.referenceQueue.poll();
    }

    @NotNull
    protected HashMap<String, String> getReportHashMap() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (HashMap) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        return new HashMap<>();
    }

    @NotNull
    protected HashMap<String, String> getSysReportInfo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return (HashMap) iPatchRedirector.redirect((short) 15, (Object) this);
        }
        int c16 = c.c();
        int f16 = c.f();
        long e16 = c.e();
        long c17 = m.c() / 1048576;
        HashMap<String, String> reportHashMap = getReportHashMap();
        reportHashMap.put("cpuArch", String.valueOf(c16));
        reportHashMap.put("numCores", String.valueOf(f16));
        reportHashMap.put("maxFreq", String.valueOf(e16));
        reportHashMap.put("memory", String.valueOf(c17));
        return reportHashMap;
    }

    @Override // com.tencent.mobileqq.ptt.api.IPttInfoCollector
    public long getsCostUntilPrepare() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Long) iPatchRedirector.redirect((short) 6, (Object) this)).longValue();
        }
        return sCostUntilPrepare;
    }

    @Override // com.tencent.mobileqq.ptt.api.IPttInfoCollector
    public void noteOneFrameProcessed() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
        } else {
            checkGc();
            checkCurrentMemory(Runtime.getRuntime());
        }
    }

    protected void realReportInner(long j3, String str, boolean z16, long j16, HashMap<String, String> hashMap) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, this, Long.valueOf(j3), str, Boolean.valueOf(z16), Long.valueOf(j16), hashMap);
        } else {
            StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, str, z16, j16, j3, hashMap, "");
        }
    }

    @Override // com.tencent.mobileqq.ptt.api.IPttInfoCollector
    public void reportGcAndMemoryUse(int i3, int i16) {
        long j3;
        long j16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        HashMap<String, String> reportHashMap = getReportHashMap();
        reportHashMap.put("type", String.valueOf(i3));
        int i17 = consumeCount;
        if (i17 != 0) {
            j3 = frameConsumedSize / i17;
        } else {
            j3 = 0;
        }
        int i18 = releaseCount;
        if (i18 != 0) {
            j16 = gcReleasedSize / i18;
        } else {
            j16 = 0;
        }
        reportHashMap.put("consumePerFrame", String.valueOf(j3));
        reportHashMap.put("releasePerGc", String.valueOf(j16));
        reportHashMap.put(BaseConstants.RDM_NoChangeFailCode, "");
        if (QLog.isColorLevel()) {
            QLog.e(TAG, 2, "reportSoundProcessCost gcCount=" + gcCount + " type=" + i3 + " time" + i16);
            StringBuilder sb5 = new StringBuilder();
            sb5.append("reportSoundProcessCost consume=");
            sb5.append(j3);
            sb5.append(" release=");
            sb5.append(j16);
            QLog.e(TAG, 2, sb5.toString());
        }
        realReportInner(gcCount, "actPttGcCount", true, i16, reportHashMap);
        gcCount = 0;
        addedObject = false;
        ReferenceQueue<Object> referenceQueue = this.referenceQueue;
        if (referenceQueue != null) {
            referenceQueue.poll();
        }
        consumedSize = 0L;
        frameConsumedSize = 0L;
        gcReleasedSize = 0L;
        consumeCount = 0;
        releaseCount = 0;
    }

    public void reportNoRange(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, z16);
            return;
        }
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put(BaseConstants.RDM_NoChangeFailCode, "");
        realReportInner(0L, StatisticCollector.PTT_NO_RANGE_FAILED_TAG, z16, 0L, hashMap);
    }

    @Override // com.tencent.mobileqq.ptt.api.IPttInfoCollector
    public void reportPTTPV(AppRuntime appRuntime, int i3, boolean z16, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, this, appRuntime, Integer.valueOf(i3), Boolean.valueOf(z16), Integer.valueOf(i16));
        } else {
            ReportController.o(appRuntime, "CliOper", "", "", "0X8005C1C", "0X8005C1C", (i3 * 100) + ((z16 ? 1 : 0) * 10) + i16, 0, "", "", "", AppSetting.f99551k);
        }
    }

    @Override // com.tencent.mobileqq.ptt.api.IPttInfoCollector
    public void reportPttUploadType(boolean z16, long j3, long j16, long j17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, this, Boolean.valueOf(z16), Long.valueOf(j3), Long.valueOf(j16), Long.valueOf(j17));
            return;
        }
        if (j3 == 1000 || j3 == 1001 || j3 == 10002 || j3 == 10004 || j3 == Constant.FROM_ID_UNINSTALL_PLUGIN || j3 == Constant.FROM_ID_START_ACTIVITY || j3 == 1004 || j3 == Constant.FROM_ID_STOP_SERVICE || j3 == 1006 || j3 == 1008 || j3 == 1009 || j3 == 1010 || j3 == 1011 || j3 == 1020 || j3 == 1021 || j3 == 1022 || j3 == 1023 || j3 == 1024 || j3 == 1025) {
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("param_FailCode", String.valueOf(j3));
            realReportInner(j17, StatisticCollector.ALL_C2C_PTT_UPLOAD_STATISTIC_TAG, z16, j16, hashMap);
        }
    }

    @Override // com.tencent.mobileqq.ptt.api.IPttInfoCollector
    public void reportSoundProcessCost(long j3, int i3, long j16, int i16) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, Long.valueOf(j3), Integer.valueOf(i3), Long.valueOf(j16), Integer.valueOf(i16));
            return;
        }
        if (Math.abs(this.random.nextInt() % 100) < 10) {
            HashMap<String, String> sysReportInfo = getSysReportInfo();
            if (i16 > 2) {
                z16 = b.f262212b;
            } else {
                z16 = b.f262211a;
            }
            sysReportInfo.put("v7so", String.valueOf(z16));
            sysReportInfo.put("type", String.valueOf(i16));
            sysReportInfo.put("maxFrameCost", String.valueOf(j16));
            realReportInner(i3, StatisticCollector.PTT_PROCESS_FRAME_COST_TAG, true, j3, sysReportInfo);
        }
    }

    @Override // com.tencent.mobileqq.ptt.api.IPttInfoCollector
    public void setsCostUntilPrepare(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, j3);
        } else {
            sCostUntilPrepare = j3;
        }
    }
}
