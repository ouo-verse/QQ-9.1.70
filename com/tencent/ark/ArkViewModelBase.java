package com.tencent.ark;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.RectF;
import android.text.TextUtils;
import android.util.LruCache;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.ark.ArkPerfMonitor;
import com.tencent.ark.ArkVsync;
import com.tencent.ark.Constants;
import com.tencent.ark.ark;
import com.tencent.ark.open.internal.ArkAppReport;
import com.tencent.soter.core.keystore.KeyPropertiesCompact;
import java.lang.ref.WeakReference;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes3.dex */
public class ArkViewModelBase implements ark.ContainerCallback, ArkVsync.ArkFrameCallback {
    public static final int APP_CREATE_FAILED = 104;
    public static final int APP_CREATE_ROOTVIEW_FAILED = 105;
    public static final int APP_JSCORE_NOT_LOADED = 107;
    public static final int APP_LOAD_APPLICATION_FAILED = 106;
    public static final int APP_LOAD_FAILED = 101;
    public static final int APP_LOAD_SUCCESS = 100;
    public static final int APP_RUN_FAILED = 102;
    public static final int APP_VIEW_IMPL_EMPTY = 103;
    public static final int ARKAPP_TYPE_DESTROY = 2;
    public static final int ARKAPP_TYPE_PAUSE = 0;
    public static final int ARKAPP_TYPE_RELOAD = 3;
    public static final int ARKAPP_TYPE_RESUME = 1;
    protected static final String KEY_FORMAT = "%s_%s";
    protected static final String TAG = "ArkApp.ViewModel";
    protected ark.ApplicationCallback mAppCallback;
    protected ark.Application mApplication;
    protected ark.Container mContainer;
    protected String mQueueKey;
    protected ArkViewImplement mViewImpl;
    protected static final ArkEnvironmentManager ENV = ArkEnvironmentManager.getInstance();
    private static final Object lock = new Object();
    protected static final HashMap<String, Size> sAppSizeHint = new HashMap<>(8);
    private static final LruCache<String, Size> mCacheSizeHint = new LruCache<>(12);
    protected static boolean sAppInit = false;
    protected Rect mRectArkContainer = new Rect();
    protected Rect mRectContainer = new Rect();
    protected RectF mRectContainerF = new RectF();
    protected RectF mRectInvalidF = new RectF();
    protected boolean mInit = false;
    protected boolean mLoadFailed = false;
    protected boolean mHasLoaded = false;
    protected boolean mRoundCorner = false;
    protected boolean mInSyncRect = false;
    protected boolean mFirstDraw = true;
    protected boolean mIsGpuRendering = false;
    protected boolean mNeedFirstPaint = false;
    public ErrorInfo mErrorInfo = new ErrorInfo();
    protected volatile boolean mSyncRectLock = false;
    protected volatile boolean mAttached = false;
    protected volatile boolean mIsActivated = true;
    protected volatile boolean mIsForeground = true;
    protected volatile boolean mIsVisible = true;
    protected boolean mInActivateStatus = true;
    protected int mDrawCount = 0;
    protected boolean mPerfTaskRunning = false;
    protected boolean mIsIndependentView = false;
    protected boolean mIsMemoryOptimized = false;
    protected AppInfo mAppInfo = new AppInfo();
    protected TimeRecord mTimeRecord = new TimeRecord();
    protected Runnable mPostRedraw = new Runnable() { // from class: com.tencent.ark.ArkViewModelBase.12
        @Override // java.lang.Runnable
        public void run() {
            if (!ArkViewModelBase.this.mRectContainerF.isEmpty()) {
                ArkViewModelBase arkViewModelBase = ArkViewModelBase.this;
                RectF rectF = arkViewModelBase.mRectContainerF;
                arkViewModelBase.Update(rectF.left, rectF.top, rectF.right, rectF.bottom);
            }
        }
    };
    private Runnable mPostInvalid = new Runnable() { // from class: com.tencent.ark.ArkViewModelBase.13
        @Override // java.lang.Runnable
        public void run() {
            ArkViewModelBase arkViewModelBase = ArkViewModelBase.this;
            ArkViewImplement arkViewImplement = arkViewModelBase.mViewImpl;
            if (arkViewImplement != null && !arkViewModelBase.mRectArkContainer.isEmpty()) {
                arkViewImplement.onInvalidate(ArkViewModelBase.this.mRectArkContainer);
            }
        }
    };

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static class AppInfo {
        public String appConfig;
        public String appMinVersion;
        public String bizSrc;
        public Size cacheSize;
        public String meta;
        public String name;
        public String path;
        public String qqConnectAppId;
        public String qqConnectAppType;
        public float scale;
        public String view;
        public boolean canceled = false;
        public int width = 0;
        public int height = 0;
        public int minWidth = -1;
        public int minHeight = -1;
        public int maxWidth = -1;
        public int maxHeight = -1;
        public int hintWidth = -1;
        public int hintHeight = -1;

        public String toString() {
            return "AppInfo{scale=" + this.scale + ", name='" + this.name + "', path='" + this.path + "', view='" + this.view + "', meta='" + this.meta + "', appMinVersion='" + this.appMinVersion + "', bizSrc='" + this.bizSrc + "', canceled=" + this.canceled + ", appConfig='" + this.appConfig + "', width=" + this.width + ", height=" + this.height + ", minWidth=" + this.minWidth + ", minHeight=" + this.minHeight + ", maxWidth=" + this.maxWidth + ", maxHeight=" + this.maxHeight + ", hintWidth=" + this.hintWidth + ", hintHeight=" + this.hintHeight + ", cacheSize=" + this.cacheSize + ", qqConnectAppId=" + this.qqConnectAppId + ", qqConnectAppType=" + this.qqConnectAppType + '}';
        }
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static class ErrorInfo {
        public boolean canRetry = true;

        /* renamed from: msg, reason: collision with root package name */
        public String f72565msg;
        public int retCode;
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static class Size {
        public int height;
        public int width;

        public Size(int i3, int i16) {
            this.width = i3;
            this.height = i16;
        }

        public String toString() {
            return "{" + this.width + "," + this.height + "}";
        }
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static class TimeRecord {
        public String appName;
        public String bizSrc;
        public String view;
        public long beginOfCreateView = 0;
        public long endOfCreateView = 0;
        public long beginOfCreateApplication = 0;
        public long beginOfCreateContainer = 0;
        public long beginOfInitContainer = 0;
        public long beginOfRunApplication = 0;
        public long beginOfDisplyView = 0;
        public long endOfDisplyView = 0;
        public long beginOfCreateContext = 0;
        public long endOfCreateContext = 0;
        public long beginOfCreateDrawTarget = 0;
        public long endOfCreateDrawTarget = 0;
        public long beginOfFirstDraw = 0;
        public long endOfFirstDraw = 0;
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    static final class TouchRunnable implements Runnable {
        private final WeakReference<ArkViewModelBase> arkViewModelBaseWeakRef;
        private int mAction;
        private ark.Container mContainer;
        private int[] mId;
        private long mLastPrintTime = 0;
        private float[] mX;
        private float[] mY;

        public TouchRunnable(MotionEvent motionEvent, ark.Container container, ArkViewModelBase arkViewModelBase, float f16) {
            this.mAction = motionEvent.getActionMasked();
            this.mContainer = container;
            this.arkViewModelBaseWeakRef = new WeakReference<>(arkViewModelBase);
            int i3 = this.mAction;
            if (i3 != 5 && i3 != 6) {
                int pointerCount = motionEvent.getPointerCount();
                pointerCount = pointerCount > ark.arkGetMaxTouchPoints() ? ark.arkGetMaxTouchPoints() : pointerCount;
                this.mId = new int[pointerCount];
                this.mX = new float[pointerCount];
                this.mY = new float[pointerCount];
                for (int i16 = 0; i16 < pointerCount; i16++) {
                    this.mId[i16] = motionEvent.getPointerId(i16);
                    this.mX[i16] = motionEvent.getX(i16) / f16;
                    this.mY[i16] = motionEvent.getY(i16) / f16;
                }
                return;
            }
            this.mId = new int[1];
            this.mX = new float[1];
            this.mY = new float[1];
            int actionIndex = motionEvent.getActionIndex();
            this.mId[0] = motionEvent.getPointerId(actionIndex);
            this.mX[0] = motionEvent.getX(actionIndex) / f16;
            this.mY[0] = motionEvent.getY(actionIndex) / f16;
        }

        private boolean checkPrintTimeValid() {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.mLastPrintTime >= 1500) {
                this.mLastPrintTime = currentTimeMillis;
                return true;
            }
            return false;
        }

        public void clearRef() {
            WeakReference<ArkViewModelBase> weakReference = this.arkViewModelBaseWeakRef;
            if (weakReference != null) {
                weakReference.clear();
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:29:0x0069, code lost:
        
            if (r0 != 6) goto L41;
         */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void run() {
            ArkViewModelBase arkViewModelBase;
            ArkViewModelBase arkViewModelBase2;
            if (ArkViewModelBase.ENV.mIsDebug && this.mAction != 2) {
                Logger.logD(ArkViewModelBase.TAG, "TouchRunnable.action:" + this.mAction + ",count:" + this.mId.length);
            }
            if (this.mContainer == null) {
                Logger.logE(ArkViewModelBase.TAG, "TouchRunnable mContainer is null");
                clearRef();
                return;
            }
            WeakReference<ArkViewModelBase> weakReference = this.arkViewModelBaseWeakRef;
            if (weakReference != null && ((arkViewModelBase2 = weakReference.get()) == null || !arkViewModelBase2.mAttached)) {
                Logger.logE(ArkViewModelBase.TAG, "TouchRunnable arkViewModelBase is null or attach false");
                clearRef();
                return;
            }
            int i3 = this.mAction;
            if (i3 != 0) {
                if (i3 != 1) {
                    if (i3 != 2) {
                        if (i3 != 3) {
                            if (i3 != 5) {
                            }
                        } else {
                            ark.Container container = this.mContainer;
                            float[] fArr = this.mX;
                            float[] fArr2 = this.mY;
                            int[] iArr = this.mId;
                            container.TouchCancel(fArr, fArr2, iArr, iArr.length);
                            if (checkPrintTimeValid()) {
                                Logger.logD(ArkViewModelBase.TAG, "TouchRunnable.action:" + this.mAction + ",count:" + this.mId.length);
                            }
                        }
                    } else {
                        ark.Container container2 = this.mContainer;
                        float[] fArr3 = this.mX;
                        float[] fArr4 = this.mY;
                        int[] iArr2 = this.mId;
                        container2.TouchMove(fArr3, fArr4, iArr2, iArr2.length);
                    }
                    clearRef();
                }
                ark.Container container3 = this.mContainer;
                float[] fArr5 = this.mX;
                float[] fArr6 = this.mY;
                int[] iArr3 = this.mId;
                container3.TouchEnd(fArr5, fArr6, iArr3, iArr3.length);
                WeakReference<ArkViewModelBase> weakReference2 = this.arkViewModelBaseWeakRef;
                if (weakReference2 != null && (arkViewModelBase = weakReference2.get()) != null) {
                    arkViewModelBase.onClickReport();
                }
                clearRef();
            }
            ark.Container container4 = this.mContainer;
            float[] fArr7 = this.mX;
            float[] fArr8 = this.mY;
            int[] iArr4 = this.mId;
            container4.TouchStart(fArr7, fArr8, iArr4, iArr4.length);
            clearRef();
        }
    }

    public ArkViewModelBase(ark.ApplicationCallback applicationCallback) {
        this.mAppCallback = applicationCallback;
    }

    public static void clearAppSizeHintCache(String str, String str2) {
        HashMap<String, Size> hashMap = sAppSizeHint;
        synchronized (hashMap) {
            hashMap.remove(str + "_" + str2);
        }
    }

    public static void clearArkHttpProxy() {
        if (ENV.isLibraryLoad()) {
            ark.arkHTTPSetDefaultHttpProxy("", 0);
        }
    }

    public static Rect convertRect(RectF rectF) {
        Rect rect = new Rect();
        rect.left = (int) rectF.left;
        rect.top = (int) rectF.top;
        rect.right = (int) Math.ceil(rectF.right);
        rect.bottom = (int) Math.ceil(rectF.bottom);
        return rect;
    }

    private Map<String, String> getCommonParams() {
        HashMap hashMap = new HashMap();
        hashMap.put("ark_id", this.mAppInfo.name);
        hashMap.put("ark_biz_src", this.mAppInfo.bizSrc);
        if (!TextUtils.isEmpty(this.mAppInfo.qqConnectAppId)) {
            hashMap.put("qqconnect_appid", this.mAppInfo.qqConnectAppId);
        }
        if (!TextUtils.isEmpty(this.mAppInfo.qqConnectAppType)) {
            hashMap.put("qqconnect_app_type", this.mAppInfo.qqConnectAppType);
        }
        return hashMap;
    }

    private static String getMD5Hash(String str) {
        try {
            byte[] digest = MessageDigest.getInstance(KeyPropertiesCompact.DIGEST_MD5).digest(str.getBytes());
            StringBuilder sb5 = new StringBuilder();
            for (byte b16 : digest) {
                int i3 = b16 & 255;
                if (i3 < 16) {
                    sb5.append('0');
                }
                sb5.append(Integer.toHexString(i3));
            }
            return sb5.toString();
        } catch (NoSuchAlgorithmException e16) {
            e16.printStackTrace();
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleCacheSize(AppInfo appInfo) {
        Size size = appInfo.cacheSize;
        if (size == null) {
            return;
        }
        Size size2 = new Size(this.mRectContainer.width(), this.mRectContainer.height());
        if (size2.width == size.width && size2.height == size.height) {
            return;
        }
        String mD5Hash = getMD5Hash(appInfo.name + appInfo.view + appInfo.meta);
        if (TextUtils.isEmpty(mD5Hash)) {
            return;
        }
        mCacheSizeHint.put(mD5Hash, size2);
        Logger.logI(TAG, "mCacheSizeHint cache put, key=" + mD5Hash + ",  app=" + this.mAppInfo.name + ", view=" + this.mAppInfo.view + ", newSize=" + size2 + ", oldSize=" + size);
    }

    private void putParams(Map<String, String> map, String str, String str2) {
        if (!TextUtils.isEmpty(str2)) {
            map.put(str, str2);
        }
    }

    private void reportPerfStat() {
        AppInfo appInfo = this.mAppInfo;
        if (appInfo != null && appInfo.name != null && appInfo.view != null) {
            ArkPerfMonitor arkPerfMonitor = ArkPerfMonitor.getInstance();
            AppInfo appInfo2 = this.mAppInfo;
            arkPerfMonitor.doReport(appInfo2.name, appInfo2.view, new ArkPerfMonitor.IReport() { // from class: com.tencent.ark.ArkViewModelBase.9
                @Override // com.tencent.ark.ArkPerfMonitor.IReport
                public void report(String str, String str2, int i3) {
                    Logger.logI(ArkViewModelBase.TAG, "perf report: app=" + str + "-" + str2 + ", avg-block-time=" + i3);
                    HashMap hashMap = new HashMap();
                    hashMap.put("view", str2);
                    ArkViewModelBase.ENV.doDataReport(str, "DisplayTimeConsuming", true, i3, hashMap);
                }
            });
        }
    }

    public static void setArkHttpProxy() {
        ArkEnvironmentManager arkEnvironmentManager = ENV;
        if (arkEnvironmentManager.isLibraryLoad()) {
            String proxyHost = arkEnvironmentManager.getProxyHost();
            int proxyPort = arkEnvironmentManager.getProxyPort();
            if (!TextUtils.isEmpty(proxyHost) && proxyPort != 0) {
                ark.arkHTTPSetDefaultHttpProxy(proxyHost, proxyPort);
            } else {
                ark.arkHTTPSetDefaultHttpProxy("", 0);
            }
            Logger.logI(TAG, "setArkHttpProxy, host=" + proxyHost + ",port=" + proxyPort);
        }
    }

    public int GetAppScriptType() {
        ark.Application application = this.mApplication;
        if (application != null) {
            return application.GetScriptType();
        }
        return 0;
    }

    public boolean InputCanRedo() {
        ark.Container container = this.mContainer;
        if (container != null) {
            return container.InputCanRedo();
        }
        return false;
    }

    public boolean InputCanUndo() {
        ark.Container container = this.mContainer;
        if (container != null) {
            return container.InputCanUndo();
        }
        return false;
    }

    public boolean InputDeleteBackward() {
        ark.Container container = this.mContainer;
        if (container != null) {
            return container.InputDeleteBackward();
        }
        return false;
    }

    @Override // com.tencent.ark.ark.ContainerCallback
    public void InputFocusChanged(final boolean z16, final boolean z17, final int i3, float f16, float f17, float f18, float f19) {
        final ArkViewImplement arkViewImplement = this.mViewImpl;
        if (arkViewImplement == null) {
            return;
        }
        final Rect rect = new Rect((int) f16, (int) f17, (int) f18, (int) f19);
        ArkDispatchTask.getInstance().postToMainThread(new Runnable() { // from class: com.tencent.ark.ArkViewModelBase.16
            @Override // java.lang.Runnable
            public void run() {
                arkViewImplement.onInputFocusChanged(z16, z17, i3, rect);
            }
        });
    }

    public String InputGetSelectText() {
        ark.Container container = this.mContainer;
        if (container != null) {
            return container.InputGetSelectText();
        }
        return null;
    }

    public boolean InputInsertText(String str) {
        ark.Container container = this.mContainer;
        if (container != null) {
            return container.InputInsertText(str);
        }
        return false;
    }

    public boolean InputIsFocused() {
        ark.Container container = this.mContainer;
        if (container != null) {
            return container.InputIsFocused();
        }
        return false;
    }

    @Override // com.tencent.ark.ark.ContainerCallback
    public void InputMenuChanged(final boolean z16, int i3, int i16, int i17, final int i18) {
        final ArkViewImplement arkViewImplement = this.mViewImpl;
        if (arkViewImplement == null) {
            return;
        }
        float f16 = this.mAppInfo.scale;
        final int i19 = (int) (i3 * f16);
        final int i26 = (int) (i16 * f16);
        final int i27 = (int) (i17 * f16);
        ArkDispatchTask.getInstance().postToMainThread(new Runnable() { // from class: com.tencent.ark.ArkViewModelBase.17
            @Override // java.lang.Runnable
            public void run() {
                arkViewImplement.onInputMenuChanged(z16, i19, i26, i27, i18);
            }
        });
    }

    public boolean InputRedo() {
        ark.Container container = this.mContainer;
        if (container != null) {
            return container.InputRedo();
        }
        return false;
    }

    public boolean InputSelect() {
        ark.Container container = this.mContainer;
        if (container != null) {
            return container.InputSelect();
        }
        return false;
    }

    public boolean InputSelectAll() {
        ark.Container container = this.mContainer;
        if (container != null) {
            return container.InputSelectAll();
        }
        return false;
    }

    @Override // com.tencent.ark.ark.ContainerCallback
    public void InputSelectChanged(int i3, int i16, int i17, int i18, float f16, float f17, float f18, float f19) {
        final ArkViewImplement arkViewImplement = this.mViewImpl;
        if (arkViewImplement == null) {
            return;
        }
        final Rect rect = new Rect((int) f16, (int) f17, (int) f18, (int) f19);
        float f26 = this.mAppInfo.scale;
        final int i19 = (int) (i3 * f26);
        final int i26 = (int) (i16 * f26);
        final int i27 = (int) (i17 * f26);
        final int i28 = (int) (i18 * f26);
        ArkDispatchTask.getInstance().postToMainThread(new Runnable() { // from class: com.tencent.ark.ArkViewModelBase.18
            @Override // java.lang.Runnable
            public void run() {
                arkViewImplement.onInputSelectChanged(i19, i26, i27, i28, rect);
            }
        });
    }

    public boolean InputSetCaretHolderSize(int i3, int i16) {
        ark.Container container = this.mContainer;
        if (container != null) {
            float f16 = this.mAppInfo.scale;
            return container.InputSetCaretHolderSize((int) (i3 / f16), (int) (i16 / f16));
        }
        return false;
    }

    public boolean InputSetSelectHolderSize(int i3, int i16) {
        ark.Container container = this.mContainer;
        if (container != null) {
            float f16 = this.mAppInfo.scale;
            return container.InputSetSelectHolderSize((int) (i3 / f16), (int) (i16 / f16));
        }
        return false;
    }

    public boolean InputUndo() {
        ark.Container container = this.mContainer;
        if (container != null) {
            return container.InputUndo();
        }
        return false;
    }

    public void SafeAsyncRun(Runnable runnable) {
        if (TextUtils.isEmpty(this.mQueueKey)) {
            Logger.logE(TAG, "SafeAsyncRun mInit= " + this.mInit + ", mQueueKey=" + this.mQueueKey);
            return;
        }
        try {
            ArkDispatchQueue.asyncRun(this.mQueueKey, runnable);
        } catch (UnsatisfiedLinkError e16) {
            Logger.logE(TAG, "SafeAsyncRun, exception=" + e16.getMessage());
        }
    }

    public void SafeAsyncRunDelay(Runnable runnable, long j3) {
        if (TextUtils.isEmpty(this.mQueueKey)) {
            Logger.logE(TAG, "SafeAsyncRun mInit= " + this.mInit + ", mQueueKey=" + this.mQueueKey);
            return;
        }
        try {
            ArkDispatchQueue.asyncRun(this.mQueueKey, runnable, j3);
        } catch (UnsatisfiedLinkError e16) {
            Logger.logE(TAG, "SafeAsyncRun, exception=" + e16.getMessage());
        }
    }

    @Override // com.tencent.ark.ark.ContainerCallback
    public void SyncRect(float f16, float f17, float f18, float f19) {
        Rect rect = new Rect(this.mRectArkContainer);
        this.mRectContainerF.set(f16, f17, f18, f19);
        this.mRectArkContainer = convertRect(this.mRectContainerF);
        final ArkViewImplement arkViewImplement = this.mViewImpl;
        if (!this.mSyncRectLock && arkViewImplement != null) {
            if (this.mInSyncRect) {
                boolean notInSizeRange = notInSizeRange(this.mRectArkContainer.width(), this.mRectArkContainer.height());
                Logger.logI(TAG, "SyncRect. reentry, model=" + this + ", nego-failed: " + notInSizeRange + ", origin-rect: " + this.mRectContainer + ", new-rect: " + this.mRectArkContainer);
                if (!notInSizeRange) {
                    this.mRectContainer = this.mRectArkContainer;
                    return;
                }
                return;
            }
            this.mInSyncRect = true;
            if (notInSizeRange(this.mRectArkContainer.width(), this.mRectArkContainer.height())) {
                Size limitToSizeRange = limitToSizeRange(this.mRectArkContainer.width(), this.mRectArkContainer.height());
                Logger.logI(TAG, "SyncRect. size negotiation failed, model=" + this + ", origin-rect: " + this.mRectContainer + ", new-rect: " + this.mRectArkContainer + ", adjusted: " + limitToSizeRange);
                this.mRectContainer.set(0, 0, limitToSizeRange.width, limitToSizeRange.height);
            } else {
                Logger.logI(TAG, "SyncRect. success, model=" + this + ", origin-rect: " + this.mRectContainer + ", new-rect: " + this.mRectArkContainer);
                this.mRectContainer = this.mRectArkContainer;
            }
            this.mContainer.SetSize(this.mRectContainer.width(), this.mRectContainer.height());
            this.mInSyncRect = false;
            createDrawTarget(arkViewImplement);
            ArkDispatchTask.getInstance().postToMainThread(new Runnable() { // from class: com.tencent.ark.ArkViewModelBase.15
                @Override // java.lang.Runnable
                public void run() {
                    arkViewImplement.onSyncRect(ArkViewModelBase.this.mRectContainer);
                }
            });
            return;
        }
        if (arkViewImplement == null) {
            Logger.logWithLimit("SyncRect.1.rect", TAG, "SyncRect.1.rect:" + this.mRectArkContainer + ",this = " + this + ",has return incorrect:");
            return;
        }
        Logger.logI(TAG, "SyncRect. sync locked, model=" + this + ", origin-rect: " + rect + ", new-rect: " + this.mRectArkContainer);
    }

    @Override // com.tencent.ark.ark.ContainerCallback
    public void Update(float f16, float f17, float f18, float f19) {
        if (this.mSyncRectLock) {
            return;
        }
        this.mRectInvalidF.union(f16, f17, f18, f19);
        this.mRectInvalidF.intersect(this.mRectContainerF);
    }

    public void activateView(final boolean z16, boolean z17) {
        if (this.mIsActivated == z16) {
            return;
        }
        this.mIsActivated = z16;
        Runnable runnable = new Runnable() { // from class: com.tencent.ark.ArkViewModelBase.11
            @Override // java.lang.Runnable
            public void run() {
                Logger.logI(ArkViewModelBase.TAG, "activateView, this=" + this + ",app=" + ArkViewModelBase.this.mAppInfo.name + ",container=:" + ArkViewModelBase.this.mContainer + ",state=" + z16);
                ArkViewModelBase arkViewModelBase = ArkViewModelBase.this;
                if (arkViewModelBase.mContainer == null) {
                    Logger.logE(ArkViewModelBase.TAG, "activateView error mContainer is null");
                } else if (!arkViewModelBase.mHasLoaded) {
                    Logger.logE(ArkViewModelBase.TAG, "activateView error mHasLoaded is false");
                    ArkViewModelBase.this.onRunAppFailed();
                } else {
                    arkViewModelBase.changeContainerActivateStatus();
                }
            }
        };
        if (z17 && !z16) {
            SafeAsyncRunDelay(runnable, 200L);
        } else {
            SafeAsyncRun(runnable);
        }
    }

    public boolean attachView(ArkViewImplement arkViewImplement) {
        this.mAttached = true;
        Logger.logD(TAG, "attachView.1.this:" + this);
        ArkViewImplement arkViewImplement2 = this.mViewImpl;
        if (arkViewImplement2 != null && arkViewImplement2 != arkViewImplement) {
            arkViewImplement2.doDetach(this);
            this.mViewImpl = null;
        }
        return initArkContainer(arkViewImplement);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void beginDraw() {
        if (this.mFirstDraw) {
            this.mTimeRecord.beginOfFirstDraw = System.currentTimeMillis();
        }
        int i3 = this.mDrawCount + 1;
        this.mDrawCount = i3;
        if (i3 % 2 == 0) {
            runPerfStat();
        }
    }

    protected void changeContainerActivateStatus() {
        boolean z16;
        boolean z17 = this.mInActivateStatus;
        if (this.mIsActivated && this.mIsForeground && this.mIsVisible) {
            z16 = true;
        } else {
            z16 = false;
        }
        this.mInActivateStatus = z16;
        Logger.logI(TAG, "changeContainerActivateStatus, container.this=" + this + ",app=" + this.mAppInfo.name + ",container=" + this.mContainer + ",mInActivateStatus=" + this.mInActivateStatus + ",oldActivateStatus=" + z17);
        ark.Container container = this.mContainer;
        if (container == null) {
            Logger.logE(TAG, "changeContainerActivateStatus error mContainer == null");
            return;
        }
        boolean z18 = this.mInActivateStatus;
        if (z18) {
            invalidateRect();
            if (this.mInActivateStatus != z17) {
                this.mContainer.ActivateRootView();
            }
            ArkVsync.getInstance().addFrameCallback(getQueueKey(), this);
            this.mPostRedraw.run();
            return;
        }
        if (z18 != z17) {
            container.DeactivateRootView();
        }
        ArkVsync.getInstance().removeFrameCallback(this);
    }

    public boolean checkShare() {
        ark.Container container = this.mContainer;
        if (container == null) {
            return false;
        }
        return container.CheckShare();
    }

    public void createDrawTarget(ArkViewImplement arkViewImplement) {
        this.mTimeRecord.beginOfCreateDrawTarget = System.currentTimeMillis();
        Bitmap recreateBitmapBuffer = arkViewImplement.recreateBitmapBuffer(this.mRectContainer);
        if (recreateBitmapBuffer != null) {
            if (this.mContainer != null) {
                ark.Application application = this.mApplication;
                if (application != null) {
                    application.IncreaseGraphicMemSize(recreateBitmapBuffer.getWidth() * recreateBitmapBuffer.getHeight() * 4 * 2);
                }
                this.mContainer.DetachBitmap(null);
                if (!this.mContainer.AttachBitmap(recreateBitmapBuffer)) {
                    Logger.logE(TAG, "createDrawTarget.1.rect: " + this.mRectContainer.toString() + ", this: " + this + ".attach.failed");
                }
                this.mRectInvalidF.set(this.mRectContainerF);
            }
        } else {
            Logger.logE(TAG, "createDrawTarget.2.rect: " + this.mRectContainer.toString() + ", this: " + this + ",bmp.null");
        }
        this.mTimeRecord.endOfCreateDrawTarget = System.currentTimeMillis();
    }

    public Rect descaleRect(Rect rect) {
        return descaleRect(rect, this.mAppInfo.scale);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void destroy() {
        reportPerfStat();
        final ArkViewImplement arkViewImplement = this.mViewImpl;
        if (arkViewImplement != null) {
            arkViewImplement.onDestroy();
        }
        ArkVsync.getInstance().removeFrameCallback(this);
        detachView();
        SafeAsyncRun(new Runnable() { // from class: com.tencent.ark.ArkViewModelBase.10
            @Override // java.lang.Runnable
            public void run() {
                StringBuilder sb5 = new StringBuilder();
                if (ArkViewModelBase.this.mContainer != null) {
                    sb5.append("ArkViewModelBase.destroy.delete.container.this: ");
                    sb5.append(this);
                    sb5.append(",container:");
                    sb5.append(ArkViewModelBase.this.mContainer);
                    ArkViewModelBase.this.mContainer.DeletePtr();
                    ArkViewModelBase.this.mContainer = null;
                }
                if (arkViewImplement != null) {
                    sb5.append("; destroyBitmapBuffer");
                    if (arkViewImplement.getBitmapBuffer() != null && ArkViewModelBase.this.mApplication != null) {
                        ArkViewModelBase.this.mApplication.IncreaseGraphicMemSize((-r1.getWidth()) * r1.getHeight() * 4 * 2);
                    }
                    arkViewImplement.destroyBitmapBuffer();
                }
                if (ArkViewModelBase.this.mApplication != null) {
                    sb5.append("; release.application = ");
                    sb5.append(ArkViewModelBase.this.mApplication);
                    sb5.append(", this = ");
                    sb5.append(this);
                    ArkViewModelBase arkViewModelBase = ArkViewModelBase.this;
                    arkViewModelBase.applicationRelease(arkViewModelBase.mApplication);
                    ArkViewModelBase.this.mApplication.Release();
                    ArkViewModelBase.this.mApplication = null;
                }
                Logger.logD(ArkViewModelBase.TAG, sb5.toString());
            }
        });
        String str = this.mAppInfo.name;
        Logger.logD(TAG, "destroy this: " + this + ", and.delay to release preloadApp:" + str);
        if (ArkAppPreloader.isAppPreloaded(str)) {
            SafeAsyncRunDelay(new RePreloadApplicationRunnable(str), 5000L);
        }
        this.mInit = false;
        this.mAppInfo.canceled = true;
        this.mLoadFailed = false;
    }

    public void destroyDrawTarget() {
        Logger.logD(TAG, "ArkViewModelBase.destroyDrawTarget");
        ark.Container container = this.mContainer;
        if (container != null) {
            container.DetachBitmap(null);
        }
    }

    public void detachView() {
        this.mAttached = false;
        ArkViewImplement arkViewImplement = this.mViewImpl;
        if (arkViewImplement != null) {
            arkViewImplement.doDetach(this);
            this.mViewImpl = null;
        }
        activateView(false, false);
        Logger.logD(TAG, "detachView.1.container.this:" + this + ",app:" + this.mAppInfo.name + ";detachView.mViewImpl" + this.mViewImpl);
        SafeAsyncRun(new Runnable() { // from class: com.tencent.ark.ArkViewModelBase.4
            @Override // java.lang.Runnable
            public void run() {
                ArkVsync.getInstance().removeFrameCallback(ArkViewModelBase.this);
                ark.Container container = ArkViewModelBase.this.mContainer;
                if (container != null) {
                    container.SetContainerCallback(null);
                    Logger.logD(ArkViewModelBase.TAG, "detachViewArkThread.this: " + ArkViewModelBase.this);
                }
                ArkViewModelBase.this.destroyDrawTarget();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void didFirstPaint() {
        final ArkViewImplement arkViewImplement = this.mViewImpl;
        if (arkViewImplement != null && this.mNeedFirstPaint) {
            ArkDispatchTask.getInstance().postToMainThread(new Runnable() { // from class: com.tencent.ark.ArkViewModelBase.19
                @Override // java.lang.Runnable
                public void run() {
                    ArkViewImplement arkViewImplement2 = arkViewImplement;
                    if (arkViewImplement2 != null) {
                        arkViewImplement2.onFirstPaint();
                    }
                }
            });
            this.mNeedFirstPaint = false;
        }
    }

    public void doFrame() {
        ArkViewImplement arkViewImplement = this.mViewImpl;
        if (arkViewImplement == null || this.mRectInvalidF.isEmpty() || this.mSyncRectLock || !this.mAttached || arkViewImplement.getBitmapBuffer() == null) {
            return;
        }
        beginDraw();
        ark.Container container = this.mContainer;
        RectF rectF = this.mRectInvalidF;
        if (container.Paint(rectF.left, rectF.top, rectF.right, rectF.bottom)) {
            arkViewImplement.mOpaque = this.mContainer.GetViewOpaque();
            arkViewImplement.onInvalidate(convertRect(this.mRectInvalidF));
            this.mRectInvalidF.setEmpty();
            endDraw();
            didFirstPaint();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void doLoadArkApp(String str, final String str2, final String str3, final String str4, boolean z16, boolean z17, int i3, String str5) {
        final AppInfo appInfo = this.mAppInfo;
        appInfo.path = str;
        this.mLoadFailed = false;
        this.mHasLoaded = false;
        Logger.logD(TAG, "doLoadArkApp.enter.this: " + this);
        if (!z16 && !appInfo.canceled && !TextUtils.isEmpty(this.mQueueKey)) {
            if (ENV.mIsDebug) {
                Logger.logD(TAG, "doLoadArkApp.beginOfDisplyView.this: " + this + ",queueKey=" + this.mQueueKey);
            }
            this.mTimeRecord.beginOfDisplyView = System.currentTimeMillis();
            final String viewId = getViewId();
            SafeAsyncRun(new Runnable() { // from class: com.tencent.ark.ArkViewModelBase.3
                /* JADX WARN: Removed duplicated region for block: B:15:0x0213  */
                /* JADX WARN: Removed duplicated region for block: B:21:0x022b  */
                @Override // java.lang.Runnable
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public void run() {
                    boolean z18;
                    boolean z19;
                    if (!ArkViewModelBase.sAppInit) {
                        ArkViewModelBase.this.initLibrary();
                        ArkViewModelBase.sAppInit = true;
                    }
                    ArkViewModelBase arkViewModelBase = ArkViewModelBase.this;
                    arkViewModelBase.mHasLoaded = true;
                    arkViewModelBase.mSyncRectLock = true;
                    ArkViewModelBase.this.mTimeRecord.beginOfCreateView = System.currentTimeMillis();
                    ArkAppPreloader.preloadCommon(appInfo.scale, str3, str2);
                    ark.Application application = ArkViewModelBase.this.mApplication;
                    if (application != null) {
                        Logger.logD(ArkViewModelBase.TAG, "profiling.doLoadArkApp.find.preApplication.this: " + ArkViewModelBase.this + ",application: " + ArkViewModelBase.this.mApplication);
                    }
                    ArkEnvironmentManager arkEnvironmentManager = ArkViewModelBase.ENV;
                    if (arkEnvironmentManager.mIsDebug) {
                        Logger.logD(ArkViewModelBase.TAG, "doLoadArkApp.beginOfCreateApplication.this: " + ArkViewModelBase.this + ",queueKey=%s" + ArkViewModelBase.this.mQueueKey);
                    }
                    ArkViewModelBase.this.mTimeRecord.beginOfCreateApplication = System.currentTimeMillis();
                    ArkViewModelBase arkViewModelBase2 = ArkViewModelBase.this;
                    AppInfo appInfo2 = appInfo;
                    arkViewModelBase2.mApplication = ark.Application.Create(appInfo2.name, StringUtil.getNotNullString(appInfo2.bizSrc), appInfo.path);
                    if (ArkViewModelBase.this.mApplication == null) {
                        Logger.logI(ArkViewModelBase.TAG, "loadArkApp.mApplication.create.fail!!");
                        ArkViewModelBase.this.onLoadReport(104);
                    } else {
                        if (application != null) {
                            Logger.logD(ArkViewModelBase.TAG, "profiling.doLoadArkApp.release.preApplication.this:" + ArkViewModelBase.this + ",application:" + application);
                            ArkViewModelBase.this.applicationRelease(application);
                            application.Release();
                        }
                        ArkStateCenter.getInstance().addArkViewModel(ArkViewModelBase.this);
                        ArkViewModelBase arkViewModelBase3 = ArkViewModelBase.this;
                        arkViewModelBase3.applicationCreate(arkViewModelBase3.mApplication);
                        ArkViewModelBase.this.mTimeRecord.beginOfRunApplication = System.currentTimeMillis();
                        if (!ArkViewModelBase.this.mApplication.Load(str3, str4, str2)) {
                            if (ArkViewModelBase.this.mApplication.GetScriptType() == 2 && !ark.Application.JSCLoaded()) {
                                ArkViewModelBase arkViewModelBase4 = ArkViewModelBase.this;
                                arkViewModelBase4.mInit = false;
                                arkViewModelBase4.mLoadFailed = true;
                                arkViewModelBase4.onLoadReport(107);
                            } else {
                                ArkViewModelBase.this.onLoadReport(106);
                            }
                        } else {
                            ArkViewModelBase arkViewModelBase5 = ArkViewModelBase.this;
                            if (!arkViewModelBase5.mApplication.Run(arkViewModelBase5.mAppCallback, arkViewModelBase5.mAppInfo.appConfig)) {
                                ArkViewModelBase.this.onLoadReport(102);
                            } else {
                                if (ArkViewModelBase.this.mContainer != null) {
                                    Logger.logI(ArkViewModelBase.TAG, "loadArkApp.mContainer.not.null");
                                    ArkViewModelBase.this.mContainer.DeletePtr();
                                }
                                ArkViewModelBase.this.mTimeRecord.beginOfCreateContainer = System.currentTimeMillis();
                                ArkViewModelBase.this.beforeContainerCreate();
                                ArkViewModelBase.this.mContainer = new ark.Container();
                                ArkViewModelBase arkViewModelBase6 = ArkViewModelBase.this;
                                arkViewModelBase6.mContainer.SetIndependentView(arkViewModelBase6.mIsIndependentView);
                                ArkViewModelBase.this.mContainer.SetDisableGPURendering(!r0.mIsGpuRendering);
                                ArkViewModelBase arkViewModelBase7 = ArkViewModelBase.this;
                                ark.Container container = arkViewModelBase7.mContainer;
                                if (arkViewModelBase7.mIsGpuRendering && !EGLContextHolder.sIsGPURasterDisabled) {
                                    z18 = false;
                                } else {
                                    z18 = true;
                                }
                                container.SetDisableGPURasterization(z18);
                                ArkViewModelBase.this.mContainer.SetShowFps(arkEnvironmentManager.mShowFps);
                                ArkViewModelBase arkViewModelBase8 = ArkViewModelBase.this;
                                arkViewModelBase8.mContainer.SetContainerCallback(arkViewModelBase8);
                                if (EGLContextHolder.isSpecialDeviceLimited()) {
                                    synchronized (ArkViewModelBase.lock) {
                                        Logger.logE(ArkViewModelBase.TAG, "SpecialDeviceLimited synchronized loadArkApp.CreateRootView");
                                        ArkViewModelBase arkViewModelBase9 = ArkViewModelBase.this;
                                        if (!arkViewModelBase9.mContainer.CreateRootView(arkViewModelBase9.mApplication, appInfo.view)) {
                                            Logger.logI(ArkViewModelBase.TAG, "loadArkApp.CreateRootView.fail!!");
                                            ArkViewModelBase.this.onLoadReport(105);
                                        } else {
                                            z19 = true;
                                        }
                                    }
                                } else {
                                    ArkViewModelBase arkViewModelBase10 = ArkViewModelBase.this;
                                    if (!arkViewModelBase10.mContainer.CreateRootView(arkViewModelBase10.mApplication, appInfo.view)) {
                                        Logger.logI(ArkViewModelBase.TAG, "loadArkApp.CreateRootView.fail!!");
                                        ArkViewModelBase.this.onLoadReport(105);
                                    }
                                    z19 = true;
                                }
                                if (z19) {
                                    ArkViewModelBase arkViewModelBase11 = ArkViewModelBase.this;
                                    arkViewModelBase11.mHasLoaded = false;
                                    arkViewModelBase11.mSyncRectLock = false;
                                    if (ArkViewModelBase.this.GetAppScriptType() == 2) {
                                        ArkViewModelBase.this.mLoadFailed = true;
                                    }
                                    ArkViewModelBase.this.onRunAppFailed();
                                    return;
                                }
                                ArkViewModelBase.this.mTimeRecord.beginOfInitContainer = System.currentTimeMillis();
                                if (!TextUtils.isEmpty(viewId)) {
                                    ArkViewModelBase.this.mContainer.SetID(viewId);
                                }
                                AppInfo appInfo3 = appInfo;
                                int i16 = appInfo3.width;
                                int i17 = appInfo3.height;
                                if (i16 <= 0) {
                                    i16 = ArkViewModelBase.this.mRectArkContainer.width();
                                }
                                if (i17 <= 0) {
                                    i17 = ArkViewModelBase.this.mRectArkContainer.height();
                                }
                                Size limitToSizeRange = ArkViewModelBase.this.limitToSizeRange(i16, i17);
                                Logger.logI(ArkViewModelBase.TAG, "loadArkApp.SetSize.this=" + this + ", info-size=" + appInfo.width + "," + appInfo.height + ", container-size=" + ArkViewModelBase.this.mRectArkContainer + ", target-size=" + i16 + "," + i17 + ", final-size=" + limitToSizeRange);
                                ArkViewModelBase.this.mContainer.SetSize(limitToSizeRange.width, limitToSizeRange.height);
                                StringBuilder sb5 = new StringBuilder();
                                sb5.append("loadArkApp.SetMetadata.container.this=");
                                sb5.append(this);
                                sb5.append(", meta=");
                                sb5.append(appInfo.meta);
                                Logger.logI(ArkViewModelBase.TAG, sb5.toString());
                                ArkViewModelBase.this.mContainer.SetMetadata(appInfo.meta, ark.ARKMETADATA_JSON);
                                ArkViewModelBase.this.mTimeRecord.endOfCreateView = System.currentTimeMillis();
                                ArkViewModelBase.this.mSyncRectLock = false;
                                ArkViewModelBase arkViewModelBase12 = ArkViewModelBase.this;
                                if (arkViewModelBase12.notInSizeRange(arkViewModelBase12.mRectArkContainer.width(), ArkViewModelBase.this.mRectArkContainer.height())) {
                                    ArkViewModelBase arkViewModelBase13 = ArkViewModelBase.this;
                                    Size limitToSizeRange2 = arkViewModelBase13.limitToSizeRange(arkViewModelBase13.mRectArkContainer.width(), ArkViewModelBase.this.mRectArkContainer.height());
                                    Logger.logI(ArkViewModelBase.TAG, "loadArkApp.InitDone.this=" + this + ", size negotiation failed, ark-size=" + ArkViewModelBase.this.mRectArkContainer + ", limit-size=" + limitToSizeRange2);
                                    ArkViewModelBase.this.mRectContainer.set(0, 0, limitToSizeRange2.width, limitToSizeRange2.height);
                                } else {
                                    Logger.logI(ArkViewModelBase.TAG, "loadArkApp.InitDone.this=" + this + ", size is valid, ark-size=" + ArkViewModelBase.this.mRectArkContainer);
                                    ArkViewModelBase arkViewModelBase14 = ArkViewModelBase.this;
                                    arkViewModelBase14.mRectContainer = arkViewModelBase14.mRectArkContainer;
                                }
                                ArkViewModelBase arkViewModelBase15 = ArkViewModelBase.this;
                                ArkViewImplement arkViewImplement = arkViewModelBase15.mViewImpl;
                                if (arkViewModelBase15.mAttached && arkViewImplement != null) {
                                    ArkViewModelBase.this.mNeedFirstPaint = true;
                                    ArkVsync arkVsync = ArkVsync.getInstance();
                                    ArkViewModelBase arkViewModelBase16 = ArkViewModelBase.this;
                                    arkVsync.addFrameCallback(arkViewModelBase16.mQueueKey, arkViewModelBase16);
                                    ArkViewModelBase.this.mContainer.SetBorderType(arkViewImplement.mBorderType);
                                    ArkViewModelBase.this.mContainer.SetBorderRadiusTop(arkViewImplement.mClipRadiusTop);
                                    ArkViewModelBase.this.mContainer.SetBorderRadius(arkViewImplement.mClipRadius);
                                    ArkViewModelBase.this.mContainer.SetBorderHornLeft(arkViewImplement.mAlignLeft);
                                    ArkViewModelBase arkViewModelBase17 = ArkViewModelBase.this;
                                    RectF rectF = arkViewModelBase17.mRectContainerF;
                                    arkViewModelBase17.SyncRect(rectF.left, rectF.top, rectF.right, rectF.bottom);
                                    ArkViewModelBase.this.mTimeRecord.endOfDisplyView = System.currentTimeMillis();
                                    if (arkEnvironmentManager.mIsDebug) {
                                        Logger.logD(ArkViewModelBase.TAG, "doLoadArkApp.endOfDisplyView.this: " + ArkViewModelBase.this);
                                    }
                                    HashMap<String, Size> hashMap = ArkViewModelBase.sAppSizeHint;
                                    synchronized (hashMap) {
                                        ArkViewModelBase.this.handleCacheSize(appInfo);
                                        hashMap.put(appInfo.name + "_" + appInfo.view, new Size(ArkViewModelBase.this.mRectContainer.width(), ArkViewModelBase.this.mRectContainer.height()));
                                    }
                                    ArkViewModelBase arkViewModelBase18 = ArkViewModelBase.this;
                                    arkViewModelBase18.onAppDisplay(arkViewModelBase18.mTimeRecord);
                                    ArkViewModelBase.this.onLoadReport(100);
                                    return;
                                }
                                Logger.logI(ArkViewModelBase.TAG, "loadArkApp.mViewImpl.null");
                                ArkViewModelBase.this.onLoadReport(103);
                                return;
                            }
                        }
                    }
                    z19 = false;
                    if (z19) {
                    }
                }
            });
            Logger.logI(TAG, "doLoadArkApp.leave.this: " + this);
            return;
        }
        this.mLoadFailed = true;
        this.mInit = false;
        ErrorInfo errorInfo = this.mErrorInfo;
        errorInfo.f72565msg = str5;
        errorInfo.retCode = i3;
        errorInfo.canRetry = z17;
        if (ArkDispatchTask.getInstance().isMainThread()) {
            ArkViewImplement arkViewImplement = this.mViewImpl;
            if (arkViewImplement != null) {
                ErrorInfo errorInfo2 = this.mErrorInfo;
                arkViewImplement.onLoadFailed(errorInfo2.f72565msg, errorInfo2.retCode, errorInfo2.canRetry);
            }
        } else {
            ArkDispatchTask.getInstance().postToMainThread(new Runnable() { // from class: com.tencent.ark.ArkViewModelBase.2
                @Override // java.lang.Runnable
                public void run() {
                    ArkViewModelBase arkViewModelBase = ArkViewModelBase.this;
                    ArkViewImplement arkViewImplement2 = arkViewModelBase.mViewImpl;
                    if (arkViewImplement2 != null) {
                        ErrorInfo errorInfo3 = arkViewModelBase.mErrorInfo;
                        arkViewImplement2.onLoadFailed(errorInfo3.f72565msg, errorInfo3.retCode, errorInfo3.canRetry);
                    }
                }
            });
        }
        Logger.logI(TAG, "doLoadArkApp.Failed.mLoadFailed: " + this.mLoadFailed + ", info.canceled: " + appInfo.canceled);
        onLoadReport(101);
    }

    public void doOnEvent(int i3) {
        if (i3 == 0) {
            if (this.mHasLoaded) {
                SafeAsyncRun(new Runnable() { // from class: com.tencent.ark.ArkViewModelBase.7
                    @Override // java.lang.Runnable
                    public void run() {
                        ArkViewModelBase.this.mIsVisible = false;
                        ArkViewModelBase.this.changeContainerActivateStatus();
                    }
                });
            }
        } else if (i3 == 1) {
            if (this.mHasLoaded) {
                SafeAsyncRun(new Runnable() { // from class: com.tencent.ark.ArkViewModelBase.8
                    @Override // java.lang.Runnable
                    public void run() {
                        ArkViewModelBase.this.mIsVisible = true;
                        ArkViewModelBase.this.changeContainerActivateStatus();
                    }
                });
            }
        } else if (i3 == 2) {
            destroy();
        } else if (i3 == 3 && GetAppScriptType() == 2) {
            this.mErrorInfo.retCode = -1;
            reinitArkContainer();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void endDraw() {
        if (this.mFirstDraw) {
            this.mTimeRecord.endOfFirstDraw = System.currentTimeMillis();
            this.mFirstDraw = false;
            onFirstDrawEnd();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void fillReportParams(Map<String, String> map) {
        try {
            JSONObject jSONObject = new JSONObject(this.mAppInfo.meta);
            if (!jSONObject.keys().hasNext()) {
                return;
            }
            JSONObject jSONObject2 = jSONObject.getJSONObject((String) jSONObject.keys().next());
            String optString = jSONObject2.optString("ark_reserved1");
            String optString2 = jSONObject2.optString("ark_reserved2");
            String optString3 = jSONObject2.optString("ark_reserved3");
            putParams(map, "ark_reserved1", optString);
            putParams(map, "ark_reserved2", optString2);
            putParams(map, "ark_reserved3", optString3);
        } catch (Exception e16) {
            Logger.logE(TAG, "fillReportParams error " + e16);
        }
    }

    public String getAppName() {
        return this.mAppInfo.name;
    }

    public String getBizSrc() {
        return this.mAppInfo.bizSrc;
    }

    public ark.Container getContainer() {
        return this.mContainer;
    }

    public Size getContainerHintSize() {
        Size size;
        if (!this.mRectContainer.isEmpty()) {
            this.mAppInfo.cacheSize = new Size(this.mRectContainer.width(), this.mRectContainer.height());
            return this.mAppInfo.cacheSize;
        }
        String mD5Hash = getMD5Hash(this.mAppInfo.name + this.mAppInfo.view + this.mAppInfo.meta);
        if (!TextUtils.isEmpty(mD5Hash)) {
            size = mCacheSizeHint.get(mD5Hash);
        } else {
            size = null;
        }
        if (size != null) {
            Logger.logI(TAG, "mCacheSizeHint cache found, key=" + mD5Hash + ", app=" + this.mAppInfo.name + ", view=" + this.mAppInfo.view + ", size=" + size);
            this.mAppInfo.cacheSize = size;
            return size;
        }
        HashMap<String, Size> hashMap = sAppSizeHint;
        synchronized (hashMap) {
            String str = this.mAppInfo.name + "_" + this.mAppInfo.view;
            Size size2 = hashMap.get(str);
            if (size2 != null) {
                Logger.logD(TAG, "size cache found, key=" + str + ", app=" + this.mAppInfo.name + ", view=" + this.mAppInfo.view + ", size=" + size2);
                this.mAppInfo.cacheSize = size2;
                return size2;
            }
            AppInfo appInfo = this.mAppInfo;
            int i3 = appInfo.width;
            if (i3 <= 0) {
                i3 = appInfo.hintWidth;
            }
            int i16 = appInfo.height;
            if (i16 <= 0) {
                i16 = appInfo.hintHeight;
            }
            appInfo.cacheSize = new Size(i3, i16);
            return this.mAppInfo.cacheSize;
        }
    }

    public Rect getContainerRect() {
        return this.mRectContainer;
    }

    public ErrorInfo getErrorInfo() {
        return this.mErrorInfo;
    }

    public String getQueueKey() {
        return this.mQueueKey;
    }

    public float getScale() {
        return this.mAppInfo.scale;
    }

    public boolean getShowRoundCorner() {
        return this.mRoundCorner;
    }

    public long getViewHandle() {
        ark.Container container = this.mContainer;
        if (container != null) {
            return container.GetViewHandle();
        }
        return 0L;
    }

    public String getViewId() {
        return null;
    }

    public ArkViewImplement getViewImpl() {
        return this.mViewImpl;
    }

    public String getViewShare() {
        ark.Container container = this.mContainer;
        if (container == null) {
            return null;
        }
        return container.GetViewShare();
    }

    public boolean init(String str, String str2, String str3, String str4, String str5, String str6, float f16) {
        if (str != null && str2 != null) {
            this.mQueueKey = str;
            if (!this.mLoadFailed && !TextUtils.isEmpty(str)) {
                if (!str.equals(this.mAppInfo.name) || !str2.equals(this.mAppInfo.view) || Math.abs(f16 - this.mAppInfo.scale) >= 1.0E-5d) {
                    this.mInit = false;
                }
                if (this.mInit) {
                    Logger.logD(TAG, "init mInit is true!!! viewModel: " + this);
                    return true;
                }
                Logger.logI(TAG, "init app = " + str + ", appView = " + str2 + ", scale = " + f16 + ", appMinVersion = " + str3 + ", viewModel = " + this);
                AppInfo appInfo = this.mAppInfo;
                appInfo.scale = f16;
                appInfo.name = str;
                appInfo.view = str2;
                appInfo.meta = str4;
                appInfo.appConfig = str5;
                appInfo.appMinVersion = str3;
                appInfo.bizSrc = str6;
                appInfo.canceled = false;
                TimeRecord timeRecord = this.mTimeRecord;
                timeRecord.appName = str;
                timeRecord.view = str2;
                timeRecord.bizSrc = str6;
                return true;
            }
            ArkViewImplement arkViewImplement = this.mViewImpl;
            if (arkViewImplement != null) {
                ErrorInfo errorInfo = this.mErrorInfo;
                arkViewImplement.onLoadFailed(errorInfo.f72565msg, errorInfo.retCode, errorInfo.canRetry);
            }
            Logger.logI(TAG, "init mLoadFailed true!!! viewModel:" + this);
            return true;
        }
        Logger.logD(TAG, "init got null app name and viewImpl name.");
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean initArkContainer(ArkViewImplement arkViewImplement) {
        Logger.logD(TAG, "initArkContainer.0.viewModel: " + this + " , container:" + this.mContainer);
        this.mViewImpl = arkViewImplement;
        if (this.mLoadFailed) {
            if (arkViewImplement != null) {
                ErrorInfo errorInfo = this.mErrorInfo;
                arkViewImplement.onLoadFailed(errorInfo.f72565msg, errorInfo.retCode, errorInfo.canRetry);
            }
            Logger.logI(TAG, "initArkContainer.mLoadFailed.true!.viewModel:" + this);
            return true;
        }
        arkViewImplement.mViewInterface.createViewContext();
        if (this.mInit) {
            SafeAsyncRun(new Runnable() { // from class: com.tencent.ark.ArkViewModelBase.1
                @Override // java.lang.Runnable
                public void run() {
                    ArkViewModelBase arkViewModelBase = ArkViewModelBase.this;
                    if (arkViewModelBase.mContainer != null && arkViewModelBase.mAttached) {
                        ArkViewModelBase arkViewModelBase2 = ArkViewModelBase.this;
                        arkViewModelBase2.mContainer.SetContainerCallback(arkViewModelBase2);
                        Logger.logD(ArkViewModelBase.TAG, "initArkContainer.1.viewModel: " + ArkViewModelBase.this);
                        ArkViewModelBase arkViewModelBase3 = ArkViewModelBase.this;
                        ArkViewImplement arkViewImplement2 = arkViewModelBase3.mViewImpl;
                        if (!arkViewModelBase3.mRectContainerF.isEmpty() && arkViewImplement2 != null) {
                            ArkViewModelBase.this.mContainer.SetBorderType(arkViewImplement2.mBorderType);
                            ArkViewModelBase.this.mContainer.SetBorderRadiusTop(arkViewImplement2.mClipRadiusTop);
                            ArkViewModelBase.this.mContainer.SetBorderRadius(arkViewImplement2.mClipRadius);
                            ArkViewModelBase arkViewModelBase4 = ArkViewModelBase.this;
                            RectF rectF = arkViewModelBase4.mRectContainerF;
                            arkViewModelBase4.SyncRect(rectF.left, rectF.top, rectF.right, rectF.bottom);
                            return;
                        }
                        Logger.logE(ArkViewModelBase.TAG, "initArkContainer.2.viewModel: " + this);
                        return;
                    }
                    Logger.logE(ArkViewModelBase.TAG, "initArkContainer.0.viewModel: " + ArkViewModelBase.this);
                }
            });
            activateView(true, false);
            Logger.logI(TAG, "init.finished.and.mInit.true!.viewModel: " + this);
            return true;
        }
        this.mInit = true;
        return onLoadApp(this.mAppInfo);
    }

    public void invalidateRect() {
        this.mRectInvalidF.set(this.mRectContainerF);
    }

    public boolean isMemoryOptimized() {
        return this.mIsMemoryOptimized;
    }

    protected Size limitToSizeRange(int i3, int i16) {
        AppInfo appInfo = this.mAppInfo;
        int i17 = appInfo.minWidth;
        if (i17 > 0 && i3 < i17) {
            i3 = i17;
        }
        int i18 = appInfo.minHeight;
        if (i18 > 0 && i16 < i18) {
            i16 = i18;
        }
        int i19 = appInfo.maxWidth;
        if (i19 > 0 && i3 > i19) {
            i3 = i19;
        }
        int i26 = appInfo.maxHeight;
        if (i26 > 0 && i16 > i26) {
            i16 = i26;
        }
        return new Size(i3, i16);
    }

    protected boolean notInSizeRange(int i3, int i16) {
        int i17;
        int i18;
        AppInfo appInfo = this.mAppInfo;
        int i19 = appInfo.minWidth;
        if ((i19 > 0 && i3 < i19) || ((i17 = appInfo.minHeight) > 0 && i16 < i17)) {
            return true;
        }
        int i26 = appInfo.maxWidth;
        if ((i26 > 0 && i3 > i26) || ((i18 = appInfo.maxHeight) > 0 && i16 > i18)) {
            return true;
        }
        return false;
    }

    protected void onClickReport() {
        Map<String, String> commonParams = getCommonParams();
        fillReportParams(commonParams);
        ArkEnvironmentManager.getInstance().dtReport(Constants.Event.EVENT_ID_ARK_APP_CLICK, commonParams);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onFirstDrawEnd() {
        String str;
        if (ENV.mShowProfilingLog) {
            AppInfo appInfo = this.mAppInfo;
            if (appInfo != null) {
                str = appInfo.name;
            } else {
                str = "";
            }
            StringBuilder sb5 = new StringBuilder();
            sb5.append("profiling.");
            sb5.append(hashCode());
            sb5.append(".app.");
            sb5.append(str);
            sb5.append("\n.DisplayView.");
            TimeRecord timeRecord = this.mTimeRecord;
            sb5.append(timeRecord.endOfDisplyView - timeRecord.beginOfDisplyView);
            sb5.append(" (");
            sb5.append(this.mTimeRecord.beginOfDisplyView);
            sb5.append("-");
            sb5.append(this.mTimeRecord.endOfDisplyView);
            sb5.append(")\n.CreateApplication.");
            TimeRecord timeRecord2 = this.mTimeRecord;
            sb5.append(timeRecord2.beginOfRunApplication - timeRecord2.beginOfCreateApplication);
            sb5.append(" (");
            sb5.append(this.mTimeRecord.beginOfCreateApplication);
            sb5.append("-");
            sb5.append(this.mTimeRecord.beginOfRunApplication);
            sb5.append(")\n.CreateContainer.");
            TimeRecord timeRecord3 = this.mTimeRecord;
            sb5.append(timeRecord3.beginOfInitContainer - timeRecord3.beginOfCreateContainer);
            sb5.append(" (");
            sb5.append(this.mTimeRecord.beginOfCreateContainer);
            sb5.append("-");
            sb5.append(this.mTimeRecord.beginOfInitContainer);
            sb5.append(")\n.CreateView.");
            TimeRecord timeRecord4 = this.mTimeRecord;
            sb5.append(timeRecord4.endOfCreateView - timeRecord4.beginOfCreateView);
            sb5.append(" (");
            sb5.append(this.mTimeRecord.beginOfCreateView);
            sb5.append("-");
            sb5.append(this.mTimeRecord.endOfCreateView);
            sb5.append(")\n.CreateContext.");
            TimeRecord timeRecord5 = this.mTimeRecord;
            sb5.append(timeRecord5.endOfCreateContext - timeRecord5.beginOfCreateContext);
            sb5.append(" (");
            sb5.append(this.mTimeRecord.beginOfCreateContext);
            sb5.append("-");
            sb5.append(this.mTimeRecord.endOfCreateContext);
            sb5.append(")\n.CreateDrawTarget.");
            TimeRecord timeRecord6 = this.mTimeRecord;
            sb5.append(timeRecord6.endOfCreateDrawTarget - timeRecord6.beginOfCreateDrawTarget);
            sb5.append(" (");
            sb5.append(this.mTimeRecord.beginOfCreateDrawTarget);
            sb5.append("-");
            sb5.append(this.mTimeRecord.endOfCreateDrawTarget);
            sb5.append(")\n.FirstDraw.");
            TimeRecord timeRecord7 = this.mTimeRecord;
            sb5.append(timeRecord7.endOfFirstDraw - timeRecord7.beginOfFirstDraw);
            sb5.append(" (");
            sb5.append(this.mTimeRecord.beginOfFirstDraw);
            sb5.append("-");
            sb5.append(this.mTimeRecord.endOfFirstDraw);
            sb5.append(")\n.total.");
            TimeRecord timeRecord8 = this.mTimeRecord;
            sb5.append(timeRecord8.endOfFirstDraw - timeRecord8.beginOfDisplyView);
            Logger.logI(TAG, sb5.toString());
        }
    }

    protected boolean onLoadApp(AppInfo appInfo) {
        return true;
    }

    final void onLoadReport(int i3) {
        Logger.logI(TAG, "doLoadArkApp.onLoadReport.loadState: " + i3);
        AppInfo appInfo = this.mAppInfo;
        if (appInfo != null && i3 == 100) {
            ArkAppReport.reportDisplayView(appInfo.name, appInfo.view, appInfo.bizSrc, false, i3, 0, 0);
            Map<String, String> commonParams = getCommonParams();
            fillReportParams(commonParams);
            ArkEnvironmentManager.getInstance().dtReport(Constants.Event.EVENT_ID_ARK_APP_DISPLAY, commonParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onRunAppFailed() {
        if (this.mViewImpl == null) {
            return;
        }
        ArkDispatchTask.getInstance().postToMainThread(new Runnable() { // from class: com.tencent.ark.ArkViewModelBase.14
            @Override // java.lang.Runnable
            public void run() {
                ArkViewModelBase arkViewModelBase = ArkViewModelBase.this;
                ArkViewImplement arkViewImplement = arkViewModelBase.mViewImpl;
                if (arkViewImplement != null) {
                    ErrorInfo errorInfo = arkViewModelBase.mErrorInfo;
                    arkViewImplement.onLoadFailed(errorInfo.f72565msg, errorInfo.retCode, errorInfo.canRetry);
                }
            }
        });
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        ark.Container container = this.mContainer;
        if (container == null) {
            return false;
        }
        SafeAsyncRun(new TouchRunnable(motionEvent, container, this, this.mAppInfo.scale));
        return true;
    }

    public boolean onViewEvent(final String str, final String str2) {
        if (this.mContainer == null) {
            Logger.logE(TAG, "onViewEvent mContainer is null");
            return false;
        }
        SafeAsyncRun(new Runnable() { // from class: com.tencent.ark.ArkViewModelBase.6
            @Override // java.lang.Runnable
            public void run() {
                ArkViewModelBase.this.mContainer.ViewEvent(str, str2);
            }
        });
        return true;
    }

    public void postInvalid() {
        SafeAsyncRun(this.mPostInvalid);
    }

    public void postRedraw() {
        SafeAsyncRun(this.mPostRedraw);
    }

    public void reinitArkContainer() {
        if (this.mLoadFailed) {
            this.mLoadFailed = false;
            if (this.mInit) {
                return;
            }
            initArkContainer(this.mViewImpl);
        }
    }

    protected void runPerfStat() {
        if (!this.mAttached || !this.mInActivateStatus || this.mPerfTaskRunning) {
            return;
        }
        this.mPerfTaskRunning = true;
        final WeakReference weakReference = new WeakReference(this);
        AppInfo appInfo = this.mAppInfo;
        final String str = appInfo.name;
        final String str2 = appInfo.view;
        final long currentTimeMillis = System.currentTimeMillis();
        SafeAsyncRun(new Runnable() { // from class: com.tencent.ark.ArkViewModelBase.20
            @Override // java.lang.Runnable
            public void run() {
                long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                ArkPerfMonitor.getInstance().addRecord(str, str2, currentTimeMillis2);
                ArkViewModelBase arkViewModelBase = (ArkViewModelBase) weakReference.get();
                if (arkViewModelBase != null) {
                    arkViewModelBase.mPerfTaskRunning = false;
                    if (currentTimeMillis2 > 30) {
                        arkViewModelBase.runPerfStat();
                    }
                }
            }
        });
    }

    public Rect scaleRect(Rect rect) {
        return scaleRect(rect, this.mAppInfo.scale);
    }

    public void setFixSize(int i3, int i16) {
        if (i3 > 0) {
            AppInfo appInfo = this.mAppInfo;
            appInfo.width = (int) (i3 / appInfo.scale);
        }
        if (i16 > 0) {
            AppInfo appInfo2 = this.mAppInfo;
            appInfo2.height = (int) (i16 / appInfo2.scale);
        }
    }

    public void setForeground(final boolean z16) {
        if (this.mIsForeground == z16) {
            return;
        }
        this.mIsForeground = z16;
        SafeAsyncRun(new Runnable() { // from class: com.tencent.ark.ArkViewModelBase.21
            @Override // java.lang.Runnable
            public void run() {
                ArkViewModelBase.this.changeContainerActivateStatus();
                ark.Application application = ArkViewModelBase.this.mApplication;
                if (application != null) {
                    application.SetForeground(z16);
                }
            }
        });
    }

    public void setHintSize(int i3, int i16) {
        if (i3 > 0) {
            AppInfo appInfo = this.mAppInfo;
            appInfo.hintWidth = (int) (i3 / appInfo.scale);
        }
        if (i16 > 0) {
            AppInfo appInfo2 = this.mAppInfo;
            appInfo2.hintHeight = (int) (i16 / appInfo2.scale);
        }
    }

    public void setIndependentView(boolean z16) {
        this.mIsIndependentView = z16;
    }

    public void setMaxSize(int i3, int i16) {
        if (i3 > 0) {
            AppInfo appInfo = this.mAppInfo;
            appInfo.maxWidth = (int) (i3 / appInfo.scale);
        }
        if (i16 > 0) {
            AppInfo appInfo2 = this.mAppInfo;
            appInfo2.maxHeight = (int) (i16 / appInfo2.scale);
        }
    }

    public void setMemoryOptimized(boolean z16) {
        this.mIsMemoryOptimized = z16;
    }

    public void setMinSize(int i3, int i16) {
        if (i3 > 0) {
            AppInfo appInfo = this.mAppInfo;
            appInfo.minWidth = (int) (i3 / appInfo.scale);
        }
        if (i16 > 0) {
            AppInfo appInfo2 = this.mAppInfo;
            appInfo2.minHeight = (int) (i16 / appInfo2.scale);
        }
    }

    public void setQQConnectParams(String str, String str2) {
        AppInfo appInfo = this.mAppInfo;
        appInfo.qqConnectAppId = str;
        appInfo.qqConnectAppType = str2;
    }

    public void setViewRect(final Rect rect) {
        if (rect == null) {
            Logger.logE(TAG, "setViewRect.1.rect return for null param");
            return;
        }
        Logger.logI(TAG, "setViewRect.1.rect: " + rect + ", this: " + this);
        SafeAsyncRun(new Runnable() { // from class: com.tencent.ark.ArkViewModelBase.5
            @Override // java.lang.Runnable
            public void run() {
                ArkViewModelBase arkViewModelBase = ArkViewModelBase.this;
                if (arkViewModelBase.mContainer != null && !rect.equals(arkViewModelBase.mRectContainer)) {
                    Size limitToSizeRange = ArkViewModelBase.this.limitToSizeRange(rect.width(), rect.height());
                    Logger.logD(ArkViewModelBase.TAG, "onConfigurationChanged.setViewRect.2.rect: " + rect + ", limit size(" + limitToSizeRange.width + "," + limitToSizeRange.height + ") this = " + ArkViewModelBase.this);
                    ArkViewModelBase.this.mContainer.SetSize(limitToSizeRange.width, limitToSizeRange.height);
                }
            }
        });
    }

    public void updateMetaData(final String str) {
        SafeAsyncRun(new Runnable() { // from class: com.tencent.ark.ArkViewModelBase.22
            @Override // java.lang.Runnable
            public void run() {
                if (ArkViewModelBase.this.mContainer != null && !TextUtils.isEmpty(str)) {
                    ArkViewModelBase.this.mContainer.SetMetadata(str, ark.ARKMETADATA_JSON);
                    Logger.logI(ArkViewModelBase.TAG, "arkAsyncShare updateMetaData = " + str);
                }
            }
        });
    }

    public static Rect descaleRect(Rect rect, float f16) {
        if (rect == null) {
            return null;
        }
        Rect rect2 = new Rect();
        rect2.left = (int) Math.ceil(rect.left / f16);
        rect2.top = (int) Math.ceil(rect.top / f16);
        rect2.right = (int) (rect.right / f16);
        rect2.bottom = (int) (rect.bottom / f16);
        return rect2;
    }

    public static Rect scaleRect(Rect rect, float f16) {
        if (rect == null) {
            return null;
        }
        Rect rect2 = new Rect();
        rect2.left = (int) (rect.left * f16);
        rect2.top = (int) (rect.top * f16);
        rect2.right = (int) Math.ceil(rect.right * f16);
        rect2.bottom = (int) Math.ceil(rect.bottom * f16);
        return rect2;
    }

    protected void beforeContainerCreate() {
    }

    protected void initLibrary() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void applicationCreate(ark.Application application) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void applicationRelease(ark.Application application) {
    }

    protected void onAppDisplay(TimeRecord timeRecord) {
    }
}
