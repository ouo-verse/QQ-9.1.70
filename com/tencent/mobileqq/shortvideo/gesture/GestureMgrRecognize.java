package com.tencent.mobileqq.shortvideo.gesture;

import android.graphics.PointF;
import android.graphics.RectF;
import android.os.SystemClock;
import com.heytap.databaseengine.apiv3.data.Element;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.av.avgesture.AVGestureWrapper;
import com.tencent.mobileqq.perf.block.LockMethodProxy;
import com.tencent.mobileqq.shortvideo.facedancegame.GestureDetectManager;
import com.tencent.sveffects.SLog;
import com.tencent.sveffects.SdkContext;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import com.tencent.ttpic.openapi.util.RetrieveDataManager;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes18.dex */
public class GestureMgrRecognize {
    public static final int GAME_MODEL_LOAD = 2;
    public static final int GESTURE_MODEL_LOAD = 1;
    static final String GestureSoName = "libAVGesture4Android.so";
    public static final int NONE_MODEL_LOAD = 0;
    private static final String TAG = "GestureMgrRecognize";
    public static final Object mGestureLock = "GestureLock";
    private static GestureMgrRecognize instance = new GestureMgrRecognize();
    static int s_token = 1;
    static String Gesture_Recognize_Time = "actAVGestureRecognizeTime";
    static int GestureTypeHitCount = 1;
    static int GestureTypeMissCount = 2;
    static String ACT_QQAVGESTURE = "actQQAVGesture";
    GestureInfo mGestureInfo = new GestureInfo();
    long mRecognizeRunnableSleepMillis = 20;
    GestureData mGestureData = null;
    boolean bSoLoaded = false;
    boolean mSoLaodSuc = true;
    long mRecognizeMillis = 200;
    int mRecognizeFrameRate = 5;
    int mCurRecognizeRunnableToken = 0;
    RecognizeRunnable mRecognizeRunnable = null;
    volatile int mModelLoadStatus = 0;
    long mLastTransferTime = 0;
    int mFrameRateCount = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class GestureData {
        int dataHeight;
        byte[] dataRGBA;
        int dataWidth;
        int originHeight;
        int originWidth;

        GestureData(byte[] bArr, int i3, int i16, int i17, int i18) {
            this.dataRGBA = null;
            this.dataRGBA = (byte[]) bArr.clone();
            this.dataWidth = i3;
            this.dataHeight = i16;
            this.originWidth = i17;
            this.originHeight = i18;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class GestureInfo extends GestureKeyInfo {
        String curType;
        int hitCount = 0;
        int missCount = 0;

        GestureInfo() {
        }

        public void copyTo(GestureInfo gestureInfo) {
            super.copyTo((GestureKeyInfo) gestureInfo);
            gestureInfo.hitCount = this.hitCount;
            gestureInfo.missCount = this.missCount;
            gestureInfo.curType = this.curType;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class RecognizeRunnable implements Runnable {
        int mToken;

        public RecognizeRunnable(int i3) {
            this.mToken = i3;
        }

        @Override // java.lang.Runnable
        public void run() {
            char c16;
            char c17;
            GestureKeyInfo doProcess;
            int i3;
            Thread currentThread = Thread.currentThread();
            char c18 = 15;
            try {
                long[] jArr = new long[15];
                HashMap hashMap = new HashMap();
                char c19 = 5;
                GestureInfo[] gestureInfoArr = new GestureInfo[5];
                for (int i16 = 0; i16 < 5; i16++) {
                    gestureInfoArr[i16] = new GestureInfo();
                }
                SLog.d(GestureMgrRecognize.TAG, String.format("RecognizeRunnable, ThreadId[%s], token[%s]", Long.valueOf(currentThread.getId()), Integer.valueOf(this.mToken)));
                int i17 = 0;
                int i18 = 0;
                while (true) {
                    if (!GestureMgrRecognize.this.loadSo()) {
                        SLog.d(GestureMgrRecognize.TAG, String.format("RecognizeRunnable load so fail, ThreadId[%s], token[%s]", Long.valueOf(currentThread.getId()), Integer.valueOf(this.mToken)));
                        break;
                    }
                    int i19 = this.mToken;
                    GestureMgrRecognize gestureMgrRecognize = GestureMgrRecognize.this;
                    if (i19 != gestureMgrRecognize.mCurRecognizeRunnableToken) {
                        SLog.d(GestureMgrRecognize.TAG, String.format("RecognizeRunnable exit1, ThreadId[%s], token[%s], curToken[%s]", Long.valueOf(currentThread.getId()), Integer.valueOf(this.mToken), Integer.valueOf(GestureMgrRecognize.this.mCurRecognizeRunnableToken)));
                        break;
                    }
                    GestureData gestureData = gestureMgrRecognize.mGestureData;
                    gestureMgrRecognize.mGestureData = null;
                    if (gestureData != null) {
                        GestureInfo gestureInfo = gestureInfoArr[i17];
                        gestureMgrRecognize.mGestureInfo.copyTo(gestureInfo);
                        synchronized (GestureMgrRecognize.mGestureLock) {
                            doProcess = GestureMgrRecognize.doProcess(this.mToken, gestureData, gestureInfo.type, jArr, i18);
                        }
                        if (hashMap.containsKey(doProcess.type)) {
                            i3 = ((Integer) hashMap.get(doProcess.type)).intValue();
                        } else {
                            i3 = 0;
                        }
                        hashMap.put(doProcess.type, Integer.valueOf(i3 + 1));
                        int i26 = this.mToken;
                        if (i26 != GestureMgrRecognize.this.mCurRecognizeRunnableToken) {
                            SLog.d(GestureMgrRecognize.TAG, String.format("RecognizeRunnable exit2, ThreadId[%s], token[%s], curToken[%s]", Long.valueOf(currentThread.getId()), Integer.valueOf(this.mToken), Integer.valueOf(GestureMgrRecognize.this.mCurRecognizeRunnableToken)));
                            break;
                        }
                        GestureMgrRecognize.mergeData(i26, gestureInfo, doProcess);
                        GestureMgrRecognize.this.mGestureInfo = gestureInfo;
                        c17 = 5;
                        i17 = (i17 + 1) % 5;
                        int i27 = i18 + 1;
                        c16 = 15;
                        if (i27 == 15) {
                            GestureMgrRecognize.reportCost(jArr, i27);
                        }
                        i18 = i27 % 15;
                    } else {
                        char c26 = c19;
                        c16 = c18;
                        c17 = c26;
                    }
                    try {
                        LockMethodProxy.sleep(GestureMgrRecognize.this.mRecognizeRunnableSleepMillis);
                    } catch (Exception unused) {
                    }
                    char c27 = c16;
                    c19 = c17;
                    c18 = c27;
                }
                GestureMgrRecognize.this.reportGestrue(hashMap);
                GestureMgrRecognize.reportCost(jArr, i18);
            } catch (Exception e16) {
                SLog.e(GestureMgrRecognize.TAG, String.format("RecognizeRunnable occured exception[%s]", e16.getClass().getName()), e16);
            }
            SLog.d(GestureMgrRecognize.TAG, String.format("RecognizeRunnable, finaly exit, ThreadId[%s], token[%s]", Long.valueOf(currentThread.getId()), Integer.valueOf(this.mToken)));
        }
    }

    GestureMgrRecognize() {
    }

    static GestureKeyInfo doProcess(int i3, GestureData gestureData, String str, long[] jArr, int i16) {
        GestureKeyInfo gestureKeyInfo = new GestureKeyInfo();
        long elapsedRealtime = SystemClock.elapsedRealtime();
        AVGestureWrapper aVGestureWrapper = new AVGestureWrapper();
        if (aVGestureWrapper.doCalc(gestureData.dataRGBA, gestureData.dataWidth, gestureData.dataHeight, 0, 0, true)) {
            gestureKeyInfo.type = aVGestureWrapper.getGestureType();
            gestureKeyInfo.vaild = true;
            gestureKeyInfo.hotArea = aVGestureWrapper.getHotRegionInOriginImg();
            gestureKeyInfo.hotPoints = aVGestureWrapper.getKeyPoints();
            gestureKeyInfo.timeStamp = System.currentTimeMillis();
            float f16 = gestureData.originHeight / gestureData.dataHeight;
            float f17 = gestureData.originWidth / gestureData.dataWidth;
            RectF rectF = gestureKeyInfo.hotArea;
            rectF.top *= f16;
            rectF.bottom *= f16;
            rectF.left *= f17;
            rectF.right *= f17;
            for (PointF pointF : gestureKeyInfo.hotPoints) {
                pointF.x *= f17;
                pointF.y *= f16;
            }
            gestureKeyInfo.dataHeight = gestureData.dataHeight;
            gestureKeyInfo.dataWidth = gestureData.dataWidth;
            gestureKeyInfo.originWidth = gestureData.originWidth;
            gestureKeyInfo.originHeight = gestureData.originHeight;
        }
        aVGestureWrapper.destroyRecognizor();
        long elapsedRealtime2 = SystemClock.elapsedRealtime() - elapsedRealtime;
        jArr[i16] = elapsedRealtime2;
        if (SLog.isEnable()) {
            SLog.d("GestureMgrRecognize|costtime", String.format("doProcess, mToken[%s], cost[%s], lastType[%s], srcSize[%s, %s], timeStamp[%s], RecognizeType[%s], vaild[%s], rcHot[%s], hotPoint{%s}", Integer.valueOf(i3), Long.valueOf(elapsedRealtime2), str, Integer.valueOf(gestureData.dataWidth), Integer.valueOf(gestureData.dataHeight), Long.valueOf(gestureKeyInfo.timeStamp), gestureKeyInfo.type, Boolean.valueOf(gestureKeyInfo.vaild), gestureKeyInfo.hotArea, getPointInfo(gestureKeyInfo.hotPoints)));
        }
        return gestureKeyInfo;
    }

    static int genToken() {
        int i3 = s_token + 1;
        s_token = i3;
        return i3;
    }

    public static GestureMgrRecognize getInstance() {
        return instance;
    }

    static String getPointInfo(PointF[] pointFArr) {
        if (pointFArr == null) {
            return "null";
        }
        String format = String.format("len[%s], ", Integer.valueOf(pointFArr.length));
        int length = pointFArr.length;
        int i3 = 0;
        int i16 = 0;
        while (i3 < length) {
            format = format + String.format("[%s,%s], ", Integer.valueOf(i16), pointFArr[i3]);
            i3++;
            i16++;
        }
        return format;
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x005e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static boolean innerLoadSo() {
        boolean z16;
        try {
            System.load(SdkContext.getInstance().getResources().getGestureResource().getSoPathDir() + "libAVGesture4Android.so");
            z16 = true;
        } catch (Exception e16) {
            SLog.e(TAG, String.format("System.load Exception[%s]", e16.getClass().getName()), e16);
            z16 = false;
            if (z16) {
            }
            return z16;
        } catch (UnsatisfiedLinkError e17) {
            SLog.e(TAG, String.format("System.load Exception[%s]", e17.getClass().getName()), e17);
            z16 = false;
            if (z16) {
            }
            return z16;
        }
        if (z16) {
            try {
                String modelPath = SdkContext.getInstance().getResources().getGestureResource().getModelPath();
                AVGestureWrapper.setFilePath(modelPath, modelPath, "");
                AVGestureWrapper.setGlobalConfigFile(modelPath);
                AVGestureWrapper.setAVGestureReport(new AVGestureWrapper.AVUploadReport() { // from class: com.tencent.mobileqq.shortvideo.gesture.GestureMgrRecognize.1
                    @Override // com.tencent.av.avgesture.AVGestureWrapper.AVUploadReport
                    public void avGestureUploadReport(String str, String str2) {
                        SdkContext.getInstance().getReporter().reportToCompass("dc00898", "", str, str, 0, 0, "", "", str2, "");
                    }
                });
                AVGestureWrapper.setShouldUpload(SdkContext.getInstance().getResources().getGestureResource().getGestureShouldUpload());
                SLog.d(TAG, String.format("loadSo suc, [%s]", AVGestureWrapper.getVersionInfo()));
            } catch (Exception e18) {
                SLog.e(TAG, String.format("loadSo suc, but setCnnModelPath Exception[%s]", e18.getClass().getName()), e18);
                return false;
            } catch (UnsatisfiedLinkError e19) {
                SLog.e(TAG, String.format("loadSo suc, but setCnnModelPath Exception[%s]", e19.getClass().getName()), e19);
            }
        }
        return z16;
    }

    static void mergeData(int i3, GestureInfo gestureInfo, GestureKeyInfo gestureKeyInfo) {
        if (gestureKeyInfo.vaild) {
            if (!gestureKeyInfo.type.equals(gestureInfo.curType)) {
                gestureInfo.curType = gestureKeyInfo.type;
                gestureInfo.hitCount = 1;
            } else {
                gestureInfo.hitCount++;
            }
            if (!gestureKeyInfo.type.equals(gestureInfo.type)) {
                gestureInfo.missCount++;
            }
        } else {
            gestureInfo.missCount++;
            gestureInfo.hitCount = 0;
        }
        if (gestureInfo.hitCount >= GestureTypeHitCount) {
            gestureInfo.type = gestureInfo.curType;
            gestureInfo.missCount = 0;
            gestureInfo.vaild = true;
        } else if (gestureInfo.missCount >= GestureTypeMissCount) {
            gestureInfo.type = null;
            gestureInfo.vaild = false;
        }
        if (gestureKeyInfo.vaild && gestureKeyInfo.type.equals(gestureInfo.type)) {
            gestureKeyInfo.copyTo(gestureInfo);
        }
        if (SLog.isEnable()) {
            SLog.d(TAG, String.format("mergeData, mToken[%s], vaild[%s], type[%s], missCount[%s], curType[%s], hitCount[%s]", Integer.valueOf(i3), Boolean.valueOf(gestureInfo.vaild), gestureInfo.type, Integer.valueOf(gestureInfo.missCount), gestureInfo.curType, Integer.valueOf(gestureInfo.hitCount)));
        }
    }

    public static void reportCost(long[] jArr, long j3) {
        long j16 = 0;
        if (j3 == 0) {
            return;
        }
        long j17 = -1;
        long j18 = 0;
        for (int i3 = 0; i3 < j3; i3++) {
            long j19 = jArr[i3];
            j17 = Math.min(j17, j19);
            j18 = Math.max(j18, j19);
            j16 += j19;
        }
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put(Element.ELEMENT_NAME_MIN, String.valueOf(j17));
        hashMap.put("max", String.valueOf(j18));
        hashMap.put("avg", String.valueOf(j16 / j3));
        hashMap.put("count", String.valueOf(j3));
        SdkContext.getInstance().getReporter().reportToBeacon(Gesture_Recognize_Time, true, -1L, -1L, hashMap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reportGestrue(HashMap<String, Integer> hashMap) {
        if (hashMap != null && !hashMap.isEmpty()) {
            HashMap<String, String> hashMap2 = new HashMap<>();
            String str = "";
            for (Map.Entry<String, Integer> entry : hashMap.entrySet()) {
                hashMap2.put(entry.getKey(), String.valueOf(entry.getValue()));
                str = str + ContainerUtils.FIELD_DELIMITER + entry.getKey() + ContainerUtils.KEY_VALUE_DELIMITER + entry.getValue();
            }
            SdkContext.getInstance().getReporter().reportToBeacon(ACT_QQAVGESTURE, true, -1L, -1L, hashMap2);
            SLog.d(TAG, "reportGestrue|" + str);
        }
    }

    public boolean checkIsLoadSo() {
        return this.bSoLoaded;
    }

    public GestureKeyInfo getGestureInfo() {
        GestureKeyInfo gestureKeyInfo = new GestureKeyInfo();
        this.mGestureInfo.copyTo(gestureKeyInfo);
        return gestureKeyInfo;
    }

    public int getModelLoadStatus() {
        return this.mModelLoadStatus;
    }

    public boolean loadSo() {
        if (this.bSoLoaded) {
            return this.mSoLaodSuc;
        }
        synchronized ("libAVGesture4Android.so") {
            if (this.bSoLoaded) {
                return this.mSoLaodSuc;
            }
            this.bSoLoaded = true;
            boolean innerLoadSo = innerLoadSo();
            this.mSoLaodSuc = innerLoadSo;
            if (innerLoadSo) {
                setModelLoadStatus(1);
            }
            SLog.d(TAG, String.format("loadSo, mSoLaodSuc[%s]", Boolean.valueOf(this.mSoLaodSuc)));
            return true;
        }
    }

    boolean preLoadSo() {
        if (this.bSoLoaded) {
            return this.mSoLaodSuc;
        }
        synchronized ("libAVGesture4Android.so") {
            if (this.bSoLoaded) {
                return this.mSoLaodSuc;
            }
            boolean innerLoadSo = innerLoadSo();
            if (innerLoadSo) {
                this.bSoLoaded = true;
                this.mSoLaodSuc = true;
                setModelLoadStatus(1);
            }
            SLog.d(TAG, String.format("preLoadSo, loadSuc[%s]", Boolean.valueOf(innerLoadSo)));
            return innerLoadSo;
        }
    }

    boolean pumpingframe() {
        int i3;
        int i16 = this.mRecognizeFrameRate;
        if (i16 != 0 && (i3 = this.mFrameRateCount) <= i16) {
            this.mFrameRateCount = i3 + 1;
            return false;
        }
        if (this.mRecognizeMillis != 0) {
            if (SystemClock.elapsedRealtime() < this.mLastTransferTime + this.mRecognizeMillis) {
                return false;
            }
            this.mLastTransferTime = SystemClock.elapsedRealtime();
        }
        this.mFrameRateCount = 0;
        return true;
    }

    public void setModelLoadStatus(int i3) {
        int i16 = this.mModelLoadStatus;
        if (i16 == i3) {
            return;
        }
        if (i16 != 1) {
            if (i16 == 2) {
                GestureDetectManager.getInstance().ResetModel();
                return;
            }
            return;
        }
        this.bSoLoaded = false;
    }

    public void setRecognizeFrameRate(int i3) {
        this.mRecognizeFrameRate = i3;
    }

    public void setRecognizeMillis(long j3) {
        this.mRecognizeMillis = j3;
    }

    public synchronized void start() {
        int i3 = this.mCurRecognizeRunnableToken;
        if (i3 == 0) {
            int genToken = genToken();
            this.mCurRecognizeRunnableToken = genToken;
            SLog.d(TAG, String.format("start, runnable create, curToken[%s]", Integer.valueOf(genToken)));
            this.mRecognizeRunnable = new RecognizeRunnable(this.mCurRecognizeRunnableToken);
            BaseThread baseThread = new BaseThread(this.mRecognizeRunnable);
            baseThread.setPriority(10);
            baseThread.start();
        } else {
            SLog.d(TAG, String.format("start, runnable exist, curToken[%s]", Integer.valueOf(i3)));
        }
    }

    public synchronized void stop() {
        this.mGestureInfo.reset();
        this.mGestureData = null;
        int i3 = this.mCurRecognizeRunnableToken;
        if (i3 != 0) {
            SLog.d(TAG, String.format("stop, curToken[%s]", Integer.valueOf(i3)));
            this.mCurRecognizeRunnableToken = 0;
            this.mRecognizeRunnable = null;
        }
    }

    public void transferRGBAbuffer(int i3, byte[] bArr, int i16, int i17, int i18, int i19) {
        if (SdkContext.getInstance().getResources().getGestureResource().isGestureEnable() && pumpingframe()) {
            if (bArr == null) {
                transferRGBAbuffer(RetrieveDataManager.getInstance().retrieveData(RetrieveDataManager.DATA_TYPE.RGBA.value, i3, i16, i17), i16, i17, i18, i19);
            } else {
                transferRGBAbuffer(bArr, i16, i17, i18, i19);
            }
        }
    }

    public void transferRGBAbuffer(int i3, int i16, int i17, int i18, int i19) {
        if (SdkContext.getInstance().getResources().getGestureResource().isGestureEnable() && pumpingframe()) {
            getInstance().transferRGBAbuffer(RetrieveDataManager.getInstance().retrieveData(RetrieveDataManager.DATA_TYPE.RGBA.value, i3, i16, i17), i16, i17, i18, i19);
        }
    }

    void transferRGBAbuffer(byte[] bArr, int i3, int i16, int i17, int i18) {
        if (!this.mSoLaodSuc || bArr == null || i3 == 0 || i16 == 0) {
            return;
        }
        try {
            this.mGestureData = new GestureData(bArr, i3, i16, i17, i18);
        } catch (Exception e16) {
            SLog.e(TAG, String.format("transferRGBAbuffer occured exception[%s]", e16.getClass().getName()), e16);
        } catch (OutOfMemoryError e17) {
            SLog.e(TAG, "transferRGBAbuffer occured OOM", e17);
        }
    }
}
