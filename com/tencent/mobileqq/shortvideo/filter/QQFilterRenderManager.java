package com.tencent.mobileqq.shortvideo.filter;

import android.annotation.SuppressLint;
import android.app.Application;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.aekit.openrender.internal.FrameBufferCache;
import com.tencent.aekit.plugin.core.AIAttr;
import com.tencent.mobileqq.shortvideo.gesture.GestureKeyInfo;
import com.tencent.mobileqq.shortvideo.gesture.GestureMgrRecognize;
import com.tencent.mobileqq.shortvideo.util.CameraInterFace;
import com.tencent.mobileqq.sveffects.libsveffects.BuildConfig;
import com.tencent.sveffects.SLog;
import com.tencent.sveffects.SdkContext;
import com.tencent.ttpic.baseutils.device.DeviceInstance;
import com.tencent.ttpic.baseutils.log.LogUtils;
import com.tencent.ttpic.openapi.PTFaceAttr;
import com.tencent.ttpic.openapi.manager.FeatureManager;
import com.tencent.ttpic.openapi.model.StarParam;
import com.tencent.ttpic.openapi.util.RetrieveDataManager;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: P */
@SuppressLint({"NewApi"})
/* loaded from: classes18.dex */
public class QQFilterRenderManager {
    public static final float FACE_DET_SCALE = 0.25f;
    private static final String TAG = "QQFilterRenderManager";
    private static final String sId_Prefix = "FRM_";
    private static final AtomicInteger sInstanceCount = new AtomicInteger(0);
    private AIAttr aiAttr;
    public CameraInterFace cameraInterFace;
    private boolean enableGauss;
    private boolean isAEDetectorInited;
    public boolean mBackCameraDetectEnable;
    private long mBeginTime;
    private FilterBusinessOperation mBusinessOpt;
    public boolean mDetectedFace;
    public boolean mDetectedGesture;
    private long mEndTime;
    private PTFaceAttr mFaceAttr;
    private int mFaceDetectBuffer;
    int mFaceDetectHeight;
    int mFaceDetectWidth;
    private FaceDetectParam mFaceParam;
    int mFilterHeight;
    int mFilterWidth;
    private boolean mHasGestureInit;
    private String mId;
    private final FilterManagerInternal mInternal;
    public GestureKeyInfo mLastGestureDetector;
    public boolean mNeedDoFaceDetect;
    public boolean mNeedDoGestureDetect;
    public boolean mNeedDoYTGestureDetect;
    private final Map<String, String> mParamMap;
    private StarParam mStarParam;
    private int mSufaceHeight;
    private int mSufaceWidth;
    private boolean mSurfaceDestroyed;
    private double mUIAspectRatio;

    /* compiled from: P */
    /* loaded from: classes18.dex */
    public final class ChainBuilder {
        boolean mNeedSort = false;
        ArrayList<Entry> mEntry = new ArrayList<>();

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: P */
        /* loaded from: classes18.dex */
        public class Entry {
            Object param;
            int type;

            Entry(int i3, Object obj) {
                this.type = i3;
                this.param = obj;
            }
        }

        ChainBuilder() {
        }

        private void sort() {
            Comparator<Entry> comparator = new Comparator<Entry>() { // from class: com.tencent.mobileqq.shortvideo.filter.QQFilterRenderManager.ChainBuilder.1
                @Override // java.util.Comparator
                public int compare(Entry entry, Entry entry2) {
                    return Integer.compare(entry.type, entry2.type);
                }
            };
            boolean z16 = true;
            if (DeviceInstance.getSDKVersion() >= 24) {
                try {
                    this.mEntry.sort(comparator);
                    z16 = false;
                } catch (NoSuchMethodError unused) {
                }
            }
            if (z16) {
                int size = this.mEntry.size();
                Entry[] entryArr = new Entry[size];
                this.mEntry.toArray(entryArr);
                Arrays.sort(entryArr, 0, size, comparator);
                this.mEntry.clear();
                this.mEntry.addAll(Arrays.asList(entryArr));
            }
        }

        public void addFilter(int i3, Object obj) {
            this.mEntry.add(new Entry(i3, obj));
        }

        public void commit() {
            if (this.mEntry.size() <= 0) {
                this.mNeedSort = false;
                SLog.i(QQFilterRenderManager.TAG, "QQFilterRenderManager ChainBuilder commit: size=" + this.mEntry.size());
                return;
            }
            if (this.mNeedSort) {
                sort();
            }
            int[] iArr = new int[this.mEntry.size()];
            Object[] objArr = new Object[this.mEntry.size()];
            for (int i3 = 0; i3 < this.mEntry.size(); i3++) {
                iArr[i3] = this.mEntry.get(i3).type;
                objArr[i3] = this.mEntry.get(i3).param;
            }
            QQFilterRenderManager.this.mInternal.push(iArr, objArr);
        }

        Object getParam(Object[] objArr, int i3) {
            if (objArr != null && i3 >= 0 && i3 < objArr.length) {
                return objArr[i3];
            }
            return null;
        }

        public void setUseSort(boolean z16) {
            this.mNeedSort = z16;
        }
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    private static class FaceDetectParam {
        public int mDataHeight;
        public int mDataWidth;
        public byte[] mFaceData;

        FaceDetectParam() {
        }
    }

    public QQFilterRenderManager() {
        this.mId = "";
        this.isAEDetectorInited = false;
        FilterManagerInternal filterManagerInternal = new FilterManagerInternal();
        this.mInternal = filterManagerInternal;
        this.enableGauss = true;
        this.mFaceDetectWidth = 0;
        this.mFaceDetectHeight = 0;
        this.mFaceDetectBuffer = 0;
        this.mDetectedFace = false;
        this.mNeedDoFaceDetect = false;
        this.mNeedDoYTGestureDetect = false;
        this.mBackCameraDetectEnable = false;
        this.mFaceParam = new FaceDetectParam();
        this.mBeginTime = 0L;
        this.mEndTime = 0L;
        this.mNeedDoGestureDetect = false;
        this.mDetectedGesture = false;
        this.mHasGestureInit = false;
        this.mLastGestureDetector = null;
        this.mParamMap = new ConcurrentHashMap();
        this.mSurfaceDestroyed = false;
        myId();
        filterManagerInternal.setCommonParam(this);
        this.mBusinessOpt = new FilterBusinessOperation(this);
    }

    private void clear() {
        destroyGestureDetector();
        this.mParamMap.clear();
    }

    private void destroyGestureDetector() {
        this.mHasGestureInit = false;
        this.mNeedDoGestureDetect = false;
        this.mDetectedGesture = false;
        GestureMgrRecognize.getInstance().stop();
    }

    private void initial() {
        if (BuildConfig.DEBUG) {
            Application application = SdkContext.getInstance().getApplication();
            if (application != null) {
                LogUtils.setEnable(application.getSharedPreferences("mobileQQ", 0).getBoolean("sv_error_log", false));
                return;
            } else {
                LogUtils.setEnable(false);
                return;
            }
        }
        LogUtils.setEnable(false);
    }

    private void myId() {
        this.mId = sId_Prefix + sInstanceCount.getAndIncrement();
    }

    public void cameraChange(int i3) {
        QQFilterLogManager.setLogStart("cameraChange");
        this.mInternal.changeCamera(i3);
        QQFilterLogManager.setLogEnd("cameraChange");
    }

    public void destroyAEDetecor() {
        this.isAEDetectorInited = false;
        this.mDetectedFace = false;
        this.mNeedDoFaceDetect = false;
        this.aiAttr = null;
        this.mFaceAttr = null;
    }

    public final int drawFrame(int i3) {
        QQFilterLogManager.setOnDrawFrameStart();
        int runChain = this.mInternal.runChain(i3);
        QQFilterLogManager.setOnDrawFrameEnd();
        return runChain;
    }

    public AIAttr getAIAttr() {
        return this.aiAttr;
    }

    public List<QQBaseFilter> getAllActiveFilters() {
        ArrayList arrayList = new ArrayList();
        this.mInternal.getAllActiveFilter(arrayList);
        return arrayList;
    }

    public boolean getBackCameraDetectEnable() {
        return this.mBackCameraDetectEnable;
    }

    public boolean getBooleanParam(String str) {
        String str2 = this.mParamMap.get(str);
        if (!TextUtils.isEmpty(str2)) {
            return Boolean.parseBoolean(str2);
        }
        return false;
    }

    public FilterBusinessOperation getBusinessOperation() {
        return this.mBusinessOpt;
    }

    public int getCameraID() {
        CameraInterFace cameraInterFace = this.cameraInterFace;
        if (cameraInterFace == null) {
            return -1;
        }
        return cameraInterFace.getCameraID();
    }

    public final ChainBuilder getChainBuilder() {
        return new ChainBuilder();
    }

    public final String getCurrentChainId() {
        return this.mInternal.getCurrentChainId();
    }

    public final boolean getCurrentChainInfo(ArrayList<Integer> arrayList, ArrayList<Object> arrayList2) {
        return this.mInternal.getCurrentChainData(arrayList, arrayList2);
    }

    public PTFaceAttr getFaceAttr() {
        return this.mFaceAttr;
    }

    public byte[] getFaceDataAfterDoFaceDetect() {
        if (this.mNeedDoFaceDetect) {
            return this.mFaceParam.mFaceData;
        }
        return null;
    }

    public byte[] getFaceDetectDataByTexture(int i3, int i16, int i17) {
        this.mBeginTime = SystemClock.elapsedRealtimeNanos();
        byte[] retrieveData = RetrieveDataManager.getInstance().retrieveData(RetrieveDataManager.DATA_TYPE.RGBA.value, i3, i16, i17);
        this.mEndTime = SystemClock.elapsedRealtimeNanos();
        if (SLog.isEnable()) {
            SLog.d(TAG, "FilterProcessRender_showPreview[doFaceDetectInitAndFlip " + ((this.mEndTime - this.mBeginTime) / 1000) + "us]");
        }
        return retrieveData;
    }

    public boolean getFaceDetectFlags() {
        return this.mNeedDoFaceDetect;
    }

    public int getFaceDetectHeight() {
        return this.mFaceDetectHeight;
    }

    public int getFaceDetectWidth() {
        return this.mFaceDetectWidth;
    }

    public String getFilterCacheInfo() {
        return this.mInternal.getCacheFilterInfo();
    }

    public int getFilterHeight() {
        return this.mFilterHeight;
    }

    public Object getFilterSpecificParam(int i3) {
        return this.mInternal.getFilterSpecificParam(i3);
    }

    public int getFilterWidth() {
        return this.mFilterWidth;
    }

    public float getFloatParam(String str) {
        String str2 = this.mParamMap.get(str);
        if (!TextUtils.isEmpty(str2)) {
            return Float.parseFloat(str2);
        }
        return -1.0f;
    }

    public int getIntParam(String str) {
        String str2 = this.mParamMap.get(str);
        if (!TextUtils.isEmpty(str2)) {
            return Integer.parseInt(str2);
        }
        return -1;
    }

    public String getParam(String str) {
        return this.mParamMap.get(str);
    }

    public QQBaseFilter getQQFilterByType(int i3) {
        return this.mInternal.currentChainGetFilter(i3);
    }

    public List<QQBaseFilter> getQQFilters(int i3) {
        ArrayList arrayList = new ArrayList();
        QQBaseFilter currentChainGetFilter = this.mInternal.currentChainGetFilter(i3);
        if (currentChainGetFilter != null) {
            arrayList.add(currentChainGetFilter);
        }
        return arrayList;
    }

    public String getStackTraceInfo() {
        return this.mInternal.generateStackTrace();
    }

    public int getSufaceWidth() {
        return this.mSufaceWidth;
    }

    public int getSurfaceHeight() {
        return this.mSufaceHeight;
    }

    public double getUIAspectRatio() {
        return this.mUIAspectRatio;
    }

    public double getWindowScale() {
        int i3;
        int i16 = this.mFaceDetectWidth;
        if (i16 != 0 && (i3 = this.mFilterWidth) != 0) {
            float f16 = (i16 * 1.0f) / i3;
            this.mFaceDetectHeight = (int) (this.mFilterHeight * f16);
            return f16;
        }
        return 0.25d;
    }

    public boolean hasAEDetectorInited() {
        return this.isAEDetectorInited;
    }

    public boolean hasActiveFilter() {
        return this.mInternal.hasAllResourceActiveFilter();
    }

    public boolean hasQQFilter(int i3) {
        return this.mInternal.currentChinaHasFilter(i3);
    }

    public void initAEDetector_sync() {
        if (!this.isAEDetectorInited) {
            FeatureManager.loadBasicFeatures();
            if (!FeatureManager.isBasicFeaturesFunctionReady()) {
                return;
            }
            this.aiAttr = null;
        }
    }

    public void initDetectFaceSDK(Frame frame) {
        initAEDetector_sync();
        if (this.mNeedDoFaceDetect && this.isAEDetectorInited) {
            doAIDetect(frame);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0058  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void initGestureDetectorSDK_Sync() {
        int i3;
        int i16;
        if (this.mHasGestureInit) {
            return;
        }
        this.mHasGestureInit = true;
        String gestureGapTime = SdkContext.getInstance().getResources().getGestureResource().getGestureGapTime();
        String gestureGapFrame = SdkContext.getInstance().getResources().getGestureResource().getGestureGapFrame();
        try {
            i3 = Integer.parseInt(gestureGapTime);
        } catch (NumberFormatException unused) {
            i3 = 200;
        }
        try {
            i16 = Integer.parseInt(gestureGapFrame);
        } catch (NumberFormatException unused2) {
            if (SLog.isEnable()) {
                SLog.d("GestureTestUse", "GestureMgr.getInstance().setRecognizeMillis number exception" + i3);
            }
            i16 = 5;
            if (SLog.isEnable()) {
            }
            GestureMgrRecognize.getInstance().setRecognizeMillis(i3);
            GestureMgrRecognize.getInstance().setRecognizeFrameRate(i16);
        }
        if (SLog.isEnable()) {
            SLog.d("GestureTestUse", "PtvTemplateManager.mGestureGapTime raw value " + gestureGapTime + ":GestureMgr.getInstance().setRecognizeMillis normal result" + i3 + ",frameRate is:" + i16);
        }
        GestureMgrRecognize.getInstance().setRecognizeMillis(i3);
        GestureMgrRecognize.getInstance().setRecognizeFrameRate(i16);
    }

    public boolean isEnableGauss() {
        return this.enableGauss;
    }

    public boolean isFilterWork(int i3) {
        return this.mInternal.isFilterWork(i3);
    }

    public boolean isSurfaceDestroyed() {
        return this.mSurfaceDestroyed;
    }

    public boolean loadFilterSoSuccess() {
        return FeatureManager.isBasicFeaturesFunctionReady();
    }

    public boolean needFaceDetect() {
        return this.mInternal.needFaceDetect();
    }

    public void onPause() {
        this.mInternal.onCurrentChainPause();
    }

    public void onResume() {
        this.mInternal.onCurrentChainResume();
    }

    public final void popAndRelease(String str) {
        this.mInternal.popAndRelease(str);
    }

    public final void popChain(String str) {
        this.mInternal.pop(str);
    }

    public final String pushChain(int[] iArr, Object[] objArr) {
        return this.mInternal.push(iArr, objArr);
    }

    public String pushChainBasedStackTopChain(int i3, Object obj) {
        return this.mInternal.insertNewFilterToOldChain_pushChain(i3, obj);
    }

    public void setBackCameraDetectEnable(boolean z16) {
        this.mBackCameraDetectEnable = z16;
    }

    public void setCaptureMode(boolean z16) {
        FilterManagerInternal filterManagerInternal = this.mInternal;
        if (filterManagerInternal != null) {
            filterManagerInternal.setCaptureMode(z16);
        }
    }

    public void setEnableGauss(boolean z16) {
        this.enableGauss = z16;
    }

    public void setFaceDetectFlags(boolean z16) {
        this.mNeedDoFaceDetect = z16;
    }

    public final void setFilterSpecificParam(int i3, Object obj) {
        this.mInternal.setFilterSpecificParam(i3, obj);
    }

    public void setGestureDetectectFlags(boolean z16) {
        this.mNeedDoGestureDetect = z16;
        if (z16) {
            GestureMgrRecognize.getInstance().start();
        } else {
            GestureMgrRecognize.getInstance().stop();
        }
    }

    public void setNeedFlip(boolean z16) {
        this.mInternal.setNeedFaceDetectFlip(z16);
    }

    public void setParam(String str, String str2) {
        this.mParamMap.put(str, str2);
    }

    public void setStarParam(StarParam starParam) {
        this.mStarParam = starParam;
    }

    public void setYTGestureDetectFlags(boolean z16) {
        this.mNeedDoYTGestureDetect = z16;
    }

    public final void surfaceChange(int i3, int i16, int i17, int i18) {
        QQFilterLogManager.setLogStart("surfaceChange");
        updatePreviewSize(i3, i16, i17, i18);
        QQFilterLogManager.setLogEnd("surfaceChange");
    }

    public final void surfaceCreate(int i3, int i16, int i17, int i18) {
        QQFilterLogManager.setLogStart("surfaceCreate");
        initial();
        updatePreviewSize(i3, i16, i17, i18);
        QQFilterLogManager.setLogEnd("surfaceCreate");
    }

    public final void surfaceDestroyed() {
        QQFilterLogManager.setLogStart("surfaceDestroyed");
        clear();
        this.mInternal.releaseAllResource();
        FrameBufferCache.getInstance().destroy();
        this.mSurfaceDestroyed = true;
        QQFilterLogManager.setLogEnd("surfaceDestroyed");
    }

    public void updatePreviewSize(int i3, int i16, int i17, int i18) {
        int i19;
        this.mSufaceWidth = i17;
        this.mSufaceHeight = i18;
        this.mFilterWidth = i3;
        this.mFilterHeight = i16;
        this.mUIAspectRatio = i3 / i16;
        int i26 = this.mFaceDetectWidth;
        if (i26 == 0 || (i19 = this.mFaceDetectHeight) == 0 || this.mFaceDetectBuffer == 0 || i26 < 90 || i19 < 120) {
            int i27 = (int) (i3 * 0.25f);
            this.mFaceDetectWidth = i27;
            int i28 = (int) (i16 * 0.25f);
            this.mFaceDetectHeight = i28;
            this.mFaceDetectBuffer = i27 * i28 * 4;
        }
        if (SLog.isEnable()) {
            SLog.d(TAG, "updatePreviewSize:: mSufaceWidth=" + this.mSufaceWidth + ";mSufaceHeight=" + this.mSufaceHeight + ";mFilterWidth=" + this.mFilterWidth + ";mFilterHeight=" + this.mFilterHeight + ";mFaceDetectWidth" + this.mFaceDetectWidth + ";mFaceDetectHeight=" + this.mFaceDetectHeight + "; mUIRatio:" + this.mUIAspectRatio);
        }
    }

    public final String pushChain(ArrayList<Integer> arrayList, ArrayList<Object> arrayList2) {
        return this.mInternal.push(arrayList, arrayList2);
    }

    public QQFilterRenderManager(int[] iArr) {
        this(iArr, null, true);
    }

    public QQFilterRenderManager(int[] iArr, Object[] objArr, boolean z16) {
        this.mId = "";
        this.isAEDetectorInited = false;
        FilterManagerInternal filterManagerInternal = new FilterManagerInternal();
        this.mInternal = filterManagerInternal;
        this.enableGauss = true;
        this.mFaceDetectWidth = 0;
        this.mFaceDetectHeight = 0;
        this.mFaceDetectBuffer = 0;
        this.mDetectedFace = false;
        this.mNeedDoFaceDetect = false;
        this.mNeedDoYTGestureDetect = false;
        this.mBackCameraDetectEnable = false;
        this.mFaceParam = new FaceDetectParam();
        this.mBeginTime = 0L;
        this.mEndTime = 0L;
        this.mNeedDoGestureDetect = false;
        this.mDetectedGesture = false;
        this.mHasGestureInit = false;
        this.mLastGestureDetector = null;
        this.mParamMap = new ConcurrentHashMap();
        this.mSurfaceDestroyed = false;
        myId();
        filterManagerInternal.setCommonParam(this);
        this.mBusinessOpt = new FilterBusinessOperation(this);
        if (iArr != null) {
            if (z16) {
                ChainBuilder chainBuilder = getChainBuilder();
                chainBuilder.setUseSort(true);
                for (int i3 = 0; i3 < iArr.length; i3++) {
                    chainBuilder.addFilter(iArr[i3], chainBuilder.getParam(objArr, i3));
                }
                chainBuilder.commit();
                return;
            }
            filterManagerInternal.push(iArr, objArr);
        }
    }

    private void doAIDetect(Frame frame) {
    }
}
